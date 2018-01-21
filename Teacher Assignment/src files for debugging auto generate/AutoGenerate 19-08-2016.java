import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mimtiaze on 02-Aug-16.
 */
public class AutoGenerate {


    public AutoGenerate(){
        CourseToLinkedList tempListOfCourse=AddSearchCourse.courseHeadPointer;
        /*while(tempListOfCourse!=null){

            CourseToLinkedListOthersInfo tempSecList=tempListOfCourse.firstSection;
            while(tempSecList!=null){
                if(tempSecList.faculty.equals("") || tempSecList.faculty==null) {
                    checkFacultyWhoAlreadyTakenThisCourse(tempListOfCourse,tempSecList);
                }
                tempSecList=tempSecList.next;
            }
            tempListOfCourse=tempListOfCourse.next;
        }

        // again loop will be start from begining, for check is all section are assigned
        // is there are section not assigned, then it will forced to some faculty who have empty slot for courses to take not assigned courses

        for(int i=0;i<1;i++) {
            tempListOfCourse = AddSearchCourse.courseHeadPointer;
            while (tempListOfCourse != null) {

                CourseToLinkedListOthersInfo tempSecList = tempListOfCourse.firstSection;
                while (tempSecList != null) {
                    if (tempSecList.faculty.equals("") || tempSecList.faculty == null) {
                        forceToTakeCourses(tempListOfCourse, tempSecList);
                    }
                    tempSecList = tempSecList.next;
                }
                tempListOfCourse = tempListOfCourse.next;
            }
        }*/

        facultyAssign();

        assignByCourse();

        int secRemaining=remainingSectionCount();

        while(secRemaining!=0) {
            if (secRemaining > 0) {
                deleteSomeSectionRandomly();
                facultyAssign();
                //assignByCourse();

            }
            secRemaining=remainingSectionCount();
        }

        System.out.println("Done Auto Generating.. Thank you for using this app");

    }


    public void assignByCourse(){
        CourseToLinkedList tempListOfCourse = AddSearchCourse.courseHeadPointer;
        while (tempListOfCourse != null) {

            CourseToLinkedListOthersInfo tempSecList = tempListOfCourse.firstSection;
            while (tempSecList != null) {
                if (tempSecList.faculty.equals("") || tempSecList.faculty == null) {
                    forceToTakeCourses(tempListOfCourse, tempSecList);
                }
                tempSecList = tempSecList.next;
            }
            tempListOfCourse = tempListOfCourse.next;
        }
    }



    public void checkFacultyWhoAlreadyTakenThisCourse(CourseToLinkedList tempCourseList,CourseToLinkedListOthersInfo tempSec){
        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        boolean assigned=false;

        while(tempFaculty!=null){
            CourseToLinkedListOthersInfo facultyTakenCourse=tempFaculty.firstSectionOfFaculty;
            while(facultyTakenCourse!=null){
                if(facultyTakenCourse.title.equals(tempSec.title)){
                    assigned=searchFacultyIfAvailableForAssign(tempCourseList,tempSec,tempFaculty);
                    break;
                }
                facultyTakenCourse=facultyTakenCourse.next;
            }

            if(assigned)
                break;

            tempFaculty=tempFaculty.next;
        }

        if(!assigned){
            // Assign randomly with priority
            // Check previous trimester data
        }
    }

    public boolean searchFacultyIfAvailableForAssign(CourseToLinkedList tempCourseList,CourseToLinkedListOthersInfo tempSec,FacultyInfo tempFaculty){

        // only 1 and 2 priority have the access
        //if(tempFaculty.priority>3)
          //  return false;

        if(tempFaculty.theoryLimit<=tempFaculty.theory && tempFaculty.labLimit<=tempFaculty.lab){
            return false;
        }

        if(tempSec.islabClass){
            if(tempFaculty.labLimit<=tempFaculty.lab)
                return false;
        }
        else{
            if(tempFaculty.theoryLimit<=tempFaculty.theory)
                return false;
        }

        CourseToLinkedListOthersInfo takenByThisFaculty=tempFaculty.firstSectionOfFaculty;
        boolean conflict=false;
        if(takenByThisFaculty!=null) {
            while (takenByThisFaculty != null) {

                if (tempSec.timeSlot == takenByThisFaculty.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                    conflict = true;
                    break;
                }
                if (takenByThisFaculty.islabClass) {
                    if ((takenByThisFaculty.timeSlot + 1) == tempSec.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                        conflict = true;
                        break;
                    }
                }
                if (tempSec.islabClass) {
                    if ((tempSec.timeSlot + 1) == takenByThisFaculty.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                        conflict = true;
                        break;
                    }
                }

                takenByThisFaculty = takenByThisFaculty.next;
            }
        }

        if(conflict){
            return false;
        }else{
            boolean classAfter5minInDifferentCampus=false;
            CourseToLinkedListOthersInfo tempListForCheckClassAfter5min=tempFaculty.firstSectionOfFaculty;
            while(tempListForCheckClassAfter5min!=null){
                if(tempListForCheckClassAfter5min.islabClass){
                    if((tempListForCheckClassAfter5min.timeSlot-tempSec.timeSlot)==1){
                        if(tempListForCheckClassAfter5min.campus!=tempSec.campus){
                            classAfter5minInDifferentCampus=true;
                            break;
                        }
                    }
                    else if((tempListForCheckClassAfter5min.timeSlot-tempSec.timeSlot)==-2){  // (-2) reason: suppose u have a class at 11:20 and that is lab class, so your next class might be at 2:10, so the difference is 2 class period.. 11:20 is ur class u have already taken, so the difference is -2
                        if(tempListForCheckClassAfter5min.campus!=tempSec.campus){
                            classAfter5minInDifferentCampus=true;
                            break;
                        }
                    }

                }else{
                    int timeDiff=Math.abs(tempSec.timeSlot-tempListForCheckClassAfter5min.timeSlot);
                    if(timeDiff==1){
                        if(tempListForCheckClassAfter5min.campus!=tempSec.campus){
                            classAfter5minInDifferentCampus=true;
                            break;
                        }
                    }
                }
                tempListForCheckClassAfter5min=tempListForCheckClassAfter5min.next;
            }

            if(!classAfter5minInDifferentCampus) {
                tempSec.faculty = tempFaculty.facultyName;
                tempFaculty.addCourseWithList(tempSec);
                return true;
            }
        }

        return false;
    }

    public boolean forceToTakeCourses(CourseToLinkedList tempCourseList,CourseToLinkedListOthersInfo tempSec){

        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        FacultyInfo lastFaculty=null;
        boolean conflict = false;


        for(;tempFaculty.next!=null;tempFaculty=tempFaculty.next) {
            lastFaculty=tempFaculty;
            conflict=false;

            if (tempFaculty.lab>=tempFaculty.labLimit && tempFaculty.theory>=tempFaculty.theoryLimit) {
                continue;
            }

            if (tempSec.islabClass) {
                if (tempFaculty.lab>=tempFaculty.labLimit )
                    continue;
            } else {
                if (tempFaculty.theory>=tempFaculty.theoryLimit)
                    continue;
            }

            CourseToLinkedListOthersInfo takenByThisFaculty = tempFaculty.firstSectionOfFaculty;
            if(takenByThisFaculty!=null) {
                while (takenByThisFaculty != null) {

                    if (tempSec.timeSlot == takenByThisFaculty.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                        conflict = true;
                        break;
                    }

                    if (takenByThisFaculty.islabClass) {
                        if ((takenByThisFaculty.timeSlot + 1) == tempSec.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                            conflict = true;
                            break;
                        }
                        // 5 min campus change logic
                        if((takenByThisFaculty.timeSlot + 2) == tempSec.timeSlot && takenByThisFaculty.campus!=tempSec.campus){
                            conflict = true;
                            break;
                        }
                    }
                    if (tempSec.islabClass) {
                        if ((tempSec.timeSlot + 1) == takenByThisFaculty.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                            conflict = true;
                            break;
                        }
                        // 5 min campus change logic
                        if((tempSec.timeSlot + 1) == takenByThisFaculty.timeSlot && takenByThisFaculty.campus!=tempSec.campus){
                            conflict = true;
                            break;
                        }
                    }

                    takenByThisFaculty = takenByThisFaculty.next;
                }
            }else{
                break;
            }

            //if(conflict)
             //   break;
            //tempFaculty=tempFaculty.next;

            if(!conflict){
                if(tempFaculty!=null) {
                    tempSec.faculty = tempFaculty.facultyName;
                    tempFaculty.addCourseWithList(tempSec);
                    return true;
                }
            }

        }

        // For last faculty
        /*if(conflict){
            return false;
        }else{
            if(tempFaculty!=null) {
                tempSec.faculty = tempFaculty.facultyName;
                tempFaculty.addCourseWithList(tempSec);
                return true;
            }else if(lastFaculty!=null){
                tempSec.faculty = lastFaculty.facultyName;
                lastFaculty.addCourseWithList(tempSec);
                return true;
            }
        }*/


        conflict=false;

        if (tempFaculty.lab>=tempFaculty.labLimit && tempFaculty.theory>=tempFaculty.theoryLimit) {
            return false;
        }

        if (tempSec.islabClass) {
            if (tempFaculty.lab>=tempFaculty.labLimit )
                return false;
        } else {
            if (tempFaculty.theory>=tempFaculty.theoryLimit)
                return false;
        }

        CourseToLinkedListOthersInfo takenByThisFaculty = tempFaculty.firstSectionOfFaculty;
        if(takenByThisFaculty!=null) {
            while (takenByThisFaculty != null) {

                if (tempSec.timeSlot == takenByThisFaculty.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                    conflict = true;
                    break;
                }

                if (takenByThisFaculty.islabClass) {
                    if ((takenByThisFaculty.timeSlot + 1) == tempSec.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                        conflict = true;
                        break;
                    }
                    // 5 min campus change logic
                    if((takenByThisFaculty.timeSlot + 2) == tempSec.timeSlot && takenByThisFaculty.campus!=tempSec.campus){
                        conflict = true;
                        break;
                    }
                }
                if (tempSec.islabClass) {
                    if ((tempSec.timeSlot + 1) == takenByThisFaculty.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                        conflict = true;
                        break;
                    }
                    // 5 min campus change logic
                    if((tempSec.timeSlot + 1) == takenByThisFaculty.timeSlot && takenByThisFaculty.campus!=tempSec.campus){
                        conflict = true;
                        break;
                    }
                }

                takenByThisFaculty = takenByThisFaculty.next;
            }
        }else{
            return false;
        }

        //if(conflict)
        //   break;
        //tempFaculty=tempFaculty.next;

        if(!conflict){
            if(tempFaculty!=null) {
                tempSec.faculty = tempFaculty.facultyName;
                tempFaculty.addCourseWithList(tempSec);
                return true;
            }
        }



        return false;
    }


    //Not complete
    public boolean forceToTakeCoursesButNotHaveClassAfter5min(CourseToLinkedList tempCourseList,CourseToLinkedListOthersInfo tempSec){

        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        FacultyInfo lastFaculty=null;
        boolean conflict = false;


        for(;tempFaculty!=null;tempFaculty=tempFaculty.next) {
            lastFaculty=tempFaculty;
            conflict=false;

            if (tempFaculty.theoryLimit <= tempFaculty.theory && tempFaculty.labLimit <= tempFaculty.lab) {
                continue;
            }

            if (tempSec.islabClass) {
                if (tempFaculty.labLimit <= tempFaculty.lab)
                    continue;
            } else {
                if (tempFaculty.theoryLimit <= tempFaculty.theory)
                    continue;
            }

            CourseToLinkedListOthersInfo takenByThisFaculty = tempFaculty.firstSectionOfFaculty;
            if(takenByThisFaculty!=null) {
                while (takenByThisFaculty != null) {

                    if (tempSec.timeSlot == takenByThisFaculty.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                        conflict = true;
                        break;
                    }
                    if (takenByThisFaculty.islabClass) {
                        if ((takenByThisFaculty.timeSlot + 1) == tempSec.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                            conflict = true;
                            break;
                        }
                    }
                    if (tempSec.islabClass) {
                        if ((tempSec.timeSlot + 1) == takenByThisFaculty.timeSlot && (tempSec.day1 == takenByThisFaculty.day1 || tempSec.day2 == takenByThisFaculty.day2 || tempSec.day1 == takenByThisFaculty.day2 || takenByThisFaculty.day1 == tempSec.day2)) {
                            conflict = true;
                            break;
                        }
                    }

                    takenByThisFaculty = takenByThisFaculty.next;
                }
            }else{
                break;
            }

            //if(conflict)
            //   break;
            //tempFaculty=tempFaculty.next;

            if(!conflict){
                if(tempFaculty!=null) {
                    tempSec.faculty = tempFaculty.facultyName;
                    tempFaculty.addCourseWithList(tempSec);
                    return true;
                }
            }

        }

        if(conflict){
            return false;
        }else{
            if(tempFaculty!=null) {
                tempSec.faculty = tempFaculty.facultyName;
                tempFaculty.addCourseWithList(tempSec);
                return true;
            }else if(lastFaculty!=null){
                tempSec.faculty = lastFaculty.facultyName;
                lastFaculty.addCourseWithList(tempSec);
                return true;
            }
        }
        return false;
    }

    public void facultyAssign(){

        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFaculty!=null){

            courseAssign(tempFaculty);

            tempFaculty=tempFaculty.next;
        }


    }

    public void courseAssign(FacultyInfo tempFaculty){

        CourseToLinkedList tempCourseList=AddSearchCourse.courseHeadPointer;

        for(;tempCourseList!=null;tempCourseList=tempCourseList.next){

            CourseToLinkedListOthersInfo tempSecList=tempCourseList.firstSection;
            boolean facultySlotFull=false;

            for(;tempSecList!=null;tempSecList=tempSecList.next){
                if(tempSecList.faculty.equals("")) {

                    // if Slot full, then return;
                    if (tempFaculty.theory >= tempFaculty.theoryLimit && tempFaculty.lab >= tempFaculty.labLimit) {
                        facultySlotFull = true;
                        return;
                    }

                    // check if this is conflicted
                    CourseToLinkedListOthersInfo tempListForCheckConflicts = tempFaculty.firstSectionOfFaculty;
                    boolean conflicts = false;

                    while (tempListForCheckConflicts != null) {

                        if (tempSecList.islabClass && tempFaculty.lab < tempFaculty.labLimit) {

                            int diff = tempSecList.timeSlot - tempListForCheckConflicts.timeSlot;
                            if (tempListForCheckConflicts.islabClass) {
                                if (tempListForCheckConflicts.time.equals(tempSecList.time) && tempListForCheckConflicts.day.equals(tempSecList.day)) {
                                    conflicts = true;
                                    break;
                                }
                                // check class after 5 min in different campus
                                if(Math.abs(diff)==2 && tempSecList.campus==tempListForCheckConflicts.campus  && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)){
                                    conflicts = true;
                                    break;
                                }
                            } else {
                                if (diff <= 0 && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                    conflicts = true;
                                    break;
                                }
                                // check class after 5 min in different campus
                                if(Math.abs(diff)==1 && tempSecList.campus==tempListForCheckConflicts.campus  && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)){
                                    conflicts = true;
                                    break;
                                }
                            }
                        } else if (!tempSecList.islabClass && tempFaculty.theory < tempFaculty.theoryLimit) {

                            int diff = tempListForCheckConflicts.timeSlot-tempSecList.timeSlot;
                            if (!tempListForCheckConflicts.islabClass) {
                                if (tempListForCheckConflicts.time.equals(tempSecList.time) && tempListForCheckConflicts.day.equals(tempSecList.day)) {
                                    conflicts = true;
                                    break;
                                }
                                // check class after 5 min in different campus
                                if(Math.abs(diff)==1 && tempSecList.campus==tempListForCheckConflicts.campus  && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)){
                                    conflicts = true;
                                    break;
                                }
                            } else {
                                if (diff <= 0 && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                    conflicts = true;
                                    break;
                                }
                                // check class after 5 min in different campus
                                if(Math.abs(diff)==2 && tempSecList.campus==tempListForCheckConflicts.campus  && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)){
                                    conflicts = true;
                                    break;
                                }
                            }
                        }

                        tempListForCheckConflicts = tempListForCheckConflicts.next;
                    }

                    if (tempSecList.islabClass && tempFaculty.lab < tempFaculty.labLimit) {
                        if (!conflicts) {
                            tempFaculty.addCourseWithList(tempSecList);
                            tempSecList.faculty = tempFaculty.facultyName;
                        }
                    }else if (!tempSecList.islabClass && tempFaculty.theory < tempFaculty.theoryLimit) {
                        if (!conflicts) {
                            tempFaculty.addCourseWithList(tempSecList);
                            tempSecList.faculty = tempFaculty.facultyName;
                        }
                    }

                }

            }


        }

    }

    public int remainingSectionCount() {
        int counter=0;

        CourseToLinkedList tempList=AddSearchCourse.courseHeadPointer;
        while(tempList!=null){
            CourseToLinkedListOthersInfo tempSecList=tempList.firstSection;
            while(tempSecList!=null){

                if(tempSecList.faculty.equals("")) {
                    counter++;
                }

                tempSecList=tempSecList.next;
            }

            tempList=tempList.next;
        }

        return counter;
    }


    public void deleteSomeSectionRandomly() {
        ArrayList<CourseToLinkedListOthersInfo> secArrayList=new ArrayList<>();

        CourseToLinkedList tempList=AddSearchCourse.courseHeadPointer;
        while(tempList!=null){
            CourseToLinkedListOthersInfo tempSecList=tempList.firstSection;
            while(tempSecList!=null){

                secArrayList.add(tempSecList);

                tempSecList=tempSecList.next;
            }

            tempList=tempList.next;
        }

        Random rand=new Random();

        for(int i=0;i<20;){
            int index=rand.nextInt(secArrayList.size());
            CourseToLinkedListOthersInfo gotTempSec=secArrayList.get(index);
            if(!gotTempSec.faculty.equals("")){
                FacultyInfo gotTempFac=AddRemoveSearchFaculty.searchFaculty(gotTempSec.faculty);
                if(gotTempFac!=null && gotTempFac.priority>2){
                    //CourseToLinkedList gotTempList=AddSearchCourse.searchCourseWithTitle(gotTempSec.title);
                    //CourseToLinkedListOthersInfo tempSec=gotTempList.searchSection(gotTempSec.section);
                    gotTempFac.removeCourseWithTitleAndSecion(gotTempSec.title,gotTempSec.section);
                    gotTempSec.faculty="";
                    i++;
                }
            }
        }

        secArrayList.clear();

        
    }

}
