package com.automation.tests.day12;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
//DOM => treats html document as a tree. every element is node like h1, div..
Implicit means not stated directly but implied or hinted at.
Explicit means stated directly. In other words, something explicit
is very clear and exact about the meaning.
 */

public class ImplicitWait {


    private WebDriver driver;
        @BeforeMethod
    public void setup(){
            driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();

            WebElement finishElement=driver.findElement(By.id("finish"));
            System.out.println(finishElement.getText());
        }

        @AfterMethod
    public void teardown(){
            if(driver!=null){
                driver.quit();
                driver=null;
            }
        }
}
