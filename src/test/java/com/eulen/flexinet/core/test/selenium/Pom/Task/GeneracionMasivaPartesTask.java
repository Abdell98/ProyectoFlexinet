package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneracionMasivaPartesTask extends BasePage {

    private GeneracionMasivaServiceClick serviceClick;
    private GeneracionMasivaServiceType serviceType;
    private GeneracionMasivaServiceCheckbox serviceCheckbox;
    private GeneracionMasivaServiceDatePicker serviceDatePicker;
    private GeneracionMasivaServiceSelect serviceSelect;
    private GeneracionMasivaServiceLookupField serviceLookupField;
    private GeneracionMasivaServiceValidate serviceValidation;
    private GeneracionMasivaServiceDataBaseProcedure serviceDataBaseProcedure;
    private CommonServiceClick commonServiceClick;
    private CommonService commonService;

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;

    public GeneracionMasivaPartesTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        serviceClick = new GeneracionMasivaServiceClick(driver);
        serviceType = new GeneracionMasivaServiceType(driver);
        serviceCheckbox = new GeneracionMasivaServiceCheckbox(driver);
        serviceDatePicker = new GeneracionMasivaServiceDatePicker(driver);
        serviceLookupField = new GeneracionMasivaServiceLookupField((driver));
        serviceValidation = new GeneracionMasivaServiceValidate(driver);
        serviceDataBaseProcedure = new GeneracionMasivaServiceDataBaseProcedure(driver);
        serviceSelect = new GeneracionMasivaServiceSelect(driver);

        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    public void completeFieldsGeneracionMasivaPartes(String scn, SystemPages page, String file) throws Exception {
        serviceSelect.selectMes(
                scn,
                page,
                null,
                file,
                1,
                true,
                false,
                false);

        serviceType.typeAnio(scn,
                page,
                null,
                file,
                1,
                true,
                false,
                false);
        serviceCheckbox.checkGenerados(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceType.typeEmpresa(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceType.typeNombre(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceType.typePrimerApellido(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceType.typeSegundoApellido(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceType.typeNif(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceCheckbox.checkBusquedaANivelNacional(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceSelect.selectZona(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceSelect.selectProvincia(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
        serviceSelect.selectOficina(scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false);
    }

    public void clickBtn(FieldByTagLabelText btnLabel, PanelTitle tabTitle, PanelTitle dialogTitle, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickBtn(
                tabTitle,
                dialogTitle,
                btnLabel,
                1,
                true,
                false
        );
    }

}
