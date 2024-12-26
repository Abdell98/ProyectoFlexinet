package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class ContratosServiceSelect extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private ContratosServiceClick contratosServiceClick;
    private ContratosServiceType contratosServiceType;
    private CommonServiceClick commonServiceClick;

    public ContratosServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        contratosServiceType = new ContratosServiceType(driver);
        contratosServiceClick = new ContratosServiceClick(driver);
    }

    public void selectMotivoBaja(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.selectField( scn, panelTitle, FieldByTagLabelText.MOTIVOBAJA, FieldType.select, cajaNumero, datosContrato.getContratosBajaDarDeBaja().getDialogDarDeBaja().getMotivoDeLaBaja(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void selectTipoNovacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        commonService.selectField( scn, panelTitle, FieldByTagLabelText.TIPONOVACION, FieldType.select, cajaNumero, datosContrato.getContratosNovacionAlta().getDialogAltaNovacion().getTipoNovacion(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void selectSexo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEXO,
                FieldType.select,
                cajaNumero,
                datosContrato.getContratoAltaSustitucion().getDialogPerfilDatoUnico().getSexo(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectSexoColaborador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEXO,
                FieldType.select,
                cajaNumero,
                datosContrato.getContratoAltaSustitucion().getSexo(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void selectFiltrarPorEstado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.FILTRAR_ESTADO,
                FieldType.select,
                cajaNumero,
                datosContrato.getContratosControlEnviosCpds().getFiltrarEstado(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
}
