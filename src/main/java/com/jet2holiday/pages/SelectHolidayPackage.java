package com.jet2holiday.pages;

import com.jet2holiday.base.BasePage;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHolidayPackage extends BasePage {
    public SelectHolidayPackage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='ga_results_more_info_71458']")
    WebElement packageClickContinueBtn;

    @FindBy(xpath = "//button[@id='continue-button']")
    WebElement packageClickContinueBtn1;

    @FindBy(xpath = "(//button[@type='button' and @class='modal-box__button-close'])[2]")
    WebElement closeDiscountFrame;

    @FindBy(xpath = "//div[@class='basket-summary basket-summary--leading']")
    WebElement checkHolidayPackageContinueBtn;

    @FindBy(xpath = "//button[@id='continue-button']")
    WebElement tailorYourHolidayContinueBtn;

    @FindBy(xpath = "//select[@class='form-select__origin']")
    WebElement lowToHighPrice;

    public void setPackageClickContinueBtn(){
        packageClickContinueBtn.click();
    }

    public void setPackageClickContinueBtn1(){
        packageClickContinueBtn1.click();
    }

    public void setCloseDiscountFrame(){
            closeDiscountFrame.click();
    }

    public void setCheckHolidayPackageContinueBtn(){
        checkHolidayPackageContinueBtn.click();
    }

    public void setTailorYourHolidayContinueBtn(){
        tailorYourHolidayContinueBtn.click();
    }

    public void setLowToHighPrice(){
        lowToHighPrice.click();
        lowToHighPrice.sendKeys(Keys.DOWN);
        lowToHighPrice.sendKeys(Keys.ENTER);
    }

    public PassengerDetails selectHolidayPackage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        SelectHolidayPackage shp = new SelectHolidayPackage();
        shp.setPackageClickContinueBtn();
        shp.setCloseDiscountFrame();
        Thread.sleep(5000);
        shp.setCheckHolidayPackageContinueBtn();
        shp.setTailorYourHolidayContinueBtn();
        Thread.sleep(2000);
        setPackageClickContinueBtn1();
        return new PassengerDetails();
    }

}
