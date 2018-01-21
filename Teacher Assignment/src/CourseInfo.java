import java.util.StringTokenizer;

/**
 * Created by mimtiaze on 10-Jun-16.
 */
public class CourseInfo {
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
    public boolean assigned;
    public int campus;
    public String dept;
    public boolean islabClass;
    public int timeSlot;
    public int labTimeSlot;
    public int day1;
    public int day2;

    public CourseInfo(){
        islabClass=false;
        assigned=false;

        code="";
        title="";
        section="";
        day="";
        time="";
        room=0;
        faculty="";
        credit="";
        campus=0;
        dept="";
        timeSlot=0;
        labTimeSlot=0;
        timeStart="";
        timeEnd="";
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
