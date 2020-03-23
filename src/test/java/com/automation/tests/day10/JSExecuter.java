package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecuter {
/*
// JavascriptExecutor js = (JavascriptExecutor) driver;
 // we need to cast JavascriptExecuter if our driver object reference type is WebDriver
 //Above we changed the reference type to RemoteWebDriver. Therefore, we don't have to cast.
 //RemoteWebDriver is the parent of all classes. //RemoteWebDriver implements both, JavaScriptExecuter Interface and WebDriverInterface.
 // //so when we use it as reference type we don't need to cast, as we can acsess all methods that it inherits from
 // //JavaScriptExecuter and WebDriver.
 */
    private RemoteWebDriver driver;



    @BeforeMethod
    public void setup(){
    //    driver= DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
      //  JavascriptExecutor js=(JavascriptExecutor)driver;//it is an interface
     //  driver.executeScript("window.scrollBy(0,250)") ;//loop ile deneyelim, bu calisti ama 10 kere
          //scrolldown yapmak istiyoruz

        for (int i = 0; i <10 ; i++) {
            driver.executeScript("window.scrollBy(0,250)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);
    }
    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        //scrollIntoView - javascript method
        //arguments[0] - means 1st webelement after comma
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
    }



    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
