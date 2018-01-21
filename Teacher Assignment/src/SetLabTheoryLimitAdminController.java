import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.event.ActionListener;

/**
 * Created by mimtiaze on 25-Jul-16.
 */
public class SetLabTheoryLimitAdminController {
    public Label totalTheoryCounter;
    public Label totalLabCounter;
    public Label assignedTheoryCounter;
    public Label assignedLabCounter;
    public Label needMoreTheoryCounter;
    public Label needMoreLabCounter;
    public Label facultyNameLabel;


    public TextField theoryEditorTextField;
    public TextField labEditorTextField;

    public TableView<CourseToLinkedList> showAllCoursesAvailableSections;
    public TableView<FacultyInfo> showAllFacultyTheoryLabLimit;

    public TableColumn<CourseToLinkedList,String> availableSectionsColumn;
    public TableColumn<CourseToLinkedList,String> availableCoursesNameColumn;
    public TableColumn<FacultyInfo,String> facultyNameColumn;
    public TableColumn<FacultyInfo,String> theoryLimitColumn;
    public TableColumn<FacultyInfo,String> labLimitColumn;
    public TableColumn<FacultyInfo,String> priorityColumn;

    public void initialize(){
        addOptionToAvailableSectionsOfCourses();
        //addOptionToAvailableSectionsOfCourses();
    }

    public void addOptionToAvailableSectionsOfCourses(){
        ObservableList<FacultyInfo> listOfFaculty = FXCollections.observableArrayList();
        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;

        while(tempFaculty!=null){
            listOfFaculty.add(tempFaculty);

            tempFaculty=tempFaculty.next;
        }
        showAllFacultyTheoryLabLimit.setItems(listOfFaculty);
        facultyNameColumn.setCellValueFactory(new PropertyValueFactory<>("facultyName"));
        theoryLimitColumn.setCellValueFactory(new PropertyValueFactory<>("theoryLimit"));
        labLimitColumn.setCellValueFactory(new PropertyValueFactory<>("labLimit"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));


        /*showAllFacultyTheoryLabLimit.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FacultyInfo>() {
            @Override
            public void changed(ObservableValue<? extends FacultyInfo> observable, FacultyInfo oldValue, FacultyInfo newValue) {

            }
        });*/

        //FacultyInfo f=showAllFacultyTheoryLabLimit.getSelectionModel().getSelectedItem();
        //System.out.println(f.facultyName+" is selected");

        showAllFacultyTheoryLabLimit.setRowFactory(tv -> {
            TableRow<FacultyInfo> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty()) ) {
                    FacultyInfo rowData = row.getItem();
                    System.out.println(rowData.facultyName);

                    String tempStrForTheoryEditorTextField= Integer.toString(rowData.theoryLimit);
                    theoryEditorTextField.setText(tempStrForTheoryEditorTextField);

                    String tempStrForLabEditorTextField= Integer.toString(rowData.labLimit);
                    labEditorTextField.setText(tempStrForLabEditorTextField);

                    facultyNameLabel.setText(rowData.facultyName);

                    theoryEditorTextField.requestFocus();
                }
                else if(event.getClickCount() == 1 && (! row.isEmpty())){
                    /*theoryEditorTextField.clear();
                    labEditorTextField.clear();*/

                    FacultyInfo rowData = row.getItem();
                    System.out.println(rowData.facultyName);

                    String tempStrForTheoryEditorTextField= Integer.toString(rowData.theoryLimit);
                    theoryEditorTextField.setText(tempStrForTheoryEditorTextField);

                    String tempStrForLabEditorTextField= Integer.toString(rowData.labLimit);
                    labEditorTextField.setText(tempStrForLabEditorTextField);

                    facultyNameLabel.setText(rowData.facultyName);
                }
            });

            //System.out.println(row.getTypeSelector());

            addOptionToShowAllCoursesAvailableSectionsTable();
            return row;
        });

        updateAllCounter();
    }

    public void keyActionForTheoryEditorTextField(KeyEvent e){
        if(e.getCode().equals(KeyCode.ENTER)){
            if (theoryEditorTextField.getText().equals("resetList") || theoryEditorTextField.getText().equals("reset")){
                SavingCoursesAndFacultyInfo.resetAllFacultyAndCourses();
            }else if (theoryEditorTextField.getText().equals("resetCourse")){
                SavingCoursesAndFacultyInfo.resetCourses();
            }else if (theoryEditorTextField.getText().equals("resetDrop")){
                SavingCoursesAndFacultyInfo.resetCoursesWithDropList();
            }else {
                //try {
                    FacultyInfo tempFaculty = showAllFacultyTheoryLabLimit.getSelectionModel().getSelectedItem();
                    //System.out.println(tempFaculty.facultyName);
                    FacultyInfo tempFacultyForChange = AddRemoveSearchFaculty.searchFaculty(tempFaculty.facultyName);
                    if (tempFacultyForChange != null) {
                        if (!theoryEditorTextField.getText().equals(""))
                            tempFacultyForChange.theoryLimit = Integer.parseInt(theoryEditorTextField.getText());
                        else
                            tempFacultyForChange.theoryLimit = 0;

                        if (!labEditorTextField.getText().equals(""))
                            tempFacultyForChange.labLimit = Integer.parseInt(labEditorTextField.getText());
                        else
                            tempFacultyForChange.labLimit = 0;


                        //showAllFacultyTheoryLabLimit.getSelectionModel().getSelectedIndex();
                        //showAllFacultyTheoryLabLimit.setSelectionModel();

                        addOptionToAvailableSectionsOfCourses();

                        labEditorTextField.requestFocus();
                    }
                //}catch (Exception e2){
                    //e2.printStackTrace();
                //}
            }
        }
        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();
    }

    public void keyActionForLabEditorTextField(KeyEvent e){
        if(e.getCode().equals(KeyCode.ENTER)){
            FacultyInfo tempFaculty=showAllFacultyTheoryLabLimit.getSelectionModel().getSelectedItem();
            //System.out.println(tempFaculty.facultyName);
            FacultyInfo tempFacultyForChange=AddRemoveSearchFaculty.searchFaculty(tempFaculty.facultyName);

            if(tempFacultyForChange!=null) {
                if (!theoryEditorTextField.getText().equals(""))
                    tempFacultyForChange.theoryLimit = Integer.parseInt(theoryEditorTextField.getText());
                else
                    tempFacultyForChange.theoryLimit = 0;

                if (!labEditorTextField.getText().equals(""))
                    tempFacultyForChange.labLimit = Integer.parseInt(labEditorTextField.getText());
                else
                    tempFacultyForChange.labLimit = 0;


                //showAllFacultyTheoryLabLimit.getSelectionModel().getSelectedIndex();
                //showAllFacultyTheoryLabLimit.setSelectionModel();

                addOptionToAvailableSectionsOfCourses();
            }
        }
        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();
    }

    public void addOptionToShowAllCoursesAvailableSectionsTable(){
        ObservableList<CourseToLinkedList> listOfAllCourses=FXCollections.observableArrayList();
        CourseToLinkedList tempLinkedList=AddSearchCourse.courseHeadPointer;

        while(tempLinkedList!=null){
            listOfAllCourses.add(tempLinkedList);
            tempLinkedList=tempLinkedList.next;
        }

        showAllCoursesAvailableSections.setItems(listOfAllCourses);
        availableCoursesNameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableSectionsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSections"));



    }

    public void updateAllCounter(){
        //Available section updater
        CourseToLinkedList tempCourseToLinkedList=AddSearchCourse.courseHeadPointer;
        int availableTheoryCounter=0;
        int availableLabCounter=0;

        while(tempCourseToLinkedList!=null){
            if(tempCourseToLinkedList.isLab)
                availableLabCounter+=tempCourseToLinkedList.availableSections;
            else
                availableTheoryCounter+=tempCourseToLinkedList.availableSections;

            tempCourseToLinkedList=tempCourseToLinkedList.next;
        }

        totalTheoryCounter.setText(Integer.toString(availableTheoryCounter));
        totalLabCounter.setText(Integer.toString(availableLabCounter));


        //Assigned section updater
        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        int assignedTheoryCount=0;
        int assignedLabCount=0;

        while(tempFaculty!=null){
            assignedTheoryCount+=tempFaculty.theoryLimit;
            assignedLabCount+=tempFaculty.labLimit;

            tempFaculty=tempFaculty.next;
        }

        assignedTheoryCounter.setText(Integer.toString(assignedTheoryCount));
        assignedLabCounter.setText(Integer.toString(assignedLabCount));


        int needMoreTheory=availableTheoryCounter-assignedTheoryCount;
        int needMoreLab=availableLabCounter-assignedLabCount;

        needMoreTheoryCounter.setText(Integer.toString(needMoreTheory));
        needMoreLabCounter.setText(Integer.toString(needMoreLab));

    }

    public void actionForKeyPressedOfFacultyNameTable(KeyEvent e){
        System.out.println("Key pressed : ");

        TableRow<FacultyInfo> row = new TableRow<>();
        if(e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.DOWN)){

            //System.out.println("UP or DOWN");
        }
        if(e.getCode().equals(KeyCode.ENTER)){
            System.out.println("Enter");
            FacultyInfo rowData = row.getItem();
            System.out.println(rowData.facultyName);

            String tempStrForTheoryEditorTextField= Integer.toString(rowData.theoryLimit);
            theoryEditorTextField.setText(tempStrForTheoryEditorTextField);

            String tempStrForLabEditorTextField= Integer.toString(rowData.labLimit);
            labEditorTextField.setText(tempStrForLabEditorTextField);

            facultyNameLabel.setText(rowData.facultyName);
        }
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
