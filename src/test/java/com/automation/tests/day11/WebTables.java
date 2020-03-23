package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/*
//BrowserUtils.getTextFromWebElements(columnNames) ==>
// this method takes the text of every single webElement and puts it into collection of strings
 */
public class WebTables {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        //to run browser without GUI(interface)
        //makes browser invisible
        //it is very common in companies
        //biz sayfaya gidildigini gormeyiz. digerine gore daha hizlidir.


        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
        //headless mode makes execution twice faster
        //it does everthing except file uploading

        // driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }

    @Test
    public void tableElements() {
        //th -->represent table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        //bunlar String ama kiyaslayacagimiz webElement , method yazip bunlari kiyaslamaya calisacagiz

        //just to print
        List<WebElement> list = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement each : list) {
            System.out.println(each.getText());
        }
        //expected row size is 4
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(list), expected);
        //browserUtils deki method ile webelemnti string e cevirdik ve expected ve actual arasinda
        //kiyas yaptik
    }

    /*
    //first way :
    //once you find email cell in the first table that has this email (jdoe@hotmail.com)
    then go to following sibling has linkText delete :
    //td element with email and td element that contains delete => are siblings
    ////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
    //to make it easier :
    //go back to parent and find link that has text delete
    //td is child of tr
    ////td[text()='fbach@yahoo.com']/..//a[text()='delete']
    //even more simple way :
    //it is more hardcoded! but easiest => you provide index so it s not flexible,
    if index is changed, ilocator will never find it
    //go to find email in the first table go to parent go to second link inside this element
    ////table[1]//td[text()='jsmith@gmail.com']/..//a[2]
     */
    @Test
    public void verifyRowCount() {
        //tbody//tr-->to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of  this collection, it automatically equals to number  of elements
        //expected --> 4 rows in the table
        Assert.assertEquals(rows.size(), 4);


//        for (WebElement each : rows) {
//            System.out.println(each.getText());
//        }
        //butun elementleri yukaridaki loop ile gorebiliriz
    }


    /*
    to get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn() {

        //td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    /**
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */
    @Test
    public void deleteRowTest() {

        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();

        BrowserUtils.wait(3);

        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount, 3);

        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));

        Assert.assertTrue(emails.isEmpty());
//isEmpty kullandik cunku email row unu delete yaptigimiz icin onu kullanip assert yapamayiz. noSuchElement exception verir
    }

    //lets write a function that will return column index based on column name
    @Test
    public void getColumnIndexByName() {

        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName = columnNames.get(i).getText();
            //to display results in the console
            System.out.println(String.format("Column name:%s, position %s,", actualColumnName, i));

            // if(columnNames.get(i).getText().equals(columnName)){
            if (actualColumnName.equals(columnName)) {
                index = i + 1; //seleniumda index 1 den baslar. o yuzden +1 koyduk
                break;//istenileni buldun mu cik
            }
        }

        Assert.assertEquals(index, 3);
    }

    @Test
    public void getSpecificCell() {
        //dynamic xpath,
        //asagidaki email i ariyoruz
        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";

        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(), expected);
    }

    @Test
    public void alphabeticOrder() {
        List<WebElement> names = driver.findElements(By.xpath("lastNames"));
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getText();
            String followingName = names.get(i+1).getText();
            Assert.assertTrue(name.compareTo(followingName) < 0);
        }

    }

    @AfterMethod
    public void teardown() {

        BrowserUtils.wait(3);
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
