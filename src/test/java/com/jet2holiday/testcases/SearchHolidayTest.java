package com.jet2holiday.testcases;

import com.jet2holiday.base.BasePage;
import com.jet2holiday.pages.LoginPage;
import com.jet2holiday.pages.SearchHoliday;
import com.jet2holiday.utils.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchHolidayTest extends BasePage {

    @BeforeMethod
    public void setUp(){
        initialization();
    }

    @Test
    public void SearchHoliday(){
        LoginPage lp = new LoginPage();
        lp.directLogin();
        SearchHoliday sh = new SearchHoliday();
        sh.searchHoliday();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.closeDriver();
    }
}
