/**
 * Created by mimtiaze on 06-Jun-16.
 */

public class MainClass {


    public static void main(String[] args) {
        //TakeInput.Take();
        //new GUIForAdmin();
        //new GUIForAdminFX();
        //launch
    }

    public static void receivedCourses(CourseInfo[] courses){
        for(int i=0;i<courses.length;i++){
            //System.out.println(courses[i].code+" "+courses[i].campus+" "+courses[i].time+" "+courses[i].timeSlot+" "+courses[i].labTimeSlot);
            System.out.println(courses[i].day+" "+courses[i].day1+" "+courses[i].day2);
        }
    }


}
