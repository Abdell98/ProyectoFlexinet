package com.eulen.flexinet.core.test.selenium.Locators;

import org.openqa.selenium.By;

public class LocatorCondition {
    private By locator;
    private Boolean condition1;
    private Boolean condition2;

    public LocatorCondition(By locator, Boolean condition1, Boolean condition2) {
        this.locator = locator;
        this.condition1 = condition1;
        this.condition2 = condition2;
    }

    //Getters
    public By getLocator() {
        return locator;
    }

    public Boolean getCondition1() {
        return condition1;
    }

    public Boolean getCondition2() {
        return condition2;
    }

}
