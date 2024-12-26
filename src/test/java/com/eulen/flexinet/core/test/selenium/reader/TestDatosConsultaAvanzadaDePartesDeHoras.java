package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosConsultaAvanzadaDePartesDeHoras {

    @SerializedName("GESTION_AVANZADA__CONSULTA_AVANZADA_DE_PARTES_DE_HORAS")
    private GestionAvanzadaConsultaAvanzadaDePartesDeHoras gestionAvanzadaConsultaAvanzadaDePartesDeHoras;

    @NoArgsConstructor
    @Getter
    public static class GestionAvanzadaConsultaAvanzadaDePartesDeHoras {
        private String empresa;
        private String mes;
        private String anio;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String buscarANivelNacional;
        private String buscar;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogoSeleccionDeColaboradores dialogoSeleccionDeColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogoSeleccionDeColaboradores {
            @SerializedName("TABLE_COLABORADORES")
            private Table table;
            @NoArgsConstructor
            @Getter
            public static class Table{
                private String qbe_nombreYApellidos;
                private String qbe_direccion;
                @SerializedName("Nombre y Apellidos")
                private String table_nombreYApellidos;
                @SerializedName("Dirección")
                private String table_direccion;
                @SerializedName("Detalle")
                private String table_detalle;
            }

        }

        @SerializedName("TABLE_PARTES")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_nroParte;
            private String qbe_duracion;
            private String qbe_formato;
            private String qbe_validado;
            private String qbe_traspasado;
            private String qbe_facturado;
            private String qbe_idContrato;
            private String qbe_nIF;
            private String qbe_colaborador;
            private String qbe_empresa;
            private String qbe_mes;
            private String qbe_diaDeInicio;
            private String qbe_diaDeFin;
            private String qbe_parteOriginal;

            @SerializedName("Nº Parte")
            private String table_nroParte;
            @SerializedName("Duración")
            private String table_duracion;
            @SerializedName("Formato")
            private String table_formato;
            @SerializedName("Validado")
            private String table_validado;
            @SerializedName("Traspasado")
            private String table_traspasado;
            @SerializedName("Facturado")
            private String table_facturado;
            @SerializedName("Id. Contrato")
            private String table_idContrato;
            @SerializedName("NIF")
            private String table_nIF;
            @SerializedName("Colaborador")
            private String table_colaborador;
            @SerializedName("Empresa")
            private String table_empresa;
            @SerializedName("Mes")
            private String table_mes;
            @SerializedName("Día de Inicio")
            private String table_diaDeInicio;
            @SerializedName("Día de Fin")
            private String table_diaDeFin;
            @SerializedName("Parte Original")
            private String table_parteOriginal;
            @SerializedName("Detalle")
            private String table_detalle;
        }

    }

}

