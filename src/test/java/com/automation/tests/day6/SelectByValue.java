package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.sql.rowset.BaseRowSet;

public class SelectByValue {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");

        String expected="District of Columbia";
        String actual=stateSelect.getFirstSelectedOption().getText();

        if(expected.equals(actual)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

       BrowserUtils.wait(2);
        driver.quit();

    }
}
