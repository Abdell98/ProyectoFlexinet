package com.eulen.flexinet.core.test.selenium.database;

public class ContratosQuery {

    public static String getConsultaID_CONTRATO(String pedido){
        return String.format("" +
                "SELECT CON.ID_CON FROM CONTRATO CON WHERE CON.ID_PEDIDO = %s", pedido);
    }

    public static String getUpdateContratoF_TRS_FACT(String contrato){
        return String.format(""+
                "UPDATE CONTRATO CON SET CON.F_TRS_FACT=0 WHERE CON.ID_CON = %s", contrato);
    }
}
