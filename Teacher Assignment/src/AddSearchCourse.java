import java.util.StringTokenizer;

/**
 * Created by mimtiaze on 04-Jul-16.
 */
public class AddSearchCourse{
    public static CourseToLinkedList courseHeadPointer;

    public static void addCourse(String title,String code,boolean isLab){

        StringTokenizer tok=new StringTokenizer(title);
        String tempTitle="";
        while(tok.hasMoreTokens()){
            tempTitle+=tok.nextToken();
            if(tok.hasMoreTokens())
                tempTitle+=" ";
        }


        if(courseHeadPointer==null){
            courseHeadPointer=new CourseToLinkedList();
            courseHeadPointer.title=tempTitle;
            courseHeadPointer.code=code;
            courseHeadPointer.isLab=isLab;
            courseHeadPointer.next=null;

        }
        else {
            CourseToLinkedList temp;
            temp = courseHeadPointer;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedList newTemp=new CourseToLinkedList();
            newTemp.title=tempTitle;
            newTemp.code=code;
            newTemp.isLab=isLab;
            newTemp.next=null;

            temp.next = newTemp;
        }
    }


    public static CourseToLinkedList searchCourse(String code){
        if(courseHeadPointer==null)
            return null;
        if(courseHeadPointer.code.equals(code)){
            return courseHeadPointer;
        }
        else{
            CourseToLinkedList temp=courseHeadPointer.next;

            while (temp!= null) {
                if(temp.code.equals(code)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public static CourseToLinkedList searchCourseWithTitle(String title){
        if(courseHeadPointer==null)
            return null;
        if(courseHeadPointer.title.equals(title)){
            return courseHeadPointer;
        }
        else{
            CourseToLinkedList temp=courseHeadPointer.next;

            while (temp!= null) {
                if(temp.title.equals(title)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

}
