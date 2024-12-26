package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class RiesgosTask extends BasePage {

    private RiesgosServiceClick serviceClick;
    private RiesgosServiceType serviceType;
    private RiesgosServiceSelect serviceSelect;
    private RiesgosServiceValidate serviceValidate;
    private RiesgosServiceDataBaseProcedure serviceDataBaseProcedure;
    private RiesgosServiceCheckbox serviceCheckbox;
    private RiesgosServiceDatePicker serviceDatePicker;

    private CommonServiceClick commonServiceClick;
    private GestionEmpresasClienteServiceType commonServiceType;
    private GestionEmpresasClienteServiceSelect commonServiceSelect;
    private GestionEmpresasClienteServiceValidate commonServiceValidate;
    private CommonService commonService;

    public RiesgosTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        commonServiceType = new GestionEmpresasClienteServiceType(driver);
        commonServiceValidate = new GestionEmpresasClienteServiceValidate(driver);
        commonServiceSelect = new GestionEmpresasClienteServiceSelect(driver);

        serviceClick = new RiesgosServiceClick(driver);
        serviceValidate = new RiesgosServiceValidate(driver);
        serviceType = new RiesgosServiceType(driver);
        serviceSelect = new RiesgosServiceSelect(driver);
        serviceDataBaseProcedure = new RiesgosServiceDataBaseProcedure(driver);
        serviceCheckbox = new RiesgosServiceCheckbox(driver);
        serviceDatePicker = new RiesgosServiceDatePicker(driver);
    }

    public void completeGestionPedidosBloqueadosSearchForm(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeEmpresa( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );

        serviceType.typeLimiteDeRiesgoDesde( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
        serviceType.typelimiteDeRiesgoHasta( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
        serviceType.typeNPedidoDesde( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
        serviceType.typeNPedidoHasta( 
                scn,
                page,
                null,
                file,
                2,
                false,
                true,
                true
        );
        serviceType.typeRiesgoPedidoDesde( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
        serviceType.typeRiesgoPedidoHasta( 
                scn,
                page,
                null,
                file,
                3,
                false,
                true,
                true
        );
        serviceDatePicker.pickDateFechaInicio( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
        serviceDatePicker.pickDateFechaFin( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
        serviceCheckbox.checkPedidosYaGestionados( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
        serviceSelect.selectProvinciaOficina( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );
        serviceSelect.selectOficina( 
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );

        //TODO; comprobar si hace falta indicar un campo observaciones en el buscador también
    }

    public void selectRecordFoundOnGestionPedidosBloqueadosTable(String scn, SystemPages page, String file) throws Exception {

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                null,
                file,
                "TestDatos->RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->TABLE",
                1,
                false
        );

        serviceCheckbox.checkSelectTableRecord();
        serviceClick.clickBtnDesbloquear(
                scn,
                page,
                null,
                file,
                1,
                false,
                true,
                true
        );

        serviceType.typeObservaciones( 
                scn,
                page,
                PanelTitle.DIALOG_DESBLOQUEODEPEDIDOS,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_DESBLOQUEODEPEDIDOS,
                FieldByTagLabelText.BTN_ACEPTAR,
                1,
                true,
                false
        );

        try {
            commonServiceValidate.validateModalTexto(ModalTitle.INFORMACION, "No se ha obtenido resultados de la búsqueda.");
            commonServiceClick.clickBtnCerrarModal();
        } catch (Exception e) {
            System.out.println("WARNING: Existen registros en la tabla");
        }
    }

}


