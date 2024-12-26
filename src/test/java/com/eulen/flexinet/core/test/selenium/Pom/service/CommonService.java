package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.util.JsonCommand;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.IOException;
import java.util.*;

public class CommonService extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;

    public CommonService(WebDriver driver){
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    //TODO: antiguo type, reemplazar donde se use, con el nuevo
    public void typeInputField(String scnid, WebElement element, String jsonFieldData, Boolean isRequired, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("...SKIPED!!");
                return;
            }
        } else if(jsonFieldData.equals(" ")) { //valor comodin para indicar que queremos validar que esté vacio y que no se los salte
            jsonFieldData = "";
        }

        switch (scnid) { //@scenarios
            case "ModificarEmpresaEnvioOK":
            case "ModificarEmpresaEnvioKO":
            case "ModificarClienteContratoEnvioOK":
            case "ModificarClienteContratoEnvioKO":
            case "ModificarClienteContratoSinEnvioERP":
            case "AltaClienteContratoEnvioOK":
            case "ModificarCentroDeTrabajoEnvioKO":
                element.sendKeys(Keys.CONTROL + "a");
                element.sendKeys(Keys.DELETE);
                break;
            default:
                clear(element);
                break;

        }

        sendKeys(element, jsonFieldData);
        System.out.println("Introduciendo... `"+jsonFieldData+"`\n");

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    //NUEVO TYPE
    public void typeInputField(String scnid, PanelTitle panelTitle, FieldByTagLabelText fieldByTagLabelText, FieldType fieldType, Integer cajaNumero, String jsonFieldData, Boolean isRequired, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...SALTADO!!");
                return;
            }
        } else if(jsonFieldData.equals(" ")) { //valor comodin para indicar que queremos validar que esté vacio y que no se los salte
            jsonFieldData = "";
        }

        //Reemplazando comandos que empiecen y terminen con %
        jsonFieldData = JsonCommand.reemplazarConTextoAleatorio(jsonFieldData);

        System.out.println("Introduciendo campo `"+fieldByTagLabelText.getCodigo()+"`...");
        System.out.println("valor `" + jsonFieldData +"`..."); // usamos print para unir el mensaje con el resultado del assert

        WebElement element;

        if(fieldByTagLabelText.toString().contains("QBE")) {
            element = pageLocators.getQbEInputField(
                    panelTitle,
                    fieldByTagLabelText,
                    cajaNumero
            );
        } else {
            element = pageLocators.getField(
                    panelTitle,
                    fieldByTagLabelText,
                    fieldType,
                    cajaNumero
            );
        }
        if (fieldByTagLabelText.equals(FieldByTagLabelText.CP) ||
                (panelTitle != null && (panelTitle.equals(PanelTitle.TAB_DATOSDECOLABORADORES) && fieldByTagLabelText.equals(FieldByTagLabelText.DNI)))) { //TODO: Indicar donde ocurre esta casuistica
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
        } else {
            clear(element);
        }

        sendKeys(element, jsonFieldData);

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    public void selectField(String scnid, WebElement element, String jsonFieldData, Boolean isRequired, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("...SKIPED!!");
                return;
            }
        } else if(jsonFieldData.equals(" ")) { //valor comodin para indicar que queremos validar que esté vacio y que no se los salte
            jsonFieldData = "";
        }

        click(element);
        WebElement elementVal = element.findElement(By.xpath(".//li/span[normalize-space(.) = '"+jsonFieldData+"']"));
        String optionValue = getText(elementVal);
        System.out.println("Seleccionando...`"+jsonFieldData+"`\n"); //TODO: Cambiar a logger, para verlo en el reporte

        if (optionValue.equals(jsonFieldData)) {
            click(elementVal);
        }

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    //NUEVO SELECT
    public void selectField(String scnid, PanelTitle panelTitle, FieldByTagLabelText fieldByTagLabelText, FieldType fieldType, Integer cajaNumero, String jsonFieldData, Boolean isRequired, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...SALTADO!!");
                return;
            }
        } else if(jsonFieldData.equals(" ")) { //valor comodin para indicar que queremos validar que esté vacio y que no se los salte
            jsonFieldData = "";
        }

        System.out.println("Seleccionando campo `"+fieldByTagLabelText.getCodigo()+"`...");
        System.out.println("valor `" + jsonFieldData +"`..."); // usamos print para unir el mensaje con el resultado del assert

        WebElement element;

        if(panelTitle == null) {
            element = pageLocators.getField(
                    null, //TODO comprobar que esto funciona si es así, borrar el if y pasar el parametro al metodo si no volver al metodo getFieldOLD
                    fieldByTagLabelText,
                    fieldType,
                    cajaNumero
            );
        } else {
            element = pageLocators.getField(
                    panelTitle,
                    fieldByTagLabelText,
                    fieldType,
                    cajaNumero
            );
        }

        waitUntilBeClickable(element);

        if(!fieldType.equals(FieldType.selectalt)) {
            if(element.findElement(By.xpath("./div")).getAttribute("class").contains("ui-state-disabled")) throw new JavascriptException("Element is not currently interactable and may not be manipulated");
        }

        click(element);
        String optionXpath;

        if(fieldType.equals(FieldType.selectalt)) { //INFO: condición añadida por el campo TabDatosDeTarifa > Seleccione Duración Tipo de Tarifa
            optionXpath = ".//following::li/span[normalize-space(.) = '" + jsonFieldData + "']";
        } else {
            optionXpath = ".//li/span[normalize-space(.) = '" + jsonFieldData + "']";
        }

        WebElement elementVal = waitAndClickUntilDropdownOpen(element, By.xpath(optionXpath), 5); //Se intenta abrir el select para encontrar el valor durante 5 segundos
        String optionValue = getText(elementVal);

        if (optionValue.equals(jsonFieldData)) {
            click(elementVal);
        }

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    public void typeselField(String scnid, PanelTitle panelTitle, FieldByTagLabelText fieldByTagLabelText, FieldType fieldType, Integer cajaNumero, String jsonFieldData, Boolean isRequired, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...SALTADO!!");
                return;
            }
        } else if(jsonFieldData.equals(" ")) { //valor comodin para indicar que queremos validar que esté vacio y que no se los salte
            jsonFieldData = "";
        }

        System.out.println("Introduciendo campo `"+fieldByTagLabelText.getCodigo()+"`...");
        System.out.println("valor `" + jsonFieldData +"`..."); // usamos print para unir el mensaje con el resultado del assert

        WebElement element = pageLocators.getField(
                panelTitle,
                fieldByTagLabelText,
                fieldType,
                cajaNumero
        );

        if (fieldByTagLabelText.equals(FieldByTagLabelText.CP)) {
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
        } else {
            clear(element);
        }

        sendKeys(element, jsonFieldData);

        System.out.println("Seleccionando valor `"+jsonFieldData+"`...");
        element = waitUntilIsDisplayed(element, By.xpath("./following::div//li/span[normalize-space(.)='" + jsonFieldData + "']"));

        click(element);

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    public void validateField(String scnid, WebElement element, String jsonFieldData, Boolean isRequired) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("...SKIPED!!");
                return;
            }
        } else if(jsonFieldData.equals(" ")) { //valor comodin para indicar que queremos validar que esté vacio y que no se los salte
            jsonFieldData = "";
        }

        String elementValue="";

        System.out.print("Valor esperado...`" + jsonFieldData +"`...");

        if(element.getTagName().equals("label")) {
            elementValue = element.getText();
        }
        if(element.getTagName().equals("input")) {
            elementValue = element.getAttribute("value");
        }
        if(element.getTagName().equals("p-dropdown")) {
            elementValue = element.findElement(By.xpath(".//label")).getText();
        }
        if(element.getTagName().equals("div")) {
            elementValue = element.findElement(By.xpath(".//span")).getAttribute("class");
            if(elementValue.contains("fa-check")) {
                elementValue = "TRUE";
            } else {
                elementValue = "";
            }
        }

        //System.out.println("FAIL: Valor Esperado = " + jsonFieldData + " | Valor Obtenido = " + elementValue );
        Assert.assertEquals("FAIL: El campo no tiene el valor esperado.\n", jsonFieldData, elementValue);
        System.out.println("PASS!!\n");
    }

    public void validateField(String scnid, PanelTitle panelTitle, FieldByTagLabelText fieldByTagLabelText, FieldType fieldType, Integer cajaNumero, String jsonFieldData, Boolean isRequired) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...SALTADO!!");
                return;
            }
        } else if(jsonFieldData.equals(" ")) { //valor comodin para indicar que queremos validar que esté vacio y que no se los salte
            jsonFieldData = "";
        }

        System.out.println("Validando campo `"+fieldByTagLabelText.getCodigo()+"`...");
        System.out.print("valor esperado...`" + jsonFieldData +"`..."); // usamos print para unir el mensaje con el resultado del assert

        WebElement element = pageLocators.getField(
                panelTitle,
                fieldByTagLabelText,
                fieldType,
                cajaNumero
        );

        String elementValue="";

        if(element.getTagName().equals("label")) {
            elementValue = element.getText().trim();
        }
        if(element.getTagName().equals("input")) {
            elementValue = element.getAttribute("value").trim();
        }
        if(element.getTagName().equals("p-dropdown")) {
            elementValue = element.findElement(By.xpath(".//label")).getText().trim();
        }
        if(element.getTagName().equals("div")) {
            elementValue = element.findElement(By.xpath(".//span")).getAttribute("class");
            if(elementValue.contains("fa-check")) {
                elementValue = "true";
            } else {
                elementValue = "false";
            }
        }

        Assert.assertEquals("FAIL: El campo no tiene el valor esperado.\n", jsonFieldData, elementValue);
        System.out.println("PASS!!\n");
    }

    public void clickRadioField(
            String scnid,
            PanelTitle panelTitle,
            FieldByTagLabelText fieldByTagLabelText,
            Integer cajaNumero,
            String jsonFieldData,
            Boolean isRequired,
            Boolean waitForSpinner,
            Boolean checkNoMessageShown) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...SALTADO!!");
                return;
            }
        } else if(!jsonFieldData.equals("true")) {
            System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"` ya tiene el valor indicado, saltamos!!");
            return;
        }

        System.out.println("Clicando campo `"+fieldByTagLabelText.getCodigo()+"`...");
        System.out.print("valor esperado...`" + jsonFieldData +"`..."); // usamos print para unir el mensaje con el resultado del assert

        WebElement element = pageLocators.getField(
                panelTitle,
                fieldByTagLabelText,
                FieldType.radio,
                cajaNumero
        );

        click(element);

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }


    public void dragAndDropField(
            String scnid,
            PanelTitle panelTitle,
            FieldByTagLabelText fieldByTagLabelText1,
            FieldByTagLabelText fieldByTagLabelText2,
            Integer cajaNumero,
            String jsonFieldData,
            Boolean isRequired,
            Boolean waitForSpinner,
            Boolean checkNoMessageShown) throws Exception {
        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+fieldByTagLabelText1.getCodigo()+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("campo `"+fieldByTagLabelText1.getCodigo()+"`...SALTADO!!");
                return;
            }
        }

        WebElement fromElement = pageLocators.getField(
                panelTitle,
                fieldByTagLabelText1,
                FieldType.draganddrop,
                1
        );

        WebElement toElement = pageLocators.getField(
                panelTitle,
                fieldByTagLabelText2,
                FieldType.draganddrop,
                1
        );

        try {
            fromElement = waitUntilIsDisplayed(fromElement, By.xpath("//div[contains(@class,'textContenedorDragDrop') and normalize-space(.)='" + jsonFieldData + "']"));
        } catch (Exception e) {
            throw new Exception("ERROR: el campo `"+fieldByTagLabelText1.getCodigo()+"` no ha sido encontrado o no es posible hacer click en el.\n", e);
        }

        dragAndDrop(fromElement, toElement);

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    public void checkBoxField(
            String scnid,
            PanelTitle panelTitle,
            FieldByTagLabelText fieldByTagLabelText,
            Integer cajaNumero,
            String jsonFieldData,
            Boolean isRequired,
            Boolean waitForSpinner,
            Boolean checkNoMessageShown
    ) throws Exception {
        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...SALTADO!!");
                return;
            }
        }


        if(jsonFieldData.contains(",")) { //INFO: comprobamos si el checkbox es solo 1 o un grupo, en función de los valores del json
            String[] arrayValores = jsonFieldData.split(",");
            ArrayList<String> listaValores = new ArrayList<>();
            Collections.addAll(listaValores, arrayValores);
            WebElement[] elementArray = new WebElement[listaValores.size()];
            for( int indice=0 ; indice < listaValores.size(); indice++) {
                elementArray[indice] = pageLocators.getField(
                        panelTitle,
                        fieldByTagLabelText,
                        FieldType.checkboxgroup,
                        indice
                );

                try {
                    elementArray[indice].findElement(By.xpath(".//div[contains(@class,'ui-state-activ')]"));

                    if(listaValores.get(indice).equals("true")) {
                        System.out.println("INFO: el campo `"+fieldByTagLabelText.getCodigo()+"` esta marcado, lo dejamos como está ya que lo indica el json");

                    } else {
                        System.out.println("INFO: el campo `"+fieldByTagLabelText.getCodigo()+"` esta marcado, lo marcamos como indica el json");
                        click(elementArray[indice]);
                    }
                } catch (Exception e) {
                    if(listaValores.get(indice).equals("true")) {
                        System.out.println("INFO: el campo `"+fieldByTagLabelText.getCodigo()+"` no esta marcado, lo marcamos como indica el json");
                        click(elementArray[indice]);
                    } else {
                        System.out.println("INFO: el campo `"+fieldByTagLabelText.getCodigo()+"` no esta marcado, lo dejamos como está ya que lo indica el json");

                    }
                }
                System.out.println("@DEBUG indice " + indice);
            }
        } else {

            WebElement element = pageLocators.getField(
                    panelTitle,
                    fieldByTagLabelText,
                    FieldType.checkbox,
                    cajaNumero
            );

            //INFO: Lo siguiente lo añado para que de un error si intentamos marcar/desmarcar un check que no es editable
            //WebElement elementAux = waitUntilIsDisplayed(element, By.xpath("./child::div[2]"));
            WebElement elementAux = waitUntilIsDisplayed(element, By.xpath(".//div[contains(@class,'ui-chkbox-box')]"));
            try {
                waitUntilAttributeNotFound(elementAux, "class", "ui-state-disabled", 10);
            } catch (Exception e) {
                throw new NotFoundException("ERROR: El check `" + fieldByTagLabelText.getCodigo() +"` no es editable...\n"+ e.getMessage());
            }

            try {
                elementAux.findElement(By.xpath("./self::div[contains(@class,'ui-state-active')]"));
                //element.findElement(By.xpath(".//div[contains(@class,'ui-state-activ')]"));

                if (jsonFieldData.equals("true")) {
                    System.out.println("INFO: el campo `" + fieldByTagLabelText.getCodigo() + "` esta marcado, lo dejamos como está ya que lo indica el json");
                    return;
                } else {
                    System.out.println("INFO: el campo `" + fieldByTagLabelText.getCodigo() + "` esta marcado, lo marcamos como indica el json");
                    click(elementAux);
                }
            } catch (Exception e) {
                if (jsonFieldData.equals("true")) {
                    System.out.println("INFO: el campo `" + fieldByTagLabelText.getCodigo() + "` no esta marcado, lo marcamos como indica el json");
                    click(elementAux);
                } else {
                    System.out.println("INFO: el campo `" + fieldByTagLabelText.getCodigo() + "` no esta marcado, lo dejamos como está ya que lo indica el json");
                    return;
                }
            }
        }

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }

    }

    public void datePickerField(
            String scnid,
            PanelTitle panelTitle,
            FieldByTagLabelText fieldByTagLabelText,
            Integer cajaNumero,
            String jsonFieldData,
            Boolean isRequired,
            Boolean waitForSpinner,
            Boolean checkNoMessageShown
    ) throws Exception {
        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("campo `"+fieldByTagLabelText.getCodigo()+"`...SALTADO!!");
                return;
            }
        }

        //Convertimos comando a fecha
        JsonCommand dt = new JsonCommand();
        jsonFieldData = dt.convertCommandToDate(jsonFieldData);

        System.out.println("Seleccionando campo fecha `"+fieldByTagLabelText.getCodigo()+"`...");
        System.out.println("valor `" + jsonFieldData +"`...");

        WebElement element;

        if(panelTitle != null && panelTitle.equals(PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO)) {
            element = pageLocators.getPickDateIntroduzcaFechaAntiguedadContrato();
        } else {
            element = pageLocators.getField(
                    panelTitle,
                    fieldByTagLabelText,
                    FieldType.datepicker,
                    cajaNumero
            );
        }

        Map<String, Integer> fecha = dateToMap(jsonFieldData);

        WebElement dateButton = waitUntilIsDisplayed(element,By.xpath("./following-sibling::button"));
        click(dateButton);

        WebElement dateCalentarYearAux = waitUntilIsDisplayed(element, By.xpath("./following-sibling::div//select[@class='ui-datepicker-year']"));
        WebElementFacade dateCalentarYear = WebElementFacadeImpl.wrapWebElement(driver,dateCalentarYearAux,1000,1000);
        dateCalentarYear.selectByVisibleText(fecha.get("año").toString());

        WebElement dateCalentarMonthAux = waitUntilIsDisplayed(element, By.xpath("./following-sibling::div//select[@class='ui-datepicker-month']"));
        WebElementFacade dateCalentarMonth = WebElementFacadeImpl.wrapWebElement(driver,dateCalentarMonthAux,1000,1000);

        String[] meses = {
                "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio",
                "agosto", "septiembre", "octubre", "noviembre", "diciembre"
        };

        String[] mesesCapital = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        String nombreMes = "";
        String nombreMesCapital = "";

            int indiceMes = fecha.get("mes") - 1;

        if(indiceMes >= 0 && indiceMes < 12) {
            nombreMes = meses[indiceMes];
            nombreMesCapital = mesesCapital[indiceMes];
        } else {
            throw new Exception("ERROR: Ha ocurrido un error relacionado con el mes indicado en el campo `"+fieldByTagLabelText.getCodigo()+"`");
        }

        try {
            dateCalentarMonth.selectByVisibleText(nombreMes);
        } catch(Exception e1) {
            try {
                dateCalentarMonth.selectByVisibleText(nombreMesCapital);
            } catch (Exception e2) {
                throw new Exception("ERROR: No se puede seleccionar el mes `"+nombreMesCapital+"`...");
            }
        }


        WebElement dateCalendarDay = waitUntilIsDisplayed(element,By.xpath("./following-sibling::div//table//td[not(contains(@class,'ui-datepicker-other-month ui-state-disabled'))]//*[text()='"+fecha.get("dia").toString()+"']"));

        click(dateCalendarDay);

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    public String getValueField(PanelTitle panelTitle, FieldByTagLabelText fieldByTagLabelText) throws Exception {

        WebElement element;

        element = pageLocators.getField(
                panelTitle,
                fieldByTagLabelText,
                FieldType.label,
                1
        );

        return element.getText();
    }

    /**
     * Se hace click a la primera fila de la tabla, cuyo indice corresponde al devuelto por el metodo validateAndReturnRowNum<ArrayList>
     * @param scn
     * @param page
     * @param file
     * @throws Exception
     */
    public void clickFirstValidRowResultOnTable(String scn, SystemPages page, PanelTitle dialogTitle, String file, int cajaNumero, boolean isUnderDialog) throws Exception {

        WebElement element = null;

        if(isUnderDialog) {
            if(dialogTitle != null) {
                element = pageLocators.getDialogTable(dialogTitle,cajaNumero);
            } else {
                element = pageLocators.getDialogTable();
            }
        } else {
            if (file.contains(SystemPages.PEDIDOS__CONSULTA.toString())) {
                element = pageLocators.getTable(cajaNumero);
            } else {
                element = pageLocators.getTable();
            }
        }

        if(element == null) {
            throw new Exception("ERROR: No se ha encontrado la tabla");
        }

        ArrayList<Integer> val = validateAndReturnRowNum(scn, page, file, element);
        int pos = val.get(0) + 1;
        String xpathValue = ".//tbody//tr["+pos+"]";
        try {
            System.out.println("Intentando hacer click en el primer registro encontrado...");
            WebElement finalElement = element.findElement(By.xpath(xpathValue));
            click(finalElement);
            System.out.println("Click realizado...");
        } catch (Exception e) {
            throw new AssertionError("FAIL: No se ha encontrado resultado o no se ha podido hacer click en el resultado");
        }
    }

    public void clickFirstValidRowResultOnTableNew(String scn, SystemPages page, PanelTitle dialogTitle, String file, String jsonObjectPath, int cajaNumero, boolean isUnderDialog) throws Exception {

        WebElement element = null;

        if(isUnderDialog) {
            if(dialogTitle != null) {
                element = pageLocators.getDialogTable(dialogTitle, cajaNumero);
            } else {
                element = pageLocators.getDialogTable();
            }
        } else {
            element = pageLocators.getTable(cajaNumero);
        }

        if(element == null) {
            throw new Exception("ERROR: No se ha encontrado la tabla");
        }
        Thread.sleep(3000); //TODO: esto es porque a veces, por ejemplo en los filtros QBE se captura la tabla antes de que termine el filtrado y luego al capturar datos da un stale reference error, ver de mejorar
        ArrayList<Integer> val = validateAndReturnRowNumNew(scn, page, file, element, jsonObjectPath);

        int pos = val.get(0) + 1;
        String xpathValue = ".//tbody//tr["+pos+"]";
        try {
            System.out.println("Intentando hacer click en el primer registro encontrado...");
            WebElement finalElement = waitUntilIsDisplayed(element,By.xpath(xpathValue));
            click(finalElement);
            System.out.println("Click realizado...");
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("FAIL: No se ha encontrado resultado o no se ha podido hacer click en el resultado");
        }
    }


    /**
     * Se le pasa el WebElement de la tabla y luego el metodo tableExtractor<SortedMap> devuelve las filas ordenadas por su indice.
     * Luego se analiza cada fila para ver si sus campos coinciden con los valores indicados en `file` y si no, se registra un error en la variable errorsList<ArraryList>.
     * Si la fila analizada, coincide con los valores de `file` entonces se guarda la variable passList<ArrayList>.
     * Finalmente si hay 1 o mas filas que coincidan con los valores indicados en `file` entonces se devuelven sus indices en un <ArrayList>.
     * @param scn
     * @param page
     * @param file
     * @param element
     * @return
     * @throws Exception
     */
    public ArrayList<Integer> validateAndReturnRowNum(String scn, SystemPages page, String file, WebElement element) throws Exception {
        this.jsonFileToMap(page  + "/" + scn + "/" + file + ".table.json");
        ArrayList<StringBuilder> errorsList = new ArrayList<>();
        ArrayList<StringBuilder> passList = new ArrayList<>();
        ArrayList<Integer> arrayRowNumPass = new ArrayList<>();
        StringBuilder errors = new StringBuilder();
        tableExtractor(element).forEach((rowkey, rowvalue) -> {
            System.out.println("@DEBUG Fila " + rowkey + ": " + rowvalue);
            rowvalue.forEach((cellkey,cellvalue) -> {
                System.out.println("@DEBUG Celda " + cellkey + ": " + cellvalue);

                if(datosMap.containsKey(cellkey)) {
                    System.out.println("fila["+rowkey+"] - celda '" + cellkey + "' está en el json!!");
                    String jsonvalue = datosMap.get(cellkey).toString();
                    if(jsonvalue == null || jsonvalue.isEmpty()) {
                        System.out.println("fila["+rowkey+"][JSON] el campo `"+cellkey+"` no tiene valor.");
                        return;
                    }
                    if(cellvalue.equals(jsonvalue)) {
                        System.out.println("fila["+rowkey+"] - PASS: '" + cellkey + "' : '" + jsonvalue +"'");
                    } else {
                        errors.append(String.format("fila["+rowkey+"] - FAIL: El valor `%s` de la columna `%s` de la tabla, NO COINCIDE con `%s` del json %n", cellvalue, cellkey, jsonvalue));
                    }
                } else {
                    if(!cellkey.isEmpty()) {
                        errors.append(String.format("fila["+rowkey+"] - FAIL: El mapa no contiene la clave: %s %n", cellkey));
                        //System.err.println("SKIP: El mapa no contiene la clave: " + cellkey);
                    }
                }
            });

            if(errors.length() == 0) {
                passList.add(new StringBuilder("fila[" + rowkey + "] - PASS: TODOS LOS VALORES CONCIDEN!!"));
                arrayRowNumPass.add(rowkey);
            } else {
                errorsList.add(new StringBuilder(errors));
                errors.delete(0, errors.length());
            }
        });
        if(passList.size() > 0 ) {
            System.out.println(passList);
            return arrayRowNumPass;
        } else {
            // TODO: Analizar si cambiar el mensaje por un mensaje errorsList por un mensaje simple, es decir quitar el errorList y poner un texto
            Assert.assertEquals(errorsList.toString(), 0, errorsList.size());
        }
        /* aqui no deberíamos llegar, si llegamos algo a pasado */
        throw new Exception("FAIL: Error desconocido en la tabla");
    }

    /**
     * Nuevo metodo validateAndReturnRowNum hace lo mismo que el anterior, pero ahora se le pasa el nuevo json y la ruta dentro del mismo donde está la tabla
     * EJ: TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSDELPEDIDO->DIALOG_SELECCIONDEEMPRESA->TABLE
     * @param scn
     * @param page
     * @param file
     * @param element
     * @param jsonObjectPath
     * @return
     * @throws Exception
     */
    public ArrayList<Integer> validateAndReturnRowNumNew(String scn, SystemPages page, String file, WebElement element, String jsonObjectPath) throws Exception {
        Map<String, String> datosMap = this.jsonFileToMapNew(file,jsonObjectPath);
        ArrayList<StringBuilder> errorsList = new ArrayList<>();
        ArrayList<StringBuilder> passList = new ArrayList<>();
        ArrayList<Integer> arrayRowNumPass = new ArrayList<>();
        StringBuilder errors = new StringBuilder();
        tableExtractor(element).forEach((rowkey, rowvalue) -> {
            System.out.println("@DEBUG Fila " + rowkey + ": " + rowvalue);
            rowvalue.forEach((cellkey,cellvalue) -> {
                System.out.println("@DEBUG Celda " + cellkey + ": " + cellvalue);

                if(datosMap.containsKey(cellkey)) {
                    System.out.println("fila["+rowkey+"] - celda '" + cellkey + "' está en el json!!");
                    String jsonvalue = datosMap.get(cellkey).toString();

                    JsonCommand dt = new JsonCommand();

                    jsonvalue = dt.convertCommandToDate(jsonvalue);

                    if(jsonvalue == null || jsonvalue.isEmpty()) {
                        System.out.println("fila["+rowkey+"][JSON] el campo `"+cellkey+"` no tiene valor.");
                        return;
                    }
                    if(cellvalue.equals(jsonvalue)) {
                        System.out.println("fila["+rowkey+"] - PASS: '" + cellkey + "' : '" + jsonvalue +"'");
                    } else {
                        errors.append(String.format("fila["+rowkey+"] - FAIL: El valor `%s` de la columna `%s` de la tabla, NO COINCIDE con `%s` del json %n", cellvalue, cellkey, jsonvalue));
                    }
                } else {
                    if(!cellkey.isEmpty()) {
                        errors.append(String.format("fila["+rowkey+"] - FAIL: El mapa no contiene la clave: %s %n", cellkey));
                        System.err.println("SKIP: El mapa no contiene la clave: " + cellkey);
                    }
                }
            });

            if(errors.length() == 0) {
                passList.add(new StringBuilder("fila[" + rowkey + "] - PASS: TODOS LOS VALORES CONCIDEN!!"));
                arrayRowNumPass.add(rowkey);
            } else {
                errorsList.add(new StringBuilder(errors));
                errors.delete(0, errors.length());
            }
        });
        if(passList.size() > 0 ) {
            System.out.println(passList);
            return arrayRowNumPass;
        } else {
            // TODO: Analizar si cambiar el mensaje por un mensaje errorsList por un mensaje simple, es decir quitar el errorList y poner un texto
            Assert.assertEquals(errorsList.toString(), 0, errorsList.size());
        }
        /* aqui no deberíamos llegar, si llegamos algo a pasado */
        throw new Exception("FAIL: Error desconocido en la tabla");
    }

    /**
     * Este metodo es para introducir valores en celdas de tablas editables, como la que hay en PedidosAlta > Tab Datos de Tarifa > Tab Desglose de Categorias Progesional
     * @param scn
     * @param page
     * @param panel
     * @param column
     * @param filaNumero
     * @param jsonFieldData
     * @param tablaNumero
     * @return
     * @throws Exception
     */
    public void typeInputCell(String scn, SystemPages page, PanelTitle panel, String column, int filaNumero, int tablaNumero, String jsonFieldData, Boolean isRequired) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("input de columna `"+column+"`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("input de columna `"+column+"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Introduciendo input columna `"+column+"`...");

        WebElement tableInput = pageLocators.getTableCell(
                panel,
                column,
                filaNumero,
                tablaNumero
        ).findElement(By.tagName("input"));

        tableInput.sendKeys(jsonFieldData);
    }


    /**
     * Obtiene los valores del json `file` que se han mapeado con las variables de la clase JsonFiles
     * @param scn
     * @param page
     * @param file
     * @throws Exception
     */

    //TODO: Validar este metodo para mejorarlo o funcionarlo con otro. "VERUSCA"
    public void typeInputCellCheckBox(String scn, SystemPages page, PanelTitle panel, String column, int filaNumero, int tablaNumero, String jsonFieldData, String file, Boolean isRequired) throws Exception {

        if (jsonFieldData == null || jsonFieldData.isEmpty()) {
            if (isRequired.equals(Boolean.TRUE)) {
                System.out.println("input de columna `" + column + "`...REQUERIDO!!");
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("input de columna `" + column + "`...SALTADO!!");
                return;
            }
        }

        System.out.println("Introduciendo input columna `" + column + "`...");

        if (jsonFieldData.contains(",")) { //INFO: comprobamos si el checkbox es solo 1 o un grupo, en función de los valores del json
            String[] arrayValores = jsonFieldData.split(",");
            ArrayList<String> listaValores = new ArrayList<>();
            Collections.addAll(listaValores, arrayValores);
            WebElement[] elementArray = new WebElement[listaValores.size()];
            for (int indice = 0; indice < listaValores.size(); indice++) {
                try {
                    if (listaValores.get(indice).equals("true")) {
                        System.out.println("INFO: el campo `" + jsonFieldData + "` esta marcado, lo dejamos como está ya que lo indica el json");

                    } else {
                        System.out.println("INFO: el campo `" + jsonFieldData + "` esta marcado, lo marcamos como indica el json");
                        click(elementArray[indice]);
                    }
                } catch (Exception e) {
                    if (listaValores.get(indice).equals("true")) {
                        System.out.println("INFO: el campo `" + jsonFieldData + "` no esta marcado, lo marcamos como indica el json");
                        click(elementArray[indice]);
                    } else {
                        System.out.println("INFO: el campo `" + jsonFieldData + "` no esta marcado, lo dejamos como está ya que lo indica el json");

                    }
                }
                System.out.println("@DEBUG indice " + indice);
            }
        } else {
            WebElement tableInput = pageLocators.getTableCell(
                    panel,
                    column,
                    filaNumero,
                    tablaNumero);

            try {
                switch (scn) { //@SCN
                    case "Flexinet19954":
                        tableInput.findElement(By.xpath(".//span/p-checkbox[1]//input[@disabled]"));
                        break;
                    default:
                        tableInput.findElement(By.xpath(".//span/p-checkbox[1]"));
                        break;
                }

                if (jsonFieldData.equals("true")) {
                    System.out.println("INFO: el campo `" + column + "` esta marcado, lo dejamos como está ya que lo indica el json");
                    click(tableInput);
                } else {
                    System.out.println("INFO: el campo `" + column + "` esta marcado, lo marcamos como indica el json");
                    return;
                }
            } catch (Exception e) {
                if (jsonFieldData.equals("true")) {
                    System.out.println("INFO: el campo `" + column + "` no esta marcado, lo marcamos como indica el json");
                    click(tableInput);
                } else {
                    System.out.println("INFO: el campo `" + column + "` no esta marcado, lo dejamos como está ya que lo indica el json");
                    return;
                }
            }
        }
    }

    //TODO: NO USAR!!, en cambio usar commonService.readJsonData
    public void getJsonFileData(String scn, SystemPages page, String file) throws Exception {
        this.jsonFile(page  + "/" + scn + "/"+ file +".json");
    }

    //NEW: usar este en vez de getJsonFileData
    public void readJsonData(String file) throws Exception {
        jsonFileNew(file);
    }

    public void checkNoUnexpectedMessageIsShown() throws Exception {
        //Thread.sleep(1000); //TODO: no hay nada que monitorizar para esperar dado que el popup sale en un timpo random, ver si se puede mejorar
        checkMsgErrorIsNotShown(true);
        checkMsgAvisoIsNotShown();
        checkMsgAtencionIsNotShown();
        checkMsgInfoIsNotShown();
    }

    /**
     * Detecta si aparece una notificación tipo Growl de Error, en tal caso lanza una AssertionError
     * @param thrownError
     * @throws Exception
     */
    public void checkMsgErrorIsNotShown(boolean thrownError) throws Exception {
        try {
            waitUntilIsNotDisplayed(pageLocators.getMsgError(), 1);
        } catch (Exception e) {
            String xpath = "./following::p";
            String message = pageLocators.getMsgError().findElement(By.xpath(xpath)).getText();
            if(thrownError) {
                throw new AssertionError("FAIL: Se ha mostrado un dialogo de ERROR inesperado con el siguiente texto: \n\n`" + message + "`\n\n" + e);
            } else {
                System.err.println("WARNING: Se ha mostrado un dialogo de ERROR inesperado con el siguiente texto: \n\n`" + message + "`\n\n" + e);
            }
        }
    }

    public void checkMsgAvisoIsNotShown() throws Exception {
        try {
            waitUntilIsNotDisplayed(pageLocators.getMsgAviso(), 1);
        } catch (Exception e) {
            String xpath = "./following::p";
            String message = pageLocators.getMsgAviso().findElement(By.xpath(xpath)).getText();
            throw new AssertionError("FAIL: Se ha mostrado un dialogo de AVISO inesperado con el siguiente texto: \n\n`" + message +"`\n\n"+ e);
        }
    }

    public void checkMsgAtencionIsNotShown() throws Exception {
        try {
            waitUntilIsNotDisplayed(pageLocators.getMsgAtencion(), 1);
        } catch (Exception e) {
            String xpath = "./following::p";
            String message = pageLocators.getMsgAtencion().findElement(By.xpath(xpath)).getText();
            throw new AssertionError("FAIL: Se ha mostrado un dialogo de ATENCION inesperado con el siguiente texto: \n\n`" + message +"`\n\n"+ e);
        }
    }

    public void checkMsgInfoIsNotShown() throws AssertionError {
        try {
            waitUntilIsNotDisplayed(pageLocators.getMsgInfo(), 1);
        } catch (Exception e) {
            String xpath = "./following::p";
            String message = pageLocators.getMsgInfo().findElement(By.xpath(xpath)).getText();
            throw new AssertionError("FAIL: Se ha mostrado un dialogo de INFORMACION inesperado con el siguiente texto: \n\n`" + message +"`\n\n"+ e);
        }
    }

    public boolean checkMsgInfoProvinceChange() throws Exception {
        try {
            waitUntilIsNotDisplayed(pageLocators.getMsgInfo(),1);
            return false;
        } catch (Exception e) {
            String xpath = "./following::p";
            String message = pageLocators.getMsgInfo().findElement(By.xpath(xpath)).getText();
            if(message.contains("El cambio de provincia puede acarrear el borrado de ciertas categorías laborales profesionales")) {
                click(pageLocators.getBtnCerrarModal());
                return true;
            }
            throw new AssertionError("FAIL: Se ha mostrado un dialogo de INFORMACION inesperado con el siguiente texto: \n\n`" + message +"`\n\n"+ e);
        }
    }

    public boolean checkMsgInfoDateChange() throws Exception {
        try {
            waitUntilIsNotDisplayed(pageLocators.getMsgAviso(), 1);
            return false;
        } catch (Exception e) {
            String xpath = "./following::p";
            String message = pageLocators.getMsgInfo().findElement(By.xpath(xpath)).getText();
            if(message.contains("Si la fecha de inicio del pedido es igual o superior al")) {
                click(pageLocators.getBtnCerrarModal());
                return true;
            }
            throw new AssertionError("FAIL: Se ha mostrado un dialogo de INFORMACION inesperado con el siguiente texto: \n\n`" + message +"`\n\n"+ e);
        }
    }

    public boolean checkMsgOficinaCambiadaCorrectamente() throws Exception {
        try {
            WebElement element;
            waitUntilIsDisplayed(element = pageLocators.getMsgInfo().findElement(By.xpath("./following::p")));
            if(element.getText().equals("La oficina se ha cambiado correctamente")) {
                click(homePageLocators.getBtnCloseInfoMsgModalCambiarEmpresa());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Este metodo fachada, simplemente sirve para llamar al waitForSpinner desde las clases Task
     * @throws Exception
     */
    public void waitUntilSpinnerIsNotDisplayed() throws Exception {
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
    }

    public void waitUntilSpinnerIsDisplayed() throws Exception {
        waitUntilIsDisplayed(homePageLocators.getFlexinetLoadingSpinner());
    }


    /**
     * Hace una captura de pantalla que se mostrará en el reporte asociado el step donde se haya ejecutado el metodo, este aparecerá
     * como un botón en el step.
     * @param title
     * @throws IOException
     */
    public void doScreenshot(String title) throws IOException {
        makeScreenshotWithTitle(title);
    }

    /**
     * Busca y hace clic en un botón en una posición específica dentro de una lista de botones identificados por un XPath.
     *
     * @param xpath     El XPath que identifica los botones.
     * @param position  La posición del botón que se desea hacer clic (empezando desde 1).
     * @throws IllegalArgumentException Si no se puede encontrar el botón en la posición indicada.
     */
    public void clickBtnByPosition(String xpath, int position) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        if (position > 0 && position <= elements.size()) {
            WebElement element = elements.get(position - 1);
            System.out.println("Haciendo click en el botón " + element + " en la posición " + position);
            element.click();
        } else {
            throw new IllegalArgumentException("No se pudo encontrar el botón en la posición indicada.");
        }
    }

    public void isCheckboxFieldChecked(int columnaNumero, int filaNumero, String jsonFieldData) {

        WebElement element = pageLocators.getCheckBoxFromTable(columnaNumero, filaNumero);
        if (jsonFieldData.equals("true")) {
            if (element.isSelected()) {
                System.out.println("El checkbox de la columna" + columnaNumero + "esta marcado como se esperaba");
            } else {
                throw new IllegalArgumentException("El checkbox de la columna" + columnaNumero + "se esperaba que estuviese seleccionado pero no lo esta");
            }
        } else {
            //false
            if(!element.isSelected()) {
                System.out.println("El checkbox de la columna" + columnaNumero + "NO esta marcado como se esperaba");
            } else {
                throw new IllegalArgumentException("El checkbox de la columna" + columnaNumero +"se esperaba que NO estuviese seleccionado pero lo esta");
            }
        }

    }

    //********************************** PAGER ***********************************//

    /**
     * Hace clic en el botón del paginador para ir a la siguiente página.
     * Opcionalmente espera a que desaparezca el spinner de carga y verifica que no se muestren mensajes inesperados.
     *
     * @param waitForSpinner       Si es true, espera a que desaparezca el spinner de carga.
     * @param checkNoMessageShown  Si es true, verifica que no se muestren mensajes inesperados.
     * @throws Exception Si ocurre un error durante la ejecución.
     */
    public void clickBtnPagerNex(Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getBtnPagerNex();
        button.click();
        System.out.println("Click en boton siguiente del paginador");
        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    /**
     * Selecciona una opción en el paginador basado en los datos del JSON.
     *
     * @param element            El elemento del paginador en el que se hará clic.
     * @param jsonFieldData      El valor del campo del JSON que se desea seleccionar.
     * @param isRequired         Indica si el campo es obligatorio.
     * @param waitForSpinner     Si es true, espera a que desaparezca el spinner de carga.
     * @param checkNoMessageShown Si es true, verifica que no se muestren mensajes inesperados.
     * @throws Exception         Si ocurre un error durante la ejecución.
     */
    public void selectPager(WebElement element, String jsonFieldData, Boolean isRequired, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.out.println("...SKIPED!!");
                return;
            }
        } else if(jsonFieldData.equals(" ")) { //valor comodin para indicar que queremos validar que esté vacio y que no se los salte
            jsonFieldData = "";
        }

        click(element);
        WebElement elementVal = waitAndClickUntilDropdownOpen(element, By.xpath("//p-datatable[@class='tablaResulAjusteColumnasScroll']//p-paginator//select/option[text()='"+jsonFieldData+"']"), 5);
        String optionValue = getText(elementVal);
        System.out.println("Seleccionando...`"+jsonFieldData+"`"); //TODO: Cambiar a logger, para verlo en el reporte

        if (optionValue.equals(jsonFieldData)) {
            click(elementVal);
        }

        if(waitForSpinner.equals(Boolean.TRUE)) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if(checkNoMessageShown.equals(Boolean.TRUE)) {
            checkNoUnexpectedMessageIsShown();
        }
    }

    /**
     * Valida el número de filas en una tabla contra un valor proporcionado en el JSON.
     *
     * @param xpath              La ruta XPath para localizar las filas de la tabla.
     * @param jsonFieldData      El número de filas esperado según el JSON.
     * @param isRequired         Indica si la validación es obligatoria.
     * @param waitForSpinner     Si es true, espera a que desaparezca el spinner de carga.
     * @param checkNoMessageShown Si es true, verifica que no se muestren mensajes inesperados.
     * @throws Exception         Si ocurre un error durante la ejecución.
     */
    public void validatePagerRows(String xpath, Integer jsonFieldData, Boolean isRequired, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        int actualCount = elements.size();


        System.out.println("Cantidad de filas encontradas "+actualCount+"`");
        System.out.println("Cantidad de filas indicadas en el JSON "+jsonFieldData+"`");

        if (actualCount == jsonFieldData) {
            System.out.println("El numero de filas es igual que el indicado en el JSON.");
        } else if (actualCount > jsonFieldData) {
            throw new IllegalArgumentException("El numero de filas es mayor que el indicado en el JSON.");
        } else {
            throw new IllegalArgumentException("El numero de filas es menor que el indicado en el JSON.");
        }
    }

    /*************** FINAL POPUPS VALIDATIONS *******************/
    /**
     * Este metodo, lo que hace es recibir el titulo del popup y el mensaje esperado, espera a que sea visible,
     * también espera a que desaparezca el spinner y que no salgan otras ventanas de error.
     * @param title
     * @param message
     * @param timeToWait
     * @throws Exception
     * TODO: pasar este metodo a common service validate
     */
    public void waitMessageIsVisible(ModalTitle title, String message, int timeToWait) throws Exception {
        waitUntilIsDisplayed(homePageLocators.getFlexinetLoadingSpinner()); //TODO: esto quitarlo cuando termine de implementar commonTask.waitGrowlMessage
        System.out.println("@DEBUG spinner visible " + System.currentTimeMillis());
        try {
            List<LocatorCondition> locatorConditions = new ArrayList<>();
            locatorConditions.add(new LocatorCondition(homePageLocators.getFlexinetLoadingSpinnerBy(), false, false));
            locatorConditions.add(new LocatorCondition(pageLocators.getModalByXpath(title, message), true, true));

            List<By> locatorsNotToBeVisible = List.of();

            switch (title) {
                case INFORMACION:
                    locatorsNotToBeVisible = Arrays.asList(
                            pageLocators.getModalNotContainsMsgByXpath(title, message), //Si aparece un mensaje diferente al que esperamos
                            pageLocators.getMsgErrorByXpath() //Miramos que no se muestre ningún error, si se muestra alguno finaliza con error
                    );
                    break;
                case ERROR:
                    locatorsNotToBeVisible = Arrays.asList(
                            pageLocators.getModalNotContainsMsgByXpath(title, message), //Si aparece un mensaje de información con un mensaje que no sea el que esperamos
                            pageLocators.getMsgInfoByXpath() //Miramos que no se muestre ningún modal de información, dado que esperamos uno de error, si se muestra alguno finaliza con error
                    );
                    break;
            }

            waitUntilConditionMet(
                    locatorConditions,
                    locatorsNotToBeVisible,
                    120
            );

        } catch (AssertionError e) {
            throw new AssertionError("FAIL: Se ha mostrado un mensaje inesperado...");
        } catch (Exception e) {
            throw new AssertionError("No se ha mostrado el mensaje esperado transcurridos `"+timeToWait+"` segundos..." + e);
        }
    }

    /**
     *
     * @param modalTitle
     * @param panelTitle
     * @param message
     * @param notContains este paremetro indica que en el xpath se hará un notcontains es decir que se capturará el elemento siempre que el mensaje no sea igual al que le hemos indicado
     * @return
     * @throws Exception
     */
    public By getLocator(ModalTitle modalTitle, PanelTitle panelTitle, String message, boolean notContains) throws Exception {
        if (panelTitle != null && modalTitle == null) {
            if(notContains) {
                //return pageLocators.getDialogNotContainsMsgByXpath(message); //TODO pendiente de hacer
            } else {
                return pageLocators.getDialogMsgByXpath(panelTitle, message);
            }
        } else if (modalTitle != null && panelTitle == null) {
            if(notContains) {
                return pageLocators.getModalNotContainsMsgByXpath(modalTitle, message);
            } else {
                return pageLocators.getModalByXpath(modalTitle, message);
            }
        }
        return null;
    }


    public List<LocatorCondition> createLocatorConditions(List<By> locators) {
        List<LocatorCondition> conditions = new ArrayList<>();
        conditions.add(new LocatorCondition(homePageLocators.getFlexinetLoadingSpinnerBy(), false, false));
        for (By locator : locators) {
            conditions.add(new LocatorCondition(locator, true, true));
        }
        return conditions;
    }
}
