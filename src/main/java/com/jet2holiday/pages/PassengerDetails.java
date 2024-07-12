package com.jet2holiday.pages;

import com.jet2holiday.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PassengerDetails extends BasePage {
    public PassengerDetails() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="(//select)[1]")
    WebElement clickTitleDropdown;

    @FindBy(xpath = "//option[normalize-space()='Mr']")
    WebElement clickMrOption;

    @FindBy(xpath = "//input[@data-bind='value: firstName, $el: $elFirstname, event: {blur: onFirstnameBlur, focus: focusFirstname}']")
    WebElement enterFirstName;

    @FindBy(xpath = "//input[@data-bind='value: surName, $el: $elSurname, event: {blur: onSurnameBlur, focus: focusSurname}']")
    WebElement enterLastName;

    @FindBy(xpath = "//select[contains(@class,'select-lead-passenger')]")
    WebElement leadPassenger;

    @FindBy(xpath = "//button[@id='continue-button']")
    WebElement passengerDetailsContinueBtn;

    @FindBy(xpath = "//button[@id='continue-button']")
    WebElement essential;

    public void setClickTitleDropdown(){
        clickTitleDropdown.click();
    }

    public void setClickMrOption(){
        clickMrOption.click();
    }

    public void setEnterFirstName(String fname){
        enterFirstName.sendKeys(fname);
    }

    public  void setEnterLastName(String lname){
        enterLastName.sendKeys(lname);
    }

    public void setLeadPassenger(){
        leadPassenger.click();
        leadPassenger.sendKeys(Keys.DOWN);
        leadPassenger.sendKeys(Keys.ENTER);

    }

    public void setPassengerDetailsContinueBtn(){
        passengerDetailsContinueBtn.click();
    }

    public void setEssential(){
        essential.click();
    }

    public static void selectDateOfBirthLogin(WebDriver driver, String date, String month, String year) throws InterruptedException {
        WebElement drpDayEle = driver.findElement(By.xpath("(//select)[3]"));
        Select drpDay = new Select(drpDayEle);
        drpDay.selectByValue(date);
        Thread.sleep(2000);

        WebElement drpMonthEle = driver.findElement(By.xpath("(//select)[4]"));
        Select drpMonth = new Select(drpMonthEle);
        drpMonth.selectByValue(month);
        Thread.sleep(2000);

        WebElement drpYearEle = driver.findElement(By.xpath("(//select)[5]"));
        Select drpYear = new Select(drpYearEle);
        drpYear.selectByValue(year);
        Thread.sleep(2000);
    }

    public PaymentPage addPassengerDetails(String fname,String lname,String datep,String monthp,String yearp) throws InterruptedException {
        PassengerDetails pd = new PassengerDetails();
        Thread.sleep(3000);
        pd.setClickTitleDropdown();
        pd.setClickMrOption();
        pd.setEnterFirstName(fname);
        pd.setEnterLastName(lname);
        selectDateOfBirthLogin(driver,datep,monthp,yearp);
        pd.setLeadPassenger();
        pd.setPassengerDetailsContinueBtn();
        pd.setEssential();
        return  new PaymentPage();
    }
}
