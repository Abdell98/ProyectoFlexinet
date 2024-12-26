package com.eulen.flexinet.core.test.selenium.Locators;

import com.eulen.flexinet.core.test.selenium.Pom.pom.PageObjectBase;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPageLocators extends PageObjectBase {

    @FindBy(xpath = "//input[@value='Conectar']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputUser;

    @FindBy(xpath = "//input[@id='pwd']")
    private WebElement inputPassword;

    public LoginPageLocators(WebDriver driver) {
        super(driver);
    }
}
