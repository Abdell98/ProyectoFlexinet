package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class GeneracionMasivaServiceValidate extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GeneracionMasivaServiceValidate(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    /*public void clickFirstValidRowResultOnTableNew(String scn, SystemPages page, PanelTitle dialogTitle, String file, String jsonObjectPath, int cajaNumero, boolean isUnderDialog) throws Exception {

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
    }*/


}
