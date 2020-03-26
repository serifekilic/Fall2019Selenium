package com.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class March25 {

    /*
    IFrame --> webdocument inside of other webdocument (html inside of html doc)
     */
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();

    }
    @Test
    public void test(){
        //iframe icinde 3 tane ayri frame vardi onlarin icindeki texte ulasabilmek icin
        //list olusturduk ve loop icine koyduk. ve loop su an ucunun de texttine ulasabilir

        driver.get("http://practice.cybertekschool.com/nested_frames");
       driver.switchTo().frame("frame-top");
        List<WebElement> frameList=driver.findElements(By.xpath("//frame"));
    /*
    we have stored all frames webelements inside the list
    1. Loop through list
    2. Switch to each frame
        a.get test from body
        b.switch to parent
     */

    for(WebElement each: frameList){
        driver.switchTo().frame(each);
        String bodyText=driver.findElement(By.tagName("body")).getText();
        System.out.println("Body text: "+bodyText);
        driver.switchTo().parentFrame();// ucunu icine alan giant frame. bu frameden iki tane var.
        //bunlari icine alan bir de default frame var
    }
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
    }
    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
