package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaAvanzadaDePartesDeHorasTask extends BasePage {

    private CommonService commonService;
    private ConsultaAvanzadaDePartesDeHorasServiceType serviceType;
    private ConsultaAvanzadaDePartesDeHorasServiceSelect serviceSelect;
    private ConsultaAvanzadaDePartesDeHorasServiceCheckbox serviceCheckbox;
    private ConsultaAvanzadaDePartesDeHorasServiceLookupField serviceLookupField;

    public ConsultaAvanzadaDePartesDeHorasTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        serviceType = new ConsultaAvanzadaDePartesDeHorasServiceType(driver);
        serviceSelect = new ConsultaAvanzadaDePartesDeHorasServiceSelect(driver);
        serviceCheckbox = new ConsultaAvanzadaDePartesDeHorasServiceCheckbox(driver);
        serviceLookupField = new ConsultaAvanzadaDePartesDeHorasServiceLookupField(driver);
    }
    public void ingresarDatosDelFormularioDeConsulta(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeEmpresa(scn, page, null, file, 1, false, false, false);
        serviceType.typeNombre(scn, page, null, file, 1, false, false, false);
        serviceType.typePrimerApellido(scn, page, null, file, 1, false, false, false);
        serviceSelect.selectMes(scn, page, null, file, 1, false, false, false);
        serviceType.typeSegundoApellido(scn, page, null, file, 1, false, false, false);
        serviceType.typeAnio(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkANivelNacional(scn, page, null, file, 1, false, false, false);
        serviceType.typeNIF(scn, page, null, file, 1, false, false, false);
        serviceLookupField.lkpNif(scn, page, null, file, 1, false, true, true);
    }

    public void rellenarDatosDeTablaDePartes(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeQbeNParte(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeIdContrato(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeNIF(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeColaborador(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeEmpresa(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeMes(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeDiaDeInicio(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeDiaDeFin(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeParteOriginal(scn, page, null, file, 1, false, false, false);
    }
}


