package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class CommonServiceWait extends BasePage  {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;

    public CommonServiceWait(WebDriver driver){
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    public void waitLoadingSpinnerWrapper(int timesleep, int timeout) throws Exception {
        Thread.sleep(timesleep);
        //TODO: implementar timeout
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
    }

}
