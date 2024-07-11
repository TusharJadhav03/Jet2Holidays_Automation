package com.jet2holiday.pages;

import com.jet2holiday.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class SearchHoliday extends BasePage {
    public SearchHoliday(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@class=\"search-box-group__link\"])[1]")
    WebElement clickDepartingListIcon;

    @FindBy(xpath = "//span[normalize-space()='Manchester']")
    WebElement selectDepartureAirport;

    @FindBy(xpath = "//span[normalize-space()='Done']")
    WebElement clickDepartureDone;

    @FindBy(xpath = "//span[@class='checkbox-button-group__label-text'][normalize-space()='Rome']")
    WebElement selectDestination;

    @FindBy(xpath = "(//a[@class='bttn bttn--primary bttn--3d button--base'])[1]")
    WebElement clickDestinationDone;

    @FindBy(xpath = "//input[@id='search-box-guests']")
    WebElement clickGuestInout;

    @FindBy(xpath = "//button[@data-gal='remove-adult-from-room-1']")
    WebElement selectGuestAndRoom;

    @FindBy(xpath = "//a[@data-gal='finished-guest-selection']")
    WebElement clickGuestDone;

    @FindBy(xpath = "//span[text()='Search holidays']")
    WebElement clickSearchHoliday;

    public void setClickDepartingListIconButton(){
        clickDepartingListIcon.click();
    }

    public void setSelectDepartureAirport(){
        selectDepartureAirport.click();
    }

    public void setClickDepartureDone(){
        clickDepartureDone.click();
    }

    public void setSelectDestination(){
        selectDestination.click();
    }

    public void setClickDestinationDone(){
        clickDestinationDone.click();
    }

    public void setClickGuestInout(){
        clickGuestInout.click();
    }

    public void setSelectGuestAndRoom(){
        selectGuestAndRoom.click();
    }

    public void setClickGuestDone(){
        clickGuestDone.click();
    }

    public void setClickSearchHoliday(){
        clickSearchHoliday.click();
    }

    public void CookiesHandler(WebDriver driver){
        WebElement cookieHandler = driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
        cookieHandler.click();
    }

    public void SelectDayMonthYear(WebDriver driver,String month,String year,String date){
        WebElement drpMonthEle = driver.findElement(By.xpath("//select[@id='duration-month']"));
        Select drpMonth = new Select(drpMonthEle);
        drpMonth.selectByVisibleText(month);
        WebElement drpYearEle = driver.findElement(By.xpath("//select[@id='duration-year']"));
        Select drpYear = new Select(drpYearEle);
        drpYear.selectByVisibleText(year);
        List<WebElement> drpDateEle = driver.findElements(By.xpath("//li[contains(@class,'js-day')]//div//div"));
        for(WebElement dt : drpDateEle){
            String dateText = dt.getText();
            if (dateText.equals(date)){
                dt.click();
                break;
            }
        }
    }

    public void SelectNights(WebDriver driver,String day){
        List <WebElement> drpDays = driver.findElements(By.xpath("//select[@id='search-box-nights']//option"));
        for (WebElement dy : drpDays){
            String days = dy.getText();
            if(days.equals(day)){
                dy.click();
                break;
            }
        }
    }

    public void searchHoliday(){
        try {
            setClickDepartingListIconButton();
        }
        catch (StaleElementReferenceException e){
            setClickDepartingListIconButton();
        }
        setSelectDepartureAirport();
        setClickDepartureDone();
        setSelectDestination();
        setClickDestinationDone();
        SelectDayMonthYear(driver,"Aug","2024","03");
        SelectNights(driver,"15");
        setClickGuestInout();
        setSelectGuestAndRoom();
        setClickGuestDone();
        setClickSearchHoliday();
    }
}
