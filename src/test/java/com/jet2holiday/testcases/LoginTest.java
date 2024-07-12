package com.jet2holiday.testcases;

import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.pages.SearchHoliday;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends LoginPage {

    public LoginTest() throws IOException {
    }

    LoginPage loginPage;
    SearchHoliday searchHoliday;

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void LoginWithSingleUser(){
        searchHoliday = loginPage.singleUserLogin();
    }

    @Test(dataProvider = "LoginData", dataProviderClass = ExcelFileReading.class)
    public void LoginWithMultipleUser(String emails,String passs) {
        searchHoliday = loginPage.multipleUserLogin(emails,passs);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }

}
