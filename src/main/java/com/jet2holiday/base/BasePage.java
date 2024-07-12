package com.jet2holiday.base;


import com.jet2holiday.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage{

    public static WebDriver driver;
    public static Properties properties;


    public BasePage(){
        PageFactory.initElements(driver, this);
        try {

            properties = new Properties();
            FileInputStream file = new FileInputStream("C:\\Users\\tusha\\IdeaProjects\\Jet2HolidayAutomation\\src\\main\\java\\com\\jet2holiday\\config\\config.properties");
            properties.load(file);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void initialization() throws IOException {
        driver = WebDriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.jet2holidays.com/");

    }




}
