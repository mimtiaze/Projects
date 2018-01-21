import java.util.ArrayList;

/**
 * Created by mimtiaze on 12-Aug-16.
 */
public class AutoGenerateAllPossibleRoutine {
    public static FacultyStructureForAutoGenerate faculties[];
    public static CourseStructureForAutoGenerate courses[];
    public static CompleteRoutineStructureHavingOnlyIndexValue routineHeadPointer;

    public static int facultyCounter=0;
    public static int courseCounter=0;
    public static int completeRoutineCounter=0;
    public int  completeRoutineRowTracker=0;
    public int maxBreak=4;

    public int getCourseCounter() {
        return courseCounter;
    }

    public void setCourseCounter(int courseCounter) {
        this.courseCounter = courseCounter;
    }

    public CourseStructureForAutoGenerate[] getCourses() {
        return courses;
    }

    public void setCourses(CourseStructureForAutoGenerate[] courses) {
        this.courses = courses;
    }

    public FacultyStructureForAutoGenerate[] getFaculties() {
        return faculties;
    }

    public void setFaculties(FacultyStructureForAutoGenerate[] faculties) {
        this.faculties = faculties;
    }

    public int getFacultyCounter() {
        return facultyCounter;
    }

    public void setFacultyCounter(int facultyCounter) {
        this.facultyCounter = facultyCounter;
    }

    public AutoGenerateAllPossibleRoutine(){

        // ***********************  Creating Structure *******************************
        facultyCounter=0;
        courseCounter=0;

        // counting faculty
        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFaculty!=null){
            facultyCounter++;
            tempFaculty=tempFaculty.next;
        }

        // creating an structure array
        faculties = new FacultyStructureForAutoGenerate[facultyCounter];
        for(int i=0;i<facultyCounter;i++){
            faculties[i]=new FacultyStructureForAutoGenerate();
        }

        // copying all info to structure
        tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        for(int i=0;tempFaculty!=null;i++){

            faculties[i].facultyName=tempFaculty.getFacultyName();
            faculties[i].isAdmin=tempFaculty.isAdmin();
            faculties[i].password=tempFaculty.getPassword();
            faculties[i].priority=tempFaculty.getPriority();
            faculties[i].lab=tempFaculty.getLab();
            faculties[i].labLimit=tempFaculty.getLabLimit();
            faculties[i].theory=tempFaculty.getTheory();
            faculties[i].theoryLimit=tempFaculty.getTheoryLimit();
            faculties[i].totalCourse=tempFaculty.getTotalCourse();
            faculties[i].isRequested=tempFaculty.isRequested();
            faculties[i].firstSectionOfFaculty=tempFaculty.getFirstSectionOfFaculty();
            faculties[i].prevTrimesterDataOfFaculty=tempFaculty.getPrevTrimesterDataOfFaculty();
            faculties[i].secondPrevTrimesterDataOfFaculty=tempFaculty.getSecondPrevTrimesterDataOfFaculty();
            faculties[i].thirdPrevTrimesterDataOfFaculty=tempFaculty.getThirdPrevTrimesterDataOfFaculty();

            faculties[i].tempLab=tempFaculty.getLab();
            faculties[i].tempTheory=tempFaculty.getTheory();
            faculties[i].isProcessing=false;
            faculties[i].tempSectionOfFaculty=tempFaculty.getFirstSectionOfFaculty();
            faculties[i].courseListForDebugging=null;


            tempFaculty=tempFaculty.next;
        }


        // Counting Courses
        CourseToLinkedList tempList=AddSearchCourse.courseHeadPointer;
        while(tempList!=null){
            CourseToLinkedListOthersInfo tempSecList=tempList.firstSection;
            while(tempSecList!=null){
                if(!tempSecList.faculty.equals("Drop"))
                    courseCounter++;

                tempSecList=tempSecList.next;
            }
            tempList=tempList.next;
        }

        // initializing
        courses = new CourseStructureForAutoGenerate[courseCounter];
        for(int i=0;i<courseCounter;i++){
            courses[i]=new CourseStructureForAutoGenerate();
        }

        // Copying Courses
        tempList=AddSearchCourse.courseHeadPointer;
        for(int i=0;tempList!=null;){
            CourseToLinkedListOthersInfo tempSecList=tempList.firstSection;
            while(tempSecList!=null){
                if(!tempSecList.faculty.equals("Drop")) {
                    courses[i].code = tempSecList.getCode();
                    courses[i].title = tempSecList.getTitle();
                    courses[i].section = tempSecList.getSection();
                    courses[i].day = tempSecList.getDay();
                    courses[i].day1 = tempSecList.getDay1();
                    courses[i].day2 = tempSecList.getDay2();
                    courses[i].time = tempSecList.getTime();
                    courses[i].faculty = tempSecList.getFaculty();
                    courses[i].campus = tempSecList.getCampus();
                    courses[i].islabClass = tempSecList.islabClass();
                    courses[i].timeSlot = tempSecList.getTimeSlot();
                    courses[i].labTimeSlot = tempSecList.getLabTimeSlot();

                    courses[i].booked = false;
                    i++;
                }

                tempSecList=tempSecList.next;
            }
            tempList=tempList.next;
        }
        //*************************  All Structure Created *****************************

        /*routine=new CompleteRoutineStructureHavingOnlyIndexValue[1];
        routine[0]=new CompleteRoutineStructureHavingOnlyIndexValue();
        for(int i=0;i<facultyCounter;i++)
            for(int j=0;j<20;j++)
                routine[0].routines[i][j]=-1;
        */

        //facultyOnGoing();
        facultyOnGoingPart2();

    }


    public int searchSecFromCourseStruct(CourseToLinkedListOthersInfo sec){
        for(int i=0;i<courseCounter;i++){
            if(sec.title.equals(courses[i].title) && sec.section.equals(courses[i].section))
                return i;
        }

        return -1;
    }


    public void facultyOnGoingPart2(){
        boolean takeTheRoutine=true;
        for(int i=0;i<facultyCounter;i++){
            if(!faculties[i].isProcessing){
                faculties[i].isProcessing=true;
                takeTheRoutine=false;
                courseOnGoingPart2(faculties[i]);
                faculties[i].isProcessing=false;
                faculties[i].courseListForDebugging=null;
            }
        }

        if(takeTheRoutine){
            // create a complete routine structure and save this routine

            if(routineHeadPointer==null){
                // creating node
                routineHeadPointer=new CompleteRoutineStructureHavingOnlyIndexValue();

                // resetting all value
                for(int i=0;i<facultyCounter;i++) {
                    for(int j=0;j<20;j++){                 // I took 20 size of array on that structure
                        routineHeadPointer.routines[i][j]=-1;
                    }
                }

                // now add all value;
                for(int i=0;i<facultyCounter;i++){
                    int columnTracker=0;
                    routineHeadPointer.routines[i][columnTracker++]=i;

                    CourseToLinkedListOthersInfo tempListForAddingTheirIndexValue=faculties[i].tempSectionOfFaculty;
                    while (tempListForAddingTheirIndexValue!=null){

                        int courseIndex=searchSecFromCourseStruct(tempListForAddingTheirIndexValue);
                        routineHeadPointer.routines[i][columnTracker++]=courseIndex;

                        tempListForAddingTheirIndexValue=tempListForAddingTheirIndexValue.next;
                    }
                }

                routineHeadPointer.next=null;
            }
            else {
                // Going to the last node
                CompleteRoutineStructureHavingOnlyIndexValue temp = routineHeadPointer;
                while (temp.next != null) {
                    temp = temp.next;
                }

                // creating new node
                CompleteRoutineStructureHavingOnlyIndexValue newTemp = new CompleteRoutineStructureHavingOnlyIndexValue();

                // resetting all value
                for (int i = 0; i < facultyCounter; i++) {
                    for (int j = 0; j < 20; j++) {                 // I took 20 size of array on that structure
                        newTemp.routines[i][j] = -1;
                    }
                }

                // now add all value;
                for (int i = 0; i < facultyCounter; i++) {
                    int columnTracker = 0;
                    newTemp.routines[i][columnTracker++] = i;

                    CourseToLinkedListOthersInfo tempListForAddingTheirIndexValue = faculties[i].tempSectionOfFaculty;
                    while (tempListForAddingTheirIndexValue != null) {

                        int courseIndex = searchSecFromCourseStruct(tempListForAddingTheirIndexValue);
                        newTemp.routines[i][columnTracker++] = courseIndex;

                        tempListForAddingTheirIndexValue = tempListForAddingTheirIndexValue.next;
                    }
                }

                temp.next = newTemp;
                newTemp.next = null;
            }
            completeRoutineCounter++;
        }

        System.out.println("Complete routine: "+completeRoutineCounter);
        // Done :D

    }

    public void courseOnGoingPart2(FacultyStructureForAutoGenerate facultyOnAction){
        if(facultyOnAction.tempTheory==facultyOnAction.theoryLimit && facultyOnAction.tempLab==facultyOnAction.labLimit) {
            facultyOnGoingPart2();
        }
        else{
            for(int i=0;i<courseCounter;i++) {
                if(!courses[i].booked) {
                    CourseToLinkedListOthersInfo tempSecList = facultyOnAction.courseListForDebugging;
                    boolean takenPreviousCriteria = false;

                    while (tempSecList != null) {
                        if (tempSecList.title.equals(courses[i].title) && tempSecList.section.equals(courses[i].section)) {
                            takenPreviousCriteria = true;
                            break;
                        }
                        tempSecList = tempSecList.next;
                    }

                    if (takenPreviousCriteria)
                        continue;


                    if (courses[i].islabClass && facultyOnAction.tempLab < facultyOnAction.labLimit) {
                        // check conflict for lab class

                        CourseToLinkedListOthersInfo tempList = facultyOnAction.tempSectionOfFaculty;
                        boolean conflicts = false;
                        while (tempList != null) {

                            if (tempList.islabClass) {
                                if (tempList.time.equals(courses[i].time) && tempList.day.equals(courses[i].day)) {
                                    conflicts = true;
                                    break;
                                }
                                else{
                                    if(Math.abs(courses[i].timeSlot-tempList.timeSlot)==2 && courses[i].campus!=tempList.campus){
                                        conflicts=true;
                                        break;
                                    }
                                    else if(Math.abs(courses[i].timeSlot-tempList.timeSlot)>maxBreak){
                                        conflicts=true;
                                        break;
                                    }
                                }
                            } else {
                                int diff = courses[i].timeSlot - tempList.timeSlot;
                                if (diff <= 0 && (courses[i].day1 == tempList.day1 || courses[i].day2 == tempList.day2 || courses[i].day1 == tempList.day2 || courses[i].day2 == tempList.day1)) {
                                    conflicts = true;
                                    break;
                                }
                                else{
                                    if(Math.abs(courses[i].timeSlot-tempList.timeSlot)==1 && courses[i].campus!=tempList.campus){
                                        conflicts=true;
                                        break;
                                    }
                                    else if(Math.abs(courses[i].timeSlot-tempList.timeSlot)>maxBreak){
                                        conflicts=true;
                                        break;
                                    }
                                }
                            }
                            tempList = tempList.next;
                        }

                        if (!conflicts) {
                            // Assign
                            facultyOnAction.addCourseWithList(courses[i]);
                            facultyOnAction.addCourseToDebuggingPointer(courses[i]);
                            courses[i].booked=true;

                            // recursion
                            courseOnGoingPart2(facultyOnAction);

                            // remove
                            facultyOnAction.removeCourseWithTitleAndSecion(courses[i].title, courses[i].section);
                            courses[i].booked=false;

                            // recursion
                            courseOnGoingPart2(facultyOnAction);

                            // break
                            return;
                        } else {
                            continue;
                        }
                    } else if (!courses[i].islabClass && facultyOnAction.tempTheory < facultyOnAction.theoryLimit) {
                        // check conflict for lab class

                        CourseToLinkedListOthersInfo tempList = facultyOnAction.tempSectionOfFaculty;
                        boolean conflicts = false;
                        while (tempList != null) {

                            if (!tempList.islabClass) {
                                if (tempList.time.equals(courses[i].time) && tempList.day.equals(courses[i].day)) {
                                    conflicts = true;
                                    break;
                                }
                                else{
                                    if(Math.abs(courses[i].timeSlot-tempList.timeSlot)==1 && courses[i].campus!=tempList.campus){
                                        conflicts=true;
                                        break;
                                    }
                                    else if(Math.abs(courses[i].timeSlot-tempList.timeSlot)>maxBreak){
                                        conflicts=true;
                                        break;
                                    }
                                }
                            } else {
                                int diff = tempList.timeSlot - courses[i].timeSlot;
                                if (diff <= 0 && (courses[i].day1 == tempList.day1 || courses[i].day2 == tempList.day2 || courses[i].day1 == tempList.day2 || courses[i].day2 == tempList.day1)) {
                                    conflicts = true;
                                    break;
                                }
                                else{
                                    if(Math.abs(courses[i].timeSlot-tempList.timeSlot)==1 && courses[i].campus!=tempList.campus){
                                        conflicts=true;
                                        break;
                                    }
                                    else if(Math.abs(courses[i].timeSlot-tempList.timeSlot)>maxBreak){
                                        conflicts=true;
                                        break;
                                    }
                                }
                            }
                            tempList = tempList.next;
                        }

                        if (!conflicts) {
                            // Assign
                            facultyOnAction.addCourseWithList(courses[i]);
                            facultyOnAction.addCourseToDebuggingPointer(courses[i]);
                            courses[i].booked=true;

                            // recursion
                            courseOnGoingPart2(facultyOnAction);

                            // remove
                            facultyOnAction.removeCourseWithTitleAndSecion(courses[i].title, courses[i].section);
                            courses[i].booked=false;

                            // recursion
                            courseOnGoingPart2(facultyOnAction);

                            // break
                            return;
                        } else {
                            continue;
                        }
                    }
                }

            }
        }

        return;
    }











    /*public void facultyOnGoing(){

        for(int i=0;i<facultyCounter;i++){
            if(faculties[i].tempLab<faculties[i].labLimit || faculties[i].tempTheory<faculties[i].theoryLimit){
                faculties[i].isProcessing=true;
                courseOnGoing(i);
            }
        }

        boolean prevRoutineCompleted=false;
        int howManyAreNotAssigned=0;

        for(int x=0;x<facultyCounter;x++){
            for(int y=0;y<3;y++){           // check the first 3 index
                if(routine[completeRoutineCounter].routines[x][y]==-1)
                    howManyAreNotAssigned++;
            }
            if(howManyAreNotAssigned>=3){
                prevRoutineCompleted=true;
                break;
            }
            else{
                howManyAreNotAssigned=0;
            }
        }

        //if(howManyAreNotAssigned>=3)
        //    prevRoutineCompleted=true;

        if(!prevRoutineCompleted) {

            completeRoutineCounter++;

            CompleteRoutineStructureHavingOnlyIndexValue tempRoutine[] = new CompleteRoutineStructureHavingOnlyIndexValue[completeRoutineCounter + 1];


            for (int i = 0; i < completeRoutineCounter; i++) {
                tempRoutine[i] = new CompleteRoutineStructureHavingOnlyIndexValue();
                tempRoutine[i].routines = routine[i].routines;
            }
            tempRoutine[completeRoutineCounter] = new CompleteRoutineStructureHavingOnlyIndexValue();
            //routine=tempRoutine;

            for (int i = 0; i < facultyCounter; i++)
                for (int j = 0; j < 20; j++)
                    tempRoutine[completeRoutineCounter].routines[i][j] = -1;

            routine = new CompleteRoutineStructureHavingOnlyIndexValue[completeRoutineCounter + 1];
            for (int i = 0; i < completeRoutineCounter + 1; i++) {
                routine[i] = new CompleteRoutineStructureHavingOnlyIndexValue();
            }

            for (int i = 0; i < completeRoutineCounter + 1; i++) {
                routine[i].routines = tempRoutine[i].routines;
            }
        }
    }

    public void courseOnGoing(int facultyIndex){

        if((faculties[facultyIndex].tempLab<faculties[facultyIndex].labLimit || faculties[facultyIndex].tempTheory<faculties[facultyIndex].theoryLimit)){
            for(int j=0;j<courseCounter;j++){

                // check if this same routine is already generated
                if(!courses[j].booked) {
                    boolean needToSkip = false;
                    boolean alreadyHaveThisSec = false;
                    boolean needToCheckTheLastOne = true;


                    for (int i = 0; i < completeRoutineCounter; i++) {
                        if (routine[i].routines[facultyIndex][0] == facultyIndex && routine[i].routines[facultyIndex][0] != -1) {
                            int columnTrucker = 1;
                            CourseToLinkedListOthersInfo tempList = faculties[facultyIndex].tempSectionOfFaculty;

                            while (tempList.next != null) {

                                int courseIndex = searchSecFromCourseStruct(tempList);

                                if (routine[i].routines[facultyIndex][columnTrucker] == courseIndex) {
                                    columnTrucker++;
                                } else {
                                    needToSkip = true;
                                    //alreadyHaveThisSec=true;
                                    needToCheckTheLastOne = false;
                                    break;
                                }

                                tempList = tempList.next;
                            }

                            if (needToCheckTheLastOne) {
                                if (tempList != null) {
                                    int courseIndex = searchSecFromCourseStruct(tempList);
                                    if (routine[i].routines[facultyIndex][columnTrucker] == courseIndex) {
                                        columnTrucker++;
                                        if(routine[i].routines[facultyIndex][columnTrucker] == j) {
                                            //needToSkip=true;
                                            alreadyHaveThisSec = true;
                                        }
                                    } else {
                                        needToSkip = true;
                                    }
                                }
                            }

                            if (alreadyHaveThisSec)
                                break;

                        }
                    }


                    if (alreadyHaveThisSec)
                        continue;


                    // check if it is lab
                    // check if it conflicts to other section
                    // if not then assign and check is still he have empty slot
                    // if he does, recall this function, else call facultyOnGoing function
                    // before calling facultyOnGoing, store current routine, because its now a complete routine for that faculty
                    // now remove that course, and recall this function
                    boolean conflicted = false;
                    if (courses[j].islabClass && faculties[facultyIndex].tempLab<faculties[facultyIndex].labLimit) {
                        CourseToLinkedListOthersInfo tempList = faculties[facultyIndex].tempSectionOfFaculty;
                        while (tempList != null) {

                            if (tempList.islabClass) {
                                if (tempList.time.equals(courses[j].time) && tempList.day.equals(courses[j].day)) {
                                    conflicted = true;
                                    break;
                                }
                            }
                            else{
                                int diff=courses[j].timeSlot-tempList.timeSlot;
                                if(diff<=0 && (courses[j].day1==tempList.day1 || courses[j].day2==tempList.day2)){
                                    conflicted=true;
                                    break;
                                }
                            }

                            tempList = tempList.next;
                        }


                        if(conflicted){
                            continue;
                        }else{
                            courses[j].booked=true;
                            faculties[facultyIndex].addCourseWithList(courses[j]);
                            if(faculties[facultyIndex].tempLab<faculties[facultyIndex].labLimit || faculties[facultyIndex].tempTheory<faculties[facultyIndex].theoryLimit){
                                courseOnGoing(facultyIndex);
                            }else{


                                //storing the routine
                                tempList = faculties[facultyIndex].tempSectionOfFaculty;
                                int columnTracker=0;
                                routine[completeRoutineCounter].routines[facultyIndex][columnTracker]=facultyIndex;
                                columnTracker++;
                                while (tempList!= null) {

                                    int courseIndex = searchSecFromCourseStruct(tempList);
                                    routine[completeRoutineCounter].routines[facultyIndex][columnTracker]=courseIndex;
                                    columnTracker++;

                                    tempList = tempList.next;
                                }
                                for(int x=0;x<facultyIndex;x++){
                                    for(int y=0;y<20;y++) {
                                        if(completeRoutineCounter-1>=0)
                                            routine[completeRoutineCounter].routines[x][y]=routine[completeRoutineCounter-1].routines[x][y];
                                    }
                                }

                                // now call next faculty ->
                                facultyOnGoing();

                                // now remove current section, and recall this function
                                faculties[facultyIndex].removeCourseWithTitleAndSecion(courses[j].title,courses[j].section);
                                courses[j].booked=false;
                                courseOnGoing(facultyIndex);
                            }
                        }
                    }




                    // check if it is theory
                    // check if it conflicts to other section
                    // if not then assign and check is still he have empty slot
                    // if he does, recall this function, else call facultyOnGoing function
                    // before calling facultyOnGoing, store current routine, because its now a complete routine for that faculty
                    // now remove that course, and recall this function
                    if (!courses[j].islabClass && faculties[facultyIndex].tempTheory<faculties[facultyIndex].theoryLimit) {
                        CourseToLinkedListOthersInfo tempList = faculties[facultyIndex].tempSectionOfFaculty;
                        while (tempList != null) {

                            if (!tempList.islabClass) {
                                if (tempList.time.equals(courses[j].time) && tempList.day.equals(courses[j].day)) {
                                    conflicted = true;
                                    break;
                                }
                            }
                            else{
                                int diff=tempList.timeSlot-courses[j].timeSlot;
                                if(diff<=0 && (courses[j].day1==tempList.day1 || courses[j].day2==tempList.day2)){
                                    conflicted=true;
                                    break;
                                }
                            }

                            tempList = tempList.next;
                        }


                        if(conflicted){
                            continue;
                        }else{
                            courses[j].booked=true;
                            faculties[facultyIndex].addCourseWithList(courses[j]);
                            if(faculties[facultyIndex].tempLab<faculties[facultyIndex].labLimit || faculties[facultyIndex].tempTheory<faculties[facultyIndex].theoryLimit){
                                courseOnGoing(facultyIndex);
                            }else{


                                //storing the routine
                                tempList = faculties[facultyIndex].tempSectionOfFaculty;
                                int columnTracker=0;
                                routine[completeRoutineCounter].routines[facultyIndex][columnTracker]=facultyIndex;
                                columnTracker++;
                                while (tempList!= null) {

                                    int courseIndex = searchSecFromCourseStruct(tempList);
                                    routine[completeRoutineCounter].routines[facultyIndex][columnTracker]=courseIndex;
                                    columnTracker++;

                                    tempList = tempList.next;
                                }
                                for(int x=0;x<facultyIndex;x++){
                                    for(int y=0;y<20;y++) {
                                        routine[completeRoutineCounter].routines[x][y]=routine[completeRoutineCounter-1].routines[x][y];
                                    }
                                }

                                // now call next faculty ->
                                facultyOnGoing();

                                // now remove current section, and recall this function
                                faculties[facultyIndex].removeCourseWithTitleAndSecion(courses[j].title,courses[j].section);
                                courses[j].booked=false;
                                courseOnGoing(facultyIndex);
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Done");
        return ;
    }*/
}
