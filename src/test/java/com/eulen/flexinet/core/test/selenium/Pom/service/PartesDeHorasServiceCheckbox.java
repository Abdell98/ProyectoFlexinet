package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PartesDeHorasServiceCheckbox extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PartesDeHorasServiceCheckbox(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void checkDiario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getChk_diario();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getChk_diario();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_DIARIO,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkParcial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getChk_parcial();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getChk_parcial();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PARCIAL,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkEspeciales(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getChk_especiales();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getChk_especiales();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_ESPECIALES,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkValidado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getChk_validado();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getChk_validado();
                break;
        }

        //WebElement checkboxValidado = pageLocators.getCheckbox(FieldByTagLabelText.CHK_VALIDADO);
        //verticalScrollTo(checkboxValidado);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(pageLocators.getCheckbox(FieldByTagLabelText.CHK_VALIDADO)));


        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_VALIDADO,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkDiferencia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getChk_diferencia();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getChk_diferencia();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_DIFERENCIA,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkParteSinTraspasar(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasTraspaso().
                        getChk_partesSinTraspasar();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PARTESINTRASPASAR,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkANivelNacional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasConsulta().
                getChk_aNivelNacional();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasTraspaso().
                getChk_aNivelNacional();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_ANIVELNACIONAL,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPartesEnviadosAOracle(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                datosAux = datosPartesDeHoras.getEnvioPartesAOracle().getChk_partesEnviadosAOracle();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PARTESENVIADOSAORACLE,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
