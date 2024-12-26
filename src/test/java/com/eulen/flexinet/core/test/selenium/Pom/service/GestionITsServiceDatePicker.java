package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionITsServiceDatePicker extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionITsServiceDatePicker(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void pickDateDesdeIT(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionITs
                .getGestionITs().getDialogoAniadirIT().getFechaInicioIT();
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAINICIODEIT,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateHastaIT(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionITs
                .getGestionITs().getDialogoAniadirIT().getFechaFinIT();

        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAFINIT,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


}
