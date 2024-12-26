package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionClientesContratoServiceType extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    public GestionClientesContratoServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void typeRazonSocial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAZONSOCIAL,
                FieldType.input,
                cajaNumero,
                gestionClientesContratoData.getRazonSocial(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeObservaciones(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.OBSERVACIONES,
                FieldType.textarea,
                cajaNumero,
                gestionClientesContratoData.getObservaciones(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );

    }
//TODO @REFACTOR @FIX @PRE
//    public void typeDC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.typeInputField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.DC,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getDC(), //TODO: cambiar a cliente contrato o bien renombrar clase empresa a shared
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//
//    }
//TODO @REFACTOR @FIX @PRE
//    public void typeNCuenta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.typeInputField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.NCUENTA,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getNCuenta(), //TODO: cambiar a cliente contrato o bien renombrar clase empresa a shared
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//
//    }
//TODO @REFACTOR @FIX @PRE
//    public void typeIBANPais(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.typeInputField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.IBANPAIS,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getIBANPais(), //TODO: cambiar a cliente contrato o bien renombrar clase empresa a shared
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//
//    }
//TODO @REFACTOR @FIX @PRE
//    public void typeIBANdc(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.typeInputField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.IBANDC,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getIBANDC(), //TODO: cambiar a cliente contrato o bien renombrar clase empresa a shared
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//
//    }
//TODO @REFACTOR @FIX @PRE
//    public void typeIBANextranjero(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.typeInputField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.IBANEXTRANJERO,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getIBANExtranjero(), //TODO: cambiar a cliente contrato o bien renombrar clase empresa a shared
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//
//    }



}
