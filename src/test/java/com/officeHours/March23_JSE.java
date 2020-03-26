package com.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class March23_JSE {

//    private WebDriver driver;
//    private JavascriptExecutor js;
//    @BeforeMethod
//    public void setup(){
//        WebDriver driver= DriverFactory.createDriver("chrome");
//        driver.get("https://www.etsy.com");
//         js=(JavascriptExecutor)driver;
//    }
@Test(description = "get the page title (return a value)")
public void testcase3(){
    WebDriver driver = DriverFactory.createDriver("chrome");
    //Navigating to etsy homepage
    driver.get("https://www.etsy.com/");
    JavascriptExecutor js = (JavascriptExecutor)driver;
    //return keyword before the script is for Selenium to know that it needs to bring back information
    String pageTitle = js.executeScript("return document.title").toString();
    System.out.println(pageTitle);
}
    @Test(description = "Send text to search box on etsy")
    public void test1(){
        //Driver instance created
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
    }
}
