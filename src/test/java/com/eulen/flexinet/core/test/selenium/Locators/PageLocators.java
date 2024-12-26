package com.eulen.flexinet.core.test.selenium.Locators;

import com.eulen.flexinet.core.test.selenium.Pom.pom.PageObjectBase;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class PageLocators extends PageObjectBase {

    WebDriver driver;
    BasePage basePage;

    public PageLocators(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.basePage = new BasePage(driver);
    }


    @FindBy(xpath = "//form//*[@id='cifBuscar']//following-sibling::button[@icon='fa-search']")
    private WebElement btnLupaCif;

    @FindBy(xpath = "//following-sibling::button[@icon='fa-search' and contains(@class, 'ui-button-icon-only')]")
    private WebElement btnLupa;

    @FindBy(xpath = "//p-dialog[contains(@header,'Seleccione Empresa')]//div[contains(@class,'dialogResponsiveSize')]")
    private WebElement dialogSeleccioneEmpresa;

    @FindBy(xpath = "//p-dialog[contains(@header,'Seleccione Empresa')]//div[contains(@class,'dialogResponsiveSize')]//label[text()='Razón Social: ']//following::input[1]")
    private WebElement inputRazonSocialDialogSeleccioneEmpresa;

    @FindBy(xpath = "//p-dialog[contains(@header,'Seleccione Empresa')]//button[@icon='fa-search']")
    private WebElement btnBuscarEmpresaModalSeleccioneEmpresa;

    @FindBy(xpath = "//p-dialog//p-datatable//table")
    private WebElement dialogTable;

    @FindBy(xpath = "//dialog-colaborador-perfil//p-dialog//p-datatable//table")
    private WebElement dialogTableColaboradorPerfil;

    @FindBy(xpath = "//dialog-perfil-dato-unico")
    private WebElement dialogPerfilDatoUnico;

    //Buscar botón + en la consulta de Prorrogas
    @FindBy(xpath = "//*[@class='ui-datatable-tablewrapper']/table/tbody/tr/td/span/button")
    private WebElement btnMas;
    //@Pedidos @AltaSimple
    @FindBy(xpath = "//p-dialog[contains(@header,'Selección de Empresa')]//div[contains(@class,'dialogResponsiveSize')]")
    private WebElement dialogSeleccionDeEmpresa;

    //@Pedidos @AltaSimple
    @FindBy(xpath = "//p-dialog[contains(@header,'Selección de Empresa')]//div[contains(@class,'dialogResponsiveSize')]//label[normalize-space(.)='Empresa:']//following::input[1]")
    private WebElement inputEmpresaDialogSeleccionDeEmpresa; //TODO: borrar si funciona con el getFieldByTab nuevo

    @FindBy(xpath = "//p-dialog[contains(@header,'Seleccione Empresa')]//button[contains(@label,'Aceptar')]")
    private WebElement btnAceptarModalSeleccioneEmpresa;

    @FindBy(xpath = "//*[contains(@class,'cajaFormularios')][1]//button[@label='Obtener Datos']")
    private WebElement btnObtenerDatos;

    @FindBy(xpath = "//*[contains(@class,'cajaFormularios')][4]//button[@label='Enviar a Riesgos']")
    private WebElement btnEnviarARiesgos;

    @FindBy(xpath = "//p-dialog//div[contains(@style,'display: block')]//button[@label='Sí']")
    private WebElement btnYesEnviarARiesgos;

    @FindBy(xpath = "//p-dialog//div[contains(@style,'display: block')]//button[@label='No']")
    private WebElement btnNoModalEnviarARiesgos;

    @FindBy(xpath = "//button[contains(@label,'Modificar Centro de Trabajo') and not(ancestor::p-dialog)]")
    private WebElement btnModificarCentroDeTrabajo;

    @FindBy(xpath = "//p-dialog//div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and text()='Envío de Datos a Riesgos']")
    private WebElement tituloVentanaModalEnviarARiesgos;

    @FindBy(xpath = "//p-growl//div[contains(@class,'ui-growl-icon-close')]")
    private WebElement btnCerrarModal;

    /*** Consulta ***/
    @FindBy(xpath = "//button[contains(@label,'Buscar') and not(ancestor::p-dialog)]")
    private WebElement btnBuscar;

    @FindBy(xpath = "//div[contains(@class,'botonesFueraFormulario')]//button[contains(@label,'Ver Empresa')]")
    private WebElement btnVerEmpresa;

    @FindBy(xpath = "//div[contains(@class,'botonesFueraFormulario')]//button[contains(@label,'Modificar Empresa')]")
    private WebElement btnModificarEmpresa;

    //TODO: borrar estos si la expresion siguiente funciona bien.
    /*@FindBy(xpath = "//p-datatable//table")
    private WebElement table;*/

    @FindBy(xpath = "(//p-datatable[not(ancestor::p-dialog)]//table)")
    private WebElement table;

    @FindBy(xpath = "//*[@class='cajaResultados']//p-datatable//table")
    private WebElement tableCajaResultados;


    @FindBy(xpath = "//button[contains(@label,'Guardar')]")
    private WebElement btnGuardar;

    /*** GestionClientesContratoAlta ***/
    @FindBy(xpath = "//button[contains(@label,'Alta Cliente Contrato') and not (@disabled)]")
    private WebElement btnAltaClienteContrato;

    @FindBy(xpath = "//button[contains(@label,'Modificación')]")
    private WebElement btnModificacion;

    /*** GestionCentrosDeTrabajoAlta ***/
    @FindBy(xpath = "//button[contains(@label,'Alta Centro de Trabajo')]")
    private WebElement btnAltaCentroDeTrabajo;

    /*** General ***/

    //@Pedidos
    @FindBy(xpath = "//p-tabpanel[contains(@header, 'Datos del Pedido')]//button[contains(@label,'Buscar Empresa') and not(ancestor::p-dialog)]")
    private WebElement btnBuscarEmpresa;

    @FindBy(xpath = "//p-dialog[@header='Selección de Empresa']//button[contains(@label,'Buscar')]")
    private WebElement btnBuscarDialog;

    @FindBy(xpath = "//p-dialog[@header='Selección de Empresa']//button[contains(@label,'Asociar a Empresa')]")
    private WebElement btnAsociarAEmpresaDialog;

    @FindBy(xpath = "//p-growl//span[contains(@class,'ui-growl-title') and contains(text(),'Información')]")
    private WebElement msgInfo;

    @FindBy(xpath = "//p-growl//div[contains(@class,'ui-growl-item')]//*[contains(@class,'ui-growl-message')]//*[contains(text(),'El cambio de provincia puede acarrear el borrado de ciertas categorías laborales profesionales')]")
    private WebElement msgProvinceChange;

    @FindBy(xpath = "//p-growl//span[contains(@class,'ui-growl-title') and contains(text(),'Error')]")
    private WebElement msgError;

    @FindBy(xpath = "//p-growl//span[contains(@class,'ui-growl-title') and contains(text(),'Aviso')]")
    private WebElement msgAviso;

    @FindBy(xpath = "//p-growl//span[contains(@class,'ui-growl-title') and contains(text(),'Atención')]")
    private WebElement msgAtencion;

    @FindBy(xpath = "//p-dialog[@header='Estado del Pedido']//p[@class='mensajeConSaltoLinea' and contains(text(),'El pedido con ID 604795068 ha sido bloqueado por Riesgos')]")
    private WebElement msgEstadoDelPedido;

    @FindBy(xpath = "//td/span[normalize-space(.)='Selecc.']//following-sibling::span")
    private WebElement selectCheckFromRecordTable;

    @FindBy(xpath = "//p-dialog[@header='Solicitud de Fecha de Alta del Contrato']//p-calendar//input")
    private WebElement pickDateIntroduzcaFechaAntiguedadContrato;

    @FindBy(xpath = "(//p-datatable//table//button[contains(@icon,'fa-plus')])[1]")
    private WebElement btnDetalleColaborador;

    @FindBy(xpath = "//*[@id=\"wrap\"]/div/p-growl/div/div/div/div[1]")
    private WebElement btnCerrarAviso;

    @FindBy(xpath = "//*[@id=\"wrap\"]/div/p-dialog[2]/div/div[2]/div[1]/div[2]/div[2]/button")
    private WebElement btnLupaUnidadesExtra;

    @FindBy(xpath = "//*[@id=\"wrap\"]/div/p-dialog[2]/div/div[2]/div[1]/div[2]/div[4]/button")
    private WebElement btnLupaUnidadesFestiva;

    @FindBy(xpath = "//span[contains(text(), 'Borrar IT')]")
    private WebElement btnBorrarIT;

    // Paginador
    @FindBy(xpath = "//*[@id=\"wrap\"]/div/div/div[3]/div/p-datatable/div/p-paginator/div/a[3]")
    private WebElement btnPagerNex;

    @FindBy(xpath = "//*[@id=\"wrap\"]/div/div/div[3]/div/p-datatable/div/p-paginator/div/select")
    private WebElement selectPager;

    @FindBy (xpath = "//div[contains(@class, 'cajaResultados')]//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")
    private List<WebElement> checkboxex;

    @FindBy (xpath = "//div[contains(@class, 'cajaResultados')]//div[@class=\"ui-chkbox-box ui-widget ui-corner-all ui-state-default\"]")
    private List<WebElement> checkboxes;

    @FindBy (xpath = "//div[contains(@class, 'cajaResultados')]//div[@class=\"ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-disabled\"]")
    private List<WebElement> checkBoxDisabled;
    //CUSTOM GET LOCATORS
    //TODO: Ver de pasar los metodos get custom a una clase independiente y en esta solo mantener los FindBy de pageFactory

    /**
     * Este metodo obtiene el WebElement de una tabla en la página siempre que esta no esté dentro de un dialogo
     * @param tablaNumero
     * @return
     */
    public WebElement getTable(int tablaNumero) {
        String cajaNumero = "[" + tablaNumero + "]";
        WebElement field = null;
        String xpath = "(//p-datatable[not(ancestor::p-dialog)]//table)"+cajaNumero;
        field = driver.findElement(By.xpath(xpath));
        return field;
    }

    /**
     * Este metodo obtiene el WebElement de una tabla que está dentro de un dialogo
     * @param dialogTitle
     * @param tablaNumero
     * @return
     * @throws Exception
     */
    public WebElement getDialogTable(PanelTitle dialogTitle, int tablaNumero) throws Exception {
        String cajaNumero = "[" + tablaNumero + "]";
        //TODO 16/05/2024  [#dialogxpath] ajustado nuevo xpath para dialogo falta probar y borrar el comentado antiguo.
        //String xpath = "//p-dialog[contains(@header,'"+dialogTitle.getValue()+"')]//p-datatable//table";
       // String dialogHeader1 = "(//p-dialog[contains(@header,'"+dialogTitle.getValue()+"')]//p-datatable//table)"+cajaNumero;
        String dialogHeader2 = "((//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+dialogTitle.getValue()+"')]/ancestor::p-dialog/div[contains(@style,'display: block')])//p-datatable//table)"+cajaNumero;
        //String xpath = "("+dialogHeader1 + "|" + dialogHeader2 +")";
        //TODO 09/12/2024 @Abdel  dialogHeader2 se usa en TestDatosContratos->CONTRATOS__ALTA_SUSTITUCION->DIALOG_SELECCIONDECOLABORADORES->TABLE
        String xpath = "(" + dialogHeader2 +")";
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * Este metodo obtiene el WebElement de una celda en particular de una tabla, para luego en un service poder actuar sobe ella.
     * @param tabOrDialogTitle
     * @param nombreColumna
     * @param filaNumero numero de la fila empezando por 1
     * @param tablaNumero
     * @return
     * @throws Exception
     */
    public WebElement getTableCell(PanelTitle tabOrDialogTitle, String nombreColumna, int filaNumero, int tablaNumero) throws Exception {
        String cajaNumero = "[" + tablaNumero + "]";
        WebElement table;
        String xpath = "";
        String tabPanelAux = "";

        if (tabOrDialogTitle == null) {
            tabPanelAux = "";
            xpath = "(" + tabPanelAux + "//p-datatable//table)"+cajaNumero;
        } else if (tabOrDialogTitle.toString().startsWith("DIALOG_")) {
            //TODO 16/05/2024  [#dialogxpath] ajustado nuevo xpath para dialogo falta probar y borrar el comentado antiguo.
//            tabPanelAux = "//p-dialog[@header='" + tabOrDialogTitle.getValue() + "']";
//            xpath = "(" + tabPanelAux + "//p-datatable//table)["+tablaNumero+"]";
            String dialogHeader1 = "(//p-dialog[contains(@header,'"+ tabOrDialogTitle.getValue() +"')]//p-datatable//table)"+cajaNumero;
            String dialogHeader2 = "((//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+ tabOrDialogTitle.getValue() +"')]/ancestor::p-dialog/div[contains(@style,'display: block')])//p-datatable//table)"+cajaNumero;
            xpath = "("+dialogHeader1 + "|" + dialogHeader2 +")";
        } else {
            tabPanelAux = "//p-tabpanel[@header='" + tabOrDialogTitle.getValue() + "']";
            xpath = "(" + tabPanelAux + "//p-datatable//table)"+cajaNumero;
        }

        table = driver.findElement(By.xpath(xpath));

        final WebElement[] celda = new WebElement[1]; //esto es para poder pasar la variable a la expresion lambda forEach

        BasePage page = new BasePage(driver);
        page.tableExtractorToWebElement(table).forEach((rowkey, rowvalue) -> {
            rowvalue.forEach((cellkey,cellvalue) -> {
                if(rowkey.equals(filaNumero-1) && cellkey.equals(nombreColumna)) { //INFO: filaNumeo -1 lo añadimos para que al llamar al metodo poder indicar fila 1 como primera fila de la tabla y no 0
                    celda[0] = cellvalue;
                }
            });
        });
        if(celda[0] != null) {
            return celda[0];
        } else {
            throw new NotFoundException("ERROR: No hay ninguna celda en la combinación:\n fila `"+filaNumero+"`,columna `" + nombreColumna);
        }
    }

    //TODO: @DEPRECAR deprecar y su uso cambiarlo por getTableCell
    public By getFirtElementTableByXpath(String message){
        String xpath = "";
        xpath = "//tbody/tr/td/span[contains(text(), 'Fec. Fin')]/following-sibling::span";
        return By.xpath(xpath);
    }

    /**
     * Este metodo sirve para generar un objecto By.xpath de un mensaje dentro de un dialogo, para usarlo por un servicio
     * @param panelTitle
     * @param message
     * @return
     * TODO UPDATED: 12/06/2024 falta probar, ahora con el mismo metodo retornamos el dialogo por el titulo, o por titulo y mensaje depende si viene o no vacio el mensaje o el titulo
     */
    public By getDialogMsgByXpath(PanelTitle panelTitle, String message) {
        String xpath = "";
        if(message.isEmpty()) {
            xpath = "(//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+ panelTitle.getValue() +"')]/ancestor::p-dialog/div[contains(@style,'display: block')])";
            return By.xpath(xpath);
        } else {
            if (panelTitle == null) {
                xpath = "//p[contains(text(),'" + message + "')]";
            } else if (panelTitle.toString().startsWith("DIALOG_")) {
                //TODO revisar la clase que miramos ui-dialog-title, no parece correcto.
                xpath = "((//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'" + panelTitle.getValue() + "')]/ancestor::p-dialog/div[contains(@style,'display: block')])//div[contains(@class,'ui-dialog-content')]//*[contains(text(),'" + message + "')])|((//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'" + panelTitle.getValue() + "')]/ancestor::p-dialog/div[contains(@style,'display: block')])//span[contains(normalize-space(.),'" + message + "')])";
            } else {
                xpath = "//p-tabpanel[@header='" + panelTitle.getValue() + "']//label[@class='spanNoRequerido labelNormal'][1]";
            }
            return By.xpath(xpath);
        }
    }

    /**
     * Este metodo genera un objeto de tipo By.xpath del titulo del dialogo indicado, para ser usado por algun servicio
     * @param dialogTitle
     * @return
     */
    public By getDialogTitleByXpath(PanelTitle dialogTitle) {
        //TODO 16/05/2024  [#dialogxpath] ajustado nuevo xpath para dialogo falta probar y borrar el comentado antiguo.
        //String xpath = "(//p-dialog//div[contains(@style,'display: block')]//span[@class='ui-dialog-title' and text()='" + dialogTitle.getValue() + "'])";
        String xpath = "(//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+ dialogTitle.getValue() +"')]/ancestor::p-dialog/div[contains(@style,'display: block')])";
        return By.xpath(xpath);
    }

    /**
     * Este metodo devuelve un objeto de tipo By.xpath del botón cerrar de un dialogo, para usarlo en algun servicio
     * @param dialogTitle
     * @return
     */
    public By getDialogCerrarByXpath(PanelTitle dialogTitle) {
        //TODO 16/05/2024  [#dialogxpath] ajustado nuevo xpath para dialogo falta probar y borrar el comentado antiguo.
        //String xpath = "(//p-dialog//div[contains(@style,'display: block')]//span[@class='ui-dialog-title' and text()='" + dialogTitle.getValue() + "'])//following-sibling::a[contains(@class,'ui-dialog-titlebar-close')]";
        String xpath = "(//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+ dialogTitle.getValue() +"')]/ancestor::p-dialog/div[contains(@style,'display: block')])//following-sibling::a[contains(@class,'ui-dialog-titlebar-close')]";
        return By.xpath(xpath);
    }


    /**
     * Este metodo retorna un By.xpath del mensaje de una notificación que tenga titulo Información
     * @return
     */
    public By getMsgInfoByXpath() {
        return By.xpath("//p-growl//div[contains(@class,'ui-growl-item')]//*[contains(@class,'ui-growl-message')]//*[contains(text(),'Información')]");
    }

    /**
     * Este metodo retorna un By.xpath del mensaje de una notificación que tenga titulo Error
     * @return
     */
    public By getMsgErrorByXpath() {
        return By.xpath("//p-growl//div[contains(@class,'ui-growl-item')]//*[contains(@class,'ui-growl-message')]//*[contains(text(),'Error')]");
    }

    //TODO El siguiente metodo creo que hay que deprecarlo por los nuevos validationGrowl revisar...
    /**
     * Este metodo retorna un WebElement del texto dentro de una notifiación de Información
     * @param title
     * @param message
     * @return
     * @throws Exception
     */
    public WebElement getTextoModalInformacion(ModalTitle title, String message) throws Exception {
        WebElement field = null;
        String xpath = "//p-growl//span[contains(@class,'ui-growl-title') and text()='" + title.getTitle() + "']/following::p[contains(text(),'" + message + "')]";
        field = driver.findElement(By.xpath(xpath));
        return field;
    }

    /**
     * UPDATED: 12/06/2024
     * @param title
     * @param message
     * @return
     * @throws Exception
     */
    public By getModalByXpath(ModalTitle title, String message) {
        if (message == null || message.isEmpty()) {
            return By.xpath("//p-growl//span[contains(@class,'ui-growl-title') and text()='" + title.getTitle() + "']");
        } else {
            return By.xpath("//p-growl//span[contains(@class,'ui-growl-title') and text()='" + title.getTitle() + "']/following::p[contains(text(),'" + message + "')]");
        }
    }

    /**
     * Este metodo retorna un objeto By.xpath de un mensaje en una notificación, siempre que NO SEA el mensaje que le pasemos, util para validaciones ver usos.
     * @param title
     * @param message
     * @return
     */
    public By getModalNotContainsMsgByXpath(ModalTitle title, String message) {
        return By.xpath("//p-growl//div[contains(@class,'ui-growl-item')]//*[contains(@class,'ui-growl-message')]//*[contains(text(),'" + title.getTitle() + "')]/following-sibling::p[not(contains(text(),'" + message + "'))]");
    }


    /**
     * Este metodo retorna un WebElement de un un campo indicado según los parametros facilitados
     * @param tabOrDialogTitle
     * @param tagLabelText
     * @param fieldtype
     * @param numeroOrdenCaja
     * @return
     * @throws Exception
     */
    public WebElement getField(PanelTitle tabOrDialogTitle, FieldByTagLabelText tagLabelText, FieldType fieldtype, Integer numeroOrdenCaja) throws Exception {
        WebElement field = null;
        String xpath = "";
        String cajaNum = "";
        String tabPanelAux = "";

        if (numeroOrdenCaja != null) {
            cajaNum = "[" + numeroOrdenCaja + "]";
        }

        if (!fieldtype.equals(FieldType.draganddrop) && !fieldtype.equals(FieldType.checkboxgroup)) {
            if (tabOrDialogTitle == null) {
                tabPanelAux = "";
                xpath = "(" + tabPanelAux + "//label[normalize-space(.)='" + tagLabelText.getCodigo() + "' and not(ancestor::p-dialog)])" + cajaNum;
            } else if (tabOrDialogTitle.toString().startsWith("DIALOG_")) {
                //TODO: [#dialogxpath] ajustado nuevo xpath para dialogo falta probar y borrar el comentado antiguo.
                //tabPanelAux = "//p-dialog[@header='" + tabOrDialogTitle.getValue() + "']";
//                xpath = "(" + tabPanelAux + "//label[normalize-space(.)='" + tagLabelText.getCodigo() + "'])" + cajaNum;
                String dialogHeader1 = "(//p-dialog[contains(@header,'"+tabOrDialogTitle.getValue()+"')]//label[normalize-space(.)='" + tagLabelText.getCodigo() + "'])"+cajaNum;
                String dialogHeader2 = "((//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/ancestor::p-dialog/div[contains(@style,'display: block')])//label[normalize-space(.)='" + tagLabelText.getCodigo() + "'])"+cajaNum;
                xpath = "("+dialogHeader1 + "|" + dialogHeader2 +")";
            } else {
                tabPanelAux = "//p-tabpanel[@header='" + tabOrDialogTitle.getValue() + "']";
                xpath = "(" + tabPanelAux + "//label[normalize-space(.)='" + tagLabelText.getCodigo() + "' and not(ancestor::p-dialog)])" + cajaNum;
            }
        }

        String xpathFinal = "";
        switch (fieldtype) {
            case checkboxinput:
            case datepicker:
            case input:
//                //INFO: este if lo añado con el nuevo xpath, dado que en el ALta Partes de horas > Concepto COlaborador > Dialogo Alta Concepto el elemento p-dialog no tiene header
//                if(tabOrDialogTitle != null && tabOrDialogTitle.equals(PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA)) {//TODO @PRE
//                    //TODO probar primero y borrar el xpath comentado si el nuevo funciona relacionado con [#dialogxpath]
//                    //xpathFinal = "//span[contains(@class,'ui-dialog-title') and contains(text(),'" + tabOrDialogTitle.getValue() + "')]/parent::div/following-sibling::div[1]//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::div/following-sibling::div[1]/input";
//                    xpathFinal = "(//p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/parent::div/following-sibling::div[1]//label[normalize-space(.)='"+tagLabelText.getCodigo()+"']/parent::div/following-sibling::div)"+cajaNum+"/input";
//                } else {
//                    xpathFinal = xpath + "/following::input[1]";
//                }
                xpathFinal = xpath + "/following::input[1]";
                break;
            case input2:
                xpathFinal = xpath + "/following::input[2]";
                break;
            case textarea:
                xpathFinal = xpath + "/following::textarea[1]";
                break;
            case label:
                xpathFinal = xpath + "/following::label[1]";
                break;
            case select:
                //INFO: este if lo añado con el nuevo xpath, dado que en el ALta Partes de horas > Concepto COlaborador > Dialogo Alta Concepto el elemento p-dialog no tiene header
//                if(tabOrDialogTitle != null && tabOrDialogTitle.equals(PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA)) {//TODO @PRE
//                    xpathFinal = "(//p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/parent::div/following-sibling::div[1]//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::div/following-sibling::div/p-dropdown";
//                } else {
//                    xpathFinal = xpath + "/following::p-dropdown[1]";
//                }
                xpathFinal = xpath + "/following::p-dropdown[1]";
                break;
            case selectalt:
                xpathFinal = xpath;
                break;
            case checkbox:
                //INFO: este if lo añado con el nuevo xpath, dado que en el ALta Partes de horas > Concepto COlaborador > Dialogo Alta Concepto el elemento p-dialog no tiene header
//                if(tabOrDialogTitle != null && tabOrDialogTitle.equals(PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA)) {//TODO @PRE
//                    //TODO probar nuevo xpath y borrar el comentario si no es necesario, relacionado con [#dialogxpath]
//                    //xpathFinal = "(//p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/parent::div/following-sibling::div[1]//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::div/following-sibling::div[1]/p-checkbox/div";
//                    //xpathFinal = "//p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/ancestor::p-dialog//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::p-checkbox/div";
//                    xpathFinal = "(//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/ancestor::p-dialog/div[contains(@style,'display: block')])//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::p-checkbox/div";
//                } else {
//                    xpathFinal = xpath + "/preceding-sibling::div[1]";
//                }
                xpathFinal = xpath + "/preceding-sibling::div[1]";
                break;
            case checkboxgroup:
                tabPanelAux = "//p-tabpanel[@header='" + tabOrDialogTitle.getValue() + "']";
                if (numeroOrdenCaja != null) {
                    xpathFinal = "((" + tabPanelAux + "//label[normalize-space(.)='" + tagLabelText.getCodigo() + "' and not(ancestor::p-dialog)])/parent::div/following-sibling::div//p-checkbox/div)[" + (numeroOrdenCaja + 1) + "]";
                } else {
                    throw new Exception("ERROR: Algun checkbox ha tomado un valor nulo revisar automatización");
                }
                break;
            case draganddrop:
                xpathFinal = "(//p-tabpanel//div[contains(@class,'cabeceraDragDrop') and contains(text(),'" + tagLabelText.getCodigo() + "')]//following-sibling::div[contains(@class,'contenedorDragDrop')])";
                break;
            case radio:
                xpathFinal = xpath + "/parent::p-radiobutton//div[contains(@class,'ui-radiobutton-box')]";
                break;
        }

        if (fieldtype.equals(FieldType.checkbox)) {
            try {
                field = driver.findElement(By.xpath(xpathFinal));
            } catch (NotFoundException e1) {
                try {
                    xpathFinal = xpath + "/following::div[1]";
                    field = driver.findElement(By.xpath(xpathFinal));
                } catch (NotFoundException e2) {
                    throw new NotFoundException("ERROR: El campo `" + tagLabelText.getCodigo() + "` no a sido encontrado");
                }
            }
        } else {
            try {
                field = basePage.waitUntilIsDisplayed(By.xpath((xpathFinal)));
            } catch (NotFoundException e) {
                throw new NotFoundException("ERROR: El campo `" + tagLabelText.getCodigo() + "` no a sido encontrado");
            }
        }

        return field;
    }

    //TODO: deprecar metodo siguiente por el nuevo
    /**
     * Este metodo solo se usa en el commonSelect, hay que borrarlo dado que se puede reemplazar por el nuevo
     * @param tagLabelText
     * @param fieldtype
     * @param numeroOrdenCaja
     * @return
     * @throws Exception
     */
    public WebElement getFieldOLD(FieldByTagLabelText tagLabelText, FieldType fieldtype, Integer numeroOrdenCaja) throws Exception {
        WebElement field;
        String xpath;
        String cajaNum = "";
        if (numeroOrdenCaja != null) {
            cajaNum = "[" + numeroOrdenCaja + "]";
        }

        if (fieldtype.equals(FieldType.select)) {
            xpath = "(//label[normalize-space(.)='" + tagLabelText.getCodigo() + "' and not(ancestor::p-dialog)]/following::p-dropdown[1])" + cajaNum;
        } else {
            xpath = "(//label[normalize-space(.)='" + tagLabelText.getCodigo() + "' and not(ancestor::p-dialog)]/following::" + fieldtype + "[1])" + cajaNum;
        }

        try {
            field = basePage.waitUntilIsDisplayed(By.xpath((xpath)));
        } catch (NotFoundException e) {
            throw new NotFoundException("ERROR: El campo `" + tagLabelText.getCodigo() + "` no a sido encontrado");
        }

        return field;
    }

    /**
     * Este metodo debería hacer lo mismo que getField, pero en vez de retornar un WebElement retorna un By.Xpath
     * @param tabOrDialogTitle
     * @param tagLabelText
     * @param fieldtype
     * @param numeroOrdenCaja
     * @return
     * @throws Exception
     */
    public By getFieldByXpath(PanelTitle tabOrDialogTitle, FieldByTagLabelText tagLabelText, FieldType fieldtype, Integer numeroOrdenCaja) throws Exception {
        By field = null;
        String xpath = "";
        String cajaNum = "";
        String tabPanelAux = "";

        if (numeroOrdenCaja != null) {
            cajaNum = "[" + numeroOrdenCaja + "]";
        }

        if (!fieldtype.equals(FieldType.draganddrop) && !fieldtype.equals(FieldType.checkboxgroup)) {
            if (tabOrDialogTitle == null) {
                tabPanelAux = "";
                xpath = "(" + tabPanelAux + "//label[normalize-space(.)='" + tagLabelText.getCodigo() + "' and not(ancestor::p-dialog)])" + cajaNum;
            } else if (tabOrDialogTitle.toString().startsWith("DIALOG_")) {
                //TODO: [#dialogxpath] ajustado nuevo xpath para dialogo falta probar y borrar el comentado antiguo.
                //tabPanelAux = "//p-dialog[@header='" + tabOrDialogTitle.getValue() + "']";
//                xpath = "(" + tabPanelAux + "//label[normalize-space(.)='" + tagLabelText.getCodigo() + "'])" + cajaNum;
                String dialogHeader1 = "(//p-dialog[contains(@header,'"+tabOrDialogTitle.getValue()+"')]//label[normalize-space(.)='" + tagLabelText.getCodigo() + "'])"+cajaNum;
                String dialogHeader2 = "((//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/ancestor::p-dialog/div[contains(@style,'display: block')])//label[normalize-space(.)='" + tagLabelText.getCodigo() + "'])"+cajaNum;
                xpath = "("+dialogHeader1 + "|" + dialogHeader2 +")";
            } else {
                tabPanelAux = "//p-tabpanel[@header='" + tabOrDialogTitle.getValue() + "']";
                xpath = "(" + tabPanelAux + "//label[normalize-space(.)='" + tagLabelText.getCodigo() + "' and not(ancestor::p-dialog)])" + cajaNum;
            }
        }

        String xpathFinal = "";
        switch (fieldtype) {
            case checkboxinput:
            case datepicker:
            case input:
                //TODO: [#dialogxpath] ajustado nuevo xpath para dialogo falta probar y borrar el comentado antiguo.
//                //INFO: este if lo añado con el nuevo xpath, dado que en el ALta Partes de horas > Concepto COlaborador > Dialogo Alta Concepto el elemento p-dialog no tiene header
//                if(tabOrDialogTitle != null && tabOrDialogTitle.equals(PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA)) {
//                    //xpathFinal = "//span[contains(@class,'ui-dialog-title') and contains(text(),'" + tabOrDialogTitle.getValue() + "')]/parent::div/following-sibling::div[1]//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::div/following-sibling::div[1]/input";
//                    xpathFinal = "(//p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/parent::div/following-sibling::div[1]//label[normalize-space(.)='"+tagLabelText.getCodigo()+"']/parent::div/following-sibling::div)"+cajaNum+"/input";
//                } else {
//                    xpathFinal = xpath + "/following::input[1]";
//                }
                xpathFinal = xpath + "/following::input[1]";
                break;
            case input2:
                xpathFinal = xpath + "/following::input[2]";
                break;
            case textarea:
                xpathFinal = xpath + "/following::textarea[1]";
                break;
            case label:
                xpathFinal = xpath + "/following::label[1]";
                break;
            case select:
                //INFO: este if lo añado con el nuevo xpath, dado que en el ALta Partes de horas > Concepto COlaborador > Dialogo Alta Concepto el elemento p-dialog no tiene header
//                if(tabOrDialogTitle != null && tabOrDialogTitle.equals(PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA)) {//TODO @PRE
//                    xpathFinal = "(//p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/parent::div/following-sibling::div[1]//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::div/following-sibling::div/p-dropdown";
//                } else {
//                    xpathFinal = xpath + "/following::p-dropdown[1]";
//                }
                xpathFinal = xpath + "/following::p-dropdown[1]";
                break;
            case selectalt:
                xpathFinal = xpath;
                break;
            case checkbox:
                //TODO: [#dialogxpath] ajustado nuevo xpath para dialogo falta probar y borrar el comentado antiguo.
                //INFO: este if lo añado con el nuevo xpath, dado que en el ALta Partes de horas > Concepto COlaborador > Dialogo Alta Concepto el elemento p-dialog no tiene header
//                if(tabOrDialogTitle != null && tabOrDialogTitle.equals(PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA)) {
//                    //xpathFinal = "(//p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/parent::div/following-sibling::div[1]//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::div/following-sibling::div[1]/p-checkbox/div";
//                    //xpathFinal = "//p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/ancestor::p-dialog//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::p-checkbox/div";
//                    xpathFinal = "(//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+tabOrDialogTitle.getValue()+"')]/ancestor::p-dialog/div[contains(@style,'display: block')])//label[normalize-space(.)='" + tagLabelText.getCodigo() + "']/parent::p-checkbox/div";
//                } else {
//                    xpathFinal = xpath + "/preceding-sibling::div[1]";
//                }
                xpathFinal = xpath + "/preceding-sibling::div[1]";
                break;
            case checkboxgroup:
                tabPanelAux = "//p-tabpanel[@header='" + tabOrDialogTitle.getValue() + "']";
                if (numeroOrdenCaja != null) {
                    xpathFinal = "((" + tabPanelAux + "//label[normalize-space(.)='" + tagLabelText.getCodigo() + "' and not(ancestor::p-dialog)])/parent::div/following-sibling::div//p-checkbox/div)[" + (numeroOrdenCaja + 1) + "]";
                } else {
                    throw new Exception("ERROR: Algun checkbox ha tomado un valor nulo revisar automatización");
                }
                break;
            case draganddrop:
                xpathFinal = "(//p-tabpanel//div[contains(@class,'cabeceraDragDrop') and contains(text(),'" + tagLabelText.getCodigo() + "')]//following-sibling::div[contains(@class,'contenedorDragDrop')])";
                break;
            case radio:
                xpathFinal = xpath + "/parent::p-radiobutton//div[contains(@class,'ui-radiobutton-box')]";
                break;
        }

        if (fieldtype.equals(FieldType.checkbox)) {
            try {
                driver.findElement(By.xpath(xpathFinal));
            } catch (NotFoundException e1) {
                try {
                    xpathFinal = xpath + "/following::div[1]";
                    driver.findElement(By.xpath(xpathFinal));
                } catch (NotFoundException e2) {
                    throw new NotFoundException("ERROR: El campo `" + tagLabelText.getCodigo() + "` no a sido encontrado");
                }
            }
        } else {
            try {
                basePage.waitUntilIsDisplayed(By.xpath((xpathFinal)));
            } catch (NotFoundException e) {
                throw new NotFoundException("ERROR: El campo `" + tagLabelText.getCodigo() + "` no a sido encontrado");
            }
        }
        field = By.xpath(xpathFinal);

        return field;
    }

    /**
     * devuelve un WebElement de la tab indicada
     * @param tabName
     * @return
     * @throws Exception
     */
    public WebElement getTab(String tabName) throws Exception {
        String xpath = "//span[contains(@class,'ui-tabview-title')][contains(text(),'" + tabName + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * devuelve un WebElement de la tab indicada siempre que esté activa sino da error
     * @param tabName
     * @return
     * @throws Exception
     */
    public WebElement getTabActive(String tabName) throws Exception {
        String xpath = "//li[contains(@class,'ui-tabview-selected ui-state-active')]//span[contains(@class,'ui-tabview-title')][contains(text(),'"+tabName+"')]";
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * Devuelve un WebElement del botón indicado según los parametros que le pasemos.
     * @param tabTitle
     * @param dialogTitle
     * @param label
     * @param numeroOrdenCaja
     * @return
     * @throws Exception
     */
    public WebElement getButton(PanelTitle tabTitle, PanelTitle dialogTitle, String label, Integer numeroOrdenCaja) throws Exception {
        WebElement field = null;
        String xpath = "";
        String cajaNum = "";

        if (numeroOrdenCaja != null) {
            cajaNum = "[" + numeroOrdenCaja + "]";
        }

        if (dialogTitle != null && tabTitle == null) {
            //TODO: 12/12/2024 este fix es debido a la Pedidos > Consulta > Eliminar pedido > Dialogo eliminacion de pedido, aqui el dialogo no se encontraba porque su etiqueta html era distinta
            //xpath = "(//p-dialog//span[contains(@class,'ui-dialog-title') and contains(text(),'"+dialogTitle.getValue()+"')]/ancestor::p-dialog/div[contains(@style,'display: block')])//button[contains(@label,'"+label+"') and not(@disabled)]"+cajaNum;
            xpath = "(//*[starts-with(name(), 'p-') and contains(name(), 'dialog')]//span[contains(@class,'ui-dialog-title') and contains(text(),'"+dialogTitle.getValue()+"')]/ancestor::*[starts-with(name(), 'p-') and contains(name(), 'dialog')]/div[contains(@style,'display: block')])//button[contains(@label,'"+label+"') and not(@disabled)]"+cajaNum;
        } else if (dialogTitle != null) {
            //xpath = "//p-tabpanel[@header='"+tabTitle.getValue()+"']//p-dialog[@header='"+dialogTitle.getValue()+"']//button[contains(@label,'"+label+"')]";
            //TODO analizar si encontramos un caso dado que al parecer los dialogos y los tabpanel en el html están en el mismo nivel, entonces basta poner el dialogo.
        } else if (tabTitle != null) {
            xpath = "//p-tabpanel[@header='" + tabTitle.getValue() + "']//button[contains(@label,'" + label + "') and not(ancestor::p-dialog) and not(@disabled)]";
        } else {
            //TODO: probar he cambiado el xpath porque si en la pantalla tenemos el botón Guardar y otro llamado Guardar y traspasar, pillaría cualquiera de ellos
            //xpath = "//button[contains(@label,'" + label + "') and not(ancestor::p-dialog) and not(@disabled)]";
            xpath = "//button[@label='" + label + "' and not(ancestor::p-dialog) and not(@disabled)]";
        }

        try {
            field = basePage.waitUntilIsDisplayed(By.xpath((xpath)));
        } catch (NotFoundException e) {
            throw new NotFoundException("ERROR: El botón `" + label + "` no a sido encontrado o está deshabilitado");
        }

        return field;
    }

    //TODO:Pendiente de analizar para integrar con GETButton, esto ocurre en la pagina de consulta contrato,al realizar el traspaso.
    public WebElement getButtonContrato(PanelTitle tabTitle, PanelTitle dialogTitle, String label, Integer numeroOrdenCaja) throws Exception {
        WebElement field = null;
        String xpath = "";
        xpath = "(//button/span[@class='ui-button-text ui-c'][contains(text(),'"+ label +"')])["+numeroOrdenCaja+"]";
        try {
            field = basePage.waitUntilIsDisplayed(By.xpath((xpath)));
        } catch (NotFoundException e) {
            throw new NotFoundException("ERROR: El botón `" + label + "` no a sido encontrado");
        }
        return field;
    }

    public WebElement getQbEInputField(PanelTitle tabOrDialogTitle, FieldByTagLabelText label, Integer numeroOrdenCaja) throws Exception {
        String xpath = "";
        String cajaNum = "";

        if (numeroOrdenCaja != null) {
            cajaNum = "[" + numeroOrdenCaja + "]";
        }

        if (tabOrDialogTitle != null && tabOrDialogTitle.toString().startsWith("DIALOG_")) {
            xpath = "((//p-dialog[@header='" + tabOrDialogTitle.getValue() + "'] | //p-dialog/div[contains(@style,'display: block')]//span[contains(@class,'ui-dialog-title') and contains(text(),'" + tabOrDialogTitle.getValue() + "')]/parent::div/following-sibling::div[1])//p-datatable//th//span[contains(@class,'ui-column-title') and normalize-space(.)='" + label.getCodigo() + "']/following-sibling::input)"+cajaNum;
        } else if (tabOrDialogTitle != null && tabOrDialogTitle.toString().startsWith("TAB_")) {
            xpath = "(//p-tabpanel[@header='" + tabOrDialogTitle.getValue() + "']//p-datatable//th//span[contains(@class,'ui-column-title') and normalize-space(.)='" + label.getCodigo() + "' and not(ancestor::p-dialog)])" + cajaNum + "/following-sibling::input";
        } else {
            xpath = "(//p-datatable//th//span[contains(@class,'ui-column-title') and normalize-space(.)='" + label.getCodigo() + "' and not(ancestor::p-dialog)])" + cajaNum + "/following-sibling::input";
        }

        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getCheckBoxFromTable(int columna, int fila) {
        String xpath = "//table/tbody/tr[" + fila + "]/td[" + columna +"]/span[2]/p-checkbox";
        System.out.println(xpath);
        return driver.findElement(By.xpath(xpath));
    }

    public By getCheckbox(FieldByTagLabelText labelText) {
        return By.xpath("//p-checkbox[@label='" + labelText.getCodigo() + "']");
    }

}
