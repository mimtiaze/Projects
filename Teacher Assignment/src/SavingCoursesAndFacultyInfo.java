import org.apache.poi.hssf.OldExcelFormatException;

import java.io.*;

/**
 * Created by mimtiaze on 07-Jul-16.
 */
public class SavingCoursesAndFacultyInfo{
    public static FacultyInfo headPointerForWrite;
    public static void savingFacultyInfo(){
        try {
            if(!logInController.isUser) {
                FileOutputStream fout = new FileOutputStream("Faculty Information.src");
                ObjectOutputStream objectStreamer = new ObjectOutputStream(fout);
                objectStreamer.writeObject(AddRemoveSearchFaculty.facultyHeadPointer);
                objectStreamer.close();
            }else{
                FileInputStream fin=new FileInputStream("Faculty Information.src");
                ObjectInputStream objectStreamer=new ObjectInputStream(fin);
                headPointerForWrite = (FacultyInfo) objectStreamer.readObject();
                FacultyInfo tempHeadPointer=headPointerForWrite;

                while(tempHeadPointer!=null){
                    if(tempHeadPointer.facultyName.equals(logInController.nowSelectedFaculty)){
                        //FacultyInfo tempFaculty=AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
                        if(logInController.userFacultyInfo!=null){
                            tempHeadPointer.requestedSectionOfFaculty = logInController.userFacultyInfo.requestedSectionOfFaculty;  // only that faculty's requestedList will update who is logged in,
                            tempHeadPointer.isRequested=true;
                            tempHeadPointer.password=logInController.userFacultyInfo.password;

                            //tempFaculty.tempSectionOfFaculty = tempHeadPointer.tempSectionOfFaculty;  // I want to make the tempList like before, User's selection will appear as request, but that change of tempList will reset

                        }
                    }
                    tempHeadPointer=tempHeadPointer.next;
                }

                FileOutputStream fout = new FileOutputStream("Faculty Information.src");
                ObjectOutputStream objectStreamer2 = new ObjectOutputStream(fout);
                objectStreamer2.writeObject(headPointerForWrite);
                objectStreamer2.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void loadingFacultyInfo(){
        try{
            FileInputStream fin=new FileInputStream("Faculty Information.src");
            ObjectInputStream objectStreamer=new ObjectInputStream(fin);
            FacultyInfo temp=(FacultyInfo) objectStreamer.readObject();
            AddRemoveSearchFaculty.facultyHeadPointer=temp;
        }catch(Exception e){
            e.printStackTrace();
        }

        restorePrevData();
    }



    public static void savingCoursesInfo(){
        try {
            FileOutputStream fout = new FileOutputStream("Course Information.src");
            ObjectOutputStream objectStreamer = new ObjectOutputStream(fout);
            objectStreamer.writeObject(AddSearchCourse.courseHeadPointer);
            objectStreamer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void loadingCoursesInfo(){
        try{

            if(logInController.isUser){
                FacultyInfo tempFaculty=AddRemoveSearchFaculty.searchFaculty(logInController.nowSelectedFaculty);
                if(tempFaculty!=null){
                    int totalSection=0;
                    CourseToLinkedListOthersInfo tempListForCounting=logInController.isUserRequestedList;
                    while(tempListForCounting!=null){
                        totalSection++;
                        tempListForCounting=tempListForCounting.next;
                    }


                    int matchCounter=0;
                    CourseToLinkedListOthersInfo tempListCurrent=tempFaculty.requestedSectionOfFaculty;
                    while(tempListCurrent!=null){
                        CourseToLinkedListOthersInfo tempListPrev=logInController.isUserRequestedList;
                        while(tempListPrev!=null){
                            if(tempListPrev.title.equals(tempListCurrent.title) && tempListPrev.section.equals(tempListCurrent.section)){
                                matchCounter++;
                            }
                            tempListPrev=tempListPrev.next;
                        }
                        tempListCurrent=tempListCurrent.next;
                    }

                    if(totalSection==matchCounter){
                        tempFaculty.isRequested=true;
                    }
                }
            }


            FileInputStream fin=new FileInputStream("Course Information.src");
            ObjectInputStream objectStreamer=new ObjectInputStream(fin);
            CourseToLinkedList temp=(CourseToLinkedList) objectStreamer.readObject();
            AddSearchCourse.courseHeadPointer=temp;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void storePrevData(){
        try {
            FileInputStream fin = new FileInputStream("PrevRoutine.src");
            ObjectInputStream objectStreamer = new ObjectInputStream(fin);
            StoredRoutine temp = (StoredRoutine) objectStreamer.readObject();

            FileOutputStream fout=new FileOutputStream("SecondPrevRoutine.src");
            ObjectOutputStream objectStreamerOut = new ObjectOutputStream(fout);
            objectStreamerOut.writeObject(temp);
            objectStreamerOut.close();
            objectStreamer.close();

        }catch(Exception e){
            e.printStackTrace();

            try {
                StoredRoutine temp=null;

                FileOutputStream fout = new FileOutputStream("SecondPrevRoutine.src");
                ObjectOutputStream objectStreamerOut = new ObjectOutputStream(fout);
                objectStreamerOut.writeObject(temp);
                objectStreamerOut.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }

        }

        try{
            FileOutputStream fout=new FileOutputStream("PrevRoutine.src");
            ObjectOutputStream objectStreamerOut = new ObjectOutputStream(fout);
            makeCurrentFUllRoutine();
            objectStreamerOut.writeObject(fullRoutineObserveController.currentFullRoutine);
            objectStreamerOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void restorePrevData(){
        try{
            FileInputStream fin=new FileInputStream("PrevRoutine.src");
            ObjectInputStream objectStreamer=new ObjectInputStream(fin);
            StoredRoutine temp=(StoredRoutine) objectStreamer.readObject();
            //AddSearchCourse.courseHeadPointer=temp;

            //Clear prev data
            FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
            while(tempFaculty!=null){
                tempFaculty.prevTrimesterDataOfFaculty=null;
                tempFaculty=tempFaculty.next;
            }

            for(CourseToLinkedListOthersInfo tempList:temp.routines){
                tempFaculty=AddRemoveSearchFaculty.searchFaculty(tempList.faculty);
                if(tempFaculty!=null){
                    tempFaculty.addCourseWithListInPrevList(tempList);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        try{
            FileInputStream fin=new FileInputStream("SecondPrevRoutine.src");
            ObjectInputStream objectStreamer=new ObjectInputStream(fin);
            StoredRoutine temp=(StoredRoutine) objectStreamer.readObject();
            //AddSearchCourse.courseHeadPointer=temp;

            //Clear prev data
            FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
            while(tempFaculty!=null){
                tempFaculty.secondPrevTrimesterDataOfFaculty=null;
                tempFaculty=tempFaculty.next;
            }

            for(CourseToLinkedListOthersInfo tempList:temp.routines){
                tempFaculty=AddRemoveSearchFaculty.searchFaculty(tempList.faculty);
                if(tempFaculty!=null){
                    tempFaculty.addCourseWithListInSecondPrevList(tempList);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void storeOnlyPrevRoutine(){
        try{
            FileOutputStream fout=new FileOutputStream("PrevRoutine.src");
            ObjectOutputStream objectStreamerOut = new ObjectOutputStream(fout);
            makeCurrentFUllRoutine();
            objectStreamerOut.writeObject(fullRoutineObserveController.currentFullRoutine);
            objectStreamerOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void makeCurrentFUllRoutine(){
        StoredRoutine currentRoutine=new StoredRoutine();
        FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFaculty!=null){

            CourseToLinkedListOthersInfo tempList=tempFaculty.tempSectionOfFaculty;
            while(tempList!=null){
                currentRoutine.routines.add(tempList);
                tempList=tempList.next;
            }
            tempFaculty=tempFaculty.next;
        }

        fullRoutineObserveController.currentFullRoutine = currentRoutine;
    }

    public static void resetAllFacultyAndCourses() {
        FacultyInfo tempFacu=AddRemoveSearchFaculty.facultyHeadPointer;
        while(tempFacu!=null){

            tempFacu.firstSectionOfFaculty=null;
            tempFacu.tempSectionOfFaculty=null;
            tempFacu.requestedSectionOfFaculty=null;
            tempFacu.chosenCourseOfFaculty=null;
            tempFacu.lab=0;
            tempFacu.tempLab=0;
            tempFacu.theory=0;
            tempFacu.tempTheory=0;

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

    public static void resetCourses(){
        CourseToLinkedList tempListOfCourse=AddSearchCourse.courseHeadPointer;
        while(tempListOfCourse!=null){
            CourseToLinkedListOthersInfo tempSecList=tempListOfCourse.firstSection;
            while(tempSecList!=null){
                if(!tempSecList.faculty.equals("Drop"))
                    tempSecList.faculty="";
                tempSecList=tempSecList.next;
            }
            tempListOfCourse=tempListOfCourse.next;
        }
    }

    public static void resetCoursesWithDropList(){
        CourseToLinkedList tempListOfCourse=AddSearchCourse.courseHeadPointer;
        while(tempListOfCourse!=null){
            CourseToLinkedListOthersInfo tempSecList=tempListOfCourse.firstSection;
            while(tempSecList!=null){
                tempSecList.faculty="";
                tempSecList=tempSecList.next;
            }
            tempListOfCourse=tempListOfCourse.next;
        }
    }

    public static void main(String[] args) {
        //savingFacultyInfo();
        //loadingFacultyInfo();

        //savingCoursesInfo();
        //loadingCoursesInfo();;
        //resetAllFacultyAndCourses();


    }

}
