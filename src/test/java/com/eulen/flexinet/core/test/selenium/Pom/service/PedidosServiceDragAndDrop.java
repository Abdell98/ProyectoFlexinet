package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class PedidosServiceDragAndDrop extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PedidosServiceDragAndDrop(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void dragAndDropCentrosDeTrabajo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getCentrosDeTrabajo();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getCentrosDeTrabajo();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getCentrosDeTrabajo();
                break;
        }

        commonService.dragAndDropField( 
                scn,
                panelTitle,
                FieldByTagLabelText.DAD_CENTROSDETRABAJO_DISPONIBLES,
                FieldByTagLabelText.DAD_CENTROSDETRABAJO_ASIGNADOS,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
