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
 * Created by mimtiaze on 04-Sep-16.
 */
public class ChooseCourseAdminController {

    public TableView facultyNameTable;
    public TableView availableCourseTable;
    public TableView chosenCourseTable;

    public Button addButton;
    public Button removeButton;

    public TableColumn<FacultyInfo,String> facultyNameColumn;
    public TableColumn<CourseToLinkedList,String> availableCourseColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> chosenCourseColumn;

    public Label facultyNameLabel;
    public Label facultyPriorityLabel;
    public Label facultyPositionLabel;

    public FacultyInfo currentFaculty;
    public CourseToLinkedList currentCourse;
    public CourseToLinkedList currentCourseForRemove;

    public void initialize(){

        addItemToFacultyNameTable();
        addItemToAvailableCourseTable();

    }

    public void addItemToChosenCourseTable(){
        if(currentFaculty!=null){
            ObservableList<CourseToLinkedList> listOfChosenCourse=FXCollections.observableArrayList();

            CourseToLinkedList tempList=currentFaculty.chosenCourseOfFaculty;
            while(tempList!=null){
                listOfChosenCourse.add(tempList);
                tempList=tempList.next;
            }


            chosenCourseTable.setItems(listOfChosenCourse);
            chosenCourseColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

            chosenCourseTable.setRowFactory(e->{
                TableRow<CourseToLinkedList> row=new TableRow<CourseToLinkedList>();
                row.setOnMouseClicked(event->{
                    if(event.getClickCount()==1 && !row.isEmpty()){
                        currentCourseForRemove=row.getItem();
                    }
                });


                return row;
            });
        }
    }

    public void addItemToFacultyNameTable(){

        ObservableList<FacultyInfo> listOfFaculty = FXCollections.observableArrayList();

        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFaculty!=null){

            listOfFaculty.add(tempFaculty);
            tempFaculty=tempFaculty.next;
        }

        facultyNameTable.setItems(listOfFaculty);
        facultyNameColumn.setCellValueFactory(new PropertyValueFactory<>("facultyName"));

        facultyNameTable.setRowFactory(e->{
            TableRow<FacultyInfo> row=new TableRow<FacultyInfo>();
            row.setOnMouseClicked(event->{
               if(event.getClickCount()==1 && (!row.isEmpty())){
                   currentFaculty = row.getItem();
                   facultyNameLabel.setText(currentFaculty.facultyName);
                   facultyPriorityLabel.setText(Integer.toString(currentFaculty.priority));
                   //facultyPositionLabel.setText(Integer.toString());
                   addItemToChosenCourseTable();
               }

            });
            return row;
        });
    }

    public void addItemToAvailableCourseTable(){
        ObservableList<CourseToLinkedList> listOfAvailableCourse=FXCollections.observableArrayList();
        CourseToLinkedList tempCourseList=AddSearchCourse.courseHeadPointer;
        while(tempCourseList!=null){
            listOfAvailableCourse.add(tempCourseList);
            tempCourseList=tempCourseList.next;
        }


        availableCourseTable.setItems(listOfAvailableCourse);
        availableCourseColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        availableCourseTable.setRowFactory(e->{
            TableRow<CourseToLinkedList> row=new TableRow<CourseToLinkedList>();
            row.setOnMouseClicked(event->{
                if(event.getClickCount()==1 && !row.isEmpty()){
                    currentCourse=row.getItem();
                }
            });

            return row;
        });

    }


    public void actionForAddButton(){
        if(currentCourse!=null && currentFaculty!=null){
            currentFaculty.addCourseWithListInChosenCourseList(currentCourse);

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.title=currentCourse.title;
            newTemp.code=currentCourse.code;
            newTemp.section="N/A";
            newTemp.time="N/A";
            newTemp.day="N/A";
            newTemp.next=null;

            currentFaculty.removeCourseWithTitleAndSectionInRequestedList(newTemp.title,newTemp.section);

            addItemToChosenCourseTable();
            SavingCoursesAndFacultyInfo.savingCoursesInfo();
            SavingCoursesAndFacultyInfo.savingFacultyInfo();
        }
    }

    public void actionForRemoveButton(){
        if(currentCourseForRemove!=null && currentFaculty!=null){
            currentFaculty.removeCourseFromChosenCourseList(currentCourseForRemove.title);

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.title=currentCourseForRemove.title;
            newTemp.code=currentCourseForRemove.code;
            newTemp.section="N/A";
            newTemp.time="N/A";
            newTemp.day="N/A";
            newTemp.next=null;

            currentFaculty.removeCourseWithTitleAndSectionInRequestedList(newTemp.title,newTemp.section);

            addItemToChosenCourseTable();
            SavingCoursesAndFacultyInfo.savingCoursesInfo();
            SavingCoursesAndFacultyInfo.savingFacultyInfo();
        }
    }




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
