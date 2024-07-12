package com.jet2holiday.pages;

import com.jet2holiday.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends BasePage {
    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='booking-contact']")
    WebElement bookingContact;

    @FindBy(xpath = "//input[@id='house-number']")
    WebElement address;

    @FindBy(xpath = "//input[@id='town-city']")
    WebElement townCity;

    @FindBy(xpath = "//input[@name='telephone-number0']")
    WebElement telephoneNumber;

    @FindBy(xpath = "//input[@id='email-address']")
    WebElement emailId;

    @FindBy(xpath = "//input[@id='confirm-email-address']")
    WebElement confirmEmailId;

    @FindBy(xpath = "(//input[@id='payment-method-card'])[1]")
    WebElement creditCard;

    @FindBy(xpath = "//input[@id='card-number']")
    WebElement cardNumber;

    @FindBy(xpath = "//select[@id='card-type']")
    WebElement cardType;

    @FindBy(xpath = "//input[@id='name-on-card']")
    WebElement nameOnCard;

    @FindBy(xpath = "//input[@id='cvv-number']")
    WebElement cvvNumber;

    @FindBy(xpath = "//button[@id='book-button']")
    WebElement paySecurely;

    public void setBookingContact(){
        bookingContact.click();
        bookingContact.sendKeys(Keys.DOWN);
        bookingContact.sendKeys(Keys.ENTER);
    }

    public void setAddress(String hn){
        address.sendKeys(hn);
    }

    public void setTownCity(String tc){
        townCity.sendKeys(tc);
    }

    public void setTelephoneNumber(String number){
        telephoneNumber.sendKeys(number);
    }

    public void setEmailId(String email){
        emailId.sendKeys(email);
    }

    public void setConfirmEmailId(String cemail){
        confirmEmailId.sendKeys(cemail);
    }

    public void setCreditCard(){
        creditCard.click();
    }

    public void setCardNumber(String number){
        cardNumber.sendKeys(number);
    }

    public void setCardType(){
        cardType.click();
        cardType.sendKeys(Keys.DOWN);
        cardType.sendKeys(Keys.ENTER);
    }

    public void setNameOnCard(String name){
        nameOnCard.sendKeys(name);
    }

    public void setCvvNumber(String cvv){
        cvvNumber.sendKeys(cvv);
    }

    public void setPaySecurely(){
        paySecurely.click();
    }

    public static void selectResidenceCountry(WebDriver driver, String country){
        WebElement countryEle =driver.findElement(By.xpath("//select[@id='selectbox-residence-country']"));
        Select drpCountry = new Select(countryEle);
        drpCountry.selectByVisibleText(country);
    }

    public static void selectCreditCardInfo(WebDriver driver,String month,String year){
        WebElement drpMonthEle = driver.findElement(By.xpath("//select[@id='expiry-month']"));
        Select drpMonth = new Select(drpMonthEle);
        drpMonth.selectByVisibleText(month);
        WebElement drpYearEle = driver.findElement(By.xpath("//select[@id='expiry-year']"));
        Select drpYear = new Select(drpYearEle);
        drpYear.selectByVisibleText(year);
    }

    public PaymentPage setPayment(String country,String add,String city,String no,String email,String cno,String cname,String cmonth,String cyear,String cvv){
        PaymentPage pm = new PaymentPage();
        pm.setBookingContact();
        selectResidenceCountry(driver,country);
        pm.setAddress(add);
        pm.setTownCity(city);
        pm.setTelephoneNumber(no);
        pm.setEmailId(email);
        pm.setConfirmEmailId(email);
        pm.setCreditCard();
        pm.setCardNumber(cno);
//        pm.setCardType();
        pm.setNameOnCard(cname);
        selectCreditCardInfo(driver,cmonth,cyear);
        pm.setCvvNumber(cvv);
        pm.setPaySecurely();
        return new PaymentPage();
    }
}
