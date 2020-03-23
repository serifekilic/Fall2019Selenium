package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes_Practice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
       List<WebElement> checkboxes=driver.findElements(By.xpath("//form[@id='checkboxes']"));
        checkboxes.forEach(each-> System.out.println(each.getText()));
        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
        BrowserUtils.wait(3);
        for (WebElement eachBox:checkboxes){
            if(!eachBox.isSelected()){
                eachBox.click();
            }
        }

        BrowserUtils.wait(2);
        driver.close();
    }
}
