package com.eulen.flexinet.core.test.selenium.pages;

import com.eulen.flexinet.core.test.selenium.Locators.LocatorCondition;
import com.eulen.flexinet.core.test.selenium.reader.*;
import com.eulen.flexinet.core.test.selenium.csvservice.CSVWriter;
import com.eulen.flexinet.core.test.selenium.csvservice.CSVReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;

import static com.eulen.flexinet.core.test.selenium.steps.util.Hooks.getEnv;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private Actions actions;
    protected static LoginData loginData;
    protected static GestionClientesContratoData gestionClientesContratoData; //@data
    protected static GestionCentrosDeTrabajoData gestionCentrosDeTrabajoData; //@data
    protected static TestDatos datos; //@data
    protected static TestDatosContrato datosContrato; //@data
    protected static TestDatosFacturacion datosFacturacion; //@data
    protected static TestDatosPartesDeHoras datosPartesDeHoras; //@data
    protected static TestDatosGestionDeEmpresaCliente datosGestionDeEmpresaCliente; //@data
    protected static TestDatosConsultaAvanzadaDePartesDeHoras datosConsultaAvanzadaDePartesDeHoras; //@data
    protected static TestDatosInformeDigitalParaCierreDeNomina datosInformeDigitalParaCierreDeNomina; //@data
    protected static TestDatosGeneracionMasivaPartes datosGeneracionMasivaPartes; //@data
    protected static TestDatosGestionITs datosGestionITs; //@data

    public static SoftAssertions softly = new SoftAssertions();

    @Getter @Setter
    private static String auxiliarKey;

    @Getter @Setter
    private static String auxiliarFile;

    protected static Map<String, Object> datosMap;
    final int SECONDS_TO_WAIT = 120;
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        BasePage.wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS_TO_WAIT));
        this.actions = new Actions(driver);
    }

    /**
     * Este metodo basicamente sirve para mover el cursor a un elemento especifico
     * @param element
     * @throws Exception
     */
    public void moveTo(WebElement element) throws Exception {
        try {
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                actions.moveToElement(element).perform();
            } catch (Exception e2) {
                throw new Exception("Could not be found item " + element);
            }
        }
    }

    /**
     * This method verifies that the indicated element has been deployed correctly.
     * @param element This is the element to be verified.
     * @return True if element is displayed
     * @return false if element is not displayed
     */
    public boolean waitUntilIsDisplayed(WebElement element) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            throw new Exception("Item could not be found " + element + e.getStackTrace());
        }
    }

    public String waitForElementWithText(By locator, long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver input) {
                try {
                    WebElement element = driver.findElement(locator);
                    String text = element.getText();
                    // Verifica si el texto no es nulo ni vacio y luego retorna el texto
                    if (text != null && !text.isEmpty()) {
                        return text;
                    } else {
                        return null; // retorna null si el textro es vacio o nulo para seguir esperando
                    }
                }  catch (Exception e) {
                    return null; // Si no se encuentra el elemento o hay algún otro error, retorna null para seguir esperando
                }
            }

            @Override
            public String toString() {
                return "wait for the element to have some text: " + locator;
            }
        });
    }

    /**
     * Espera hasta que un localizador sea visible
     * @param xpath
     * @return
     * @throws Exception
     */
    public WebElement waitUntilIsDisplayed(By xpath) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
            return driver.findElement(xpath);
        } catch (Exception e) {
            throw new NotFoundException("Item could not be found " + xpath);
        }
    }

    public WebElement waitUntilIsDisplayed(WebElement element, By xpath) throws Exception {
        try {
            wait.until(childElementFound(element, xpath));
            return element.findElement(xpath);
        } catch (Exception e) {
            throw new Exception("Item could not be found " + element);
        }
    }

    public void waitUntilAttributeNotFound(WebElement element, String attribute, String value, int secondsToWait) throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(element, attribute, value)));
        } catch (Exception e) {
            throw new Exception("Timeout after wait `"+secondsToWait+"` seconds to the element attribute `"+attribute+"` does not have the value `"+value+"` ..." + element);
        } finally {
            wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS_TO_WAIT));
        }
    }

    public void waitUntilElementStale(WebElement element, int secondsToWait) throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        try {
            wait.until(ExpectedConditions.stalenessOf(element));
        } catch (Exception e) {
            throw new Exception("Timeout after wait `"+secondsToWait+"` to the element be stale...");
        } finally {
            wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS_TO_WAIT));
        }
    }

    public void waitUntilBeClickable(WebElement element) throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new Exception("Item could not be found " + element);
        }
    }

    public WebElement waitAndClickUntilDropdownOpen(WebElement element, By optionXpath, int timeToWait) throws Exception {
        final WebElement[] elementVal = new WebElement[1];

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeToWait)) // aplicar time to wait
                .pollingEvery(Duration.ofSeconds(1L))
                .ignoring(NoSuchElementException.class);
        try {
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    try {
                        System.out.println("@DEBUG intentando seleccionar la opcion " + optionXpath);
                        elementVal[0] = element.findElement(optionXpath);
                        return elementVal[0].isDisplayed();
                    } catch (Exception e1) {
                        try {
                            click(element);
                            System.out.println("@DEBUG no se encontró la opcion volviendo a clicar");
                            return false;
                        } catch (Exception e2) {
                            throw new NotFoundException("ERROR: No se ha encontrado el campo");
                        }
                    }
                }
            });
        } catch (TimeoutException e) {
            throw new Exception("ERROR: La opción no fue encontrada despues de " + timeToWait + " segundos");
        }

        return elementVal[0];
    }

    /**
     * Este metodo recibe una lista ordenada de localizadores y cada uno viene con una variable booleana que indican si esperamos
     * que sea o no visible, además una segunda condición booleana sirve para confirmar que si es verdadera se salta el resto de
     * localizadores y pasa luego a evaluar otro listado de localizadores que no quedemos que sean visibles y si lo son dará error.
     * @param locatorConditions
     * @param locatorsNotToBeVisible
     * @param timeToWait
     * @throws Exception
     */
    public By waitUntilConditionMet(
            List<LocatorCondition> locatorConditions,
            List<By> locatorsNotToBeVisible,
            int timeToWait
    ) throws Exception {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait)); //Cambiamos el tiempo de espera al indicado para realizar el proceso.
            final String[] message = new String[1];
            final By[] locator = new By[1];
            wait.pollingEvery(Duration.ofMillis(1));
            wait.until(driver -> {
                System.out.println("@DEBUG intentando declarar tiempo implicito");
                boolean isConditionMet = false;
                for (LocatorCondition entry : locatorConditions) {
                    By originalLocator = locator[0] = entry.getLocator();
                    By modifiedLocator;
                    if(originalLocator.toString().contains("(.*)")) {
                        String originalLocatorString = originalLocator.toString();
                        String extractedXpath = originalLocatorString.substring(originalLocatorString.indexOf(": ") + 2);
                        String modifiedXpath = extractedXpath.replace("(.*)","') and contains(normalize-space(.), '");
                        modifiedLocator = By.xpath(modifiedXpath);
                        System.out.println("@DEBUG el mensaje contiene `(.*)` el localizador se ha modificado a: " + modifiedXpath);
                    } else {
                        modifiedLocator = entry.getLocator();
                    }
                    Boolean shouldBeVisible = entry.getCondition1();
                    Boolean ifTrueThenAllConditionsAreMet = entry.getCondition2();
                    System.out.println("@DEBUG..." + System.currentTimeMillis() + " " + modifiedLocator);
                    try {
                        isConditionMet = shouldBeVisible == driver.findElement(modifiedLocator).isDisplayed();
                        System.out.println("@DEBUG 1 isConditionMet..." + isConditionMet);
                    } catch (Exception e) {
                        System.out.println("@DEBUG 2 isConditionMet..." + isConditionMet);
                        // Si se espera que el elemento sea visible
                        isConditionMet = !shouldBeVisible;
                    }
                    if (isConditionMet && ifTrueThenAllConditionsAreMet) {
                        break;
                    }
                }

                for (By singleNotToBeVisibleLocator : locatorsNotToBeVisible) {
                    boolean unexpectedLocatorIsVisible = false;
                    try {
                        System.out.println("@DEBUG nottobevisible " + singleNotToBeVisibleLocator);
                        WebElement errorGrowl = driver.findElement(singleNotToBeVisibleLocator);
                        errorGrowl.isDisplayed();
                        message[0] = errorGrowl.getText();
                        unexpectedLocatorIsVisible = true;
                    } catch (Exception e) {
                        System.out.println("@DEBUG ok no se ha mostrado ninguna ventana no esperada...");
                        // Elemento no encontrado o no visible, lo cual está bien
                    }
                    if (unexpectedLocatorIsVisible) {
                        throw new AssertionError("ERROR: Se mostrado un elemento inesperado...\n`" + message[0] + "`");
                    }
                }

                return isConditionMet;
            });
            return locator[0];
        } catch (AssertionError e) {
            throw new AssertionError(e.getMessage());
        } catch (Exception e) {
            System.out.println("@DEBUG no se ha cumplido");
            throw new Exception(e.getMessage());
        } finally {
            wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS_TO_WAIT)); //Volvemos a dejar el tiempo como estaba al finalizar
        }
    }


    public boolean waitUntilIsNotDisplayed(WebElement element, int secondsToWait) throws Exception {

        long startTime = System.currentTimeMillis();
        long endTime = 0;
        long elapsedTime = 0;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            System.out.println("Loading - elapsed time: " + elapsedTime/1000f);
            return true;
        } catch (TimeoutException e) {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            throw new TimeoutException("Error de timeout al esperar por mas de " + elapsedTime + " milisegundos que el elemento dejara de ser visible ");
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
            throw new Exception("Ha ocurrido un error no controlado: ", e);
        } finally {
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS_TO_WAIT));
        }
    }

    /**
     * This method wait till the blue loading spinner finishes, this spinner change the class name from pace-done
     * to pace-running on the body tag meanwhile the spinner is visible, so this will wait till the class is pace-done
     * @param element
     * @return
     * @throws Exception
     */
    public void waitForSpinner(WebElement element) throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            throw new TimeoutException("Error de timeout al esperar al spinner por mas de " + elapsedTime + " milisegundos");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error no controlado " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ExpectedCondition<Boolean> childElementFound(final WebElement element, final By xpath) throws Exception {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    element.findElement(xpath);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        };
    }

    public void click(WebElement element) throws Exception {
        try {
            verticalScrollTo(element);
            element.click();
        } catch (Exception e) {
            try {
                actions.moveToElement(element).click().build().perform();
            } catch (Exception e2) {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    this.click(element);
                } catch (Exception e3) {
                    throw new Exception("Could not click on item " + element);
                }
            }
        }
    }

    public void sendKeys(WebElement element, String string) throws Exception {
        if (string != null && !string.isEmpty()) {
            this.click(element);
            actions.sendKeys(string).perform();
        } else {
            System.out.println("El valor de cadena proporcionado es nulo o vacío");
        }
    }

    public void clear(WebElement element) throws Exception {
        this.click(element);
        element.clear();
    }

    public void jsonFile(String jsonFileName) throws Exception {
        JsonReader jsonReader = new JsonReader("src/test/java/com/eulen/flexinet/core/test/selenium/data/"+getEnv()+"/"+ jsonFileName);
        //@data
        loginData = jsonReader.getData();
        //TODO: borrar la siguiente linea luego de probar GestionEmpresaCliente
        //gestionEmpresaClienteData = jsonReader.getGestionEmpresaClienteData();
        gestionClientesContratoData = jsonReader.getGestionClientesContratoData();
        gestionCentrosDeTrabajoData = jsonReader.gestionCentrosDeTrabajoData();

        if (loginData == null) {
            throw new IllegalArgumentException("Hubo un error al leer el archivo JSON " + jsonReader);
        }
    }

    //TODO: nueva version del jsonFile que usa la nueva clase JsonReader que permitirá usar un solo archivo json dividido en arrays u objetos.
    // Cambiar a este nuevo metodo cuando se haya comprobado que funciona bien
    public void jsonFileNew(String jsonFileName) throws Exception {
        JsonReaderNew jsonReaderNew = new JsonReaderNew();
        jsonReaderNew.leerJson("src/test/java/com/eulen/flexinet/core/test/selenium/data/"+getEnv()+"/"+ jsonFileName);

        datos = jsonReaderNew.getDatos();
        datosContrato = jsonReaderNew.getDatosContrato();
        datosPartesDeHoras = jsonReaderNew.getDatosPartesDeHoras();
        datosGestionDeEmpresaCliente = jsonReaderNew.getDatosGestionEmpresaCliente();
        datosGeneracionMasivaPartes = jsonReaderNew.getDatosGeneracionMasivaPartes();
        datosConsultaAvanzadaDePartesDeHoras = jsonReaderNew.getDatosConsultaAvanzadaDePartesDeHoras();
        datosInformeDigitalParaCierreDeNomina = jsonReaderNew.getDatosInformeDigitalParaCierreDeNomina();
        datosFacturacion = jsonReaderNew.getDatosFacturacion();
        datosGestionITs = jsonReaderNew.getDatosGestionITs();
        //datosOtraPagina = jsonReaderNew.getOtraPagina();
    }

    public void jsonFileToMap(String jsonFileName) throws Exception {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String,Object>>(){}.getType();
        Path filePath = Paths.get("src/test/java/com/eulen/flexinet/core/test/selenium/data/" + getEnv() + "/" + jsonFileName);

        try (InputStream inputStream = Files.newInputStream(filePath);
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            datosMap = gson.fromJson(reader, type);

        } catch (IOException e) {
            throw new IllegalArgumentException("Hubo un error al leer el archivo JSON " + filePath + "\n" + e);
        }
    }

    public Map<String, String > jsonFileToMapNew(String jsonFileName, String jsonObjectPath) throws Exception {
        JsonReaderNew convertirAmap = new JsonReaderNew();
        //INFO: @MODGIO01
        String[] parts = jsonFileName.split(";", 2);
        String path = parts[0];

        String ruta = "src/test/java/com/eulen/flexinet/core/test/selenium/data/" + getEnv() + "/" + path;
        Map<String, String > mapa = convertirAmap.convertirTablaAMapDesdeJson(ruta, jsonObjectPath);
        return mapa;
    }

    public void jsonUpdate(String file, String propertyPath, String value) {
        JsonUpdater jsonUpdater = new JsonUpdater();

        String filepath = "src/test/java/com/eulen/flexinet/core/test/selenium/data/" + getEnv() + "/" + file;

        jsonUpdater.jsonUpdateGson(filepath, propertyPath, value);
    }

    public void writeDataToCSV(List<Map<String, Object>> data, String filePath) {
        CSVWriter.writeDataToCSV(data, "src/test/java/com/eulen/flexinet/core/test/selenium/data/" + getEnv() + "/" + filePath);
    }

    public String getValueFromCSV(String filePath, String column, int rowIndex) throws IOException {
        return CSVReader.getValueFromCSV("src/test/java/com/eulen/flexinet/core/test/selenium/data/" + getEnv() + "/" + filePath, column, rowIndex);
    }

    public int countSizeInCSV(String filePath) throws IOException {
        return CSVReader.countSizeInCSV("src/test/java/com/eulen/flexinet/core/test/selenium/data/" + getEnv() + "/" + filePath);
    }

    public String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        } catch (Exception e) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                return element.getText();
            } catch (Exception e2) {
                throw new Exception("Could not get text of item " + element);
            }
        }
    }

    public void verticalScrollTo(WebElement element) throws Exception {
        try {
            Thread.sleep(300);
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                    element);
            Thread.sleep(300);
        } catch (Exception e) {
            throw new Exception("Could not be found item " + element);
        }
    }

    /**
     * Drag an element to another
     * @param fromElement
     * @param toElement
     */
    public void dragAndDrop(WebElement fromElement, WebElement toElement) throws Exception {
        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release()
                .build();

        dragAndDrop.perform();
    }

    public Map<String,Integer> dateToMap(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

        Map<String, Integer> dateMap = new HashMap<>();

        dateMap.put("dia", localDate.getDayOfMonth());
        dateMap.put("mes", localDate.getMonthValue());
        dateMap.put("año", localDate.getYear());

        return dateMap;
    }

    /**
     * Extract the table from the given element, parsed into a SortedMap
     * @param element
     * @return
     * @throws Exception
     */
    public SortedMap<Integer , Map<String, String>> tableExtractor(WebElement element) throws Exception {
        List<WebElement> headers;
        List<WebElement> rows;
        WebElement table = element;

        try {
            headers = table.findElements(By.xpath("./thead/tr/th/*[contains(@class,'ui-column-title') or self::p-dtcheckbox]"));
            //headers = table.findElements(By.xpath("./thead/tr/th"));
            rows = table.findElements(By.xpath("./tbody/tr"));
        } catch (Exception e) {
            throw new Exception("ERROR: No se han encontrado resultados...");
        }

        SortedMap<Integer , Map<String, String>> tableData = new TreeMap<>();

        for(int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            List<WebElement> cells = rows.get(rowIndex).findElements(By.tagName("td"));
            Map<String, String> rowData = new TreeMap<>();
            System.out.println("@DEBUG imprimiendo lista celdas: " + Arrays.toString(cells.toArray()));
            for (int i = 0; i < headers.size() && i < cells.size(); i++) {
                String headerAux = headers.get(i).getText();
                String cellAux = cells.get(i).getText();
                rowData.put(headerAux, cellAux);
            }

            tableData.put(rowIndex, rowData);
        }

        return tableData;
    }

    public SortedMap<Integer , Map<String, WebElement>> tableExtractorToWebElement(WebElement element) throws Exception {
        List<WebElement> headers;
        List<WebElement> rows;
        WebElement table = element;

        try {
            headers = table.findElements(By.xpath("./thead/tr/th/span[contains(@class,'ui-column-title')]"));
            rows = table.findElements(By.xpath("./tbody/tr"));
        } catch (Exception e) {
            throw new Exception("ERROR: No se han encontrado resultados...");
        }

        SortedMap<Integer , Map<String, WebElement>> tableData = new TreeMap<>();

        for(int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            List<WebElement> cells = rows.get(rowIndex).findElements(By.tagName("td"));
            Map<String, WebElement> rowData = new TreeMap<>();

            for (int i = 0; i < headers.size() && i < cells.size(); i++) {
                rowData.put(headers.get(i).getText(), cells.get(i));
            }

            tableData.put(rowIndex, rowData);
        }

        return tableData;
    }

    public void makeScreenshotWithTitle(String description) throws IOException {
        try {
            // toma la captura de pantalla
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // construye el nombre del archivo
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            Path destinationPath = Path.of("target/site/serenity/tmp_" + timestamp + "_screenshot.png");

            // Guarda la captura de pantalla en el directorio de destino
            Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

//            // Convierte la captura de pantalla en un array de bytes
//            byte[] screenshotData = Files.readAllBytes(destinationPath);

            // Añade la captura de pantalla al reporte de serenity
            Serenity.recordReportData()
                    .withTitle(description)
                    .downloadable()
                    .fromFile(destinationPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
