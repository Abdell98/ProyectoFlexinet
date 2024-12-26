Feature: gestion-centros-de-trabajo-alta

  @GestionCentrosDeTrabajo @Alta @AltaCentroDeTrabajoEnvioKO
  Scenario Outline: El objetivo de este escenario es que al intentar dar de alta un centro de trabajo con datos incorrectos se salga un error
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa por su razón social <scenario>,<pagina>,<fichero_datos>
    And la selecciona y hace click en la fila correspondiente del resultado de la tabla <scenario>,<pagina>,<fichero_datos>
    And selecciona el cliente contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en Alta Centro de Trabajo <scenario>
    When aparecen las pestañas de gestion accede a ellas y rellena los campos requeridos que no tengan valor <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón Guardar
    Then aparece un mensaje de error de envio al ERP <scenario>,<pagina>,<fichero_datos>
    And finalmente comprueba que NO se ha creado una nueva entidad en la tabla CENTRO <scenario>,<pagina>,<fichero_datos>,<oficina>
    And finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado KO <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario        | pagina                             | fichero_datos                  | oficina           |
      | AltaCentroDeTrabajoEnvioKO | GESTION_CENTROS_DE_TRABAJO__ALTA | GestionCentrosDeTrabajoAlta | 421-FLX-SEGOVIA |

  @GestionCentrosDeTrabajo @Alta @AltaCentroDeTrabajoEnvioOK
  Scenario Outline: El objetivo de este escenario es dar de alta un centro de trabajo
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa por su razón social <scenario>,<pagina>,<fichero_datos>
    And la selecciona y hace click en la fila correspondiente del resultado de la tabla <scenario>,<pagina>,<fichero_datos>
    And selecciona el cliente contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en Alta Centro de Trabajo <scenario>
    When aparecen las pestañas de gestion accede a ellas y rellena los campos requeridos que no tengan valor <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón Guardar
    Then aparece un mensaje que indica que el alta se ha realizado correctamente y se ha enviado al ERP <scenario>,<pagina>,<fichero_datos>
    And finalmente comprueba que SI se ha creado una nueva entidad en la tabla CENTRO <scenario>,<pagina>,<fichero_datos>,<oficina>
    And finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado OK <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario        | pagina                             | fichero_datos                  | oficina           |
      | AltaCentroDeTrabajoEnvioOK | GESTION_CENTROS_DE_TRABAJO__ALTA | GestionCentrosDeTrabajoAlta | 423-FLX-VALLADOLID |