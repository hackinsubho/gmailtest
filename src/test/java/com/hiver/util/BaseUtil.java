package com.hiver.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseUtil {
    public static WebDriver driver;
    public static void explicitWait(WebDriver driver, String selector) {
        if(selector.contains("xpath"))
            (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.replaceFirst("xpath;", ""))));
        else (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
    }

    public static String objectLocator(String key) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("ObjectRepo/Properties/WebObjectRepo.properties"));
        return prop.getProperty(key);
    }
    @BeforeTest
    public void init(){
        System.out.println("Opening the Browser\n");
        System.setProperty("webdriver.chrome.driver","drivers/chrome/win/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.google.com");
        driver.manage().window().maximize();
    }
    @AfterTest
    public  void tearDown(){
        System.out.println("Test Execution Complete");
        driver.close();
    }
}
