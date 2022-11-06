package util;

import basepage.BasePage;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TestUtility extends BasePage {

    public  static long Page_Load_Time = 20; //time for loading page
    public static long Implicit_Wait = 10; //time for executing action

    //code for reading from excel workbook and sheet
    public static String TESTDATA_SHEET_PATH = "C:\\Users\\Saeed\\Documents\\Foodics\\Automation Task\\Automation_Task\\src\\main\\java\\testdata\\Data_Driven.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] gettestdata(String sheetname) {
        FileInputStream file = null;

        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = null;
        try {
            //workbook = new XSSFWorkbook(file);
             book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //XSSFSheet sheet = workbook.getSheet(sheetname);
        sheet = book.getSheet(sheetname);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++)
        {
            for (int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
            {
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
            }
        }
        return data;
    }


}
