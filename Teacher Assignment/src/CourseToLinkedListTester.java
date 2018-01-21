/**
 * Created by mimtiaze on 29-Jul-16.
 */
public class CourseToLinkedListTester {
    public static void main(String[] args) {
        new TakeInput();


        CourseToLinkedList tempList=AddSearchCourse.searchCourseWithTitle("Structured Programming Language");
        CourseToLinkedListOthersInfo tempSec=tempList.searchSectionWIthDayAndTimeSlot(1,2);
        System.out.println(tempSec.section);
        String sec=tempSec.section;
        while((tempSec=tempList.searchAnotherSectionWIthDayAndTimeSlot(sec,1,2))!=null){
            sec=tempSec.section;
            System.out.println(sec);
        }
    }
}
