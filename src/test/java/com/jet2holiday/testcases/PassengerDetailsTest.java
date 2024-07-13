package com.jet2holiday.testcases;

import com.jet2holiday.listener.TestListners;
import com.jet2holiday.pages.*;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
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
        loginPage = new LoginPage();
        searchHoliday = new SearchHoliday();
        selectHolidayPackage = new SelectHolidayPackage();
        passengerDetails = new PassengerDetails();
    }

    @Test(dataProvider = "PassengerDetails", dataProviderClass = ExcelFileReading.class)
    public void PassengerDetailsSingleUser(String user,String pass,String fname,String lname,String date,String month,String year) throws InterruptedException {
        searchHoliday = loginPage.singleUserLogin();
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
