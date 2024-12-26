Feature: contratos-novacion

   # ---- CREACION DE PEDIDOS Y CONTRATOS ----

  @PartesDeHoras @CrearPedidoAutorizadoRiesgosFlujo56
  Scenario Outline: CrearPedidoAutorizadoRiesgosFlujo56: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario                    | pagina                | fichero_datos                                | oficina        |
      #PRE
      | Flexinet19910 | CONTRATOS__NOVACION_ALTA | CONTRATOS__NOVACION/Flexinet19910/ContratoNovacionAlta.json | 451-FLX-TOLEDO |


  # Resumen:
  # Tras la novación se enviará a Oracle la fecha de baja del contrato novado
  # Precondiciones:
  # Pasos:
  # Pulsar Botón "Editar Pedido"
  # Resultados Esperados:
  # Se da de baja el contrato y se envía la baja a Oracle.
  # Ver tablas:
  #   -  EXTERNAL_CPD_BAJA
  #   -  EXTERNAL_LOG_REQUEST
  #   -  EXTERNAL_HIST_FEC

  @Contratos @Novacion @Flexinet19910 @Flexinet19973 @Flexinet19972 @CrearNovacionContrtoFlujo56 @Flujo56
  Scenario Outline: Flexinet19910, Flexinet-19972, Flexinet19973: Probar la ventana de Novar Contrato
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And se selecciona los datos de la empresa <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And filtrar el contrato recién creado <scenario>,<pagina>,<fichero_datos>
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_NOVARCONTRATO ubicado en CURRENTPAGE true
    And se ingresa los datos baja de contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_ACEPTAR ubicado en DIALOG_ALTANOVACION true
    And aparece un mensaje indicando que el contrato ha sido dado de baja correctamente <fichero_datos>
      #A partir de aqui se ejecuta el escenario Flexinet-19910
    Then seleccionar la opción editar pedidos <scenario>

    Examples:
      | scenario           | pagina                   | fichero_datos                                               | oficina       |
      | Flexinet19910      | CONTRATOS__NOVACION_ALTA | CONTRATOS__NOVACION/Flexinet19910/ContratoNovacionAlta.json | 451-FLX-TOLEDO|
  #    | Flexinet19973
  #    | Flexinet19972