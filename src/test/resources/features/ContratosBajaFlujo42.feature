Feature: contratos-baja-flujo42

  @Contratos @CrearPedidoAutorizadoRiesgos42 @Flujo42
  Scenario Outline: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
    #PRE
      | scenario | pagina                      | fichero_datos                       | oficina        |
      | Flujo42  | CONTRATOS__BAJA_DAR_DE_BAJA |CONTRATOS__BAJA/Flujo42/Flujo42.json | 451-FLX-TOLEDO |

  #INFO: Validar nuevamente cuando se tenga información para realizar la baja en ambiente UAT.
  @Contratos @Baja @DarBaja @Flexinet-19953 @Flexinet-19969 @Flujo42
  Scenario Outline: Flexinet-19953:Dar Baja (Tiene movimientos Oracle, el útimo OK) "Flujo42"
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_DARDEBAJA ubicado en CURRENTPAGE true
    And selecciona el motivo de la baja y su fecha <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_MOTIVOBAJA true
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_BAJACONTRATO true
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_BAJACONTRATO false
    When aparece un mensaje indicando que el contrato se ha traspasado <fichero_datos>
    #Se selecciona la opción aceptar para realizar la sustitución del contrato Flexinet-19969.
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_BAJACONTRATO false
    And se ingresan los datos para completar el Alta de Sustitución <scenario>,CONTRATOS__ALTA_SUSTITUCION,<fichero_datos>
    And hace click en el botón BTN_ALTADESUSTITUCION ubicado en DIALOG_ALTASUSTITUCION true
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_ALTASUSTITUCION false
    Then se ha creado correctamente la sustitución del contrato
    Examples:
      | scenario       |pagina                       |fichero_datos                             | oficina       |
      #UAT
     # | Flexinet19953 | CONTRATOS__BAJA_DAR_DE_BAJA  |CONTRATOS__BAJA/Flujo42/ContratoBajas.json| 402-FLX-CÁDIZ |
      #PRE
      | Flujo42 | CONTRATOS__BAJA_DAR_DE_BAJA |CONTRATOS__BAJA/Flujo42/Flujo42.json  | 451-FLX-TOLEDO |