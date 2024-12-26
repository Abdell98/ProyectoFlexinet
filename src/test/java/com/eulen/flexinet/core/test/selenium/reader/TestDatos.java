package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatos {

    @SerializedName("PEDIDOS__ALTA_SIMPLE")
    private PedidosAlta pedidosAlta;

    @SerializedName("PEDIDOS__ALTA_LV3233")
    private PedidosAlta pedidosAltaLv3233;

    @SerializedName("PEDIDOS__ALTA_INDEFINIDOS")
    private PedidosAlta pedidosAltaIndefinidos;

    @SerializedName("RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS")
    private RiesgosGestionDePedidosBloqueados riesgosGestionPedidosBloqueados;

    @SerializedName("PEDIDOS__CONSULTA")
    private PedidosConsulta pedidosConsulta;

    @SerializedName("PEDIDOS__MODIFICACION")
    private PedidosModificacion pedidosModificacion;


    @NoArgsConstructor
    @Getter
    public static class PedidosAlta {

        @SerializedName("TAB_DATOSDELPEDIDO")
        private TabDatosDelPedido tabDatosDelPedido;

        @SerializedName("TAB_DATOSDEJORNADA")
        private TabDatosDeJornada tabDatosDeJornada;

        @SerializedName("TAB_DATOSDETARIFA")
        private TabDatosDeTarifa tabDatosDeTarifa;

        @SerializedName("TAB_DATOSCOLABORADORES")
        private TabDatosColaboradores tabDatosColaboradores;

        @SerializedName("TAB_DESGLOSEDECATEGORIAPROFESIONAL")
        private TabDesgloseDeCategoriaProfesional tabDesgloseDeCategoriaProfesional;

        @SerializedName("DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO")
        private DialogSolicitudDeFechaDeAltaDelContrato dialogSolicitudDeFechaDeAltaDelContrato;

        @NoArgsConstructor
        @Getter
        public static class TabDatosDelPedido {
            private String nPedido;
            private String nPedidoAuxiliar;
            private String tCont;
            private String clausulas;
            private String convenio;
            private String centrosDeTrabajo;
            private String supuestoCelebracion;
            private String existeConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18;
            private String marqueSiexisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18; //INFO: Solo sale en el supuesto celebración B en pedidos alta lv32-33
            private String sustitucionDelTrabajador;
            private String motivoDeSustitucion;
            private String elLaTrabajadoraEstaEnPosesionDelTitulo;
            private String elLaTrabajadoraAcreditaConLaCertificacionPor;
            private String certificadoProfesional;
            private String desempleadoYMenor30Anos;
            private String desempleadoYMenor35AnosYConDiscapacSup30;
            private String menor30AnosRealizarPracticasNoLaboralesRD15432011;
            private String haberTerminadoLosEstudiosQueLeCapacitanParaLaPracticaObjetoDeDichoContratoConFecha;
            private String descripcion;
            private String contratacionMenos100;
            private String fechaPrevistaDeInicio;
            private String fechaPrevistaDeFin;
            private String rad_previsible;
            private String rad_imprevisible;
            private String avalNecesario;
            private String importeDelAval;
            private String observaciones;

            @SerializedName("DIALOG_SELECCIONDEEMPRESA")
            private DialogSeleccionDeEmpresa dialogSeleccionDeEmpresa;

            @NoArgsConstructor
            @Getter
            public static class DialogSeleccionDeEmpresa {
                private String empresa;
                private String nIF;
                private String nCliente;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nif;
                    private String qbe_empresa;
                    private String qbe_nCliente;
                    private String qbe_estado;
                    private String qbe_formaDePago;
                    private String qbe_comportamientoDePago;
                    private String qbe_detalle;

                    @SerializedName("N.I.F.")
                    private String nif;
                    @SerializedName("Empresa")
                    private String empresa;
                    @SerializedName("Nº Cliente")
                    private String nCliente;
                    @SerializedName("Estado")
                    private String estado;
                    @SerializedName("Forma de Pago")
                    private String formaDePago;
                    @SerializedName("Comportamiento de pago")
                    private String comportamientoDePago;
                    @SerializedName("Detalle")
                    private String detalle;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosDeJornada {
            private String departamento;
            private String nCandidatosAsignados;
            private String nCandidatosSolicitados;
            private String diasTrabajadosALaSemana;
            private String horasNormalesDiarias;
            private String periodoDePrueba;
            private String porcentajeJornada;
            private String diasDeTrabajoSemanales;
            private String horario;
            private String aTurnos;
            private String turno;
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosDeTarifa {
            private String oferta;
            private String categoriaLaboral;
            private String categoriaProfesional;
            private String seleccioneDuracionYTipoDeJornadaDeLaTarifa;
            private String tarifaNormal;
            private String tarifaIgualOInferior5Dias;
            private String compPago;
            private String grupoCotizacion;
            private String ocupacion;
            private String brutoMensual;
            private String bonificacion;
            private String fechaInicio;
            private String fechaFin;
            private String previsionarCompensacionFinContrato;
        }

        @NoArgsConstructor
        @Getter
        public static class TabDesgloseDeCategoriaProfesional {
            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_salarioBruto;
                private String qbe_salarial;
                private String qbe_extrasal;
                private String qbe_plusSalarial;
                private String qbe_plusExtraSal;
                private String qbe_seguridadSocial;
                private String qbe_formacionComPartit;
                private String qbe_indemnizFinContrato;
                private String qbe_revisionCoste;
                private String qbe_medica;
                private String qbe_otros;
                private String qbe_costeTotal;
                private String qbe_margenBruto;
                private String qbe_pvp;

                @SerializedName("Salario Bruto")
                private String salarioBruto;
                @SerializedName("Salarial")
                private String salarial;
                @SerializedName("Extrasal.")
                private String extrasal;
                @SerializedName("Plus Salarial")
                private String plusSalarial;
                @SerializedName("Plus Extrasal.")
                private String plusExtraSal;
                @SerializedName("Seguridad Social")
                private String seguridadSocial;
                @SerializedName("Formación + Com. Parit.")
                private String formacionComPartit;
                @SerializedName("Indemniz. Fin Contrato")
                private String indemnizFinContrato;
                @SerializedName("Revisión Coste")
                private String revisionCoste;
                @SerializedName("Médica %")
                private String medica;
                @SerializedName("Otros")
                private String otros;
                @SerializedName("Coste Total")
                private String costeTotal;
                @SerializedName("Margen Bruto %")
                private String margenBruto;
                @SerializedName("P.V.P.")
                private String pvp;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosColaboradores {
            private String nombre;
            private String primerApellido;
            private String segundoApellido;
            private String dNI;

            @SerializedName("DIALOG_PERFILDATOUNICO")
            private DialogPerfilDatoUnico dialogPerfilDatoUnico;

            @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
            private DialogSeleccionDeColaboradores dialogSeleccionDeColaboradores;

            @NoArgsConstructor
            @Getter
            public static class DialogPerfilDatoUnico {
                private String elegirPaisDeNacionalidad;
                private String elegirMpioResidencia;
                private String elegirOcupacion;
                private String seleccionarTitulacion;
                private String sexo;
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
                    private String qbe_detalle;

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
        public static class DialogSolicitudDeFechaDeAltaDelContrato {
            private String introduzcaLaFechaDeAntiguedadDelContrato;
            private String rad_RealizandoElTraspasoDeLosContratos;
            private String rad_SinTraspasarLosContratos;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class PedidosAltaLV3233 {

        @SerializedName("TAB_DATOSDELPEDIDO")
        private TabDatosDelPedido tabDatosDelPedido;

        @SerializedName("TAB_DATOSDEJORNADA")
        private TabDatosDeJornada tabDatosDeJornada;

        @SerializedName("TAB_DATOSDETARIFA")
        private TabDatosDeTarifa tabDatosDeTarifa;

        @SerializedName("TAB_DATOSCOLABORADORES")
        private TabDatosColaboradores tabDatosColaboradores;

        @SerializedName("TAB_DESGLOSEDECATEGORIAPROFESIONAL")
        private TabDesgloseDeCategoriaProfesional tabDesgloseDeCategoriaProfesional;

        @SerializedName("DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO")
        private DialogSolicitudDeFechaDeAltaDelContrato dialogSolicitudDeFechaDeAltaDelContrato;

        @NoArgsConstructor
        @Getter
        public static class TabDatosDelPedido {
            private String nPedido;
            private String nPedidoAuxiliar;
            private String tCont;
            private String clausulas;
            private String convenio;
            private String centrosDeTrabajo;
            private String supuestoCelebracion;
            private String existeConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18;
            private String marqueSiexisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18; //INFO: Solo sale en el supuesto celebración B en pedidos alta lv32-33
            private String sustitucionDelTrabajador;
            private String motivoDeSustitucion;
            private String elLaTrabajadoraEstaEnPosesionDelTitulo;
            private String elLaTrabajadoraAcreditaConLaCertificacionPor;
            private String certificadoProfesional;
            private String desempleadoYMenor30Anos;
            private String desempleadoYMenor35AnosYConDiscapacSup30;
            private String menor30AnosRealizarPracticasNoLaboralesRD15432011;
            private String haberTerminadoLosEstudiosQueLeCapacitanParaLaPracticaObjetoDeDichoContratoConFecha;
            private String descripcion;
            private String contratacionMenos100;
            private String fechaPrevistaDeInicio;
            private String fechaPrevistaDeFin;
            private String rad_previsible;
            private String rad_imprevisible;
            private String avalNecesario;
            private String importeDelAval;
            private String observaciones;

            @SerializedName("DIALOG_SELECCIONDEEMPRESA")
            private DialogSeleccionDeEmpresa dialogSeleccionDeEmpresa;

            @NoArgsConstructor
            @Getter
            public static class DialogSeleccionDeEmpresa {
                private String empresa;
                private String nIF;
                private String nCliente;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nif;
                    private String qbe_empresa;
                    private String qbe_nCliente;
                    private String qbe_estado;
                    private String qbe_formaDePago;
                    private String qbe_comportamientoDePago;
                    private String qbe_detalle;

                    @SerializedName("N.I.F.")
                    private String nif;
                    @SerializedName("Empresa")
                    private String empresa;
                    @SerializedName("Nº Cliente")
                    private String nCliente;
                    @SerializedName("Estado")
                    private String estado;
                    @SerializedName("Forma de Pago")
                    private String formaDePago;
                    @SerializedName("Comportamiento de pago")
                    private String comportamientoDePago;
                    @SerializedName("Detalle")
                    private String detalle;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosDeJornada {
            private String departamento;
            private String nCandidatosAsignados;
            private String nCandidatosSolicitados;
            private String diasTrabajadosALaSemana;
            private String horasNormalesDiarias;
            private String periodoDePrueba;
            private String porcentajeJornada;
            private String diasDeTrabajoSemanales;
            private String horario;
            private String aTurnos;
            private String turno;
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosDeTarifa {
            private String oferta;
            private String categoriaLaboral;
            private String categoriaProfesional;
            private String seleccioneDuracionYTipoDeJornadaDeLaTarifa;
            private String tarifaNormal;
            private String tarifaIgualOInferior5Dias;
            private String compPago;
            private String grupoCotizacion;
            private String ocupacion;
            private String brutoMensual;
            private String bonificacion;
            private String fechaInicio;
            private String fechaFin;
            private String previsionarCompensacionFinContrato;
        }

        @NoArgsConstructor
        @Getter
        public static class TabDesgloseDeCategoriaProfesional {
            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_salarioBruto;
                private String qbe_salarial;
                private String qbe_extrasal;
                private String qbe_plusSalarial;
                private String qbe_plusExtraSal;
                private String qbe_seguridadSocial;
                private String qbe_formacionComPartit;
                private String qbe_indemnizFinContrato;
                private String qbe_revisionCoste;
                private String qbe_medica;
                private String qbe_otros;
                private String qbe_costeTotal;
                private String qbe_margenBruto;
                private String qbe_pvp;

                @SerializedName("Salario Bruto")
                private String salarioBruto;
                @SerializedName("Salarial")
                private String salarial;
                @SerializedName("Extrasal.")
                private String extrasal;
                @SerializedName("Plus Salarial")
                private String plusSalarial;
                @SerializedName("Plus Extrasal.")
                private String plusExtraSal;
                @SerializedName("Seguridad Social")
                private String seguridadSocial;
                @SerializedName("Formación + Com. Parit.")
                private String formacionComPartit;
                @SerializedName("Indemniz. Fin Contrato")
                private String indemnizFinContrato;
                @SerializedName("Revisión Coste")
                private String revisionCoste;
                @SerializedName("Médica %")
                private String medica;
                @SerializedName("Otros")
                private String otros;
                @SerializedName("Coste Total")
                private String costeTotal;
                @SerializedName("Margen Bruto %")
                private String margenBruto;
                @SerializedName("P.V.P.")
                private String pvp;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosColaboradores {
            private String nombre;
            private String primerApellido;
            private String segundoApellido;
            private String dNI;

            @SerializedName("DIALOG_PERFILDATOUNICO")
            private DialogPerfilDatoUnico dialogPerfilDatoUnico;

            @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
            private DialogSeleccionDeColaboradores dialogSeleccionDeColaboradores;

            @NoArgsConstructor
            @Getter
            public static class DialogPerfilDatoUnico {
                private String elegirPaisDeNacionalidad;
                private String elegirMpioResidencia;
                private String elegirOcupacion;
                private String seleccionarTitulacion;
                private String sexo;
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
                    private String qbe_detalle;

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
        public static class DialogSolicitudDeFechaDeAltaDelContrato {
            private String introduzcaLaFechaDeAntiguedadDelContrato;
            private String rad_RealizandoElTraspasoDeLosContratos;
            private String rad_SinTraspasarLosContratos;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class PedidosAltaIndefinidos {

        @SerializedName("TAB_DATOSDELPEDIDO")
        private TabDatosDelPedido tabDatosDelPedido;

        @SerializedName("TAB_DATOSDEJORNADA")
        private TabDatosDeJornada tabDatosDeJornada;

        @SerializedName("TAB_DATOSDETARIFA")
        private TabDatosDeTarifa tabDatosDeTarifa;

        @SerializedName("TAB_DATOSCOLABORADORES")
        private TabDatosColaboradores tabDatosColaboradores;

        @SerializedName("TAB_DESGLOSEDECATEGORIAPROFESIONAL")
        private TabDesgloseDeCategoriaProfesional tabDesgloseDeCategoriaProfesional;

        @SerializedName("DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO")
        private DialogSolicitudDeFechaDeAltaDelContrato dialogSolicitudDeFechaDeAltaDelContrato;

        @NoArgsConstructor
        @Getter
        public static class TabDatosDelPedido {
            private String nPedido;
            private String nPedidoAuxiliar;
            private String tCont;
            private String clausulas;
            private String convenio;
            private String centrosDeTrabajo;
            private String supuestoCelebracion;
            private String existeConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18;
            private String marqueSiexisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18; //INFO: Solo sale en el supuesto celebración B en pedidos alta lv32-33
            private String sustitucionDelTrabajador;
            private String motivoDeSustitucion;
            private String elLaTrabajadoraEstaEnPosesionDelTitulo;
            private String elLaTrabajadoraAcreditaConLaCertificacionPor;
            private String certificadoProfesional;
            private String desempleadoYMenor30Anos;
            private String desempleadoYMenor35AnosYConDiscapacSup30;
            private String menor30AnosRealizarPracticasNoLaboralesRD15432011;
            private String haberTerminadoLosEstudiosQueLeCapacitanParaLaPracticaObjetoDeDichoContratoConFecha;
            private String descripcion;
            private String contratacionMenos100;
            private String fechaPrevistaDeInicio;
            private String fechaPrevistaDeFin;
            private String rad_previsible;
            private String rad_imprevisible;
            private String avalNecesario;
            private String importeDelAval;
            private String observaciones;

            @SerializedName("DIALOG_SELECCIONDEEMPRESA")
            private DialogSeleccionDeEmpresa dialogSeleccionDeEmpresa;

            @NoArgsConstructor
            @Getter
            public static class DialogSeleccionDeEmpresa {
                private String empresa;
                private String nIF;
                private String nCliente;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nif;
                    private String qbe_empresa;
                    private String qbe_nCliente;
                    private String qbe_estado;
                    private String qbe_formaDePago;
                    private String qbe_comportamientoDePago;
                    private String qbe_detalle;

                    @SerializedName("N.I.F.")
                    private String nif;
                    @SerializedName("Empresa")
                    private String empresa;
                    @SerializedName("Nº Cliente")
                    private String nCliente;
                    @SerializedName("Estado")
                    private String estado;
                    @SerializedName("Forma de Pago")
                    private String formaDePago;
                    @SerializedName("Comportamiento de pago")
                    private String comportamientoDePago;
                    @SerializedName("Detalle")
                    private String detalle;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosDeJornada {
            private String departamento;
            private String nCandidatosAsignados;
            private String nCandidatosSolicitados;
            private String diasTrabajadosALaSemana;
            private String horasNormalesDiarias;
            private String periodoDePrueba;
            private String porcentajeJornada;
            private String diasDeTrabajoSemanales;
            private String horario;
            private String aTurnos;
            private String turno;
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosDeTarifa {
            private String oferta;
            private String categoriaLaboral;
            private String categoriaProfesional;
            private String seleccioneDuracionYTipoDeJornadaDeLaTarifa;
            private String tarifaNormal;
            private String tarifaIgualOInferior5Dias;
            private String compPago;
            private String grupoCotizacion;
            private String ocupacion;
            private String brutoMensual;
            private String bonificacion;
            private String fechaInicio;
            private String fechaFin;
            private String previsionarCompensacionFinContrato;
        }

        @NoArgsConstructor
        @Getter
        public static class TabDesgloseDeCategoriaProfesional {
            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_salarioBruto;
                private String qbe_salarial;
                private String qbe_extrasal;
                private String qbe_plusSalarial;
                private String qbe_plusExtraSal;
                private String qbe_seguridadSocial;
                private String qbe_formacionComPartit;
                private String qbe_indemnizFinContrato;
                private String qbe_revisionCoste;
                private String qbe_medica;
                private String qbe_otros;
                private String qbe_costeTotal;
                private String qbe_margenBruto;
                private String qbe_pvp;

                @SerializedName("Salario Bruto")
                private String salarioBruto;
                @SerializedName("Salarial")
                private String salarial;
                @SerializedName("Extrasal.")
                private String extrasal;
                @SerializedName("Plus Salarial")
                private String plusSalarial;
                @SerializedName("Plus Extrasal.")
                private String plusExtraSal;
                @SerializedName("Seguridad Social")
                private String seguridadSocial;
                @SerializedName("Formación + Com. Parit.")
                private String formacionComPartit;
                @SerializedName("Indemniz. Fin Contrato")
                private String indemnizFinContrato;
                @SerializedName("Revisión Coste")
                private String revisionCoste;
                @SerializedName("Médica %")
                private String medica;
                @SerializedName("Otros")
                private String otros;
                @SerializedName("Coste Total")
                private String costeTotal;
                @SerializedName("Margen Bruto %")
                private String margenBruto;
                @SerializedName("P.V.P.")
                private String pvp;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosColaboradores {
            private String nombre;
            private String primerApellido;
            private String segundoApellido;
            private String dNI;

            @SerializedName("DIALOG_PERFILDATOUNICO")
            private DialogPerfilDatoUnico dialogPerfilDatoUnico;

            @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
            private DialogSeleccionDeColaboradores dialogSeleccionDeColaboradores;

            @NoArgsConstructor
            @Getter
            public static class DialogPerfilDatoUnico {
                private String elegirPaisDeNacionalidad;
                private String elegirMpioResidencia;
                private String elegirOcupacion;
                private String seleccionarTitulacion;
                private String sexo;
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
                    private String qbe_detalle;

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
        public static class DialogSolicitudDeFechaDeAltaDelContrato {
            private String introduzcaLaFechaDeAntiguedadDelContrato;
            private String rad_RealizandoElTraspasoDeLosContratos;
            private String rad_SinTraspasarLosContratos;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class RiesgosGestionDePedidosBloqueados {
        private String empresa;
        private String limiteDeRiesgoDesde;
        private String limiteDeRiesgoHasta;
        private String nPedidoDesde;
        private String nPedidoHasta;
        private String riesgoPedidoDesde;
        private String riesgoPedidoHasta;
        private String fechaInicio;
        private String fechaFin;
        private String pedidosYaGestionados;
        private String provinciaOficina;
        private String oficina;
        private String observaciones;

        @SerializedName("TABLE")
        private Table table;

        @SerializedName("DIALOG_DESBLOQUEODEPEDIDOS")
        private DialogDesbloqueoDePedidos dialogDesbloqueoDePedidos;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_nPedido;
            private String qbe_fInicio;
            private String qbe_fFin;
            private String qbe_codigo;
            private String qbe_empresa;
            private String qbe_limiteR;
            private String qbe_riesgo;
            private String qbe_riesgoAcumulado;
            private String qbe_estadoSeguro;
            private String qbe_importeAsegurado;
            private String qbe_razonBloqueo;
            private String qbe_observaciones;
            private String qbe_selecc;

            @SerializedName("Nº Pedido")
            private String nPedido;
            @SerializedName("F.Inicio")
            private String fInicio;
            @SerializedName("F.Fin")
            private String fFin;
            @SerializedName("Código")
            private String codigo;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("Límite R.")
            private String limiteR;
            @SerializedName("Riesgo")
            private String riesgo;
            @SerializedName("Riesgo Acumulado")
            private String riesgoAcumulado;
            @SerializedName("Estado Seguro")
            private String estadoSeguro;
            @SerializedName("Importe Asegurado")
            private String importeAsegurado;
            @SerializedName("Razón Bloqueo")
            private String razonBloqueo;
            @SerializedName("Observaciones")
            private String observaciones;
            @SerializedName("Selecc.")
            private String selecc;
        }

        @NoArgsConstructor
        @Getter
        public static class DialogDesbloqueoDePedidos {
            private String observaciones;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class PedidosConsulta {
        private String nPedido;
        private String estado;
        private String oferta;
        private String buscarANivelNacional;
        private String fechaDeInicioDesde;
        private String fechaDeIniciohasta;
        private String fechaDeFinDesde;
        private String fechaDeFinhasta;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String empresa;
        private String nCliente;

        @SerializedName("TABLE_EMPRESA")
        private TableEmpresa tableEmpresa;

        @SerializedName("TABLE_COLABORADOR")
        private TableColaborador tableColaborador;

        @SerializedName("DIALOG_BUSQUEDADEEMPRESAS")
        private DialogBusquedaDeEmpresa dialogBusquedaDeEmpresa;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class TableEmpresa {
            private String qbe_nPedido;
            private String qbe_fechaDeInicio;
            private String qbe_fechaDeFin;
            private String qbe_empresa;
            private String qbe_estado;
            private String qbe_oferta;
            private String qbe_detalle;

            @SerializedName("Nº Pedido")
            private String nPedido;
            @SerializedName("Fecha de Inicio")
            private String fechaDeInicio;
            @SerializedName("Fecha de Fin")
            private String fechaDeFin;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("Estado")
            private String estado;
            @SerializedName("Oferta")
            private String oferta;
            @SerializedName("Detalle")
            private String detalle;
        }

        @NoArgsConstructor
        @Getter
        public static class TableColaborador {
            private String qbe_colaborador;
            private String qbe_generado;
            private String qbe_anulado;
            private String qbe_sustituto;
            private String qbe_prorroga;

            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Generado")
            private String generado;
            @SerializedName("Anulado")
            private String anulado;
            @SerializedName("Sustituto")
            private String sustituto;
            @SerializedName("Prórroga")
            private String prorroga;
        }

        @NoArgsConstructor
        @Getter
        public static class DialogBusquedaDeEmpresa {
            private String empresaClienteRazonSocial;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_empresa;
                private String qbe_nif;

                @SerializedName("Empresa")
                private String empresa;
                @SerializedName("N.I.F.")
                private String nif;
            }

        }

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_nombreYApellidos;
                private String qbe_direccion;
                private String qbe_detalle;

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
    public static class PedidosModificacion {

        @SerializedName("DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO")
        private DialogSolicitudDeFechaDeAltaDelContrato dialogSolicitudDeFechaDeAltaDelContrato;

        @NoArgsConstructor
        @Getter
        public static class DialogSolicitudDeFechaDeAltaDelContrato {
            private String introduzcaLaFechaDeAntiguedadDelContrato;
            private String rad_RealizandoElTraspasoDeLosContratos;
            private String rad_SinTraspasarLosContratos;
        }

    }
}

