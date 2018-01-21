import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;

import java.util.StringTokenizer;

/**
 * Created by mimtiaze on 04-Jul-16.
 */
public class RoutineGridShowAdminController {
    @FXML

    public ComboBox courseShowComboBox;
    public ComboBox facultyShowComboBox;

    public static CourseInfo[] coursesInTheGridShowAdminController;
    public static int lengthOfCoursesInTheGridShowAdminController;

    public static String[] tempCourseList;
    public static int tempCourseListLength;

    public ComboBox<String> TheoryButtonDay1Time1;
    public ComboBox<String> TheoryButtonDay1Time2;
    public ComboBox<String> TheoryButtonDay1Time3;
    public ComboBox<String> TheoryButtonDay1Time4;
    public ComboBox<String> TheoryButtonDay1Time5;
    public ComboBox<String> TheoryButtonDay1Time6;
    public ComboBox<String> TheoryButtonDay1Time7;
    public ComboBox<String> TheoryButtonDay2Time1;
    public ComboBox<String> TheoryButtonDay2Time2;
    public ComboBox<String> TheoryButtonDay2Time3;
    public ComboBox<String> TheoryButtonDay2Time4;
    public ComboBox<String> TheoryButtonDay2Time5;
    public ComboBox<String> TheoryButtonDay2Time6;
    public ComboBox<String> TheoryButtonDay2Time7;
    public ComboBox<String> TheoryButtonDay3Time1;
    public ComboBox<String> TheoryButtonDay3Time2;
    public ComboBox<String> TheoryButtonDay3Time3;
    public ComboBox<String> TheoryButtonDay3Time4;
    public ComboBox<String> TheoryButtonDay3Time5;
    public ComboBox<String> TheoryButtonDay3Time6;
    public ComboBox<String> TheoryButtonDay3Time7;
    public ComboBox<String> TheoryButtonDay4Time1;
    public ComboBox<String> TheoryButtonDay4Time2;
    public ComboBox<String> TheoryButtonDay4Time3;
    public ComboBox<String> TheoryButtonDay4Time4;
    public ComboBox<String> TheoryButtonDay4Time5;
    public ComboBox<String> TheoryButtonDay4Time6;
    public ComboBox<String> TheoryButtonDay4Time7;

    public Label facultyTheoryCounter;
    public Label facultyLabCounter;

    public Label labLimitOverLabel;
    public Label theoryLimitOverLabel;


    /*public RoutineGridShowAdminController(){
        if(logInController.selectedTitleFromAcourseShowComboBoxAdmin!=null)
            courseShowComboBox.setValue(logInController.selectedTitleFromAcourseShowComboBoxAdmin);
        if(logInController.nowSelectedFaculty!=null && facultyShowComboBox!=null)
            facultyShowComboBox.setValue(logInController.nowSelectedFaculty);
    }*/

    public void initialize(){
        //SavingCoursesAndFacultyInfo.loadingFacultyInfo();
        //SavingCoursesAndFacultyInfo.loadingCoursesInfo();


        addOptionToComboBox();
        addOptionToFacultyComboBox();

        if(logInController.selectedTitleFromAcourseShowComboBoxAdmin!=null)
            courseShowComboBox.setValue(logInController.selectedTitleFromAcourseShowComboBoxAdmin);
        if(logInController.activeFacultyOnAdminComboBox!=null)
            facultyShowComboBox.setValue(logInController.activeFacultyOnAdminComboBox.facultyName);

    }

    public void actionForComboBox() {

        //SavingCoursesAndFacultyInfo.savingFacultyInfo();
        //SavingCoursesAndFacultyInfo.loadingFacultyInfo();


        logInController.selectedTitleFromAcourseShowComboBoxAdmin = (String) courseShowComboBox.getValue();
        System.out.println(logInController.selectedTitleFromAcourseShowComboBoxAdmin);

        CourseToLinkedListOthersInfo tempCourseToLinkedListOthersInfo;

        updateTheoryLabCounterLabelForCourseShowComboBox();

        logInController.activeFacultyOnAdminComboBox = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        logInController.activeCourse = AddSearchCourse.searchCourseWithTitle(logInController.selectedTitleFromAcourseShowComboBoxAdmin);

        if (logInController.activeCourse != null && logInController.activeFacultyOnAdminComboBox != null) {
            if (logInController.activeCourse.isLab) {
                goToLabScene();
            }
        }

        TheoryButtonDay1Time1.setPromptText("");
        TheoryButtonDay1Time1.getItems().clear();
        TheoryButtonDay1Time2.setPromptText("");
        TheoryButtonDay1Time2.getItems().clear();
        TheoryButtonDay1Time3.setPromptText("");
        TheoryButtonDay1Time3.getItems().clear();
        TheoryButtonDay1Time4.setPromptText("");
        TheoryButtonDay1Time4.getItems().clear();
        TheoryButtonDay1Time5.setPromptText("");
        TheoryButtonDay1Time5.getItems().clear();
        TheoryButtonDay1Time6.setPromptText("");
        TheoryButtonDay1Time6.getItems().clear();
        TheoryButtonDay1Time7.setPromptText("");
        TheoryButtonDay1Time7.getItems().clear();


        TheoryButtonDay2Time1.setPromptText("");
        TheoryButtonDay2Time1.getItems().clear();
        TheoryButtonDay2Time2.setPromptText("");
        TheoryButtonDay2Time2.getItems().clear();
        TheoryButtonDay2Time3.setPromptText("");
        TheoryButtonDay2Time3.getItems().clear();
        TheoryButtonDay2Time4.setPromptText("");
        TheoryButtonDay2Time4.getItems().clear();
        TheoryButtonDay2Time5.setPromptText("");
        TheoryButtonDay2Time5.getItems().clear();
        TheoryButtonDay2Time6.setPromptText("");
        TheoryButtonDay2Time6.getItems().clear();
        TheoryButtonDay2Time7.setPromptText("");
        TheoryButtonDay2Time7.getItems().clear();


        TheoryButtonDay3Time1.setPromptText("");
        TheoryButtonDay3Time1.getItems().clear();
        TheoryButtonDay3Time2.setPromptText("");
        TheoryButtonDay3Time2.getItems().clear();
        TheoryButtonDay3Time3.setPromptText("");
        TheoryButtonDay3Time3.getItems().clear();
        TheoryButtonDay3Time4.setPromptText("");
        TheoryButtonDay3Time4.getItems().clear();
        TheoryButtonDay3Time5.setPromptText("");
        TheoryButtonDay3Time5.getItems().clear();
        TheoryButtonDay3Time6.setPromptText("");
        TheoryButtonDay3Time6.getItems().clear();
        TheoryButtonDay3Time7.setPromptText("");
        TheoryButtonDay3Time7.getItems().clear();


        TheoryButtonDay4Time1.setPromptText("");
        TheoryButtonDay4Time1.getItems().clear();
        TheoryButtonDay4Time2.setPromptText("");
        TheoryButtonDay4Time2.getItems().clear();
        TheoryButtonDay4Time3.setPromptText("");
        TheoryButtonDay4Time3.getItems().clear();
        TheoryButtonDay4Time4.setPromptText("");
        TheoryButtonDay4Time4.getItems().clear();
        TheoryButtonDay4Time5.setPromptText("");
        TheoryButtonDay4Time5.getItems().clear();
        TheoryButtonDay4Time6.setPromptText("");
        TheoryButtonDay4Time6.getItems().clear();
        TheoryButtonDay4Time7.setPromptText("");
        TheoryButtonDay4Time7.getItems().clear();

        labLimitOverLabel.setVisible(false);
        theoryLimitOverLabel.setVisible(false);


        if (logInController.selectedTitleFromAcourseShowComboBoxAdmin != null && logInController.activeFacultyOnAdminComboBox != null) {
            CourseToLinkedListOthersInfo timeConflictsoCoursesForFaculty;

            if (logInController.activeCourse != null) {

                boolean time31HaveLabClass=false;
                boolean time33HaveLabClass=false;
                boolean time35HaveLabClass=false;
                boolean time41HaveLabClass=false;
                boolean time43HaveLabClass=false;
                boolean time45HaveLabClass=false;

                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 1)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay1Time2.getItems().clear();
                        TheoryButtonDay1Time2.setPromptText("<--------");
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 3)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay1Time4.getItems().clear();
                        TheoryButtonDay1Time4.setPromptText("<--------");
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 5)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay1Time6.getItems().clear();
                        TheoryButtonDay1Time6.setPromptText("<--------");
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 1)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay2Time2.getItems().clear();
                        TheoryButtonDay2Time2.setPromptText("<--------");
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 3)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay2Time4.getItems().clear();
                        TheoryButtonDay2Time4.setPromptText("<--------");
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 5)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay2Time6.getItems().clear();
                        TheoryButtonDay2Time6.setPromptText("<--------");
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    }
                }

                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 1)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay3Time2.getItems().clear();
                        TheoryButtonDay3Time2.setPromptText("<--------");

                        TheoryButtonDay3Time1.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();

                        time31HaveLabClass=true;
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 3)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay3Time4.getItems().clear();
                        TheoryButtonDay3Time4.setPromptText("<--------");

                        TheoryButtonDay3Time3.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                        time33HaveLabClass=true;
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 5)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay3Time6.getItems().clear();
                        TheoryButtonDay3Time6.setPromptText("<--------");

                        TheoryButtonDay3Time5.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();

                        time35HaveLabClass=true;
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 1)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay4Time2.getItems().clear();
                        TheoryButtonDay4Time2.setPromptText("<--------");

                        TheoryButtonDay4Time1.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                        time41HaveLabClass=true;
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 3)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay4Time4.getItems().clear();
                        TheoryButtonDay4Time4.setPromptText("<--------");

                        TheoryButtonDay4Time3.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                        time43HaveLabClass=true;
                    }
                }
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 5)) != null) {
                    if (timeConflictsoCoursesForFaculty.islabClass) {
                        TheoryButtonDay4Time6.getItems().clear();
                        TheoryButtonDay4Time6.setPromptText("<--------");

                        TheoryButtonDay4Time5.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                        time45HaveLabClass=true;
                    }
                }


                //Button 11 (11 means day1Time1)
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 1)) != null) {
                    TheoryButtonDay1Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay1Time1.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay1Time1.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time1.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay1Time1.setPromptText(tempStrForPrompText);
                    }
                }


                //Button12
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 2)) != null) {
                    TheoryButtonDay1Time2.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time2.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time2.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
                } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 1)) == null) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 2)) != null) {
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
                            TheoryButtonDay1Time2.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay1Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay1Time2.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 2)) != null) {
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
                                TheoryButtonDay1Time2.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay1Time2.setPromptText(tempStrForPrompText);
                    }
                } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 1)).islabClass) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 2)) != null) {
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
                            TheoryButtonDay1Time2.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay1Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay1Time2.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 2)) != null) {
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
                                TheoryButtonDay1Time2.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay1Time2.setPromptText(tempStrForPrompText);
                    }
                }

                //Button13
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 3)) != null) {
                    TheoryButtonDay1Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay1Time3.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay1Time3.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time3.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay1Time3.setPromptText(tempStrForPrompText);
                    }
                }


                //Button14
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 4)) != null) {
                    TheoryButtonDay1Time4.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time4.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time4.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
                } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 3)) == null) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 4)) != null) {
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
                            TheoryButtonDay1Time4.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay1Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay1Time4.setPromptText("Assigned");
                            promTextEditable=false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 4)) != null) {
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
                                TheoryButtonDay1Time4.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable=true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if(promTextEditable)
                            TheoryButtonDay1Time4.setPromptText(tempStrForPrompText);
                    }
                } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 3)).islabClass) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 4)) != null) {
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
                            TheoryButtonDay1Time4.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay1Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay1Time4.setPromptText("Assigned");
                            promTextEditable=false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 4)) != null) {
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
                                TheoryButtonDay1Time4.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable=true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if(promTextEditable)
                            TheoryButtonDay1Time4.setPromptText(tempStrForPrompText);
                    }
                }


                //Button15
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 5)) != null) {
                    TheoryButtonDay1Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay1Time5.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay1Time5.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time5.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay1Time5.setPromptText(tempStrForPrompText);
                    }
                }

                //Button16
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 6)) != null) {
                    TheoryButtonDay1Time6.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time6.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time6.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
                } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 5)) == null) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 6)) != null) {
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
                            TheoryButtonDay1Time6.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay1Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay1Time6.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 6)) != null) {
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
                                TheoryButtonDay1Time6.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay1Time6.setPromptText(tempStrForPrompText);
                    }
                } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 5)).islabClass) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(1, 6)) != null) {
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
                            TheoryButtonDay1Time6.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay1Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay1Time6.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 6)) != null) {
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
                                TheoryButtonDay1Time6.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay1Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay1Time6.setPromptText(tempStrForPrompText);
                    }
                }


                //Button17
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 7)) != null) {
                    TheoryButtonDay1Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay1Time7.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay1Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay1Time7.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                TheoryButtonDay1Time7.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 1)) != null) {
                    TheoryButtonDay2Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay2Time1.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay2Time1.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time1.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time1.setPromptText(tempStrForPrompText);
                    }
                }

                //Button22
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 2)) != null) {
                    TheoryButtonDay2Time2.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time2.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time2.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
                } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 1)) == null) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 2)) != null) {
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
                            TheoryButtonDay2Time2.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay2Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay2Time2.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 2)) != null) {
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
                                TheoryButtonDay2Time2.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time2.setPromptText(tempStrForPrompText);
                    }
                } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 1)).islabClass) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 2)) != null) {
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
                            TheoryButtonDay2Time2.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay2Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay2Time2.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 2)) != null) {
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
                                TheoryButtonDay2Time2.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time2.setPromptText(tempStrForPrompText);
                    }
                }

                //Button23
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 3)) != null) {
                    TheoryButtonDay2Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay2Time3.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay2Time3.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time3.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time3.setPromptText(tempStrForPrompText);
                    }
                }

                //Button24
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 4)) != null) {
                    TheoryButtonDay2Time4.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time4.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time4.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
                } else if (logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 3) == null) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 4)) != null) {
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
                            TheoryButtonDay2Time4.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay2Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay2Time4.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 4)) != null) {
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
                                TheoryButtonDay2Time4.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time4.setPromptText(tempStrForPrompText);
                    }
                } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 3)).islabClass) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 4)) != null) {
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
                            TheoryButtonDay2Time4.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay2Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay2Time4.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 4)) != null) {
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
                                TheoryButtonDay2Time4.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time4.setPromptText(tempStrForPrompText);
                    }
                }

                //Button25
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 5)) != null) {
                    TheoryButtonDay2Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay2Time5.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    printSlash=true;
                                }
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay2Time5.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time5.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time5.setPromptText(tempStrForPrompText);
                    }
                }

                //Button26
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 6)) != null) {
                    TheoryButtonDay2Time6.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time6.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time6.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
                } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 5)) == null) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 6)) != null) {
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
                            TheoryButtonDay2Time6.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay2Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay2Time6.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 6)) != null) {
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
                                TheoryButtonDay2Time6.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time6.setPromptText(tempStrForPrompText);
                    }
                } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 5)).islabClass) {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(2, 6)) != null) {
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
                            TheoryButtonDay2Time6.getItems().add(secAndCampus);
                        } else {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                            TheoryButtonDay2Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            TheoryButtonDay2Time6.setPromptText("Assigned");
                            promTextEditable = false;
                        }

                        while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 6)) != null) {
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
                                TheoryButtonDay2Time6.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay2Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time6.setPromptText(tempStrForPrompText);
                    }
                }

                //Button27
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 7)) != null) {
                    TheoryButtonDay2Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay2Time7.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay2Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay2Time7.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                TheoryButtonDay2Time7.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay2Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 31 (31 means day3Time1)
                if(!time31HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 1)) != null) {
                        TheoryButtonDay3Time1.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
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
                                TheoryButtonDay3Time1.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    TheoryButtonDay3Time1.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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

                //Button32
                if(!time31HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 2)) != null) {
                        TheoryButtonDay3Time2.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time2.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time2.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 1)) == null) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 2)) != null) {
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
                                TheoryButtonDay3Time2.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay3Time2.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 2)) != null) {
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
                                    TheoryButtonDay3Time2.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time2.setPromptText(tempStrForPrompText);
                        }
                    } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 1)).islabClass) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 2)) != null) {
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
                                TheoryButtonDay3Time2.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay3Time2.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 2)) != null) {
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
                                    TheoryButtonDay3Time2.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time2.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button33
                if(!time33HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 3)) != null) {
                        TheoryButtonDay3Time3.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
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
                                TheoryButtonDay3Time3.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    TheoryButtonDay3Time3.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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


                //Button34
                if(!time33HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 4)) != null) {
                        TheoryButtonDay3Time4.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time4.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time4.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 3)) == null) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 4)) != null) {
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
                                TheoryButtonDay3Time4.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay3Time4.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 4)) != null) {
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
                                    TheoryButtonDay3Time4.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time4.setPromptText(tempStrForPrompText);
                        }
                    } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 3)).islabClass) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 4)) != null) {
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
                                TheoryButtonDay3Time4.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay3Time4.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 4)) != null) {
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
                                    TheoryButtonDay3Time4.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time4.setPromptText(tempStrForPrompText);
                        }
                    }
                }


                //Button35
                if(!time35HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 5)) != null) {
                        TheoryButtonDay3Time5.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
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
                                TheoryButtonDay3Time5.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    TheoryButtonDay3Time5.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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

                //Button36
                if(!time35HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 6)) != null) {
                        TheoryButtonDay3Time6.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay3Time6.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay3Time6.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 5)) == null) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 6)) != null) {
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
                                TheoryButtonDay3Time6.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay3Time6.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 6)) != null) {
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
                                    TheoryButtonDay3Time6.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time6.setPromptText(tempStrForPrompText);
                        }
                    } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 5)).islabClass) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(3, 6)) != null) {
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
                                TheoryButtonDay3Time6.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay3Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay3Time6.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 6)) != null) {
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
                                    TheoryButtonDay3Time6.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay3Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay3Time6.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button37
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 7)) != null) {
                    TheoryButtonDay3Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay3Time7.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay3Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
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
                            TheoryButtonDay3Time7.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                TheoryButtonDay3Time7.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                            }
                            promTextEditable = true;
                        }
                        if(tempStrForPrompText.equals(""))
                            tempStrForPrompText="Assigned";
                        if (promTextEditable)
                            TheoryButtonDay3Time7.setPromptText(tempStrForPrompText);
                    }
            }


                //Button 41 (41 means day4Time1)
                if(!time41HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 1)) != null) {
                        TheoryButtonDay4Time1.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time1.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time1.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
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
                                TheoryButtonDay4Time1.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    TheoryButtonDay4Time1.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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


                //Button42
                if(!time41HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 2)) != null) {
                        TheoryButtonDay4Time2.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time2.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time2.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 1)) == null) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 2)) != null) {
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
                                TheoryButtonDay4Time2.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay4Time2.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 2)) != null) {
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
                                    TheoryButtonDay4Time2.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time2.setPromptText(tempStrForPrompText);
                        }
                    } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 1)).islabClass) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 2)) != null) {
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
                                TheoryButtonDay4Time2.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay4Time2.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 2)) != null) {
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
                                    TheoryButtonDay4Time2.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time2.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time2.setPromptText(tempStrForPrompText);
                        }
                    }
                }


                //Button43
                if(!time43HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 3)) != null) {
                        TheoryButtonDay4Time3.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time3.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time3.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
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
                                TheoryButtonDay4Time3.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    TheoryButtonDay4Time3.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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

                //Button44
                if(!time43HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 4)) != null) {
                        TheoryButtonDay4Time4.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time4.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time4.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 3)) == null) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 4)) != null) {
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
                                TheoryButtonDay4Time4.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay4Time4.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 4)) != null) {
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
                                    TheoryButtonDay4Time4.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time4.setPromptText(tempStrForPrompText);
                        }
                    } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 3)).islabClass) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 4)) != null) {
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
                                TheoryButtonDay4Time4.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay4Time4.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 4)) != null) {
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
                                    TheoryButtonDay4Time4.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time4.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time4.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button45
                if(!time45HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 5)) != null) {
                        TheoryButtonDay4Time5.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time5.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time5.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
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
                                TheoryButtonDay4Time5.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                    TheoryButtonDay4Time5.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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


                //Button46
                if(!time45HaveLabClass) {
                    if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 6)) != null) {
                        TheoryButtonDay4Time6.getItems().clear();
                        String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                        TheoryButtonDay4Time6.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                        TheoryButtonDay4Time6.setPromptText(timeConflictsoCoursesForFaculty.code);
                        updateTheoryLabCounterLabelForCourseShowComboBox();
                    } else if ((logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 5)) == null) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 6)) != null) {
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
                                TheoryButtonDay4Time6.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay4Time6.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 6)) != null) {
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
                                    TheoryButtonDay4Time6.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time6.setPromptText(tempStrForPrompText);
                        }
                    } else if (!(logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 5)).islabClass) {
                        if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 6)) != null) {
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
                                TheoryButtonDay4Time6.getItems().add(secAndCampus);
                            } else {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                TheoryButtonDay4Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                TheoryButtonDay4Time6.setPromptText("Assigned");
                                promTextEditable = false;
                            }

                            while ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 6)) != null) {
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
                                    TheoryButtonDay4Time6.getItems().add(secAndCampus);
                                } else {
                                    prevSec = tempCourseToLinkedListOthersInfo.section;
                                    secAndCampus = tempCourseToLinkedListOthersInfo.faculty + " asssigned to Sec " + prevSec;
                                    TheoryButtonDay4Time6.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
                                }
                                promTextEditable = true;
                            }
                            if (tempStrForPrompText.equals(""))
                                tempStrForPrompText = "Assigned";
                            if (promTextEditable)
                                TheoryButtonDay4Time6.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                    //Button47
                if ((timeConflictsoCoursesForFaculty = logInController.activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 7)) != null) {
                    TheoryButtonDay4Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + " -> " + timeConflictsoCoursesForFaculty.time;
                    TheoryButtonDay4Time7.getItems().addAll(tempForAddingItemInCOmboBox,timeConflictsoCoursesForFaculty.title, "Clear");
                    TheoryButtonDay4Time7.setPromptText(timeConflictsoCoursesForFaculty.code);
                    updateTheoryLabCounterLabelForCourseShowComboBox();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = logInController.activeCourse.searchSectionWIthDayAndTimeSlot(4, 7)) != null) {
                        /*String tempStrForPrompText = "";
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
                        TheoryButtonDay4Time7.setPromptText(tempStrForPrompText);*/


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
                            TheoryButtonDay4Time7.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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
                                TheoryButtonDay4Time7.getItems().addAll(secAndCampus, "Remove faculty from " + tempCourseToLinkedListOthersInfo.section);
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



    public void actionForFacultyShowComboBox(){
        facultyTheoryCounter.setText("-");
        facultyLabCounter.setText("-");

        logInController.nowSelectedFaculty =(String) facultyShowComboBox.getValue();
        FacultyInfo tempForCoutineClass = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if(tempForCoutineClass!=null) {
            String tempCounter = Integer.toString(tempForCoutineClass.theory);
            facultyTheoryCounter.setText(tempCounter);
            tempCounter = Integer.toString(tempForCoutineClass.lab);
            facultyLabCounter.setText(tempCounter);
        }
        //updateTheoryLabCounterLabelForCourseShowComboBox();
    }

    public void addOptionToFacultyComboBox(){
        facultyShowComboBox.getItems().clear();

        FacultyInfo temp = AddRemoveSearchFaculty.facultyHeadPointer;
        while(temp!=null){
            facultyShowComboBox.getItems().add(temp.facultyName);
            temp=temp.next;
        }

        new AutoCompleteComboBoxListener<>(facultyShowComboBox);

        updateTheoryLabCounterLabel();
        //actionForComboBox();
    }



    public void addOptionToComboBox(){
        courseShowComboBox.getItems().removeAll(courseShowComboBox.getItems());

        CourseToLinkedList temp = AddSearchCourse.courseHeadPointer;
        while(temp!=null){
            courseShowComboBox.getItems().add(temp.title);
            temp=temp.next;
        }
        new AutoCompleteComboBoxListener<>(courseShowComboBox);

    }

    public void updateTheoryLabCounterLabel(){

        FacultyInfo tempForCountingClass = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if(tempForCountingClass!=null) {
            String tempCounter = Integer.toString(tempForCountingClass.tempTheory);
            facultyTheoryCounter.setText(tempCounter);
            tempCounter = Integer.toString(tempForCountingClass.tempLab);
            facultyLabCounter.setText(tempCounter);


            if(tempForCountingClass.tempLab==tempForCountingClass.labLimit)
                labLimitOverLabel.setVisible(true);
            if(tempForCountingClass.tempTheory==tempForCountingClass.theoryLimit)
                theoryLimitOverLabel.setVisible(true);
        }
        //actionForComboBox();
        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();
    }

    public void updateTheoryLabCounterLabelForCourseShowComboBox(){

        FacultyInfo tempForCountingClass = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if(tempForCountingClass!=null) {
            String tempCounter = Integer.toString(tempForCountingClass.tempTheory);
            facultyTheoryCounter.setText(tempCounter);
            tempCounter = Integer.toString(tempForCountingClass.tempLab);
            facultyLabCounter.setText(tempCounter);

            if(tempForCountingClass.tempLab==tempForCountingClass.labLimit)
                labLimitOverLabel.setVisible(true);
            if(tempForCountingClass.tempTheory==tempForCountingClass.theoryLimit)
                theoryLimitOverLabel.setVisible(true);
        }
        //actionForComboBox();

        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();
    }

    public void mouseMoveAction(){
        //System.out.println(logInController.selectedTitleFromAcourseShowComboBoxAdmin+" Mouse is movine");
        courseShowComboBox.setValue(logInController.selectedTitleFromAcourseShowComboBoxAdmin);
        facultyShowComboBox.setValue(logInController.nowSelectedFaculty);
        actionForComboBox();
    }

    public void goToLabScene(){
        try{
            chooseCourseAdminRoot= FXMLLoader.load(getClass().getResource("routineGridShowLabAdmin.fxml"));
            chooseCourseAdminScene=new Scene(chooseCourseAdminRoot,850,500);

            chooseCourseStage = (Stage) copyRightLabel.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseAdminScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay1Time1.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay1Time1.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay1Time1.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
                }
            }
        }
    }
    public void actionForTheoryButtonDay1Time2(){
        String command=(String)TheoryButtonDay1Time2.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay1Time2.getItems().get(0);
                String tempTitle=TheoryButtonDay1Time2.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    //System.out.println("Command :"+command);
                    for(int i=0;i<TheoryButtonDay1Time2.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay1Time2.getItems().get(i);
                        //System.out.println("temp in "+i+":"+command);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay1Time2.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    //System.out.println("Command :"+command);
                    for(int i=0;i<TheoryButtonDay1Time3.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay1Time3.getItems().get(i);
                        //System.out.println("temp in "+i+":"+command);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay1Time3.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
                }
            }
        }
    }
    public void actionForTheoryButtonDay1Time4(){
        String command=(String)TheoryButtonDay1Time4.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay1Time4.getItems().get(0);
                String tempTitle=TheoryButtonDay1Time4.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    //System.out.println("Command :"+command);
                    for(int i=0;i<TheoryButtonDay1Time4.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay1Time4.getItems().get(i);
                        //System.out.println("temp in "+i+":"+command);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay1Time4.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay1Time5.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay1Time5.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay1Time5.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
                }
            }
        }
    }
    public void actionForTheoryButtonDay1Time6(){
        String command=(String)TheoryButtonDay1Time6.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay1Time6.getItems().get(0);
                String tempTitle=TheoryButtonDay1Time6.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay1Time6.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay1Time6.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay1Time6.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay1Time7.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay1Time7.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay1Time7.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay2Time1.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay2Time1.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay2Time1.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time2(){
        String command=(String)TheoryButtonDay2Time2.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay2Time2.getItems().get(0);
                String tempTitle=TheoryButtonDay2Time2.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}


                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay2Time2.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay2Time2.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay2Time2.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay2Time3.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay2Time3.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay2Time3.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time4(){
        String command=(String)TheoryButtonDay2Time4.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay2Time4.getItems().get(0);
                String tempTitle=TheoryButtonDay2Time4.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay2Time4.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay2Time4.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay2Time4.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay2Time5.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay2Time5.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay2Time5.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time6(){
        String command=(String)TheoryButtonDay2Time6.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                String tempStr=(String)TheoryButtonDay2Time6.getItems().get(0);
                String tempTitle=TheoryButtonDay2Time6.getItems().get(1);

                StringTokenizer tok=new StringTokenizer(tempStr);
                tempStr=tok.nextToken();   // here it will recieve "Sec" word
                String tempSec=tok.nextToken();   // Here it will recieve section name

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay2Time6.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay2Time6.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay2Time6.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec") && !temp.equals("Remove")) {
                    logInController.activeFacultyOnAdminComboBox.addCourseWithList(logInController.activeCourse.searchSection(temp));
                    CourseToLinkedListOthersInfo tempSec=logInController.activeCourse.searchSection(temp);
                    tempSec.faculty=logInController.activeFacultyOnAdminComboBox.facultyName;
                    updateTheoryLabCounterLabel();
                }
                else if(temp.equals("Remove")){
                    for(int i=0;i<TheoryButtonDay2Time7.getVisibleRowCount();i++) {
                        temp = (String) TheoryButtonDay2Time7.getItems().get(i);
                        if(command.equals(temp)){
                            temp = (String) TheoryButtonDay2Time7.getItems().get(i-1);
                            break;
                        }
                    }
                    tok=new StringTokenizer(temp);
                    String tempFacultyName=tok.nextToken();
                    while(tok.hasMoreTokens())
                        temp=tok.nextToken();
                    CourseToLinkedListOthersInfo tempSection=logInController.activeCourse.searchSection(temp);
                    if(tempSection!=null) {
                        tempSection.faculty = "";
                        FacultyInfo tempFaculty = AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

                        try {
                            tempSection = tempFaculty.searchCourseAndSection(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseWithTitleAndSecion(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                        try {
                            tempSection = tempFaculty.searchCourseAndSectionInTempList(tempSection.title, tempSection.section);
                            tempFaculty.removeCourseFromTempList(tempSection.title, tempSection.section);
                        }catch(Exception e){}
                    }
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
        }
    }
    public void actionForTheoryButtonDay3Time2(){

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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
        }
    }
    public void actionForTheoryButtonDay3Time4(){

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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }

        }
    }
    public void actionForTheoryButtonDay3Time6(){

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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
        }
    }
    public void actionForTheoryButtonDay4Time2(){

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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
        }
    }
    public void actionForTheoryButtonDay4Time4(){

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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
        }
    }
    public void actionForTheoryButtonDay4Time6(){

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

                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseWithTitleAndSecion(tempTitle, tempSec);
                }catch(Exception e){}
                try {
                    AddSearchCourse.searchCourseWithTitle(tempTitle).searchSection(tempSec).faculty = "";
                    logInController.activeFacultyOnAdminComboBox.removeCourseFromTempList(tempTitle, tempSec);
                }catch(Exception e){}

                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
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
