package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosGestionDeEmpresaCliente {

    @SerializedName("GESTION_EMPRESAS_CLIENTE__ALTA")
    private GestionDeEmpresaClienteAlta gestionDeEmpresaClienteAlta;

    @SerializedName("GESTION_EMPRESAS_CLIENTE__CONSULTA")
    private GestionDeEmpresaClienteConsulta gestionDeEmpresaClienteConsulta;

    @SerializedName("GESTION_EMPRESAS_CLIENTE__MODIFICAR")
    private GestionDeEmpresaClienteModificar gestionDeEmpresaClienteModificar;

    @NoArgsConstructor
    @Getter
    public static class GestionDeEmpresaClienteAlta {
        @SerializedName("TAB_DATOSRIESGOS")
        private TabDatosRiesgos tabDatosRiesgos;

        @SerializedName("TAB_IDENTIFICATIVOS")
        private TabIdentificativos tabIdentificativos;

        @SerializedName("TAB_DATOSECONOMICOS")
        private TabDatosEconomicos tabDatosEconomicos;

        @SerializedName("TAB_CATEGORIASEGURIDADSOCIAL")
        private TabCategoriaSeguridadSocial tabCategoriaSeguridadSocial;

        @SerializedName("TAB_RETRATOROBOT")
        private TabRetratoRobot tabRetratoRobot;

        @NoArgsConstructor
        @Getter
        public static class TabDatosRiesgos {
            private String lkp_cif;
            private String estado;
            private String razonSocial;
            private String razonSocialFactura;
            private String margenBruto;
            private String limiteRiesgo;
            private String medioDePago;
            private String formaDePago;

            @SerializedName("DIALOG_SELECCIONEEMPRESA") //TODO: @PRE puede que en uat sea distinto
            private DialogSeleccioneEmpresa dialogSeleccioneEmpresa;

            @NoArgsConstructor
            @Getter
            public static class DialogSeleccioneEmpresa {
                private String razonSocial;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nombreEmpresa;
                    private String qbe_direccion;
                    private String qbe_provincia;
                    private String qbe_nifEmpresa;
                    private String qbe_cnae;
                    private String qbe_responsable;

                    @SerializedName("Nombre Empresa")
                    private String nombreEmpresa;
                    @SerializedName("Dirección")
                    private String direccion;
                    @SerializedName("Provincia")
                    private String provincia;
                    @SerializedName("NIF Empresa")
                    private String nifEmpresa;
                    @SerializedName("C.N.A.E.")
                    private String cnae;
                    @SerializedName("Responsable")
                    private String responsable;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabIdentificativos {
            private String siglas;
            private String chk_clientesNacional;
            private String chk_facturaGlobalizada;
            private String chk_envioCPD;
            private String chk_envioFacturaDigital;
            private String chk_rappel_Checkbox;
            private String rappel_input;
            private String tipo_DomicilioSocial;
            private String direccion_DomicilioSocial;
            private String localidad_DomicilioSocial;
            private String provincia_DomicilioSocial;
            private String cP_DomicilioSocial;
            private String tipo_DomicilioFiscal;
            private String direccion_DomicilioFiscal;
            private String localidad_DomicilioFiscal;
            private String provincia_DomicilioFiscal;
            private String cP_DomicilioFiscal;
            private String bOE;
            private String medioDeCapt;
            private String oficinaOrigenDelContrato1;
            private String oficinaOrigenDelContrato2;
            private String respDeCuenta;
            private String telefono;
            private String paginaWeb;
            private String observaciones;
            private String lkp_convColectivoEmpresaUsuaria;

            @SerializedName("DIALOG_BUSQUEDADECONVENIOS")
            private DialogBusquedaDeConvenios dialogBusquedaDeConvenios;

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeConvenios {
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nombre;
                    @SerializedName("Nombre")
                    private String nombre;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosEconomicos {
            private String impuestosTipoPorcentaje;
            private String diasFijosDePago1;
            private String diasFijosDePago2;
            private String numeroDeCliente;
            private String banco;
            private String entidad;
            private String sucursal;
            private String dC;
            private String nCuenta;
            private String iBANPais;
            private String iBANDC;
            private String iBANExtranjero;
            private String chk_personalizable;
            private String tipo;
            private String nombre_DireccionFactura;
            private String localidad;
            private String provincia;
            private String cP;
            private String destinatario;
            private String clausuladoDelContratoLaboral;
            private String clausuladoDelCPD;
            private String contacto;
            private String nIF;
            private String nombre_Contacto;
            private String apellidos1;
            private String apellidos2;
            private String cargo;
            private String telf1;
            private String telf2;
            private String email;
            private String chk_firmanteCPDPRLPersonalizable;
            private String btn_anadirContacto;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {

                private String qbe_nombreYApellidos;
                private String qbe_nif;
                private String qbe_cargo;
                private String qbe_telefono;
                private String qbe_fax;
                private String qbe_email;

                @SerializedName("Nombre y Apellidos")
                private String table_nombreYApellidos;
                @SerializedName("NIF")
                private String table_nif;
                @SerializedName("Cargo")
                private String table_cargo;
                @SerializedName("Teléfono")
                private String table_telefono;
                @SerializedName("Fax")
                private String table_fax;
                @SerializedName("E-mail")
                private String table_email;
                @SerializedName("Firm. CPD")
                private String table_chk_firmcpd;
                @SerializedName("Firm. PRL")
                private String table_chk_firmprl;
                @SerializedName("Contato Ppal.")
                private String table_chk_contactoppal;
                @SerializedName("Resp. Pago")
                private String table_chk_resppago;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabCategoriaSeguridadSocial {
            private String lkp_categoriaLaboral;
            private String regimenDeLaSegSocial;
            private String lkp_categoriaProfesional;
            private String chk_prlPersonalizable;
            private String btn_anadirCategoria;

            @SerializedName("DIALOG_BUSQUEDADECATEGORIASLABORALES")
            private DialogBusquedasDeCategoriasLaborales dialogBusquedasDeCategoriasLaborales;

            @SerializedName("DIALOG_BUSQUEDADECATEGORIASPROFESIONALES")
            private DialogBusquedasDeCategoriasProfesionales dialogBusquedasDeCategoriasProfesionales;

            @SerializedName("DIALOG_FICHAPRLDELACATEGORIA")
            private DialogFichaPRLDeLaCategoria dialogFichaPRLDeLaCategoria;

            @SerializedName("TABLE")
            private GestionDeEmpresaClienteModificar.TabCategoriaSeguridadSocial.Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_categoriaLaboral;
                private String qbe_categoriaProfesional;
                private String qbe_regimenesSegSocial;
                private String qbe_fichaPrl;
                private String qbe_personalizable;
                private String qbe_cursosPrl;
                private String qbe_personalizablePrl;
                private String qbe_recMedico;

                @SerializedName("Categoría Laboral")
                private String table_categoriaLaboral;
                @SerializedName("Categoría Profesional")
                private String table_categoriaProfesional;
                @SerializedName("Regímenes Seg. Social")
                private String table_regimenesSegSocial;
                @SerializedName("Ficha PRL")
                private String table_fichaPrl;
                @SerializedName("¿Personalizable?")
                private String table_personalizable;
                @SerializedName("Cursos PRL")
                private String table_cursosPrl;
                @SerializedName("¿Personalizable PRL?")
                private String table_personalizablePrl;
                @SerializedName("Rec. Médico")
                private String table_recMedico;
            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedasDeCategoriasLaborales {
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {

                    private String qbe_codigo;
                    private String qbe_categoriaLaboral;

                    @SerializedName("Código")
                    private String codigo;
                    @SerializedName("Categoría Laboral")
                    private String categoriaLaboral;
                }

            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedasDeCategoriasProfesionales {
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_codigo;
                    private String qbe_categoriaProfesional;

                    @SerializedName("Código")
                    private String codigo;
                    @SerializedName("Categoría Profesional")
                    private String categoriaProfesional;
                }

            }

            @NoArgsConstructor
            @Getter
            public static class DialogFichaPRLDeLaCategoria {
                private String caracteristicasDelPuestoDeTrabajoYTareasADesarrollar;
                private String riesgosDelCentro;
                private String riesgosDelPuestoDeTrabajoFichasDeDatosDeSeguridadFichasTecnicasDeEquiposDeTrabajoYMaquinaria;
                private String medidasPreventivas;
                private String equiposDeProteccion;
                private String Observaciones;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabRetratoRobot {
            private String lkp_actividad;
            private String lkp_cNAE;
            private String lkp_sIC;
            private String ventas;
            private String nEmpleados;
            private String chk_porTiposDeHoras;
            private String chk_facturaGlobalizada;
            private String chk_porCentrosDeTrabajo;
            private String chk_porCategoriaProfesional;
            private String chk_mostrarPrecioUnidad;
            private String chk_porColaborador;
            private String chk_colaboradorConcepto;
            private String chk_mostrarMinFInicioMaxFFinPartes;
            private String chk_porDuracionDelContrato5Dias5Dias;
            private String chk_porDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo;
            private String chk_porNumeroDeColaboradores;
            private String numeroMaximoDeColaboradoresEnFactura;
            private String chk_porImporteGlobal;
            private String importeMaximoPorFacturaImporteCorrespondienteIncluido;
            private String chk_elTipoDeFacturacionEsPersonalizable;

            @SerializedName("DIALOG_BUSQUEDADEACTIVIDAD")
            private DialogBusquedaDeActividad dialogBusquedaDeActividad;

            @SerializedName("DIALOG_BUSQUEDADECNAE")
            private DialogBusquedaDeCNAE dialogBusquedaDeCNAE;

            @SerializedName("DIALOG_BUSQUEDADESIC")
            private DialogBusquedaDeSIC dialogBusquedaDeSIC;

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeActividad {
                private String id;
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_idActividad;
                    private String qbe_actividad;
                    @SerializedName("ID Actividad")
                    private String idActividad;
                    @SerializedName("Actividad")
                    private String actividad;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeCNAE {
                private String id;
                private String nombre;
                private String grupo;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_idCnae;
                    private String qbe_cnae;
                    @SerializedName("ID CNAE")
                    private String idCnae;
                    @SerializedName("CNAE")
                    private String cnae;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeSIC {
                private String id;
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_idSic;
                    private String qbe_sic;
                    @SerializedName("ID SIC")
                    private String idSic;
                    @SerializedName("SIC")
                    private String sic;
                }
            }
        }
    }

    @NoArgsConstructor
    @Getter
    public static class GestionDeEmpresaClienteConsulta {
        private String razonSocialEmpresa;
        private String nIFempresa;
        private String ventas;
        private String provincia;
        private String rangoDeEmpleados;
        private String codigoPostal;
        private String chk_LaEmpresaProvieneDeMarketing;
        private String date_Desde;
        private String date_Hasta;
        private String radio_realizarBusquedaANivelNacional_si;
        private String radio_realizarBusquedaANivelNacional_no;

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            private String qbe_nombreEmpresa;
            private String qbe_nIFEmpresa;
            private String qbe_direccion;
            private String qbe_provincia;
            private String qbe_cP;
            private String qbe_nombreContacto;
            private String qbe_cargoContacto;
            private String qbe_telefonoContacto;
            private String qbe_cNAE;
            private String qbe_ventas;
            private String qbe_rangoEmpleados;
            private String qbe_responsable;
            private String qbe_nombreOficina;

            @SerializedName("Nombre Empresa")
            private String table_nombreEmpresa;
            @SerializedName("NIF Empresa")
            private String table_nIFEmpresa;
            @SerializedName("Dirección")
            private String table_direccion;
            @SerializedName("Provincia")
            private String table_provincia;
            @SerializedName("CP")
            private String table_cP;
            @SerializedName("Nombre Contacto")
            private String table_nombreContacto;
            @SerializedName("Cargo Contacto")
            private String table_cargoContacto;
            @SerializedName("Teléfono Contacto")
            private String table_telefonoContacto;
            @SerializedName("C.N.A.E.")
            private String table_cNAE;
            @SerializedName("Ventas")
            private String table_ventas;
            @SerializedName("Rango Empleados")
            private String table_rangoEmpleados;
            @SerializedName("Responsable")
            private String table_responsable;
            @SerializedName("Nombre Oficina")
            private String table_nombreOficina;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class GestionDeEmpresaClienteModificar {
        @SerializedName("TAB_DATOSRIESGOS")
        private TabDatosRiesgos tabDatosRiesgos;

        @SerializedName("TAB_IDENTIFICATIVOS")
        private TabIdentificativos tabIdentificativos;

        @SerializedName("TAB_DATOSECONOMICOS")
        private TabDatosEconomicos tabDatosEconomicos;

        @SerializedName("TAB_CATEGORIASEGURIDADSOCIAL")
        private TabCategoriaSeguridadSocial tabCategoriaSeguridadSocial;

        @SerializedName("TAB_RETRATOROBOT")
        private TabRetratoRobot tabRetratoRobot;

        @NoArgsConstructor
        @Getter
        public static class TabDatosRiesgos {
            private String lkp_cif;
            private String estado;
            private String razonSocial;
            private String razonSocialFactura;
            private String margenBruto;
            private String limiteRiesgo;
            private String medioDePago;
            private String formaDePago;

            @SerializedName("DIALOG_SELECCIONEEMPRESA") //TODO: @PRE puede que en uat sea distinto
            private DialogSeleccioneEmpresa dialogSeleccioneEmpresa;

            @NoArgsConstructor
            @Getter
            public static class DialogSeleccioneEmpresa {
                private String razonSocial;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nombreEmpresa;
                    private String qbe_direccion;
                    private String qbe_provincia;
                    private String qbe_nifEmpresa;
                    private String qbe_cnae;
                    private String qbe_responsable;

                    @SerializedName("Nombre Empresa")
                    private String nombreEmpresa;
                    @SerializedName("Dirección")
                    private String direccion;
                    @SerializedName("Provincia")
                    private String provincia;
                    @SerializedName("NIF Empresa")
                    private String nifEmpresa;
                    @SerializedName("C.N.A.E.")
                    private String cnae;
                    @SerializedName("Responsable")
                    private String responsable;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabIdentificativos {
            private String siglas;
            private String chk_clientesNacional;
            private String chk_facturaGlobalizada;
            private String chk_envioCPD;
            private String chk_envioFacturaDigital;
            private String chk_rappel_Checkbox;
            private String rappel_input;
            private String tipo_DomicilioSocial;
            private String direccion_DomicilioSocial;
            private String localidad_DomicilioSocial;
            private String provincia_DomicilioSocial;
            private String cP_DomicilioSocial;
            private String tipo_DomicilioFiscal;
            private String direccion_DomicilioFiscal;
            private String localidad_DomicilioFiscal;
            private String provincia_DomicilioFiscal;
            private String cP_DomicilioFiscal;
            private String bOE;
            private String medioDeCapt;
            private String oficinaOrigenDelContrato1;
            private String oficinaOrigenDelContrato2;
            private String respDeCuenta;
            private String telefono;
            private String paginaWeb;
            private String observaciones;
            private String lkp_convColectivoEmpresaUsuaria;

            @SerializedName("DIALOG_BUSQUEDADECONVENIOS")
            private DialogBusquedaDeConvenios dialogBusquedaDeConvenios;

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeConvenios {
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_nombre;

                    @SerializedName("Nombre")
                    private String nombre;
                }
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabDatosEconomicos {
            private String impuestosTipoPorcentaje;
            private String diasFijosDePago1;
            private String diasFijosDePago2;
            private String numeroDeCliente;
            private String banco;
            private String entidad;
            private String sucursal;
            private String dC;
            private String nCuenta;
            private String iBANPais;
            private String iBANDC;
            private String iBANExtranjero;
            private String chk_personalizable;
            private String tipo;
            private String nombre_DireccionFactura;
            private String localidad;
            private String provincia;
            private String cP;
            private String destinatario;
            private String clausuladoDelContratoLaboral;
            private String clausuladoDelCPD;
            private String contacto;
            private String nIF;
            private String nombre_Contacto;
            private String apellidos1;
            private String apellidos2;
            private String cargo;
            private String telf1;
            private String telf2;
            private String email;
            private String chk_firmanteCPDPRLPersonalizable;
            private String btn_anadirContacto;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {

                private String qbe_nombreYApellidos;
                private String qbe_nif;
                private String qbe_cargo;
                private String qbe_telefono;
                private String qbe_fax;
                private String qbe_email;

                @SerializedName("Nombre y Apellidos")
                private String table_nombreYApellidos;
                @SerializedName("NIF")
                private String table_nif;
                @SerializedName("Cargo")
                private String table_cargo;
                @SerializedName("Teléfono")
                private String table_telefono;
                @SerializedName("Fax")
                private String table_fax;
                @SerializedName("E-mail")
                private String table_email;
                @SerializedName("Firm. CPD")
                private String table_chk_firmcpd;
                @SerializedName("Firm. PRL")
                private String table_chk_firmprl;
                @SerializedName("Contato Ppal.")
                private String table_chk_contactoppal;
                @SerializedName("Resp. Pago")
                private String table_chk_resppago;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabCategoriaSeguridadSocial {
            private String lkp_categoriaLaboral;
            private String regimenDeLaSegSocial;
            private String lkp_categoriaProfesional;
            private String chk_prlPersonalizable;
            private String btn_anadirCategoria;

            @SerializedName("DIALOG_BUSQUEDADECATEGORIASLABORALES")
            private DialogBusquedasDeCategoriasLaborales dialogBusquedasDeCategoriasLaborales;

            @SerializedName("DIALOG_BUSQUEDADECATEGORIASPROFESIONALES")
            private DialogBusquedasDeCategoriasProfesionales dialogBusquedasDeCategoriasProfesionales;

            @SerializedName("DIALOG_FICHAPRLDELACATEGORIA")
            private DialogFichaPRLDeLaCategoria dialogFichaPRLDeLaCategoria;

            @SerializedName("TABLE")
            private Table table;

            @NoArgsConstructor
            @Getter
            public static class Table {
                private String qbe_categoriaLaboral;
                private String qbe_categoriaProfesional;
                private String qbe_regimenesSegSocial;
                private String qbe_fichaPrl;
                private String qbe_personalizable;
                private String qbe_cursosPrl;
                private String qbe_personalizablePrl;
                private String qbe_recMedico;

                @SerializedName("Categoría Laboral")
                private String table_categoriaLaboral;
                @SerializedName("Categoría Profesional")
                private String table_categoriaProfesional;
                @SerializedName("Regímenes Seg. Social")
                private String table_regimenesSegSocial;
                @SerializedName("Ficha PRL")
                private String table_fichaPrl;
                @SerializedName("¿Personalizable?")
                private String table_personalizable;
                @SerializedName("Cursos PRL")
                private String table_cursosPrl;
                @SerializedName("¿Personalizable PRL?")
                private String table_personalizablePrl;
                @SerializedName("Rec. Médico")
                private String table_recMedico;
            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedasDeCategoriasLaborales {
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {

                    private String qbe_codigo;
                    private String qbe_categoriaLaboral;

                    @SerializedName("Código")
                    private String codigo;
                    @SerializedName("Categoría Laboral")
                    private String categoriaLaboral;
                }

            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedasDeCategoriasProfesionales {
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_codigo;
                    private String qbe_categoriaProfesional;

                    @SerializedName("Código")
                    private String codigo;
                    @SerializedName("Categoría Profesional")
                    private String categoriaProfesional;
                }

            }

            @NoArgsConstructor
            @Getter
            public static class DialogFichaPRLDeLaCategoria {
                private String caracteristicasDelPuestoDeTrabajoYTareasADesarrollar;
                private String riesgosDelCentro;
                private String riesgosDelPuestoDeTrabajoFichasDeDatosDeSeguridadFichasTecnicasDeEquiposDeTrabajoYMaquinaria;
                private String medidasPreventivas;
                private String equiposDeProteccion;
                private String Observaciones;
            }
        }

        @NoArgsConstructor
        @Getter
        public static class TabRetratoRobot {
            private String lkp_actividad;
            private String lkp_cNAE;
            private String lkp_sIC;
            private String ventas;
            private String nEmpleados;
            private String chk_porTiposDeHoras;
            private String chk_facturaGlobalizada;
            private String chk_porCentrosDeTrabajo;
            private String chk_porCategoriaProfesional;
            private String chk_mostrarPrecioUnidad;
            private String chk_porColaborador;
            private String chk_colaboradorConcepto;
            private String chk_mostrarMinFInicioMaxFFinPartes;
            private String chk_porDuracionDelContrato5Dias5Dias;
            private String chk_porDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo;
            private String chk_porNumeroDeColaboradores;
            private String numeroMaximoDeColaboradoresEnFactura;
            private String chk_porImporteGlobal;
            private String importeMaximoPorFacturaImporteCorrespondienteIncluido;
            private String chk_elTipoDeFacturacionEsPersonalizable;

            @SerializedName("DIALOG_BUSQUEDADEACTIVIDAD")
            private DialogBusquedaDeActividad dialogBusquedaDeActividad;

            @SerializedName("DIALOG_BUSQUEDADECNAE")
            private DialogBusquedaDeCNAE dialogBusquedaDeCNAE;

            @SerializedName("DIALOG_BUSQUEDADESIC")
            private DialogBusquedaDeSIC dialogBusquedaDeSIC;

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeActividad {
                private String id;
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_idActividad;
                    private String qbe_actividad;

                    @SerializedName("ID Actividad")
                    private String idActividad;
                    @SerializedName("Actividad")
                    private String actividad;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeCNAE {
                private String id;
                private String nombre;
                private String grupo;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_idCnae;
                    private String qbe_cnae;

                    @SerializedName("ID CNAE")
                    private String idCnae;
                    @SerializedName("CNAE")
                    private String cnae;
                }
            }

            @NoArgsConstructor
            @Getter
            public static class DialogBusquedaDeSIC {
                private String id;
                private String nombre;

                @SerializedName("TABLE")
                private Table table;

                @NoArgsConstructor
                @Getter
                public static class Table {
                    private String qbe_idSic;
                    private String qbe_sic;

                    @SerializedName("ID SIC")
                    private String idSic;
                    @SerializedName("SIC")
                    private String sic;
                }
            }
        }
    }


}
