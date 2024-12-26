package com.eulen.flexinet.core.test.selenium.Pom.service.util;

import com.eulen.flexinet.core.test.selenium.Locators.MenuByTextContent;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.MenuTypeByTagName;
import com.eulen.flexinet.core.test.selenium.Pom.service.CommonService;
import com.eulen.flexinet.core.test.selenium.Pom.service.HomePageService;
import com.eulen.flexinet.core.test.selenium.Pom.service.LoginPageService;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.Environments;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class NavigationService extends BasePage {

    private LoginPageService serviceLogin;
    private HomePageService serviceHome;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    public NavigationService(WebDriver driver) {
        super(driver);
        serviceLogin = new LoginPageService(driver);
        serviceHome = new HomePageService(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void navigateToPage(SystemPages page) throws Exception {
        switch (page) {
            case LOGIN_PAGE:
                Assert.assertTrue(serviceLogin.loginButtonIsDisplayed());
                Assert.assertTrue(serviceLogin.loginPageFlexiplanLogoIsDisplayed());
                Assert.assertTrue(serviceLogin.loginPageFlexinetLogoIsDisplayed());
                serviceLogin.typeUser();
                serviceLogin.typePassword();
                serviceLogin.clickLoginButton();
                waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
                break;
            case HOME_PAGE: //TODO: tener en cuenta que segun el rol puede que algunos iconos no se vean
                Assert.assertTrue(serviceHome.homepageOfficeIconIsDisplayed());
                Assert.assertTrue(serviceHome.homepageInboxIconIsDisplayed());
                Assert.assertTrue(serviceHome.homepagePrintIconIsDisplayed());
                Assert.assertTrue(serviceHome.homepageSignOutIconIsDisplayed());
                Assert.assertTrue(serviceHome.homePageFlexiplanLogoIsDisplayed());
                Assert.assertTrue(serviceHome.homepageFlexinetLogoIsDisplayed());
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void navigateToSubPage(SystemPages page, String oficina, String scn) throws Exception {

        MenuTypeByTagName menuTypeByTagName;

        if(!checkWeAreOnHomePage()) {
            navigateToPage(SystemPages.LOGIN_PAGE);
        }

        navigateToPage(SystemPages.HOME_PAGE);

        //INFO: esto comprueba si la navegación es horizonal o mediante botón hamburguesa, es decir si el navegador
        // Está ajustado a un tamaño menor.
        if(checkSliderMenuIsActive()) {
            menuTypeByTagName = MenuTypeByTagName.slidemenu;
            Thread.sleep(3000);
            click(homePageLocators.getHomePageHamburgerIcon());
            waitUntilIsDisplayed(homePageLocators.getMenu(menuTypeByTagName, Boolean.FALSE, MenuByTextContent.ADMINISTRACIONDEFLEXINET));
        } else {
            menuTypeByTagName = MenuTypeByTagName.menubar;
        }

        establecerOficina(oficina, scn);

        switch (page) { //@paginas
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                gestionDeEmpresasCliente(menuTypeByTagName, MenuByTextContent.Alta);
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                gestionDeEmpresasCliente(menuTypeByTagName, MenuByTextContent.Consulta);
                break;
            case GESTION_CLIENTES_CONTRATO__ALTA:
                gestionClientesContrato(menuTypeByTagName, MenuByTextContent.Alta);
                break;
            case GESTION_CLIENTES_CONTRATO__CONSULTA:
                gestionClientesContrato(menuTypeByTagName, MenuByTextContent.Consulta);
                break;
            case GESTION_CENTROS_DE_TRABAJO__ALTA:
                gestionDeCentrosDeTrabajo(menuTypeByTagName, MenuByTextContent.Alta);
                break;
            case GESTION_CENTROS_DE_TRABAJO__CONSULTA:
                gestionDeCentrosDeTrabajo(menuTypeByTagName, MenuByTextContent.Consulta);
                break;
            case PEDIDOS__ALTA_SIMPLE:
                pedidos(menuTypeByTagName, MenuByTextContent.Simple);
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                pedidos(menuTypeByTagName, MenuByTextContent.Indefinidos);
                break;
            case PEDIDOS__ALTA_LV3233:
                pedidos(menuTypeByTagName, MenuByTextContent.PedidosLV3233);
                break;
            case PEDIDOS__CONSULTA:
                pedidos(menuTypeByTagName, MenuByTextContent.Consulta);
                break;
            case RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS:
                riesgos(menuTypeByTagName, MenuByTextContent.GestiondePedidosBloqueados);
                break;
            case CONTRATOS__CONSULTA:
                contratos(menuTypeByTagName, MenuByTextContent.Consulta);
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                contratos(menuTypeByTagName,MenuByTextContent.TraspasosMasivosDeAltas);
                break;
            case CONTRATOS__BAJA_CONSULTA:
                contratos(menuTypeByTagName,MenuByTextContent.Baja);
                break;
            case CONTRATOS__ANULACION:
                contratos(menuTypeByTagName,MenuByTextContent.Anulacion);
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                contratos(menuTypeByTagName,MenuByTextContent.DardeBaja);
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                contratos(menuTypeByTagName,MenuByTextContent.BajasMasivas);
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                contratos(menuTypeByTagName,MenuByTextContent.Prorrogas);
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                contratos(menuTypeByTagName,MenuByTextContent.ProrrogasAnulacion);
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                contratos(menuTypeByTagName,MenuByTextContent.Alta);
                break;
            case CONTRATOS__NOVACION_ALTA:
                contratos(menuTypeByTagName,MenuByTextContent.Novacion);
                break;
            case CONTRATOS__SUSTITUCION_CONSULTA:
                contratos(menuTypeByTagName,MenuByTextContent.Sustitucion);
                break;
            case CONTRATOS__ALTA_SUSTITUCION:
                contratos(menuTypeByTagName,MenuByTextContent.AltaSustitucion);
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                contratos(menuTypeByTagName,MenuByTextContent.ControlEnviosCpds);
                break;
            case PARTES_DE_HORAS__ALTA:
                partesdehoras(menuTypeByTagName, MenuByTextContent.Alta);
                break;
            case PARTES_DE_HORAS__CONSULTA:
                partesdehoras(menuTypeByTagName, MenuByTextContent.Consulta);
                break;
			case PARTES_DE_HORAS__TRASPASO:
                partesdehoras(menuTypeByTagName, MenuByTextContent.Traspaso);
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                if(Hooks.getEnv().equals(Environments.UAT)) { //@SHERPA
                    partesdehoras(menuTypeByTagName, MenuByTextContent.EnvioPartesAOracle);
                }
                break;
            case GENERADOR_AUTOMATICO_PARTES__HORAS:
                gestionAvanzada(menuTypeByTagName, MenuByTextContent.GeneracionMasivadePartes);
                break;
            case GESTION_AVANZADA__CONSULTA_AVANZADA_DE_PARTES_DE_HORAS:
                gestionAvanzada(menuTypeByTagName, MenuByTextContent.ConsultaAvanzadadePartesdeHoras);
                break;
            case GESTION_DE_INFORMES__INFORME_DE_CONTRATACION_Y_PERSONAL__INFORME_DIGITAL_PARA_CIERRE_DE_NOMINA:
                gestiondeInformes(menuTypeByTagName, MenuByTextContent.InformeDigitalparaCierredeNomina);
                break;
            case FACTURACION__CONSULTA:
                facturacion(menuTypeByTagName, MenuByTextContent.Consulta);
                break;
            case GESTION_DE_ITS:
                administracionPersonal(menuTypeByTagName, MenuByTextContent.GestiondeITs);
                break;
        }
    }

    public void establecerOficina(String oficina, String scn) throws Exception {
        WebElement element;

        waitUntilIsDisplayed(element = homePageLocators.getOficinaActual());
        if(!element.getText().equals(oficina)) {

            commonService.waitUntilSpinnerIsNotDisplayed();
            element = waitUntilIsDisplayed(element, By.xpath("./following-sibling::i[1]"));
            click(element);
            commonService.waitUntilSpinnerIsDisplayed();

            commonService.waitUntilSpinnerIsNotDisplayed();
            commonService.checkNoUnexpectedMessageIsShown();

            WebElement table = homePageLocators.getTableModalCambiarEmpresa();
            WebElement oficinaQueryByEntry;

            waitUntilIsDisplayed(oficinaQueryByEntry = table.findElement(By.xpath("./thead/tr/th[1]/input")));

            Thread.sleep(2000);

            commonService.typeInputField(
                    scn,
                    oficinaQueryByEntry,
                    oficina,
                    true,
                    true,
                    true
            );

            oficinaQueryByEntry.sendKeys(Keys.ENTER);

            Thread.sleep(2000);

            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
            commonService.checkNoUnexpectedMessageIsShown();

            tableExtractor(table).entrySet().stream()
                                    .filter(entry -> oficina.equals(entry.getValue().get("Oficinas Disponibles")))
                                    .findFirst()
                                    .ifPresentOrElse(entry -> {
                                        System.out.println(entry.getValue());
                                        Integer rowkey = entry.getKey();
                                        try {
                                            WebElement fila;
                                            waitUntilIsDisplayed(fila = table.findElement(By.xpath("./tbody/tr[" + (rowkey + 1) + "]")));
                                            click(fila);

                                            WebElement boton;
                                            waitUntilIsDisplayed(boton = homePageLocators.getBtnAceptarModalCambiarEmpresa());
                                            click(boton);
                                        } catch (Exception e) {
                                            System.err.println(e.getMessage());
                                            throw new NoSuchElementException("No se ha logrado hacer click en la fila...");
                                        }

                                    }, () -> {
                                        throw new AssertionError("No se ha encontrado la oficina...");
                                    });

            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());

            if(commonService.checkMsgOficinaCambiadaCorrectamente()) {
                System.out.println("INFO: Oficina cambiada correctamente");
            } else {
                commonService.checkNoUnexpectedMessageIsShown();
            }
        }
    }

    public void gestionClientesContrato(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.FALSE, MenuByTextContent.GESTIONDEOFICINAS));
            Thread.sleep(3000);
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresas));
            Thread.sleep(500);
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeClientesContrato));
            System.out.println("El menú es tipo menubar");
        } else {
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.FALSE, MenuByTextContent.GESTIONDEOFICINAS));
            Thread.sleep(500);
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresas));
            Thread.sleep(500);
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeClientesContrato));
            System.out.println("El menú es tipo slide");
        }
        Thread.sleep(500);
        click(homePageLocators.getMenuItem(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeClientesContrato, subPage));
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public void gestionDeEmpresasCliente(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.FALSE, MenuByTextContent.GESTIONDEOFICINAS));
            Thread.sleep(3000);
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresas));
            Thread.sleep(500);
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresasCliente));
            System.out.println("INFO: El menú es tipo menubar");
        } else {
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.FALSE, MenuByTextContent.GESTIONDEOFICINAS));
            Thread.sleep(500);
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresas));
            Thread.sleep(500);
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresasCliente));
            System.out.println("INFO: El menú es tipo slide");
        }
        Thread.sleep(500);
        click(homePageLocators.getMenuItem(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresasCliente, subPage));
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("INFO: Hemos cargado la página de " + subPage);
    }

    public void gestionDeCentrosDeTrabajo(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.FALSE, MenuByTextContent.GESTIONDEOFICINAS));
            Thread.sleep(500);
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresas));
            Thread.sleep(500);
            moveTo(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeCentrosdeTrabajo));
            System.out.println("El menú es tipo menubar");
        } else {
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.FALSE, MenuByTextContent.GESTIONDEOFICINAS));
            Thread.sleep(500);
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeEmpresas));
            Thread.sleep(500);
            click(homePageLocators.getMenu(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeCentrosdeTrabajo));
            System.out.println("El menú es tipo slide");
        }
        Thread.sleep(500);
        click(homePageLocators.getMenuItem(menuTypeByTagName, Boolean.TRUE, MenuByTextContent.GestiondeCentrosdeTrabajo, subPage));
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public void gestiondeInformes(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case ListadodeCPDS:
                case AGETT:
                case ListadodeNominas:
                case InformeControldeNominasyFiniquitos:
                case InformeDigitalparaCierredeNomina:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEINFORMES, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEINFORMES, MenuByTextContent.InformesdeContratacionyPersonal, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEINFORMES, MenuByTextContent.InformesdeContratacionyPersonal, MenuByTextContent.InformeDigitalparaCierredeNomina, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEINFORMES, MenuByTextContent.InformesdeContratacionyPersonal, MenuByTextContent.InformeDigitalparaCierredeNomina, null));
                    break;
                case InformedeContratacionyFacturacion:
                case InformedeAbsentismo:
                case ControldeTemporalidad:
                case InformedeAlarmas:
                case GestiondeFijosDiscontinuos:
            }
        } else {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case ListadodeCPDS:
                case AGETT:
                case ListadodeNominas:
                case InformeControldeNominasyFiniquitos:
                case InformeDigitalparaCierredeNomina:
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEINFORMES, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEINFORMES, MenuByTextContent.InformedeContratacionyPersonal, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEINFORMES, MenuByTextContent.InformedeContratacionyPersonal, MenuByTextContent.InformeDigitalparaCierredeNomina, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEINFORMES, MenuByTextContent.InformedeContratacionyPersonal, MenuByTextContent.InformeDigitalparaCierredeNomina, subPage));
                    break;
                case InformedeContratacionyFacturacion:
                case InformedeAbsentismo:
                case ControldeTemporalidad:
                case InformedeAlarmas:
                case GestiondeFijosDiscontinuos:
            }
        }
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public void pedidos(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case Simple:
                case Indefinidos:
                case PedidosLV3233:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, null, MenuByTextContent.Alta));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, MenuByTextContent.Alta, subPage));
                    break;
                case Consulta:
                case GestiondeSolicitudesdelPortaldeClientes:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, null, subPage));
            }
        } else {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case Simple:
                case Indefinidos:
                case PedidosLV3233:
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, MenuByTextContent.Alta, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, MenuByTextContent.Alta, subPage));
                    break;
                case Consulta:
                case GestiondeSolicitudesdelPortaldeClientes:
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Pedidos, null, subPage));
                    break;
            }
        }
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public void contratos(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {
        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case Consulta:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, subPage));
                    break;
                case TraspasosMasivosDeAltas:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.TraspasosMasivosdeAltas, null, null));
                    break;
                case Baja:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, MenuByTextContent.Consulta));
                    break;
                case Anulacion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Anulacion, null));
                    break;
                case DardeBaja:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, MenuByTextContent.DardeBaja));
                    break;
                case BajasMasivas:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, MenuByTextContent.BajasMasivas));
                    break;
                case Prorrogas:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, MenuByTextContent.Consulta));
                    break;
                case ProrrogasAnulacion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, MenuByTextContent.Anulacion));
                    break;
                case Alta:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, MenuByTextContent.Alta));
                    break;
                case Novacion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Novacion, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Novacion, MenuByTextContent.Alta));
                    break;
                case Sustitucion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Sustitucion, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Sustitucion, MenuByTextContent.Consulta));
                    break;
                case AltaSustitucion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Sustitucion, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Sustitucion, MenuByTextContent.Alta));
                    break;
                case ControlEnviosCpds:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.ControlEnviosCpds, null, null));
                    break;
            }
        } else {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case Consulta:
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, subPage));
                    break;
                case TraspasosMasivosDeAltas:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.TraspasosMasivosdeAltas, null, null));
                    break;
                case Baja:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, MenuByTextContent.Consulta));
                    break;
                case Anulacion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Anulacion, null));
                    break;
                case DardeBaja:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, MenuByTextContent.DardeBaja));
                    break;
                case BajasMasivas:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Baja, MenuByTextContent.BajasMasivas));
                    break;
                case Prorrogas:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, MenuByTextContent.Consulta));
                    break;
                case ProrrogasAnulacion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, MenuByTextContent.Anulacion));
                    break;
                case Alta:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Prorrogas, MenuByTextContent.Alta));
                    break;
                case Novacion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Novacion, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Novacion, MenuByTextContent.Alta));
                    break;
                case Sustitucion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Sustitucion, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Sustitucion, MenuByTextContent.Consulta));
                    break;
                case AltaSustitucion:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Sustitucion, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, MenuByTextContent.Sustitucion, MenuByTextContent.Alta));
                    break;
                case ControlEnviosCpds:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Contratos, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.ControlEnviosCpds, null, null));
                    break;
            }
        }
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public void facturacion(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception{
        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case Consulta:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Facturacion, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.Facturacion, null, subPage));
                    break;
            }
        }
    }
    public void riesgos(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case GestiondePedidosBloqueados:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.RIESGOS, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.RIESGOS, MenuByTextContent.GestiondePedidosBloqueados,null, null));
                    break;
            }
        } else {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case GestiondePedidosBloqueados:
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.RIESGOS, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.RIESGOS, MenuByTextContent.GestiondePedidosBloqueados,null, subPage));
                    break;
            }
        }
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public void partesdehoras(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case Traspaso:
                case Consulta:
                case Alta:
                case EnvioPartesAOracle:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.PartesdeHoras, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.PartesdeHoras, null, subPage));
                    break;
            }
        } else {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case Traspaso:
                case Consulta:
                case Alta:
                case EnvioPartesAOracle:
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.PartesdeHoras, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONDEOFICINAS, MenuByTextContent.PartesdeHoras, null, subPage));
                    System.out.println("INFO: El menú es tipo slide");
                    break;
            }
        }
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public void gestionAvanzada(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case FacturacionManual:
                    break;
                case DetalleFacturaElectronica:
                    break;
                case BloqueodeFacturacionActiva:
                    break;
                case GestiondeDocumentos:
                    break;
                case GestionPresupuestaria:
                    break;
                case MarcarPartesComoFacturados:
                    break;
                case MantenimientoDigitalizaciondeClientes:
                    break;
                case DatoUnico:
                    break;
                case TraspasosMasivosDeContratos:
                    break;
                case GeneracionMasivadePartes:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA,null,null,  subPage));
                    break;
                case ConsultaAvanzadadePartesdeHoras:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, null, null, null));
                    Thread.sleep(500);
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, MenuByTextContent.ConsultaAvanzadadePartesdeHoras, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, MenuByTextContent.ConsultaAvanzadadePartesdeHoras, null, null));
                    break;
                case GestiondeSPFs:
                    break;
                case InformedeMaximos:
                    break;
                case InformedeFiniquitosPendientes:
                    break;
                case PrefacturacionOrdenesdeFacturacion:
                    break;
                case SPFsFlexinet:
                    break;
                case Informedepartesconembargos:
                    break;
            }
        } else {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case FacturacionManual:
                    break;
                case DetalleFacturaElectronica:
                    break;
                case BloqueodeFacturacionActiva:
                    break;
                case GestiondeDocumentos:
                    break;
                case GestionPresupuestaria:
                    break;
                case MarcarPartesComoFacturados:
                    break;
                case MantenimientoDigitalizaciondeClientes:
                    break;
                case DatoUnico:
                    break;
                case TraspasosMasivosDeContratos:
                    break;
                case GeneracionMasivadePartes:
                    break;
                case ConsultaAvanzadadePartesdeHoras:
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, MenuByTextContent.ConsultaAvanzadadePartesdeHoras, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, MenuByTextContent.ConsultaAvanzadadePartesdeHoras, null, subPage));
                    break;
                case GestiondeSPFs:
                    break;
                case InformedeMaximos:
                    break;
                case InformedeFiniquitosPendientes:
                    break;
                case PrefacturacionOrdenesdeFacturacion:
                    break;
                case SPFsFlexinet:
                    break;
                case Informedepartesconembargos:
                    break;
            }
        }
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public void administracionPersonal(MenuTypeByTagName menuTypeByTagName, MenuByTextContent subPage) throws Exception {

        if(menuTypeByTagName.equals(MenuTypeByTagName.menubar)) {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case BasesdeCotizacion:
                    break;
                case InformesITs:
                    break;
                case GestiondeITs:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.ADMINISTRACIONDEPERSONAL, null, null, null));
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.ADMINISTRACIONDEPERSONAL, subPage, null, null));
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.ADMINISTRACIONDEPERSONAL, subPage, null, null));
                    break;
            }
        } else {
            System.out.println("El menú es tipo " + menuTypeByTagName);
            switch (subPage) {
                case FacturacionManual:
                    break;
                case DetalleFacturaElectronica:
                    break;
                case BloqueodeFacturacionActiva:
                    break;
                case GestiondeDocumentos:
                    break;
                case GestionPresupuestaria:
                    break;
                case MarcarPartesComoFacturados:
                    break;
                case MantenimientoDigitalizaciondeClientes:
                    break;
                case DatoUnico:
                    break;
                case TraspasosMasivosDeContratos:
                    break;
                case GeneracionMasivadePartes:
                    moveTo(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, null,null,  subPage));
                    break;
                case ConsultaAvanzadadePartesdeHoras:
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, null, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, MenuByTextContent.ConsultaAvanzadadePartesdeHoras, null, null));
                    Thread.sleep(500);
                    click(homePageLocators.getMenuItem(menuTypeByTagName, MenuByTextContent.GESTIONAVANZADA, MenuByTextContent.ConsultaAvanzadadePartesdeHoras, null, subPage));
                    break;
                case GestiondeSPFs:
                    break;
                case InformedeMaximos:
                    break;
                case InformedeFiniquitosPendientes:
                    break;
                case PrefacturacionOrdenesdeFacturacion:
                    break;
                case SPFsFlexinet:
                    break;
                case Informedepartesconembargos:
                    break;
            }
        }
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        System.out.println("Hemos cargado la página de " + subPage);
    }

    public boolean checkSliderMenuIsActive() {
        try {
            WebElement element = homePageLocators.getHomePageHamburgerIcon();
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkWeAreOnHomePage() {
        try {
            WebElement element = homePageLocators.getHomePageOfficeIcon();
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
