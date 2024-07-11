package com.jet2holiday.pages;

import com.jet2holiday.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement cookieHandler;

    @FindBy(xpath = "//a[@href='/api/jet2/login/b2clogin']")
    WebElement clickLoginBtn;

    @FindBy(xpath = "//input[@id='email' and @placeholder='Email Address']")
    WebElement emailId;

    @FindBy(xpath = "//*[@id='continue']")
    WebElement clickLoginContinue;

    @FindBy(xpath = "//*[@id='password']")
    WebElement passwords;

    @FindBy(xpath = "//*[@id='next']")
    WebElement clickNext;

    public void clickCookiePage(){
        cookieHandler.click();
    }

    public void clickLoginButton(){
        clickLoginBtn.click();
    }

    public void enterEmailId(String email){
        emailId.sendKeys(email);
    }

    public void clickLoginContinueButton(){
        clickLoginContinue.click();
    }

    public void enterPassword(String pwd){
        passwords.sendKeys(pwd);
    }

    public void clickNextButton(){
        clickNext.click();
    }


    public SearchHoliday directLogin(){
        clickCookiePage();
        clickLoginButton();
        enterEmailId("tusharjadhav228@gmail.com");
        clickLoginContinueButton();
        enterPassword("Sakshi@1228");
        clickNextButton();
        return new SearchHoliday();
    }
}