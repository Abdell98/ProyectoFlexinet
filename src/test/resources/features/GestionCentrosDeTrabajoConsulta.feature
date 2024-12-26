Feature: gestion-centros-de-trabajo-consulta

  @GestionCentrosDeTrabajo @Consulta @ModificarCentroDeTrabajoEnvioKO
  Scenario Outline: El objetivo de este escenario es comprobar que se muestra un error al intentar guardar modificaciones en un centro cuyo cliente que no está dado de alta en el erp
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa por su razón social <scenario>,<pagina>,<fichero_datos>
    And la selecciona y hace click en la fila correspondiente del resultado de la tabla <scenario>,<pagina>,<fichero_datos>
    And selecciona el cliente contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón Buscar
    And selecciona un resultado de la tabla <scenario>,<pagina>,<fichero_datos>
    And hace click en Modificar Centro de Trabajo
    When aparecen las pestañas de gestion accede a ellas y modifica algunos campos <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón Guardar
    Then aparece un mensaje de error indicando que los cambios no han sido enviados al erp <scenario>,<pagina>,<fichero_datos>
    And finalmente se comprueba que NO se ha modificado la información del cliente contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado KO <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario        | pagina                             | fichero_datos                  | oficina           |
      | ModificarCentroDeTrabajoEnvioKO | GESTION_CENTROS_DE_TRABAJO__CONSULTA | GestionCentrosDeTrabajoConsulta | 421-FLX-SEGOVIA |

  @GestionCentrosDeTrabajo @Consulta @ModificarCentroDeTrabajoEnvioOK
  Scenario Outline: El objetivo de este escenario es comprobar que al modificar un centro de trabajo valido se envia al erp y se guardan los cambios
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa por su razón social <scenario>,<pagina>,<fichero_datos>
    And la selecciona y hace click en la fila correspondiente del resultado de la tabla <scenario>,<pagina>,<fichero_datos>
    And selecciona el cliente contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón Buscar
    And selecciona un resultado de la tabla <scenario>,<pagina>,<fichero_datos>
    And hace click en Modificar Centro de Trabajo
    When aparecen las pestañas de gestion accede a ellas y modifica algunos campos <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón Guardar
    Then aparece un mensaje que indica que la modificación se ha realizado correctamente y se ha enviado al erp <scenario>,<pagina>,<fichero_datos>
    And finalmente se comprueba que SI se ha modificado la información del cliente contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado OK <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario        | pagina                             | fichero_datos                  | oficina           |
      | ModificarCentroDeTrabajoEnvioOK | GESTION_CENTROS_DE_TRABAJO__CONSULTA | GestionCentrosDeTrabajoConsulta | 423-FLX-VALLADOLID |