import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by mimtiaze on 21-Jun-16.
 */
public class TakeInputForDebug {

    public TakeInputForDebug(){
        System.out.println("Inside TakeInput class..");
        try {
            File f = new File("courses.xls");
            FileInputStream fs = new FileInputStream(f);
            POIFSFileSystem input = new POIFSFileSystem(fs);
            HSSFWorkbook wb = new HSSFWorkbook(input);
            HSSFSheet sheet = wb.getSheetAt(0);

            // Reseting faculty and course head pointer
            AddSearchCourse.courseHeadPointer=null;
            FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
            while(tempFaculty!=null){
                tempFaculty.firstSectionOfFaculty=null;
                tempFaculty=tempFaculty.next;
            }

            int CSECourseCounter = 0;

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                String tempCode = sheet.getRow(i).getCell(0).getStringCellValue();
                StringTokenizer tok = new StringTokenizer(tempCode);

                String codeTok = tok.nextToken();

                if (codeTok.equals("CSE") || codeTok.equals("CSI")) {
                    CSECourseCounter++;
                }

            }

            CourseInfo[] courses = new CourseInfo[CSECourseCounter];
            for (int i = 0; i < CSECourseCounter; i++)
                courses[i] = new CourseInfo();

            System.out.println(sheet.getLastRowNum());


            for (int i = 0, j = 0; i <= sheet.getLastRowNum(); i++) {
                String tempCode = sheet.getRow(i).getCell(0).getStringCellValue();
                StringTokenizer tok = new StringTokenizer(tempCode);

                String codeTok = tok.nextToken();

                if (codeTok.equals("CSE") || codeTok.equals("CSI")) {
                    courses[j].code = sheet.getRow(i).getCell(0).getStringCellValue();
                    courses[j].title = sheet.getRow(i).getCell(1).getStringCellValue();
                    courses[j].section = sheet.getRow(i).getCell(2).getStringCellValue();
                    courses[j].day = sheet.getRow(i).getCell(4).getStringCellValue();
                    courses[j].time = sheet.getRow(i).getCell(5).getStringCellValue();
                    courses[j].faculty = sheet.getRow(i).getCell(7).getStringCellValue();
                    //courses[i].room = sheet.getRow(i).getCell(6).getNumericCellValue();
                    //System.out.println(courses[j].code);
                    j++;
                    //CSECourseCounter++;
                }
            }

            Arrays.sort(courses, new Comparator<CourseInfo>() {
                @Override
                public int compare(CourseInfo o1, CourseInfo o2) {
                    return o1.title.compareTo(o2.title);
                }
            });

            System.out.println("CSE courses = " + CSECourseCounter);

            for (int i = 0; i < CSECourseCounter; i++) {
                courses[i].setCampus();
                courses[i].setLabCLassAndTimeSlot();
                courses[i].setDay();
            }


            //***************************** CourseInfo to a linked list ******************

            for (int i = 0; i < courses.length; i++) {

                CourseToLinkedList temp = AddSearchCourse.searchCourse(courses[i].code);

                if (temp == null) {
                    AddSearchCourse.addCourse(courses[i].title, courses[i].code, courses[i].islabClass);
                    CourseToLinkedList temp1 = AddSearchCourse.searchCourse(courses[i].code);
                    temp1.addSections(courses[i].code, courses[i].title, courses[i].section, courses[i].day, courses[i].time,
                            courses[i].timeStart, courses[i].timeEnd, courses[i].room,
                            courses[i].faculty, courses[i].credit, courses[i].assigned,
                            courses[i].campus, courses[i].dept, courses[i].islabClass,
                            courses[i].timeSlot, courses[i].labTimeSlot, courses[i].day1, courses[i].day2
                    );
                } else {
                    CourseToLinkedList temp1 = AddSearchCourse.searchCourse(courses[i].code);
                    temp1.addSections(courses[i].code, courses[i].title, courses[i].section, courses[i].day, courses[i].time,
                            courses[i].timeStart, courses[i].timeEnd, courses[i].room,
                            courses[i].faculty, courses[i].credit, courses[i].assigned,
                            courses[i].campus, courses[i].dept, courses[i].islabClass,
                            courses[i].timeSlot, courses[i].labTimeSlot, courses[i].day1, courses[i].day2
                    );
                }
            }
            wb.close();
            System.out.println("take complete");

        }catch(Exception e){
            e.printStackTrace();
            try {
                File f = new File("courses.xlsx");
                FileInputStream fs = new FileInputStream(f);
                XSSFWorkbook wb = new XSSFWorkbook(fs);
                XSSFSheet sheet = wb.getSheetAt(0);

                // Reseting faculty and course head pointer
                AddSearchCourse.courseHeadPointer=null;
                FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
                while(tempFaculty!=null){
                    tempFaculty.firstSectionOfFaculty=null;
                    tempFaculty=tempFaculty.next;
                }

                int CSECourseCounter = 0;

                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    String tempCode = sheet.getRow(i).getCell(0).getStringCellValue();
                    StringTokenizer tok = new StringTokenizer(tempCode);

                    String codeTok = tok.nextToken();

                    if (codeTok.equals("CSE") || codeTok.equals("CSI")) {
                        CSECourseCounter++;
                    }

                }

                CourseInfo[] courses = new CourseInfo[CSECourseCounter];
                for (int i = 0; i < CSECourseCounter; i++)
                    courses[i] = new CourseInfo();

                System.out.println(sheet.getLastRowNum());


                for (int i = 0, j = 0; i <= sheet.getLastRowNum(); i++) {
                    String tempCode = sheet.getRow(i).getCell(0).getStringCellValue();
                    StringTokenizer tok = new StringTokenizer(tempCode);

                    String codeTok = tok.nextToken();

                    if (codeTok.equals("CSE") || codeTok.equals("CSI")) {
                        courses[j].code = sheet.getRow(i).getCell(0).getStringCellValue();
                        courses[j].title = sheet.getRow(i).getCell(1).getStringCellValue();
                        courses[j].section = sheet.getRow(i).getCell(2).getStringCellValue();
                        courses[j].day = sheet.getRow(i).getCell(4).getStringCellValue();
                        courses[j].time = sheet.getRow(i).getCell(5).getStringCellValue();
                        courses[j].faculty = sheet.getRow(i).getCell(7).getStringCellValue();
                        //courses[i].room = sheet.getRow(i).getCell(6).getNumericCellValue();
                        //System.out.println(courses[j].code);
                        j++;
                        //CSECourseCounter++;
                    }
                }

                Arrays.sort(courses, new Comparator<CourseInfo>() {
                    @Override
                    public int compare(CourseInfo o1, CourseInfo o2) {
                        return o1.title.compareTo(o2.title);
                    }
                });

                System.out.println("CSE courses = " + CSECourseCounter);

                for (int i = 0; i < CSECourseCounter; i++) {
                    courses[i].setCampus();
                    courses[i].setLabCLassAndTimeSlot();
                    courses[i].setDay();
                }


                //***************************** CourseInfo to a linked list ******************

                for (int i = 0; i < courses.length; i++) {

                    CourseToLinkedList temp = AddSearchCourse.searchCourse(courses[i].code);

                    if (temp == null) {
                        AddSearchCourse.addCourse(courses[i].title, courses[i].code, courses[i].islabClass);
                        CourseToLinkedList temp1 = AddSearchCourse.searchCourse(courses[i].code);
                        temp1.addSections(courses[i].code, courses[i].title, courses[i].section, courses[i].day, courses[i].time,
                                courses[i].timeStart, courses[i].timeEnd, courses[i].room,
                                courses[i].faculty, courses[i].credit, courses[i].assigned,
                                courses[i].campus, courses[i].dept, courses[i].islabClass,
                                courses[i].timeSlot, courses[i].labTimeSlot, courses[i].day1, courses[i].day2
                        );
                    } else {
                        CourseToLinkedList temp1 = AddSearchCourse.searchCourse(courses[i].code);
                        temp1.addSections(courses[i].code, courses[i].title, courses[i].section, courses[i].day, courses[i].time,
                                courses[i].timeStart, courses[i].timeEnd, courses[i].room,
                                courses[i].faculty, courses[i].credit, courses[i].assigned,
                                courses[i].campus, courses[i].dept, courses[i].islabClass,
                                courses[i].timeSlot, courses[i].labTimeSlot, courses[i].day1, courses[i].day2
                        );
                    }
                }
                wb.close();

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        System.out.println("outside try catch..");
    }
}
