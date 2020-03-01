package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);
//every window has some id, this id calls window handle
        //based on window handle, we can switch in between windows
        String windowHandle=driver.getWindowHandle();

        System.out.println(windowHandle);
        //getWindowHandles()-->return id'sof all currently opened windows
        //CDwindow-0E71299875E98F1C63D4AD30086FC30F this is id of open window

        Set<String> windowHandles=driver.getWindowHandles();

        System.out.println(windowHandles);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        for(String windowId:windowHandles){
            if(!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
       // driver.close();
        driver.quit();
    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String>windows=driver.getWindowHandles();
        for(String window:windows){
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pageTitle)){
              break;
            }
        }
    }
}
