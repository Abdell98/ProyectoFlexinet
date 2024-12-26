package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GestionEmpresasClienteServiceLookupField extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    private GestionEmpresasClienteServiceType serviceType;
    private GestionEmpresasClienteServiceSelect serviceSelect;

    public GestionEmpresasClienteServiceLookupField(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        serviceType = new GestionEmpresasClienteServiceType(driver);
        serviceSelect = new GestionEmpresasClienteServiceSelect(driver);
    }

    public void lkpCIF(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown)  throws Exception {
        jsonFileNew(file);
        //String jsonFieldData = gestionEmpresaClienteData.getNombre_BusquedaDeConvenios();
        String jsonFieldData = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteAlta().
                getTabDatosRiesgos().
                getLkp_cif();

        if(jsonFieldData == null) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.CIF +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.CIF +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.CIF.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.CIF,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        serviceType.typeRazonSocial(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );


        serviceType.typeQbeNombreEmpresa(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeDireccion(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeProvincia(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeNifEmpresa(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeCNAE(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeResponsable(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                file,
                1,
                false,
                false,
                false
        );


        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_SELECCIONEEMPRESA,
                FieldByTagLabelText.QBE_RESPONSABLE,
                1
        ).sendKeys(Keys.ENTER);


        String jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_DATOSRIESGOS->DIALOG_SELECCIONEEMPRESA->TABLE"; //TODO: @PRE en uat puede ser distinto

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONEEMPRESA,
                file,
                jsonObjPathAux,
                1,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_SELECCIONEEMPRESA, //TODO: @PRE el nombre del dialogo en uat puede ser distinto ajustar
                FieldByTagLabelText.BTN_ACEPTAR,
                1,
                true,
                true
        );
    }

    public void lkpConColectivoEmpresaUsuaria(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown)  throws Exception {
        jsonFileNew(file);
        String jsonFieldData = null;
        String jsonObjPathAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getLkp_convColectivoEmpresaUsuaria();

                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_IDENTIFICATIVOS->DIALOG_BUSQUEDADECONVENIOS->TABLE";
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getLkp_convColectivoEmpresaUsuaria();

                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__MODIFICAR->TAB_IDENTIFICATIVOS->DIALOG_BUSQUEDADECONVENIOS->TABLE";
                break;
        }

        if(jsonFieldData == null) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.LKP_CONVCOLECTIVOEMPRESAUSUARIA +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.LKP_CONVCOLECTIVOEMPRESAUSUARIA +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.LKP_CONVCOLECTIVOEMPRESAUSUARIA.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.LKP_CONVCOLECTIVOEMPRESAUSUARIA,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        serviceType.typeNombre(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECONVENIOS,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_BUSQUEDADECONVENIOS,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );


        serviceType.typeQbeNombre(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECONVENIOS,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_BUSQUEDADECONVENIOS,
                FieldByTagLabelText.QBE_NOMBRE,
                1
        ).sendKeys(Keys.ENTER);


        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECONVENIOS,
                file,
                jsonObjPathAux,
                1,
                true
        );

    }

    public void lkpCategoriaLaboral(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown)  throws Exception {
        jsonFileNew(file);
        String jsonFieldData = null;
        String jsonObjPathAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabCategoriaSeguridadSocial().
                        getLkp_categoriaLaboral();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_CATEGORIASEGURIDADSOCIAL->DIALOG_BUSQUEDADECATEGORIASLABORALES->TABLE";
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabCategoriaSeguridadSocial().
                        getLkp_categoriaLaboral();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__MODIFICAR->TAB_CATEGORIASEGURIDADSOCIAL->DIALOG_BUSQUEDADECATEGORIASLABORALES->TABLE";
                break;
        }

        if(jsonFieldData == null) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.CATEGORIALABORAL +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.CATEGORIALABORAL +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.CATEGORIALABORAL.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.CATEGORIALABORAL,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        serviceType.typeNombre(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASLABORALES,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASLABORALES,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        serviceType.typeQbeCodigo(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASLABORALES,
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeCategoriaLaboral(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASLABORALES,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASLABORALES,
                FieldByTagLabelText.QBE_CATEGORIALABORAL,
                1
        ).sendKeys(Keys.ENTER);

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASLABORALES,
                file,
                jsonObjPathAux,
                1,
                true
        );
    }

    public void lkpCategoriaProfesional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown)  throws Exception {
        jsonFileNew(file);
        String jsonFieldData = null;
        String jsonObjPathAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabCategoriaSeguridadSocial().
                        getLkp_categoriaProfesional();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_CATEGORIASEGURIDADSOCIAL->DIALOG_BUSQUEDADECATEGORIASPROFESIONALES->TABLE";
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabCategoriaSeguridadSocial().
                        getLkp_categoriaProfesional();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__MODIFICAR->TAB_CATEGORIASEGURIDADSOCIAL->DIALOG_BUSQUEDADECATEGORIASPROFESIONALES->TABLE";
                break;
        }

        if(jsonFieldData == null) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.CATEGORIAPROFESIONAL +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.CATEGORIAPROFESIONAL +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.CATEGORIAPROFESIONAL.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.CATEGORIAPROFESIONAL,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        serviceType.typeNombre(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASPROFESIONALES,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASPROFESIONALES,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        serviceType.typeQbeCodigo(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASPROFESIONALES,
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeCategoriaProfesional(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASPROFESIONALES,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASPROFESIONALES,
                FieldByTagLabelText.QBE_CATEGORIAPROFESIONAL,
                1
        ).sendKeys(Keys.ENTER);

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADECATEGORIASPROFESIONALES,
                file,
                jsonObjPathAux,
                1,
                true
        );
    }

    public void lkpActividad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown)  throws Exception {
        jsonFileNew(file);
        String jsonFieldData = null;
        String jsonObjPathAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getLkp_actividad();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_RETRATOROBOT->DIALOG_BUSQUEDADEACTIVIDAD->TABLE";
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getLkp_actividad();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__MODIFICAR->TAB_RETRATOROBOT->DIALOG_BUSQUEDADEACTIVIDAD->TABLE";
                break;
        }

        if(jsonFieldData == null) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.LKP_ACTIVIDAD +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.LKP_ACTIVIDAD +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.LKP_ACTIVIDAD.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.LKP_ACTIVIDAD,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        serviceType.typeId(
                scn,
                page,
                PanelTitle.DIALOG_ACTIVIDAD,
                file,
                1,
                false,
                true,
                true
        );

        serviceType.typeNombre(
                scn,
                page,
                PanelTitle.DIALOG_ACTIVIDAD,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_ACTIVIDAD,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        serviceType.typeQbeIdActividad(
                scn,
                page,
                PanelTitle.DIALOG_ACTIVIDAD,
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeActividad(
                scn,
                page,
                PanelTitle.DIALOG_ACTIVIDAD,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_ACTIVIDAD,
                FieldByTagLabelText.QBE_IDACTIVIDAD,
                1
        ).sendKeys(Keys.ENTER);

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_ACTIVIDAD,
                file,
                jsonObjPathAux,
                1,
                true
        );
    }

    public void lkpCNAE(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown)  throws Exception {
        jsonFileNew(file);
        String jsonFieldData = null;
        String jsonObjPathAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getLkp_cNAE();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_RETRATOROBOT->DIALOG_BUSQUEDADECNAE->TABLE";
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getLkp_cNAE();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__MODIFICAR->TAB_RETRATOROBOT->DIALOG_BUSQUEDADECNAE->TABLE";
                break;
        }

        if(jsonFieldData == null) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.LKP_CNAE +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.LKP_CNAE +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.LKP_CNAE.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.LKP_CNAE,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        serviceType.typeId(
                scn,
                page,
                PanelTitle.DIALOG_CNAE,
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeNombre(
                scn,
                page,
                PanelTitle.DIALOG_CNAE,
                file,
                1,
                false,
                false,
                false
        );

        serviceSelect.selectGrupo(
                scn,
                page,
                PanelTitle.DIALOG_CNAE,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_CNAE,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        serviceType.typeQbeIDCNAE(
                scn,
                page,
                PanelTitle.DIALOG_CNAE,
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeCNAE(
                scn,
                page,
                PanelTitle.DIALOG_CNAE,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_CNAE,
                FieldByTagLabelText.QBE_CNAE,
                1
        ).sendKeys(Keys.ENTER);

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_CNAE,
                file,
                jsonObjPathAux,
                1,
                true
        );
    }

    public void lkpSIC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown)  throws Exception {
        jsonFileNew(file);
        String jsonFieldData = null;
        String jsonObjPathAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getLkp_sIC();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_RETRATOROBOT->DIALOG_BUSQUEDADESIC->TABLE";
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                jsonFieldData = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getLkp_sIC();
                jsonObjPathAux = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__MODIFICAR->TAB_RETRATOROBOT->DIALOG_BUSQUEDADESIC->TABLE";
                break;
        }

        if(jsonFieldData == null) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.LKP_SIC +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.LKP_SIC +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.LKP_SIC.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.LKP_SIC,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        serviceType.typeId(
                scn,
                page,
                PanelTitle.DIALOG_SIC,
                file,
                1,
                false,
                true,
                true
        );

        serviceType.typeNombre(
                scn,
                page,
                PanelTitle.DIALOG_SIC,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_SIC,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        serviceType.typeQbeIDSIC(
                scn,
                page,
                PanelTitle.DIALOG_SIC,
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeSIC(
                scn,
                page,
                PanelTitle.DIALOG_SIC,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_SIC,
                FieldByTagLabelText.QBE_SIC,
                1
        ).sendKeys(Keys.ENTER);

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_SIC,
                file,
                jsonObjPathAux,
                1,
                true
        );
    }


}
