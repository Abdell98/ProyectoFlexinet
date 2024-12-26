package com.eulen.flexinet.core.test.selenium.steps.util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.pages.PageObject;

public class Hooks extends PageObject {

    private static WebDriver driver;
    
    private static Environments env = Environments.PRE; //TODO: aqui cambiamos el entorno de momento, esto hay que pasarlo a hacerlo desde serenity.conf

    @Before
    public void setUp(){

        driver = getDriver();
        switch (env) {
            case PRE:
                driver.get("https://preflexinet.eulen.com/flexinet");
                //driver.get("https://preflexinet.eulen.com/flexinet");
                break;
            case UAT:
                driver.get("https://uatflexinet.eulen.com/");
                break;
            case INT:
                driver.get("https://intflexinet.eulen.com/");
                break;
        }
        driver.manage().window().maximize();
        System.out.println("test");
    }

    public static WebDriver getSerenityDriver(){
        return driver;
    }


    public static Environments getEnv() {
        return env;
    }

}
