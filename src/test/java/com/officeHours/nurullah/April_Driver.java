package com.officeHours.nurullah;

import com.automation.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//if the driver does  not exist and you try toclose it then you will get an error "Session does not exist"
public class April_Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browser= ConfigurationReader.getProperty("browser");
        if (driver == null) {
            browser = browser.toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    return new ChromeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                case "chrome_headless":
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
                    return new ChromeDriver(chromeOptions);
                //set capabilities----DesiredCapabilities-->extentions, proxy, platname
                case "firefox_headless":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions().setHeadless(true);
                    return new FirefoxDriver(firefoxOptions);
            }
        }
            return driver;
        }

}
