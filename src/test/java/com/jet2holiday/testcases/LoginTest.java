package com.jet2holiday.testcases;

import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.utils.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends LoginPage  {

    @BeforeMethod
    public void setUp() {
        initialization();

    }

    @Test
    public void Login(){
        LoginPage lp = new LoginPage();
        lp.clickCookiePage();
        lp.clickLoginButton();
        lp.enterEmailId("tusharjadhav228@gmail.com");
        lp.clickLoginContinueButton();
        lp.enterPassword("Sakshi@1228");
        lp.clickNextButton();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }

}
