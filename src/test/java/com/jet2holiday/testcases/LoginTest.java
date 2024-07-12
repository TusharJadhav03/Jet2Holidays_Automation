package com.jet2holiday.testcases;

import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.utils.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends LoginPage  {

    @BeforeMethod
    public void setUp() {
        initialization();

    }

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        LoginPage excelFileReader = new LoginPage();
        int totalRows = excelFileReader.getRowCount("Sheet1");
        int totalCols = excelFileReader.getColCount("Sheet1",1);

        String loginData[][] = new String[totalRows][totalCols];

        for(int i=1;i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                loginData[i-1][j]= excelFileReader.getCellData("Sheet1",i,j);
            }
        }
        return loginData;
    }

    @Test(dataProvider = "LoginData")
    public void Login(String user,String pwd){
        LoginPage lp = new LoginPage();
        lp.clickCookiePage();
        lp.clickLoginButton();
        lp.enterEmailId(user);
        lp.clickLoginContinueButton();
        lp.enterPassword(pwd);
        lp.clickNextButton();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }

}
