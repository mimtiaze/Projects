import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * Created by mimtiaze on 31-Jul-16.
 */
public class ObserveFacultyAsListController {
    public TableView<FacultyInfo> facultyShowTable;
    public TableColumn<FacultyInfo, String> facultyNameColumn;
    public TableColumn<FacultyInfo, String> takenLimitTheoryColumn;
    public TableColumn<FacultyInfo, String> takenLimitLabColumn;

    public TableColumn<FacultyInfo, String> takenTheoryColumn;
    public TableColumn<FacultyInfo, String> takenLabColumn;
    public TableColumn<FacultyInfo, String> limitTheoryColumn;
    public TableColumn<FacultyInfo, String> limitLabColumn;

    public TableView<CourseToLinkedListOthersInfo> sectionShowTable;
    public TableColumn<CourseToLinkedListOthersInfo, String> courseNameColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> sectionColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> timeColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> dayColumn;
    public TableColumn<CourseToLinkedListOthersInfo, String> roomColumn;

    public void initialize(){


        // for debugging eprpose
        FacultyInfo tempFac=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFac!=null){

            if(tempFac.lab!=tempFac.labLimit || tempFac.theory!=tempFac.theoryLimit)
                System.out.println(tempFac.facultyName);

            tempFac=tempFac.next;
        }

        addFacultyNameList();
    }

    public void addFacultyNameList() {




        ObservableList<FacultyInfo> listOfFaculty= FXCollections.observableArrayList();

        FacultyInfo tempFacultyInfo=AddRemoveSearchFaculty.facultyHeadPointer;

        while(tempFacultyInfo!=null){
            listOfFaculty.add(tempFacultyInfo);
            tempFacultyInfo=tempFacultyInfo.next;
        }

        facultyShowTable.setItems(listOfFaculty);
        facultyNameColumn.setCellValueFactory(new PropertyValueFactory<>("facultyName"));
        takenTheoryColumn.setCellValueFactory(new PropertyValueFactory<>("tempTheory"));
        takenLabColumn.setCellValueFactory(new PropertyValueFactory<>("tempLab"));
        limitTheoryColumn.setCellValueFactory(new PropertyValueFactory<>("theoryLimit"));
        limitLabColumn.setCellValueFactory(new PropertyValueFactory<>("labLimit"));
        //takenLimitTheoryColumn.setCellValueFactory(new PropertyValueFactory<>("theory"));
        //takenLimitLabColumn.setCellValueFactory(new PropertyValueFactory<>("lab"+"/"+"labLimit"));

        facultyShowTable.setRowFactory(t->{
            TableRow<FacultyInfo> row=new TableRow<>();
            row.setOnMouseClicked(e->{
                if(e.getClickCount()==1 && !(row.isEmpty())){
                    FacultyInfo temp=row.getItem();
                    addItemToCourseTable(temp);
                }
            });

            return row;
        });
    }

    public void addItemToCourseTable(FacultyInfo faculty){
        ObservableList<CourseToLinkedListOthersInfo> listOfCourse=FXCollections.observableArrayList();
        CourseToLinkedListOthersInfo tempList=faculty.tempSectionOfFaculty;

        while(tempList!=null){
            listOfCourse.add(tempList);
            tempList=tempList.next;
        }

        sectionShowTable.setItems(listOfCourse);
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));

        sectionShowTable.setRowFactory(tv -> {
            TableRow<CourseToLinkedListOthersInfo> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    CourseToLinkedListOthersInfo rowData = row.getItem();
                    System.out.println(rowData.title+" "+rowData.section);
                    System.out.println("Day 1: "+rowData.day1+" Day 2: "+rowData.day2);
                    System.out.println("TimeSlot : "+rowData.timeSlot);
                }
            });

            //System.out.println(row.getTypeSelector());

            return row;
        });

    }


    public void actionForEditButton() {
        FacultyInfo tempFacu=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFacu!=null){

            //tempFacu.firstSectionOfFaculty=null;
            tempFacu.tempSectionOfFaculty=null;
            //tempFacu.lab=0;
            tempFacu.tempLab=0;
            //tempFacu.theory=0;
            tempFacu.tempTheory=0;

            CourseToLinkedListOthersInfo tempTemp=tempFacu.firstSectionOfFaculty;
            while(tempTemp!=null){
                tempFacu.addCourseWithListInTempList(tempTemp);
                tempTemp=tempTemp.next;
            }

            tempFacu=tempFacu.next;
        }

        CourseToLinkedList list=AddSearchCourse.courseHeadPointer;

        while(list!=null){
            CourseToLinkedListOthersInfo secList=list.firstSection;
            while(secList!=null){

                if(!secList.faculty.equals("Drop"))
                    secList.faculty="";

                secList=secList.next;
            }
            list=list.next;
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
