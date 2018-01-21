/**
 * Created by mimtiaze on 02-Aug-16.
 */
public class AutoGenerate {


    public AutoGenerate(){
        CourseToLinkedList tempListOfCourse=AddSearchCourse.courseHeadPointer;
        while(tempListOfCourse!=null){

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

        for(int i=0;i<10;i++) {
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
        }

        System.out.println("Done Auto Generating.. Thank you for using this app");

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
}
