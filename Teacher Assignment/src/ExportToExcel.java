import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by mimtiaze on 05-Aug-16.
 */
public class ExportToExcel {
    public ExportToExcel(){
        try{
            File f = new File("courses.xls");
            FileInputStream fs = new FileInputStream(f);
            //POIFSFileSystem input = new POIFSFileSystem(fs);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);

            int startsFromRow=1;   // normal position
            int facultyCell=8;     // normal position
            int courseNameCell=2;  // normal position
            int sectionCell=3;     // normal position

            for(int i=0;i<sheet.getLastRowNum();i++){
                for(int j=0;j<(int)sheet.getRow(i).getLastCellNum();j++){
                    String temp="";
                    double tempIntValue=0;
                    boolean foundNumericCell=false;
                    try {
                        temp = sheet.getRow(i).getCell(j).getStringCellValue();
                    }catch (IllegalStateException e){
                        tempIntValue=sheet.getRow(i).getCell(j).getNumericCellValue();
                        foundNumericCell=true;
                    }catch (NullPointerException ex){

                    }
                    if(foundNumericCell)
                        temp=Double.toString(tempIntValue);

                    temp=temp.toLowerCase();
                    if(temp.equals("faculty")){
                        startsFromRow=i+1;
                        facultyCell=j;
                    }
                    if(temp.equals("title"))
                        courseNameCell=j;
                    if(temp.equals("section"))
                        sectionCell=j;
                }

            }

            //wb.close();

            FileOutputStream fOut=new FileOutputStream(f);

            // write all the full routine
            FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
            while(tempFaculty!=null){

                CourseToLinkedListOthersInfo tempSecList=tempFaculty.tempSectionOfFaculty;
                while(tempSecList!=null){

                    for (int i = startsFromRow; i < sheet.getLastRowNum(); i++) {
                        String tempCourseName = sheet.getRow(i).getCell(courseNameCell).getStringCellValue();
                        String tempSection = sheet.getRow(i).getCell(sectionCell).getStringCellValue();

                        StringTokenizer tok=new StringTokenizer(tempSection);
                        String tempSecTokenized="";
                        while(tok.hasMoreTokens()){
                            tempSecTokenized+=tok.nextToken();
                        }

                        tok=new StringTokenizer(tempCourseName);
                        String tempTitleTokenized="";
                        while(tok.hasMoreTokens()){
                            tempTitleTokenized+=tok.nextToken();
                            if(tok.hasMoreTokens())
                                tempTitleTokenized+=" ";
                        }

                        if (tempSecList.title.equals(tempTitleTokenized) && tempSecList.section.equals(tempSecTokenized)) {
                            if (tempSecList.faculty.equals("Drop")) {
                                sheet.getRow(i).getCell(facultyCell).setCellValue(tempSecList.faculty);
                                /*CellStyle style=sheet.getRow(i).getCell(facultyCell).getCellStyle();
                                Font font= wb.createFont();
                                font.setBold(false);
                                style.setFont(font);*/
                                //style.setFillBackgroundColor((short) 246);
                                //sheet.getRow(i).getCell(facultyCell).setCellStyle(style);
                            } else {
                                sheet.getRow(i).getCell(facultyCell).setCellValue(tempSecList.faculty);
                            }
                            break;
                        }
                    }


                    tempSecList=tempSecList.next;
                }

                tempFaculty=tempFaculty.next;
            }


            // write only drop sections
            CourseToLinkedList tempCourseList=AddSearchCourse.courseHeadPointer;
            while(tempCourseList!=null){
                CourseToLinkedListOthersInfo tempSecList=tempCourseList.firstSection;

                while(tempSecList!=null){

                    if(tempSecList.faculty.equals("Drop")) {
                        for (int i = startsFromRow; i < sheet.getLastRowNum(); i++) {
                            String tempCourseName = sheet.getRow(i).getCell(courseNameCell).getStringCellValue();
                            String tempSection = sheet.getRow(i).getCell(sectionCell).getStringCellValue();

                            StringTokenizer tok=new StringTokenizer(tempSection);
                            String tempSecTokenized="";
                            while(tok.hasMoreTokens()){
                                tempSecTokenized+=tok.nextToken();
                            }

                            tok=new StringTokenizer(tempCourseName);
                            String tempTitleTokenized="";
                            while(tok.hasMoreTokens()){
                                tempTitleTokenized+=tok.nextToken();
                                if(tok.hasMoreTokens())
                                    tempTitleTokenized+=" ";
                            }

                            if (tempSecList.title.equals(tempTitleTokenized) && tempSecList.section.equals(tempSecTokenized)) {
                                if (tempSecList.faculty.equals("Drop")) {
                                    sheet.getRow(i).getCell(facultyCell).setCellValue(tempSecList.faculty);
                                /*CellStyle style=sheet.getRow(i).getCell(facultyCell).getCellStyle();
                                Font font= wb.createFont();
                                font.setBold(false);
                                style.setFont(font);*/
                                    //style.setFillBackgroundColor((short) 246);
                                    //sheet.getRow(i).getCell(facultyCell).setCellStyle(style);
                                } else {
                                    sheet.getRow(i).getCell(facultyCell).setCellValue(tempSecList.faculty);
                                }
                                break;
                            }
                        }
                    }

                    tempSecList=tempSecList.next;
                }
                tempCourseList=tempCourseList.next;
            }
            System.out.println("Exported in xls format");
            wb.write(fOut);
            overridePrevRoutine();
            SavingCoursesAndFacultyInfo.resetAllFacultyAndCourses();

            try{
                Parent newParent= FXMLLoader.load(getClass().getClassLoader().getResource("operationSuccessful.fxml"));
                Scene newScene=new Scene(newParent,300,100);

                Stage newStage=new Stage();

                newStage.setScene(newScene);
                newStage.setTitle("Message");
                newStage.setResizable(false);
                newStage.centerOnScreen();
                newStage.show();

            }catch (Exception e){
                e.printStackTrace();
            }

        }catch(Exception e0){
            e0.printStackTrace();
            try{
                File f = new File("courses.xlsx");
                FileInputStream fs = new FileInputStream(f);
                //POIFSFileSystem input = new POIFSFileSystem(fs);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);

                int startsFromRow=1;   // normal position
                int facultyCell=8;     // normal position
                int courseNameCell=2;  // normal position
                int sectionCell=3;     // normal position

                for(int i=0;i<sheet.getLastRowNum();i++){
                    for(int j=0;j<(int)sheet.getRow(i).getLastCellNum();j++){
                        String temp="";
                        double tempIntValue=0;
                        boolean foundNumericCell=false;
                        try {
                            temp = sheet.getRow(i).getCell(j).getStringCellValue();
                        }catch (IllegalStateException e){
                            tempIntValue=sheet.getRow(i).getCell(j).getNumericCellValue();
                            foundNumericCell=true;
                        }catch (NullPointerException ex){

                        }
                        if(foundNumericCell)
                            temp=Double.toString(tempIntValue);

                        temp=temp.toLowerCase();
                        if(temp.equals("faculty")){
                            startsFromRow=i+1;
                            facultyCell=j;
                        }
                        if(temp.equals("title"))
                            courseNameCell=j;
                        if(temp.equals("section"))
                            sectionCell=j;
                    }

                }

                //wb.close();

                FileOutputStream fOut=new FileOutputStream(f);

                // write all the full routine
                FacultyInfo tempFaculty=AddRemoveSearchFaculty.facultyHeadPointer;
                while(tempFaculty!=null){

                    CourseToLinkedListOthersInfo tempSecList=tempFaculty.tempSectionOfFaculty;
                    while(tempSecList!=null){

                        for (int i = startsFromRow; i < sheet.getLastRowNum(); i++) {
                            String tempCourseName = sheet.getRow(i).getCell(courseNameCell).getStringCellValue();
                            String tempSection = sheet.getRow(i).getCell(sectionCell).getStringCellValue();

                            StringTokenizer tok=new StringTokenizer(tempSection);
                            String tempSecTokenized="";
                            while(tok.hasMoreTokens()){
                                tempSecTokenized+=tok.nextToken();
                            }

                            tok=new StringTokenizer(tempCourseName);
                            String tempTitleTokenized="";
                            while(tok.hasMoreTokens()){
                                tempTitleTokenized+=tok.nextToken();
                                if(tok.hasMoreTokens())
                                    tempTitleTokenized+=" ";
                            }

                            if (tempSecList.title.equals(tempTitleTokenized) && tempSecList.section.equals(tempSecTokenized)) {
                                if (tempSecList.faculty.equals("Drop")) {
                                    sheet.getRow(i).getCell(facultyCell).setCellValue(tempSecList.faculty);
                                /*CellStyle style=sheet.getRow(i).getCell(facultyCell).getCellStyle();
                                Font font= wb.createFont();
                                font.setBold(false);
                                style.setFont(font);*/
                                    //style.setFillBackgroundColor((short) 246);
                                    //sheet.getRow(i).getCell(facultyCell).setCellStyle(style);
                                } else {
                                    sheet.getRow(i).getCell(facultyCell).setCellValue(tempSecList.faculty);
                                }
                                break;
                            }
                        }

                        tempSecList=tempSecList.next;
                    }

                    tempFaculty=tempFaculty.next;
                }


                // write only drop sections
                CourseToLinkedList tempCourseList=AddSearchCourse.courseHeadPointer;
                while(tempCourseList!=null){
                    CourseToLinkedListOthersInfo tempSecList=tempCourseList.firstSection;

                    while(tempSecList!=null){

                        if(tempSecList.faculty.equals("Drop")) {
                            for (int i = startsFromRow; i < sheet.getLastRowNum(); i++) {
                                String tempCourseName = sheet.getRow(i).getCell(courseNameCell).getStringCellValue();
                                String tempSection = sheet.getRow(i).getCell(sectionCell).getStringCellValue();

                                StringTokenizer tok=new StringTokenizer(tempSection);
                                String tempSecTokenized="";
                                while(tok.hasMoreTokens()){
                                    tempSecTokenized+=tok.nextToken();
                                }

                                tok=new StringTokenizer(tempCourseName);
                                String tempTitleTokenized="";
                                while(tok.hasMoreTokens()){
                                    tempTitleTokenized+=tok.nextToken();
                                    if(tok.hasMoreTokens())
                                        tempTitleTokenized+=" ";
                                }

                                if (tempSecList.title.equals(tempTitleTokenized) && tempSecList.section.equals(tempSecTokenized)) {
                                    if (tempSecList.faculty.equals("Drop")) {
                                        sheet.getRow(i).getCell(facultyCell).setCellValue(tempSecList.faculty);
                                /*CellStyle style=sheet.getRow(i).getCell(facultyCell).getCellStyle();
                                Font font= wb.createFont();
                                font.setBold(false);
                                style.setFont(font);*/
                                        //style.setFillBackgroundColor((short) 246);
                                        //sheet.getRow(i).getCell(facultyCell).setCellStyle(style);
                                    } else {
                                        sheet.getRow(i).getCell(facultyCell).setCellValue(tempSecList.faculty);
                                    }
                                    break;
                                }
                            }
                        }

                        tempSecList=tempSecList.next;
                    }
                    tempCourseList=tempCourseList.next;
                }

                wb.write(fOut);
                System.out.println("Exported in xlsx format");
                overridePrevRoutine();
                SavingCoursesAndFacultyInfo.resetAllFacultyAndCourses();

                try{
                    Parent newParent= FXMLLoader.load(getClass().getClassLoader().getResource("operationSuccessful.fxml"));
                    Scene newScene=new Scene(newParent,300,100);

                    Stage newStage=new Stage();

                    newStage.setScene(newScene);
                    newStage.setTitle("Message");
                    newStage.setResizable(false);
                    newStage.centerOnScreen();
                    newStage.show();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }catch(Exception e){
                e.printStackTrace();

                try{
                    Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("fileNotFound.fxml"));
                    Stage newStage=new Stage();
                    Scene newScene=new Scene(root,300,120);
                    newStage.setScene(newScene);
                    newStage.setResizable(false);
                    newStage.centerOnScreen();
                    newStage.setTitle("Message");
                    newStage.show();
                }catch(Exception exp){
                    exp.printStackTrace();
                }
            }
        }

    }

    public void overridePrevRoutine(){

        Calendar cal = Calendar.getInstance();
        Date dateForExport=cal.getTime();
        Date dateImported=null;

        // read date from record
        try{
            FileInputStream fin=new FileInputStream("record.src");
            ObjectInputStream objectStreamer=new ObjectInputStream(fin);
            dateImported=(Date)objectStreamer.readObject();
            objectStreamer.close();
        }catch(Exception e){
            e.printStackTrace();
        }


        int dateDifference=dateDiff(dateForExport,dateImported);
        if(dateDifference<60){
            SavingCoursesAndFacultyInfo.storeOnlyPrevRoutine();
        }else{
            SavingCoursesAndFacultyInfo.storePrevData();
        }


        // writing date in file
        try{
            FileOutputStream fout=new FileOutputStream("record.src");
            ObjectOutputStream objectStreamer = new ObjectOutputStream(fout);
            objectStreamer.writeObject(dateForExport);
            objectStreamer.close();
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public int dateDiff(Date current,Date compared){

        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        String strDateCurrent=dateFormat.format(current);
        StringTokenizer tok=new StringTokenizer(strDateCurrent,"-");
        String nowDay=tok.nextToken();
        String nowMonth=tok.nextToken();
        String nowYear=tok.nextToken();

        String strDateCompared=null;
        if(compared==null){
            strDateCompared="1-1-1970";
        }else{
            strDateCompared=dateFormat.format(compared);
        }


        tok=new StringTokenizer(strDateCompared,"-");
        String comparedDay=tok.nextToken();
        String comparedMonth=tok.nextToken();
        String comparedYear=tok.nextToken();

        int diff=Math.abs(Integer.parseInt(nowDay)-Integer.parseInt(comparedDay)) +
                (Math.abs(Integer.parseInt(nowMonth)-Integer.parseInt(comparedMonth)) * 30) +
                (Math.abs(Integer.parseInt(nowYear)-Integer.parseInt(comparedYear)) * 365);


        System.out.println("Current Date: "+strDateCurrent+" Compared Date: "+strDateCompared);
        System.out.println("Date difference: "+diff);

        return diff;
    }

}
