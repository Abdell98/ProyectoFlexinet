package com.eulen.flexinet.core.test.selenium.database;

public class GestionCentroDeTrabajoQuery {
    public static String getConsulta(String idcliente, String user) {

        return String.format(
                "SELECT * FROM CENTRO c WHERE ID_CLIENTE = '%s' AND NIF_USU = (SELECT u.NIF_USU FROM USUARIO u WHERE u.COD_USU = '%s') AND FOPERA >= CURRENT DATE ORDER BY FOPERA DESC"
        , idcliente, user);
    }
}