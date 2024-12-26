package com.eulen.flexinet.core.test.selenium.database;

public class GestionClienteContratoQuery {
    public static String getConsulta(String nif, String oficina) {

        return String.format(
                " SELECT " +
                        "SUBSTR(cc.ID_CLIENTE,1,LOCATE('-', cc.ID_CLIENTE) - 1 ) AS NUMERO_CLIENTE," +
                        "(SELECT CONCAT(CONCAT(CONCAT(u.NOMBRE,' '),u.APELLIDO1),CONCAT(' ',u.APELLIDO2)) FROM USUARIO u WHERE cc.NIF_EJECUT = u.NIF_USU) AS EJECUTIVO_DE_CUENTA," +
                        "(SELECT mc.NOMBRE FROM MEDIO_CAPT mc WHERE cc.ID_MEDIO_C = mc.ID_MEDIO_C) AS MEDIO_DE_CAPT," +
                        "(SELECT con.NOMBRE FROM CONVENIO con WHERE cc.ID_CNV = con.ID_CNV) AS CONVENIO, " +
                        "(SELECT con.ID_ADM FROM CONVENIO con WHERE cc.ID_CNV = con.ID_CNV) AS BOE," +
                        "cc.TELEFONO," +
                        "(SELECT p.LITERAL AS CLAUSURADO_CONTRATO_LABORAL FROM PLANTILLA p WHERE cc.ID_PLN_CL = p.ID_PLN)," +
                        "(SELECT p.LITERAL AS CLAUSURADO_CPD FROM PLANTILLA p WHERE cc.ID_PLN_CPD = p.ID_PLN)," +
                        "cc.OBSERV AS OBSERVACIONES," +
                        "(SELECT ct.BANCO AS ENTIDAD FROM CTA_CTE ct WHERE cc.ID_CTA_ETT = ct.ID_CTA)," +
                        "(SELECT ct.BANSUC AS SUCURSAL FROM CTA_CTE ct WHERE cc.ID_CTA_ETT = ct.ID_CTA)," +
                        "(SELECT ct.DIGIT_CTRL AS DC FROM CTA_CTE ct WHERE cc.ID_CTA_ETT = ct.ID_CTA)," +
                        "(SELECT ct.NUMERO_CTA AS NUMERO_CUENTA FROM CTA_CTE ct WHERE cc.ID_CTA_ETT = ct.ID_CTA)," +
                        "(SELECT ct.IBAN_PAIS AS IBAN_PAIS FROM CTA_CTE ct WHERE cc.ID_CTA_ETT = ct.ID_CTA)," +
                        "(SELECT ct.IBAN_DC AS IBAN_DC FROM CTA_CTE ct WHERE cc.ID_CTA_ETT = ct.ID_CTA)," +
                        "(SELECT ct.IBAN34 AS IBAN_EXTRANJERO FROM CTA_CTE ct WHERE cc.ID_CTA_ETT = ct.ID_CTA)," +
                        "(SELECT (SELECT tv.DESCRIPCIO AS TIPO_DIR_FACTURA FROM TIPO_VIA tv WHERE d.ID_TIPO_VI = tv.ID_TIPO_VI) FROM DIRECCION d WHERE cc.DIR_FACTUR = d.ID_DIR)," +
                        "(SELECT (SELECT d.NOMBRE AS NOMBRE_DIR_FACTURA FROM TIPO_VIA tv WHERE d.ID_TIPO_VI = tv.ID_TIPO_VI) FROM DIRECCION d WHERE cc.DIR_FACTUR = d.ID_DIR)," +
                        "(SELECT d.LOCALIDAD AS LOCALIDAD_DIR_FACTURA FROM DIRECCION d WHERE cc.DIR_FACTUR = d.ID_DIR)," +
                        "(SELECT (SELECT UPPER(p.NOM_PROVINCIA) AS PROVINCIA_DIR_FACTURA FROM PROVINCIA p WHERE SUBSTRING(LPAD(d.CP, 5, '0') FROM 1 FOR 2) = p.PREFIJO_POSTAL) FROM DIRECCION d WHERE cc.DIR_FACTUR = d.ID_DIR)," +
                        "(SELECT LPAD(d.CP, 5, '0') AS CP_DIR_FACTURA FROM DIRECCION d WHERE cc.DIR_FACTUR = d.ID_DIR)," +
                        "cc.DESTINATAR AS DESTINATARIO," +
                        "(SELECT v.DESCRIPCIO  FROM VENTAS v WHERE cc.ID_VENTAS = v.ID_VENTAS) AS VENTAS," +
                        "(SELECT re.DESCRIPCIO FROM RANGO_EMP re WHERE  cc.ID_RANG_EM = re.ID_RANG_EM) AS RANGO_EMPLEADOS" +
                        " FROM " +
                        "CLIENT_CON cc" +
                        " WHERE " +
                        "cc.NIF_EMP = '%s'" +
                        " AND cc.ID_OFICINA = (SELECT o.ID_OFICINA FROM OFICINA o WHERE o.LITERAL = '%s')"
                , nif, oficina);
    }
}
