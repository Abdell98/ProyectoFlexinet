package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.LoginPageLocators;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageService extends BasePage {

    private LoginPageLocators loginPageLocators;

    private HomePageLocators homePageLocators;

    public LoginPageService(WebDriver driver) {
        super(driver);
        loginPageLocators = new LoginPageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    public boolean loginButtonIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(loginPageLocators.getLoginButton());
    }

    public boolean loginPageFlexinetLogoIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(homePageLocators.getHomePageFlexinetLogo());
    }

    public boolean loginPageFlexiplanLogoIsDisplayed() throws Exception {
        return waitUntilIsDisplayed(homePageLocators.getHomePageFlexiplanLogo());
    }


    public void typeUser() throws Exception {
        this.jsonFile("datosLogin.json");
        if (loginData != null) {
            String user = loginData.getUser();
            sendKeys(loginPageLocators.getInputUser(), user);
        } else {
            System.out.println("Error al cargar datos JSON");
        }
    }

    public void typePassword() throws Exception {
        this.jsonFile("datosLogin.json");
        if (loginData != null) {
            String password = loginData.getPassword();
            sendKeys(loginPageLocators.getInputPassword(), password);
        } else {
            System.out.println("Error al cargar datos JSON");
        }
    }

    public void clickLoginButton() throws Exception {
        click(loginPageLocators.getLoginButton());
    }
}
