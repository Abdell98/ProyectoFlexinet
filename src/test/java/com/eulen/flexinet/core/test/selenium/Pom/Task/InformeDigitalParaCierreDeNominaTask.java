package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class InformeDigitalParaCierreDeNominaTask extends BasePage {

    private InformeDigitalParaCierreDeNominaServiceType serviceType;
    private InformeDigitalParaCierreDeNominaServiceCheckbox serviceCheckbox;
    private InformeDigitalParaCierreDeNominaServiceLookupField serviceLookupField;
    private InformeDigitalParaCierreDeNominaServiceClick serviceClick;
    private InformeDigitalParaCierreDeNominaServiceSelect serviceSelect;

    public InformeDigitalParaCierreDeNominaTask(WebDriver driver) {
        super(driver);
        serviceType = new InformeDigitalParaCierreDeNominaServiceType(driver);
        serviceCheckbox = new InformeDigitalParaCierreDeNominaServiceCheckbox(driver);
        serviceLookupField = new InformeDigitalParaCierreDeNominaServiceLookupField(driver);
        serviceClick = new InformeDigitalParaCierreDeNominaServiceClick(driver);
        serviceSelect = new InformeDigitalParaCierreDeNominaServiceSelect(driver);
    }

    public void lkpEmpresa(String scn, SystemPages page, String file) throws Exception {
        serviceLookupField.lkpEmpresa(scn, page, null, file, 1, false, true, true);
    }

    public void clickBtnDetalleColaborador() throws Exception {
        serviceClick.clickBtnDetalleColaborador();
    }

    public void ingresarDatosDelFormularioDeConsulta(String scn, SystemPages page, String file) throws Exception {
        serviceSelect.selectOficina(scn, page, null, file, 1, false, false, false);
        serviceType.typeAnio(scn, page, null, file, 1, false, false, false);
        serviceSelect.selectMes(scn, page, null, file, 1, false, false, false);
        serviceType.typeDniColaborador(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkExcluirGenerados(scn, page, null, file, 1, false, false, false);
        serviceLookupField.lkpEmpresa(scn, page, null, file, 1, false, true, true);
    }

    public void ingresarDatosTablaInformes(String scn, SystemPages page, String file) throws Exception {
        serviceCheckbox.checkTodosValidados(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeEmpresa(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeCodCli(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeIdCent(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeColaborador(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeNIF(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeSec(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeFInicio(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeFBaja(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeMotivoBaja(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeUndsSalarioNom(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeUndsSalarioFac(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeUndsSalarioTeorico(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeUndsExtra(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeUndsNocturnaNom(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeUndsNocturnaFac(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeUndsFestiva(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeConceptosN(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeConceptosF(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeNSalario(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeNImporte(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeNSExtra(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeNSNoct(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeNSFest(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeFSalario(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeFImporte(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeFPVPExtra(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeFPVPNoct(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeFPVPFest(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeFecGeneracion(scn, page, null, file, 1, false, false, false);
        serviceType.typeQbeContrato(scn, page, null, file, 1, false, false, false);
    }

    public void ingresarDatosDetalleColaborador(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeNomina(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeNomina(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 2, false, false, false);
        serviceType.typePermisoRetribuido(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbeConcepto(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbeConcepto(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 2, false, false, false);
        serviceType.typeQbeTipo(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbeCoef(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbeDevengo(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbeDevengo(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 2, false, false, false);
        serviceType.typeQbeUnds(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbeUnds(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 2, false, false, false);
        serviceType.typeQbeImporte(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbePrecio(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbeTotal(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceType.typeQbeTotal(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 2, false, false, false);
        serviceType.typeQbeC(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
    }

    public void activarCheck(String scn, SystemPages page, String file) throws Exception {
        serviceCheckbox.checkDiferencia(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
        serviceCheckbox.checkValidado(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, false, false);
    }

    public void clickBtnCerrarAviso() throws Exception {
        serviceClick.clickBtnCerrarAviso();
    }

    public void ModificarHorasExtras(String scn, SystemPages page, String file) throws Exception {
        serviceLookupField.lkpHorasExtras(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, true, true);
    }

    public void ModificarHorasFestiva(String scn, SystemPages page, String file) throws Exception {
        serviceLookupField.lkpHorasFestiva(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, true, true);
    }

    public void SeleccionarConcepto(String scn, SystemPages page, String file) throws Exception {
        serviceLookupField.lkpConcepto(scn, page, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file, 1, false, true, true);
    }
}


