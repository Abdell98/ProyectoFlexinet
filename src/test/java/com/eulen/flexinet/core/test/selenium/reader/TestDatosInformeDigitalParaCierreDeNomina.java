package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosInformeDigitalParaCierreDeNomina {

    @SerializedName("GESTION_DE_INFORMES__INFORME_DE_CONTRATACION_Y_PERSONAL__INFORME_DIGITAL_PARA_CIERRE_DE_NOMINA")
    private GestionDeInformesInformeDeContratacionYPersonalInformeDigitalParaCierreDeNomina informe;

    @NoArgsConstructor
    @Getter
    public static class GestionDeInformesInformeDeContratacionYPersonalInformeDigitalParaCierreDeNomina {

        private String oficina;
        private String empresa;
        private String anio;
        private String mes;
        private String dniColaborador;
        private String excluirGenerados;

        @SerializedName("DIALOGO_BUSQUEDADEEMPRESAS")
        private DialogoBusquedaDeEmpresas dialogoBusquedaDeEmpresas;

        @NoArgsConstructor
        @Getter
        public static class DialogoBusquedaDeEmpresas {

            private String empresaClienteRazonSocial;

            @SerializedName("TABLE")
            private Table table;
            @NoArgsConstructor
            @Getter
            public static class Table{
                private String qbe_empresa;
                private String qbe_nif;

                @SerializedName("Empresa")
                private String table_empresa;
                @SerializedName("N.I.F.")
                private String table_nif;
            }

        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String marcarDesmarcarTodosComoValidados;
            private String qbe_validado;
            private String qbe_empresa;
            private String qbe_codCli;
            private String qbe_idCent;
            private String qbe_colaborador;
            private String qbe_nif;
            private String qbe_sec;
            private String qbe_fInicio;
            private String qbe_fBaja;
            private String qbe_motivoBaja;
            private String qbe_undsSalarioNom;
            private String qbe_undsSalarioFac;
            private String qbe_undsSalarioTeorico;
            private String qbe_undsExtra;
            private String qbe_undsNocturnaNom;
            private String qbe_undsNocturnaFac;
            private String qbe_undsFestiva;
            private String qbe_conceptosN;
            private String qbe_conceptosF;
            private String qbe_nSalario;
            private String qbe_nImporte;
            private String qbe_nsExtra;
            private String qbe_nsNoct;
            private String qbe_nsFest;
            private String qbe_fSalario;
            private String qbe_fImporte;
            private String qbe_fpvpExtra;
            private String qbe_fpvpNoct;
            private String qbe_fpvpFest;
            private String qbe_generado;
            private String qbe_fecGeneracion;
            private String qbe_contrato;

            @SerializedName("Marcar / Desmarcar Todos Como Validados")
            private String table_marcarDesmarcarTodosComoValidados;
            @SerializedName("Validado")
            private String table_validado;
            @SerializedName("Empresa")
            private String table_empresa;
            @SerializedName("Cod. Cli.")
            private String table_codCli;
            @SerializedName("Id Cent.")
            private String table_idCent;
            @SerializedName("Colaborador")
            private String table_colaborador;
            @SerializedName("NIF")
            private String table_nif;
            @SerializedName("Sec.")
            private String table_sec;
            @SerializedName("F. Inicio")
            private String table_fInicio;
            @SerializedName("F. Baja")
            private String table_fBaja;
            @SerializedName("Motivo Baja")
            private String table_motivoBaja;
            @SerializedName("Unds. Salario Nom.")
            private String table_undsSalarioNom;
            @SerializedName("Unds. Salario Fac.")
            private String table_undsSalarioFac;
            @SerializedName("Unds. Salario Teórico")
            private String table_undsSalarioTeorico;
            @SerializedName("Unds. Extra")
            private String table_undsExtra;
            @SerializedName("Unds. Nocturna Nom.")
            private String table_undsNocturnaNom;
            @SerializedName("Unds.Nocturna Fac")
            private String table_undsNocturnaFac;
            @SerializedName("Unds. Festiva")
            private String table_undsFestiva;
            @SerializedName("Conceptos N.")
            private String table_conceptosN;
            @SerializedName("Conceptos F.")
            private String table_conceptosF;
            @SerializedName("N. Salario")
            private String table_nSalario;
            @SerializedName("N. Importe")
            private String table_nImporte;
            @SerializedName("N.S. Extra")
            private String table_nsExtra;
            @SerializedName("N.S. Noct.")
            private String table_nsNoct;
            @SerializedName("N.S. Fest.")
            private String table_nsFest;
            @SerializedName("F. Salario")
            private String table_fSalario;
            @SerializedName("F. Importe")
            private String table_fImporte;
            @SerializedName("F.PVP Extra")
            private String table_fpvpExtra;
            @SerializedName("F.PVP Noct.")
            private String table_fpvpNoct;
            @SerializedName("F.PVP Fest.")
            private String table_fpvpFest;
            @SerializedName("Generado")
            private String table_generado;
            @SerializedName("Fec. Generación")
            private String table_fecGeneracion;
            @SerializedName("Contrato")
            private String table_contrato;
        }

        @SerializedName("DIALOGO_DETALLEDELCOLABORADOR")
        private DialogoDetalleDelColaborador dialogoDetalleDelColaborador;

        @NoArgsConstructor
        @Getter
        public static class DialogoDetalleDelColaborador {

            @SerializedName("FORMULARIO")
            private Formulario formulario;
            @NoArgsConstructor
            @Getter
            public static class Formulario{
                private String nomina;
                private String facturacion;
                private String extra;
                private String nomina2;
                private String facturacion2;
                private String festiva;
                private String permisoRetribuido;

                @SerializedName("MODIFICACIONDEHORASEXTRA")
                private ModificaciondeHorasExtra modificaciondeHorasExtra;
                @NoArgsConstructor
                @Getter
                public static class ModificaciondeHorasExtra{
                    private String unidades;
                    private String total;
                    private String importe;
                }

                @SerializedName("MODIFICACIONDEHORASFESTIVA")
                private ModificaciondeHorasFestiva modificaciondeHorasFestiva;
                @NoArgsConstructor
                @Getter
                public static class ModificaciondeHorasFestiva{
                    private String unidades;
                    private String total;
                    private String importe;
                }
            }

            @SerializedName("SECCIONNOMINAS")
            private Nominas nominas;
            @NoArgsConstructor
            @Getter
            public static class Nominas{
                private String concepto;
                private String chk_diferencia;

                @SerializedName("LISTADODECONCEPTOS")
                private ListadoDeConceptos listadoDeConceptos ;
                @NoArgsConstructor
                @Getter
                public static class ListadoDeConceptos{

                    @SerializedName("FORMULARIO")
                    private Formulario formulario;
                    @NoArgsConstructor
                    @Getter
                    public static class Formulario{
                        private String concepto;
                    }

                    @SerializedName("TABLE")
                    private Table table;

                    @NoArgsConstructor
                    @Getter
                    public static class Table {
                        private String qbe_conceptosDisponibles;
                        private String qbe_cotizable;

                        @SerializedName("Conceptos Disponibles")
                        private String table_conceptosDisponibles;
                        @SerializedName("Cotizable")
                        private String table_cotizable;

                    }

                    @SerializedName("CONCEPTO")
                    private Concepto concepto;
                    @NoArgsConstructor
                    @Getter
                    public static class Concepto{
                        private String unidades;
                        private String salarial;
                        private String totalSal;
                        private String coeficiente;
                        private String PVP;
                        private String totalPVP;
                    }

                }

                @SerializedName("TABLE")
                private Table table;
                @NoArgsConstructor
                @Getter
                public static class Table{
                    private String qbe_concepto;
                    private String qbe_tipo;
                    private String qbe_devengo;
                    private String qbe_dif;
                    private String qbe_unds;
                    private String qbe_importe;
                    private String qbe_total;
                    private String qbe_c;

                    @SerializedName("Concepto")
                    private String table_concepto;
                    @SerializedName("Tipo")
                    private String table_tipo;
                    @SerializedName("Devengo")
                    private String table_devengo;
                    @SerializedName("Dif.")
                    private String table_dif;
                    @SerializedName("Unds.")
                    private String table_unds;
                    @SerializedName("Importe")
                    private String table_importe;
                    @SerializedName("Total")
                    private String table_total;
                    @SerializedName("C")
                    private String table_c;
                }

            }

            @SerializedName("SECCIONFACTURAS")
            private Facturas facturas;
            @NoArgsConstructor
            @Getter
            public static class Facturas{
                private String concepto;

                @SerializedName("TABLE")
                private Table table;
                @NoArgsConstructor
                @Getter
                public static class Table{
                    private String qbe_concepto;
                    private String qbe_coef;
                    private String qbe_devengo;
                    private String qbe_dif;
                    private String qbe_unds;
                    private String qbe_precio;
                    private String qbe_total;
                    private String qbe_c;

                    @SerializedName("Concepto")
                    private String table_concepto;
                    @SerializedName("Coef.")
                    private String table_coef;
                    @SerializedName("Devengo")
                    private String table_devengo;
                    @SerializedName("Dif.")
                    private String table_dif;
                    @SerializedName("Unds.")
                    private String table_unds;
                    @SerializedName("Precio")
                    private String table_precio;
                    @SerializedName("Total")
                    private String table_total;
                    @SerializedName("C")
                    private String table_c;
                }
            }

            @SerializedName("BOTONES")
            private Botones botones;
            @NoArgsConstructor
            @Getter
            public static class Botones{
                private String chk_validado;
            }
        }
    }
}
