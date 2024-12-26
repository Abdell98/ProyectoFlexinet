package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonServiceValidate extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    public CommonServiceValidate(WebDriver driver){
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
    }

    public void waitToAccessPage(SystemPages page) throws Exception {
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        String currentUrl = "";
        switch (page) {
            case PEDIDOS__CONSULTA:
                wait.until(ExpectedConditions.urlContains("/pedidos-consulta"));
                currentUrl = driver.getCurrentUrl();
                Assert.assertTrue(currentUrl.contains("/pedidos-consulta"));
                System.out.println("PASS: Hemos sido llevados a "+page);
                break;
            case PEDIDOS__MODIFICACION:
                wait.until(ExpectedConditions.urlContains("/pedidos-modificacion"));
                currentUrl = driver.getCurrentUrl();
                Assert.assertTrue(currentUrl.contains("/pedidos-modificacion"));
                System.out.println("PASS: Hemos sido llevados a "+page);
                break;
            case RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS:
                wait.until(ExpectedConditions.urlContains("/consulta-pedidos-bloqueados"));
                currentUrl = driver.getCurrentUrl();
                Assert.assertTrue(currentUrl.contains("/consulta-pedidos-bloqueados"));
                System.out.println("PASS: Hemos sido llevados a "+page);
                break;
            default:
                System.err.println("WARNING: No existe caso para la página indicada...");
        }

    }

    public void validateDialogVisible(PanelTitle dialogTitle) throws Exception {
        try {
            waitUntilIsDisplayed(pageLocators.getDialogTitleByXpath(dialogTitle));
        } catch (Exception e) {
            throw new NotFoundException("ERROR: El dialogo mostrado no es el esperado.");
        }
    }


    public void validateGrowlMessage(ModalTitle title, String message, boolean cerrarModal, boolean hacerScreenShot) throws Exception {
        System.out.println("Validando notificacion `"+message+"`");
        int timeToWait = 120; //TODO: esto pasarlo por argumentos
        System.out.println("@DEBUG spinner visible " + System.currentTimeMillis());
        try {
            List<LocatorCondition> locatorConditions = new ArrayList<>();
            locatorConditions.add(new LocatorCondition(homePageLocators.getFlexinetLoadingSpinnerBy(), false, false));
            locatorConditions.add(new LocatorCondition(pageLocators.getModalByXpath(title, message), true, true));

            List<By> locatorsNotToBeVisible = List.of();

            switch (title) {
                case INFORMACION:
                    locatorsNotToBeVisible = Arrays.asList(
                            pageLocators.getModalNotContainsMsgByXpath(title, message), //Si aparece un mensaje diferente al que esperamos
                            pageLocators.getMsgErrorByXpath() //Miramos que no se muestre ningún error, si se muestra alguno finaliza con error
                    );
                    break;
                case ERROR:
                    locatorsNotToBeVisible = Arrays.asList(
                            pageLocators.getModalNotContainsMsgByXpath(title, message), //Si aparece un mensaje de información con un mensaje que no sea el que esperamos
                            pageLocators.getMsgInfoByXpath() //Miramos que no se muestre ningún modal de información, dado que esperamos uno de error, si se muestra alguno finaliza con error
                    );
                    break;
            }

            waitUntilConditionMet(
                    locatorConditions,
                    locatorsNotToBeVisible,
                    timeToWait
            );

        } catch (AssertionError e) {
            throw new AssertionError("FAIL: Se ha mostrado un mensaje inesperado...");
        } catch (Exception e) {
            throw new AssertionError("No se ha mostrado el mensaje esperado transcurridos `"+timeToWait+"` segundos..." + e);
        } finally {
            if(hacerScreenShot) {
                //commonService.doScreenshot("Notificación Mostrada");
            }
            if(cerrarModal) {
                commonServiceClick.clickBtnCerrarModal();
            }
        }
    }

    public void validateDialogMessage(PanelTitle panelTitle, String message, String file) throws Exception {
        int timeToWait = 60;
        System.out.println("@DEBUG spinner visible " + System.currentTimeMillis());
        try {
            List<LocatorCondition> locatorConditions = new ArrayList<>();
            locatorConditions.add(new LocatorCondition(homePageLocators.getFlexinetLoadingSpinnerBy(), false, false));
            locatorConditions.add(new LocatorCondition(pageLocators.getDialogMsgByXpath(panelTitle, message), true, true));

            List<By> locatorsNotToBeVisible = List.of();

            locatorsNotToBeVisible = Arrays.asList(
                    pageLocators.getMsgErrorByXpath(), //Miramos que no se muestre ningún error, si se muestra alguno finaliza con error
                    pageLocators.getMsgInfoByXpath()
            );

            waitUntilConditionMet(
                    locatorConditions,
                    locatorsNotToBeVisible,
                    timeToWait
            );
        } catch (AssertionError e) {
            throw new AssertionError("FAIL: Se ha mostrado un mensaje inesperado...");
        } catch (Exception e) {
            throw new AssertionError("No se ha mostrado el mensaje esperado transcurridos `"+timeToWait+"` segundos..." + e);
        }

    }

    public void waitForGrowlNotifToBeVisible(ModalTitle title, String message, boolean cerrarModal, boolean hacerScreenShot) throws Exception {

        waitUntilIsDisplayed(pageLocators.getModalByXpath(title, message));

        if(hacerScreenShot) {
            commonService.doScreenshot("Notificación Mostrada");
        }

        if(cerrarModal) {
            commonServiceClick.clickBtnCerrarModal();
        }
    }

}
