package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class RiesgosServiceDatePicker extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public RiesgosServiceDatePicker(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void pickDateFechaInicio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.FECHAINICIO,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getFechaInicio(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaFin(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.FIN,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getFechaFin(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
