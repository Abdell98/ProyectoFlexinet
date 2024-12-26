Feature: contratos-anulacion

  @Contratos @CrearPedidoBloqueadoRiesgosBaja
  Scenario Outline: Creación de Pedidos bloqueado por riesgos y luego traspasado
    Given un pedido de alta simple inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
    #UAT
      | scenario      | pagina                        | fichero_datos                       | oficina |
      | Flexinet19954 | CONTRATOS__BAJA_BAJAS_MASIVAS |CONTRATOS__BAJA/Flujo43/Flujo43.json | 402-FLX-CÁDIZ |

  @Contratos @CrearPedidoAutorizadoRiesgosFlujo54
  Scenario Outline: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario | pagina | fichero_datos  | oficina |
      #PRE
      | Flexinet19921  | CONTRATOS__ANULACION | CONTRATOS__ANULACION/Flujo54/Flujo54.json   | 451-FLX-TOLEDO |

  @Contratos @CrearPedidoAutorizadoNoTraspadadoFlujo55
  Scenario Outline: Creación de Pedidos autorizado por riesgos y no traspasado de alta simple
    Given un pedido autorizado y NO traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario | pagina | fichero_datos  | oficina |
      #PRE
      | Flexinet19962  | CONTRATOS__ANULACION | CONTRATOS__ANULACION/Flujo55/Flujo55.json   | 451-FLX-TOLEDO |

  #TODO: Escenario Ejecutado en ambiente PRE
  @Contratos @Anulacion @Flexinet19921 @Flujo54
  Scenario Outline: Flexinet-19921:Botón Anulación Contrato traspasado. Último movimiento Oracle KO
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en opción anular contrato
    And hace click en opción Aceptar, sobre la anulación de contrato
    Then validar información que el contrato se ha anulado
    Examples:
      | scenario      | pagina               | fichero_datos                              | oficina        |
      | Flexinet19921 | CONTRATOS__ANULACION | CONTRATOS__ANULACION/Flujo54/Flujo54.json  | 451-FLX-TOLEDO |

  #TODO: Escenario Ejecutado en ambiente PRE PROBAR EL LUNES QUE TODO ESTE BIEN CREANDO UN PEDIDO DESDE CERO.
  @Contratos @Anulacion @Flexinet19962 @Flujo55
  Scenario Outline: Flexinet-19962:Botón Anulación Contrato NO traspasado
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en opción anular contrato
    And hace click en opción Aceptar, sobre la anulación de contrato
    Then validar información que el contrato se ha anulado
    Examples:
      | scenario      | pagina               | fichero_datos                              | oficina        |
      | Flexinet19962 | CONTRATOS__ANULACION | CONTRATOS__ANULACION/Flujo55/Flujo55.json  | 451-FLX-TOLEDO |

  #TODO: Escenario solo se puede validar en UAT cuando este disponible no se ha probado aun, y es cuando el contrato aun tiene un proceso pendiente en ORACLE.Ability:
  @Contratos @Anulacion @Flexinet19921 @Flujo56
  Scenario Outline: Flexinet-19921:Botón Anulación Contrato traspasado. Último movimiento Oracle KO
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en opción anular contrato
    And hace click en opción Aceptar, sobre la anulación de contrato
    Then validar información que el contrato se ha anulado
    Examples:
      | scenario      | pagina               | fichero_datos                              | oficina        |
      | Flexinet19962 | CONTRATOS__ANULACION | CONTRATOS__ANULACION/Flujo55/Flujo55.json  | 451-FLX-TOLEDO |


  @Contratos @Flujo5X
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
      | scenario      | pagina               | fichero_datos                              | oficina        |
      | Flujo5X | CONTRATOS__ANULACION | CONTRATOS__ANULACION/Flujo5X/Flujo5X.json  | 451-FLX-TOLEDO |


