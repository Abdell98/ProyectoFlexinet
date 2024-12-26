package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosPartesDeHoras {

    @SerializedName("PARTES_DE_HORAS__ALTA")
    private PartesDeHorasAlta partesDeHorasAlta;

    @SerializedName("PARTES_DE_HORAS__CONSULTA")
    private PartesDeHorasConsulta partesDeHorasConsulta;

    @SerializedName("PARTES_DE_HORAS__MODIFICACION")
    private PartesDeHorasModificacion partesDeHorasModificacion;

    @SerializedName("PARTES_DE_HORAS__TRASPASO")
    private PartesDeHorasTraspaso partesDeHorasTraspaso;

    @SerializedName("PARTES_DE_HORAS__ENVIOPARTESAORACLE")
    private PartesDeHorasEnvioPartesAOracle envioPartesAOracle;


    @NoArgsConstructor
    @Getter
    public static class PartesDeHorasAlta {
        private String empresa;
        private String anio;
        private String mes;
        private String chk_diario;
        private String chk_parcial;
        private String chk_especiales;
        private String chk_validado;
        private String chk_validado_modificar;

        @SerializedName("TABLE1")
        private Table1 table1;

        @SerializedName("TABLE2")
        private Table2 table2;

        @SerializedName("TAB_PARTEDEHORAS")
        private TabParteDeHoras tabParteDeHoras;

        @SerializedName("TAB_CONCEPTOSIT")
        private TabConceptosIT tabConceptosIT;

        @SerializedName("TAB_CONCEPTOSCOLABORADOR")
        private TabConceptosColaborador tabConceptosColaborador;

        @SerializedName("TAB_ABSENTISMOFALTAS")
        private TabAbsentismoFaltas tabAbsentismoFaltas;

        @NoArgsConstructor
        @Getter
        public static class Table1 {
            private String qbe_empresa;
            @SerializedName("Empresa")
            private String empresa;
        }

        @NoArgsConstructor
        @Getter
        public static class Table2 {
            private String qbe_idContrato;
            private String qbe_colaborador;
            private String qbe_diaDeInicio;
            private String qbe_diaDeFin;
            private String qbe_motivoDeBaja;
            private String qbe_centroDeTrabajo;
            private String qbe_personalizada;

            @SerializedName("Id. Contrato")
            private String idContrato;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Día de Inicio")
            private String diaDeInicio;
            @SerializedName("Día de Fin")
            private String diaDeFin;
            @SerializedName("Motivo de Baja")
            private String motivoDeBaja;
            @SerializedName("Centro de Trabajo")
            private String centroDeTrabajo;
            @SerializedName("Personalizada")
            private String personalizada;
        }

        @NoArgsConstructor
        @Getter
        public static class TabParteDeHoras {

            @SerializedName("SECTION_NOMINA")
            private SectionNomina sectionNomina;

            @SerializedName("SECTION_FACTURACION")
            private SectionFacturacion sectionFacturacion;

            @NoArgsConstructor
            @Getter
            public static class SectionNomina {
                private String horasNormales;
                private String horasExtras;
                private String horasFestivas;
                private String horasNocturnas;
                private String horasComplementarias;
                private String horasPermisoRetribuido;
                private String it;
                private String total;
            }

            @NoArgsConstructor
            @Getter
            public static class SectionFacturacion {
                private String horasNormales;
                private String horasExtras;
                private String horasFestivas;
                private String horasComplementarias;
                private String horasNocturnas;
                private String horasPermisoRetribuido;
                private String it;
                private String total;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabConceptosIT {
            @SerializedName("SECTION_NOMINA")
            private SectionNomina sectionNomina;
            @NoArgsConstructor
            @Getter
            public static class SectionNomina {
                private String concepto;
                private String de;
                private String a;
                private String horasTotales;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabConceptosColaborador {
            @SerializedName("SECTION_NOMINA")
            private SectionNomina sectionNomina;
            @SerializedName("SECTION_FACTURACION")
            private SectionFacturacion sectionFacturacion;

            @NoArgsConstructor
            @Getter
            public static class SectionNomina {
                private String btn_AnadirColaboradorConceptoNomina;

                @SerializedName("DIALOG_ALTACONCEPTOCOLABORADORNOMINA")
                private DialogAltaConceptoColaboradorNomina dialogAltaConceptoColaboradorNomina;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class DialogAltaConceptoColaboradorNomina {

                    private String lkp_concepto;
                    private String chk_diferencia;
                    private String tipo;
                    private String devengo;
                    private String unidades;
                    private String salario;
                    private String coeficiente;
                    private String total;

                    @SerializedName("DIALOG_LISTADODECONCEPTOS")
                    private DialogListadoDeConceptos dialogListadoDeConceptos;

                    @NoArgsConstructor
                    @Getter
                    public static class DialogListadoDeConceptos {
                        private String concepto;

                        @SerializedName("TABLE")
                        private Table table;

                        @NoArgsConstructor
                        @Getter
                        public static class Table {
                            private String qbe_conceptosDisponibles;
                            @SerializedName("Conceptos Disponibles")
                            private String conceptosDisponibles;
                        }
                    }
                }

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_concepto;
                    private String qbe_diferencia;
                    private String qbe_tipo;
                    private String qbe_devengo;
                    private String qbe_unidades;
                    private String qbe_salarioUnidad;
                    private String qbe_coeficiente;
                    private String qbe_total;

                    @SerializedName("Concepto")
                    private String concepto;
                    @SerializedName("Diferencia")
                    private String diferencia;
                    @SerializedName("Tipo")
                    private String tipo;
                    @SerializedName("Devengo")
                    private String devengo;
                    @SerializedName("Unidades")
                    private String unidades;
                    @SerializedName("Salario/Unidad")
                    private String salarioUnidad;
                    @SerializedName("Coeficiente")
                    private String coeficiente;
                    @SerializedName("Total")
                    private String total;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class SectionFacturacion {

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_concepto;
                    private String qbe_diferencia;
                    private String qbe_tipo;
                    private String qbe_devengo;
                    private String qbe_unidades;
                    private String qbe_salarioUnidad;
                    private String qbe_coeficiente;
                    private String qbe_precioUnidad;
                    private String qbe_total;

                    @SerializedName("Concepto")
                    private String concepto;
                    @SerializedName("Diferencia")
                    private String diferencia;
                    @SerializedName("Tipo")
                    private String tipo;
                    @SerializedName("Devengo")
                    private String devengo;
                    @SerializedName("Unidades")
                    private String unidades;
                    @SerializedName("Salario/Unidad")
                    private String salarioUnidad;
                    @SerializedName("Coeficiente")
                    private String coeficiente;
                    @SerializedName("Precio/Unidad")
                    private String precioUnidad;
                    @SerializedName("Total")
                    private String total;
                }
            }

        }

        @NoArgsConstructor
        @Getter
        private static class TabAbsentismoFaltas {
            //TODO: Averiguar dado que no vemos campos y dice `Esta Opción Sólo está Habilitada para Contratos con Tarifa Bruto/Mes`
        }
    }

    @NoArgsConstructor
    @Getter
    public static class PartesDeHorasConsulta {
        private String empresa;
        private String mes;
        private String anio;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String lkp_nif;
        private String chk_aNivelNacional;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionDeColaboradores dialogSeleccionDeColaboradores;

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_nParte;
            private String qbe_duracion;
            private String qbe_formato;
            private String qbe_validado;
            private String qbe_traspasado;
            private String qbe_facturado;
            private String qbe_enviadoOracle;
            private String qbe_estado;
            private String qbe_msgEnvio;
            private String qbe_idContrato;
            private String qbe_nif;
            private String qbe_colaborador;
            private String qbe_empresa;
            private String qbe_mes;
            private String qbe_diaDeInicio;
            private String qbe_diaDeFin;
            private String qbe_parteOriginal;
            private String qbe_detalle;
            private String qbe_info;

            @SerializedName("Nº Parte")
            private String nParte;
            @SerializedName("Duración")
            private String duracion;
            @SerializedName("Formato")
            private String formato;
            @SerializedName("Validado")
            private String validado;
            @SerializedName("Traspasado")
            private String traspasado;
            @SerializedName("Facturado")
            private String facturado;
            @SerializedName("Enviado a Oracle")
            private String enviadoOracle;
            @SerializedName("Estado")
            private String estado;
            @SerializedName("MSG Envío")
            private String msgEnvio;
            @SerializedName("Id. Contrato")
            private String idContrato;
            @SerializedName("NIF")
            private String nif;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("Mes")
            private String mes;
            @SerializedName("Día de Inicio")
            private String diaDeInicio;
            @SerializedName("Día de Fin")
            private String diaDeFin;
            @SerializedName("Parte Original")
            private String parteOriginal;
            @SerializedName("Detalle")
            private String detalle;
            @SerializedName("Info")
            private String info;
        }

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDeColaboradores {

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_nombreYApellidos;
                private String qbe_direccion;

                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
                @SerializedName("Detalle")
                private String detalle;
            }
        }
    }

    @NoArgsConstructor
    @Getter
    public static class PartesDeHorasModificacion {
        private String empresa;
        private String anio;
        private String mes;
        private String chk_diario;
        private String chk_parcial;
        private String chk_especiales;
        private String chk_validado;
        private String chk_validado_modificar;

        @SerializedName("TABLE1")
        private Table1 table1;

        @SerializedName("TABLE2")
        private Table2 table2;

        @SerializedName("TAB_PARTEDEHORAS")
        private TabParteDeHoras tabParteDeHoras;

        @SerializedName("TAB_CONCEPTOSIT")
        private TabConceptosIT tabConceptosIT;

        @SerializedName("TAB_CONCEPTOSCOLABORADOR")
        private TabConceptosColaborador tabConceptosColaborador;

        @SerializedName("TAB_ABSENTISMOFALTAS")
        private TabAbsentismoFaltas tabAbsentismoFaltas;

        @NoArgsConstructor
        @Getter
        public static class Table1 {
            private String qbe_empresa;
            @SerializedName("Empresa")
            private String empresa;
        }

        @NoArgsConstructor
        @Getter
        public static class Table2 {
            private String qbe_idContrato;
            private String qbe_colaborador;
            private String qbe_diaDeInicio;
            private String qbe_diaDeFin;
            private String qbe_motivoDeBaja;
            private String qbe_centroDeTrabajo;
            private String qbe_personalizada;

            @SerializedName("Id. Contrato")
            private String idContrato;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Día de Inicio")
            private String diaDeInicio;
            @SerializedName("Día de Fin")
            private String diaDeFin;
            @SerializedName("Motivo de Baja")
            private String motivoDeBaja;
            @SerializedName("Centro de Trabajo")
            private String centroDeTrabajo;
            @SerializedName("Personalizada")
            private String personalizada;
        }

        @NoArgsConstructor
        @Getter
        public static class TabParteDeHoras {

            @SerializedName("SECTION_NOMINA")
            private SectionNomina sectionNomina;

            @SerializedName("SECTION_FACTURACION")
            private SectionFacturacion sectionFacturacion;

            @NoArgsConstructor
            @Getter
            public static class SectionNomina {
                private String horasNormales;
                private String horasExtras;
                private String horasFestivas;
                private String horasNocturnas;
                private String horasComplementarias;
                private String horasPermisoRetribuido;
                private String it;
                private String total;
            }

            @NoArgsConstructor
            @Getter
            public static class SectionFacturacion {
                private String horasNormales;
                private String horasExtras;
                private String horasFestivas;
                private String horasComplementarias;
                private String horasNocturnas;
                private String horasPermisoRetribuido;
                private String it;
                private String total;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabConceptosIT {
            @SerializedName("SECTION_NOMINA")
            private SectionNomina sectionNomina;
            @NoArgsConstructor
            @Getter
            public static class SectionNomina {
                private String concepto;
                private String de;
                private String a;
                private String horasTotales;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabConceptosColaborador {
            @SerializedName("SECTION_NOMINA")
            private SectionNomina sectionNomina;
            @SerializedName("SECTION_FACTURACION")
            private SectionFacturacion sectionFacturacion;

            @NoArgsConstructor
            @Getter
            public static class SectionNomina {
                private String btn_AnadirColaboradorConceptoNomina;

                @SerializedName("DIALOG_ALTACONCEPTOCOLABORADORNOMINA")
                private DialogAltaConceptoColaboradorNomina dialogAltaConceptoColaboradorNomina;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class DialogAltaConceptoColaboradorNomina {

                    private String lkp_concepto;
                    private String chk_diferencia;
                    private String tipo;
                    private String devengo;
                    private String unidades;
                    private String salario;
                    private String coeficiente;
                    private String total;

                    @SerializedName("DIALOG_LISTADODECONCEPTOS")
                    private DialogListadoDeConceptos dialogListadoDeConceptos;


                    @NoArgsConstructor
                    @Getter
                    public static class DialogListadoDeConceptos {
                        private String concepto;

                        @SerializedName("TABLE")
                        private Table table;

                        @NoArgsConstructor
                        @Getter
                        public static class Table {
                            private String qbe_conceptosDisponibles;
                            @SerializedName("Conceptos Disponibles")
                            private String conceptosDisponibles;
                        }
                    }
                }

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_concepto;
                    private String qbe_diferencia;
                    private String qbe_tipo;
                    private String qbe_devengo;
                    private String qbe_unidades;
                    private String qbe_salarioUnidad;
                    private String qbe_coeficiente;
                    private String qbe_total;

                    @SerializedName("Concepto")
                    private String concepto;
                    @SerializedName("Diferencia")
                    private String diferencia;
                    @SerializedName("Tipo")
                    private String tipo;
                    @SerializedName("Devengo")
                    private String devengo;
                    @SerializedName("Unidades")
                    private String unidades;
                    @SerializedName("Salario/Unidad")
                    private String salarioUnidad;
                    @SerializedName("Coeficiente")
                    private String coeficiente;
                    @SerializedName("Total")
                    private String total;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class SectionFacturacion {

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_concepto;
                    private String qbe_diferencia;
                    private String qbe_tipo;
                    private String qbe_devengo;
                    private String qbe_unidades;
                    private String qbe_salarioUnidad;
                    private String qbe_coeficiente;
                    private String qbe_precioUnidad;
                    private String qbe_total;

                    @SerializedName("Concepto")
                    private String concepto;
                    @SerializedName("Diferencia")
                    private String diferencia;
                    @SerializedName("Tipo")
                    private String tipo;
                    @SerializedName("Devengo")
                    private String devengo;
                    @SerializedName("Unidades")
                    private String unidades;
                    @SerializedName("Salario/Unidad")
                    private String salarioUnidad;
                    @SerializedName("Coeficiente")
                    private String coeficiente;
                    @SerializedName("Precio/Unidad")
                    private String precioUnidad;
                    @SerializedName("Total")
                    private String total;
                }
            }

        }

        @NoArgsConstructor
        @Getter
        private static class TabAbsentismoFaltas {
            //TODO: Averiguar dado que no vemos campos y dice `Esta Opción Sólo está Habilitada para Contratos con Tarifa Bruto/Mes`
        }
    }

    @NoArgsConstructor
    @Getter
    public static class PartesDeHorasTraspaso {
        private String empresa;
        private String mes;
        private String anio;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String lkp_nif;
        private String chk_partesSinTraspasar;
        private String chk_aNivelNacional;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionDeColaboradores dialogSeleccionDeColaboradores;

        @SerializedName("TABLE1")
        private Table1 table1;

        @SerializedName("TABLE2")
        private Table1 table2;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDeColaboradores {

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_nombreYApellidos;
                private String qbe_direccion;

                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
                @SerializedName("Detalle")
                private String detalle;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class Table1 {

            private String qbe_nParte;
            private String qbe_duracion;
            private String qbe_formato;
            private String qbe_idContrato;
            private String qbe_oficina;
            private String qbe_colaborador;
            private String qbe_empresa;
            private String qbe_diaDeInicio;
            private String qbe_diaDeFin;
            private String qbe_traspasado;
            private String qbe_detalle;

            @SerializedName("Nº Parte")
            private String nParte;
            @SerializedName("Duración")
            private String duracion;
            @SerializedName("Formato")
            private String formato;
            @SerializedName("ID.Contrato")
            private String idContrato;
            @SerializedName("Oficina")
            private String oficina;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("Día de Inicio")
            private String diaDeInicio;
            @SerializedName("Día de Fin")
            private String diaDeFin;
            @SerializedName("Traspasado")
            private String traspasado;
            @SerializedName("Detalle")
            private String detalle;

        }

        @NoArgsConstructor
        @Getter
        public static class Table2 {
            private String qbe_nParte;
            private String qbe_duracion;
            private String qbe_formato;
            private String qbe_idContrato;
            private String qbe_oficina;
            private String qbe_colaborador;
            private String qbe_empresa;
            private String qbe_diaDeInicio;
            private String qbe_diaDeFin;
            private String qbe_detalle;

            @SerializedName("Nº Parte")
            private String nParte;
            @SerializedName("Duración")
            private String duracion;
            @SerializedName("Formato")
            private String formato;
            @SerializedName("ID.Contrato")
            private String idContrato;
            @SerializedName("Oficina")
            private String oficina;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("Día de Inicio")
            private String diaDeInicio;
            @SerializedName("Día de Fin")
            private String diaDeFin;
            @SerializedName("Detalle")
            private String detalle;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class PartesDeHorasEnvioPartesAOracle {
        private String empresa;
        private String mes;
        private String anio;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String lkp_nif;
        private String chk_partesEnviadosAOracle;
        private String chk_aNivelNacional;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionDeColaboradores dialogSeleccionDeColaboradores;

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_nParte;
            private String qbe_duracion;
            private String qbe_formato;
            private String qbe_validado;
            private String qbe_traspasado;
            private String qbe_facturado;
//            private String qbe_enviadoOracle; //En uat no está
            private String qbe_idContrato;
            private String qbe_nif;
            private String qbe_colaborador;
            private String qbe_empresa;
            private String qbe_mes;
            private String qbe_diaDeInicio;
            private String qbe_diaDeFin;
            private String qbe_parteOriginal;
            private String qbe_fEnvio;
            private String qbe_detalle;

            @SerializedName("Nº Parte")
            private String nParte;
            @SerializedName("Duración")
            private String duracion;
            @SerializedName("Formato")
            private String formato;
            @SerializedName("Validado")
            private String validado;
            @SerializedName("Traspasado")
            private String traspasado;
            @SerializedName("Facturado")
            private String facturado;
            @SerializedName("Enviado a Oracle")
            private String enviadoOracle;
            @SerializedName("Estado")
            private String estado;
            @SerializedName("MSG Envío")
            private String msgEnvio;
            @SerializedName("Id. Contrato")
            private String idContrato;
            @SerializedName("NIF")
            private String nif;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("Mes")
            private String mes;
            @SerializedName("Día de Inicio")
            private String diaDeInicio;
            @SerializedName("Día de Fin")
            private String diaDeFin;
            @SerializedName("Parte Original")
            private String parteOriginal;
            @SerializedName("F. Envio")
            private String fEnvio;
            @SerializedName("Detalle")
            private String detalle;
        }

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDeColaboradores {

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_nombreYApellidos;
                private String qbe_direccion;

                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
                @SerializedName("Detalle")
                private String detalle;
            }
        }
    }

}




