package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.PedidosQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PartesDeHorasServiceDataBaseProcedure extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PartesDeHorasServiceDataBaseProcedure(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public String getNumeroDeParte(String idContrato) {
        return String.format(
                "SELECT p.ID_PARTE FROM PARTE p WHERE p.ID_CON = %s", idContrato
        );
    }




}
