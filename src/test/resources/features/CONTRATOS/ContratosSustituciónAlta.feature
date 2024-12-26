Feature: contratos-Sustitución-Alta

   # ---- CREACION DE PEDIDOS Y CONTRATOS ----

  @PartesDeHoras @CrearPedidoAutorizadoRiesgosFlujo59
  Scenario Outline: CrearPedidoAutorizadoRiesgosFlujo56: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario                    | pagina                | fichero_datos                                | oficina        |
      #PRE
      | Flexinet-19967 | CONTRATOS__ALTA_SUSTITUCION | CONTRATOS_SUSTITUCION/Flujo59/Flujo59.json | 451-FLX-TOLEDO |

  @Contratos @Baja @ContratoBajaFlujo59
  Scenario Outline: Dar de baja a contratos creados
    Given un contrato creado para darle de baja <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario       | pagina                         | fichero_datos                                                          | oficina |
      | Flexinet-19967   | CONTRATOS__BAJA_DAR_DE_BAJA | CONTRATOS_SUSTITUCION/Flujo59/Flujo59.json  | 451-FLX-TOLEDO |
  #Tras darle al botón Alta Sustitución se le da de baja al contrato sustituido
  #Precondiciones:
  #Ir a la ventana Gestión de Oficinas -> Sustitución -> Alta -> realizar busqueda y pulsar Alta sustitución
  # Resultado Esperado :
  # Da de baja el contrato sustituido y se env´via fecha de baja (Contrato.fec_baja) a Oracle

  @Contratos @Alta-Sustitucion @Flexinet19967 @Flexinet19968 @Flujo59

  Scenario Outline: Flujo59 : Botón Crear Sustitución
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And filtrar el contrato recién creado <scenario>,<pagina>,<fichero_datos>
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_ALTASUSTITUCION ubicado en CURRENTPAGE true
    And ingresamos los datos para completar el Alta de Sustitución <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_BUSCARCOLABORADOR ubicado en DIALOG_ALTASUSTITUCION true
    And selecciona el colaborador <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_PERFILDATOUNICO ubicado en DIALOG_SELECCIONDECOLABORADORES true
    And rellena los datos de la tabla de Pérfil Dato Único <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_GUARDAR ubicado en DIALOG_PERFILDATOUNICO true
    And verifica que aparece el mensaje del modal correctamente y lo cierra
    And hace click en el botón BTN_ASOCIARCOLABORADOR ubicado en DIALOG_SELECCIONDECOLABORADORES true
    And hace click en opción alta de sustitución
    And se selecciona la opción aceptar sobre la sustitución
    Then se ha creado correctamente la sustitución del contrato

    Examples:
      | scenario       | pagina                         | fichero_datos                                                          | oficina                |
      | Flujo59   | CONTRATOS__ALTA_SUSTITUCION | CONTRATOS_SUSTITUCION/Flujo59/Flujo59.json  | 451-FLX-TOLEDO |