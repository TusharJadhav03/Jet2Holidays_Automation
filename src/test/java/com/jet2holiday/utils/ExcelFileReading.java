package com.jet2holiday.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFileReading {

    public static FileInputStream fi;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static String link = "C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\src\\main\\java\\com\\jet2holiday\\testdata\\Book1.xlsx";

    public static String[][] getData(String Sheets) throws IOException {
        int totalRows = getRowCount(Sheets);
        int totalCols = getColCount(Sheets,1);

        String loginData[][] = new String[totalRows][totalCols];
        for(int i=1;i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                loginData[i-1][j]= getCellData(Sheets,i,j);
            }
        }
        return loginData;
    }
    public static int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(link);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public static int getColCount(String sheetName, int rownum) throws IOException {
        fi = new FileInputStream(link);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String sheetName, int rownum, int colnum) throws IOException {
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


    @DataProvider(name = "CombinedData")
    public Object[][] combinedData() throws IOException {
        String[][] loginData = getData("LoginDetails");
        String[][] passengerDetails = getData("PassengerDetails");

        int totalRows = Math.min(loginData.length,passengerDetails.length);
        int totalColumns = loginData[0].length + passengerDetails[0].length;

        Object[][] combinedData = new Object[totalRows][totalColumns];

        for (int i = 0; i < totalRows; i++) {
            int columnIndex = 0;
            for (int j = 0; j < loginData[i].length; j++) {
                combinedData[i][columnIndex++] = loginData[i][j];
            }
            for (int j = 0; j < passengerDetails[i].length; j++) {
                combinedData[i][columnIndex++] = passengerDetails[i][j];
            }
        }

        return combinedData;
    }

    @DataProvider(name="PassengerDetailsWithoutLogin")
    public static Object[][] PassengerDetailsWithoutLogin() throws IOException {
        String[][] PassengersDetails = getData("PassengerDetails");
        int totalRows = PassengersDetails.length;
        int totalColumns = PassengersDetails[0].length;

        int columnIndex = 2;
        int startIndex = totalColumns-columnIndex;
        Object[][] PassengerData = new Object[totalRows][totalColumns];
        for(int i=0;i<totalRows;i++){

            for(int j=0;j<PassengerData[i].length;j++){
                PassengerData[i][startIndex++] = PassengersDetails[i][j];
            }
        }
        return PassengersDetails;
    }

    @DataProvider(name = "LoginData")
    public static Object[][] loginData() throws IOException {
        return getData("LoginDetails");
    }

    @DataProvider(name = "PassengerDetails")
    public static Object[][] passengerDetails() throws IOException {
        return getData("PassengerDetails");
    }

    @DataProvider(name = "UserDetails")
    public static Object[][] userDetails() throws IOException {
        return getData("UserDetails");
    }

}
