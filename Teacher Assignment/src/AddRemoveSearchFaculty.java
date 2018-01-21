import java.io.Serializable;

/**
 * Created by mimtiaze on 01-Jul-16.
 */
public class AddRemoveSearchFaculty implements Serializable{

    public static FacultyInfo facultyHeadPointer;

    public static final int priorityLimit=5;

    public static void addFaculty(String fullName,String shortName,String password,
                                  boolean isAdmin,int priority,int maxClassBreak,int takenClassInThisDays){

        /*if(facultyHeadPointer==null){
            facultyHeadPointer=new FacultyInfo();
            facultyHeadPointer.facultyName=shortName;
            facultyHeadPointer.facultyFullName=fullName;
            facultyHeadPointer.isAdmin=isAdmin;
            facultyHeadPointer.password=password;
            facultyHeadPointer.priority=priority;
            facultyHeadPointer.next=null;

        }
        else {
            FacultyInfo temp;
            temp = facultyHeadPointer;
            while (temp.next != null)
                temp = temp.next;

            FacultyInfo newTemp=new FacultyInfo();
            newTemp.facultyName=shortName;
            newTemp.facultyFullName=fullName;
            newTemp.isAdmin=isAdmin;
            newTemp.password=password;
            newTemp.priority=priority;
            newTemp.next=null;

            temp.next = newTemp;
        }*/

        if(priority>AddRemoveSearchFaculty.priorityLimit)
            priority=AddRemoveSearchFaculty.priorityLimit;

        if(facultyHeadPointer==null){
            facultyHeadPointer=new FacultyInfo();
            facultyHeadPointer.facultyName=shortName;
            facultyHeadPointer.facultyFullName=fullName;
            facultyHeadPointer.isAdmin=isAdmin;
            facultyHeadPointer.password=password;
            facultyHeadPointer.priority=priority;
            facultyHeadPointer.maxClassBreak=maxClassBreak;
            facultyHeadPointer.classTakenInThisNumberOfDays=takenClassInThisDays;
            facultyHeadPointer.next=null;

        }
        else {
            if(priority==AddRemoveSearchFaculty.priorityLimit) {
                FacultyInfo temp;
                temp = facultyHeadPointer;
                while (temp.next != null)
                    temp = temp.next;

                FacultyInfo newTemp = new FacultyInfo();
                newTemp.facultyName = shortName;
                newTemp.facultyFullName = fullName;
                newTemp.isAdmin = isAdmin;
                newTemp.password = password;
                newTemp.priority = priority;
                newTemp.maxClassBreak=maxClassBreak;
                newTemp.classTakenInThisNumberOfDays=takenClassInThisDays;

                newTemp.next = null;
                temp.next = newTemp;
            }
            else{
                FacultyInfo temp,prev;
                prev=facultyHeadPointer;
                temp = facultyHeadPointer.next;
                while (temp!= null) {
                    if(temp.priority>priority)
                        break;

                    temp = temp.next;
                    prev=prev.next;
                }

                FacultyInfo newTemp = new FacultyInfo();
                newTemp.facultyName = shortName;
                newTemp.facultyFullName = fullName;
                newTemp.isAdmin = isAdmin;
                newTemp.password = password;
                newTemp.priority = priority;
                newTemp.maxClassBreak=maxClassBreak;
                newTemp.classTakenInThisNumberOfDays=takenClassInThisDays;

                newTemp.next = temp;
                prev.next = newTemp;

            }
        }
    }

    public static void modifyFacultyPriority(String name,int priority){

        FacultyInfo temp=searchFaculty(name);
        if(temp!=null){
            temp.priority=priority;
        }

        if(name.equals(facultyHeadPointer.facultyName))
            return;

        // Update Faculty
        if(temp!=null) {
            if (temp != facultyHeadPointer || temp != facultyHeadPointer.next) { //if there are only one or two faculty, we do not need to change their position
                // Removing temp from previous position
                FacultyInfo prev;
                prev=facultyHeadPointer;
                while (prev.next != null) {
                    if(prev.next==temp)
                        break;
                    prev=prev.next;
                }

                prev.next = temp.next;

                // Assign to new position
                prev=facultyHeadPointer;
                FacultyInfo current=facultyHeadPointer.next;

                while(current!=null){

                    if(current.priority>temp.priority)
                        break;

                    current=current.next;
                    prev=prev.next;
                }

                prev.next=temp;
                temp.next=current;

            }
        }
    }

    public static void removeFaculty(String name){
        if(facultyHeadPointer.facultyName.equals(name)){
            facultyHeadPointer=facultyHeadPointer.next;
        }
        else{
            FacultyInfo prev=facultyHeadPointer;
            FacultyInfo temp=facultyHeadPointer.next;

            while (temp!= null) {
                if(temp.facultyName.equals(name)){
                    prev.next=temp.next;
                    break;
                }
                temp = temp.next;
                prev=prev.next;
            }
        }
    }

    public static FacultyInfo searchFaculty(String name){
        if(facultyHeadPointer==null)
            return null;
        if(facultyHeadPointer.facultyName.equals(name)){
            return facultyHeadPointer;
        }
        else{
            FacultyInfo temp=facultyHeadPointer.next;

            while (temp!= null) {
                if(temp.facultyName.equals(name)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public static FacultyInfo searchForLogInFaculty(String name,String password){
        if(facultyHeadPointer==null)
            return null;
        if(facultyHeadPointer.facultyName.equals(name) && facultyHeadPointer.password.equals(password)){
            return facultyHeadPointer;
        }
        else{
            FacultyInfo temp=facultyHeadPointer.next;

            while (temp!= null) {
                if(temp.facultyName.equals(name) && temp.password.equals(password)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public static boolean searchForWrongPasswordFaculty(String name,String password){
        if(facultyHeadPointer==null)
            return false;
        if(facultyHeadPointer.facultyName.equals(name) && !facultyHeadPointer.password.equals(password)){
            return true;
        }
        else{
            FacultyInfo temp=facultyHeadPointer.next;

            while (temp!= null) {
                if(temp.facultyName.equals(name) && !temp.password.equals(password)){
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
}
