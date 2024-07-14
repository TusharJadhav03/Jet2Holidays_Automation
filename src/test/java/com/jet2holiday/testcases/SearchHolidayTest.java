package com.jet2holiday.testcases;

import com.jet2holiday.listener.TestListners;
import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.pages.SearchHoliday;
import com.jet2holiday.pages.SelectHolidayPackage;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListners.class)
public class SearchHolidayTest extends SearchHoliday {

    LoginPage loginPage;
    SearchHoliday searchHoliday;
    SelectHolidayPackage selectHolidayPackage;

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        logger.info("SearchHolidayTest Method Running....");
        loginPage = new LoginPage();
        searchHoliday = new SearchHoliday();
    }

    @Test(priority = 1)
    @Description("Verify search holiday package successfully")
    @Epic("EP001")
    @Feature("Feature1 : Search Holiday")
    @Story("Story : Search holiday package")
    @Step("Search holiday package with single user")
    @Severity(SeverityLevel.CRITICAL)
    public void SearchHolidaySingleUser(){
        searchHoliday = loginPage.singleUserLogin();
        selectHolidayPackage = searchHoliday.searchHoliday();
    }

    @Test(priority = 2,dataProvider = "LoginData", dataProviderClass = ExcelFileReading.class)
    @Description("Verify search holiday package successfully")
    @Epic("EP002")
    @Feature("Feature1 : Search Holiday")
    @Story("Story : Search holiday package")
    @Step("Search holiday package with multiple user")
    @Severity(SeverityLevel.CRITICAL)
    public void SearchHolidayMultipleUser(String user,String pwd){
        searchHoliday = loginPage.multipleUserLogin(user, pwd);
        selectHolidayPackage = searchHoliday.searchHoliday();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }
}
