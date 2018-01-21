import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mimtiaze on 27-Jun-16.
 */
public class FacultyInfo implements Serializable{

    public String facultyName;
    public String facultyFullName;
    public String password;
    public String msg;
    public String mail;
    public int priority;
    public int maxClassBreak;
    public int classTakenInThisNumberOfDays;
    public int lab;
    public int tempLab;
    public int labLimit;
    public int theory;
    public int tempTheory;
    public int theoryLimit;
    public int totalCourse;
    public boolean isAdmin;
    public boolean isRequested;
    public CourseToLinkedListOthersInfo firstSectionOfFaculty;
    public CourseToLinkedListOthersInfo tempSectionOfFaculty;
    public CourseToLinkedListOthersInfo prevTrimesterDataOfFaculty;
    public CourseToLinkedListOthersInfo secondPrevTrimesterDataOfFaculty;
    public CourseToLinkedListOthersInfo requestedSectionOfFaculty;
    public CourseToLinkedList chosenCourseOfFaculty;
    public FacultyInfo next;


    public String getFacultyName(){
        return facultyName;
    }

    public int getLabLimit() {
        return labLimit;
    }

    public int getTheoryLimit() {
        return theoryLimit;
    }

    public int getLab() {
        return lab;
    }

    public int getTheory() {
        return theory;
    }

    public String getFacultyFullName() {
        return facultyFullName;
    }

    public void setFacultyFullName(String facultyFullName) {
        this.facultyFullName = facultyFullName;
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

    public CourseToLinkedListOthersInfo getTempSectionOfFaculty() {
        return tempSectionOfFaculty;
    }

    public void setTempSectionOfFaculty(CourseToLinkedListOthersInfo tempSectionOfFaculty) {
        this.tempSectionOfFaculty = tempSectionOfFaculty;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isRequested() {
        return isRequested;
    }

    public void setRequested(boolean requested) {
        isRequested = requested;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    public void setLabLimit(int labLimit) {
        this.labLimit = labLimit;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FacultyInfo getNext() {
        return next;
    }

    public void setNext(FacultyInfo next) {
        this.next = next;
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

    public CourseToLinkedListOthersInfo getSecondPrevTrimesterDataOfFaculty() {
        return secondPrevTrimesterDataOfFaculty;
    }

    public void setSecondPrevTrimesterDataOfFaculty(CourseToLinkedListOthersInfo secondPrevTrimesterDataOfFaculty) {
        this.secondPrevTrimesterDataOfFaculty = secondPrevTrimesterDataOfFaculty;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public void setTheoryLimit(int theoryLimit) {
        this.theoryLimit = theoryLimit;
    }

    public CourseToLinkedListOthersInfo getRequestedSectionOfFaculty() {
        return requestedSectionOfFaculty;
    }

    public void setRequestedSectionOfFaculty(CourseToLinkedListOthersInfo requestedSectionOfFaculty) {
        this.requestedSectionOfFaculty = requestedSectionOfFaculty;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public void addCourseWithAllPeremeter(String code,
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
        if(islabClass)
            this.lab++;
        else
            this.theory++;

        totalCourse++;


        if(firstSectionOfFaculty==null){
            firstSectionOfFaculty=new CourseToLinkedListOthersInfo();
            firstSectionOfFaculty.code=code;
            firstSectionOfFaculty.title=title;
            firstSectionOfFaculty.section=sec;
            firstSectionOfFaculty.day=day;
            firstSectionOfFaculty.time=time;
            firstSectionOfFaculty.timeStart=timeStart;
            firstSectionOfFaculty.timeEnd=timeEnd;
            firstSectionOfFaculty.room=room;
            firstSectionOfFaculty.faculty=faculty;
            firstSectionOfFaculty.credit=credit;
            firstSectionOfFaculty.isAssigned=isAssigned;
            firstSectionOfFaculty.campus=campus;
            firstSectionOfFaculty.dept=dept;
            firstSectionOfFaculty.islabClass=islabClass;
            firstSectionOfFaculty.timeSlot=timeSlot;
            firstSectionOfFaculty.labTimeSlot=labTimeSlot;
            firstSectionOfFaculty.day1=day1;
            firstSectionOfFaculty.day2=day2;
            firstSectionOfFaculty.forFacultyUse.approved=false;
            firstSectionOfFaculty.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = firstSectionOfFaculty;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedListOthersInfo newTemp=new CourseToLinkedListOthersInfo();
            newTemp.code=code;
            newTemp.title=title;
            newTemp.section=sec;
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
            newTemp.forFacultyUse.approved=false;
            newTemp.next=null;

            temp.next = newTemp;
        }
    }


    public void addCourseWithList(CourseToLinkedListOthersInfo list){
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

        addCourseWithListInTempList(list);
    }

    public void removeCourseWithTitleAndSecion(String title,String sec){

        if(firstSectionOfFaculty!=null && firstSectionOfFaculty.section.equals(sec) && firstSectionOfFaculty.title.equals(title)){
            if(firstSectionOfFaculty.islabClass)
                lab--;
            else
                theory--;
            totalCourse--;

            firstSectionOfFaculty=firstSectionOfFaculty.next;
        }
        else{
            CourseToLinkedListOthersInfo prev=firstSectionOfFaculty;
            CourseToLinkedListOthersInfo temp=firstSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.section.equals(sec) && temp.title.equals(title)){
                    if(temp.islabClass)
                        lab--;
                    else
                        theory--;
                    totalCourse--;

                    prev.next=temp.next;
                }
                prev = prev.next;
                temp = temp.next;
            }
        }

        removeCourseFromTempList(title, sec);
    }


    public void removeCourseWithDayAndTime(int day,int timeSlot,boolean isLab){
        if(isLab)
            this.lab--;
        else
            this.theory--;

        totalCourse--;

        if(firstSectionOfFaculty!=null && firstSectionOfFaculty.timeSlot==timeSlot && (firstSectionOfFaculty.day1==day || firstSectionOfFaculty.day2==day)){
            firstSectionOfFaculty=firstSectionOfFaculty.next;
        }
        else{
            CourseToLinkedListOthersInfo prev=firstSectionOfFaculty;
            CourseToLinkedListOthersInfo temp=firstSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.timeSlot==timeSlot && (temp.day1==day || temp.day2==day)){
                    prev.next=temp.next;
                }
                prev = prev.next;
                temp = temp.next;
            }
        }
    }


    public CourseToLinkedListOthersInfo searchCourseAndSection(String title,String sec){
        if(firstSectionOfFaculty==null)
            return null;
        if(firstSectionOfFaculty.section.equals(sec) && firstSectionOfFaculty.title.equals(title)){
            return firstSectionOfFaculty;
        }
        else{
            CourseToLinkedListOthersInfo temp=firstSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.section.equals(sec) && temp.title.equals(title)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    /*public CourseToLinkedListOthersInfo searchSectionWIthDayAndTimeSlot(int day,int timeSlot){
        if(firstSectionOfFaculty==null)
            return null;
        if(firstSectionOfFaculty.timeSlot==timeSlot && (firstSectionOfFaculty.day1==day || firstSectionOfFaculty.day2==day)){
            return firstSectionOfFaculty;
        }
        else{
            CourseToLinkedListOthersInfo temp=firstSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.timeSlot==timeSlot && (temp.day1==day || temp.day2==day)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }*/


    public CourseToLinkedListOthersInfo searchSectionWIthDayAndTimeSlot(int day,int timeSlot){
        if(tempSectionOfFaculty==null)
            return null;
        if(tempSectionOfFaculty.timeSlot==timeSlot && (tempSectionOfFaculty.day1==day || tempSectionOfFaculty.day2==day)){
            return tempSectionOfFaculty;
        }
        else{
            CourseToLinkedListOthersInfo temp=tempSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.timeSlot==timeSlot && (temp.day1==day || temp.day2==day)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }




    // Temp List property

    public void addCourseWithListInTempList(CourseToLinkedListOthersInfo list){
        if(list.labTimeSlot>0)
            this.tempLab++;
        else
            this.tempTheory++;

        //totalCourse++;


        if(tempSectionOfFaculty==null){
            tempSectionOfFaculty=new CourseToLinkedListOthersInfo();
            tempSectionOfFaculty.code=list.code;
            tempSectionOfFaculty.title=list.title;
            tempSectionOfFaculty.section=list.section;
            tempSectionOfFaculty.day=list.day;
            tempSectionOfFaculty.time=list.time;
            tempSectionOfFaculty.timeStart=list.timeStart;
            tempSectionOfFaculty.timeEnd=list.timeEnd;
            tempSectionOfFaculty.room=list.room;
            tempSectionOfFaculty.faculty=list.faculty;
            tempSectionOfFaculty.credit=list.credit;
            tempSectionOfFaculty.isAssigned=list.isAssigned;
            tempSectionOfFaculty.campus=list.campus;
            tempSectionOfFaculty.dept=list.dept;
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

    public void removeCourseFromTempList(String title,String sec){

        if(tempSectionOfFaculty==null)
            return;

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

    public CourseToLinkedListOthersInfo searchCourseAndSectionInTempList(String title,String sec){
        if(tempSectionOfFaculty==null)
            return null;
        if(tempSectionOfFaculty.section.equals(sec) && tempSectionOfFaculty.title.equals(title)){
            return tempSectionOfFaculty;
        }
        else{
            CourseToLinkedListOthersInfo temp=tempSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.section.equals(sec) && temp.title.equals(title)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }


    // First Prev List Property


    public void addCourseWithListInPrevList(CourseToLinkedListOthersInfo list){


        if(prevTrimesterDataOfFaculty==null){
            prevTrimesterDataOfFaculty=new CourseToLinkedListOthersInfo();
            prevTrimesterDataOfFaculty.code=list.code;
            prevTrimesterDataOfFaculty.title=list.title;
            prevTrimesterDataOfFaculty.section=list.section;
            prevTrimesterDataOfFaculty.day=list.day;
            prevTrimesterDataOfFaculty.time=list.time;
            prevTrimesterDataOfFaculty.timeStart=list.timeStart;
            prevTrimesterDataOfFaculty.timeEnd=list.timeEnd;
            prevTrimesterDataOfFaculty.room=list.room;
            prevTrimesterDataOfFaculty.faculty=list.faculty;
            prevTrimesterDataOfFaculty.credit=list.credit;
            prevTrimesterDataOfFaculty.isAssigned=list.isAssigned;
            prevTrimesterDataOfFaculty.campus=list.campus;
            prevTrimesterDataOfFaculty.dept=list.dept;
            prevTrimesterDataOfFaculty.islabClass=list.islabClass;
            prevTrimesterDataOfFaculty.timeSlot=list.timeSlot;
            prevTrimesterDataOfFaculty.labTimeSlot=list.labTimeSlot;
            prevTrimesterDataOfFaculty.day1=list.day1;
            prevTrimesterDataOfFaculty.day2=list.day2;
            prevTrimesterDataOfFaculty.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = prevTrimesterDataOfFaculty;
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


    public CourseToLinkedListOthersInfo searchCourseAndSectionInPrevList(String title,String sec){
        if(prevTrimesterDataOfFaculty==null)
            return null;
        if(prevTrimesterDataOfFaculty.section.equals(sec) && prevTrimesterDataOfFaculty.title.equals(title)){
            return prevTrimesterDataOfFaculty;
        }
        else{
            CourseToLinkedListOthersInfo temp=prevTrimesterDataOfFaculty.next;

            while (temp!= null) {
                if(temp.section.equals(sec) && temp.title.equals(title)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    // Second Prev Property


    public void addCourseWithListInSecondPrevList(CourseToLinkedListOthersInfo list){


        if(secondPrevTrimesterDataOfFaculty==null){
            secondPrevTrimesterDataOfFaculty=new CourseToLinkedListOthersInfo();
            secondPrevTrimesterDataOfFaculty.code=list.code;
            secondPrevTrimesterDataOfFaculty.title=list.title;
            secondPrevTrimesterDataOfFaculty.section=list.section;
            secondPrevTrimesterDataOfFaculty.day=list.day;
            secondPrevTrimesterDataOfFaculty.time=list.time;
            secondPrevTrimesterDataOfFaculty.timeStart=list.timeStart;
            secondPrevTrimesterDataOfFaculty.timeEnd=list.timeEnd;
            secondPrevTrimesterDataOfFaculty.room=list.room;
            secondPrevTrimesterDataOfFaculty.faculty=list.faculty;
            secondPrevTrimesterDataOfFaculty.credit=list.credit;
            secondPrevTrimesterDataOfFaculty.isAssigned=list.isAssigned;
            secondPrevTrimesterDataOfFaculty.campus=list.campus;
            secondPrevTrimesterDataOfFaculty.dept=list.dept;
            secondPrevTrimesterDataOfFaculty.islabClass=list.islabClass;
            secondPrevTrimesterDataOfFaculty.timeSlot=list.timeSlot;
            secondPrevTrimesterDataOfFaculty.labTimeSlot=list.labTimeSlot;
            secondPrevTrimesterDataOfFaculty.day1=list.day1;
            secondPrevTrimesterDataOfFaculty.day2=list.day2;
            secondPrevTrimesterDataOfFaculty.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = secondPrevTrimesterDataOfFaculty;
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


    public CourseToLinkedListOthersInfo searchCourseAndSectionInSecondPrevList(String title,String sec){
        if(secondPrevTrimesterDataOfFaculty==null)
            return null;
        if(secondPrevTrimesterDataOfFaculty.section.equals(sec) && secondPrevTrimesterDataOfFaculty.title.equals(title)){
            return secondPrevTrimesterDataOfFaculty;
        }
        else{
            CourseToLinkedListOthersInfo temp=secondPrevTrimesterDataOfFaculty.next;

            while (temp!= null) {
                if(temp.section.equals(sec) && temp.title.equals(title)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    // Third Prev Property

    public void addCourseWithListInRequestedList(CourseToLinkedListOthersInfo list){


        if(requestedSectionOfFaculty==null){
            requestedSectionOfFaculty=new CourseToLinkedListOthersInfo();
            requestedSectionOfFaculty.code=list.code;
            requestedSectionOfFaculty.title=list.title;
            requestedSectionOfFaculty.section=list.section;
            requestedSectionOfFaculty.day=list.day;
            requestedSectionOfFaculty.time=list.time;
            requestedSectionOfFaculty.timeStart=list.timeStart;
            requestedSectionOfFaculty.timeEnd=list.timeEnd;
            requestedSectionOfFaculty.room=list.room;
            requestedSectionOfFaculty.faculty=list.faculty;
            requestedSectionOfFaculty.credit=list.credit;
            requestedSectionOfFaculty.isAssigned=list.isAssigned;
            requestedSectionOfFaculty.campus=list.campus;
            requestedSectionOfFaculty.dept=list.dept;
            requestedSectionOfFaculty.islabClass=list.islabClass;
            requestedSectionOfFaculty.timeSlot=list.timeSlot;
            requestedSectionOfFaculty.labTimeSlot=list.labTimeSlot;
            requestedSectionOfFaculty.day1=list.day1;
            requestedSectionOfFaculty.day2=list.day2;
            requestedSectionOfFaculty.next=null;

        }
        else {
            CourseToLinkedListOthersInfo temp;
            temp = requestedSectionOfFaculty;
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


    public CourseToLinkedListOthersInfo searchCourseAndSectionInRequestedList(String title,String sec){
        if(requestedSectionOfFaculty==null)
            return null;
        if(requestedSectionOfFaculty.section.equals(sec) && requestedSectionOfFaculty.title.equals(title)){
            return requestedSectionOfFaculty;
        }
        else{
            CourseToLinkedListOthersInfo temp=requestedSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.section.equals(sec) && temp.title.equals(title)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public void removeCourseWithTitleAndSectionInRequestedList(String title,String sec){

        if(requestedSectionOfFaculty==null)
            return;

        if(requestedSectionOfFaculty!=null && requestedSectionOfFaculty.section.equals(sec) && requestedSectionOfFaculty.title.equals(title)){

            requestedSectionOfFaculty=requestedSectionOfFaculty.next;
        }
        else{
            CourseToLinkedListOthersInfo prev=requestedSectionOfFaculty;
            CourseToLinkedListOthersInfo temp=requestedSectionOfFaculty.next;

            while (temp!= null) {
                if(temp.section.equals(sec) && temp.title.equals(title)){
                    prev.next=temp.next;
                }
                prev = prev.next;
                temp = temp.next;
            }
        }
    }




    // ChosenCourse List property

    public void addCourseWithListInChosenCourseList(CourseToLinkedList list){

        if(chosenCourseOfFaculty==null){
            chosenCourseOfFaculty=new CourseToLinkedList();
            chosenCourseOfFaculty.code=list.code;
            chosenCourseOfFaculty.title=list.title;

            chosenCourseOfFaculty.next=null;

        }
        else {
            CourseToLinkedList temp;
            temp = chosenCourseOfFaculty;
            while (temp.next != null)
                temp = temp.next;

            CourseToLinkedList newTemp=new CourseToLinkedList();
            newTemp.code=list.code;
            newTemp.title=list.title;

            newTemp.next=null;
            temp.next = newTemp;
        }
    }

    public void removeCourseFromChosenCourseList(String title){

        if(chosenCourseOfFaculty==null)
            return;

        if(chosenCourseOfFaculty!=null && chosenCourseOfFaculty.title.equals(title)){
            chosenCourseOfFaculty=chosenCourseOfFaculty.next;
        }
        else{
            CourseToLinkedList prev=chosenCourseOfFaculty;
            CourseToLinkedList temp=chosenCourseOfFaculty.next;

            while (temp!= null) {
                if(temp.title.equals(title)){
                    prev.next=temp.next;
                }
                prev = prev.next;
                temp = temp.next;
            }
        }
    }

    public CourseToLinkedList searchCourseAndSectionInChosenCourseList(String title){
        if(chosenCourseOfFaculty==null)
            return null;
        if(chosenCourseOfFaculty.title.equals(title)){
            return chosenCourseOfFaculty;
        }
        else{
            CourseToLinkedList temp=chosenCourseOfFaculty.next;

            while (temp!= null) {
                if(temp.title.equals(title)){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }








    public int getTempTheory() {
        return tempTheory;
    }

    public void setTempTheory(int tempTheory) {
        this.tempTheory = tempTheory;
    }

    public int getClassTakenInThisNumberOfDays() {
        return classTakenInThisNumberOfDays;
    }

    public void setClassTakenInThisNumberOfDays(int classTakenInThisNumberOfDays) {
        this.classTakenInThisNumberOfDays = classTakenInThisNumberOfDays;
    }

    public int getMaxClassBreak() {
        return maxClassBreak;
    }

    public void setMaxClassBreak(int maxClassBreak) {
        this.maxClassBreak = maxClassBreak;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTempLab() {
        return tempLab;
    }

    public void setTempLab(int tempLab) {
        this.tempLab = tempLab;
    }
}