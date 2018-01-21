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
public class ChooseCourseUserController {

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

        //addItemToFacultyNameTable();
        /*FacultyInfo tempFaculty=AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if(tempFaculty!=null) {*/
            currentFaculty = logInController.userFacultyInfo;

            facultyNameLabel.setText(currentFaculty.facultyName);
            facultyPriorityLabel.setText(Integer.toString(currentFaculty.priority));
        //}

        addItemToAvailableCourseTable();
        addItemToChosenCourseTable();

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

            currentFaculty.addCourseWithListInRequestedList(newTemp);
        }
        addItemToChosenCourseTable();

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
        }
        addItemToChosenCourseTable();
    }









    @FXML
    private Stage chooseCourseStage;
    private Scene chooseCourseUserScene;
    private Parent chooseCourseUserRoot;

    public Label copyRightLabel;

    public void actionForChooseSectionMenuItem(){

        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("routineGridShowUser.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.centerOnScreen();
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }


    public void actionForChooseCourseMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("chooseCourseUser.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.centerOnScreen();
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }


    public void actionForChangePasswordMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("changePasswordUser.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,400,300);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.centerOnScreen();
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForHelpMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("help.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,600,400);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.centerOnScreen();
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForAboutMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getClassLoader().getResource("about.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,600,400);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
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

}
