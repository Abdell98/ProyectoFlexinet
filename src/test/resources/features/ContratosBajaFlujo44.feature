Feature: contratos-baja

  @Contratos @CrearPedidoAutorizadoRiesgos @Flujo44pp
  Scenario Outline: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario | pagina | fichero_datos  | oficina |
      | Flexinet19899  | CONTRATOS__BAJA_BAJAS_MASIVAS | CONTRATOS__BAJA/Flujo44/Flujo44.json   | 451-FLX-TOLEDO |
      | Flexinet19899  | CONTRATOS__BAJA_BAJAS_MASIVAS | CONTRATOS__BAJA/Flujo44/Flujo44_2.json | 451-FLX-TOLEDO |

  #TODO: Se seleccionan dos contratos de alta simple, para la ejecución de este test.
  @Contratos @Baja @BajasMasivas @Flexinet19899 @Flexinet19954 @Flujo44
  Scenario Outline: Flexinet-19899:Bajas Masiva "Flujo44"
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    #And rellena el formulario de <scenario>,<pagina>,<fichero_datos>

    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    And se realiza una busqueda por columna nro contrato <scenario>,<pagina>,<fichero_datos>
    And seleccionar sobre la tabla el contrato <scenario>,<pagina>,<fichero_datos>
    And se realiza una busqueda por columna nro contrato <scenario>,<pagina>,CONTRATOS__BAJA/Flujo44/Flujo44_2.json
    And seleccionar sobre la tabla el contrato <scenario>,<pagina>,CONTRATOS__BAJA/Flujo44/Flujo44_2.json
    And hace click en opción baja de contratos
    And selecciona la fecha sobre el detalle de la baja masiva <scenario>,<pagina>,<fichero_datos>
    And hace click sobre la opcion de aceptar <scenario>
    And hace click en aceptar para proceder a la baja masiva de contratos
    And hace click sobre el boton aceptar
    Then aparece una notificacion indicando que el contrato ha sido dado de baja correctamente <fichero_datos>
    Examples:
      | scenario      | pagina                        | fichero_datos                        | oficina        |
      | Flexinet19899 | CONTRATOS__BAJA_BAJAS_MASIVAS | CONTRATOS__BAJA/Flujo44/Flujo44.json | 451-FLX-TOLEDO |

  @Contratos @Flujo5X_50
  Scenario Outline: Flujo5X: Este escenario simplemente anula un contrato
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_ANULARCONTRATO ubicado en CURRENTPAGE true
    When hace click en el botón BTN_ACEPTAR ubicado en DIALOG_ANULACIONDECONTRATO true
    Then validar información que el contrato se ha anulado
    Then el usuario comprueba que sale la notificación del tipo CORRECTO con el mensaje El contrato ha sido anulado.
    Examples:
      | scenario      | pagina               | fichero_datos                         | oficina        |
      | Flujo5X       | CONTRATOS__ANULACION | CONTRATOS__BAJA/Flujo50/Flujo50.json  | 451-FLX-TOLEDO |

  @Contratos @Flujo5Y
  Scenario Outline: Flujo5Y: Este escenario simplemente da de baja un contrato
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_DARDEBAJA ubicado en CURRENTPAGE true
    And selecciona el motivo de la baja y su fecha <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_ACEPTAR ubicado en DIALOG_MOTIVOBAJA true
    When hace click en el botón BTN_ACEPTAR ubicado en DIALOG_BAJACONTRATO true
    Then el usuario comprueba que sale la notificación del tipo CORRECTO con el mensaje Se ha traspasado la baja correctamente
    Examples:
      | scenario      | pagina               | fichero_datos                              | oficina        |
      | Flujo5Y | CONTRATOS__BAJA_DAR_DE_BAJA | CONTRATOS__BAJA/Flujo5Y/Flujo5Y.json  | 451-FLX-TOLEDO |