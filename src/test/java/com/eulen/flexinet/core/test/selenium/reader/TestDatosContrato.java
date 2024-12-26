package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosContrato {

    @SerializedName("CONTRATOS__CONSULTA")
    private ContratosConsulta contratosConsulta;

    @SerializedName("CONTRATOS__TRASPASO_MASIVO")
    private ContratosTraspasoMasivos contratosTraspasoMasivos;

    @SerializedName("CONTRATOS__BAJA_CONSULTA")
    private ContratosBajaConsulta contratosBajaConsulta;

    @SerializedName("CONTRATOS__ANULACION")
    private ContratosAnulacion contratosAnulacion;

    @SerializedName("CONTRATOS__BAJA_DARDEBAJA")
    private ContratosBajaDarDeBaja contratosBajaDarDeBaja;

    @SerializedName("CONTRATOS__BAJA_BAJAS_MASIVAS")
    private ContratosBajaBajasMasivas contratosBajaBajasMasivas;

    @SerializedName("CONTRATOS__PRORROGAS_CONSULTA")
    private ContratosProrrogasConsulta contratosProrrogasConsulta;

    @SerializedName("CONTRATOS__PRORROGAS_ANULACION")
    private ContratosProrrogasAnulacion contratosProrrogasAnulacion;

    @SerializedName("CONTRATOS__PRORROGAS_ALTA")
    private ContratosProrrogasAlta contratosProrrogasAlta;

    @SerializedName("CONTRATOS__NOVACION_ALTA")
    private ContratosNovacionAlta contratosNovacionAlta;

    @SerializedName("CONTRATOS__ALTA_SUSTITUCION")
    private ContratoAltaSustitucion contratoAltaSustitucion;

    @SerializedName("CONTRATOS__CONTROL_ENVIOS_CPDS")
    private ContratosControlEnviosCpds contratosControlEnviosCpds;

    @NoArgsConstructor
    @Getter
    public static class ContratosConsulta {
        private String empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF; //TODO: este es el mismo lkp_nif por lo que debería quitarse para dejar solo el lkp_nif ver donde se usa y quitarlo
        private String lkp_nIF;
        private String nContrato;
        private String secuencial;
        private String generados;
        private String traspasados;
        private String activos;
        private String bajas;
        private String conProrrogas;
        private String novacion;
        private String llamamiento;
        private String ceseVoluntario;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String busquedaANivelNacional;
        private String buscarANivelNacional; //TODO parece que este campo no es usadp
        private String colorSemaforo;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos; //TODO: pasar este campo de tipo qbe dentro del objeto TABLE
            private String qbe_direccion; //TODO: pasar este campo de tipo qbe dentro del objeto TABLE

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
                @SerializedName("Detalle")
                private String detalle;
            }
        }

        @SerializedName("DIALOG_SELECCIONDETALLEDELCONTRATO")
        private DialogSeleccionDetalleDelContrato dialogSeleccionDetalleDelContrato;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDetalleDelContrato {
            private String traspasarErp;
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("Empresa")
            private String empresaContrato;
            @SerializedName("Oficina")
            private String oficinaContrato;
            @SerializedName("@")
            private String arrobaContrato;
            @SerializedName("AF")
            private String afContrato;
            @SerializedName("Activo")
            private String activoContrato;
            @SerializedName("Codigo Contrato")
            private String codigoContrato;
            @SerializedName("Colaborador")
            private String colaboradorContrato;
            @SerializedName("Fec. Antigüedad")
            private String fecAntiguedadContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("L. Venta")
            private String lVentaContrato;
            @SerializedName("MSG Envío")
            private String mSGEnvioContrato;
            @SerializedName("Motivo Baja")
            private String motivoBajaContrato;
            @SerializedName("NIF")
            private String nIFContrato;
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Nº Proyecto")
            private String nProyectoContrato;
            @SerializedName("Prev/Imprev")
            private String prevImprevContrato;
            @SerializedName("Sec.")
            private String sECContrato;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Status")
            private String statusContrato;
            @SerializedName("Tipo Contrato")
            private String tipoContrato;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosTraspasoMasivos {
        private String empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String nContrato;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String buscarANivelNacional;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
                @SerializedName("Detalle")
                private String detalle;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("qbe_seleccionarContrato")
            private String qbe_seleccionarContrato;
            @SerializedName("qbe_nContrato")
            private String qbe_nContrato;
            @SerializedName("qbe_empresa")
            private String qbe_empresa;
            @SerializedName("qbe_nIF")
            private String qbe_nIF;
            @SerializedName("qbe_colaborador")
            private String qbe_colaborador;
            @SerializedName("qbe_seguridadSocialContrato")
            private String qbe_seguridadSocialContrato;
            @SerializedName("qbe_fecInicioContrato")
            private String qbe_fecInicioContrato;
            @SerializedName("qbe_fecFinContrato")
            private String qbe_fecFinContrato;
            @SerializedName("qbe_fecAntiguedadContrato")
            private String qbe_fecAntiguedadContrato;


            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Antigüedad")
            private String fecAntiguedadContrato;
            @SerializedName("Seleccionar")
            private String seleccionarContrato;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosBajaConsulta {
        private String empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String nContrato;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String buscarANivelNacional;
        private String colorSemaforo;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
            }
        }

        @SerializedName("DIALOG_SELECCIONDETALLEDELCONTRATO")
        private DialogSeleccionDetalleDelContrato dialogSeleccionDetalleDelContrato;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDetalleDelContrato {
            private String traspasarErp;
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
        	@SerializedName("Info") //@UAT
        	private String info; 
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresaContrato;
            @SerializedName("NIF")
            private String nIFContrato;
            @SerializedName("Sec.")
            private String sECContrato;
            @SerializedName("Colaborador")
            private String colaboradorContrato;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Baja")
            private String fecBajaContrato;
            @SerializedName("Motivo Baja")
            private String motivoBajaContrato;
            @SerializedName("Afiliación")
            private String afiliacion;
            @SerializedName("Status") //@UAT
            private String status;
            @SerializedName("MSG Envio")
            private String msgEnvio; //@UAT
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosAnulacion {
        private String empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String nContrato;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String busquedaANivelNacional;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec")
            private String sec;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Antigüedad")
            private String fecAntiguedadContrato;
            @SerializedName("Seleccionar")
            private String seleccionarContrato;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosBajaDarDeBaja {
        private String empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String nContrato;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String buscarANivelNacional;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec.")
            private String sEC;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Antigüedad")
            private String fecAntiguedadContrato;
            @SerializedName("Máximo Días Vacaciones")
            private String maximoDiasVacaciones;
            @SerializedName("Embargos")
            private String embargos;
        }

        @SerializedName("DIALOG_DARDEBAJA")
        private DialogDarDeBaja dialogDarDeBaja;

        @NoArgsConstructor
        @Getter
        public static class DialogDarDeBaja {
            private String motivoDeLaBaja;
            private String fecha;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosBajaBajasMasivas {
        private String empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String nContrato;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String buscarANivelNacional;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec.")
            private String sEC;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Antigüedad")
            private String fecAntiguedadContrato;
            @SerializedName("Seleccionar")
            private String seleccionarContrato;
        }

        @SerializedName("DIALOG_BAJAMASIVACONTRATO")
        private DialogBajaMasivaContrato dialogBajaMasivaContrato;

        @NoArgsConstructor
        @Getter
        public static class DialogBajaMasivaContrato {
            private String fecha;
        }

        @SerializedName("DIALOG_SELECCIONDECONTRATOS")
        private DialogSeleccionContrato dialogSeleccionContrato;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionContrato {
            private String qbe_nroContrato;
            private String qbe_empresa;
            private String qbe_nif;
            private String qbe_sec;
            private String qbe_colaborador;
            private String qbe_seguridadSocial;
            private String qbe_fechaInicio;
            private String qbe_fechaFin;
            private String qbe_fechaAntiguedad;

            @SerializedName("TABLE")
            private DialogSeleccionColaboradores.Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nº Contrato")
                private String nroContrato;
                @SerializedName("Empresa")
                private String empresa;
                @SerializedName("NIF")
                private String nIF;
                @SerializedName("Sec.")
                private String sEC;
                @SerializedName("Colaborador")
                private String colaborador;
                @SerializedName("Seguridad Social")
                private String seguridadSocial;
                @SerializedName("Fec. Inicio")
                private String fecInicio;
                @SerializedName("Fec. Fin")
                private String fecFin;
                @SerializedName("Fec. Antigüedad")
                private String FecAntiguedad;
                @SerializedName("Seleccionar")
                private String seleccionar;
            }
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosProrrogasConsulta {
        private String empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String nContrato;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String busquedaANivelNacional;

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec")
            private String sec;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("@")
            private String signoArroba;
            @SerializedName("Status")
            private String status;
            @SerializedName("MSG Envío")
            private String msgEnvio;
            @SerializedName("Info")
            private String info;
            @SerializedName("Seleccionar")
            private String seleccionarContrato;

            @SerializedName("DIALOG_HISTORICODETRASPASOSAORACLE")
            private DialogHistoricoDeTraspasosAOracle dialoghistoricodetraspasosaoracle;
            @NoArgsConstructor
            @Getter
            public static class DialogHistoricoDeTraspasosAOracle {
                @SerializedName("TABLE1")
                private Table1 table;
                @NoArgsConstructor
                @Getter
                public static class Table1{
                    private String qbe_Log;
                    private String qbe_Lote;
                    private String qbe_Acción;
                    private String qbe_Estado;
                    private String qbe_Estado1;
                    private String qbe_numProyect;
                    private String qbe_Fecha_creación;
                    private String qbe_Fecha_actualización;
                    private String qbe_Fecha_Envío_a_Oracle;
                    private String qbe_Fecha_procesado;
                    private String qbe_Usuario_creador;

                    @SerializedName("Log")
                    private String log;
                    @SerializedName("Lote")
                    private String lote;
                    @SerializedName("Acción")
                    private String accion;
                    @SerializedName("Estado")
                    private String estado; //INFO: Este campo hay que dejarlo vacio porque esta duplicado en el front y afecta a la automatización, dado que es un dato opcional lo dejamos vacio
                    @SerializedName("Estado2")
                    private String estado2; //INFO: Este campo hay que dejarlo vacio porque esta duplicado en el front y afecta a la automatización, dado que es un dato opcional lo dejamos vacio
                    @SerializedName("numProyect")
                    private String numeroproyecto;
                    @SerializedName("Fecha creación")
                    private String fechacreacion;
                    @SerializedName("Fecha actualización")
                    private String fechaactualizacion;
                    @SerializedName("Fecha envío a Oracle")
                    private String fecha_env_oracle;
                    @SerializedName("Fecha procesado")
                    private String fechaprocesado;
                    @SerializedName("Usuario creador")
                    private String usuariocreador;
                }
            }
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosProrrogasAnulacion {
        private String empresa;
        private String lkp_empresa;
        private String nContrato;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String busquedaANivelNacional;

        @SerializedName("DIALOG_SELECCIONDEEMPRESA")
        private DialogSeleccionDeEmpresa dialogSeleccionDeEmpresa;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDeEmpresa {
            private String qbe_empresaCliente;
            private String qbe_nIF;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Empresa")
                private String empresa;
                @SerializedName("N.I.F.")
                private String nIF;
            }

        }

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
                @SerializedName("Detalle")
                private String detalle;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec.")
            private String sec;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Seg. Social")
            private String segSocialContrato;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Antigüedad")
            private String fecAntiguedadContrato;
            @SerializedName("Seleccionar")
            private String seleccionarContrato;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosProrrogasAlta {
        private String empresa;
        private String lkp_empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String nContrato;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String busquedaANivelNacional;
        private String fechaDeFinalizacionProrroga;

        @SerializedName("DIALOG_SELECCIONDEEMPRESA")
        private DialogSeleccionDeEmpresa dialogSeleccionDeEmpresa;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDeEmpresa {
            private String qbe_empresaCliente;
            private String qbe_nIF;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Empresa")
                private String empresa;
                //@SerializedName("N.I.F.")
                private String nIF;
            }

        }

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                //@SerializedName("Dirección")
                private String direccion;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("Seleccionar")
            private String seleccionarContrato;
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec")
            private String sec;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Antigüedad")
            private String fecAntiguedadContrato;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosNovacionAlta {
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String empresa;
        private String lkp_empresa;

        @SerializedName("DIALOG_SELECCIONDEEMPRESA")
        private DialogSeleccionDeEmpresa dialogSeleccionDeEmpresa;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDeEmpresa {
            private String qbe_empresaCliente;
            private String qbe_nIF;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Empresa")
                private String empresa;
                //@SerializedName("N.I.F.")
                private String nIF;
            }

        }

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                //@SerializedName("Dirección")
                private String direccion;
            }
        }

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("qbe_seleccionarContrato")
            private String qbe_seleccionarContrato;
            @SerializedName("qbe_nContrato")
            private String qbe_nContrato;
            @SerializedName("qbe_empresa")
            private String qbe_empresa;
            @SerializedName("qbe_nIF")
            private String qbe_nIF;
            @SerializedName("qbe_sec")
            private String qbe_sec;
            @SerializedName("qbe_colaborador")
            private String qbe_colaborador;
            @SerializedName("qbe_seguridadSocialContrato")
            private String qbe_seguridadSocialContrato;
            @SerializedName("qbe_fecInicioContrato")
            private String qbe_fecInicioContrato;
            @SerializedName("qbe_fecFinContrato")
            private String qbe_fecFinContrato;
            @SerializedName("qbe_fecAntiguedadContrato")
            private String qbe_fecAntiguedadContrato;

            @SerializedName("Seleccionar")
            private String seleccionarContrato;
            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec")
            private String sec;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Antigüedad")
            private String fecAntiguedadContrato;
        }

        @SerializedName("DIALOG_ALTANOVACION")
        private DialogAltaNovacion dialogAltaNovacion;

        @NoArgsConstructor
        @Getter
        public static class DialogAltaNovacion {
            private String tipoNovacion;
            private String fecha;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratoAltaSustitucion {
        private String empresa;
        private String nCliente;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String nContrato;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;
        private String busquedaANivelNacional;
        private String sexo;
        private String fechaInicioSustitucion;

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
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
                @SerializedName("Detalle")
                private String detalle;
            }
        }
        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("qbe_seleccionarContrato")
            private String qbe_seleccionarContrato;
            @SerializedName("qbe_nContrato")
            private String qbe_nContrato;
            @SerializedName("qbe_empresa")
            private String qbe_empresa;
            @SerializedName("qbe_nIF")
            private String qbe_nIF;
            @SerializedName("qbe_sec")
            private String qbe_sec;
            @SerializedName("qbe_colaborador")
            private String qbe_colaborador;
            @SerializedName("qbe_seguridadSocialContrato")
            private String qbe_seguridadSocialContrato;
            @SerializedName("qbe_fecInicioContrato")
            private String qbe_fecInicioContrato;
            @SerializedName("qbe_fecFinContrato")
            private String qbe_fecFinContrato;
            @SerializedName("qbe_fecBajaContrato")
            private String qbe_fecBajaContrato;
            @SerializedName("qbe_MotivoBajaContrato")
            private String qbe_MotivoBajaContrato;
            @SerializedName("qbe_fecAntiguedadContrato")
            private String qbe_fecAntiguedadContrato;


            @SerializedName("Nº Contrato")
            private String nContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec")
            private String sec;
            @SerializedName("Colaborador")
            private String colaborador;
            @SerializedName("Seguridad Social")
            private String seguridadSocialContrato;
            @SerializedName("Fec. Inicio")
            private String fecInicioContrato;
            @SerializedName("Fec. Fin")
            private String fecFinContrato;
            @SerializedName("Fec. Baja")
            private String FecBaja;
            @SerializedName("Motivo Baja")
            private String motivobaja;
            @SerializedName("Fec. Antigüedad ")
            private String fecAntigüedad ;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class ContratosControlEnviosCpds {
        private String empresa;
        private String lkp_empresa;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nIF;
        private String lkp_nIF;
        private String filtrarEstado;
        private String fechadeInicioDesde;
        private String fechadeInicioHasta;
        private String fechaDeFinDesde;
        private String fechaDeFinHasta;

        @SerializedName("DIALOG_SELECCIONDEEMPRESA")
        private DialogSeleccionDeEmpresa dialogSeleccionDeEmpresa;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionDeEmpresa {
            private String qbe_empresaCliente;
            private String qbe_nIF;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Empresa")
                private String empresa;
                @SerializedName("N.I.F.")
                private String nIF;
            }

        }

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogSeleccionColaboradores dialogSeleccionColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogSeleccionColaboradores {
            private String qbe_nombreYApellidos;
            private String qbe_direccion;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                @SerializedName("Nombre y Apellidos")
                private String nombreYApellidos;
                @SerializedName("Dirección")
                private String direccion;
            }
        }
        @SerializedName("DIALOG_FECHAENVIO_CPDS_PRORROGAS")
        private DialogFechaEnvioCpds dialogFechaEnvioCpds;

        @SerializedName("DIALOG_FECHA_RECEPCION_CPDS_PRORROGAS")
        private DialogFechaRecepcionCpds dialogFechaRecepcionCpds;

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("qbe_seleccionarContrato")
            private String qbe_seleccionarContrato;
            @SerializedName("qbe_empresa")
            private String qbe_empresa;
            @SerializedName("qbe_nIF")
            private String qbe_nIF;
            @SerializedName("qbe_sec")
            private String qbe_sec;
            @SerializedName("qbe_nombre")
            private String qbe_nombre;
            @SerializedName("qbe_cpd_pro")
            private String qbe_cpd_pro;
            @SerializedName("qbe_fecInicio")
            private String qbe_fecInicio;
            @SerializedName("qbe_fecFin")
            private String qbe_fecFin;
            @SerializedName("qbe_estado")
            private String qbe_estado;
            @SerializedName("qbe_tipo")
            private String qbe_tipo;
            @SerializedName("qbe_fecEnvio")
            private String qbe_fecEnvio;
            @SerializedName("qbe_fecRecep")
            private String qbe_fecRecep;

            @SerializedName("Selección")
            private String seleccionarContrato;
            @SerializedName("Empresa")
            private String empresa;
            @SerializedName("NIF")
            private String nIF;
            @SerializedName("Sec.")
            private String sec;
            @SerializedName("Nombre")
            private String colaborador;
            @SerializedName("Nº CPD / PRO")
            private String NumumeroCpd;
            @SerializedName("Fecha Inicio")
            private String fecInicioContrato;
            @SerializedName("Fecha Fin")
            private String fecFinContrato;
            @SerializedName("Estado")
            private String Estado;
            @SerializedName("Tipo")
            private String tipo;
            @SerializedName("Fecha Envío")
            private String fecEnvio;
            @SerializedName("Fecha Recep.")
            private String fecRecep;
        }

        @NoArgsConstructor
        @Getter
        public static class DialogFechaEnvioCpds {
            private String fecha;
        }

        @NoArgsConstructor
        @Getter
        public static class DialogFechaRecepcionCpds {
            private String fechaRecepcionCpds;
        }
    }
}