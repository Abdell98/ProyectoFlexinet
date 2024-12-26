package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import dev.failsafe.Execution;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonServiceClick extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public CommonServiceClick(WebDriver driver){
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void clickBtnCerrarModal() throws Exception {
        click(pageLocators.getBtnCerrarModal());
        Thread.sleep(1000);
        try {
            System.out.println("@DEBUG comprobando que se cierra el modal");
            waitUntilIsNotDisplayed(pageLocators.getBtnCerrarModal(), 2);
        } catch (Exception e) {
            System.out.println("@DEBUG fail no se ha cerrado, intentando nuevamente");
            softly.fail("FAIL: La notificación no se ha cerrado en el primer intento de cierre");
            click(pageLocators.getBtnCerrarModal());
            Thread.sleep(1000);
            System.out.println("@DEBUG comprobando nuevamente que se ha cerrado el modal");
            waitUntilIsNotDisplayed(pageLocators.getBtnCerrarModal(), 2);
        }

        boolean result;

        try {
            result = pageLocators.getBtnCerrarModal().isDisplayed();
        } catch (Exception e) {
            result = false;
        }

        Assert.assertFalse("FAIL: El modal sigue siendo visible", result);
    }

    public void clickBtnCerrarDialog(PanelTitle dialogTitle) throws Exception {
        WebElement element = waitUntilIsDisplayed(pageLocators.getDialogCerrarByXpath(dialogTitle));
        click(element);
    }

    public void clickBtnGuardar() throws Exception {
        click(pageLocators.getBtnGuardar());
    }

    public void clickBtnBuscar() throws Exception {
        click(pageLocators.getBtnBuscar());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickTab(String tabName) throws Exception {
        waitUntilBeClickable(pageLocators.getTab(tabName));
        click(pageLocators.getTab(tabName));
        try {
            waitUntilIsDisplayed(pageLocators.getTabActive(tabName));
        } catch (Exception e) {
            click(pageLocators.getTab(tabName));
            waitUntilIsDisplayed(pageLocators.getTabActive(tabName));
        }
    }

    public void clickBtn(
            PanelTitle tabTitle,
            PanelTitle dialogTitle,
            FieldByTagLabelText buttonLabel,
            Integer cajaNumero,
            Boolean waitForSpinner,
            Boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton(
                tabTitle,
                dialogTitle,
                buttonLabel.getCodigo(),
                cajaNumero
        );
        System.out.println("INFO: Haciendo click en el botón `" + buttonLabel.getCodigo() +"`...");
        commonService.click(button);

        if(waitForSpinner.equals(Boolean.TRUE)) {
            commonService.waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            commonService.checkNoUnexpectedMessageIsShown();
        } else {
            commonService.checkMsgErrorIsNotShown(true);
        }

    }

    public void sendEnterOnQbeFilter(PanelTitle panelTitle, FieldByTagLabelText fieldByTagLabelText, Integer cajaNum) throws Exception {
        pageLocators.getQbEInputField(
                panelTitle,
                fieldByTagLabelText,
                cajaNum
        ).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        Thread.sleep(3000);
    }
}
