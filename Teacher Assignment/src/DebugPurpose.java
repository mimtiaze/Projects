/**
 * Created by mimtiaze on 17-Sep-16.
 */
public class DebugPurpose {
    public static void main(String[] args) {
        //loadRoutine();
        SavingCoursesAndFacultyInfo.resetAllFacultyAndCourses();
    }

    public static void loadRoutine(){
        //SavingCoursesAndFaculyInfo.loadingCoursesInfo();
        SavingCoursesAndFacultyInfo.loadingFacultyInfo();

        try {
            new TakeInputForDebug();
        }catch(Exception e){

        }
        StoredRoutine newRoutine=new StoredRoutine();
        CourseToLinkedList tempList=AddSearchCourse.courseHeadPointer;
        while(tempList!=null){
            CourseToLinkedListOthersInfo tempSecList=tempList.firstSection;
            while(tempSecList!=null){

                if(tempSecList.faculty.equals("") || tempSecList.faculty==null){
                    tempSecList.faculty="Drop";
                }
                newRoutine.routines.add(tempSecList);
                tempSecList=tempSecList.next;
            }
            tempList=tempList.next;
        }

        fullRoutineObserveController.currentFullRoutine=newRoutine;

        SavingCoursesAndFacultyInfo.storePrevData();
    }
}
