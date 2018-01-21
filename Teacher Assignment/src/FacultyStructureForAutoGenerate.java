/**
 * Created by mimtiaze on 12-Aug-16.
 */
public class FacultyStructureForAutoGenerate {
    public String facultyName;
    public String password;
    public int priority;
    public int lab;
    public int labLimit;
    public int theory;
    public int theoryLimit;
    public int totalCourse;
    public boolean isAdmin;
    public boolean isRequested;
    public CourseToLinkedListOthersInfo firstSectionOfFaculty;
    public CourseToLinkedListOthersInfo tempSectionOfFaculty;
    public CourseToLinkedListOthersInfo prevTrimesterDataOfFaculty;
    public CourseToLinkedListOthersInfo secondPrevTrimesterDataOfFaculty;
    public CourseToLinkedListOthersInfo thirdPrevTrimesterDataOfFaculty;
    public CourseToLinkedListOthersInfo courseListForDebugging;
    public int tempLab;
    public int tempLabLimit;
    public int tempTheory;
    public int tempTheoryLimit;
    public boolean isProcessing;



    public void addCourseWithListAtFirstSectionOfFaculty(CourseToLinkedListOthersInfo list){
        if(list.labTimeSlot>0)
            this.lab++;
        else
            this.theory++;

        totalCourse++;


        if(firstSectionOfFaculty==null){
            firstSectionOfFaculty=new CourseToLinkedListOthersInfo();
            firstSectionOfFaculty.code=list.code;
            firstSectionOfFaculty.title=list.title;
            firstSectionOfFaculty.section=list.section;
            firstSectionOfFaculty.day=list.day;
            firstSectionOfFaculty.time=list.time;
            firstSectionOfFaculty.timeStart=list.timeStart;
            firstSectionOfFaculty.timeEnd=list.timeEnd;
            firstSectionOfFaculty.room=list.room;
            firstSectionOfFaculty.faculty=list.faculty;
            firstSectionOfFaculty.credit=list.credit;
            firstSectionOfFaculty.isAssigned=list.isAssigned;
            firstSectionOfFaculty.campus=list.campus;
            firstSectionOfFaculty.dept=list.dept;
            firstSectionOfFaculty.islabClass=list.islabClass;
            firstSectionOfFaculty.timeSlot=list.timeSlot;
            firstSectionOfFaculty.labTimeSlot=list.labTimeSlot;
            firstSectionOfFaculty.day1=list.day1;
            firstSectionOfFaculty.day2=list.day2;
            firstSectionOfFaculty.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = firstSectionOfFaculty;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.code=list.code;
            newTemp.title=list.title;
            newTemp.section=list.section;
            newTemp.day=list.day;
            newTemp.time=list.time;
            newTemp.timeStart=list.timeStart;
            newTemp.timeEnd=list.timeEnd;
            newTemp.room=list.room;
            newTemp.faculty=list.faculty;
            newTemp.credit=list.credit;
            newTemp.isAssigned=list.isAssigned;
            newTemp.campus=list.campus;
            newTemp.dept=list.dept;
            newTemp.islabClass=list.islabClass;
            newTemp.timeSlot=list.timeSlot;
            newTemp.labTimeSlot=list.labTimeSlot;
            newTemp.day1=list.day1;
            newTemp.day2=list.day2;
            newTemp.next=null;

            temp.next = newTemp;
        }
    }



    public void addCourseWithList(CourseStructureForAutoGenerate list){
        if(list.labTimeSlot>0)
            this.tempLab++;
        else
            this.tempTheory++;


        if(tempSectionOfFaculty==null){
            tempSectionOfFaculty=new CourseToLinkedListOthersInfo();
            tempSectionOfFaculty.code=list.code;
            tempSectionOfFaculty.title=list.title;
            tempSectionOfFaculty.section=list.section;
            tempSectionOfFaculty.day=list.day;
            tempSectionOfFaculty.time=list.time;
            tempSectionOfFaculty.faculty=list.faculty;
            tempSectionOfFaculty.campus=list.campus;
            tempSectionOfFaculty.islabClass=list.islabClass;
            tempSectionOfFaculty.timeSlot=list.timeSlot;
            tempSectionOfFaculty.labTimeSlot=list.labTimeSlot;
            tempSectionOfFaculty.day1=list.day1;
            tempSectionOfFaculty.day2=list.day2;
            tempSectionOfFaculty.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = tempSectionOfFaculty;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.code=list.code;
            newTemp.title=list.title;
            newTemp.section=list.section;
            newTemp.day=list.day;
            newTemp.time=list.time;
            newTemp.faculty=list.faculty;
            newTemp.campus=list.campus;
            newTemp.islabClass=list.islabClass;
            newTemp.timeSlot=list.timeSlot;
            newTemp.labTimeSlot=list.labTimeSlot;
            newTemp.day1=list.day1;
            newTemp.day2=list.day2;
            newTemp.next=null;

            temp.next = newTemp;
        }
    }

    public void addCourseWithListForInitialization(CourseToLinkedListOthersInfo list){
        if(list.labTimeSlot>0)
            this.tempLab++;
        else
            this.tempTheory++;


        if(tempSectionOfFaculty==null){
            tempSectionOfFaculty=new CourseToLinkedListOthersInfo();
            tempSectionOfFaculty.code=list.code;
            tempSectionOfFaculty.title=list.title;
            tempSectionOfFaculty.section=list.section;
            tempSectionOfFaculty.day=list.day;
            tempSectionOfFaculty.time=list.time;
            tempSectionOfFaculty.faculty=list.faculty;
            tempSectionOfFaculty.campus=list.campus;
            tempSectionOfFaculty.islabClass=list.islabClass;
            tempSectionOfFaculty.timeSlot=list.timeSlot;
            tempSectionOfFaculty.labTimeSlot=list.labTimeSlot;
            tempSectionOfFaculty.day1=list.day1;
            tempSectionOfFaculty.day2=list.day2;
            tempSectionOfFaculty.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = tempSectionOfFaculty;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.code=list.code;
            newTemp.title=list.title;
            newTemp.section=list.section;
            newTemp.day=list.day;
            newTemp.time=list.time;
            newTemp.faculty=list.faculty;
            newTemp.campus=list.campus;
            newTemp.islabClass=list.islabClass;
            newTemp.timeSlot=list.timeSlot;
            newTemp.labTimeSlot=list.labTimeSlot;
            newTemp.day1=list.day1;
            newTemp.day2=list.day2;
            newTemp.next=null;

            temp.next = newTemp;
        }
    }

    public void addCourseToDebuggingPointer(CourseStructureForAutoGenerate list){

        if(courseListForDebugging==null){
            courseListForDebugging=new CourseToLinkedListOthersInfo();
            courseListForDebugging.code=list.code;
            courseListForDebugging.title=list.title;
            courseListForDebugging.section=list.section;
            courseListForDebugging.day=list.day;
            courseListForDebugging.time=list.time;
            courseListForDebugging.faculty=list.faculty;
            courseListForDebugging.campus=list.campus;
            courseListForDebugging.islabClass=list.islabClass;
            courseListForDebugging.timeSlot=list.timeSlot;
            courseListForDebugging.labTimeSlot=list.labTimeSlot;
            courseListForDebugging.day1=list.day1;
            courseListForDebugging.day2=list.day2;
            courseListForDebugging.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = courseListForDebugging;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.code=list.code;
            newTemp.title=list.title;
            newTemp.section=list.section;
            newTemp.day=list.day;
            newTemp.time=list.time;
            newTemp.faculty=list.faculty;
            newTemp.campus=list.campus;
            newTemp.islabClass=list.islabClass;
            newTemp.timeSlot=list.timeSlot;
            newTemp.labTimeSlot=list.labTimeSlot;
            newTemp.day1=list.day1;
            newTemp.day2=list.day2;
            newTemp.next=null;

            temp.next = newTemp;
        }
    }

    public void addCourseToDebuggingPointerForInitialization(CourseToLinkedListOthersInfo list){

        if(courseListForDebugging==null){
            courseListForDebugging=new CourseToLinkedListOthersInfo();
            courseListForDebugging.code=list.code;
            courseListForDebugging.title=list.title;
            courseListForDebugging.section=list.section;
            courseListForDebugging.day=list.day;
            courseListForDebugging.time=list.time;
            courseListForDebugging.faculty=list.faculty;
            courseListForDebugging.campus=list.campus;
            courseListForDebugging.islabClass=list.islabClass;
            courseListForDebugging.timeSlot=list.timeSlot;
            courseListForDebugging.labTimeSlot=list.labTimeSlot;
            courseListForDebugging.day1=list.day1;
            courseListForDebugging.day2=list.day2;
            courseListForDebugging.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = courseListForDebugging;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.code=list.code;
            newTemp.title=list.title;
            newTemp.section=list.section;
            newTemp.day=list.day;
            newTemp.time=list.time;
            newTemp.faculty=list.faculty;
            newTemp.campus=list.campus;
            newTemp.islabClass=list.islabClass;
            newTemp.timeSlot=list.timeSlot;
            newTemp.labTimeSlot=list.labTimeSlot;
            newTemp.day1=list.day1;
            newTemp.day2=list.day2;
            newTemp.next=null;

            temp.next = newTemp;
        }
    }

    public void removeCourseWithTitleAndSecion(String title,String sec){

        if(tempSectionOfFaculty!=null && tempSectionOfFaculty.section.equals(sec) && tempSectionOfFaculty.title.equals(title)){
            if(tempSectionOfFaculty.islabClass)
                tempLab--;
            else
                tempTheory--;

            tempSectionOfFaculty=tempSectionOfFaculty.next;
        }
        else{
            CourseToLinkedListOthersInfo prev=tempSectionOfFaculty;
            CourseToLinkedListOthersInfo temp=tempSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.section.equals(sec) && temp.title.equals(title)){
                    if(temp.islabClass)
                        tempLab--;
                    else
                        tempTheory--;

                    prev.next=temp.next;
                }
                prev = prev.next;
                temp = temp.next;
            }
        }
    }


    public CourseToLinkedListOthersInfo getCourseListForDebugging() {
        return courseListForDebugging;
    }

    public void setCourseListForDebugging(CourseToLinkedListOthersInfo courseListForDebugging) {
        this.courseListForDebugging = courseListForDebugging;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public CourseToLinkedListOthersInfo getFirstSectionOfFaculty() {
        return firstSectionOfFaculty;
    }

    public void setFirstSectionOfFaculty(CourseToLinkedListOthersInfo firstSectionOfFaculty) {
        this.firstSectionOfFaculty = firstSectionOfFaculty;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void setProcessing(boolean processing) {
        isProcessing = processing;
    }

    public boolean isRequested() {
        return isRequested;
    }

    public void setRequested(boolean requested) {
        isRequested = requested;
    }

    public int getLab() {
        return lab;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    public int getLabLimit() {
        return labLimit;
    }

    public void setLabLimit(int labLimit) {
        this.labLimit = labLimit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CourseToLinkedListOthersInfo getPrevTrimesterDataOfFaculty() {
        return prevTrimesterDataOfFaculty;
    }

    public void setPrevTrimesterDataOfFaculty(CourseToLinkedListOthersInfo prevTrimesterDataOfFaculty) {
        this.prevTrimesterDataOfFaculty = prevTrimesterDataOfFaculty;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public CourseToLinkedListOthersInfo getSecondPrevTrimesterDataOfFaculty() {
        return secondPrevTrimesterDataOfFaculty;
    }

    public void setSecondPrevTrimesterDataOfFaculty(CourseToLinkedListOthersInfo secondPrevTrimesterDataOfFaculty) {
        this.secondPrevTrimesterDataOfFaculty = secondPrevTrimesterDataOfFaculty;
    }

    public int getTempLab() {
        return tempLab;
    }

    public void setTempLab(int tempLab) {
        this.tempLab = tempLab;
    }

    public CourseToLinkedListOthersInfo getTempSectionOfFaculty() {
        return tempSectionOfFaculty;
    }

    public void setTempSectionOfFaculty(CourseToLinkedListOthersInfo tempSectionOfFaculty) {
        this.tempSectionOfFaculty = tempSectionOfFaculty;
    }

    public int getTempTheory() {
        return tempTheory;
    }

    public void setTempTheory(int tempTheory) {
        this.tempTheory = tempTheory;
    }

    public int getTheory() {
        return theory;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public int getTheoryLimit() {
        return theoryLimit;
    }

    public void setTheoryLimit(int theoryLimit) {
        this.theoryLimit = theoryLimit;
    }

    public CourseToLinkedListOthersInfo getThirdPrevTrimesterDataOfFaculty() {
        return thirdPrevTrimesterDataOfFaculty;
    }

    public void setThirdPrevTrimesterDataOfFaculty(CourseToLinkedListOthersInfo thirdPrevTrimesterDataOfFaculty) {
        this.thirdPrevTrimesterDataOfFaculty = thirdPrevTrimesterDataOfFaculty;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public int getTempTheoryLimit() {
        return tempTheoryLimit;
    }

    public void setTempTheoryLimit(int tempTheoryLimit) {
        this.tempTheoryLimit = tempTheoryLimit;
    }

    public int getTempLabLimit() {
        return tempLabLimit;
    }

    public void setTempLabLimit(int tempLabLimit) {
        this.tempLabLimit = tempLabLimit;
    }
}
