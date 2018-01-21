import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * Created by mimtiaze on 04-Jul-16.
 */
public class CourseToLinkedListOthersInfo implements Serializable{
    public String code;
    public String title;
    public String section;
    public String day;
    public String time;
    public String timeStart;
    public String timeEnd;
    public double room;
    public String faculty;
    public String credit;
    public boolean isAssigned;
    public int campus;
    public String dept;
    public boolean islabClass;
    public int timeSlot;
    public int labTimeSlot;
    public int day1;
    public int day2;
    SelectedCourseOfFaculty forFacultyUse;
    CourseToLinkedListOthersInfo next;


    public String getTime() {
        return time;
    }

    public String getDay() {
        return day;
    }

    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCampus() {
        return campus;
    }

    public void setCampus(int campus) {
        this.campus = campus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public int getDay1() {
        return day1;
    }

    public void setDay1(int day1) {
        this.day1 = day1;
    }

    public int getDay2() {
        return day2;
    }

    public void setDay2(int day2) {
        this.day2 = day2;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public SelectedCourseOfFaculty getForFacultyUse() {
        return forFacultyUse;
    }

    public void setForFacultyUse(SelectedCourseOfFaculty forFacultyUse) {
        this.forFacultyUse = forFacultyUse;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public boolean islabClass() {
        return islabClass;
    }

    public void setIslabClass(boolean islabClass) {
        this.islabClass = islabClass;
    }

    public int getLabTimeSlot() {
        return labTimeSlot;
    }

    public void setLabTimeSlot(int labTimeSlot) {
        this.labTimeSlot = labTimeSlot;
    }

    public CourseToLinkedListOthersInfo getNext() {
        return next;
    }

    public void setNext(CourseToLinkedListOthersInfo next) {
        this.next = next;
    }

    public double getRoom() {
        return room;
    }

    public void setRoom(double room) {
        this.room = room;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCampus() {
        if(this.section.length()==1)
            this.campus=1;
        else if(this.section.charAt(0)=='N' || this.section.charAt(0)=='n')
            this.campus=2;
        else if(this.section.charAt(0)=='S' || this.section.charAt(0)=='s')
            this.campus=4;
    }



    public void setLabCLassAndTimeSlot(){

        StringTokenizer tok=new StringTokenizer(time);

        String temp1=tok.nextToken();

        String garbage=tok.nextToken();     // for skipping time format
        garbage=tok.nextToken();            // For skipping '-'

        String temp2=tok.nextToken();

        String timeStart="";
        String timeEnd="";

        if(temp1.charAt(0)=='0'){
            for(int i=1;i<temp1.length();i++){
                timeStart=timeStart+temp1.charAt(i);
            }
        }
        else{
            timeStart=temp1;
        }

        if(temp2.charAt(0)=='0'){
            for(int i=1;i<temp2.length();i++){
                timeEnd=timeEnd+temp2.charAt(i);
            }
        }
        else{
            timeEnd=temp2;
        }

        this.timeStart=timeStart;
        this.timeEnd=timeEnd;

        // Assigning Lab time Slot
        if(timeStart.equals("8:30") && timeEnd.equals("9:50")){
            timeSlot=1;
            labTimeSlot=0;
            islabClass=false;
        }
        if(timeStart.equals("9:55") && timeEnd.equals("11:15")){
            timeSlot=2;
            labTimeSlot=0;
            islabClass=false;
        }
        if(timeStart.equals("11:20") && timeEnd.equals("12:40")){
            timeSlot=3;
            labTimeSlot=0;
            islabClass=false;
        }
        if(timeStart.equals("12:45") && timeEnd.equals("2:05")){
            timeSlot=4;
            labTimeSlot=0;
            islabClass=false;
        }
        if(timeStart.equals("2:10") && timeEnd.equals("3:30")){
            timeSlot=5;
            labTimeSlot=0;
            islabClass=false;
        }
        if(timeStart.equals("3:35") && timeEnd.equals("4:55")){
            timeSlot=6;
            labTimeSlot=0;
            islabClass=false;
        }
        if(timeStart.equals("5:00") && timeEnd.equals("6:20")){
            timeSlot=7;
            labTimeSlot=0;
            islabClass=false;
        }

        // >>>>>>>>>>>>>>>>> For lab class <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        if(timeStart.equals("8:30") && timeEnd.equals("11:10")){
            timeSlot=1;
            labTimeSlot=1;
            islabClass=true;
        }
        if(timeStart.equals("11:20") && timeEnd.equals("2:00")){
            timeSlot=3;
            labTimeSlot=2;
            islabClass=true;
        }
        if(timeStart.equals("2:10") && timeEnd.equals("4:50")){
            timeSlot=5;
            labTimeSlot=3;
            islabClass=true;
        }
        if(timeStart.equals("5:00") && timeEnd.equals("7:40")){
            timeSlot=7;
            labTimeSlot=4;
            islabClass=true;
        }

    }

    public void setDay(){

        if(day.charAt(0)=='S' || day.charAt(0)=='s')
            day1=1;
        else if(day.charAt(0)=='M' || day.charAt(0)=='m')
            day1=2;
        else if(day.charAt(0)=='T' || day.charAt(0)=='t')
            day1=3;
        else if(day.charAt(0)=='W' || day.charAt(0)=='w')
            day1=4;

        try {
            if (day.charAt(2) == 'S' || day.charAt(2) == 's')
                day2 = 1;
        }
        catch(StringIndexOutOfBoundsException e) {
            day2 = 0;
        }

        try {
            if(day.charAt(2)=='M' || day.charAt(2)=='m')
                day2=2;
        }
        catch(StringIndexOutOfBoundsException e) {
            day2 = 0;
        }

        try {
            if(day.charAt(2)=='T' || day.charAt(2)=='t')
                day2=3;
        }
        catch(StringIndexOutOfBoundsException e) {
            day2 = 0;
        }

        try {
            if(day.charAt(2)=='W' || day.charAt(2)=='w')
                day2=4;
        }
        catch(StringIndexOutOfBoundsException e) {
            day2 = 0;
        }
    }

}
