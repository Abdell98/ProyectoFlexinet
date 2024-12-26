package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class PartesDeHorasServiceSelect extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PartesDeHorasServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void selectMes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getMes();
                break;
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getMes();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getMes();
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                datosAux = datosPartesDeHoras.getEnvioPartesAOracle().getMes();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_MES,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosIT().
                getSectionNomina().
                getConcepto();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_CONCEPTO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectTipo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getDialogAltaConceptoColaboradorNomina().
                getTipo();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getTipo();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.TIPO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
