Feature: contratos-baja-flujo50

  @PartesDeHoras @CrearPedidoFlujo50 @Flujo50
  Scenario Outline: CrearPedidoAutorizadoRiesgosFlujo50 Creación de Pedido lv3233 autorizado por riesgos y luego traspasado
    Given un pedido autorizado y traspasado LV3233 <scenario>,<pagina>,<fichero_datos>,<oficina>

    Examples:
      | scenario      | pagina                   | fichero_datos                        | oficina        |
      #PRE
      | Flujo50 | CONTRATOS__BAJA_CONSULTA | CONTRATOS__BAJA/Flujo50/Flujo50.json | 451-FLX-TOLEDO |

  @Contratos @Baja @BajasMasivas @Flexinet19896 @Flujo50
  Scenario Outline: Flexinet-19955:No tiene movimiento Oracle "Flujo50"
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_DARDEBAJA ubicado en CURRENTPAGE true
    And selecciona el motivo de la baja y su fecha <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_MOTIVOBAJA true
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_BAJACONTRATO true
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_BAJACONTRATO false
    And aparece un mensaje indicando que el contrato se ha traspasado <fichero_datos>
    And se selecciona la opción de cancelar para no sustituir el contrato
    Examples:
      | scenario  | pagina                   | fichero_datos                        | oficina        |
      | Flujo50   | CONTRATOS__BAJA_DAR_DE_BAJA | CONTRATOS__BAJA/Flujo50/Flujo50.json | 451-FLX-TOLEDO |

  @Contratos @Baja @BajasMasivas @Flexinet19955 @Flujo50
  Scenario Outline: Flexinet-19955:No tiene movimiento Oracle "Flujo50"
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_ANULARBAJA ubicado en CURRENTPAGE false
    And hace click en el botón BTN_SI_SINACENTO ubicado en DIALOG_ANULACIONBAJA false
    Then hace click en el botón BTN_ACEPTAR ubicado en CURRENTPAGE false
    Examples:
      | scenario  | pagina                   | fichero_datos                        | oficina        |
      | Flujo50   | CONTRATOS__BAJA_CONSULTA | CONTRATOS__BAJA/Flujo50/Flujo50.json | 451-FLX-TOLEDO |

  @Contratos @Flujo50
  Scenario Outline: Flujo50: Este escenario simplemente anula un contrato
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_ANULARCONTRATO ubicado en CURRENTPAGE true
    When hace click en el botón BTN_ACEPTAR ubicado en DIALOG_ANULACIONDECONTRATO true
    Then validar información que el contrato se ha anulado
    Examples:
      | scenario      | pagina               | fichero_datos                         | oficina        |
      | Flujo50       | CONTRATOS__ANULACION | CONTRATOS__BAJA/Flujo50/Flujo50.json  | 451-FLX-TOLEDO |