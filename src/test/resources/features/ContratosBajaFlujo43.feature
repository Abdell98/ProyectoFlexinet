Feature: contratos-baja-flujo43

  @Contratos @CrearPedidoBloqueadoRiesgosBaja @Flujo43
  Scenario Outline: Creación de Pedidos bloqueado por riesgos y luego traspasado
    Given un pedido de alta simple inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
    #UAT
      | scenario      | pagina                        | fichero_datos                       | oficina |
      | Flujo43 | CONTRATOS__BAJA_BAJAS_MASIVAS |CONTRATOS__BAJA/Flujo43/Flujo43.json | 402-FLX-CÁDIZ |

  #TODO: Elegir Contrato sobre el check de validación: 3, El chek debe estar SIEMPRE deshabilitado.
  #Validar los test siguientes donde se puede seleccionar la opción de traspaso de baja masivas
  # Test 3: Si el contrato tiene movimientos y el ultimo es sino de los siguientes: (ERP_SEND_OK,ERP_SEND_KO, ERP_KO),
  #TODO: CHECK DESHABILITADO
  @Contratos @Baja @BajasMasivas @Flexinet19954 @Flujo43
  Scenario Outline: Flexinet-19954: Elegir Contrato "Flujo43"
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    Then seleccionar sobre la tabla el contrato <scenario>,<pagina>,<fichero_datos>
    Examples:
    #UAT
      | scenario      | pagina                        | fichero_datos                        | oficina       |
      | Flujo43 | CONTRATOS__BAJA_BAJAS_MASIVAS | CONTRATOS__BAJA/Flujo43/Flujo43.json | 402-FLX-CÁDIZ |

  @Contratos @Flujo43
  Scenario Outline: Flujo43: Este escenario simplemente da de baja un contrato
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
    #UAT
      | scenario | pagina                        | fichero_datos                         | oficina       |
      | Flujo43  | CONTRATOS__BAJA_BAJAS_MASIVAS | CONTRATOS__BAJA/Flujo43/Flujo43.json  | 402-FLX-CÁDIZ |