package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown_By_Select {
    static WebDriver driver= DriverFactory.createDriver("chrome");
    public static void main(String[] args) {
        //
        //bu testleri calistiramadim
        //
        // /
        selectByTextTest();
      //  selectByValueTest();
          //  multipleSelectDropDownTest();
          //  nonSelectDropDownTest();
//       WebDriverManager.chromedriver().version("79").setup();
//       WebDriver driver=new ChromeDriver();
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("http://practice.cybertekschool.com/dropdown");
//       BrowserUtils.wait(2);
//       Select select=new Select(driver.findElement(By.id("state")));
//       select.selectByValue("North Carolina");
//       String expected="North Carolina";
//       String actual=select.getFirstSelectedOption().getText();
//       BrowserUtils.wait(2);
//       driver.close();

    }

    public static void setup(){

        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    public static void selectByTextTest(){
        setup();
        BrowserUtils.wait(3);
        Select select=new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        BrowserUtils.wait(3);
        driver.close();
    }
    public static void selectByValueTest(){
      //  setup();
        WebDriverManager.chromedriver().version("79").setup();
         WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");


        BrowserUtils.wait(3);
        Select select=new Select(driver.findElement(By.id("state")));
        select.selectByValue("DC");
        BrowserUtils.wait(2);
        String expected="District Of Columbia";
        String actual=select.getFirstSelectedOption().getText();
        BrowserUtils.wait(1);
        System.out.println("Expected: "+expected);
        System.out.println("Actual: "+actual);

        BrowserUtils.wait(3);
        driver.close();
    }
    public static void multipleSelectDropDownTest(){
        setup();
        BrowserUtils.wait(3);
        Select select=new Select(driver.findElement(By.name("Languages")));

        List<WebElement> options=select.getOptions();
        for(WebElement option:options){
            BrowserUtils.wait(3);
            System.out.println(option.getAttribute("value"));
            select.selectByVisibleText(option.getText());
        }
        BrowserUtils.wait(3);
        List<WebElement>selectedOptions=select.getAllSelectedOptions();
        for(WebElement option:selectedOptions){
            System.out.println(option.getText());
        }
        select.deselectAll();
        BrowserUtils.wait(2);
        driver.close();
    }
    public static void nonSelectDropDownTest(){
        setup();
        BrowserUtils.wait(3);
        WebElement dropdown=driver.findElement(By.id(" dropdownMenuLink"));
        WebElement links=driver.findElement(By.xpath("//a[.='Amazon']"));
        BrowserUtils.wait(2);

       dropdown.click();
        BrowserUtils.wait(1);
        links.click();

        driver.close();
    }
}
