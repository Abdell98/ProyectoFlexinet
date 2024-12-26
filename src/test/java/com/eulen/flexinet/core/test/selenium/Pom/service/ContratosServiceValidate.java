package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContratosServiceValidate extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public ContratosServiceValidate(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void clickFirstValidRowResultOnTableNew(String scn, SystemPages page, PanelTitle dialogTitle, String file, String jsonObjectPath, int cajaNumero, boolean isUnderDialog) throws Exception {

        WebElement element = null;

        if (isUnderDialog) {
            if (dialogTitle != null) {
                element = pageLocators.getDialogTable(dialogTitle, 1);
            } else {
                element = pageLocators.getDialogTable();
            }
        } else {
            if (page.equals(SystemPages.PEDIDOS__CONSULTA)) {
                element = pageLocators.getTable(cajaNumero);
            } else {
                element = pageLocators.getTable();
            }
        }

        if (element == null) {
            throw new Exception("ERROR: No se ha encontrado la tabla");
        }

        Thread.sleep(1000);
        ArrayList<Integer> val = commonService.validateAndReturnRowNumNew(scn, page, file, element, jsonObjectPath);

        int pos = val.get(0) + 1;
        String xpathValue = ".//tbody//tr[" + pos + "]";
        try {
            System.out.println("Intentando hacer click en el primer registro encontrado...");
            WebElement finalElement = element.findElement(By.xpath(xpathValue));
            click(finalElement);
            switch (datosContrato.getContratosConsulta().getColorSemaforo()) { //@color_semaforo
                case "Verde":
                    String xpathElemenlSemaforo = "//i[@class='fa fa-circle contrato-enviado'][" + pos + "]";
                    WebElement finalElementSemaforo = element.findElement(By.xpath(xpathElemenlSemaforo));
                    click(finalElementSemaforo);
                    System.out.println("Elemento Encontrado");
                    break;
                case "Rojo":
                    String xpathElemenlSemaforoRojo = "//i[@class='fa fa-circle contrato-no-enviado'][" + pos + "]";
                    WebElement finalElementSemaforoRojo = element.findElement(By.xpath(xpathElemenlSemaforoRojo));
                    click(finalElementSemaforoRojo);
                    System.out.println("Elemento Encontrado");
                    break;
                case "Azul":
                    String xpathElemenlSemaforoAzul = "//i[@class='fa fa-circle contrato-no-se-envia'][" + pos + "]";
                    WebElement finalElementSemaforoAzul = element.findElement(By.xpath(xpathElemenlSemaforoAzul));
                    click(finalElementSemaforoAzul);
                    System.out.println("Elemento Encontrado");
                    break;
            }
            System.out.println("Click realizado...");
        } catch (Exception e) {
            throw new AssertionError("FAIL: No se ha encontrado resultado o no se ha podido hacer click en el resultado");
        }
    }

    public void capturarDateBaja(String scn, SystemPages page, String file, Boolean writeIdPedidoOnJson) throws Exception {
        WebElement element;
        String mensaje = "";
        switch (Hooks.getEnv()) {
            case PRE:
                try {
                    element = waitUntilIsDisplayed(pageLocators.getFirtElementTableByXpath("Fec. Fin "));
                } catch (Exception e) {
                    throw new AssertionError("FAIL: No se ha mostrado el mensaje esperado");
                }
                mensaje = element.getText();
                System.out.println("Se ha mostrado el mensaje:\n" + mensaje);
                if (mensaje != null) {
                    System.out.println("Fecha Fin Contrato: " + mensaje);
                    switch (scn) {
                        case "Flexinet19910":
                            if (writeIdPedidoOnJson) {
                                jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_ALTANOVACION->fecha", mensaje);
                                System.out.println("JsonActualizados con la fecha fin del Contrato!!");
                            } else {
                                throw new Exception("ERROR: El mensaje no indica la fecha fin del Contrato");
                            }
                            break;
                        case "Flexinet19907":
                            if (writeIdPedidoOnJson) {
                                jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->fechaDeFinalizacionProrroga", mensaje);
                                System.out.println("JsonActualizados con la fecha fin del Contrato!!");
                            } else {
                                throw new Exception("ERROR: El mensaje no indica la fecha fin del Contrato");
                            }
                            break;
                        default:
                            if (writeIdPedidoOnJson) {
                                jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->fechadeFinDesde", mensaje);
                                jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->DIALOG_BAJAMASIVACONTRATO->fecha", mensaje);
                                System.out.println("JsonActualizados con la fecha fin del Contrato!!");
                            } else {
                                throw new Exception("ERROR: El mensaje no indica la fecha fin del Contrato");
                            }
                    }
                }
                break;
        }
    }

}
