package com.eulen.flexinet.core.test.selenium.Locators;

public enum PanelTitle {
    TAB_DATOSRIESGOS("Datos Riesgos"),
    CABECERA("Cabecera"),
    TAB_IDENTIFICATIVOS("Identificativos"),
    TAB_OTROSDATOSIDENTIFICATIVOS("Otros Datos Identificativos"),
    TAB_DATOSECONOMICOS("Datos Económicos"),
    TAB_CATEGORIASEGURIDADSOCIAL("Categoría / Seguridad Social"),
    TAB_RETRATOROBOT("Retrato Robot"),
    TIPOSDEALERTA("Tipos de Alerta"),
    DESGLOSEDECATEGORIAPROFESIONAL("Desglose de Categoría Profesional"),
    TAB_DATOSDELPEDIDO("Datos del Pedido"),
    TAB_DATOSDEJORNADA("Datos de Jornada"),
    TAB_DATOSDETARIFA("Datos de Tarifa"),
    TAB_DATOSDECOLABORADORES("Datos de Colaboradores"),
    TAB_PARTEDEHORAS("Parte de Horas"),
    TAB_CONCEPTOSIT("Conceptos IT"),
    TAB_CONCEPTOSCOLABORADOR("Conceptos Colaborador"),
    TAB_ABSENTISMOFALTAS("Absentismo / Faltas"),

    /** TITULO DE DIALOGOS FLOTANTES **/
    DIALOG_ALTADEIT("Alta de IT"),
    DIALOG_BORRADODEPARTE("Borrado de Parte"),
    DIALOG_CONFIRMACIONDEOPERACION("Confirmación de Operación"),
    DIALOG_DETALLEDELCOLABORADOR("Detalle del Colaborador:"),
    DIALOG_LISTADODECONCEPTOS("Listado de Conceptos"),
    DIALOG_SELECCIONDEEEMPRESA("Selección de Empresa"),
    DIALOG_SELECCIONEEMPRESA("Seleccione Empresa"), // TODO: @PRE en pre parece que el dialogo es distinto
    DIALOG_SELECCIONDECOLABORADORES("Selección de Colaboradores"),
    DIALOG_PERFILDATOUNICO("Perfil Dato Único"),
    DIALOG_ESTADODEPEDIDO("Estado del Pedido"),
    DIALOG_PEDIDOCORRECTO("Correcto"),
    DIALOG_INFORMACION("Información"),
    DIALOG_DESBLOQUEODEPEDIDOS("Desbloqueo de Pedidos"),
    DIALOG_BUSQUEDADEEMPRESAS("Búsqueda de Empresas"),
    DIALOG_MODIFICACIONDEHORASEXTRA("Modificación de Horas Extra"),
    DIALOG_MODIFICACIONDEHORASFESTIVA("Modificación de Horas Festiva"),
    DIALOG_BUSQUEDADECONVENIOS("Búsqueda de Convenios"),
    DIALOG_BUSQUEDADECATEGORIASLABORALES("Búsqueda de Categorías Laborales"),
    DIALOG_BUSQUEDADECATEGORIASPROFESIONALES("Búsqueda de Categorías Profesionales"),
    DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO("Solicitud de Fecha de Alta del Contrato"),
    DIALOG_ACTIVIDAD("Búsqueda de Actividad"),
    DIALOG_CNAE("Búsqueda de CNAE"),
    DIALOG_SIC("Búsqueda de SIC"),
    DIALOG_HISTORICODETRASPASOSAORACLE("Hístorico de traspasos a Oracle"),
    DIALOG_CONFIRMARTRASPASOCONTRATO("Confirmar Traspaso Contrato"),
    DIALOG_TRASPASOCONTRATOERP("Traspaso contrato a ERP"),
    DIALOG_TRASPASO_MASIVO_ALTAS_CONTRATO("Traspaso Masivo de Altas de Contratos"),
    DIALOG_FECHAENVIOCPDS_PRORROGAS("Fecha de Envío CPDS / Prórrogas"),
    DIALOG_DETALLEMENSAJETRASPASOMASIVOALTA("Detalle de Mensajes de Traspaso Masivo de Altas"),
    DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR("Documentos Listos para Imprimir"),
    DIALOG_GRABADODEPEDIDO("Grabado de Pedido"),
    DIALOG_MOTIVOBAJA("Dar de Baja"),
    DIALOG_ALTANOVACION("Alta Novación"),
    DIALOG_ALTASUSTITUCION("Alta de Sustitución"),
    DIALOG_INFORMACIONRESULTADO("Información de los Resultados"),
    DIALOG_GENERARINCIDENCIACONTRATO("Generador Automático de Incidencias de Contratación"),
    DIALOG_DETALLEBAJAMASIVACONTRATO("Detalle Baja Masiva de Contrato"),
    DIALOG_BAJADECONTRATO("Baja de Contratos"),
    DIALOG_BAJACONTRATO("Baja de Contrato"),
    DIALOG_CREACIONPRORROGA("Creación de Prórroga"),
    DIALOG_ANULACIONDECONTRATO("Anulación de Contrato"),
    DIALOG_ANULACIONBAJA("Anulación Baja"),
    DIALOG_INFORMEDIGITALPARACIERREDENOMINAS("Informe Digital para Cierre de Nóminas"),
    DIALOG_ALTACOLABORADORCONCEPTONOMINA("Alta Concepto Colaborador (Nómina)"),
    DIALOG_ELIMINACIONDEPEDIDO("Eliminación de Pedido"),
    CURRENTPAGE("null");

    private final String codigo;

    PanelTitle(String codigo) {
        this.codigo = codigo;
    }

    public String getValue() {
        return codigo;
    }
}
