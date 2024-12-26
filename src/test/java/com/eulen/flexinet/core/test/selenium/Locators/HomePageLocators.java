package com.eulen.flexinet.core.test.selenium.Locators;

import com.eulen.flexinet.core.test.selenium.Pom.pom.PageObjectBase;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class HomePageLocators extends PageObjectBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//i[contains(@class,'fa-building')]")
    private WebElement homePageOfficeIcon;

    @FindBy(xpath = "//i[contains(@class,'fa-inbox')]")
    private WebElement homePageInboxIcon;

    @FindBy(xpath = "//i[contains(@class,'fa-print')]")
    private WebElement homePagePrintIcon;

    @FindBy(xpath = "//i[contains(@class,'fa-sign-out')]")
    private WebElement homePageSignOutIcon;

    @FindBy(xpath = "//p-slidemenu//following::i[contains(@class,'headerSlideMenuBoton')]")
    private WebElement homePageHamburgerIcon;

    @FindBy(xpath = "//img[contains(@src,'/flexinet/src/assets/FlexiNet_LOGO.jpg')]")
    private WebElement homePageFlexinetLogo;

    @FindBy(xpath = "//img[contains(@src,'/flexinet/src/assets/logoCabeceraTL.png')]")
    private WebElement homePageFlexiplanLogo;

    @FindBy(xpath = "//loading//img[contains(@style,'display:block')]")
    private WebElement flexinetLoadingSpinner;

    public By getFlexinetLoadingSpinnerBy() {
        return By.xpath("//loading//img[contains(@style,'display:block')]");
    }

    //BAR MENU
    @FindBy(xpath = "//p-menubar//*[normalize-space(text()) and normalize-space(.)='GESTIÓN DE OFICINAS']")
    private WebElement barMenuGestionDeOficinas;

    @FindBy(xpath = "//p-menubar//*[contains(@class,'active')]//*[normalize-space(text()) and normalize-space(.)='GESTIÓN DE OFICINAS']") ///ancestor::li[contains(@class,'active')]
    private WebElement barMenuGestionDeOficinasIsActive;


    @FindBy(xpath = "//p-menubar//*[contains(@class,'active')]//*[normalize-space(text()) and normalize-space(.)='Gestión de Empresas']")
    private WebElement barMenuGestionDeEmpresas;

    //SLIDE MENU
    @FindBy(xpath = "//p-slidemenu//*[normalize-space(text()) and normalize-space(.)='GESTIÓN DE OFICINAS']")
    private WebElement slideMenuGestionDeOficinas;

    @FindBy(xpath = "//p-slidemenu//*[contains(@class,'active')]//*[normalize-space(text()) and normalize-space(.)='Gestión de Empresas']")
    private WebElement slideMenuGestionDeEmpresas;

    //OFICINA
    @FindBy(xpath = "//span[contains(@class,'navbar-brand oficina')]")
    private WebElement oficinaActual;

    @FindBy(xpath = "//p-dialog[contains(@header,'Cambiar de Oficina')]//table/thead/tr/th[1]/input")
    private WebElement inputOficinasDisponiblesModalCambiarDeOficina;

    @FindBy(xpath = "//p-dialog[contains(@header,'Cambiar de Oficina')]//table/thead/tr/th[2]/input")
    private WebElement inputResponsableModalCambiarDeOficina;

    @FindBy(xpath = "//p-dialog[contains(@header,'Cambiar de Oficina')]//table")
    private WebElement tableModalCambiarEmpresa;

    @FindBy(xpath = "//p-dialog[contains(@header,'Cambiar de Oficina')]//span[contains(text(),'Aceptar')]")
    private  WebElement btnAceptarModalCambiarEmpresa;

    @FindBy(xpath = "//p-growl//*[contains(@class,'fa-close')]")
    private WebElement btnCloseInfoMsgModalCambiarEmpresa;


    public WebElement getMenu(MenuTypeByTagName menuTypeByTagName, Boolean classContainsActive, MenuByTextContent item) {
        WebElement selectedMenu;
        String xpath;
        if(classContainsActive) {
            xpath = "//p-" + menuTypeByTagName.toString() + "//*[contains(@class,'active')]//*[normalize-space(text()) and normalize-space(.)='" + item.getCodigo() + "']";
        } else {
            xpath = "//p-" + menuTypeByTagName.toString() + "//*[normalize-space(text()) and normalize-space(.)='" + item.getCodigo() + "']";
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        selectedMenu = driver.findElement(By.xpath(xpath));
        return selectedMenu;
    }

    public WebElement getMenuItem(MenuTypeByTagName menuTypeByTagName, Boolean classContainsActive, MenuByTextContent parentMenu, MenuByTextContent childItem) {
        WebElement selectedMenuItem;
        String xpath;
        if(classContainsActive) {
            xpath = "//p-" + menuTypeByTagName.toString() + "//*[contains(@class,'active')]//*[normalize-space(text()) and normalize-space(.)='" + parentMenu.getCodigo() + "']//parent::a/parent::li//p-"+ menuTypeByTagName.toString() +"sub//*[text() = '" + childItem.getCodigo() + "']";
        } else {
            xpath = "//p-" + menuTypeByTagName.toString() + "//*[normalize-space(text()) and normalize-space(.)='" + parentMenu.getCodigo() + "']//parent::a/parent::li//p-"+ menuTypeByTagName.toString() +"sub//*[text() = '" + childItem.getCodigo() + "']";
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        selectedMenuItem = driver.findElement(By.xpath(xpath));
        return selectedMenuItem;
    }

    public WebElement getMenuItem(
            MenuTypeByTagName menuTypeByTagName,
            MenuByTextContent menu,
            MenuByTextContent subMenu1,
            MenuByTextContent subMenu2,
            MenuByTextContent childItem) {
        WebElement selectedMenuItem;
        String xpath;
        String xpathSubMenu1;
        String xpathSubMenu2;
        String xpathChildItem;

        String xpathMenu = " //p-"+menuTypeByTagName.toString()+"//*[normalize-space(text()) and normalize-space(.)='"+menu.getCodigo()+"']";

        if(subMenu1 != null) {
            xpathSubMenu1 = "//ancestor::li[1]/p-"+ menuTypeByTagName +"sub//*[normalize-space(text()) and normalize-space(.)='"+subMenu1.getCodigo()+"']";
        } else {
            xpathSubMenu1 = "";
        }

        if(subMenu2 != null) {
            xpathSubMenu2 = "//ancestor::li[1]/p-"+ menuTypeByTagName +"sub//*[normalize-space(text()) and normalize-space(.)='"+subMenu2.getCodigo()+"']";
        } else {
            xpathSubMenu2 = "";
        }

        if(childItem != null) {
            xpathChildItem = "//ancestor::li[1]/p-"+ menuTypeByTagName +"sub//*[normalize-space(text()) and normalize-space(.)='"+childItem.getCodigo()+"']";
        } else {
            xpathChildItem = "";
        }

        xpath = xpathMenu+xpathSubMenu1+xpathSubMenu2+xpathChildItem;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        selectedMenuItem = driver.findElement(By.xpath(xpath));
        return selectedMenuItem;
    }



    public HomePageLocators(WebDriver driver) {
        super(driver);
    }
}
