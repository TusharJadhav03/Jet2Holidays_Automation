package com.jet2holiday.testcases;

import com.jet2holiday.listener.TestListners;
import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.pages.PassengerDetails;
import com.jet2holiday.pages.SearchHoliday;
import com.jet2holiday.pages.SelectHolidayPackage;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
import io.qameta.allure.*;
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
        logger.info("SelectHolidayPackageTest Method Running....");
        loginPage = new LoginPage();
        searchHoliday = new SearchHoliday();
        selectHolidayPackage = new SelectHolidayPackage();
    }

    @Test(priority = 1)
    @Description("Select holiday package successfully")
    @Epic("EP001")
    @Feature("Feature1 : Select Holiday Package")
    @Story("Story : Select holiday package")
    @Step("Select holiday package with single user")
    @Severity(SeverityLevel.NORMAL)
    public void SelectHolidaySingleUser() throws InterruptedException {
        searchHoliday = loginPage.singleUserLogin();
        selectHolidayPackage = searchHoliday.searchHoliday();
        passengerDetails = selectHolidayPackage.selectHolidayPackage();
    }

    @Test(priority = 2,dataProvider = "LoginData", dataProviderClass = ExcelFileReading.class)
    @Description("Select holiday package successfully")
    @Epic("EP002")
    @Feature("Feature1 : Select Holiday Package")
    @Story("Story : Select holiday package")
    @Step("Select holiday package with multiple user")
    @Severity(SeverityLevel.NORMAL)
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
