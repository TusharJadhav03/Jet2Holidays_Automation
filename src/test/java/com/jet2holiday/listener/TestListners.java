package com.jet2holiday.listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.jet2holiday.base.BasePage;
import com.jet2holiday.utils.Utility;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class TestListners extends BasePage implements ITestListener {

    Utility utility;

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
        System.out.println(result.getMethod().getMethodName()+" :onTestFailure");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Tushar").assignDevice("Windows 11,Chrome");
        test.fail("Test method failed");
//        String FTname = result.getMethod().getMethodName();
        utility = new Utility();
        try {
            utility.failedTest();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath("C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\Screenshots"+result.getMethod().getMethodName()+".png");
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
