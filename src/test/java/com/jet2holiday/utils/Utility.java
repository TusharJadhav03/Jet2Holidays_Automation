package com.jet2holiday.utils;

import com.jet2holiday.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

public class Utility extends BasePage {

    public static void failedTest(ITestResult result) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File fs = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\Screenshots\\"+result.getMethod().getMethodName()+".png");
        FileHandler.copy(fs,des);
    }
}
