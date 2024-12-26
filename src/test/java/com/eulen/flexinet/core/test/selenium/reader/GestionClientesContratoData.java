package com.eulen.flexinet.core.test.selenium.reader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GestionClientesContratoData {
    /** Cabecera **/
    String nIF;
    String razonSocial;
    String clienteNacional;
    String numeroCliente;
    String limiteDeRiesgo;
    String margenBruto;
    String medioDePago;
    String formaDePago;
    String siglas;
    String actividad;
    String cNAE;
    String sIC;
    String responsableDeCuenta;
    String estado;
    String oficinaOrigenContacto;
    String paginaWeb;
    String domicilioSocial;
    String codigoPostalDomicilioSocial;
    String provinciaDomicilioSocial;
    String domicilioFiscal;
    String codigoPostalDomicilioFiscal;
    String provinciaDomicilioFiscal;
    /** Otros Datos Identificativos **/
    String ejecutivoDeCuenta;
    String medioDeCapt;
    String convenio;
    String bOE;
    String telefono;
    String clausuladoDelContratoLaboral;
    String clausuladoDelCPD;
    String observaciones;
    public GestionClientesContratoData(
        /** Cabecera **/
        String nIF,
        String razonSocial,
        String clienteNacional,
        String numeroCliente,
        String limiteDeRiesgo,
        String margenBruto,
        String medioDePago,
        String formaDePago,
        String siglas,
        String actividad,
        String cNAE,
        String sIC,
        String responsableDeCuenta,
        String estado,
        String oficinaOrigenContacto,
        String paginaWeb,
        String domicilioSocial,
        String codigoPostalDomicilioSocial,
        String provinciaDomicilioSocial,
        String domicilioFiscal,
        String codigoPostalDomicilioFiscal,
        String provinciaDomicilioFiscal,
        /** Otros Datos Identificativos **/
        String ejecutivoDeCuenta,
        String medioDeCapt,
        String convenio,
        String bOE,
        String telefono,
        String clausuladoDelContratoLaboral,
        String clausuladoDelCPD,
        String observaciones
    ) {
        /** Cabecera **/
        this.nIF = nIF;
        this.razonSocial = razonSocial;
        this.clienteNacional = clienteNacional;
        this.numeroCliente = numeroCliente;
        this.limiteDeRiesgo = limiteDeRiesgo;
        this.margenBruto = margenBruto;
        this.medioDePago = medioDePago;
        this.formaDePago = formaDePago;
        this.siglas = siglas;
        this.actividad = actividad;
        this.cNAE = cNAE;
        this.sIC = sIC;
        this.responsableDeCuenta = responsableDeCuenta;
        this.estado = estado;
        this.oficinaOrigenContacto = oficinaOrigenContacto;
        this.paginaWeb = paginaWeb;
        this.domicilioSocial = domicilioSocial;
        this.codigoPostalDomicilioSocial = codigoPostalDomicilioSocial;
        this.provinciaDomicilioSocial = provinciaDomicilioSocial;
        this.domicilioFiscal = domicilioFiscal;
        this.codigoPostalDomicilioFiscal = codigoPostalDomicilioFiscal;
        this.provinciaDomicilioFiscal = provinciaDomicilioFiscal;
        this.ejecutivoDeCuenta = ejecutivoDeCuenta;
        /** Otros Datos Identificativos **/
        this.medioDeCapt = medioDeCapt;
        this.convenio = convenio;
        this.bOE = bOE;
        this.telefono = telefono;
        this.clausuladoDelContratoLaboral = clausuladoDelContratoLaboral;
        this.clausuladoDelCPD = clausuladoDelCPD;
        this.observaciones = observaciones;
    }
}
