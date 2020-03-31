package com.officeHours.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;
/**
 * CHEAP SPOONS
 * 1.go to https://amazon.com
 * 2.search for "wooden spoon"
 * 3.click on Price option Under $25 on the left
 * 4.verify that all results are cheaper than $25
 */

public class March30_HW_CheapSpoon {

    private WebDriver driver = Driver.getDriver();
    @Test
    public void test() {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        driver.findElement(By.linkText("Under $25")).click();
        //we collect only dollar values from the price of every item
        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
        //we convert collection of web elements into collection of strings
        List<String> pricesText = BrowserUtils.getTextFromWebElements(prices);
        System.out.println(pricesText);
        for (String price : pricesText) {
            //we convert every price as a string into integer
            int priceConverted = Integer.parseInt(price);
            //checking if the price of every item is under 25
            Assert.assertTrue(priceConverted < 25);
        }
    }

    @Test
    public void department_sort() {
        driver.get("https://www.amazon.com");
        Assert.assertEquals(driver.findElement(By.className("nav-search-label")).getText(), "All");
        List<WebElement> l1 = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        boolean notAlphOrder = false;
        for (int i = 0; i < l1.size() - 1; i++) {
            if (l1.get(i).getText().compareTo(l1.get(i + 1).getText()) > 0) {
                notAlphOrder = true;
                break;
            }
        }
        Assert.assertTrue(notAlphOrder);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}