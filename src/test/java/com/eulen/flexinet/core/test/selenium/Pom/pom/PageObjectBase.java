package com.eulen.flexinet.core.test.selenium.Pom.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectBase {

    protected WebDriver driver;

    public PageObjectBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
