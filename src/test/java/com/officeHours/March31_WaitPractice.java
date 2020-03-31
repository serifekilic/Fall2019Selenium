package com.officeHours;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
http://qa3.vytrack.com
salesmanager110
UserUser123
 */
/*
 /*
        Implicit Wait - set it 1 time and it will work for every findElement method
                        -NoSuchElementException
       Thread.sleep - not Selenium wait! Thread - java class, sleep() method of Thread class
                        stops the execution of java program
                        -We never want to use this method in our tests
        Explicit wait - we have to declare every time before the iteraction with element
                        Expected Condition we are looking for
        Singelton - it helps us to make sure we have only 1 instance of driver object at a time
     */


public class March31_WaitPractice extends AbstractTestBase{





    @Test
    public void testWait() {
        Driver.getDriver().get("http://qa3.vytrack.com");
        LoginPage loginPage=new LoginPage();



    }


}