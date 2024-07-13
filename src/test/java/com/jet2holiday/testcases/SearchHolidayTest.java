package com.jet2holiday.testcases;

import com.jet2holiday.listener.TestListners;
import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.pages.SearchHoliday;
import com.jet2holiday.pages.SelectHolidayPackage;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
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
        loginPage = new LoginPage();
        searchHoliday = new SearchHoliday();
    }

    @Test
    public void SearchHolidaySingleUser(){
        searchHoliday = loginPage.singleUserLogin();
        selectHolidayPackage = searchHoliday.searchHoliday();
    }

    @Test(dataProvider = "LoginData", dataProviderClass = ExcelFileReading.class)
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
