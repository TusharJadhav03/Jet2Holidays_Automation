package com.jet2holiday.testcases;

import com.jet2holiday.listener.TestListners;
import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.pages.PassengerDetails;
import com.jet2holiday.pages.SearchHoliday;
import com.jet2holiday.pages.SelectHolidayPackage;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestListners.class)
public class SelectHolidayPackageTest extends SelectHolidayPackage {

    LoginPage loginPage;
    SearchHoliday searchHoliday;
    SelectHolidayPackage selectHolidayPackage;
    PassengerDetails passengerDetails;

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        searchHoliday = new SearchHoliday();
        selectHolidayPackage = new SelectHolidayPackage();
    }



    @Test
    public void SelectHolidaySingleUser() throws InterruptedException {
        searchHoliday = loginPage.singleUserLogin();
        selectHolidayPackage = searchHoliday.searchHoliday();
        passengerDetails = selectHolidayPackage.selectHolidayPackage();
    }

    @Test(dataProvider = "LoginData", dataProviderClass = ExcelFileReading.class)
    public void SelectHolidayMultipleUser(String user,String pwd) throws InterruptedException {
        searchHoliday = loginPage.multipleUserLogin(user, pwd);
        selectHolidayPackage = searchHoliday.searchHoliday();
        passengerDetails = selectHolidayPackage.selectHolidayPackage();
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }
}
