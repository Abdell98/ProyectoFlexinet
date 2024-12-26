package com.eulen.flexinet.core.test.selenium.database;

public class GestionEmpresaClienteQuery {
    public static String getConsulta(String nif, String oficina) {

        return String.format(
                "SELECT" +
                        "(" +
                        "          SELECT" +
                        "cc.BANCO AS ENTIDAD" +
                        "FROM" +
                        "CTA_CTE cc" +
                        "WHERE" +
                        "e.ID_CTA_ETT = cc.ID_CTA)," +
                        "(" +
                        "          SELECT" +
                        "cc.BANSUC AS SUCURSAL" +
                        "FROM" +
                        "CTA_CTE cc" +
                        "WHERE" +
                        "e.ID_CTA_ETT = cc.ID_CTA)," +
                        "(" +
                        "          SELECT" +
                        "cc.DIGIT_CTRL AS DC" +
                        "FROM" +
                        "CTA_CTE cc" +
                        "WHERE" +
                        "e.ID_CTA_ETT = cc.ID_CTA)," +
                        "(" +
                        "          SELECT" +
                        "cc.NUMERO_CTA AS NUMERO_CUENTA" +
                        "FROM" +
                        "CTA_CTE cc" +
                        "WHERE" +
                        "e.ID_CTA_ETT = cc.ID_CTA)," +
                        "(" +
                        "          SELECT" +
                        "cc.IBAN_PAIS AS IBAN_PAIS" +
                        "FROM" +
                        "CTA_CTE cc" +
                        "WHERE" +
                        "e.ID_CTA_ETT = cc.ID_CTA)," +
                        "(" +
                        "          SELECT" +
                        "cc.IBAN_DC AS IBAN_DC" +
                        "FROM" +
                        "CTA_CTE cc" +
                        "WHERE" +
                        "e.ID_CTA_ETT = cc.ID_CTA)," +
                        "(" +
                        "          SELECT" +
                        "cc.IBAN34 AS IBAN_EXTRANJERO" +
                        "FROM" +
                        "CTA_CTE cc" +
                        "WHERE" +
                        "e.ID_CTA_ETT = cc.ID_CTA)," +
                        "(" +
                        "          SELECT" +
                        "(" +
                        "                    SELECT" +
                        "tv.DESCRIPCIO AS TIPO_DIR_FACTURA" +
                        "FROM" +
                        "TIPO_VIA tv" +
                        "WHERE" +
                        "d.ID_TIPO_VI = tv.ID_TIPO_VI)" +
                        "FROM" +
                        "DIRECCION d" +
                        "WHERE" +
                        "e.DIR_FACTUR = d.ID_DIR)," +
                        "(" +
                        "          SELECT" +
                        "(" +
                        "                    SELECT" +
                        "d.NOMBRE AS DIRECCION_DIR_FACTURA" +
                        "FROM" +
                        "TIPO_VIA tv" +
                        "WHERE" +
                        "d.ID_TIPO_VI = tv.ID_TIPO_VI)" +
                        "FROM" +
                        "DIRECCION d" +
                        "WHERE" +
                        "e.DIR_FACTUR = d.ID_DIR)," +
                        "(" +
                        "          SELECT" +
                        "d.LOCALIDAD AS LOCALIDAD_DIR_FACTURA" +
                        "FROM" +
                        "DIRECCION d" +
                        "WHERE" +
                        "e.DIR_FACTUR = d.ID_DIR)," +
                        "(" +
                        "          SELECT" +
                        "TRIM(de.PRO_FAC) AS PROVINCIA_DIR_FACTURA" +
                        "FROM" +
                        "DATOS_EMPR de" +
                        "WHERE" +
                        "e.NIF_EMP = de.NIF_EMP)," +
                        "(" +
                        "          SELECT" +
                        "d.CP AS CP_DIR_FACTURA" +
                        "FROM" +
                        "DIRECCION d" +
                        "WHERE" +
                        "e.DIR_FACTUR = d.ID_DIR)," +
                        "e.DESTINATAR AS DESTINATARIO      ," +
                        "(" +
                        "          SELECT" +
                        "p.LITERAL AS CLAUSURADO_CONTRATO_LABORAL" +
                        "FROM" +
                        "PLANTILLA p" +
                        "WHERE" +
                        "e.ID_PLN_CL = p.ID_PLN)," +
                        "(" +
                        "          SELECT" +
                        "p.LITERAL AS CLAUSURADO_CPD" +
                        "FROM" +
                        "PLANTILLA p" +
                        "WHERE" +
                        "e.ID_PLN_CPD = p.ID_PLN)" +
                        "FROM" +
                        "EMPRESA e" +
                        "WHERE" +
                        "e.NIF_EMP = %s"
        , nif);
    }

    public static String getExternalMiscEnvios(String user) {
        return String.format("SELECT ID_LOTE, CD_STATUS, FECHA_ENVIO, FECHA_CREACION, FECHA_ACTUALIZACION, ID_USUARIO_CREADOR, ID_USUARIO_ACTUALIZADOR FROM EXTERNAL_MISC_ENVIO ex WHERE ex.ID_USUARIO_CREADOR =(SELECT u.NIF_USU FROM USUARIO u WHERE u.COD_USU = '"+user+"') AND ex.FECHA_CREACION >= CURRENT DATE ORDER BY ex.FECHA_CREACION DESC");
    }

    public static String getEmpresaBy(String nifemp) {
        return String.format("SELECT(SELECT cc.BANCO AS ENTIDAD FROM CTA_CTE cc WHERE e.ID_CTA_ETT = cc.ID_CTA), (SELECT cc.BANSUC AS SUCURSAL FROM CTA_CTE cc WHERE e.ID_CTA_ETT = cc.ID_CTA), (SELECT cc.DIGIT_CTRL AS DC FROM CTA_CTE cc WHERE e.ID_CTA_ETT = cc.ID_CTA), (SELECT cc.NUMERO_CTA AS NUMERO_CUENTA FROM CTA_CTE cc WHERE e.ID_CTA_ETT = cc.ID_CTA), (SELECT cc.IBAN_PAIS AS IBAN_PAIS FROM CTA_CTE cc WHERE e.ID_CTA_ETT = cc.ID_CTA), (SELECT cc.IBAN_DC AS IBAN_DC FROM CTA_CTE cc WHERE e.ID_CTA_ETT = cc.ID_CTA), (SELECT cc.IBAN34 AS IBAN_EXTRANJERO FROM CTA_CTE cc WHERE e.ID_CTA_ETT = cc.ID_CTA), (SELECT (SELECT tv.DESCRIPCIO AS TIPO_DIR_FACTURA FROM TIPO_VIA tv WHERE d.ID_TIPO_VI = tv.ID_TIPO_VI) FROM DIRECCION d WHERE e.DIR_FACTUR = d.ID_DIR), (SELECT (SELECT d.NOMBRE AS DIRECCION_DIR_FACTURA FROM TIPO_VIA tv WHERE d.ID_TIPO_VI = tv.ID_TIPO_VI) FROM DIRECCION d WHERE e.DIR_FACTUR = d.ID_DIR), (SELECT d.LOCALIDAD AS LOCALIDAD_DIR_FACTURA FROM DIRECCION d WHERE e.DIR_FACTUR = d.ID_DIR), (SELECT TRIM(de.PRO_FAC) AS PROVINCIA_DIR_FACTURA FROM DATOS_EMPR de WHERE e.NIF_EMP = de.NIF_EMP), (SELECT d.CP AS CP_DIR_FACTURA FROM DIRECCION d WHERE e.DIR_FACTUR = d.ID_DIR), e.DESTINATAR AS DESTINATARIO, (SELECT p.LITERAL AS CLAUSURADO_CONTRATO_LABORAL FROM PLANTILLA p WHERE e.ID_PLN_CL = p.ID_PLN), (SELECT p.LITERAL AS CLAUSURADO_CPD FROM PLANTILLA p WHERE e.ID_PLN_CPD = p.ID_PLN) FROM EMPRESA e WHERE e.NIF_EMP = '"+nifemp+"'");
    }

    public static String getEmpTipoFaBy(String nifemp) {
        return String.format("SELECT * FROM EMP_TIPOFA et WHERE NIF_EMP = '"+nifemp+"'");
    }

}
