package com.jet2holiday.pages;

import com.jet2holiday.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BasePage {
    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
    public String email = properties.getProperty("emailId");
    public String pwd = properties.getProperty("pass");

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

    public void enterEmailId(String emails){
        emailId.sendKeys(emails);
    }

    public void clickLoginContinueButton(){
        clickLoginContinue.click();
    }

    public void enterPassword(String pass){
        passwords.sendKeys(pass);
    }

    public void clickNextButton(){
        clickNext.click();
    }



    public SearchHoliday singleUserLogin(){
        clickCookiePage();
        clickLoginButton();
        enterEmailId(email);
        clickLoginContinueButton();
        enterPassword(pwd);
        clickNextButton();
        return new SearchHoliday();
    }

    public SearchHoliday multipleUserLogin(String emails,String passs){
        clickCookiePage();
        clickLoginButton();
        enterEmailId(emails);
        clickLoginContinueButton();
        enterPassword(passs);
        clickNextButton();
        return new SearchHoliday();
    }


}