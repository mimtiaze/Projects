import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by mimtiaze on 17-Jun-16.
 */
public class POITest {
    public static void main(String[] args) throws IOException {
        File f=new File("course offerings_5.29.2016 (Instructors+TA).xls");
        FileInputStream fs = new FileInputStream(f);
        HSSFWorkbook wb= new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);

        String temp=sheet.getRow(0).getCell(0).getStringCellValue();
        String temp1=sheet.getSheetName();

        System.out.println(temp1);


        for (int i=0;i<sheet.getLastRowNum();i++){
            System.out.println(i+"   "+sheet.getRow(i).getCell(0).getStringCellValue()+"   "+sheet.getRow(i).getCell(7).getStringCellValue());
        }
    }
}
