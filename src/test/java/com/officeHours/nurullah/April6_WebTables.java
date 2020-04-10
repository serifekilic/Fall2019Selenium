package com.officeHours.nurullah;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class April6_WebTables {

   /*
  Preconditions:
     1. We navigate to the practice website
     2. Click on the Sortable Table Link
     Tests Cases:
      Verify that row 2, column 4 is $51.00
      Verify the number of rows is 4 in the table1 body
      Verify the number of columns is 6 in table1
 */

   @BeforeMethod
    public void setup(){
       Driver.getDriver().get("http://practice-cybertekschool.herokuapp.com/");

       Driver.getDriver().findElement(By.linkText("Sortable Data Tables")).click();

   }

   @Test
    public void testCase1(){
       WebElement data=Driver.getDriver().findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[4]/td[4]"));
       String actual=data.getText();
       String expected="$50.00";
       Assert.assertEquals(actual,expected);
   }

   @Test(description = "Verify the number of rows is 4 in the table1 body")
   public void testCase2(){
       List<WebElement> rowsOfTable1=Driver.getDriver().findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr"));
        int actualRows=rowsOfTable1.size();
        Assert.assertEquals(actualRows,4,"Number of rows does not match");


   }
   @Test(description = "Verify the number of columns is 6 in table1")
   public void testCase3(){
       List<WebElement> rowsOfTable1=Driver.getDriver().findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td"));
       int actualRows=rowsOfTable1.size();
       Assert.assertEquals(actualRows,6,"Number of rows does not match");

   }

@AfterMethod
    public void teardown(){
       Driver.getDriver().quit();
}
}
