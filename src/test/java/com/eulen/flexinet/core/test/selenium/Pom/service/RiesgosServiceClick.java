package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RiesgosServiceClick extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public RiesgosServiceClick(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    //TODO deprecar por clickBtn
    public void clickBtnDesbloquear(String scn, SystemPages page, PanelTitle dialogTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton(
                null,
                null,
                "Desbloquear",
                1
        );
        commonService.click(button);
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

}
