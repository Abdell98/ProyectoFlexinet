package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class RiesgosServiceType extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public RiesgosServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void typeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datos.getRiesgosGestionPedidosBloqueados().getEmpresa();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMPRESA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeLimiteDeRiesgoDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.LIMITEDERIESGODESDE,
                FieldType.input,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getLimiteDeRiesgoDesde(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typelimiteDeRiesgoHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HASTA,
                FieldType.input,
                cajaNumero, //tiene que ser 1
                datos.getRiesgosGestionPedidosBloqueados().getLimiteDeRiesgoHasta(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNPedidoDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NPEDIDODESDE,
                FieldType.input,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getNPedidoDesde(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNPedidoHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HASTA,
                FieldType.input,
                cajaNumero, //tiene que ser 2
                datos.getRiesgosGestionPedidosBloqueados().getNPedidoHasta(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeRiesgoPedidoDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.RIESGOPEDIDODESDE,
                FieldType.input,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getRiesgoPedidoDesde(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeRiesgoPedidoHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HASTA,
                FieldType.input,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getRiesgoPedidoHasta(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeObservaciones(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.OBSERVACIONES,
                FieldType.textarea,
                cajaNumero,
                datos.getRiesgosGestionPedidosBloqueados().getDialogDesbloqueoDePedidos().getObservaciones(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }



}
