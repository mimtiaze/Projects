import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * Created by mimtiaze on 03-Aug-16.
 */
public class SecNotEnrolledController {
    public TableView<CourseToLinkedListOthersInfo> fullRoutineTable;
    public TableColumn<CourseToLinkedListOthersInfo, String> courseNameColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> sectionColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> timeColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> dayColumn;
    //public TableColumn<CourseToLinkedListOthersInfo, String> facultyColumn;

    public Button previousButton;
    public Button nextButton;
    public Button selectButton;


    public CourseToLinkedListOthersInfo selectedSecListForDrop;
    public CourseToLinkedList selectedCourseListForDrop;

    public void initialize(){

        actionForFullRoutineTable();

    }

    public void actionForFullRoutineTable() {
        ObservableList<CourseToLinkedListOthersInfo> listOfSection = FXCollections.observableArrayList();

        CourseToLinkedList tempCourseList=AddSearchCourse.courseHeadPointer;
        while(tempCourseList!=null){
            CourseToLinkedListOthersInfo tempSecList=tempCourseList.firstSection;
            while(tempSecList!=null){
                //listOfSection.add(tempSecList);

                if(tempSecList.faculty.equals(""))
                    listOfSection.add(tempSecList);

                tempSecList=tempSecList.next;
            }
            tempCourseList=tempCourseList.next;
        }

        //listOfSection.clear();

        fullRoutineTable.setItems(listOfSection);
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));

        // facultyColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));


        fullRoutineTable.setRowFactory(tv->{
            TableRow<CourseToLinkedListOthersInfo> row=new TableRow<>();
            row.setOnMouseClicked(event ->{
                if(event.getClickCount()==1 && (!row.isEmpty())){
                    selectedSecListForDrop=row.getItem();
                    selectedCourseListForDrop=AddSearchCourse.searchCourseWithTitle(selectedSecListForDrop.title);
                    System.out.println(selectedSecListForDrop.timeSlot);
                    System.out.println(selectedSecListForDrop.day1 + " " + selectedSecListForDrop.day2);
                    System.out.println(selectedSecListForDrop.campus);
                }
                if(event.getClickCount()==2 && (!row.isEmpty())){
                    selectedSecListForDrop=row.getItem();
                    //dropButtonAction();
                }
            });
            return row;
        });
    }

    public void dropButtonAction(){
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

            actionForFullRoutineTable();
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
