import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.awt.event.ActionEvent;

import static java.awt.SystemColor.window;

/**
 * Created by mimtiaze on 03-Jul-16.
 */
public class logInController {
    @FXML
    public TextField logInNameField;
    public Label logInNameLbl;
    public Label logInPassLbl;
    public PasswordField logInPassfield;
    public Button logInButton;
    public Label logInErrorMessege;
    private Stage logInStage;
    private Scene firstScene;
    private Parent firstSceneAdminRoot;
    private Parent firstSceneUserRoot;

    public static String selectedTitleFromAcourseShowComboBoxAdmin;
    public static FacultyInfo activeFacultyOnAdminComboBox;
    public static CourseToLinkedList activeCourse;

    public static boolean isUser;
    public static CourseToLinkedListOthersInfo isUserRequestedList;
    public static CourseToLinkedListOthersInfo isUserTempList;

    //Determine which faculty is now selected
    public static String nowSelectedFaculty;
    public static FacultyInfo userFacultyInfo;

    //Set the boolean button for coloring and fixing course according to time
    public static boolean[] theoryButtonSelected=new boolean[28];
    public static boolean[] labButtonSelected=new boolean[16];


    public void funcForNameField(){
        logInPassfield.requestFocus();
    }

    public void keyaction(KeyEvent event) {
        if(event.getCode().equals(KeyCode.TAB)){
            logInPassfield.requestFocus();
        }
    }


    public void funcForPassField(){
        funcForLogInButton();
    }

    public void funcForLogInButton(){
        logInCheck();
    }

    public void logInCheckTest() {
        System.out.println(logInNameField.getText());
        System.out.println(logInPassfield.getText());
    }

    public void logInCheck(){

        boolean ChangeScene=false;


        System.out.println(logInNameField.getText());
        System.out.println(logInPassfield.getText());

        FacultyInfo temp=AddRemoveSearchFaculty.searchForLogInFaculty(logInNameField.getText(),logInPassfield.getText());
        boolean wrongPassword=AddRemoveSearchFaculty.searchForWrongPasswordFaculty(logInNameField.getText(),logInPassfield.getText());

        // Access for Developer
        if(logInNameField.getText().equals("mimtiaze") && logInPassfield.getText().equals("mAruf")){
            try {
                firstSceneAdminRoot = FXMLLoader.load(getClass().getResource("firstSceneAdmin.fxml"));
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
            firstScene=new Scene(firstSceneAdminRoot,850,500);
            ChangeScene=true;
            isUser=false;
            isUserRequestedList=null;
        }
        else if(logInNameField.getText().equals("mimtiaze") && logInPassfield.getText().equals("marUf")){
            try {
                firstSceneAdminRoot = FXMLLoader.load(getClass().getResource("firstSceneUser.fxml"));
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
            firstScene=new Scene(firstSceneAdminRoot,850,500);
            ChangeScene=true;
            isUser=false;
            isUserRequestedList=null;
        }
        else if(wrongPassword){
            logInErrorMessege.setText("Password not correct !");
        }
        else if(temp==null){
            logInErrorMessege.setText("Faculty not found !");
        }
        else if(temp.isAdmin){
            try {
                firstSceneAdminRoot = FXMLLoader.load(getClass().getResource("firstSceneAdmin.fxml"));
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
            firstScene=new Scene(firstSceneAdminRoot,850,500);
            ChangeScene=true;
            isUser=false;
            isUserRequestedList=null;
        }
        else{
            try {
                firstSceneUserRoot = FXMLLoader.load(getClass().getResource("firstSceneUser.fxml"));
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
            firstScene=new Scene(firstSceneUserRoot,850,500);
            ChangeScene=true;
            isUser=true;

            userFacultyInfo=temp;

            // Copying user requested List
            CourseToLinkedListOthersInfo tempRequestedList=temp.requestedSectionOfFaculty;
            while(tempRequestedList!=null){

                if(isUserRequestedList==null){
                    isUserRequestedList=new CourseToLinkedListOthersInfo();
                    isUserRequestedList.code=tempRequestedList.code;
                    isUserRequestedList.title=tempRequestedList.title;
                    isUserRequestedList.section=tempRequestedList.section;
                    isUserRequestedList.day=tempRequestedList.day;
                    isUserRequestedList.time=tempRequestedList.time;
                    isUserRequestedList.timeStart=tempRequestedList.timeStart;
                    isUserRequestedList.timeEnd=tempRequestedList.timeEnd;
                    isUserRequestedList.room=tempRequestedList.room;
                    isUserRequestedList.faculty=tempRequestedList.faculty;
                    isUserRequestedList.credit=tempRequestedList.credit;
                    isUserRequestedList.isAssigned=tempRequestedList.isAssigned;
                    isUserRequestedList.campus=tempRequestedList.campus;
                    isUserRequestedList.dept=tempRequestedList.dept;
                    isUserRequestedList.islabClass=tempRequestedList.islabClass;
                    isUserRequestedList.timeSlot=tempRequestedList.timeSlot;
                    isUserRequestedList.labTimeSlot=tempRequestedList.labTimeSlot;
                    isUserRequestedList.day1=tempRequestedList.day1;
                    isUserRequestedList.day2=tempRequestedList.day2;
                    isUserRequestedList.next=null;

                }
                else {
                    CourseToLinkedListOthersInfo tempList;
                    tempList = isUserRequestedList;
                    while (tempList.next != null)
                        tempList = tempList.next;

                    CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
                    newTemp.code=tempRequestedList.code;
                    newTemp.title=tempRequestedList.title;
                    newTemp.section=tempRequestedList.section;
                    newTemp.day=tempRequestedList.day;
                    newTemp.time=tempRequestedList.time;
                    newTemp.timeStart=tempRequestedList.timeStart;
                    newTemp.timeEnd=tempRequestedList.timeEnd;
                    newTemp.room=tempRequestedList.room;
                    newTemp.faculty=tempRequestedList.faculty;
                    newTemp.credit=tempRequestedList.credit;
                    newTemp.isAssigned=tempRequestedList.isAssigned;
                    newTemp.campus=tempRequestedList.campus;
                    newTemp.dept=tempRequestedList.dept;
                    newTemp.islabClass=tempRequestedList.islabClass;
                    newTemp.timeSlot=tempRequestedList.timeSlot;
                    newTemp.labTimeSlot=tempRequestedList.labTimeSlot;
                    newTemp.day1=tempRequestedList.day1;
                    newTemp.day2=tempRequestedList.day2;
                    newTemp.next=null;

                    tempList.next = newTemp;
                }

                tempRequestedList=tempRequestedList.next;
            }

            // Copying user temp List
            CourseToLinkedListOthersInfo tempTempList=temp.tempSectionOfFaculty;
            while(tempTempList!=null){

                if(isUserTempList==null){
                    isUserTempList=new CourseToLinkedListOthersInfo();
                    isUserTempList.code=tempTempList.code;
                    isUserTempList.title=tempTempList.title;
                    isUserTempList.section=tempTempList.section;
                    isUserTempList.day=tempTempList.day;
                    isUserTempList.time=tempTempList.time;
                    isUserTempList.timeStart=tempTempList.timeStart;
                    isUserTempList.timeEnd=tempTempList.timeEnd;
                    isUserTempList.room=tempTempList.room;
                    isUserTempList.faculty=tempTempList.faculty;
                    isUserTempList.credit=tempTempList.credit;
                    isUserTempList.isAssigned=tempTempList.isAssigned;
                    isUserTempList.campus=tempTempList.campus;
                    isUserTempList.dept=tempTempList.dept;
                    isUserTempList.islabClass=tempTempList.islabClass;
                    isUserTempList.timeSlot=tempTempList.timeSlot;
                    isUserTempList.labTimeSlot=tempTempList.labTimeSlot;
                    isUserTempList.day1=tempTempList.day1;
                    isUserTempList.day2=tempTempList.day2;
                    isUserTempList.next=null;

                }
                else {
                    CourseToLinkedListOthersInfo tempList;
                    tempList = isUserTempList;
                    while (tempList.next != null)
                        tempList = tempList.next;

                    CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
                    newTemp.code=tempTempList.code;
                    newTemp.title=tempTempList.title;
                    newTemp.section=tempTempList.section;
                    newTemp.day=tempTempList.day;
                    newTemp.time=tempTempList.time;
                    newTemp.timeStart=tempTempList.timeStart;
                    newTemp.timeEnd=tempTempList.timeEnd;
                    newTemp.room=tempTempList.room;
                    newTemp.faculty=tempTempList.faculty;
                    newTemp.credit=tempTempList.credit;
                    newTemp.isAssigned=tempTempList.isAssigned;
                    newTemp.campus=tempTempList.campus;
                    newTemp.dept=tempTempList.dept;
                    newTemp.islabClass=tempTempList.islabClass;
                    newTemp.timeSlot=tempTempList.timeSlot;
                    newTemp.labTimeSlot=tempTempList.labTimeSlot;
                    newTemp.day1=tempTempList.day1;
                    newTemp.day2=tempTempList.day2;
                    newTemp.next=null;

                    tempList.next = newTemp;
                }

                tempTempList=tempTempList.next;
            }
        }

        if(ChangeScene) {
            nowSelectedFaculty=logInNameField.getText();

            updateTheoryLabCounterLabel();

            logInStage = (Stage) logInNameLbl.getScene().getWindow();
            logInStage.setScene(firstScene);
            logInStage.centerOnScreen();
            logInStage.setResizable(false);
            logInStage.show();
        }
    }

    public static void updateTheoryLabCounterLabel(){
        for(int i=0;i<28;i++){  //theory button have 28 boolean
            logInController.theoryButtonSelected[i]=false;
        }
        for(int i=0;i<16;i++){  //lab button have 16 boolean
            logInController.labButtonSelected[i]=false;
        }

        //theoryButtonSelected[0];
        FacultyInfo tempForSettingValueOfButtonBoolean=AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if(tempForSettingValueOfButtonBoolean!=null) {
            CourseToLinkedListOthersInfo tempForbuttonBoolean = tempForSettingValueOfButtonBoolean.firstSectionOfFaculty;
            while (tempForbuttonBoolean != null) {
                if (tempForbuttonBoolean.islabClass) {
                    logInController.labButtonSelected[((tempForbuttonBoolean.day1 - 1) * 4) + tempForbuttonBoolean.labTimeSlot - 1] = true;
                    logInController.theoryButtonSelected[((tempForbuttonBoolean.day1 - 1) * 7) + tempForbuttonBoolean.timeSlot - 1] = true;

                    if (tempForbuttonBoolean.timeSlot % 2 == 0)
                        logInController.theoryButtonSelected[((tempForbuttonBoolean.day1 - 1) * 7) + tempForbuttonBoolean.timeSlot - 2] = true;
                    else
                        logInController.theoryButtonSelected[((tempForbuttonBoolean.day1 - 1) * 7) + tempForbuttonBoolean.timeSlot] = true;

                } else {
                    logInController.theoryButtonSelected[((tempForbuttonBoolean.day1 - 1) * 7) + tempForbuttonBoolean.timeSlot - 1] = true;
                    logInController.theoryButtonSelected[((tempForbuttonBoolean.day2 - 1) * 7) + tempForbuttonBoolean.timeSlot - 1] = true;

                    int tempLabTimeSlot = 0;
                    if (tempForbuttonBoolean.timeSlot == 1)
                        tempLabTimeSlot = 1;
                    else if (tempForbuttonBoolean.timeSlot == 2)
                        tempLabTimeSlot = 1;
                    else if (tempForbuttonBoolean.timeSlot == 3)
                        tempLabTimeSlot = 2;
                    else if (tempForbuttonBoolean.timeSlot == 4)
                        tempLabTimeSlot = 2;
                    else if (tempForbuttonBoolean.timeSlot == 5)
                        tempLabTimeSlot = 3;
                    else if (tempForbuttonBoolean.timeSlot == 6)
                        tempLabTimeSlot = 3;
                    else if (tempForbuttonBoolean.timeSlot == 7)
                        tempLabTimeSlot = 4;

                    logInController.labButtonSelected[((tempForbuttonBoolean.day1 - 1) * 4) + tempLabTimeSlot] = true;
                    logInController.labButtonSelected[((tempForbuttonBoolean.day2 - 1) * 4) + tempLabTimeSlot] = true;


                }
                tempForbuttonBoolean = tempForbuttonBoolean.next;
            }

        }
    }
}
