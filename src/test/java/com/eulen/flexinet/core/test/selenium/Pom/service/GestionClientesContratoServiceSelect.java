package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionClientesContratoServiceSelect extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    public GestionClientesContratoServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void selectEjecutivoDeCuenta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.EJECUTIVODECUENTA,
                FieldType.select,
                cajaNumero,
                gestionClientesContratoData.getEjecutivoDeCuenta(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectMedioDeCapt(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.MEDIODECAPT,
                FieldType.select,
                cajaNumero,
                gestionClientesContratoData.getMedioDeCapt(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    //TODO: corregir Clausurado a Clausulado
    public void selectClausuradoDelContratoLaboral(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULADODELCONTRATOLABORAL,
                FieldType.select,
                cajaNumero,
                gestionClientesContratoData.getClausuladoDelContratoLaboral(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    //TODO: corregir Clausurado a Clausulado
    public void selectClausuradoDelCPD(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULADODELCPD,
                FieldType.select,
                cajaNumero,
                gestionClientesContratoData.getClausuladoDelCPD(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
//TODO @REFACTOR @FIX @PRE
//    public void selectEntidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        commonService.selectField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.ENTIDAD,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getEntidad(), //TODO: cambiar a cliente contrato o bien renombrar clase empresa a shared
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void selectSucursal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        commonService.selectField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.SUCURSAL,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getSucursal(), //TODO: cambiar a cliente contrato o bien renombrar clase empresa a shared
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void selectVentas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        commonService.selectField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.VENTAS,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getVentas(),
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void selectNEmpleados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        commonService.selectField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.NEMPLEADOS,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getNEmpleados(),
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }

}
