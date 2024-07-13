package com.jet2holiday.utils;

import com.jet2holiday.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Utility extends BasePage {

    public void failedTest() throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File fs = ts.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\Screenshots\\fail.png");
        FileHandler.copy(fs,des);
    }
}
