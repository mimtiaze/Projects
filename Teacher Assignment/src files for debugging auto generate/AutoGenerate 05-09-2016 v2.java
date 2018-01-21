import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTOuterShadowEffectImpl;

import java.util.*;

/**
 * Created by mimtiaze on 02-Aug-16.
 */
public class AutoGenerate extends Thread{

    public static ArrayList<StoredRoutine> fullRoutines;

    public void run(){
        System.out.println("RUN");

        try{
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("autoGenerate.fxml"));
            Scene newScene=new Scene(root,850,500);

            Stage newStage = new Stage();

            newStage.setScene(newScene);
            newStage.setResizable(false);
            newStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

    }

    public void createThread(){
        System.out.println("Create Thread");
        Thread t=new Thread();
        t.start();
    }

    public AutoGenerate() {
        //createThread();

        CourseToLinkedList tempListOfCourse = AddSearchCourse.courseHeadPointer;

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

        // again loop will be start from beginning, for check is all section are assigned
        // is there are section not assigned, then it will forced to some faculty who have empty slot for courses to take not assigned courses

        /*for(int i=0;i<1;i++) {
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
        System.out.println("Starts Auto Generator");

        //progressBar=new ProgressBar();
        //progressBar.setProgress(10);

        reset();

        facultyAssignByPrevTrimester();
        facultyAssign();


        //assignByCourse();

        int secRemaining;

        /*while (secRemaining != 0) {
            if (secRemaining > 0) {
                deleteSomeSectionRandomly();
                facultyAssign();
                //assignByCourse();

            }
            secRemaining = remainingSectionCount();
        }*/


        //System.out.println("Done Auto Generating.. Thank you for using this app");

        fullRoutines=new ArrayList<>();

        for (int i = 0; i < 1000; i++) {

            deleteSomeSectionRandomly();
            secRemaining = remainingSectionCount();
            while (secRemaining != 0) {
                if (secRemaining > 0) {
                    deleteSomeSectionRandomly();
                    facultyAssign();
                    //assignByCourse();
                }
                secRemaining = remainingSectionCount();
            }

            System.out.println(i);
            StoredRoutine storing=new StoredRoutine();
            /*CourseToLinkedList tempList = AddSearchCourse.courseHeadPointer;
            while (tempList != null) {
                CourseToLinkedListOthersInfo tempSecList = tempList.firstSection;
                while (tempSecList != null) {
                    //fullRoutines.add(tempSecList);

                    storing.routines.add(tempSecList);
                    tempSecList = tempSecList.next;
                }
                tempList = tempList.next;
            }*/
            FacultyInfo tempFacultyList=AddRemoveSearchFaculty.facultyHeadPointer;
            while(tempFacultyList!=null) {
                CourseToLinkedListOthersInfo tempSecList = tempFacultyList.tempSectionOfFaculty;
                while(tempSecList!=null){
                    storing.routines.add(tempSecList);
                    tempSecList=tempSecList.next;
                }
                tempFacultyList=tempFacultyList.next;
            }

            storing=alphaingAllRoutine(storing);
            //System.out.println("Saved");
            fullRoutines.add(storing);

        }

        // sorting
        Collections.sort(fullRoutines, new Comparator<StoredRoutine>() {
            @Override
            public int compare(StoredRoutine o1, StoredRoutine o2) {
                return o2.alpha-o1.alpha;
            }
        });

        System.out.println(fullRoutines.size());

        for(StoredRoutine i:fullRoutines){
            System.out.println(i.alpha);
        }



        // FOr debug
        /*for(int i=0;i<fullRoutines.size()-1;i++){
            System.out.println(fullRoutines.get(i).alpha);
            StoredRoutine prevRoutine=fullRoutines.get(i);
            StoredRoutine presentRoutine=fullRoutines.get(i+1);

            for(int j=0;j<prevRoutine.routines.size();j++){
                CourseToLinkedListOthersInfo prev=prevRoutine.routines.get(j);
                for(int k=0;k<presentRoutine.routines.size();k++){
                    CourseToLinkedListOthersInfo present=presentRoutine.routines.get(k);
                    if(prev.title.equals(present.title) && prev.section.equals(present.section) &&
                            !prev.faculty.equals(present.faculty))
                    {
                        System.out.println(present.title+" "+present.section+" "+present.faculty);
                    }
                }
            }
        }*/

    }


    public StoredRoutine alphaingAllRoutine(StoredRoutine storing) {
        storing.alpha=0;
        FacultyInfo tempFacultyList=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFacultyList!=null){

            CourseToLinkedListOthersInfo tempSecList=tempFacultyList.tempSectionOfFaculty;
            // Marking according to campus change in 5min class break
            tempSecList=tempFacultyList.tempSectionOfFaculty;
            while(tempSecList!=null){

                CourseToLinkedListOthersInfo tempSecListSecond=tempSecList.next;
                while(tempSecListSecond!=null){

                    int diff=Math.abs(tempSecList.timeSlot-tempSecListSecond.timeSlot);
                    int campusDiff=Math.abs(tempSecList.campus-tempSecListSecond.campus);
                    if(tempSecList.islabClass && tempSecListSecond.islabClass && diff==2 && campusDiff==1 || campusDiff==2)
                        storing.alpha-=40;
                    if(!tempSecList.islabClass && !tempSecListSecond.islabClass && diff==1 && campusDiff==1 || campusDiff==2)
                        storing.alpha-=40;
                    if(tempSecList.islabClass && !tempSecListSecond.islabClass) {
                        int timeDiff=tempSecListSecond.timeSlot-tempSecList.timeSlot;
                        if(timeDiff==-1 || timeDiff==2){
                            storing.alpha-=40;
                        }
                    }
                    if(!tempSecList.islabClass && tempSecListSecond.islabClass) {
                        int timeDiff=tempSecList.timeSlot-tempSecListSecond.timeSlot;
                        if(timeDiff==-1 || timeDiff==2){
                            storing.alpha-=40;
                        }
                    }

                    tempSecListSecond=tempSecListSecond.next;
                }
                tempSecList=tempSecList.next;
            }

            // alphaing according to inter class break;
            tempSecList=tempFacultyList.tempSectionOfFaculty;
            while(tempSecList!=null){

                CourseToLinkedListOthersInfo tempSecListSecond=tempSecList.next;
                while(tempSecListSecond!=null){

                    int maxBreak=Math.abs(tempSecList.timeSlot-tempSecListSecond.timeSlot);
                    if(maxBreak<=tempFacultyList.maxClassBreak)
                        storing.alpha+=10;
                    else{
                        storing.alpha-=10*(maxBreak-tempFacultyList.maxClassBreak);
                    }

                    tempSecListSecond=tempSecListSecond.next;
                }
                tempSecList=tempSecList.next;
            }

            // alphaing according to taken course at previous trimester
            tempSecList=tempFacultyList.tempSectionOfFaculty;
            while(tempSecList!=null){

                CourseToLinkedListOthersInfo tempSecListSecond=tempFacultyList.prevTrimesterDataOfFaculty;
                while(tempSecListSecond!=null){

                    if(tempSecList.title.equals(tempSecListSecond.title))
                        storing.alpha+=20;

                    tempSecListSecond=tempSecListSecond.next;
                }
                tempSecList=tempSecList.next;
            }

            // alphaing according to taken course at second previous trimester
            tempSecList=tempFacultyList.tempSectionOfFaculty;
            while(tempSecList!=null){

                CourseToLinkedListOthersInfo tempSecListSecond=tempFacultyList.secondPrevTrimesterDataOfFaculty;
                while(tempSecListSecond!=null){

                    if(tempSecList.title.equals(tempSecListSecond.title))
                        storing.alpha+=10;

                    tempSecListSecond=tempSecListSecond.next;
                }
                tempSecList=tempSecList.next;
            }



            tempFacultyList=tempFacultyList.next;
        }

        return storing;

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

            CourseToLinkedListOthersInfo takenByThisFaculty = tempFaculty.tempSectionOfFaculty;
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

        CourseToLinkedListOthersInfo takenByThisFaculty = tempFaculty.tempSectionOfFaculty;
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

            CourseToLinkedListOthersInfo takenByThisFaculty = tempFaculty.tempSectionOfFaculty;
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

    public void facultyAssignByPrevTrimester(){
        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFaculty!=null){

            courseAssignByPrevTrimester(tempFaculty);

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
                    if (tempFaculty.tempTheory >= tempFaculty.theoryLimit && tempFaculty.tempLab >= tempFaculty.labLimit) {
                        facultySlotFull = true;
                        return;
                    }

                    // check if this is conflicted
                    CourseToLinkedListOthersInfo tempListForCheckConflicts = tempFaculty.tempSectionOfFaculty;
                    boolean conflicts = false;

                    while (tempListForCheckConflicts != null) {

                        if (tempSecList.islabClass && tempFaculty.tempLab < tempFaculty.labLimit) {

                            int diff = tempSecList.timeSlot - tempListForCheckConflicts.timeSlot;
                            if (tempListForCheckConflicts.islabClass) {
                                if (tempListForCheckConflicts.time.equals(tempSecList.time) && tempListForCheckConflicts.day.equals(tempSecList.day)) {
                                    conflicts = true;
                                    break;
                                }
                                // check class after 5 min in different campus
                                if(Math.abs(diff)==2 && tempSecList.campus!=tempListForCheckConflicts.campus  && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)){
                                    conflicts = true;
                                    break;
                                }
                            } else {
                                if (diff <= 0 && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                    conflicts = true;
                                    break;
                                }
                                // check class after 5 min in different campus
                                if(Math.abs(diff)==1 && tempSecList.campus!=tempListForCheckConflicts.campus  && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)){
                                    conflicts = true;
                                    break;
                                }
                            }
                        }
                        else if (!tempSecList.islabClass && tempFaculty.tempTheory < tempFaculty.theoryLimit) {

                            int diff = tempListForCheckConflicts.timeSlot-tempSecList.timeSlot;
                            if (!tempListForCheckConflicts.islabClass) {
                                if (tempListForCheckConflicts.time.equals(tempSecList.time) && tempListForCheckConflicts.day.equals(tempSecList.day)) {
                                    conflicts = true;
                                    break;
                                }
                                // check class after 5 min in different campus
                                if(Math.abs(diff)==1 && tempSecList.campus!=tempListForCheckConflicts.campus  && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)){
                                    conflicts = true;
                                    break;
                                }
                            } else {
                                if (diff <= 0 && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                    conflicts = true;
                                    break;
                                }
                                // check class after 5 min in different campus
                                if(Math.abs(diff)==2 && tempSecList.campus!=tempListForCheckConflicts.campus  && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)){
                                    conflicts = true;
                                    break;
                                }
                            }
                        }

                        tempListForCheckConflicts = tempListForCheckConflicts.next;
                    }

                    if (tempSecList.islabClass && tempFaculty.tempLab < tempFaculty.labLimit) {
                        if (!conflicts) {
                            //tempFaculty.addCourseWithList(tempSecList);
                            tempSecList.faculty = tempFaculty.facultyName;
                            tempFaculty.addCourseWithListInTempList(tempSecList);
                        }
                    }else if (!tempSecList.islabClass && tempFaculty.tempTheory < tempFaculty.theoryLimit) {
                        if (!conflicts) {
                            //tempFaculty.addCourseWithList(tempSecList);
                            tempSecList.faculty = tempFaculty.facultyName;
                            tempFaculty.addCourseWithListInTempList(tempSecList);
                        }
                    }

                }

            }


        }

    }


    public void courseAssignByPrevTrimester(FacultyInfo tempFaculty){

        CourseToLinkedList tempCourseList=AddSearchCourse.courseHeadPointer;

        for(;tempCourseList!=null;tempCourseList=tempCourseList.next){
            boolean takenThisCourseInPrevTrimester=false;
            CourseToLinkedListOthersInfo takenThisCourseInPrevTrimesterList=tempFaculty.prevTrimesterDataOfFaculty;

            while(takenThisCourseInPrevTrimesterList!=null){

                if(takenThisCourseInPrevTrimesterList.title.equals(tempCourseList.title))
                    takenThisCourseInPrevTrimester=true;

                takenThisCourseInPrevTrimesterList=takenThisCourseInPrevTrimesterList.next;
            }


            if(takenThisCourseInPrevTrimester) {
                CourseToLinkedListOthersInfo tempSecList = tempCourseList.firstSection;

                for (; tempSecList != null; tempSecList = tempSecList.next) {
                    if (tempSecList.faculty.equals("")) {

                        // if Slot full, then return;
                        if (tempFaculty.tempTheory >= tempFaculty.theoryLimit && tempFaculty.tempLab >= tempFaculty.labLimit) {
                            return;
                        }

                        // check if this is conflicted
                        CourseToLinkedListOthersInfo tempListForCheckConflicts = tempFaculty.tempSectionOfFaculty;
                        boolean conflicts = false;

                        while (tempListForCheckConflicts != null) {

                            if (tempSecList.islabClass && tempFaculty.tempLab < tempFaculty.labLimit) {

                                int diff = tempSecList.timeSlot - tempListForCheckConflicts.timeSlot;
                                if (tempListForCheckConflicts.islabClass) {
                                    if (tempListForCheckConflicts.time.equals(tempSecList.time) && tempListForCheckConflicts.day.equals(tempSecList.day)) {
                                        conflicts = true;
                                        break;
                                    }
                                    // check class after 5 min in different campus
                                    if (Math.abs(diff) == 2 && tempSecList.campus != tempListForCheckConflicts.campus && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                        conflicts = true;
                                        break;
                                    }
                                } else {
                                    if (diff <= 0 && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                        conflicts = true;
                                        break;
                                    }
                                    // check class after 5 min in different campus
                                    if (Math.abs(diff) == 1 && tempSecList.campus != tempListForCheckConflicts.campus && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                        conflicts = true;
                                        break;
                                    }
                                }
                            } else if (!tempSecList.islabClass && tempFaculty.tempTheory < tempFaculty.theoryLimit) {

                                int diff = tempListForCheckConflicts.timeSlot - tempSecList.timeSlot;
                                if (!tempListForCheckConflicts.islabClass) {
                                    if (tempListForCheckConflicts.time.equals(tempSecList.time) && tempListForCheckConflicts.day.equals(tempSecList.day)) {
                                        conflicts = true;
                                        break;
                                    }
                                    // check class after 5 min in different campus
                                    if (Math.abs(diff) == 1 && tempSecList.campus != tempListForCheckConflicts.campus && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                        conflicts = true;
                                        break;
                                    }
                                } else {
                                    if (diff <= 0 && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                        conflicts = true;
                                        break;
                                    }
                                    // check class after 5 min in different campus
                                    if (Math.abs(diff) == 2 && tempSecList.campus != tempListForCheckConflicts.campus && (tempSecList.day1 == tempListForCheckConflicts.day1 || tempSecList.day2 == tempListForCheckConflicts.day2 || tempSecList.day1 == tempListForCheckConflicts.day2 || tempSecList.day2 == tempListForCheckConflicts.day1)) {
                                        conflicts = true;
                                        break;
                                    }
                                }
                            }

                            tempListForCheckConflicts = tempListForCheckConflicts.next;
                        }

                        if (tempSecList.islabClass && tempFaculty.tempLab < tempFaculty.labLimit) {
                            if (!conflicts) {
                                //tempFaculty.addCourseWithList(tempSecList);
                                tempSecList.faculty = tempFaculty.facultyName;
                                tempFaculty.addCourseWithListInTempList(tempSecList);

                            }
                        } else if (!tempSecList.islabClass && tempFaculty.tempTheory < tempFaculty.theoryLimit) {
                            if (!conflicts) {
                                //tempFaculty.addCourseWithList(tempSecList);
                                tempSecList.faculty = tempFaculty.facultyName;
                                tempFaculty.addCourseWithListInTempList(tempSecList);

                            }
                        }

                    }

                }

            }
        }

    }

    public int remainingSectionCount() {
        int counter=0;

        /*CourseToLinkedList tempList=AddSearchCourse.courseHeadPointer;
        while(tempList!=null){
            CourseToLinkedListOthersInfo tempSecList=tempList.firstSection;
            while(tempSecList!=null){

                if(tempSecList.faculty.equals("")) {
                    counter++;
                }

                tempSecList=tempSecList.next;
            }

            tempList=tempList.next;
        }*/

        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFaculty!=null){

            counter=counter+(tempFaculty.theoryLimit-tempFaculty.tempTheory)+(tempFaculty.labLimit-tempFaculty.tempLab);

            tempFaculty=tempFaculty.next;
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

        for(int i=0;i<50;){
            int index=rand.nextInt(secArrayList.size());
            CourseToLinkedListOthersInfo gotTempSec=secArrayList.get(index);
            if(!gotTempSec.faculty.equals("") && !gotTempSec.faculty.equals("Drop")){
                FacultyInfo gotTempFac=AddRemoveSearchFaculty.searchFaculty(gotTempSec.faculty);
                //if(gotTempFac!=null && gotTempFac.priority>2){
                if(gotTempFac!=null){
                    //CourseToLinkedList gotTempList=AddSearchCourse.searchCourseWithTitle(gotTempSec.title);
                    //CourseToLinkedListOthersInfo tempSec=gotTempList.searchSection(gotTempSec.section);
                    CourseToLinkedListOthersInfo gotTempFacultyFirstSection=gotTempFac.searchCourseAndSection(gotTempSec.title,gotTempSec.section);

                    if(gotTempFacultyFirstSection==null) {

                        CourseToLinkedList tempCourseListForRemove = AddSearchCourse.searchCourseWithTitle(gotTempSec.title);
                        if (tempCourseListForRemove != null) {
                            CourseToLinkedListOthersInfo tempSectionListForRemove = tempCourseListForRemove.searchSection(gotTempSec.section);
                            if (tempSectionListForRemove != null)
                                tempSectionListForRemove.faculty = "";
                        }

                        gotTempFac.removeCourseFromTempList(gotTempSec.title, gotTempSec.section);
                        //gotTempSec.faculty = "";

                        i++;
                    }

                }
            }
        }

        secArrayList.clear();

        /*for(FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;tempFaculty!=null;tempFaculty=tempFaculty.next){
            for(CourseToLinkedListOthersInfo tempListOfThisFac=tempFaculty.firstSectionOfFaculty;tempListOfThisFac!=null;tempListOfThisFac=tempListOfThisFac.next){
                CourseToLinkedListOthersInfo searchFound=tempFaculty.searchCourseAndSectionInTempList(tempListOfThisFac.title,tempListOfThisFac.section);
                if(searchFound==null){
                    tempFaculty.addCourseWithListInTempList(tempListOfThisFac);

                    CourseToLinkedList tempCourseListForReassign=AddSearchCourse.searchCourseWithTitle(tempListOfThisFac.title);
                    if(tempCourseListForReassign!=null){
                        CourseToLinkedListOthersInfo tempSectionForReassign=tempCourseListForReassign.searchSection(tempListOfThisFac.section);
                        if(tempSectionForReassign!=null){
                            tempSectionForReassign.faculty=tempFaculty.facultyName;
                        }
                    }
                }
            }
        }*/


        // Adding those section which are selected by admin but deleted by this function
        /*FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFaculty!=null){

            CourseToLinkedListOthersInfo tempSection=tempFaculty.firstSectionOfFaculty;
            while(tempSection!=null){

                CourseToLinkedListOthersInfo searchFound=tempFaculty.searchCourseAndSectionInTempList(tempSection.title,tempSection.section);
                if(searchFound==null){
                    tempFaculty.addCourseWithListInTempList(tempSection);
                }
                else {
                    searchFound.faculty = tempFaculty.facultyName;
                }

                CourseToLinkedList tempCourseListForReassign=AddSearchCourse.searchCourseWithTitle(tempSection.title);
                if(tempCourseListForReassign!=null){
                    CourseToLinkedListOthersInfo tempSectionForReassign=tempCourseListForReassign.searchSection(tempSection.section);
                    if(tempSectionForReassign!=null){
                        tempSectionForReassign.faculty=tempFaculty.facultyName;
                    }
                }

                tempSection=tempSection.next;
            }

            tempFaculty=tempFaculty.next;
        }*/
        
    }


    public void reset() {
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
    }

}
