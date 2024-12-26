Feature: contratos-baja-flujo45

  @Contratos @CrearPedidoAutorizadoRiesgos @Flujo45
  Scenario Outline: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario      | pagina                   | fichero_datos                        | oficina |
      #PRE
      | Flujo45 | CONTRATOS__BAJA_CONSULTA | CONTRATOS__BAJA/Flujo45/Flujo45.json | 451-FLX-TOLEDO |

  @Contratos @Baja @BajasMasivas @Flexinet19953 @Flujo45
  Scenario Outline: Flexinet-19953:Dar Baja (Tiene movimientos Oracle, el útimo OK)
    Given el usuario está en la página CONTRATOS__BAJA_DAR_DE_BAJA, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And hace click en el botón BTN_DARDEBAJA ubicado en CURRENTPAGE true
    And selecciona el motivo de la baja y su fecha <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_MOTIVOBAJA true
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_BAJACONTRATO true
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_BAJACONTRATO false
    When aparece un mensaje indicando que el contrato se ha traspasado <fichero_datos>
    Then se selecciona la opción de cancelar para no sustituir el contrato
    Examples:
      | scenario | pagina                   | fichero_datos                        | oficina        |
      | Flujo45  | CONTRATOS__BAJA_CONSULTA | CONTRATOS__BAJA/Flujo45/Flujo45.json | 451-FLX-TOLEDO |

  @Contratos @Baja @AnularBaja @Flexinet19957 @Flujo45
  Scenario Outline: Flexinet-19957:Tiene movimiento oracle OK "Flujo45"
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_ANULARBAJA ubicado en CURRENTPAGE true
    When hace click en el botón BTN_SI_SINACENTO ubicado en DIALOG_ANULACIONBAJA false
    Then hace click en el botón BTN_ACEPTAR ubicado en CURRENTPAGE false
    Examples:
      | scenario      | pagina                   | fichero_datos                        | oficina        |
      | Flujo45 | CONTRATOS__BAJA_CONSULTA | CONTRATOS__BAJA/Flujo45/Flujo45.json | 451-FLX-TOLEDO |

  @Contratos @Anulacion @Flujo45
  Scenario Outline: Flujo45: Este escenario simplemente anula un contrato
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_ANULARCONTRATO ubicado en CURRENTPAGE true
    When hace click en el botón BTN_ACEPTAR ubicado en DIALOG_ANULACIONDECONTRATO true
    Then el usuario comprueba que sale la notificación del tipo CORRECTO con el mensaje El contrato ha sido anulado.
    Examples:
      | scenario      | pagina               | fichero_datos                         | oficina        |
      | Flujo45       | CONTRATOS__ANULACION | CONTRATOS__BAJA/Flujo45/Flujo45.json  | 451-FLX-TOLEDO |