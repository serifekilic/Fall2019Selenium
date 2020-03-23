package com.automation.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindingElements_By_Id {
    public static void main(String[] args)throws Exception {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://google.com");
        WebElement btn1=driver.findElement(By.id("gbqfbb"));
        String actualText=btn1.getAttribute("value");
        String expectedText="I'm Feeling Lucky";
        if(actualText.equals(expectedText)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected Text: "+expectedText);
            System.out.println("Actual Text: "+actualText);
        }
        Thread.sleep(3000);
        driver.close();
    }
}
