package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PedidosServiceValidate extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PedidosServiceValidate(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void waitToDialogSeleccionEmpresaIsVisible() throws Exception {
        waitUntilIsDisplayed(pageLocators.getDialogSeleccionDeEmpresa());
    }

    public void captureIdPedidoAndWriteToJson(String scn, SystemPages page, String file, Boolean writeIdPedidoOnJson) throws Exception {
        WebElement element;
        String mensaje = "";
        switch (Hooks.getEnv()) {
            case PRE:
                try {
                    element = waitUntilIsDisplayed(pageLocators.getDialogMsgByXpath(PanelTitle.TAB_DATOSDELPEDIDO, "Nº Pedido: "));
                } catch (Exception e) {
                    throw new AssertionError("FAIL: No se ha mostrado el mensaje esperado");
                }
                mensaje = element.getText();
                System.out.println("Se ha mostrado el mensaje:\n" + mensaje);
                if (mensaje != null) {
                    System.out.println("ID Pedido: " + mensaje);

                    if (writeIdPedidoOnJson) {
                        jsonUpdate(file, "RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->nPedidoDesde", mensaje);
                        jsonUpdate(file, "RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->TABLE->Nº Pedido", mensaje);
                        jsonUpdate(file, "PEDIDOS__CONSULTA->nPedido", mensaje);
                        jsonUpdate(file, "PEDIDOS__CONSULTA->TABLE->Nº Pedido", mensaje);

                        System.out.println("JsonActualizados con ID Pedido!!");
                    } else {
                        throw new Exception("ERROR: El mensaje no indica el número de pedido");
                    }
                }
                break;
            case UAT:
                try {
                    element = waitUntilIsDisplayed(pageLocators.getDialogMsgByXpath(PanelTitle.DIALOG_ESTADODEPEDIDO, ""));
                } catch (Exception e) {
                    throw new AssertionError("FAIL: No se ha mostrado el mensaje esperado");
                }
                mensaje = element.getText();
                System.out.println("Se ha mostrado el mensaje:\n" + mensaje);
                Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
                Matcher m = p.matcher(mensaje);
                if (m.find()) {
                    System.out.println("ID Pedido: " + m.group(0));

                    if (writeIdPedidoOnJson) {
                        jsonUpdate(file, "RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->nPedidoDesde", m.group(0));
                        jsonUpdate(file, "RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->TABLE->Nº Pedido", m.group(0));
                        jsonUpdate(file, "PEDIDOS__CONSULTA->nPedido", m.group(0));
                        jsonUpdate(file, "PEDIDOS__CONSULTA->TABLE->Nº Pedido", m.group(0));

                        System.out.println("JsonActualizados con ID Pedido!!");
                    }
                } else {
                    throw new Exception("ERROR: El mensaje no indica el número de pedido");
                }
                break;
        }
    }

    public String waitUntilGetNPedido() throws Exception {

        return waitForElementWithText(pageLocators.getFieldByXpath(
                PanelTitle.TAB_DATOSDELPEDIDO,
                FieldByTagLabelText.NPEDIDO,
                FieldType.label,
                1
        ), 10);
    }

}
