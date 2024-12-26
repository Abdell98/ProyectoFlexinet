package com.eulen.flexinet.core.test.selenium.reader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GestionCentrosDeTrabajoData {
    //String nIF;
    String razonSocial;
    String clienteContrato;
    String nombreEmpresa;
    String tipoVia;
    String nombreDireccion;
    String medioDeCaptacion;
    String convColectivoEmpresaUsuaria;
    String diasFijosDePago;
    String ventas;
    String nEmpleados;
    public GestionCentrosDeTrabajoData(
        //String nIF,
        String razonSocial,
        String clienteContrato,
        String nombreEmpresa,
        String tipoVia,
        String nombreDireccion,
        String medioDeCaptacion,
        String convColectivoEmpresaUsuaria,
        String diasFijosDePago,
        String ventas,
        String nEmpleados
    ) {
       //this.nIF = nIF;
        this.razonSocial = razonSocial;
        this.clienteContrato = clienteContrato;
        this.nombreEmpresa = nombreEmpresa;
        this.tipoVia = tipoVia;
        this.nombreDireccion = nombreDireccion;
        this.medioDeCaptacion = medioDeCaptacion;
        this.convColectivoEmpresaUsuaria = convColectivoEmpresaUsuaria;
        this.diasFijosDePago = diasFijosDePago;
        this.ventas = ventas;
        this.nEmpleados = nEmpleados;
    }
}
