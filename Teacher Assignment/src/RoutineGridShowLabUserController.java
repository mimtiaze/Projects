import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.StringTokenizer;

/**
 * Created by mimtiaze on 14-Jul-16.
 */
public class RoutineGridShowLabUserController {

    public Label copyRightLabel;

    public ComboBox<String> courseShowComboBox;
    public ComboBox<String> facultyShowComboBox;

    public static CourseInfo[] coursesInTheGridShowAdminController;
    public static int lengthOfCoursesInTheGridShowAdminController;

    public static String[] tempCourseList;
    public static int tempCourseListLength;

    public ComboBox<String> TheoryButtonDay1Time1;
    public ComboBox TheoryButtonDay1Time2;
    public ComboBox<String> TheoryButtonDay1Time3;
    public ComboBox TheoryButtonDay1Time4;
    public ComboBox<String> TheoryButtonDay1Time5;
    public ComboBox TheoryButtonDay1Time6;
    public ComboBox<String> TheoryButtonDay1Time7;
    public ComboBox<String> TheoryButtonDay2Time1;
    public ComboBox TheoryButtonDay2Time2;
    public ComboBox<String> TheoryButtonDay2Time3;
    public ComboBox TheoryButtonDay2Time4;
    public ComboBox<String> TheoryButtonDay2Time5;
    public ComboBox<String> TheoryButtonDay2Time6;
    public ComboBox<String> TheoryButtonDay2Time7;
    public ComboBox<String> TheoryButtonDay3Time1;
    public ComboBox TheoryButtonDay3Time2;
    public ComboBox<String> TheoryButtonDay3Time3;
    public ComboBox TheoryButtonDay3Time4;
    public ComboBox<String> TheoryButtonDay3Time5;
    public ComboBox TheoryButtonDay3Time6;
    public ComboBox<String> TheoryButtonDay3Time7;
    public ComboBox<String> TheoryButtonDay4Time1;
    public ComboBox TheoryButtonDay4Time2;
    public ComboBox<String> TheoryButtonDay4Time3;
    public ComboBox TheoryButtonDay4Time4;
    public ComboBox<String> TheoryButtonDay4Time5;
    public ComboBox TheoryButtonDay4Time6;
    public ComboBox<String> TheoryButtonDay4Time7;

    public Label facultyTheoryCounter;
    public Label facultyLabCounter;
    public Label activeFacultyNameLabel;

    public void initialize(){
        //addOptionToFacultyComboBox();
        addOptionToComboBox();
    }


    public void actionForComboBox() {

        logInController.selectedTitleFromAcourseShowComboBoxAdmin = courseShowComboBox.getValue();
        System.out.println(logInController.selectedTitleFromAcourseShowComboBoxAdmin);
        activeFacultyNameLabel.setText(logInController.nowSelectedFaculty);


        CourseToLinkedListOthersInfo tempCourseToLinkedListOthersInfo;
        updateTheoryLabCounterLabel();

        logInController.activeCourse = AddSearchCourse.searchCourseWithTitle(logInController.selectedTitleFromAcourseShowComboBoxAdmin);
        //logInController.activeFacultyOnAdminComboBox = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);

        if (logInController.activeCourse != null && logInController.userFacultyInfo != null) {
            if (!logInController.activeCourse.isLab)
                goToTheoryScene();
        }


        TheoryButtonDay1Time1.setPromptText("");
        TheoryButtonDay1Time1.getItems().clear();
        TheoryButtonDay1Time3.setPromptText("");
        TheoryButtonDay1Time3.getItems().clear();
        TheoryButtonDay1Time5.setPromptText("");
        TheoryButtonDay1Time5.getItems().clear();
        TheoryButtonDay1Time7.setPromptText("");
        TheoryButtonDay1Time7.getItems().clear();


        TheoryButtonDay2Time1.setPromptText("");
        TheoryButtonDay2Time1.getItems().clear();
        TheoryButtonDay2Time3.setPromptText("");
        TheoryButtonDay2Time3.getItems().clear();
        TheoryButtonDay2Time5.setPromptText("");
        TheoryButtonDay2Time5.getItems().clear();
        TheoryButtonDay2Time7.setPromptText("");
        TheoryButtonDay2Time7.getItems().clear();


        TheoryButtonDay3Time1.setPromptText("");
        TheoryButtonDay3Time1.getItems().clear();
        TheoryButtonDay3Time3.setPromptText("");
        TheoryButtonDay3Time3.getItems().clear();
        TheoryButtonDay3Time5.setPromptText("");
        TheoryButtonDay3Time5.getItems().clear();
        TheoryButtonDay3Time7.setPromptText("");
        TheoryButtonDay3Time7.getItems().clear();


        TheoryButtonDay4Time1.setPromptText("");
        TheoryButtonDay4Time1.getItems().clear();
        TheoryButtonDay4Time3.setPromptText("");
        TheoryButtonDay4Time3.getItems().clear();
        TheoryButtonDay4Time5.setPromptText("");
        TheoryButtonDay4Time5.getItems().clear();
        TheoryButtonDay4Time7.setPromptText("");
        TheoryButtonDay4Time7.getItems().clear();


        if (logInController.selectedTitleFromAcourseShowComboBoxAdmin != null && logInController.userFacultyInfo != null) {
            CourseToLinkedListOthersInfo timeConflictsoCoursesForFaculty;

            if (logInController.activeCourse != null) {

                boolean time12HaveTheoryClass=false;
                boolean time14HaveTheoryClass=false;
                boolean time16HaveTheoryClass=false;
                boolean time22HaveTheoryClass=false;
                boolean time24HaveTheoryClass=false;
                boolean time26HaveTheoryClass=false;
                boolean time32HaveTheoryClass=false;
                boolean time34HaveTheoryClass=false;
                boolean time36HaveTheoryClass=false;
                boolean time42HaveTheoryClass=false;
                boolean time44HaveTheoryClass=false;
                boolean time46HaveTheoryClass=false;

                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 2)) != null) {
                    TheoryButtonDay1Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time12HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 4)) != null) {
                    TheoryButtonDay1Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time14HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 6)) != null) {
                    TheoryButtonDay1Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time16HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 2)) != null) {
                    TheoryButtonDay2Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time22HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 4)) != null) {
                    TheoryButtonDay2Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time24HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 6)) != null) {
                    TheoryButtonDay2Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time26HaveTheoryClass=true;
                }

                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 2)) != null) {
                    TheoryButtonDay3Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay3Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time32HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 4)) != null) {
                    TheoryButtonDay3Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay3Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time34HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 6)) != null) {
                    TheoryButtonDay3Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay3Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time36HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 2)) != null) {
                    TheoryButtonDay4Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay4Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time42HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 4)) != null) {
                    TheoryButtonDay4Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay4Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time44HaveTheoryClass=true;
                }
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 6)) != null) {
                    TheoryButtonDay4Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay4Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                    time46HaveTheoryClass=true;
                }




                //Button11 (11 means day1Time1)
                /*if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 1)) != null) {
                    TheoryButtonDay1Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time1.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 2))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 1)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time1.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 1)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time1.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time1.setPromptText(tempStrForPrompText);
                    }
                }


                //Button13
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 3)) != null) {
                    TheoryButtonDay1Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time3.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 4))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 3)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time3.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 3)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time3.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time3.setPromptText(tempStrForPrompText);
                    }
                }


                //Button15
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 5)) != null) {
                    TheoryButtonDay1Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time5.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 6))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 5)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time5.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 5)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time5.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time5.setPromptText(tempStrForPrompText);
                    }
                }


                //Button17
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 7)) != null) {
                    TheoryButtonDay1Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time7.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time7.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 7)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time7.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 21 (21 means day2Time1)
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 1)) != null) {
                    TheoryButtonDay2Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time1.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 2))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 1)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time1.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 1)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time1.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time1.setPromptText(tempStrForPrompText);
                    }
                }


                //Button23
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 3)) != null) {
                    TheoryButtonDay2Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time3.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 4))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 3)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time3.getItems().add(secAndCampus);


                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 3)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time3.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time3.setPromptText(tempStrForPrompText);


                    }
                }


                //Button25
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 5)) != null) {
                    TheoryButtonDay2Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time5.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 6))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 5)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time5.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 5)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time6.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time5.setPromptText(tempStrForPrompText);
                    }
                }


                //Button27
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 7)) != null) {
                    TheoryButtonDay2Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time7.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time7.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 7)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time7.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 31 (11 means day3Time1)
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 1)) != null) {
                    TheoryButtonDay3Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time1.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 2))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 1)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time1.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 1)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time1.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time1.setPromptText(tempStrForPrompText);
                    }
                }


                //Button33
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 3)) != null) {
                    TheoryButtonDay3Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time3.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 4))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 3)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time3.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 3)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time3.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time3.setPromptText(tempStrForPrompText);
                    }
                }


                //Button35
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 5)) != null) {
                    TheoryButtonDay3Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time5.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 6))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 5)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time5.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 5)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time5.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time5.setPromptText(tempStrForPrompText);
                    }
                }


                //Button37
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 7)) != null) {
                    TheoryButtonDay3Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time7.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time7.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 7)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time7.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 41 (11 means day4Time1)
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 1)) != null) {
                    TheoryButtonDay4Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time1.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 2))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 1)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time1.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 1)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time1.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time1.setPromptText(tempStrForPrompText);
                    }
                }


                //Button43
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 3)) != null) {
                    TheoryButtonDay4Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time3.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 4))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 3)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time3.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 3)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time3.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time3.setPromptText(tempStrForPrompText);
                    }
                }


                //Button45
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 5)) != null) {
                    TheoryButtonDay4Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time5.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else if( (logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 6))==null){
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 5)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time5.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 5)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time5.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time5.setPromptText(tempStrForPrompText);
                    }
                }


                //Button47
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 7)) != null) {
                    TheoryButtonDay4Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time7.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time7.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 7)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time7.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time7.setPromptText(tempStrForPrompText);
                    }
                }*/


                //Button 11 (11 means day1Time1)
                if(!time12HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 1)) != null) {
                        TheoryButtonDay1Time1.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay1Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay1Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 1)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay1Time1.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time1.getItems().addAll(secAndCampus );
                                TheoryButtonDay1Time1.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 1)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay1Time1.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay1Time1.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay1Time1.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button13
                if(!time14HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 3)) != null) {
                        TheoryButtonDay1Time3.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay1Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay1Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 3)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay1Time3.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time3.getItems().addAll(secAndCampus );
                                TheoryButtonDay1Time3.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 3)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay1Time3.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay1Time3.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay1Time3.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button15
                if(!time16HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 5)) != null) {
                        TheoryButtonDay1Time5.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay1Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay1Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 5)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay1Time5.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time5.getItems().addAll(secAndCampus );
                                TheoryButtonDay1Time5.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 5)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay1Time5.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay1Time5.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay1Time5.setPromptText(tempStrForPrompText);
                        }
                    }
                }



                //Button17
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(1, 7)) != null) {
                    TheoryButtonDay1Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time7.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec;
                        String secAndCampus;
                        boolean printSlash = false;
                        boolean promTextEditable = true;
                        if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                            tempStrForPrompText = "";
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                            printSlash = true;
                            TheoryButtonDay1Time7.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay1Time7.getItems().addAll(secAndCampus );
                            TheoryButtonDay1Time7.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 7)) != null) {
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                if (printSlash)
                                    tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                else {
                                    tempStrForPrompText = prevSec;
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay1Time7.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time7.getItems().addAll(secAndCampus );
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay1Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 21 (21 means day2Time1)
                if(!time22HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 1)) != null) {
                        TheoryButtonDay2Time1.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay2Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay2Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 1)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay2Time1.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time1.getItems().addAll(secAndCampus );
                                TheoryButtonDay2Time1.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 1)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay2Time1.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay2Time1.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay2Time1.setPromptText(tempStrForPrompText);
                        }
                    }
                }


                //Button23
                if(!time24HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 3)) != null) {
                        TheoryButtonDay2Time3.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay2Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay2Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 3)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay2Time3.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time3.getItems().addAll(secAndCampus );
                                TheoryButtonDay2Time3.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 3)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay2Time3.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay2Time3.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay2Time3.setPromptText(tempStrForPrompText);
                        }
                    }
                }


                //Button25
                if(!time26HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 5)) != null) {
                        TheoryButtonDay2Time5.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay2Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay2Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 5)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay2Time5.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time5.getItems().addAll(secAndCampus );
                                TheoryButtonDay2Time5.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 5)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay2Time5.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay2Time5.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay2Time5.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button27
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(2, 7)) != null) {
                    TheoryButtonDay2Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time7.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec;
                        String secAndCampus;
                        boolean printSlash = false;
                        boolean promTextEditable = true;
                        if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                            tempStrForPrompText = "";
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                            printSlash = true;
                            TheoryButtonDay2Time7.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay2Time7.getItems().addAll(secAndCampus );
                            TheoryButtonDay2Time7.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 7)) != null) {
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                if (printSlash)
                                    tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                else {
                                    tempStrForPrompText = prevSec;
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay2Time7.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time7.getItems().addAll(secAndCampus );
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 31 (11 means day3Time1)
                if(!time32HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 1)) != null) {
                        TheoryButtonDay3Time1.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 1)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay3Time1.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time1.getItems().addAll(secAndCampus );
                                TheoryButtonDay3Time1.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 1)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay3Time1.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time1.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time1.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button33
                if(!time34HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 3)) != null) {
                        TheoryButtonDay3Time3.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 3)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay3Time3.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time3.getItems().addAll(secAndCampus );
                                TheoryButtonDay3Time3.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 3)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay3Time3.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time3.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time3.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button35
                if(!time36HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 5)) != null) {
                        TheoryButtonDay3Time5.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 5)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay3Time5.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time5.getItems().addAll(secAndCampus );
                                TheoryButtonDay3Time5.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 5)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay3Time5.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time5.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time5.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button37
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(3, 7)) != null) {
                    TheoryButtonDay3Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time7.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay3Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec;
                        String secAndCampus;
                        boolean printSlash = false;
                        boolean promTextEditable = true;
                        if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                            tempStrForPrompText = "";
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                            printSlash = true;
                            TheoryButtonDay3Time7.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay3Time7.getItems().addAll(secAndCampus );
                            TheoryButtonDay3Time7.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 7)) != null) {
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                if (printSlash)
                                    tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                else {
                                    tempStrForPrompText = prevSec;
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay3Time7.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time7.getItems().addAll(secAndCampus );
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay3Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 41 (11 means day4Time1)
                if(!time42HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 1)) != null) {
                        TheoryButtonDay4Time1.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 1)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay4Time1.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time1.getItems().addAll(secAndCampus );
                                TheoryButtonDay4Time1.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 1)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay4Time1.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time1.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time1.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button43
                if(!time44HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 3)) != null) {
                        TheoryButtonDay4Time3.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 3)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay4Time3.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time3.getItems().addAll(secAndCampus );
                                TheoryButtonDay4Time3.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 3)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay4Time3.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time3.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time3.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button45
                if(!time46HaveTheoryClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 5)) != null) {
                        TheoryButtonDay4Time5.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabel();
                    } else {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 5)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec;
                            String secAndCampus;
                            boolean printSlash = false;
                            boolean promTextEditable = true;
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                tempStrForPrompText = "";
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                                printSlash = true;
                                TheoryButtonDay4Time5.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time5.getItems().addAll(secAndCampus );
                                TheoryButtonDay4Time5.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 5)) != null) {
                                if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                    if (printSlash)
                                        tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                    else {
                                        tempStrForPrompText = prevSec;
                                        printSlash = true;
                                    }
                                    secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                    TheoryButtonDay4Time5.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time5.getItems().addAll(secAndCampus );
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time5.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button47
                if ((timeConflictsoCoursesForFaculty = logInController.userFacultyInfo.searchSectionWIthDayAndTimeSlot(4, 7)) != null) {
                    TheoryButtonDay4Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time7.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay4Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec;
                        String secAndCampus;
                        boolean printSlash = false;
                        boolean promTextEditable = true;
                        if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                            tempStrForPrompText = "";
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                            printSlash = true;
                            TheoryButtonDay4Time7.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay4Time7.getItems().addAll(secAndCampus );
                            TheoryButtonDay4Time7.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 7)) != null) {
                            if (tempCourseToLinkedListOthersInfo.faculty == null || tempCourseToLinkedListOthersInfo.faculty.equals("")) {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                // This thing is for printing slash sign, if I dont give the condition, slash will aprear at the begining, I dont want this :3
                                if (printSlash)
                                    tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                else {
                                    tempStrForPrompText = prevSec;
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay4Time7.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time7.getItems().addAll(secAndCampus );
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay4Time7.setPromptText(tempStrForPrompText);
                    }
                }




            }
        }
    }

    public void mouseMoveAction(){
        courseShowComboBox.setValue(logInController.selectedTitleFromAcourseShowComboBoxAdmin);
        //facultyShowComboBox.setValue(logInController.nowSelectedFaculty);
        actionForComboBox();
    }


    public void goToTheoryScene(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("routineGridShowUser.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForFacultyShowComboBox(){
        facultyTheoryCounter.setText("-");
        facultyLabCounter.setText("-");

        logInController.nowSelectedFaculty = facultyShowComboBox.getValue();
        FacultyInfo tempForCoutineClass = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if(tempForCoutineClass!=null) {
            String tempCounter = Integer.toString(tempForCoutineClass.theory);
            facultyTheoryCounter.setText(tempCounter);
            tempCounter = Integer.toString(tempForCoutineClass.lab);
            facultyLabCounter.setText(tempCounter);
        }
        //updateTheoryLabCounterLabel();
    }

    public void addOptionToFacultyComboBox(){
        /*facultyShowComboBox.getItems().clear();

        FacultyInfo temp = AddRemoveSearchFaculty.facultyHeadPointer;
        while(temp!=null){
            facultyShowComboBox.getItems().add(temp.facultyName);
            temp=temp.next;
        }

        new AutoCompleteComboBoxListener<>(facultyShowComboBox);
        updateTheoryLabCounterLabel();
        actionForComboBox();*/

        facultyTheoryCounter.setText("-");
        facultyLabCounter.setText("-");

        activeFacultyNameLabel.setText(logInController.nowSelectedFaculty);
        updateTheoryLabCounterLabel();
    }



    public void addOptionToComboBox(){
        courseShowComboBox.getItems().removeAll(courseShowComboBox.getItems());

        CourseToLinkedList temp = AddSearchCourse.courseHeadPointer;
        while(temp!=null){
            courseShowComboBox.getItems().add(temp.title);
            temp=temp.next;
        }
        new AutoCompleteComboBoxListener<>(courseShowComboBox);
        //actionForComboBox();

    }

    public void updateTheoryLabCounterLabel(){
        FacultyInfo tempForCoutineClass = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if(tempForCoutineClass!=null) {
            String tempCounter = Integer.toString(tempForCoutineClass.tempTheory);
            facultyTheoryCounter.setText(tempCounter);
            tempCounter = Integer.toString(tempForCoutineClass.tempLab);
            facultyLabCounter.setText(tempCounter);
        }
        /*SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();*/
    }

    public void actionForTheoryButtonDay1Time1(){
        String command=(String)TheoryButtonDay1Time1.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay1Time1.getItems().get(0);
                String tempTitle=TheoryButtonDay1Time1.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }

    public void actionForTheoryButtonDay1Time3(){
        String command=(String)TheoryButtonDay1Time3.getValue();

        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay1Time3.getItems().get(0);
                String tempTitle=TheoryButtonDay1Time3.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay1Time5(){
        String command=(String)TheoryButtonDay1Time5.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay1Time5.getItems().get(0);
                String tempTitle=TheoryButtonDay1Time5.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }



    public void actionForTheoryButtonDay1Time7(){
        String command=(String)TheoryButtonDay1Time7.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay1Time7.getItems().get(0);
                String tempTitle=TheoryButtonDay1Time7.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }

    public void actionForTheoryButtonDay2Time1(){
        String command=(String)TheoryButtonDay2Time1.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay2Time1.getItems().get(0);
                String tempTitle=TheoryButtonDay2Time1.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay2Time3(){
        String command=(String)TheoryButtonDay2Time3.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay2Time3.getItems().get(0);
                String tempTitle=TheoryButtonDay2Time3.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay2Time5(){
        String command=(String)TheoryButtonDay2Time5.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay2Time5.getItems().get(0);
                String tempTitle=TheoryButtonDay2Time5.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay2Time7(){
        String command=(String)TheoryButtonDay2Time7.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay2Time7.getItems().get(0);
                String tempTitle=TheoryButtonDay2Time7.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay3Time1(){
        String command=(String)TheoryButtonDay3Time1.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay3Time1.getItems().get(0);
                String tempTitle=TheoryButtonDay3Time1.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }

    public void actionForTheoryButtonDay3Time3(){
        String command=(String)TheoryButtonDay3Time3.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay3Time3.getItems().get(0);
                String tempTitle=TheoryButtonDay3Time3.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay3Time5(){
        String command=(String)TheoryButtonDay3Time5.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay3Time5.getItems().get(0);
                String tempTitle=TheoryButtonDay3Time5.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay3Time7(){
        String command=(String)TheoryButtonDay3Time7.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay3Time7.getItems().get(0);
                String tempTitle=TheoryButtonDay3Time7.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay4Time1(){
        String command=(String)TheoryButtonDay4Time1.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay4Time1.getItems().get(0);
                String tempTitle=TheoryButtonDay4Time1.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay4Time3(){
        String command=(String)TheoryButtonDay4Time3.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay4Time3.getItems().get(0);
                String tempTitle=TheoryButtonDay4Time3.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay4Time5(){
        String command=(String)TheoryButtonDay4Time5.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay4Time5.getItems().get(0);
                String tempTitle=TheoryButtonDay4Time5.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }


    public void actionForTheoryButtonDay4Time7(){
        String command=(String)TheoryButtonDay4Time7.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay4Time7.getItems().get(0);
                String tempTitle=TheoryButtonDay4Time7.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                //AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty="";

                try {
                    logInController.userFacultyInfo.removeCourseWithTitleAndSectionInRequestedList(tempTitle, tempSec);
                    logInController.userFacultyInfo.removeCourseFromTempList(tempTitle, tempSec);

                }catch(Exception e){
                    e.printStackTrace();
                }
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.userFacultyInfo.addCourseWithListInRequestedList(logInController.activeCourse.searchSection(temp));
                    logInController.userFacultyInfo.addCourseWithListInTempList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    //tempSec.faculty=logInController.userFacultyInfo.facultyName;
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }



    public void mouseClickedTheoryButtonDay1Time1(){

    }
    public void mouseClickedTheoryButtonDay1Time2(){

    }
    public void mouseClickedTheoryButtonDay1Time3(){

    }
    public void mouseClickedTheoryButtonDay1Time4(){

    }
    public void mouseClickedTheoryButtonDay1Time5(){

    }
    public void mouseClickedTheoryButtonDay1Time6(){

    }
    public void mouseClickedTheoryButtonDay1Time7(){

    }
    public void mouseClickedTheoryButtonDay2Time1(){

    }
    public void mouseClickedTheoryButtonDay2Time2(){

    }
    public void mouseClickedTheoryButtonDay2Time3(){

    }
    public void mouseClickedTheoryButtonDay2Time4(){

    }
    public void mouseClickedTheoryButtonDay2Time5(){

    }
    public void mouseClickedTheoryButtonDay2Time6(){

    }
    public void mouseClickedTheoryButtonDay2Time7(){

    }
    public void mouseClickedTheoryButtonDay3Time1(){

    }
    public void mouseClickedTheoryButtonDay3Time2(){

    }
    public void mouseClickedTheoryButtonDay3Time3(){

    }
    public void mouseClickedTheoryButtonDay3Time4(){

    }
    public void mouseClickedTheoryButtonDay3Time5(){

    }
    public void mouseClickedTheoryButtonDay3Time6(){

    }
    public void mouseClickedTheoryButtonDay3Time7(){

    }
    public void mouseClickedTheoryButtonDay4Time1(){

    }
    public void mouseClickedTheoryButtonDay4Time2(){

    }
    public void mouseClickedTheoryButtonDay4Time3(){

    }
    public void mouseClickedTheoryButtonDay4Time4(){

    }
    public void mouseClickedTheoryButtonDay4Time5(){

    }
    public void mouseClickedTheoryButtonDay4Time6(){

    }
    public void mouseClickedTheoryButtonDay4Time7(){

    }


    @FXML
    private Stage chooseCourseStage;
    private Scene chooseCourseUserScene;
    private Parent chooseCourseUserRoot;

    //public Label copyRightLabel;

    public void actionForChooseSectionMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("routineGridSHowUser.fxml"));
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
