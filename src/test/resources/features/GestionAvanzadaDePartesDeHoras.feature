Feature: gestion-avanzada-de-partes-de-horas

  #  Como Usuario
  #  Quiero modificar y traspasar un Contrato
  #  Para verificar que se guarda exitosamente

  #  Este escenario cubre los siguientes casos de prueba de TestLink:

  #  Flexinet-19932: Traspasar Contrato

  @GestionAvanzada @GestionAvanzadaDePartesDeHoras @BotonConsultas @BotonGuardarTraspasar @Flexinet-19932
  Scenario Outline: Traspasar Contrato
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    When el usuario rellena los datos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
    And el usuario hace click en buscar
    And el usuario rellena los datos de la tabla de partes de horas <scenario>,<pagina>,<fichero_datos>
    And el usuario selecciona el primer parte encontrado <scenario>,<pagina>,<fichero_datos>
    And el usuario hace click en el botón Modificar <scenario>,<pagina>,<fichero_datos>
    And el usuario modifica los datos del parte <scenario>,<pagina>,<fichero_datos>
    And el usuario presiona boton guardar y traspasar
    Then se muestra mensaje de exito parte modificado y traspasado

    Examples:
      |     scenario   |                          pagina                        |                                              fichero_datos                                                   |     oficina    |
      | Flexinet-19932 | GESTION_AVANZADA__CONSULTA_AVANZADA_DE_PARTES_DE_HORAS |  GESTION_AVANZADA__CONSULTA_AVANZADA_DE_PARTES_DE_HORAS/Flexinet-19932/ConsultaAvanzadaDePartesDeHoras.json  | 442-FLX-GETAFE |