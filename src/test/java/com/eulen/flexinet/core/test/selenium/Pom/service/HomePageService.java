package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageService extends BasePage {
    private HomePageLocators homePageLocators;
    public HomePageService(WebDriver driver) {
        super(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    public boolean homepageOfficeIconIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(homePageLocators.getHomePageOfficeIcon());
    }
    public boolean homepageInboxIconIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(homePageLocators.getHomePageInboxIcon());
    }

    public boolean homepagePrintIconIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(homePageLocators.getHomePagePrintIcon());
    }

    public boolean homepageSignOutIconIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(homePageLocators.getHomePageSignOutIcon());
    }

    public boolean homepageFlexinetLogoIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(homePageLocators.getHomePageFlexinetLogo());
    }

    public boolean homePageFlexiplanLogoIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(homePageLocators.getHomePageFlexiplanLogo());
    }


}
