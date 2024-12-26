Feature: informe-digital-para-cierre-de-nomina

  @GestionDeInformes @InformeDeContratacionYPersonal @InformeDigitalParaCierreDeNomina @FlujoCompleto @Flexinet-19829 @Flexinet-19830 @Flexinet-19831

  #  Como Usuario
  #  Quiero realizar el flujo completo de la pagina Informe Digital Para Cierre de Nominas
  #  Para verificar el correcto funcionamiento de sus opciones

  #  Este escenario cubre los siguientes casos de prueba de TestLink:

  #  Flexinet-19829:Botón Presentar Informe
  #  Flexinet-19830:Botón + del Grid
  #  Flexinet-19831:Botón Eliminar

  #  Nota: El valor de la nomina debe ser 1,00 debido a que los valores altos generan error
  #  Nota: Este escenario debe ejecutarse obligatoriamente de forma completa de lo contrario el dato no padra ser usado nuevamente

    @GestionInformes @Flujo80
  Scenario Outline: Flujo completo de la pagina Informe Digital Para Cierre de Nominas
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    When el usuario rellena formulario de consulta pag. Informe Digital Para Cierre de Nominas <scenario>,<pagina>,<fichero_datos>
    #caso de prueba "Flexinet-19829:Botón Presentar Informe"
    And el usuario hace click en el boton presentar informe <scenario>,<pagina>,<fichero_datos>
    And el usuario hace click en el boton si <scenario>,<pagina>,<fichero_datos>
    And el usuario ingresa los datos de la tabla de informes <scenario>,<pagina>,<fichero_datos>
    And el usuario selecciona la primera fila de la tabla de informes <scenario>,<pagina>,<fichero_datos>
    #caso de prueba "Flexinet-19830:Botón + del Grid"
    And el usuario hace click en boton detalle del colaborador
    And el usuario ingresa los datos de la pagina detalle del colaborador <scenario>,<pagina>,<fichero_datos>
    And el usuario elimina concepto de la tabla de conceptos <scenario>,<pagina>,<fichero_datos>
    And el usuario hace click en boton cerrar aviso
    And el usuario activa check <scenario>,<pagina>,<fichero_datos>
    And el usuario hace click en el boton guardar <scenario>,<pagina>,<fichero_datos>
    And el usuario hace click en el boton grabar <scenario>,<pagina>,<fichero_datos>
    And el usuario hace click en boton cerrar aviso
    And el usuario hace click en boton detalle del colaborador
    #caso de prueba "Flexinet-19831:Botón Eliminar"
    And el usuario hace click en boton eliminar linea <scenario>,<pagina>,<fichero_datos>
    And el usuario hace click en el boton grabar <scenario>,<pagina>,<fichero_datos>
    Then se muestra mensaje de exito

    Examples:
      |     scenario   |                                          pagina                                                |                                                                     fichero_datos                                                                  |     oficina    |
      |   AllElements  | GESTION_DE_INFORMES__INFORME_DE_CONTRATACION_Y_PERSONAL__INFORME_DIGITAL_PARA_CIERRE_DE_NOMINA |  GESTION_DE_INFORMES__INFORME_DE_CONTRATACION_Y_PERSONAL__INFORME_DIGITAL_PARA_CIERRE_DE_NOMINA/AllElements/InformeDigitalParaCierreDeNomina.json  | 451-FLX-TOLEDO |

