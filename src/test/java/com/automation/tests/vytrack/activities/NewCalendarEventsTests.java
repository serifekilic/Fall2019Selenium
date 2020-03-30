package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {
    LoginPage loginPage=new LoginPage();
    CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
    //bu ikisi test icine de konabilirdi
    @Test
    public void defaultOptionsTest(){

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(),calendarEventsPage.getCurrentUserName());
        String actualStartDate=calendarEventsPage.getStartDate();
        String expectedStartDate=DateTimeUtilities.getCurrentDate("MMM dd, yyyy");
      //  Assert.assertEquals(calendarEventsPage.getStartDate(), DateTimeUtilities.getCurrentDate("MMM dd, yyyy"));
   //yukaridaki iki Stringi iceriyor.
        Assert.assertEquals(actualStartDate,expectedStartDate);
    }
    /**
     * 15 minutes until 3:45
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/
    @Test
    public void timeDifferenceTest(){
       loginPage.login();
       calendarEventsPage.navigateTo("Activities","Calendar Events");

       calendarEventsPage.clickToCreateCalendarEvent();
       String startTime=calendarEventsPage.getStartTime();//get start time
       String endTime=calendarEventsPage.getEndTime();//get end time
       String format="h:m a";//format 5:15 AM for example
      long actual=DateTimeUtilities.getTimeDifference(startTime,endTime,format);
      Assert.assertEquals(actual,1,"Time difference is not correct");


    }
    //use qa1
    /**
     * Test Case: Verify calendar events table
     * Login as store manager
     * Go to Activities --> Calendar Events
     * And verify that column names displayed:
     * |TITLE            |
     * |CALENDAR         |
     * |START            |
     * |END              |
     * |RECURRENT        |
     * |RECURRENCE       |
     * |INVITATION STATUS|
     */

    @Test
    public void verifyColumnNamesTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");

        Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);
    }
    }