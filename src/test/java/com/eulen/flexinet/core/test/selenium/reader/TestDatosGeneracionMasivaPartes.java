package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosGeneracionMasivaPartes {

    @SerializedName("GENERADOR_AUTOMATICO_PARTES__HORAS")
    private GeneradorAutomaticoPartesHoras generadorAutomaticoPartesHoras;

    @NoArgsConstructor
    @Getter
    public static class GeneradorAutomaticoPartesHoras {
        private String mes;
        private String anio;
        private String chk_nominas;
        private String chk_finiquitos;
        private String chk_mostrarGenerados;
        private String empresa;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nif;
        private String zona;
        private String provincia;
        private String oficina;
        private String radio_realizarBusquedaANivelNacional_si;
        private String radio_realizarBusquedaANivelNacional_no;

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_zona;
            private String qbe_provincia;
            private String qbe_oficina;
            private String qbe_cif;
            private String qbe_razonSocial;
            private String qbe_contrato;
            private String qbe_nifColaborador;
            private String qbe_nombreColaborador;
            private String qbe_secuencial;
            private String qbe_fechaInicio;
            private String qbe_fechaBaja;
            private String qbe_motivoBaja;
            private String qbe_fechaValidado;
            private String qbe_fechaGenerado;
            private String qbe_nParte;

            @SerializedName("Zona")
            private String table_zona;
            @SerializedName("Provincia")
            private String table_provincia;
            @SerializedName("Oficina")
            private String table_oficina;
            @SerializedName("Cif")
            private String table_cif;
            @SerializedName("Razon Social")
            private String table_razonSocial;
            @SerializedName("Contrato")
            private String table_contrato;
            @SerializedName("NIF Colaborador")
            private String table_nifColaborador;
            @SerializedName("Nombre Colaborador")
            private String table_nombreColaborador;
            @SerializedName("Secuencial")
            private String table_Secuencial;
            @SerializedName("Fecha Inicio")
            private String table_fechaInicio;
            @SerializedName("Fecha Baja")
            private String table_fechaBaja;
            @SerializedName("Motivo Baja")
            private String table_motivoBaja;
            @SerializedName("Fecha Validado")
            private String table_fechaValidado;
            @SerializedName("Fecha Generado")
            private String table_fechaGenerado;
            @SerializedName("Nº Parte")
            private String table_nParte;
        }
    }
}
