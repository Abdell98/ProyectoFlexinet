package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionITsServiceType extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionITsServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void typeNombre(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        datos = datosGestionITs.getGestionITs().getNombre();

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePrimerApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        datos = datosGestionITs.getGestionITs().getPrimerApellido();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.PRIMERAPELLIDO,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeSegundoApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        datos = datosGestionITs.getGestionITs().getSegundoApellido();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEGUNDOAPELLIDO,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        datos = datosGestionITs.getGestionITs().getNif();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NIF,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNombreYApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionITs.getGestionITs().getDialogoSeleccionDeColaboradores().getTable().getTable_nombreYApellidos();

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NOMBREYAPELLIDOS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionITs.getGestionITs().getDialogoSeleccionDeColaboradores().getTable().getQbe_direccion();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_DIRECCION,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNParte(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionITs.getGestionITs().getDialogoAniadirIT().getMesFiltro();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_MES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
}
