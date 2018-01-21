import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by mimtiaze on 18-Jul-16.
 */
public class SeeRequestAdminController {
    @FXML
    public TableColumn<FacultyInfo,String> nameOfFaculty;
    public TableView<FacultyInfo> facultyNameTable;

    public TableView<CourseToLinkedListOthersInfo> detailsTable;
    public TableColumn<CourseToLinkedListOthersInfo,String> requestedSubject;
    public TableColumn<CourseToLinkedListOthersInfo,String> requestedSection;
    public TableColumn<CourseToLinkedListOthersInfo,String> requestedTime;
    public TableColumn<CourseToLinkedListOthersInfo,String> requestedRoom;
    public TableColumn<CourseToLinkedListOthersInfo,String> requestedDay;

    public FacultyInfo currentFaculty;
    public CourseToLinkedListOthersInfo currentCourse;

    public ArrayList<String> requestedFacultyName;

    public void initialize(){

        addItemToTable();
    }


    public void addItemToTable(){
        requestedFacultyName=new ArrayList<>();

        ObservableList<FacultyInfo> listOfRequestedFaculty = FXCollections.observableArrayList();
        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;

        //Debug perpose
        //AddRemoveSearchFaculty.facultyHeadPointer.isRequested=true;


        while(tempFaculty.next!=null){
            if(tempFaculty.isRequested){
                listOfRequestedFaculty.add(tempFaculty);
                requestedFacultyName.add(tempFaculty.facultyName);
            }
            tempFaculty=tempFaculty.next;
        }

        facultyNameTable.setItems(listOfRequestedFaculty);
        nameOfFaculty.setCellValueFactory(new PropertyValueFactory<>("facultyName"));

        //Showing row content to console
        facultyNameTable.setRowFactory( tv -> {
            TableRow<FacultyInfo> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    FacultyInfo rowData = row.getItem();
                    currentFaculty=rowData;
                    currentFaculty.isRequested=false;
                    addItemToDetailsTable();
                    System.out.println(rowData.facultyName);
                }
            });
            return row;
        });
    }


    public void addItemToDetailsTable(){

        ObservableList<CourseToLinkedListOthersInfo> list=FXCollections.observableArrayList();
        CourseToLinkedListOthersInfo tempList=currentFaculty.requestedSectionOfFaculty;
        while(tempList!=null){
            list.add(tempList);
            tempList=tempList.next;
        }

        detailsTable.setItems(list);
        requestedSubject.setCellValueFactory(new PropertyValueFactory<>("title"));
        requestedSection.setCellValueFactory(new PropertyValueFactory<>("section"));
        requestedDay.setCellValueFactory(new PropertyValueFactory<>("day"));
        requestedTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        requestedRoom.setCellValueFactory(new PropertyValueFactory<>("room"));

        detailsTable.setRowFactory( tv -> {
            TableRow<CourseToLinkedListOthersInfo> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    CourseToLinkedListOthersInfo rowData = row.getItem();
                    currentCourse=rowData;
                }
            });
            return row;
        });

    }

    public void actionForAcceptAllRequest(){
        for(String tempFacultyName : requestedFacultyName){
            FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);
            if(tempFaculty != null){
                currentFaculty = tempFaculty;

                currentCourse = tempFaculty.requestedSectionOfFaculty;
                while(currentCourse != null){
                    accept();
                    currentCourse = currentCourse.next;
                }
            }
        }
        addItemToTable();
    }

    public void actionForIgnoreAllRequest(){
        for(String tempFacultyName : requestedFacultyName){
            FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);
            if(tempFaculty != null){
                currentFaculty = tempFaculty;
                currentFaculty.isRequested=false;

                currentCourse = tempFaculty.requestedSectionOfFaculty;
                while(currentCourse != null){
                    ignore();
                    currentCourse = currentCourse.next;
                }
            }
        }
        addItemToTable();
        addItemToDetailsTable();
    }

    public void actionForAcceptThis(){
        accept();
        addItemToDetailsTable();
    }

    public void actionForIgnoreThis(){
        ignore();
        addItemToDetailsTable();
    }

    public void actionForAcceptAll(){
        currentCourse = currentFaculty.requestedSectionOfFaculty;
        while(currentCourse != null){
            accept();
            currentCourse = currentCourse.next;
        }
        addItemToDetailsTable();
    }
    public void actionForIgnoreAll(){
        currentCourse = currentFaculty.requestedSectionOfFaculty;
        while(currentCourse != null){
            ignore();
            currentCourse = currentCourse.next;
        }
        addItemToDetailsTable();
    }


    public void accept(){
        if(currentCourse!=null && currentFaculty!=null) {

            boolean alreadyAssigned=false;

            FacultyInfo tempFacultyForCheck=AddRemoveSearchFaculty.facultyHeadPointer;
            while(tempFacultyForCheck!=null){
                CourseToLinkedListOthersInfo tempListForCheck=tempFacultyForCheck.searchCourseAndSectionInTempList(currentCourse.title,currentCourse.section);
                if(tempListForCheck!=null) {
                    alreadyAssigned = true;
                    break;
                }
                tempFacultyForCheck=tempFacultyForCheck.next;
            }

            if (!alreadyAssigned) {
                if (currentCourse.section.equals("N/A")) {
                    CourseToLinkedList tempCourse = AddSearchCourse.searchCourseWithTitle(currentCourse.title);
                    currentFaculty.addCourseWithListInChosenCourseList(tempCourse);
                    currentFaculty.removeCourseWithTitleAndSectionInRequestedList(currentCourse.title, currentCourse.section);

                } else {
                    if (currentCourse.islabClass) {
                        if (currentFaculty.tempLab < currentFaculty.labLimit) {
                            currentFaculty.addCourseWithList(currentCourse);
                            currentFaculty.removeCourseWithTitleAndSectionInRequestedList(currentCourse.title, currentCourse.section);
                        } else {
                            currentFaculty.removeCourseWithTitleAndSectionInRequestedList(currentCourse.title, currentCourse.section);
                        }
                    }
                    if (!currentCourse.islabClass) {
                        if (currentFaculty.tempTheory < currentFaculty.theoryLimit) {
                            currentFaculty.addCourseWithList(currentCourse);
                            currentFaculty.removeCourseWithTitleAndSectionInRequestedList(currentCourse.title, currentCourse.section);
                        } else {
                            currentFaculty.removeCourseWithTitleAndSectionInRequestedList(currentCourse.title, currentCourse.section);
                        }
                    }

                }
            }
            else{
                currentFaculty.isRequested=true;

                try{
                    chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("assignedAlready.fxml"));
                    chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,300,150);

                    chooseCourseStage = new Stage();

                    chooseCourseStage.setScene(chooseCourseAdminScene);
                    chooseCourseStage.setResizable(false);
                    chooseCourseStage.setTitle("Warning");
                    chooseCourseStage.show();
                }catch(Exception e){
                    System.out.println("Error: "+e.getMessage());
                }

            }
        }
        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();
    }

    public void ignore(){
        if(currentCourse!=null && currentFaculty!=null){
            currentFaculty.removeCourseWithTitleAndSectionInRequestedList(currentCourse.title,currentCourse.section);
        }
        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();
    }







    @FXML
    public Stage chooseCourseStage;
    public Scene chooseCourseAdminScene;
    public Parent chooseCourseAdminRoot;

    public Label copyRightLabel;



    public void actionForChooseSectionMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("routineGridShowAdmin.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForChooseCourseMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("chooseCourse.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForSeeRequestMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("seeRequestAdmin.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForCreateNewFaculty(){
        try{
            Parent newRoot= FXMLLoader.load(getClass().getClassLoader().getResource("createFaculty.fxml"));
            Scene newScene=new Scene(newRoot,400,300);

            Stage newStage = new Stage();

            newStage.setScene(newScene);
            newStage.setTitle("Add new faculty");
            newStage.setResizable(false);
            newStage.centerOnScreen();
            newStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

    }

    public void actionForModifyFaculty(){
        try{
            Parent newRoot= FXMLLoader.load(getClass().getClassLoader().getResource("modifyFaculty.fxml"));
            Scene newScene=new Scene(newRoot,400,350);

            Stage newStage = new Stage();

            newStage.setScene(newScene);
            newStage.setTitle("Add new faculty");
            newStage.setResizable(false);
            newStage.centerOnScreen();
            newStage.show();

            newStage.setOnCloseRequest(e->{
                newStage.close();
            });


        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }



    }

    public void actionForCloseMenuItem(){
        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();

        chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();
        chooseCourseStage.close();
    }

    public void actionForDropListMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("dropSectionAdmin.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForSectionNotEnrolledMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("secNotEnrolled.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForFullRoutineObserveMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("fullRoutineObserve.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForObserveByFacultyMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("observeByFacultyAdmin.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

    }

    public void actionForSetCourseLimitMenuItem(){
        /*FacultyInfo tempFacu=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFacu!=null){

            tempFacu.firstSectionOfFaculty=null;

            tempFacu=tempFacu.next;
        }*/
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("setLabTheoryLimitAdmin.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }


    public void actionForObserveFacultyAsListMenuItem(){
        //observeFacultyAsList
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("observeFacultyAsList.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

    }

    public void actionForHelpMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("help.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,600,400);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForAboutMenuItem(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("about.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,600,400);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForExportFullDataMenuItem(){
        try{
            // Export class call here
            new ExportToExcel();

        }catch(Exception e){
            e.printStackTrace();

        }

    }

    public void actionForLoadInputFromExcelFileMenuItem(){
        /*try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("loadFromExcelFile.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,600,400);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }*/
        new TakeInput();
    }

    public void actionForAutoGenerateMenuItem(){
        /*Stage newStage=null;
        try{
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("autoGenerate.fxml"));
            Scene newScene=new Scene(root,850,500);

            newStage = new Stage();

            newStage.setScene(newScene);
            newStage.setResizable(false);
            newStage.centerOnScreen();
            newStage.setAlwaysOnTop(true);
            newStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }*/


        new AutoGenerate();
        //new AutoGenerateAllPossibleRoutine();
        //new NumberingAndChooseTheBestRoutine();

        //newStage.close();

        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getClassLoader().getResource("fullRoutineObserve.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

    }

}
