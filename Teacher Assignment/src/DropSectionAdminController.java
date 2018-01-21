import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 26-Jul-16.
 */
public class DropSectionAdminController {

    public TableView<CourseToLinkedList> availableCourseShowTable;
    public TableView<CourseToLinkedListOthersInfo> availableCoursesSectionsTable;
    public TableView<CourseToLinkedList> droppedCourseShowTable;
    public TableView<CourseToLinkedListOthersInfo> droppedCourseSectionsTable;

    public TableColumn<CourseToLinkedList, String> availableCourseNameColumn;
    public TableColumn<CourseToLinkedList, String> droppedCourseNameColumn;

    public TableColumn<CourseToLinkedListOthersInfo, String> availableSectionNameColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> availableSectionTimeColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> availableSectionDayColumn;

    public TableColumn<CourseToLinkedListOthersInfo, String> droppedSectionNameColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> droppedSectionTimeColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> droppedSectionDayColumn;

    public Button dropButton;
    public Button recoverButton;

    public CourseToLinkedList selectedCourseListForDrop;
    public CourseToLinkedList selectedCourseListForRecover;

    public CourseToLinkedListOthersInfo selectedSecListForDrop;
    public CourseToLinkedListOthersInfo selectedSecListForRecover;




    public void initialize(){
        addItemToAvailableCourseTable();
        addItemToRecoverCourseTable();
    }

    public void addItemToAvailableCourseTable(){
        ObservableList<CourseToLinkedList> listOfCourse = FXCollections.observableArrayList();
        CourseToLinkedList tempCourseToLinkedList=AddSearchCourse.courseHeadPointer;

        while(tempCourseToLinkedList!=null){
            listOfCourse.add(tempCourseToLinkedList);
            tempCourseToLinkedList=tempCourseToLinkedList.next;
        }

        if(listOfCourse==null)
            System.out.println("Observable list is empty");

        availableCourseShowTable.setItems(listOfCourse);
        availableCourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        availableCourseShowTable.setRowFactory( tv->{
            TableRow<CourseToLinkedList> row= new TableRow<>();
            row.setOnMouseClicked(event->{
                if(event.getClickCount()==1 && (!row.isEmpty())){
                    CourseToLinkedList tempForSearch=row.getItem();
                    addItemToAvailableSectionTable(tempForSearch);
                }
            });
            return row;
        });

    }

    public void addItemToAvailableSectionTable(CourseToLinkedList tempForSearch) {
        ObservableList<CourseToLinkedListOthersInfo> listOfSections = FXCollections.observableArrayList();
        CourseToLinkedListOthersInfo tempCourseToLinkedListOthersInfo = tempForSearch.firstSection;

        while (tempCourseToLinkedListOthersInfo != null) {

            if(!tempCourseToLinkedListOthersInfo.faculty.equals("Drop"))
                listOfSections.add(tempCourseToLinkedListOthersInfo);

            tempCourseToLinkedListOthersInfo = tempCourseToLinkedListOthersInfo.next;
        }

        availableCoursesSectionsTable.setItems(listOfSections);
        availableSectionNameColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        availableSectionTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        availableSectionDayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));

        selectedCourseListForDrop=tempForSearch;

        availableCoursesSectionsTable.setRowFactory(tv->{
            TableRow<CourseToLinkedListOthersInfo> row=new TableRow<>();
            row.setOnMouseClicked(event ->{
                if(event.getClickCount()==1 && (!row.isEmpty())){
                    selectedSecListForDrop=row.getItem();
                    System.out.println(selectedSecListForDrop.timeSlot);
                    System.out.println(selectedSecListForDrop.day1 + " " + selectedSecListForDrop.day2);
                    System.out.println(selectedSecListForDrop.campus);
                }
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    selectedSecListForDrop=row.getItem();
                    actionForDropButton();
                }
            });
            return row;
        });

    }

    public void actionForDropButton(){

        if(selectedCourseListForDrop!=null && selectedSecListForDrop!=null && selectedSecListForDrop.faculty.equals("")){
            System.out.println(selectedCourseListForDrop.title);
            System.out.println(selectedSecListForDrop.section);

            selectedSecListForDrop.timeSlot=99;
            selectedSecListForDrop.labTimeSlot=99;
            selectedSecListForDrop.campus=99;
            selectedSecListForDrop.day1=99;
            selectedSecListForDrop.day2=99;

            if(selectedSecListForDrop.faculty.equals("") || selectedSecListForDrop.faculty==null)
                selectedSecListForDrop.faculty="Drop";
            else{
                String droppedCourseFacultyName=selectedSecListForDrop.faculty;
                FacultyInfo tempFaculty=AddRemoveSearchFaculty.searchFaculty(droppedCourseFacultyName);
                if(tempFaculty!=null){
                    if(selectedSecListForDrop.islabClass)
                        tempFaculty.lab--;
                    else
                        tempFaculty.theory--;
                }
                selectedSecListForDrop.faculty="Drop";
            }

            selectedCourseListForDrop.availableSections--;

            addItemToAvailableSectionTable(selectedCourseListForDrop);
            if(selectedCourseListForRecover!=null)
                addItemToDroppedSectionTable(selectedCourseListForRecover);

            //actionForRecoverButton();
        }
        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();
    }

    public void actionForRecoverButton(){
        if(selectedCourseListForRecover!=null && selectedSecListForRecover!=null){
            System.out.println(selectedCourseListForRecover.title);
            System.out.println(selectedSecListForRecover.section);


            selectedSecListForRecover.setCampus();
            selectedSecListForRecover.setDay();
            selectedSecListForRecover.setLabCLassAndTimeSlot();
            selectedSecListForRecover.faculty="";

            selectedCourseListForRecover.availableSections++;

            addItemToDroppedSectionTable(selectedCourseListForRecover);
            if(selectedCourseListForDrop!=null)
                addItemToAvailableSectionTable(selectedCourseListForDrop);
        }
        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();

    }


    public void addItemToRecoverCourseTable(){
        ObservableList<CourseToLinkedList> listOfCourse = FXCollections.observableArrayList();
        CourseToLinkedList tempCourseToLinkedList=AddSearchCourse.courseHeadPointer;

        while(tempCourseToLinkedList!=null){
            listOfCourse.add(tempCourseToLinkedList);
            tempCourseToLinkedList=tempCourseToLinkedList.next;
        }

        if(listOfCourse==null)
            System.out.println("Observable list is empty");

        droppedCourseShowTable.setItems(listOfCourse);
        droppedCourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        droppedCourseShowTable.setRowFactory( tv->{
            TableRow<CourseToLinkedList> row= new TableRow<>();
            row.setOnMouseClicked(event->{
                if(event.getClickCount()==1 && (!row.isEmpty())){
                    CourseToLinkedList tempForSearch=row.getItem();
                    addItemToDroppedSectionTable(tempForSearch);
                    System.out.println("In the drooped courses table");
                }
            });
            return row;
        });

    }

    public void addItemToDroppedSectionTable(CourseToLinkedList tempForSearchForRecover) {
        ObservableList<CourseToLinkedListOthersInfo> listOfSections = FXCollections.observableArrayList();
        CourseToLinkedListOthersInfo tempCourseToLinkedListOthersInfo = tempForSearchForRecover.firstSection;

        while (tempCourseToLinkedListOthersInfo != null) {

            if(tempCourseToLinkedListOthersInfo.faculty.equals("Drop"))
                listOfSections.add(tempCourseToLinkedListOthersInfo);

            tempCourseToLinkedListOthersInfo = tempCourseToLinkedListOthersInfo.next;
        }

        droppedCourseSectionsTable.setItems(listOfSections);
        droppedSectionNameColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        droppedSectionTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        droppedSectionDayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));

        selectedCourseListForRecover=tempForSearchForRecover;

        droppedCourseSectionsTable.setRowFactory(tv->{
            TableRow<CourseToLinkedListOthersInfo> row=new TableRow<>();
            row.setOnMouseClicked(event ->{
                if(event.getClickCount()==1 && (!row.isEmpty())){
                    selectedSecListForRecover=row.getItem();
                    System.out.println(selectedSecListForRecover.timeSlot);
                    System.out.println(selectedSecListForRecover.day1 + " " + selectedSecListForRecover.day2);
                    System.out.println(selectedSecListForRecover.campus);
                }
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    selectedSecListForRecover=row.getItem();
                    actionForRecoverButton();
                }
            });
            return row;
        });

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
        new AutoGenerate();
        //new AutoGenerateAllPossibleRoutine();
        //new NumberingAndChooseTheBestRoutine();

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


