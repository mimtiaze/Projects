/**
 * Created by mimtiaze on 20-Aug-16.
 */
public class Temp {
    public static void main(String[] args) {
        SavingCoursesAndFacultyInfo.loadingFacultyInfo();
        FacultyInfo temp=AddRemoveSearchFaculty.facultyHeadPointer;
        while(temp!=null){

            temp.maxClassBreak=5;
            temp.classTakenInThisNumberOfDays=4;

            System.out.println("Done");
            temp=temp.next;
        }
        SavingCoursesAndFacultyInfo.savingFacultyInfo();
    }
}
