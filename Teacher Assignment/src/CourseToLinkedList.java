import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * Created by mimtiaze on 04-Jul-16.
 */
public class CourseToLinkedList implements Serializable{
    public String code;
    public String title;
    public int availableSections;
    public boolean isLab;
    CourseToLinkedListOthersInfo firstSection;
    CourseToLinkedList next;


    public void addSections(String code,
                            String title,
                            String sec,
                                   String day,
                                   String time,
                                   String timeStart,
                                   String timeEnd,
                                   double room,
                                   String faculty,
                                   String credit,
                                   boolean isAssigned,
                                   int campus,
                                   String dept,
                                   boolean islabClass,
                                   int timeSlot,
                                   int labTimeSlot,
                                   int day1,
                                   int day2
                                   ){

        StringTokenizer tok=new StringTokenizer(sec);
        String tempSec="";
        while(tok.hasMoreTokens()){
            tempSec+=tok.nextToken();
        }

        tok=new StringTokenizer(title);
        String tempTitle="";
        while(tok.hasMoreTokens()){
            tempTitle+=tok.nextToken();
            if(tok.hasMoreTokens())
                tempTitle+=" ";
        }

        if(firstSection==null){
            firstSection=new CourseToLinkedListOthersInfo();
            firstSection.code=code;
            firstSection.title=tempTitle;
            firstSection.section=tempSec;
            firstSection.day=day;
            firstSection.time=time;
            firstSection.timeStart=timeStart;
            firstSection.timeEnd=timeEnd;
            firstSection.room=room;
            firstSection.faculty=faculty;
            firstSection.credit=credit;
            firstSection.isAssigned=isAssigned;
            firstSection.campus=campus;
            firstSection.dept=dept;
            firstSection.islabClass=islabClass;
            firstSection.timeSlot=timeSlot;
            firstSection.labTimeSlot=labTimeSlot;
            firstSection.day1=day1;
            firstSection.day2=day2;
            firstSection.next=null;

            // assign to name to its faculty list
            FacultyInfo tempFaculty=AddRemoveSearchFaculty.searchFaculty(faculty);
            if(tempFaculty!=null){
                tempFaculty.addCourseWithList(firstSection);
            }


        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = firstSection;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.code=code;
            newTemp.title=tempTitle;
            newTemp.section=tempSec;
            newTemp.day=day;
            newTemp.time=time;
            newTemp.timeStart=timeStart;
            newTemp.timeEnd=timeEnd;
            newTemp.room=room;
            newTemp.faculty=faculty;
            newTemp.credit=credit;
            newTemp.isAssigned=isAssigned;
            newTemp.campus=campus;
            newTemp.dept=dept;
            newTemp.islabClass=islabClass;
            newTemp.timeSlot=timeSlot;
            newTemp.labTimeSlot=labTimeSlot;
            newTemp.day1=day1;
            newTemp.day2=day2;
            newTemp.next=null;

            temp.next = newTemp;

            // assign to name to its faculty list
            FacultyInfo tempFaculty=AddRemoveSearchFaculty.searchFaculty(faculty);
            if(tempFaculty!=null){
                tempFaculty.addCourseWithList(newTemp);
            }
        }
        availableSections++;


    }


    public CourseToLinkedListOthersInfo searchSection(String sec){
        if(firstSection==null)
            return null;
        if(firstSection.section.equals(sec)){
            return firstSection;
        }
        else{
            CourseToLinkedListOthersInfo temp=firstSection.next;

            while (temp!= null) {
                if(temp.section.equals(sec)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public CourseToLinkedListOthersInfo searchSectionWIthDayAndTimeSlot(int day,int timeSlot){
        if(firstSection==null)
            return null;
        if(firstSection.timeSlot==timeSlot && (firstSection.day1==day || firstSection.day2==day)){
            return firstSection;
        }
        else{
            CourseToLinkedListOthersInfo temp=firstSection.next;

            while (temp!= null) {
                if(temp.timeSlot==timeSlot && (temp.day1==day || temp.day2==day)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public CourseToLinkedListOthersInfo searchAnotherSectionWIthDayAndTimeSlot(String prevSec,int day,int timeSlot){
        if(firstSection==null)
            return null;
        if(firstSection.section.equals(prevSec)){
            return searchAnotherSectionHelper(firstSection.next,day,timeSlot);
        }
        else{
            CourseToLinkedListOthersInfo temp=firstSection.next;

            while (temp!= null) {
                if(temp.section.equals(prevSec)){
                    return searchAnotherSectionHelper(temp.next,day,timeSlot);
                }
                temp = temp.next;
            }
        }
        return null;
    }


    public CourseToLinkedListOthersInfo searchAnotherSectionHelper(CourseToLinkedListOthersInfo searchFromThisNode,int day,int timeSlot){
        if(searchFromThisNode==null)
            return null;
        if(searchFromThisNode.timeSlot==timeSlot && (searchFromThisNode.day1==day || searchFromThisNode.day2==day)){
            return searchFromThisNode;
        }
        else{
            CourseToLinkedListOthersInfo temp=searchFromThisNode.next;

            while (temp!= null) {
                if(temp.timeSlot==timeSlot && (temp.day1==day || temp.day2==day)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }


    public CourseToLinkedListOthersInfo searchSectionWithList(CourseToLinkedListOthersInfo searchedSec){
        if(firstSection==null)
            return null;
        if(firstSection.title.equals(searchedSec.title) && firstSection.section.equals(searchedSec.section)){
            return firstSection;
        }
        else{
            CourseToLinkedListOthersInfo temp=firstSection.next;

            while (temp!= null) {
                if(temp.title.equals(searchedSec.title) && temp.section.equals(searchedSec.section)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public int getAvailableSections() {
        return availableSections;
    }

    public String getTitle() {
        return title;
    }
}
