package com.jet2holiday.base;

import com.jet2holiday.utils.WebDriverManager;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public static Properties properties;
    public static FileInputStream fi;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static String link = "C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\src\\main\\java\\com\\jet2holiday\\testdata\\Book1.xlsx";


    public BasePage(){
        PageFactory.initElements(driver, this);
        try {

            properties = new Properties();
            FileInputStream file = new FileInputStream("C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\src\\main\\java\\com\\jet2holiday\\config\\config.properties");
            properties.load(file);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void initialization(){
        driver = WebDriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.jet2holidays.com/");
    }



    public  int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(link);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public  int getColCount(String sheetName,int rownum) throws IOException {
        fi = new FileInputStream(link);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public  String getCellData(String sheetName,int rownum,int colnum) throws IOException {
        fi = new FileInputStream(link );
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);

        String data;
        try{
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        }
        catch (Exception e){
            data = " ";
        }
        wb.close();
        fi.close();
        return data;
    }


}
