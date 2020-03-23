package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class FindingElements_By_Xpath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");

        driver.findElement(By.xpath("//span[@class='h1y']"));
//        List<WebElement>lists=driver.findElements(By.tagName("a"));
//        BrowserUtils.wait(2);
//        lists.forEach(each-> System.out.println(each.getText()));
//
//        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Autocomplete")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("myCountry")).sendKeys("Turkey");
       driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
       BrowserUtils.wait(3);
      String resultId=  driver.findElement(By.xpath("//p[@id='result']")).getText();


       String expected="You selected: Turkey";
       System.out.println((resultId.equals(expected))?"Test passed":"Test Failed" );
       System.out.println("expected: "+expected);
        System.out.println("actual: "+resultId);
     BrowserUtils.wait(3);
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Context Menu']")).click();
          BrowserUtils.wait(2);
          driver.findElement(By.xpath("//a[.='Home']")).click();
          driver.findElement(By.xpath("//a[@href='/drag_and_drop']")).click();
          driver.findElement(By.xpath("//a[@class='nav-link']")).click();
          BrowserUtils.wait(1);
          driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//label[.='Gender']")).findElement(By.xpath("//input[@value='female']")).click();
       BrowserUtils.wait(2);



//
//          driver.findElement(By.linkText("Multiple Buttons")).click();
//            BrowserUtils.wait(2);
//
//       WebElement button2= driver.findElement(By.name("button2"));
//       button2.click();
//       BrowserUtils.wait(2);
//        String actual2 =  driver.findElement(By.id("result")).getText();
//       String expected2="Clicked on button two!";
//        System.out.println(expected2.equals(actual2)?"Passed":"Failed");




        BrowserUtils.wait(2);
        driver.close();
    }
}
