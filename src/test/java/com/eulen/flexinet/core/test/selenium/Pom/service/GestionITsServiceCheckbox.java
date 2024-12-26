package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GestionITsServiceCheckbox extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionITsServiceCheckbox(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void checkGenerados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        datos = datosGeneracionMasivaPartes.getGeneradorAutomaticoPartesHoras().getChk_mostrarGenerados();
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_MOSTRAR_GENERADOS,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


    public void checkBusquedaANivelNacional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        datos = datosGeneracionMasivaPartes.getGeneradorAutomaticoPartesHoras().getChk_mostrarGenerados();

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_ANIVELNACIONAL,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void isTrapasadoChecked(String file) throws Exception {
        jsonFileNew(file);
        String datos = datosGestionITs.getGestionITs().getTraspasado();
        commonService.isCheckboxFieldChecked(5, 2, datos);
    }

}
