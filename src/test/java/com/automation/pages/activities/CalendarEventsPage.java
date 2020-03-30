package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

//where we store the web element of current user name locator => in abstractPageBase ;
// because every page has that webelement
//owner name locator =>  in calenderEventsPage since it is belong to calender event
public class CalendarEventsPage extends AbstractPageBase {


    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css="[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css="[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    public List<String> getColumnNames(){
        BrowserUtils.waitForPageToLoad(20);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector( "[title='Create Calendar event']")));
    //calismazsa yukaridakini ekle
        return BrowserUtils.getTextFromWebElements(columnNames);

    }


    public String getStartTime(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        //eger code hala gecmiyorsa asagidakini kullan.
     //   wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        wait.until(ExpectedConditions.elementToBeClickable(startTime));
        return startTime.getAttribute("value");

    }

    public String getEndTime(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        wait.until(ExpectedConditions.elementToBeClickable(endTime));
        return endTime.getAttribute("value");
    }

    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(15);
        //wait for element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        //yukaridakini kullanmak zorunda degilsin ama bazilarinin code u calismadigi icin hoca yazdi. burda kendimizi
        //tekrar ediyoruz, ama baska yol yok dedi.
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForPageToLoad(15);
     //   wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
      //  BrowserUtils.waitForPageToLoad(20);
        //calismiyorsa soluk olanlari commentout yap, aktif yap
    }

    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        //if you need the the page to be scrolled down add this method
       // BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }


}






