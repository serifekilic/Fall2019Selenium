package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {
//document.getElementsByName('username')[0].setAttribute('value','tomsmith')-
  //  document.getElementsByName('password')[0].setAttribute('value','SuperSecretPassword')
    //javascript ile yapilan
        private WebDriver driver;

        @BeforeMethod
    public void setup(){
            driver= DriverFactory.createDriver("chrome");
            driver.get("http://practice.cybertekschool.com/");
            driver.manage().window().maximize();
        }
@Test
public void verifyTitle(){
            String expected="Practice";
            //we create jscriptexecuter object by casting webdriver object
    JavascriptExecutor js=(JavascriptExecutor)driver;
    //executeScript-- this method executes javascript code
    //we provide js code as aString
   // return document.title---javascript code
    //document---represents HtMl page
  //  String actual=(String)js.executeScript("return document.title");
    //asagida toString cagirdik. ayni seyi toString ile basardik. upperCasting yapmadik
    //.toString()---to avaid additional casting from Object to string
    String actual=js.executeScript("return document.title").toString();
    Assert.assertEquals(actual,expected);
}

    @Test
    public void clickTest() {
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
//        disable this click action ,to perform it with js executor
//        link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //after "" you can list webelements that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //arguments - listed after ,
        //use index to get specific webelement
        // WebElement arguments = {element, link, link2};
        //from left - to right
        js.executeScript("arguments[0].click()", link);

        WebElement button6=driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()",button6);
        BrowserUtils.wait(2);
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"Now it's gone!");


    }

    @Test
    public void textinputText(){

            driver.findElement(By.linkText("Form Authentication")).click();
            BrowserUtils.wait(3);
            WebElement username=driver.findElement(By.name("username"));
            WebElement password=driver.findElement(By.name("password"));
            WebElement loginbtn=driver.findElement(By.id("wooden_spoon"));
         //   WebElement country=driver.findElement(By.id("myCountry"));


            JavascriptExecutor js=(JavascriptExecutor)driver;
            //to get text from input box-- read attribute "value"
        //to enter text-- set attribute "value"

        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')",password);
        js.executeScript("arguments[0].click()",loginbtn);
      //  js.executeScript("arguments[0].setAttribute('value','Turkey')",country);
//        WebElement warning=driver.findElement(By.id("flash"));
//        String actual=warning.getText();
//        String expected="You logged into a secure area!";
//        Assert.assertEquals(actual,expected);

        BrowserUtils.wait(3);
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();
     //   String subheader =(String) js.executeScript("return document.getElementsByClassName('subheader')[0].textContent");
        //toString()--> kullanmazsak yukaridaki gibi downcasting yapmamiz laZim
        Assert.assertEquals(subheader,expected);

    }

    @Test
    public void scrollToElement(){
            BrowserUtils.wait(5);
            //href=link, URL
            WebElement link=driver.findElement(By.linkText("Cybertek School"));
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true)",link);
    }

    @Test
    public void scrollTest() {
        //navigate to ---> just like  get message

        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //  js.executeScript("window.scrollBy(0,1000"); //or we can put into loop
        //it is going to scrolldown 1000 pixel
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,1000)");
            BrowserUtils.wait(1);
        }
    }


        @AfterMethod
    public void teardown(){

            BrowserUtils.wait(3);
            if(driver!=null){
                driver.quit();
                driver=null;
            }
        }

}
