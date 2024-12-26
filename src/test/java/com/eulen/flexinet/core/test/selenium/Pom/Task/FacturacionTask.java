package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FacturacionTask extends BasePage {
    private FacturacionServiceClick serviceClick;
    private FacturacionServiceType serviceType;
    private FacturacionServiceCheckbox serviceCheckbox;
    private FacturacionServiceDatePicker serviceDatePicker;
    private FacturacionServiceLookupField serviceLookupField;
    private FacturacionServiceValidate serviceValidation;
    private FacturacionServiceSelect serviceSelect;
    private CommonServiceClick commonServiceClick;
    private CommonService commonService;
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;

    public FacturacionTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        serviceClick = new FacturacionServiceClick(driver);
        serviceType = new FacturacionServiceType(driver);
        serviceCheckbox = new FacturacionServiceCheckbox(driver);
        serviceDatePicker = new FacturacionServiceDatePicker(driver);
        serviceLookupField = new FacturacionServiceLookupField((driver));
        serviceValidation = new FacturacionServiceValidate(driver);
        serviceSelect = new FacturacionServiceSelect(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    public void completeRazonSocialForm(String scn, SystemPages page, String file) throws Exception {
        serviceLookupField.lkpRazonSocial(scn, page, null, file, 1, false, true, true);
    }

    public void completeformularioConsultaFacturacion(String scn, SystemPages page, String file) throws Exception {
        serviceCheckbox.checkBusquedaErp(scn, null, file, 1, false, true, true);
        serviceCheckbox.checkBusquedaANivelNacional(scn, page, null, file, 1, false, true, true);
        serviceSelect.selectFacturas(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.checkPrefacturas(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.checkFacturas(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.checkSpf(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.checkAbonosTotales(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.checkAbonosParciales(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.checkValidadasEmisionMasiva(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.checkMarcarDesmarcarParaEmitir(scn,page,null,file,1,false, true, true);
        serviceType.typeNroDocumento(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.clickRadUltimoMes(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.clickRadDentroRangoFechas(scn, page, null, file, 1, false, true, true);
        serviceDatePicker.pickDateDesde(scn, page, null, file, 1, false, true, true);
        serviceDatePicker.pickDateHasta(scn, page, null, file, 1, false, true, true);
        serviceCheckbox.checkFacturadasManuales(scn, page, null, file, 1, false, true, true);
    }

    public void seleccionarFactura(String scn, SystemPages page, String file) throws Exception {
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = "TestDatosFacturacion->FACTURACION__CONSULTA->TABLE";
                break;
        }
        commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
    }

    public void busquedaQbeEmpresa(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeQbeEmpresa(scn, page, null,file, 1, false, true, true);
        pageLocators.getQbEInputField(null,FieldByTagLabelText.QBE_EMPRESA,1).sendKeys(Keys.ENTER);
        commonService.waitUntilSpinnerIsDisplayed();
        commonService.waitUntilSpinnerIsNotDisplayed();
    }
}
