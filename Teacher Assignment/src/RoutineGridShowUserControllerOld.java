import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;

import java.util.StringTokenizer;


/**
 * Created by mimtiaze on 04-Jul-16.
 */
public class RoutineGridShowUserControllerOld {

    @FXML
    public ComboBox<String> courseShowComboBox;

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
    public Label activeFacultyNameLabel;


    public static String selectedTitleFromAcourseShowComboBoxAdmin;
    public static FacultyInfo activeFacultyOnAdminComboBox;
    public static CourseToLinkedList activeCourse;

    public void actionForcourseShowComboBox() {
        selectedTitleFromAcourseShowComboBoxAdmin = logInController.selectedTitleFromAcourseShowComboBoxAdmin = courseShowComboBox.getValue();
        System.out.println(selectedTitleFromAcourseShowComboBoxAdmin);
        updateTheoryLabCounterLabel();





        CourseToLinkedListOthersInfo tempCourseToLinkedListOthersInfo;

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


        activeFacultyOnAdminComboBox = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if (selectedTitleFromAcourseShowComboBoxAdmin != null && activeFacultyOnAdminComboBox != null) {
            activeCourse = AddSearchCourse.searchCourseWithTitle(selectedTitleFromAcourseShowComboBoxAdmin);
            CourseToLinkedListOthersInfo timeConflictsoCoursesForFaculty;

            if (activeCourse != null) {

                //Button 11 (11 means day1Time1)
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 1)) != null) {
                    TheoryButtonDay1Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay1Time1.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time1.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(1, 1)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time1.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 1)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time1.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time1.setPromptText(tempStrForPrompText);
                    }
                }

                //Button12
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 2)) != null) {
                    TheoryButtonDay1Time2.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay1Time2.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time2.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 1)) == null){
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(1, 2)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time2.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 2)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time2.getItems().add(secAndCampus);
                        }
                        TheoryButtonDay1Time2.setPromptText(tempStrForPrompText);
                    }
                }

                //Button13
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 3)) != null) {
                    TheoryButtonDay1Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay1Time3.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time3.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(1, 3)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time3.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 3)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time3.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time3.setPromptText(tempStrForPrompText);
                    }
                }

                //Button14
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 4)) != null) {
                    TheoryButtonDay1Time4.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay1Time4.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time4.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 3)) == null){
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(1, 4)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time4.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 4)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;

                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time4.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time4.setPromptText(tempStrForPrompText);
                    }
                }

                //Button15
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 5)) != null) {
                    TheoryButtonDay1Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay1Time5.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time5.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(1, 5)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time5.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 5)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time5.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time5.setPromptText(tempStrForPrompText);
                    }
                }

                //Button16
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 6)) != null) {
                    TheoryButtonDay1Time6.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay1Time6.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time6.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 5)) == null){
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(1, 6)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time6.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 6)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time6.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time6.setPromptText(tempStrForPrompText);
                    }
                }

                //Button17
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(1, 7)) != null) {
                    TheoryButtonDay1Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay1Time7.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay1Time7.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(1, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay1Time7.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 1, 7)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay1Time7.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay1Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 21 (21 means day2Time1)
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 1)) != null) {
                    TheoryButtonDay2Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay2Time1.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time1.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(2, 1)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time1.getItems().add(prevSec);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 1)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time1.getItems().add(prevSec);

                        }
                        TheoryButtonDay2Time1.setPromptText(tempStrForPrompText);
                    }
                }

                //Button22
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 2)) != null) {
                    TheoryButtonDay2Time2.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay2Time2.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time2.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 1)) == null){
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(2, 2)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time2.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 2)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time2.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time2.setPromptText(tempStrForPrompText);
                    }
                }

                //Button23
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 3)) != null) {
                    TheoryButtonDay2Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay2Time3.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time3.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(2, 3)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time3.getItems().add(secAndCampus);


                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 3)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time3.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time3.setPromptText(tempStrForPrompText);


                    }
                }

                //Button24
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 4)) != null) {
                    TheoryButtonDay2Time4.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay2Time4.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time4.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else  if(activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 3) == null){
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(2, 4)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time4.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 4)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time4.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time4.setPromptText(tempStrForPrompText);
                    }
                }

                //Button25
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 5)) != null) {
                    TheoryButtonDay2Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay2Time5.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time5.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(2, 5)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time5.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 5)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time6.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time5.setPromptText(tempStrForPrompText);
                    }
                }

                //Button26
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 6)) != null) {
                    TheoryButtonDay2Time6.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay2Time6.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time6.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else  if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 5)) == null){
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(2, 6)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time6.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 6)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time6.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time6.setPromptText(tempStrForPrompText);
                    }
                }

                //Button27
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(2, 7)) != null) {
                    TheoryButtonDay2Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay2Time7.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay2Time7.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(2, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay2Time7.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 2, 7)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay2Time7.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay2Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 31 (11 means day3Time1)
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 1)) != null) {
                    TheoryButtonDay3Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay3Time1.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time1.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(3, 1)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time1.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 1)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time1.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time1.setPromptText(tempStrForPrompText);
                    }
                }

                //Button32
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 2)) != null) {
                    TheoryButtonDay3Time2.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay3Time2.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time2.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else  if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 1)) == null){
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(3, 2)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time2.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 2)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time2.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time2.setPromptText(tempStrForPrompText);
                    }
                }

                //Button33
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 3)) != null) {
                    TheoryButtonDay3Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay3Time3.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time3.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(3, 3)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time3.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 3)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time3.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time3.setPromptText(tempStrForPrompText);
                    }
                }

                //Button34
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 4)) != null) {
                    TheoryButtonDay3Time4.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay3Time4.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time4.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else  if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 3)) == null){
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(3, 4)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time4.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 4)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time4.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time4.setPromptText(tempStrForPrompText);
                    }
                }

                //Button35
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 5)) != null) {
                    TheoryButtonDay3Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay3Time5.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time5.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(3, 5)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time5.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 5)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time5.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time5.setPromptText(tempStrForPrompText);
                    }
                }

                //Button36
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 6)) != null) {
                    TheoryButtonDay3Time6.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay3Time6.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time6.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 5)) == null) {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(3, 6)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time6.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 6)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time6.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time6.setPromptText(tempStrForPrompText);
                    }
                }

                //Button37
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(3, 7)) != null) {
                    TheoryButtonDay3Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay3Time7.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay3Time7.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(3, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay3Time7.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 3, 7)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay3Time7.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay3Time7.setPromptText(tempStrForPrompText);
                    }
                }


                //Button 41 (11 means day4Time1)
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 1)) != null) {
                    TheoryButtonDay4Time1.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay4Time1.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time1.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(4, 1)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time1.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 1)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time1.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time1.setPromptText(tempStrForPrompText);
                    }
                }

                //Button42
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 2)) != null) {
                    TheoryButtonDay4Time2.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay4Time2.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time2.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 1)) == null){
                    if (!logInController.theoryButtonSelected[22]) {
                        if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(4, 2)) != null) {
                            String tempStrForPrompText = "";
                            String prevSec = tempCourseToLinkedListOthersInfo.section;
                            String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                            TheoryButtonDay4Time2.getItems().add(secAndCampus);

                            while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 2)) != null) {
                                prevSec = tempCourseToLinkedListOthersInfo.section;
                                tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                                secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                                TheoryButtonDay4Time2.getItems().add(secAndCampus);

                            }
                            TheoryButtonDay4Time2.setPromptText(tempStrForPrompText);
                        }
                    }
                }

                //Button43
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 3)) != null) {
                    TheoryButtonDay4Time3.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay4Time3.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time3.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(4, 3)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time3.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 3)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time3.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time3.setPromptText(tempStrForPrompText);
                    }
                }

                //Button44
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 4)) != null) {
                    TheoryButtonDay4Time4.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay4Time4.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time4.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 3)) == null) {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(4, 4)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time4.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 4)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time4.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time4.setPromptText(tempStrForPrompText);
                    }
                }

                //Button45
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 5)) != null) {
                    TheoryButtonDay4Time5.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay4Time5.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time5.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(4, 5)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time5.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 5)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time5.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time5.setPromptText(tempStrForPrompText);
                    }
                }

                //Button46
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 6)) != null) {
                    TheoryButtonDay4Time6.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay4Time6.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time6.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else if((activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 5)) == null) {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(4, 6)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time6.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 6)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time6.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time6.setPromptText(tempStrForPrompText);
                    }
                }

                //Button47
                if ((timeConflictsoCoursesForFaculty = activeFacultyOnAdminComboBox.searchSectionWIthDayAndTimeSlot(4, 7)) != null) {
                    TheoryButtonDay4Time7.getItems().clear();
                    String tempForAddingItemInCOmboBox = "Sec " + timeConflictsoCoursesForFaculty.section + " - Campus " + timeConflictsoCoursesForFaculty.campus + ", " + timeConflictsoCoursesForFaculty.title;
                    TheoryButtonDay4Time7.getItems().addAll(tempForAddingItemInCOmboBox, "Clear");
                    TheoryButtonDay4Time7.setPromptText(tempForAddingItemInCOmboBox);
                    updateTheoryLabCounterLabel();
                } else {
                    if ((tempCourseToLinkedListOthersInfo = activeCourse.searchSectionWIthDayAndTimeSlot(4, 7)) != null) {
                        String tempStrForPrompText = "";
                        String prevSec = tempCourseToLinkedListOthersInfo.section;
                        String secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                        tempStrForPrompText = tempStrForPrompText + tempCourseToLinkedListOthersInfo.section;
                        TheoryButtonDay4Time7.getItems().add(secAndCampus);

                        while ((tempCourseToLinkedListOthersInfo = activeCourse.searchAnotherSectionWIthDayAndTimeSlot(prevSec, 4, 7)) != null) {
                            prevSec = tempCourseToLinkedListOthersInfo.section;
                            tempStrForPrompText = tempStrForPrompText + "/" + tempCourseToLinkedListOthersInfo.section;
                            secAndCampus = prevSec + " - Campus " + tempCourseToLinkedListOthersInfo.campus;
                            TheoryButtonDay4Time7.getItems().add(secAndCampus);

                        }
                        TheoryButtonDay4Time7.setPromptText(tempStrForPrompText);
                    }
                }
            }
        }
    }




    public void addOptionToComboBox(){
        courseShowComboBox.getItems().removeAll(courseShowComboBox.getItems());

        CourseToLinkedList temp = AddSearchCourse.courseHeadPointer;
        while(temp!=null){
            courseShowComboBox.getItems().add(temp.title);
            temp=temp.next;
        }

    }

    public void mouseMoveAction(){
        courseShowComboBox.setValue(logInController.selectedTitleFromAcourseShowComboBoxAdmin);
        actionForcourseShowComboBox();
    }

    public void updateTheoryLabCounterLabel(){

        activeFacultyNameLabel.setText(logInController.nowSelectedFaculty);

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

        FacultyInfo tempForCoutineClass = AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
        if(tempForCoutineClass!=null) {
            String tempCounter = Integer.toString(tempForCoutineClass.theory);
            facultyTheoryCounter.setText(tempCounter);
            tempCounter = Integer.toString(tempForCoutineClass.lab);
            facultyLabCounter.setText(tempCounter);
        }

    }



    public void actionForTheoryButtonDay1Time1(){
        String command=(String)TheoryButtonDay1Time1.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(1,1,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }

    }
    public void actionForTheoryButtonDay1Time2(){
        String command=(String)TheoryButtonDay1Time2.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(1,2,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay1Time3(){
        String command=(String)TheoryButtonDay1Time3.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(1,3,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay1Time4(){
        String command=(String)TheoryButtonDay1Time4.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(1,4,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay1Time5(){
        String command=(String)TheoryButtonDay1Time5.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(1,5,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay1Time6(){
        String command=(String)TheoryButtonDay1Time6.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(1,6,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay1Time7(){
        String command=(String)TheoryButtonDay1Time7.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(1,7,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time1(){
        String command=(String)TheoryButtonDay2Time1.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(2,1,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time2(){
        String command=(String)TheoryButtonDay2Time2.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(2,2,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time3(){
        String command=(String)TheoryButtonDay2Time3.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(2,3,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time4(){
        String command=(String)TheoryButtonDay2Time4.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(2,4,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time5(){
        String command=(String)TheoryButtonDay2Time5.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(2,5,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time6(){
        String command=(String)TheoryButtonDay2Time6.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(2,6,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay2Time7(){
        String command=(String)TheoryButtonDay2Time7.getValue();
        if(command!=null){
            if(command.equals("Clear")){
                activeFacultyOnAdminComboBox.removeCourseWithDayAndTime(2,7,false);
                updateTheoryLabCounterLabel();
                //actionForcourseShowComboBox();
            }
            else{
                StringTokenizer tok=new StringTokenizer(command);
                String temp=tok.nextToken();
                if(!temp.equals("Sec")) {
                    activeFacultyOnAdminComboBox.addCourseWithList(activeCourse.searchSection(temp));
                    updateTheoryLabCounterLabel();
                }
            }
        }
    }
    public void actionForTheoryButtonDay3Time1(){

    }
    public void actionForTheoryButtonDay3Time2(){

    }
    public void actionForTheoryButtonDay3Time3(){

    }
    public void actionForTheoryButtonDay3Time4(){

    }
    public void actionForTheoryButtonDay3Time5(){

    }
    public void actionForTheoryButtonDay3Time6(){

    }
    public void actionForTheoryButtonDay3Time7(){

    }
    public void actionForTheoryButtonDay4Time1(){

    }
    public void actionForTheoryButtonDay4Time2(){

    }
    public void actionForTheoryButtonDay4Time3(){

    }
    public void actionForTheoryButtonDay4Time4(){

    }
    public void actionForTheoryButtonDay4Time5(){

    }
    public void actionForTheoryButtonDay4Time6(){

    }
    public void actionForTheoryButtonDay4Time7(){

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

}
