package com.automation.tests.day9;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class bos {


    private WebDriver driver;
    private String URL="https://saucelabs.com/resources/articles/selenium-tips-css-selectors";
    private Actions action;

@BeforeMethod
    public void setup(){
    driver = DriverFactory.createDriver("chrome");
    action = new Actions(driver);
}

@Test
public void actionHere(){}



@AfterMethod
    public void teardown(){
    driver.quit();
}


}
