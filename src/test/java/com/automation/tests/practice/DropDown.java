package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select selectOption=new Select(driver.findElement(By.id("dropdown")));
        selectOption.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        selectOption.selectByVisibleText("Option 1");
        BrowserUtils.wait(1);

        Select selectYear=new Select(driver.findElement(By.id("year")));
        List<WebElement>years=selectYear.getOptions();

        selectYear.selectByVisibleText("2012");
        BrowserUtils.wait(2);
        Select selectMonth=new Select(driver.findElement(By.id("month")));
        List<WebElement> months=selectMonth.getOptions();
        for(WebElement each:months){
            System.out.println(each.getAttribute("value"));
            System.out.println(each.getText());
        }
        selectMonth.selectByVisibleText("June");
        BrowserUtils.wait(2);
        Select selectDay=new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("12");
        BrowserUtils.wait(2);

        Select selectState=new Select(driver.findElement(By.id("state")));
        List<WebElement>states=selectState.getOptions();
        for(WebElement each:states){
            System.out.println(each.getText());
        }
        selectState.selectByVisibleText("North Carolina");
        BrowserUtils.wait(2);

        Select selectLanguage=new Select(driver.findElement(By.name("Languages")));
        List<WebElement>languages=selectLanguage.getOptions();
        for(WebElement each:languages){
            BrowserUtils.wait(3);
         //   selectLanguage.selectByVisibleText(each.getText());
            System.out.println(each.getAttribute("value"));
        }
        BrowserUtils.wait(2);
        selectLanguage.selectByVisibleText("Java");
        selectLanguage.selectByVisibleText("Python");
        selectLanguage.selectByVisibleText("JavaScript");
        BrowserUtils.wait(3);

        Select selectWebsite=new Select(driver.findElement(By.className("dropdown show")));
        BrowserUtils.wait(3);
        selectWebsite.selectByVisibleText("Amazon");

        BrowserUtils.wait(2);
        driver.close();
    }
}
