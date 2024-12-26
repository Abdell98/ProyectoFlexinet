package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class RiesgosServiceSelect extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public RiesgosServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void selectProvinciaOficina(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.PROVINCIAOFICINA,
                FieldType.select,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getProvinciaOficina(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectOficina(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.OFICINA,
                FieldType.select,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getOficina(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
}
