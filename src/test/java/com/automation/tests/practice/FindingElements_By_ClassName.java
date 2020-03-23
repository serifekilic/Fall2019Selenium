package com.automation.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElements_By_ClassName {
    public static void main(String[] args) throws Throwable{

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        WebElement listOfExamples=driver.findElement(By.className("list-group"));
        System.out.println("Size: "+listOfExamples.getSize());

        Thread.sleep(3000);
        driver.close();
    }
}
