package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosFacturacion {

    @SerializedName("FACTURACION__CONSULTA")
    private FacturacionConsulta facturacionConsulta;

    @NoArgsConstructor
    @Getter
    public static class FacturacionConsulta {
        private String razonSocial;
        private String lkp_razonSocial;
        private String chk_busquedaANivelNacional;
        private String chk_preFacturadas;
        private String chk_facturas;
        private String chk_sPF;
        private String chk_abonosTotales;
        private String chk_abonosParciales;
        private String chk_validadasEmisionMasiva;
        private String chk_busquedaErp;
        private String nDocumento;
        private String chk_fechaEmisionUltimoMes;
        private String chk_fechaEmisionRangoFechas;
        private String facturas;
        private String rangoFechaDesde;
        private String rangoFechaHasta;
        private String chk_facturasManuales;
        private String chk_ultimoMes;
        private String chk_rangoFecha;
        private String chk_marcarDesmarcarEmitir;

        @SerializedName("DIALOG_SELECCIONDEEMPRESA")
        private DialogSeleccionEmpresa dialogSeleccionEmpresa;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionEmpresa
        {
            private String qbe_empresaCliente;
            private String qbe_nIF;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Empresa")
                private String empresa;
                //@SerializedName("Dirección")
                private String nIF;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_idDocumento;
            private String qbe_empresa;
            private String qbe_tipo;
            private String qbe_numFactura;
            private String qbe_fechaEmision;
            private String qbe_lVenta;

            @SerializedName("Provincia")
            private String provincia;
            @SerializedName("Oficina")
            private String oficina;
            @SerializedName("Nombre Oficina")
            private String nombreOficina;
            @SerializedName("Id. Documento")
            private String idDocumento;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("Tipo")
            private String tipo;
            @SerializedName("Base Imponible")
            private String baseImponible;
            @SerializedName("I.V.A / I.G.I.C")
            private String iVA;
            @SerializedName("Importe Total")
            private String importeTotal;
            @SerializedName("Num. Factura")
            private String numFactura;
            @SerializedName("Fecha Emisión / Prefac. / Abono")
            private String fecEmisionAbono;
            @SerializedName("Estado")
            private String estado;
            @SerializedName("L. Venta")
            private String lineaVenta;
            @SerializedName("Indicador")
            private String indicador;
            private String selectPager;
            private Integer validateNumRows;
        }
    }

}