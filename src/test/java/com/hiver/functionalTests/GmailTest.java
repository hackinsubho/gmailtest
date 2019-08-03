package com.hiver.functionalTests;

import com.hiver.pageObjects.InboxPage;
import com.hiver.pageObjects.LoginPage;
import com.hiver.util.BaseUtil;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailTest extends BaseUtil {

    @Test
    public void logIntoGmailApp() throws Exception{
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        InboxPage inboxPage = PageFactory.initElements(driver, InboxPage.class);
        loginPage.isSignInPageLoaded();
        loginPage.enterEmail("emailid");
        loginPage.clickNextBtn();
        Thread.sleep(5000);
        loginPage.enterPassword("password");
        loginPage.clickNextBtn();
        Assert.assertTrue(inboxPage.isComposeBtnPresent(),"Gmail Page is not loaded");
        inboxPage.clickEmail("2");
        Thread.sleep(10000);
        System.out.println(inboxPage.subjectTitle());
        System.out.println(inboxPage.bodyText());

    }
}
