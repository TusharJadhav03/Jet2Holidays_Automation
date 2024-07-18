package com.jet2holiday.testcases;

import com.jet2holiday.base.BasePage;
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
public class Tests extends BasePage {

    LoginPage loginPage;
    SearchHoliday searchHoliday;
    SelectHolidayPackage selectHolidayPackage;
    PassengerDetails passengerDetails;
    PaymentPage paymentPage;

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        logger.info("Book Holiday Package Method Running....");
        loginPage = new LoginPage();
        searchHoliday = new SearchHoliday();
        selectHolidayPackage = new SelectHolidayPackage();
        passengerDetails = new PassengerDetails();
    }

    @Test(priority = 1,dataProvider = "UserDetails", dataProviderClass = ExcelFileReading.class)
    @Description("Book holiday package successfully")
    @Epic("EP001")
    @Feature("Feature1 : Book Holiday")
    @Story("Story : Book holiday package ")
    @Step("Book holiday package with user account")
    @Severity(SeverityLevel.CRITICAL)
    public void BookHolidayWithUserAccount(String user,String pass,String fname,String lname,String date,String month,String year,String countrys,String adds,String citys,String nos,String emails,String cnos,String cnames,String cmonths,String cyears,String cvvs) throws InterruptedException {
        searchHoliday = loginPage.multipleUserLogin(user,pass);
        selectHolidayPackage = searchHoliday.searchHoliday();
        passengerDetails = selectHolidayPackage.selectHolidayPackage();
        paymentPage = passengerDetails.addPassengerDetails(fname,lname,date,month,year);
        paymentPage = paymentPage.setPayment(countrys,adds,citys,nos,emails,cnos,cnames,cmonths,cyears,cvvs);
    }


    @Test(priority = 2,dataProvider = "UserDetails", dataProviderClass = ExcelFileReading.class)
    @Description("Book holiday package successfully")
    @Epic("EP002")
    @Feature("Feature1 : Book Holiday")
    @Story("Story : Book holiday package ")
    @Step("Book holiday package without user account")
    @Severity(SeverityLevel.CRITICAL)
    public void BookHolidayWithoutUserAccount(String user,String pass,String fname,String lname,String date,String month,String year,String countrys,String adds,String citys,String nos,String emails,String cnos,String cnames,String cmonths,String cyears,String cvvs) throws InterruptedException {
        loginPage.clickCookiePage();
        selectHolidayPackage = searchHoliday.searchHoliday();
        passengerDetails = selectHolidayPackage.selectHolidayPackage();
        paymentPage = passengerDetails.addPassengerDetail(fname,lname,date,month,year);
        paymentPage = paymentPage.setPayment(countrys,adds,citys,nos,emails,cnos,cnames,cmonths,cyears,cvvs);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }
}
