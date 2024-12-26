package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosGestionClientesContrato {


    @SerializedName("GESTION_CLIENTES_CONTRATO__ALTA")
    private GestionClientesContratoAlta gestionClientesContratoAlta;

    @SerializedName("GESTION_CLIENTES_CONTRATO__CONSULTA")
    private GestionClientesContratoConsulta gestionClientesContratoConsulta;

    @SerializedName("GESTION_CLIENTES_CONTRATO__MODIFICAR")
    private GestionClientesContratoModificar gestionClientesContratoModificar;


    @NoArgsConstructor
    @Getter
    public static class GestionClientesContratoAlta {
        private String in_razonSocial;

        @SerializedName("TABLE")
        private Table table;
        @SerializedName("TAB_CABECERA")
        private TabCabecera tabCabecera;
        @SerializedName("TAB_OTROSDATOSIDENTIFICATIVOS")
        private TabOtrosDatosIdentificativos tabOtrosDatosIdentificativos;
        @SerializedName("TAB_DATOSECONOMICOS")
        private TabDatosEconomicos tabDatosEconomicos;
        @SerializedName("TAB_CATEGORIASEGURIDADSOCIAL")
        private TabCategoriaSeguridadSocial tabCategoriaSeguridadSocial;
        @SerializedName("TAB_RETRATOROBOT")
        private TabRetratoRobot tabRetratoRobot;
        @SerializedName("TAB_TIPOSDEALERTA")
        private TabTiposDeAlerta tabTiposDeAlerta;


        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_nombreEmpresa;
            private String qbe_direccion;
            private String qbe_provincia;
            private String qbe_nIF;
            private String qbe_cNAE;
            private String qbe_responsable;

            @SerializedName("Nombre Empresa")
            private String table_nombreEmpresa;
            @SerializedName("Dirección")
            private String table_direccion;
            @SerializedName("Provincia")
            private String table_provincia;
            @SerializedName("N.I.F.")
            private String table_nIF;
            @SerializedName("C.N.A.E.")
            private String table_cNAE;
            @SerializedName("Responsable")
            private String table_responsable;
        }

        @NoArgsConstructor
        @Getter
        public static class TabCabecera {
            private String ro_nif;
            private String ro_razonSocial;
            private String ro_clienteNacional;
            private String ro_numeroCliente;
            private String ro_limiteDeRiesgo;
            private String rp_margenBruto;
            private String ro_medioDePago;
            private String ro_formaDePago;
            private String ro_siglas;
            private String ro_actividad;
            private String ro_cnae;
            private String ro_sic;
            private String ro_responsableDeCuenta;
            private String ro_estado;
            private String ro_oficinaOrigenContrato;
            private String ro_paginaWeb;
            private String ro_domicilioSocial;
            private String ro_codigoPostal;
            private String ro_provincia;
            private String ro_domicilioFiscal;

        }

        @NoArgsConstructor
        @Getter
        public static class TabOtrosDatosIdentificativos {
            private String sel_ejecutivoDecuenta;
            private String sel_medioDeCapt;
            private String lkp_convenio;
            private String in_boe;
            private String in_telefono;
            private String sel_clausuladoDelContratoLaboral;
            private String sel_clausuladoDelCPD;
            private String txt_observaciones;

            @SerializedName("DIALOG_BUSQUEDADECONVENIOS")
            private DialogBusquedaDeConvenios dialogBusquedaDeConvenios;

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeConvenios {
                private String in_nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nombre;
                    @SerializedName("Nombre")
                    private String table_nombre;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosEconomicos {

            private String sel_impuestosTipoPorcentaje;
            private String in_diasFijosDePago1;
            private String in_diasFijosDePago2;
            private String in_nCtaCorrienteEtt;
            private String in_banco;
            private String sel_entidad;
            private String sel_sucursal;
            private String in_dc;
            private String in_nCuenta;
            private String in_datosIbanEtt;
            private String in_ibanPais;
            private String in_ibanExtrajero;

            @SerializedName("SECTION_DIRECCIONDEFACTURA")
            private SectionDireccionDeFactura sectionDireccionDeFactura;

            @SerializedName("SECTION_CONTACTO")
            private SectionContacto sectionContacto;


            @NoArgsConstructor
            @Getter
            public static class SectionDireccionDeFactura {
                private String sel_tipo;
                private String in_nombre;
                private String in_localidad;
                private String sel_provincia;
                private String in_cp;
                private String in_destinatario;
            }

            @NoArgsConstructor
            @Getter
            public static class SectionContacto {
                private String in_nif;
                private String in_nombre;
                private String in_apellidos1;
                private String in_apellidos2;
                private String in_cargo;
                private String in_telf1;
                private String in_telf2;
                private String in_email;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nombreYApellidos;
                    private String qbe_nIF;
                    private String qbe_cargo;
                    private String qbe_telefono;
                    private String qbe_fax;
                    private String qbe_eMail;
                    private String qbe_firmCPD;
                    private String qbe_firmPRL;
                    private String qbe_contactoPpal;
                    private String qbe_respPago;

                    @SerializedName("Nombre y Apellidos")
                    private String table_nombreYApellidos;
                    @SerializedName("NIF")
                    private String table_nIF;
                    @SerializedName("Cargo")
                    private String table_cargo;
                    @SerializedName("Teléfono")
                    private String table_telefono;
                    @SerializedName("Fax")
                    private String table_fax;
                    @SerializedName("E-Mail")
                    private String table_eMail;
                    @SerializedName("Firm. CPD")
                    private String table_firmCPD;
                    @SerializedName("Firm. PRL")
                    private String table_firmPRL;
                    @SerializedName("Contacto Ppal.")
                    private String table_contactoPpal;
                    @SerializedName("Resp. Pago")
                    private String table_respPago;
                }
            }

        }

        @NoArgsConstructor
        @Getter
        public static class TabCategoriaSeguridadSocial {
            private String lkp_categoriaLaboral;
            private String lkp_categoriaProfesional;
            private String sel_regimenDeLaSeguridadSocial;
            private String btn_fichaPRL;
            private String chk_prlPersonalizable;
            private String btn_anadirCategoria;

            @SerializedName("DIALOG_BUSQUEDADECATEGORIASLABORALES")
            private DialogBusquedaDeCategoriasLaborales dialogBusquedaDeCategoriasLaborales;
            @SerializedName("DIALOG_BUSQUEDADECATEGORIASPROFESIONALES")
            private DialogBusquedaDeCategoriasProfesionales dialogBusquedaDeCategoriasProfesionales;
            @SerializedName("DIALOG_FICHAPRLDELACATEGORIA")
            private DialogFichaPRLdeLaCategoria dialogFichaPRLdeLaCategoria;
            @SerializedName("TABLE_CATEGORIASPROFESIONALESLABORALESASOCIADASALAEMPRESA")
            private TableCategoriasProfesionalesLaboralesAsociadasALaEmpresa tableCategoriasProfesionalesLaboralesAsociadasALaEmpresa;
            @SerializedName("TABLE_REGIMENESASOCIADOSALAEMPRESA")
            private TableRegimenesAsociadosALaEmpresa tableRegimenesAsociadosALaEmpresa;


            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeCategoriasLaborales {
                private String in_nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_codigo;
                    private String qbe_categoriaLaboral;

                    @SerializedName("Código")
                    private String table_codigo;
                    @SerializedName("Categoria Laboral")
                    private String table_categoriaLaboral;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeCategoriasProfesionales {
                private String in_nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_codigo;
                    private String qbe_categoriaProfesional;

                    @SerializedName("Código")
                    private String table_codigo;
                    @SerializedName("Categoria Profesional")
                    private String table_categoriaProfesional;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class DialogFichaPRLdeLaCategoria {
                private String in_identificacionDelServicio;
                private String in_empresaUsuaria;
                private String in_nDeCliente;
                private String in_direccionDelCentroDeTrabajo;
                private String in_denominacionDelPuestoDeTrabajo;
                private String in_trabajador;
                private String in_nif;
                private String txt_caracteristicasDelPuestoDeTrabajoYTareasADesarrollar;
                private String txt_riesgosDelCentro;
                private String txt_riesgosDelPuestoDeTrabajoFichasDeDatosDeSeguridadFichasTecnicasDeEquiposDeTrabajoYMaquinaria;
                private String txt_medidasPreventivas;
                private String txt_equiposDeProteccion;
                private String txt_observaciones;
            }

            @NoArgsConstructor
            @Getter
            public static class TableCategoriasProfesionalesLaboralesAsociadasALaEmpresa {
                private String qbe_categoriaLaboral;
                private String qbe_categoriaProfesional;
                private String qbe_regimenesSegSocial;

                @SerializedName("Categoria Laboral")
                private String table_categoriaLaboral;
                @SerializedName("Categoria Profesional")
                private String table_categoriaProfesional;
                @SerializedName("Regimenes Seg. Social")
                private String table_regimenesSegSocial;
                @SerializedName("Ficha PRL")
                private String table_fichaPRL;
                private String table_btn_fichaPRL1;
                private String table_btn_fichaPRL2;
                @SerializedName("¿Personalizable?")
                private String table_personalizable;
                @SerializedName("Cursos PRL")
                private String table_cursosPRL;
                @SerializedName("¿Personalizable PRL?")
                private String table_personalizablePRL;
                @SerializedName("Rec. Médico")
                private String table_recMedico;

                @SerializedName("DIALOG_FUNCIONES")
                private DialogFunciones dialogFunciones;

                @NoArgsConstructor
                @Getter
                public static class DialogFunciones {
                    private String in_nueva;
                    private String sel_funciones;
                }

            }

            @NoArgsConstructor
            @Getter
            public static class TableRegimenesAsociadosALaEmpresa{
                private String qbe_regimen;
                private String qbe_nSeguridadSocial;

                @SerializedName("Régimen")
                private String table_regimen;
                @SerializedName("Nº Seguridad Social")
                private String table_nSeguridadSocial;
            }

        }

        @NoArgsConstructor
        @Getter
        public static class TabRetratoRobot {
            private String sel_ventas;
            private String sel_nEmpleados;

            private String chk_porTiposDeHoras;
            private String chk_porCentrosDeTrabajo;
            private String chk_porCategoriaProfesional;
            private String chk_mostrarPrecioUnidad;
            private String chk_porColaborador;
            private String chk_colaboradorConcepto;
            private String chk_mostrarMinFinicioMaxFinPartes;
            private String chk_porDuracionDelContrato;
            private String chk_porDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo;
            private String chk_porNumeroDeColaboradores;
            private String in_numeroMaximoDeColaboradoresEnFactura;
            private String chk_porImporteGlobal;
            private String in_importeMaximoPorFacturaImporteCorrespondienteIncluido;
        }


        @NoArgsConstructor
        @Getter
        public static class TabTiposDeAlerta {
            private String chk_vencimientoPeriodoDePruebas;
            private String in_vencimientoPeriodoDePruebas;
            private String chk_finalizacionContratosEventualesPracticasOFD;
            private String in_finalizacionContratosEventualesPracticasOFD;
            private String chk_finalizacionDeContratosInternidad;
            private String in_finalizacionDeContratosInternidad;
            private String chk_finalizacionDeProrrogas;
            private String in_finalizacionDeProrrogas;
            private String chk_caducidadReconocomientoMedico;
            private String in_caducidadReconocimientoMedico;
            private String chk_caducidadPreventor;
            private String in_caducidadPreventor;
            private String chk_caducidadPermisoTrabajo;
            private String in_caducidadPermisoTrabajo;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class GestionClientesContratoConsulta {
        private String in_razonSocial;
        private String in_nifEmpresa;
        private String chk_pedidosActivos;
        private String rad_actualmente;
        private String rad_rangoDeFechas;
        private String date_desde;
        private String date_hasta;
        private String rad_realizarBusquedaANivelNacionalSI;
        private String rad_realizarBusquedaANivelNacionalNODentroDeSuOficina;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_id;
            private String qbe_nombreDeEmpresa;
            private String qbe_direccion;
            private String qbe_provincia;
            private String qbe_nifEmpresa;
            private String qbe_telefonoContacto;

            @SerializedName("ID")
            private String table_id;
            @SerializedName("Nombre Empresa")
            private String table_nombreDeEmpresa;
            @SerializedName("Dirección")
            private String table_direccion;
            @SerializedName("Provincia")
            private String table_provincia;
            @SerializedName("NIF Empresa")
            private String table_nifEmpresa;
            @SerializedName("Teléfono Contacto")
            private String table_telefonoContacto;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class GestionClientesContratoModificar {
        private String in_razonSocial;

        @SerializedName("TABLE")
        private Table table;
        @SerializedName("TAB_CABECERA")
        private TabCabecera tabCabecera;
        @SerializedName("TAB_OTROSDATOSIDENTIFICATIVOS")
        private TabOtrosDatosIdentificativos tabOtrosDatosIdentificativos;
        @SerializedName("TAB_DATOSECONOMICOS")
        private TabDatosEconomicos tabDatosEconomicos;
        @SerializedName("TAB_CATEGORIASEGURIDADSOCIAL")
        private TabCategoriaSeguridadSocial tabCategoriaSeguridadSocial;
        @SerializedName("TAB_RETRATOROBOT")
        private TabRetratoRobot tabRetratoRobot;
        @SerializedName("TAB_TIPOSDEALERTA")
        private TabTiposDeAlerta tabTiposDeAlerta;


        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_nombreEmpresa;
            private String qbe_direccion;
            private String qbe_provincia;
            private String qbe_nIF;
            private String qbe_cNAE;
            private String qbe_responsable;

            @SerializedName("Nombre Empresa")
            private String table_nombreEmpresa;
            @SerializedName("Dirección")
            private String table_direccion;
            @SerializedName("Provincia")
            private String table_provincia;
            @SerializedName("N.I.F.")
            private String table_nIF;
            @SerializedName("C.N.A.E.")
            private String table_cNAE;
            @SerializedName("Responsable")
            private String table_responsable;
        }

        @NoArgsConstructor
        @Getter
        public static class TabCabecera {
            private String ro_nif;
            private String ro_razonSocial;
            private String ro_clienteNacional;
            private String ro_numeroCliente;
            private String ro_limiteDeRiesgo;
            private String rp_margenBruto;
            private String ro_medioDePago;
            private String ro_formaDePago;
            private String ro_siglas;
            private String ro_actividad;
            private String ro_cnae;
            private String ro_sic;
            private String ro_responsableDeCuenta;
            private String ro_estado;
            private String ro_oficinaOrigenContrato;
            private String ro_paginaWeb;
            private String ro_domicilioSocial;
            private String ro_codigoPostal;
            private String ro_provincia;
            private String ro_domicilioFiscal;

        }

        @NoArgsConstructor
        @Getter
        public static class TabOtrosDatosIdentificativos {
            private String sel_ejecutivoDecuenta;
            private String sel_medioDeCapt;
            private String lkp_convenio;
            private String in_boe;
            private String in_telefono;
            private String sel_clausuladoDelContratoLaboral;
            private String sel_clausuladoDelCPD;
            private String txt_observaciones;

            @SerializedName("DIALOG_BUSQUEDADECONVENIOS")
            private DialogBusquedaDeConvenios dialogBusquedaDeConvenios;

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeConvenios {
                private String in_nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nombre;
                    @SerializedName("Nombre")
                    private String table_nombre;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosEconomicos {

            private String sel_impuestosTipoPorcentage;
            private String in_diasFijosDePago1;
            private String in_diasFijosDePago2;
            private String in_nCtaCorrienteEtt;
            private String in_banco;
            private String sel_entidad;
            private String sel_sucursal;
            private String in_dc;
            private String in_nCuenta;
            private String in_datosIbanEtt;
            private String in_ibanPais;
            private String in_ibanExtrajero;

            @SerializedName("SECTION_DIRECCIONDEFACTURA")
            private SectionDireccionDeFactura sectionDireccionDeFactura;

            @SerializedName("SECTION_CONTACTO")
            private SectionContacto sectionContacto;


            @NoArgsConstructor
            @Getter
            public static class SectionDireccionDeFactura {
                private String sel_tipo;
                private String in_nombre;
                private String in_localidad;
                private String sel_provincia;
                private String in_cp;
                private String in_destinatario;
            }

            @NoArgsConstructor
            @Getter
            public static class SectionContacto {
                private String in_nif;
                private String in_nombre;
                private String in_apellidos1;
                private String in_apellidos2;
                private String in_cargo;
                private String in_telf1;
                private String in_telf2;
                private String in_email;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nombreYApellidos;
                    private String qbe_nIF;
                    private String qbe_cargo;
                    private String qbe_telefono;
                    private String qbe_fax;
                    private String qbe_eMail;
                    private String qbe_firmCPD;
                    private String qbe_firmPRL;
                    private String qbe_contactoPpal;
                    private String qbe_respPago;

                    @SerializedName("Nombre y Apellidos")
                    private String table_nombreYApellidos;
                    @SerializedName("NIF")
                    private String table_nIF;
                    @SerializedName("Cargo")
                    private String table_cargo;
                    @SerializedName("Teléfono")
                    private String table_telefono;
                    @SerializedName("Fax")
                    private String table_fax;
                    @SerializedName("E-Mail")
                    private String table_eMail;
                    @SerializedName("Firm. CPD")
                    private String table_firmCPD;
                    @SerializedName("Firm. PRL")
                    private String table_firmPRL;
                    @SerializedName("Contacto Ppal.")
                    private String table_contactoPpal;
                    @SerializedName("Resp. Pago")
                    private String table_respPago;
                }
            }

        }

        @NoArgsConstructor
        @Getter
        public static class TabCategoriaSeguridadSocial {
            private String lkp_categoriaLaboral;
            private String lkp_categoriaProfesional;
            private String sel_regimenDeLaSeguridadSocial;
            private String btn_fichaPRL;
            private String chk_prlPersonalizable;
            private String btn_anadirCategoria;

            @SerializedName("DIALOG_BUSQUEDADECATEGORIASLABORALES")
            private DialogBusquedaDeCategoriasLaborales dialogBusquedaDeCategoriasLaborales;
            @SerializedName("DIALOG_BUSQUEDADECATEGORIASPROFESIONALES")
            private DialogBusquedaDeCategoriasProfesionales dialogBusquedaDeCategoriasProfesionales;
            @SerializedName("DIALOG_FICHAPRLDELACATEGORIA")
            private DialogFichaPRLdeLaCategoria dialogFichaPRLdeLaCategoria;
            @SerializedName("TABLE_CATEGORIASPROFESIONALESLABORALESASOCIADASALAEMPRESA")
            private TableCategoriasProfesionalesLaboralesAsociadasALaEmpresa tableCategoriasProfesionalesLaboralesAsociadasALaEmpresa;
            @SerializedName("TABLE_REGIMENESASOCIADOSALAEMPRESA")
            private TableRegimenesAsociadosALaEmpresa tableRegimenesAsociadosALaEmpresa;


            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeCategoriasLaborales {
                private String in_nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_codigo;
                    private String qbe_categoriaLaboral;

                    @SerializedName("Código")
                    private String table_codigo;
                    @SerializedName("Categoria Laboral")
                    private String table_categoriaLaboral;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeCategoriasProfesionales {
                private String in_nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_codigo;
                    private String qbe_categoriaProfesional;

                    @SerializedName("Código")
                    private String table_codigo;
                    @SerializedName("Categoria Profesional")
                    private String table_categoriaProfesional;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class DialogFichaPRLdeLaCategoria {
                private String in_identificacionDelServicio;
                private String in_empresaUsuaria;
                private String in_nDeCliente;
                private String in_direccionDelCentroDeTrabajo;
                private String in_denominacionDelPuestoDeTrabajo;
                private String in_trabajador;
                private String in_nif;
                private String txt_caracteristicasDelPuestoDeTrabajoYTareasADesarrollar;
                private String txt_riesgosDelCentro;
                private String txt_riesgosDelPuestoDeTrabajoFichasDeDatosDeSeguridadFichasTecnicasDeEquiposDeTrabajoYMaquinaria;
                private String txt_medidasPreventivas;
                private String txt_equiposDeProteccion;
                private String txt_observaciones;
            }

            @NoArgsConstructor
            @Getter
            public static class TableCategoriasProfesionalesLaboralesAsociadasALaEmpresa {
                private String qbe_categoriaLaboral;
                private String qbe_categoriaProfesional;
                private String qbe_regimenesSegSocial;

                @SerializedName("Categoria Laboral")
                private String table_categoriaLaboral;
                @SerializedName("Categoria Profesional")
                private String table_categoriaProfesional;
                @SerializedName("Regimenes Seg. Social")
                private String table_regimenesSegSocial;
                @SerializedName("Ficha PRL")
                private String table_fichaPRL;
                private String table_btn_fichaPRL1;
                private String table_btn_fichaPRL2;
                @SerializedName("¿Personalizable?")
                private String table_personalizable;
                @SerializedName("Cursos PRL")
                private String table_cursosPRL;
                @SerializedName("¿Personalizable PRL?")
                private String table_personalizablePRL;
                //TODO falta algun campo de la tabla revisar...

                @SerializedName("DIALOG_FUNCIONES")
                private DialogFunciones dialogFunciones;

                @NoArgsConstructor
                @Getter
                public static class DialogFunciones {
                    private String in_nueva;
                    private String sel_funciones;
                }

            }

            @NoArgsConstructor
            @Getter
            public static class TableRegimenesAsociadosALaEmpresa{
                private String qbe_regimen;
                private String qbe_nSeguridadSocial;

                @SerializedName("Régimen")
                private String table_regimen;
                @SerializedName("Nº Seguridad Social")
                private String table_nSeguridadSocial;
            }

        }

        @NoArgsConstructor
        @Getter
        public static class TabRetratoRobot {
            private String sel_ventas;
            private String sel_nEmpleados;

            private String chk_porTiposDeHoras;
            private String chk_porCentrosDeTrabajo;
            private String chk_porCategoriaProfesional;
            private String chk_mostrarPrecioUnidad;
            private String chk_porColaborador;
            private String chk_colaboradorConcepto;
            private String chk_mostrarMinFinicioMaxFinPartes;
            private String chk_porDuracionDelContrato;
            private String chk_porDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo;
            private String chk_porNumeroDeColaboradores;
            private String in_numeroMaximoDeColaboradoresEnFactura;
            private String chk_porImporteGlobal;
            private String in_importeMaximoPorFacturaImporteCorrespondienteIncluido;
        }


        @NoArgsConstructor
        @Getter
        public static class TabTiposDeAlerta {
            private String chk_vencimientoPeriodoDePruebas;
            private String in_vencimientoPeriodoDePruebas;
            private String chk_finalizacionContratosEventualesPracticasOFD;
            private String in_finalizacionContratosEventualesPracticasOFD;
            private String chk_finalizacionDeContratosInternidad;
            private String in_finalizacionDeContratosInternidad;
            private String chk_finalizacionDeProrrogas;
            private String in_finalizacionDeProrrogas;
            private String chk_caducidadReconocomientoMedico;
            private String in_caducidadReconocimientoMedico;
            private String chk_caducidadPreventor;
            private String in_caducidadPreventor;
            private String chk_caducidadPermisoTrabajo;
            private String in_caducidadPermisoTrabajo;
        }
    }

}






