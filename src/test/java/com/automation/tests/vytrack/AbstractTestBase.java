package com.automation.tests.vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
/*
Driver.getDriver().get(URL);
//We instantiate webDriver (=new className) in Driver class under utilities package.
//getDriver();  method will return us driver object that comes from driver class.
//call the static getDriver() method through the classNAme
//By doing this; we will know that we are always calling the same driver

 */
/*
Configuration Properties file => store credentials connection url's info about servers
POM => store locators
keep elements inside class not in properties
you have to always keep check what is the keyname to use that locator, not convenient
 */
public abstract class AbstractTestBase {
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }


    @AfterMethod
    public void teardown() {
        Driver.closeDriver();
    }
    }