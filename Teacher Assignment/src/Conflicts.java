/**
 * Created by mimtiaze on 01-Jul-16.
 */
public class Conflicts {
    public static boolean labConflicts(CourseToLinkedListOthersInfo sec1,CourseToLinkedListOthersInfo sec2){
        int comp=Math.abs(sec1.labTimeSlot-sec2.labTimeSlot);

        if(sec1.labTimeSlot==0 || sec2.labTimeSlot==0)
            return true;
        if(sec1.day.equals(sec2.day) && comp==0)
            return false;
        else
            return true;
    }

    public static boolean timeConflicts(CourseToLinkedListOthersInfo sec1,CourseToLinkedListOthersInfo sec2){
        if (sec1.timeSlot == sec2.timeSlot) {
            if (sec1.day1 == sec2.day1 || sec1.day2 == sec2.day2)
                return false;
            else
                return true;
        }
        if (sec1.labTimeSlot > 0) {
            if (sec1.timeSlot < sec2.timeSlot && Math.abs(sec1.timeSlot - sec2.timeSlot) == 1) {
                return false;
            }
        } else if (sec2.labTimeSlot > 0) {
            if (sec2.timeSlot < sec1.timeSlot && Math.abs(sec1.timeSlot - sec2.timeSlot) == 1) {
                return false;
            }
        }

    return true;
    }

}
