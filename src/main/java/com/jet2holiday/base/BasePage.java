package com.jet2holiday.base;

import com.jet2holiday.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public void initialization(){
        driver = WebDriverManager.getDriver();
//        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.jet2holidays.com/");
    }

//    try {
//
//        properties = new Properties();
//        FileInputStream file = new FileInputStream(".\\config\\config.properties");
//        properties.load(file);
//    }
//        catch(Exception e){
//        System.out.println(e.getMessage());
//    }


}
