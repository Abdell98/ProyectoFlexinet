package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GestionITsTask extends BasePage {

    private GestionITsServiceClick serviceClick;
    private GestionITsServiceType serviceType;
    private GestionITsServiceCheckbox serviceCheckbox;
    private GestionITsServiceDatePicker serviceDatePicker;
    private GestionITsServiceSelect serviceSelect;
    private GestionITsServiceLookupField serviceLookupField;
    private GestionITsServiceValidate serviceValidation;
    private GestionITsServiceDataBaseProcedure serviceDataBaseProcedure;
    private CommonServiceClick commonServiceClick;
    private CommonService commonService;

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;

    public GestionITsTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        serviceClick = new GestionITsServiceClick(driver);
        serviceType = new GestionITsServiceType(driver);
        serviceCheckbox = new GestionITsServiceCheckbox(driver);
        serviceDatePicker = new GestionITsServiceDatePicker(driver);
        serviceLookupField = new GestionITsServiceLookupField((driver));
        serviceValidation = new GestionITsServiceValidate(driver);
        serviceDataBaseProcedure = new GestionITsServiceDataBaseProcedure(driver);
        serviceSelect = new GestionITsServiceSelect(driver);

        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    public void completeFieldsGestionITs(String scn, SystemPages page, String file) throws Exception {

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

        serviceLookupField.lkpNif(
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
    }

    public void completeFieldsAniadirIT(String scn, SystemPages page, String file) throws Exception {
        serviceDatePicker.pickDateDesdeIT( scn, page, PanelTitle.DIALOG_ALTADEIT,
                file, 1, false,
                false, false);
        serviceDatePicker.pickDateHastaIT(scn, page, PanelTitle.DIALOG_ALTADEIT,
                file, 1, false,
                false, false);
        serviceSelect.selectTipoIT(scn, page, PanelTitle.DIALOG_ALTADEIT,
                file, 1, false,
                false, false);
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
    public void clickBtnBorrarIT() throws Exception {
        waitUntilBeClickable(pageLocators.getBtnBorrarIT());
        click(pageLocators.getBtnBorrarIT());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void rellenarFechaYFiltrarTabla(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeQbeNParte(
                scn,
                page,
                null,
                file,
                1,
                false,
                false,
                false
        );
        commonServiceClick.sendEnterOnQbeFilter( null, FieldByTagLabelText.QBE_MES, 1 );
    }

    public void comprobarTraspasado(String file) throws Exception {
        serviceCheckbox.isTrapasadoChecked(file);
    }
}
