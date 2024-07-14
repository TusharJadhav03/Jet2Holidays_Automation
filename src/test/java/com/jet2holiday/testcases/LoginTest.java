package com.jet2holiday.testcases;

import com.jet2holiday.listener.TestListners;
import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.pages.SearchHoliday;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListners.class)
public class LoginTest extends LoginPage {


    public LoginTest() throws IOException {

    }

    LoginPage loginPage;
    SearchHoliday searchHoliday;

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        logger.info("LoginTest Method Running....");
        loginPage = new LoginPage();
    }


    @Test(priority = 1)
    @Description("Verify successfully login")
    @Epic("EP001")
    @Feature("Feature1 : Login")
    @Story("Story : Verify login")
    @Step("Verify login with single user")
    @Severity(SeverityLevel.CRITICAL)
    public void LoginWithSingleUser(){
        searchHoliday = loginPage.singleUserLogin();
    }

    @Test(priority = 2,dataProvider = "LoginData", dataProviderClass = ExcelFileReading.class)
    @Description("Verify successfully login")
    @Epic("EP002")
    @Feature("Feature1 : Login")
    @Story("Story : Verify login")
    @Step("Verify login with multiple user")
    @Severity(SeverityLevel.CRITICAL)
    public void LoginWithMultipleUser(String emails,String passs) {
        searchHoliday = loginPage.multipleUserLogin(emails,passs);
    }

    @Test(priority = 3)
    public void getTitles(){
        String title = loginPage.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "All Inclusive Holidays and Package Holidays | Jet2holidays");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }

}
