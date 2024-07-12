package com.jet2holiday.testcases;

import com.jet2holiday.pages.*;
import com.jet2holiday.utils.ExcelFileReading;
import com.jet2holiday.utils.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaymentTest extends PaymentPage {
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
    public void Payment(String user,String pass,String fname,String lname,String date,String month,String year,String countrys,String adds,String citys,String nos,String emails,String cnos,String cnames,String cmonths,String cyears,String cvvs) throws InterruptedException {
        searchHoliday = loginPage.singleUserLogin();
        selectHolidayPackage = searchHoliday.searchHoliday();
        passengerDetails = selectHolidayPackage.selectHolidayPackage();
        paymentPage = passengerDetails.addPassengerDetails(fname,lname,date,month,year);
        paymentPage = paymentPage.setPayment(countrys,adds,citys,nos,emails,cnos,cnames,cmonths,cyears,cvvs);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }
}
