package com.hiver.pageObjects;

import com.hiver.util.BaseUtil;
import com.hiver.functionalTests.BaseTest;
import org.openqa.selenium.By;

import java.io.IOException;

public class LoginPage extends BaseUtil {


    public void isSignInPageLoaded() throws IOException {
        explicitWait(driver, objectLocator("SignIn"));
        driver.findElement(By.xpath(objectLocator("SignIn")));
    }
    public void clickNextBtn() throws IOException {
        explicitWait(driver, objectLocator("NextBtn"));
        driver.findElement(By.xpath(objectLocator("NextBtn"))).click();
    }
    public void enterEmail(String email) throws IOException {
        explicitWait(driver, objectLocator("InputEmailBox"));
        driver.findElement(By.xpath(objectLocator("InputEmailBox"))).sendKeys(email);
    }
    public void enterPassword(String password) throws IOException {
        explicitWait(driver, objectLocator("EnterPassword"));
        driver.findElement(By.xpath(objectLocator("EnterPassword"))).sendKeys(password);
    }

}
