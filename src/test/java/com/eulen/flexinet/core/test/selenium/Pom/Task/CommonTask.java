package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CommonTask extends BasePage {

    private PedidosServiceClick serviceClick;
    private PedidosServiceType serviceType;
    private PedidosServiceSelect serviceSelect;
    private PedidosServiceValidate serviceValidate;
    private PedidosServiceDataBaseProcedure serviceDataBaseProcedure;
    private PedidosServiceDragAndDrop serviceDragAndDrop;
    private PedidosServiceCheckbox serviceCheckbox;
    private PedidosServiceDatePicker serviceDatePicker;
    private PedidosServiceLookupField serviceLookupField;

    private CommonServiceClick commonServiceClick;
    private GestionEmpresasClienteServiceType commonServiceType;
    private GestionEmpresasClienteServiceSelect commonServiceSelect;
    private CommonServiceValidate commonServiceValidate;
    private CommonService commonService;

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;

    public CommonTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        //commonServiceClick = new GestionEmpresasClienteServiceClick(driver);
        commonServiceClick = new CommonServiceClick(driver);
        commonServiceType = new GestionEmpresasClienteServiceType(driver);
        commonServiceValidate = new CommonServiceValidate(driver);
        commonServiceSelect = new GestionEmpresasClienteServiceSelect(driver);

        serviceClick = new PedidosServiceClick(driver);
        serviceValidate = new PedidosServiceValidate(driver);
        serviceType = new PedidosServiceType(driver);
        serviceSelect = new PedidosServiceSelect(driver);
        serviceDataBaseProcedure = new PedidosServiceDataBaseProcedure(driver);
        serviceDragAndDrop = new PedidosServiceDragAndDrop(driver);
        serviceCheckbox = new PedidosServiceCheckbox(driver);
        serviceDatePicker = new PedidosServiceDatePicker(driver);
        serviceLookupField = new PedidosServiceLookupField((driver));

        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    public void clickBtnBuscar() throws Exception {
        commonServiceClick.clickBtnBuscar();
    }

    public void clickBtnModificar() throws Exception {
        commonServiceClick.clickBtn(
                null,
                null,
                FieldByTagLabelText.BTN_MODIFICAR,
                1,
                true,
                true
        );
    }

    public void clickBtnGenerarContratos() throws Exception {
        commonServiceClick.clickBtn(
                null,
                null,
                FieldByTagLabelText.BTN_GENERARCONTRATOS,
                1,
                true,
                true
        );
    }

    public void waitToAccessPage(SystemPages page) throws Exception {
        commonServiceValidate.waitToAccessPage(page);
    }


    public void clickBtnOK(PanelTitle tabTitle, PanelTitle dialogTitle) throws Exception {
        commonServiceClick.clickBtn(
                tabTitle,
                dialogTitle,
                FieldByTagLabelText.BTN_OK,
                1,
                true,
                true
        );
    }

    public void clickBtn(FieldByTagLabelText btnLabel, PanelTitle tabTitle, PanelTitle dialogTitle, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickBtn(
                tabTitle,
                dialogTitle,
                btnLabel,
                1,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void clickTab(String tabTitle) throws Exception {
        commonServiceClick.clickTab(tabTitle);
    }

    /**
     * Este metodo hace click en el primer resultado de la tabla que coincida, si existe mas de una hay que añadir la página en la definicion del metodo en el commonService
     * RECORDAR que el formato para el jsonObjectPath es separar los elementos por puntos
     * @param scn
     * @param page
     * @param dialogTitle
     * @param file
     * @param jsonObjectPath
     * @param cajaNumero
     * @param isUnderDialog
     * @throws Exception
     */
    public void clickFirstValidRowResultOnTable(String scn, SystemPages page, PanelTitle dialogTitle, String file, String jsonObjectPath, int cajaNumero, boolean isUnderDialog) throws Exception {
        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                dialogTitle,
                file,
                jsonObjectPath,
                cajaNumero,
                isUnderDialog
        );
        commonService.waitUntilSpinnerIsNotDisplayed();
    }

    public void doScreenshot(String title) throws IOException {
        commonService.doScreenshot(title);
    }

    //FIXME @Roger no es correcto que llamemos a page locators desde un task, crear un service y llamar al service desde el task
    public void validatePager(String file) throws Exception {
        jsonFileNew(file);
        String xpath= "//table[@class=\"undefined\"]//tbody/tr[@class=\"ui-widget-content ui-datatable-even\" or @class=\"ui-widget-content ui-datatable-odd\"]";
        commonService.clickBtnPagerNex(true,true);
        commonService.selectPager(pageLocators.getSelectPager(),datosFacturacion.getFacturacionConsulta().getTable().getSelectPager(),false,true,true);
        commonService.validatePagerRows(xpath,datosFacturacion.getFacturacionConsulta().getTable().getValidateNumRows(),false,true,true);
    }


    public void clickBtnCerrarModal() throws Exception {
        commonServiceClick.clickBtnCerrarModal();
    }

    public void clickBtnCerrarDialog(PanelTitle dialogTitle) throws Exception {
        commonServiceClick.clickBtnCerrarDialog(dialogTitle);
    }

    public void validateDialogVisible(PanelTitle dialogTitle) throws Exception {
        commonServiceValidate.validateDialogVisible(dialogTitle);
    }

    public void validateDialogMessage(PanelTitle dialogTitle, String patternMessage, boolean cerrarDialog, String file) throws Exception {
        commonServiceValidate.validateDialogMessage(dialogTitle, patternMessage, file);
        if(cerrarDialog) {
            commonServiceClick.clickBtnCerrarDialog(dialogTitle);
        }
    }

    public String getNombreColaborador(SystemPages page, String file) throws Exception {
        jsonFileNew(file);
        String nombre = null;
        String apellido1 = null;
        String apellido2 = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                nombre = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                apellido1 = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                apellido2 = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                break;
            case PEDIDOS__ALTA_LV3233:
                nombre = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                apellido1 = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                apellido2 = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
                break;
            default:
                nombre = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                apellido1 = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                apellido2 = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                break;
        }

        return nombre + " " + apellido1 + " " + apellido2;
    }

    //TODO: ver de unificar los siguientes metodos validateGrowlMessage y waitGrowlMessage
    /**
     * Este metodo espera a que aparezca la notifiación indicada, podemos decir que valide si aparece el spinner y espere para continuar con la validacion
     * @param growlTitle
     * @param patternMessage
     * @param waitForSpinnerBeforeValidation
     * @throws Exception
     */
    public void validateGrowlMessage(ModalTitle growlTitle, String patternMessage, Boolean waitForSpinnerBeforeValidation, boolean cerrarModal, boolean hacerScreenShot) throws Exception {
        if(waitForSpinnerBeforeValidation) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }
        commonServiceValidate.validateGrowlMessage(growlTitle, patternMessage, cerrarModal, hacerScreenShot);
    }

    //TODO: ver de unificar los siguientes metodos validateGrowlMessage y waitGrowlMessage
    /**
     * Este metodo espera a que aparezca la notifiación indicada, podemos decir que valide si aparece el spinner y espere para continuar con la validacion
     * @param growlTitle
     * @param patternMessage
     * @param waitForSpinnerBeforeValidation
     * @throws Exception
     */
    public void validateGrowlMessageFile(ModalTitle growlTitle, String patternMessage, Boolean waitForSpinnerBeforeValidation, String file, boolean cerrarModal, boolean hacerScreenShot) throws Exception {
        jsonFileNew(file);

        if(waitForSpinnerBeforeValidation) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }
        commonServiceValidate.validateGrowlMessage(growlTitle, patternMessage, cerrarModal, hacerScreenShot);
    }


    public void waitForGrowlNotifToBeVisible(ModalTitle growlTitle, String patternMessage, Boolean waitForSpinnerBeforeValidation, boolean cerrarModal, boolean hacerScreenShot) throws Exception {
        if(waitForSpinnerBeforeValidation) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }
        commonServiceValidate.waitForGrowlNotifToBeVisible(growlTitle, patternMessage, cerrarModal, hacerScreenShot);
    }
}
