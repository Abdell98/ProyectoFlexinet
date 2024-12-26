package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Pom.service.LoginPageService;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageTask extends BasePage {

    private LoginPageService service;

    public LoginPageTask(WebDriver driver) {
        super(driver);
        service = new LoginPageService(driver);
    }

    public void typeText() throws Exception {
        service.typeUser();
        service.typePassword();
    }

    public void clickLoginButton() throws Exception {
        service.clickLoginButton();
    }

    public void login() throws Exception {
        service.typeUser();
        service.typePassword();
        service.clickLoginButton();
    }

}
