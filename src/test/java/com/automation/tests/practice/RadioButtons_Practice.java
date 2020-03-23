package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons_Practice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> buttons=driver.findElements(By.cssSelector("input[type='radio']"));
        for(WebElement each: buttons){
          //  if(each.isEnabled()){
            each.click();
            BrowserUtils.wait(2);
            System.out.println( each.getAttribute("id"));
       // }else{
         //       driver.close();
          //  }bu kod ile de blackten sonrasini tiklamam, hemen birakirim
        }


        BrowserUtils.wait(3);
        driver.close();
    }
}
