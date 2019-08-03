package com.hiver.pageObjects;

import com.hiver.util.BaseUtil;
import org.openqa.selenium.By;

import java.io.IOException;

public class InboxPage extends BaseUtil {
    public boolean isComposeBtnPresent() throws IOException {
        explicitWait(driver, objectLocator("ComposeBtn"));
        return driver.findElement(By.xpath(objectLocator("ComposeBtn"))).isDisplayed();
    }
    public void clickEmail(String number) throws IOException {
        explicitWait(driver, objectLocator("EmailList").replace("{number}",number));
        driver.findElement(By.xpath(objectLocator("EmailList").replace("{number}",number))).click();
    }
    public String subjectTitle() throws IOException {
        explicitWait(driver, objectLocator("SubjectTitle"));
        return driver.findElement(By.xpath(objectLocator("SubjectTitle"))).getText();
    }

    public String bodyText() throws IOException {
        explicitWait(driver, objectLocator("BodyText"));
        return driver.findElement(By.xpath(objectLocator("BodyText"))).getText();
    }
}
