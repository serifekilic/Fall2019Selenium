package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown_NoSelect {
    public static void main(String[] args) {


        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
      driver.findElement(By.id("dropdownMenuLink")).click();

        BrowserUtils.wait(3);
        List<WebElement> webSites=driver.findElements(By.className("dropdown-item"));
       for(WebElement each:webSites){
           System.out.println(each.getText());
           System.out.println(each.getAttribute("href"));
       }

        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Amazon")).click();
   driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Turkey");
             driver.findElement(By.xpath("//input[@type='submit']"));
             BrowserUtils.wait(3);

        BrowserUtils.wait(2);
       driver.close();

    }
}
