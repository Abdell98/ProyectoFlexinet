package com.eulen.flexinet.core.test.selenium.Pom.service.util;

import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.reader.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonCommand {

    protected static TestDatos datos; //@data
    protected static TestDatosContrato datosContrato; //@data
    protected static TestDatosFacturacion datosFacturacion; //@data
    protected static TestDatosPartesDeHoras datosPartesDeHoras; //@data
    protected static TestDatosGestionDeEmpresaCliente datosGestionDeEmpresaCliente; //@data
    protected static TestDatosConsultaAvanzadaDePartesDeHoras datosConsultaAvanzadaDePartesDeHoras; //@data
    protected static TestDatosInformeDigitalParaCierreDeNomina datosInformeDigitalParaCierreDeNomina; //@data
    protected static TestDatosGeneracionMasivaPartes datosGeneracionMasivaPartes; //@data
    protected static TestDatosGestionITs datosGestionITs;


    public String convertCommandToDate(String data) {
        if (data != null && data.startsWith("%") && data.endsWith("%")) {
            data = data.replaceAll("%","");
            if(data.startsWith(JsonCommandList.TODAY.toString())) {
                LocalDate currentdate = LocalDate.now();
                String year = Integer.toString(currentdate.getYear());
                String month = currentdate.getMonthValue() <= 9 ? "0" + currentdate.getMonthValue() : Integer.toString(currentdate.getMonthValue());
                String day = currentdate.getDayOfMonth() <= 9 ? "0" + currentdate.getDayOfMonth() : Integer.toString(currentdate.getDayOfMonth());
                data = day + "/" + month + "/" + year;
                System.out.println("@DEBUG TODAY jsonvalue = " + data);
                return data;
            } else if(data.startsWith(JsonCommandList.PLUS.toString())){
                Pattern pattern = Pattern.compile("PLUS(\\d+)");
                Matcher matcher = pattern.matcher(data);
                if(matcher.find()) {
                    String numberStr = matcher.group(1);
                    int number = Integer.parseInt(numberStr);
                    LocalDate currentdate = LocalDate.now().plusDays(number);
                    String year = Integer.toString(currentdate.getYear());
                    String month = currentdate.getMonthValue() <= 9 ? "0" + currentdate.getMonthValue() : Integer.toString(currentdate.getMonthValue());
                    String day = currentdate.getDayOfMonth() <= 9 ? "0" + currentdate.getDayOfMonth() : Integer.toString(currentdate.getDayOfMonth());
                    data = day + "/" + month + "/" + year;
                    System.out.println("@DEBUG PLUS jsonvalue = " + data);
                    //return data;
                }
                return data;
            } else if (data.startsWith(JsonCommandList.MINUS.toString())) {
                Pattern pattern = Pattern.compile("MINUS(\\d+)");
                Matcher matcher = pattern.matcher(data);
                if(matcher.find()) {
                    String numberStr = matcher.group(1);
                    int number = Integer.parseInt(numberStr);
                    LocalDate currentdate = LocalDate.now().minusDays(number);
                    String year = Integer.toString(currentdate.getYear());
                    String month = currentdate.getMonthValue() <= 9 ? "0" + currentdate.getMonthValue() : Integer.toString(currentdate.getMonthValue());
                    String day = currentdate.getDayOfMonth() <= 9 ? "0" + currentdate.getDayOfMonth() : Integer.toString(currentdate.getDayOfMonth());
                    data = day + "/" + month + "/" + year;
                    System.out.println("@DEBUG MINUS jsonvalue = " + data);
                    //return data;
                }
                return data;
            } else {
                return data;
            }
        } else {
            return data;
        }
    }

    public boolean convertCommandBtnClickToBoolean(String data) {
        if (data != null && data.startsWith("%") && data.endsWith("%")) {
            data = data.replaceAll("%","");
            return data.startsWith(JsonCommandList.DO_CLICK.toString());
        } else {
            return false;
        }
    }

    public static String reemplazarConTextoAleatorio(String input) {
        StringBuffer sb = new StringBuffer();

        // Compilar un patrón que coincida con ambos %RANDOM_TEXT% y %RANDOM_KEY%
        Pattern patron = Pattern.compile("%RANDOM_TEXT%|%RANDOM_KEY%");
        Matcher matcher = patron.matcher(input);

        // Reemplazar cada coincidencia con una cadena aleatoria
        while (matcher.find()) {
            String textoAleatorio = generarTextoAleatorio(10); // Generar texto aleatorio de 10 caracteres
            matcher.appendReplacement(sb, textoAleatorio);

            // Si la coincidencia es %RANDOM_KEY%, establecerla como clave temporal
            if ("%RANDOM_KEY%".equals(matcher.group())) {
                BasePage.setAuxiliarKey(textoAleatorio);
            }
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

    public static String generarTextoAleatorio(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return sb.toString();
    }

    /*
    * Metodo que devuelve un mapa con con el anio, mes y dia formateados a String
    * Recibe como parametro la fecha en formato comando
     */
    public Map<String, String> dateToYearMonthDay (String comandoFecha) {

        Map<String, String> fechaCompleta = new HashMap<>();

        String jsonFieldData = convertCommandToDate(comandoFecha);
        System.out.println(jsonFieldData);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(jsonFieldData, formatter);

        Map<String, Integer> fechaMap = new HashMap<>();

        fechaMap.put("dia", localDate.getDayOfMonth());
        fechaMap.put("mes", localDate.getMonthValue());
        fechaMap.put("año", localDate.getYear());

        String[] mesesCapital = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        fechaCompleta.put("anio", fechaMap.get("año").toString());

        String nombreMesCapital = "";

        int indiceMes = fechaMap.get("mes") - 1;

        if(indiceMes >= 0 && indiceMes < 12) {

            nombreMesCapital = mesesCapital[indiceMes];
        }
        fechaCompleta.put("mes", nombreMesCapital);

        fechaCompleta.put("dia", fechaMap.get("dia").toString());


        return fechaCompleta;
    }


}
