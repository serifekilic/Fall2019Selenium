package com.automation.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElements_By_Name {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://wikipedia.org");
        WebElement search=driver.findElement(By.name("search"));
        search.sendKeys("corona virus", Keys.ENTER);
        Thread.sleep(2000);

        //eger yukaridaki name e click yaptigim yerde bir yazi olsaydi, onu text olarak
        //yazdirmak icin asagidaki sekilde yazabilirdim. ama burda herhangi bir text yoktu.
        //kullanamadim
     //   WebElement searchInput=driver.findElement(By.id("searchInput"));
      // System.out.println(searchInput.getText());
        driver.close();
    }
}
