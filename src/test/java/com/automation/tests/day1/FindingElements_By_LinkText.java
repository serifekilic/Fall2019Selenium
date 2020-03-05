package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindingElements_By_LinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        //in order to get all links available on the page
        List<WebElement> listOfElements=driver.findElements(By.tagName("a"));
        System.out.println("Amount of Links: "+listOfElements.size());
        WebElement link=driver.findElement(By.linkText("Broken Images"));
        link.click();
      //  Thread.sleep(2000);
      //  driver.close();
        //partiallyText kullanimini gosterelim. yukaridaki ornege ekleme yapacagim.
        driver.navigate().back();
        WebElement link2=driver.findElement(By.partialLinkText("Drag"));
        link2.click();
        Thread.sleep(3000);
        driver.close();


    }
}
