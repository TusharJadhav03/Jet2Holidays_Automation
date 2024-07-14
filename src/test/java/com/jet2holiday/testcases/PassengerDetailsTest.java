package com.jet2holiday.testcases;

import com.jet2holiday.listener.TestListners;
import com.jet2holiday.pages.*;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListners.class)
public class PassengerDetailsTest extends PassengerDetails {
    LoginPage loginPage;
    SearchHoliday searchHoliday;
    SelectHolidayPackage selectHolidayPackage;
    PassengerDetails passengerDetails;
    PaymentPage paymentPage;

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        logger.info("PassengerDetailsTest Method Running....");
        loginPage = new LoginPage();
        searchHoliday = new SearchHoliday();
        selectHolidayPackage = new SelectHolidayPackage();
        passengerDetails = new PassengerDetails();
    }

    @Test(priority = 1,dataProvider = "PassengerDetails", dataProviderClass = ExcelFileReading.class)
    @Description("Add passenger details successfully")
    @Epic("EP001")
    @Feature("Feature1 : Add Passenger Details")
    @Story("Story : Add passengers details ")
    @Step("Add passenger details with single user")
    @Severity(SeverityLevel.NORMAL)
    public void PassengerDetailsSingleUser(String user,String pass,String fname,String lname,String date,String month,String year) throws InterruptedException {
        searchHoliday = loginPage.multipleUserLogin(user,pass);
        selectHolidayPackage = searchHoliday.searchHoliday();
        passengerDetails = selectHolidayPackage.selectHolidayPackage();
        paymentPage = passengerDetails.addPassengerDetails(fname,lname,date,month,year);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }
}
