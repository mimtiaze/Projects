import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 29-Jul-16.
 */
public class ObserveByFacultyAdminController {


    public Label labelDay1Time1;
    public Label labelDay1Time2;
    public Label labelDay1Time3;
    public Label labelDay1Time4;
    public Label labelDay1Time5;
    public Label labelDay1Time6;
    public Label labelDay1Time7;
    public Label labelDay2Time1;
    public Label labelDay2Time2;
    public Label labelDay2Time3;
    public Label labelDay2Time4;
    public Label labelDay2Time5;
    public Label labelDay2Time6;
    public Label labelDay2Time7;
    public Label labelDay3Time1;
    public Label labelDay3Time2;
    public Label labelDay3Time3;
    public Label labelDay3Time4;
    public Label labelDay3Time5;
    public Label labelDay3Time6;
    public Label labelDay3Time7;
    public Label labelDay4Time1;
    public Label labelDay4Time2;
    public Label labelDay4Time3;
    public Label labelDay4Time4;
    public Label labelDay4Time5;
    public Label labelDay4Time6;
    public Label labelDay4Time7;

    public Label facultyTheoryCounter;
    public Label facultyLabCounter;

    public ComboBox facultyShowComboBox;

    public void initialize(){
        addOptionToFacultyShowComboBox();
    }

    public void actionForFacultyShowComboBox(){

        String tempFacultyStr=(String)facultyShowComboBox.getValue();
        FacultyInfo tempFacultyInfo=AddRemoveSearchFaculty.searchFaculty(tempFacultyStr);

        resetLabel();

        if(tempFacultyInfo!=null){
            CourseToLinkedListOthersInfo sectionList=tempFacultyInfo.tempSectionOfFaculty;
            if(sectionList!=null){
                while(sectionList!=null){

                    if(sectionList.islabClass)
                        addDetailsForLabClass(sectionList);
                    else
                        addDetailsToLabel(sectionList);
                    sectionList=sectionList.next;
                }
            }
            String tempCounter = Integer.toString(tempFacultyInfo.tempTheory);
            facultyTheoryCounter.setText(tempCounter);
            tempCounter = Integer.toString(tempFacultyInfo.tempLab);
            facultyLabCounter.setText(tempCounter);
        }
    }

    private void addDetailsForLabClass(CourseToLinkedListOthersInfo received) {

        if(received.timeSlot==1 && (received.day1==1 || received.day2==1)){
            labelDay1Time1.setText(received.code+"\n"+received.section);
            labelDay1Time1.setStyle("-fx-background-color: #6cc1ae;");
            labelDay1Time1.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay1Time2.setText("<-------");
            labelDay1Time2.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==3 && (received.day1==1 || received.day2==1)){
            labelDay1Time3.setText(received.code+"\n"+received.section);
            labelDay1Time3.setStyle("-fx-background-color: #6cc1ae;");
            labelDay1Time3.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay1Time4.setText("<-------");
            labelDay1Time4.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==5 && (received.day1==1 || received.day2==1)){
            labelDay1Time5.setText(received.code+"\n"+received.section);
            labelDay1Time5.setStyle("-fx-background-color: #6cc1ae;");
            labelDay1Time5.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay1Time6.setText("<-------");
            labelDay1Time6.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==7 && (received.day1==1 || received.day2==1)){
            labelDay1Time7.setText(received.code+"\n"+received.section);
            labelDay1Time7.setStyle("-fx-background-color: #6cc1ae;");
            labelDay1Time7.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }





        if(received.timeSlot==1 && (received.day1==2 || received.day2==2)){
            labelDay2Time1.setText(received.code+"\n"+received.section);
            labelDay2Time1.setStyle("-fx-background-color: #6cc1ae;");
            labelDay2Time1.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay2Time2.setText("<-------");
            labelDay2Time2.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==3 && (received.day1==2 || received.day2==2)){
            labelDay2Time3.setText(received.code+"\n"+received.section);
            labelDay2Time3.setStyle("-fx-background-color: #6cc1ae;");
            labelDay2Time3.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay2Time4.setText("<-------");
            labelDay2Time4.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==5 && (received.day1==2 || received.day2==2)){
            labelDay2Time5.setText(received.code+"\n"+received.section);
            labelDay2Time5.setStyle("-fx-background-color: #6cc1ae;");
            labelDay2Time5.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay2Time6.setText("<-------");
            labelDay2Time6.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==7 && (received.day1==2 || received.day2==2)){
            labelDay2Time7.setText(received.code+"\n"+received.section);
            labelDay2Time7.setStyle("-fx-background-color: #6cc1ae;");
            labelDay2Time7.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

        }




        if(received.timeSlot==1 && (received.day1==3 || received.day2==3)){
            labelDay3Time1.setText(received.code+"\n"+received.section);
            labelDay3Time1.setStyle("-fx-background-color: #6cc1ae;");
            labelDay3Time1.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay3Time2.setText("<-------");
            labelDay3Time2.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==3 && (received.day1==3 || received.day2==3)){
            labelDay3Time3.setText(received.code+"\n"+received.section);
            labelDay3Time3.setStyle("-fx-background-color: #6cc1ae;");
            labelDay3Time3.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay3Time4.setText("<-------");
            labelDay3Time4.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==5 && (received.day1==3 || received.day2==3)){
            labelDay3Time5.setText(received.code+"\n"+received.section);
            labelDay3Time5.setStyle("-fx-background-color: #6cc1ae;");
            labelDay3Time5.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay3Time6.setText("<-------");
            labelDay3Time6.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==7 && (received.day1==3 || received.day2==3)){
            labelDay3Time7.setText(received.code+"\n"+received.section);
            labelDay3Time7.setStyle("-fx-background-color: #6cc1ae;");
            labelDay3Time7.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }





        if(received.timeSlot==1 && (received.day1==4 || received.day2==4)){
            labelDay4Time1.setText(received.code+"\n"+received.section);
            labelDay4Time1.setStyle("-fx-background-color: #6cc1ae;");
            labelDay4Time1.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay4Time2.setText("<-------");
            labelDay4Time2.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==3 && (received.day1==4 || received.day2==4)){
            labelDay4Time3.setText(received.code+"\n"+received.section);
            labelDay4Time3.setStyle("-fx-background-color: #6cc1ae;");
            labelDay4Time3.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay4Time4.setText("<-------");
            labelDay4Time4.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==5 && (received.day1==4 || received.day2==4)){
            labelDay4Time5.setText(received.code+"\n"+received.section);
            labelDay4Time5.setStyle("-fx-background-color: #6cc1ae;");
            labelDay4Time5.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));

            labelDay4Time6.setText("<-------");
            labelDay4Time6.setStyle("-fx-background-color: #6cc1ae;");
        }

        if(received.timeSlot==7 && (received.day1==4 || received.day2==4)){
            labelDay4Time7.setText(received.code+"\n"+received.section);
            labelDay4Time7.setStyle("-fx-background-color: #6cc1ae;");
            labelDay4Time7.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }


    }


    public void addDetailsToLabel(CourseToLinkedListOthersInfo received){

        if(received.timeSlot==1 && (received.day1==1 || received.day2==1)){
            labelDay1Time1.setText(received.code+"\n"+received.section);
            labelDay1Time1.setStyle("-fx-background-color: #aeecdf;");
            labelDay1Time1.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==2 && (received.day1==1 || received.day2==1)){
            labelDay1Time2.setText(received.code+"\n"+received.section);
            labelDay1Time2.setStyle("-fx-background-color: #aeecdf;");
            labelDay1Time2.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==3 && (received.day1==1 || received.day2==1)){
            labelDay1Time3.setText(received.code+"\n"+received.section);
            labelDay1Time3.setStyle("-fx-background-color: #aeecdf;");
            labelDay1Time3.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==4 && (received.day1==1 || received.day2==1)){
            labelDay1Time4.setText(received.code+"\n"+received.section);
            labelDay1Time4.setStyle("-fx-background-color: #aeecdf;");
            labelDay1Time4.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==5 && (received.day1==1 || received.day2==1)){
            labelDay1Time5.setText(received.code+"\n"+received.section);
            labelDay1Time5.setStyle("-fx-background-color: #aeecdf;");
            labelDay1Time5.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==6 && (received.day1==1 || received.day2==1)){
            labelDay1Time6.setText(received.code+"\n"+received.section);
            labelDay1Time6.setStyle("-fx-background-color: #aeecdf;");
            labelDay1Time6.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==7 && (received.day1==1 || received.day2==1)){
            labelDay1Time7.setText(received.code+"\n"+received.section);
            labelDay1Time7.setStyle("-fx-background-color: #aeecdf;");
            labelDay1Time7.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }



        if(received.timeSlot==1 && (received.day1==2 || received.day2==2)){
            labelDay2Time1.setText(received.code+"\n"+received.section);
            labelDay2Time1.setStyle("-fx-background-color: #aeecdf;");
            labelDay2Time1.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==2 && (received.day1==2 || received.day2==2)){
            labelDay2Time2.setText(received.code+"\n"+received.section);
            labelDay2Time2.setStyle("-fx-background-color: #aeecdf;");
            labelDay2Time2.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==3 && (received.day1==2 || received.day2==2)){
            labelDay2Time3.setText(received.code+"\n"+received.section);
            labelDay2Time3.setStyle("-fx-background-color: #aeecdf;");
            labelDay2Time3.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==4 && (received.day1==2 || received.day2==2)){
            labelDay2Time4.setText(received.code+"\n"+received.section);
            labelDay2Time4.setStyle("-fx-background-color: #aeecdf;");
            labelDay2Time4.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==5 && (received.day1==2 || received.day2==2)){
            labelDay2Time5.setText(received.code+"\n"+received.section);
            labelDay2Time5.setStyle("-fx-background-color: #aeecdf;");
            labelDay2Time5.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==6 && (received.day1==2 || received.day2==2)){
            labelDay2Time6.setText(received.code+"\n"+received.section);
            labelDay2Time6.setStyle("-fx-background-color: #aeecdf;");
            labelDay2Time6.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==7 && (received.day1==2 || received.day2==2)){
            labelDay2Time7.setText(received.code+"\n"+received.section);
            labelDay2Time7.setStyle("-fx-background-color: #aeecdf;");
            labelDay2Time7.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }


        if(received.timeSlot==1 && (received.day1==3 || received.day2==3)){
            labelDay3Time1.setText(received.code+"\n"+received.section);
            labelDay3Time1.setStyle("-fx-background-color: #aeecdf;");
            labelDay3Time1.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==2 && (received.day1==3 || received.day2==3)){
            labelDay3Time2.setText(received.code+"\n"+received.section);
            labelDay3Time2.setStyle("-fx-background-color: #aeecdf;");
            labelDay3Time2.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==3 && (received.day1==3 || received.day2==3)){
            labelDay3Time3.setText(received.code+"\n"+received.section);
            labelDay3Time3.setStyle("-fx-background-color: #aeecdf;");
            labelDay3Time3.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==4 && (received.day1==3 || received.day2==3)){
            labelDay3Time4.setText(received.code+"\n"+received.section);
            labelDay3Time4.setStyle("-fx-background-color: #aeecdf;");
            labelDay3Time4.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==5 && (received.day1==3 || received.day2==3)){
            labelDay3Time5.setText(received.code+"\n"+received.section);
            labelDay3Time5.setStyle("-fx-background-color: #aeecdf;");
            labelDay3Time5.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==6 && (received.day1==3 || received.day2==3)){
            labelDay3Time6.setText(received.code+"\n"+received.section);
            labelDay3Time6.setStyle("-fx-background-color: #aeecdf;");
            labelDay3Time6.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==7 && (received.day1==3 || received.day2==3)){
            labelDay3Time7.setText(received.code+"\n"+received.section);
            labelDay3Time7.setStyle("-fx-background-color: #aeecdf;");
            labelDay3Time7.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }



        if(received.timeSlot==1 && (received.day1==4 || received.day2==4)){
            labelDay4Time1.setText(received.code+"\n"+received.section);
            labelDay4Time1.setStyle("-fx-background-color: #aeecdf;");
            labelDay4Time1.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==2 && (received.day1==4 || received.day2==4)){
            labelDay4Time2.setText(received.code+"\n"+received.section);
            labelDay4Time2.setStyle("-fx-background-color: #aeecdf;");
            labelDay4Time2.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==3 && (received.day1==4 || received.day2==4)){
            labelDay4Time3.setText(received.code+"\n"+received.section);
            labelDay4Time3.setStyle("-fx-background-color: #aeecdf;");
            labelDay4Time3.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==4 && (received.day1==4 || received.day2==4)){
            labelDay4Time4.setText(received.code+"\n"+received.section);
            labelDay4Time4.setStyle("-fx-background-color: #aeecdf;");
            labelDay4Time4.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==5 && (received.day1==4 || received.day2==4)){
            labelDay4Time5.setText(received.code+"\n"+received.section);
            labelDay4Time5.setStyle("-fx-background-color: #aeecdf;");
            labelDay4Time5.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==6 && (received.day1==4 || received.day2==4)){
            labelDay4Time6.setText(received.code+"\n"+received.section);
            labelDay4Time6.setStyle("-fx-background-color: #aeecdf;");
            labelDay4Time6.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }
        if(received.timeSlot==7 && (received.day1==4 || received.day2==4)){
            labelDay4Time7.setText(received.code+"\n"+received.section);
            labelDay4Time7.setStyle("-fx-background-color: #aeecdf;");
            labelDay4Time7.setTooltip(new Tooltip(received.title+"\n"+"Campus - "+received.campus+"\n"+received.time));
        }

    }

    public void resetLabel(){
        labelDay1Time1.setText("");
        labelDay1Time2.setText("");
        labelDay1Time3.setText("");
        labelDay1Time4.setText("");
        labelDay1Time5.setText("");
        labelDay1Time6.setText("");
        labelDay1Time7.setText("");
        labelDay2Time1.setText("");
        labelDay2Time2.setText("");
        labelDay2Time3.setText("");
        labelDay2Time4.setText("");
        labelDay2Time5.setText("");
        labelDay2Time6.setText("");
        labelDay2Time7.setText("");
        labelDay3Time1.setText("");
        labelDay3Time2.setText("");
        labelDay3Time3.setText("");
        labelDay3Time4.setText("");
        labelDay3Time5.setText("");
        labelDay3Time6.setText("");
        labelDay3Time7.setText("");
        labelDay4Time1.setText("");
        labelDay4Time2.setText("");
        labelDay4Time3.setText("");
        labelDay4Time4.setText("");
        labelDay4Time5.setText("");
        labelDay4Time6.setText("");
        labelDay4Time7.setText("");

        labelDay1Time1.setStyle("");
        labelDay1Time2.setStyle("");
        labelDay1Time3.setStyle("");
        labelDay1Time4.setStyle("");
        labelDay1Time5.setStyle("");
        labelDay1Time6.setStyle("");
        labelDay1Time7.setStyle("");
        labelDay2Time1.setStyle("");
        labelDay2Time2.setStyle("");
        labelDay2Time3.setStyle("");
        labelDay2Time4.setStyle("");
        labelDay2Time5.setStyle("");
        labelDay2Time6.setStyle("");
        labelDay2Time7.setStyle("");
        labelDay3Time1.setStyle("");
        labelDay3Time2.setStyle("");
        labelDay3Time3.setStyle("");
        labelDay3Time4.setStyle("");
        labelDay3Time5.setStyle("");
        labelDay3Time6.setStyle("");
        labelDay3Time7.setStyle("");
        labelDay4Time1.setStyle("");
        labelDay4Time2.setStyle("");
        labelDay4Time3.setStyle("");
        labelDay4Time4.setStyle("");
        labelDay4Time5.setStyle("");
        labelDay4Time6.setStyle("");
        labelDay4Time7.setStyle("");

    }

    public void addOptionToFacultyShowComboBox(){
        facultyShowComboBox.getItems().clear();

        FacultyInfo temp = AddRemoveSearchFaculty.facultyHeadPointer;
        while(temp!=null){
            facultyShowComboBox.getItems().add(temp.facultyName);
            temp=temp.next;
        }

        new AutoCompleteComboBoxListener<>(facultyShowComboBox);
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
