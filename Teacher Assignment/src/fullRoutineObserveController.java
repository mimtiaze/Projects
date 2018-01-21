import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * Created by mimtiaze on 03-Aug-16.
 */
public class fullRoutineObserveController {
    public TableView<CourseToLinkedListOthersInfo> fullRoutineTable;
    public TableColumn<CourseToLinkedListOthersInfo, String> courseNameColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> sectionColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> timeColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> dayColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> facultyColumn;

    public Button previousButton;
    public Button nextButton;
    public Button selectButton;

    public static StoredRoutine currentFullRoutine;


    public static int indexOfFullRoutine;

    public void initialize(){

        Image backImage = new Image(getClass().getResourceAsStream("left.png"));
        previousButton.setGraphic(new ImageView(backImage));
        Image frontImage = new Image(getClass().getResourceAsStream("right.png"));
        nextButton.setGraphic(new ImageView(frontImage));
        Image selectImage = new Image(getClass().getResourceAsStream("select.png"));
        selectButton.setGraphic(new ImageView(selectImage));

        actionForFullRoutineTable();
    }

    public void nextButtonAction(){
        StoredRoutine prevRoutine=AutoGenerate.fullRoutines.get(indexOfFullRoutine);

        if(indexOfFullRoutine<20)
            indexOfFullRoutine+=1;
        actionForFullRoutineTable();
        System.out.println(indexOfFullRoutine);

        /*for(CourseToLinkedListOthersInfo sec:AutoGenerate.fullRoutines.get(indexOfFullRoutine).routines){
            if(!sec.faculty.equals("Drop"))
                sec.faculty="";
        }
        actionForFullRoutineTable();*/

        // For debug
        for(int i=0;i<currentFullRoutine.routines.size();i++){
            CourseToLinkedListOthersInfo tempList=currentFullRoutine.routines.get(i);
            for(int j=0;j<prevRoutine.routines.size();j++){
                CourseToLinkedListOthersInfo tempListPrevRoutine=prevRoutine.routines.get(j);
                if(tempList.title.equals(tempListPrevRoutine.title) &&
                        tempList.section.equals(tempListPrevRoutine.section) &&
                        !tempList.faculty.equals(tempListPrevRoutine.faculty))
                    System.out.println(tempList.title+" "+tempList.section+" "+tempList.faculty);
            }
        }
    }

    public void prevButtonAction(){
        StoredRoutine prevRoutine=AutoGenerate.fullRoutines.get(indexOfFullRoutine);

        if(indexOfFullRoutine>0)
            indexOfFullRoutine-=1;
        actionForFullRoutineTable();
        System.out.println(indexOfFullRoutine);


        // For debug
        for(int i=0;i<currentFullRoutine.routines.size();i++){
            CourseToLinkedListOthersInfo tempList=currentFullRoutine.routines.get(i);
            for(int j=0;j<prevRoutine.routines.size();j++){
                CourseToLinkedListOthersInfo tempListPrevRoutine=prevRoutine.routines.get(j);
                if(tempList.title.equals(tempListPrevRoutine.title) &&
                        tempList.section.equals(tempListPrevRoutine.section) &&
                        !tempList.faculty.equals(tempListPrevRoutine.faculty))
                    System.out.println(tempList.title+" "+tempList.section+" "+tempList.faculty);
            }
        }
    }

    public void actionForSelectIconButton(){
        currentFullRoutine=AutoGenerate.fullRoutines.get(indexOfFullRoutine);

        // make clear of all tempList
        FacultyInfo faculty=AddRemoveSearchFaculty.facultyHeadPointer;
        while(faculty!=null){
            faculty.tempSectionOfFaculty=null;
            faculty.tempLab=0;
            faculty.tempTheory=0;

            faculty=faculty.next;
        }


        // Change tempList
        for(CourseToLinkedListOthersInfo secList:currentFullRoutine.routines){
            FacultyInfo tempFaculty=AddRemoveSearchFaculty.searchFaculty(secList.faculty);
            if(tempFaculty!=null){
                tempFaculty.addCourseWithListInTempList(secList);
            }
        }
        System.out.println("Change done");
    }

    public void actionForFullRoutineTable() {
        ObservableList<CourseToLinkedListOthersInfo> listOfSection = FXCollections.observableArrayList();

        /*CourseToLinkedList tempCourseList=AddSearchCourse.courseHeadPointer;
        while(tempCourseList!=null){
            CourseToLinkedListOthersInfo tempSecList=tempCourseList.firstSection;
            while(tempSecList!=null){
                listOfSection.add(tempSecList);

                tempSecList=tempSecList.next;
            }
            tempCourseList=tempCourseList.next;
        }*/

        listOfSection.clear();
        try {

            currentFullRoutine=AutoGenerate.fullRoutines.get(indexOfFullRoutine);
            for (CourseToLinkedListOthersInfo sec : currentFullRoutine.routines) {
                listOfSection.add(sec);
                //System.out.println(sec.title + " " + sec.section + " " + sec.faculty);
            }

            if(listOfSection.size()==0){
                CourseToLinkedList tempCourseList = AddSearchCourse.courseHeadPointer;
                while (tempCourseList != null) {
                    CourseToLinkedListOthersInfo tempSecList = tempCourseList.firstSection;
                    while (tempSecList != null && tempSecList.faculty.equals("Drop")) {
                        listOfSection.add(tempSecList);

                        tempSecList = tempSecList.next;
                    }
                    tempCourseList = tempCourseList.next;
                }
            }

        }catch(Exception e){
            if(currentFullRoutine!=null){
                for (CourseToLinkedListOthersInfo sec : currentFullRoutine.routines) {
                    listOfSection.add(sec);
                    //System.out.println(sec.title + " " + sec.section + " " + sec.faculty);
                }
            }
            else {
                CourseToLinkedList tempCourseList = AddSearchCourse.courseHeadPointer;
                while (tempCourseList != null) {
                    CourseToLinkedListOthersInfo tempSecList = tempCourseList.firstSection;
                    while (tempSecList != null) {
                        listOfSection.add(tempSecList);

                        tempSecList = tempSecList.next;
                    }
                    tempCourseList = tempCourseList.next;
                }
            }
        }

        fullRoutineTable.setItems(listOfSection);
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
        facultyColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
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
