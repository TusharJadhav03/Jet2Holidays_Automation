package com.jet2holiday.listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.jet2holiday.base.BasePage;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class TestListners extends BasePage implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+ " :onTestStart");
        extent.attachReporter((ExtentObserver) spark);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.pass("Test successfully executed");
        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " :onTestFailure");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Tushar").assignDevice("Windows 11,Chrome");
        test.fail("Test method failed");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File fs = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File des = new File("C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\Screenshots\\"+result.getMethod().getMethodName()+".png");
        File des = new File("C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\Screenshots\\" + result.getMethod().getMethodName() + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png");
        try {
            FileHandler.copy(fs,des);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        test.addScreenCaptureFromPath("C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\Screenshots\\" + result.getMethod().getMethodName() + ".png");
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" :onTestSkipped");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.skip("Test method Skipped..");
        extent.flush();
    }
}
