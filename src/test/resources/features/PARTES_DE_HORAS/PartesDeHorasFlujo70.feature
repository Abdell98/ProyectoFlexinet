Feature: partes-de-horas-flujo70

  ############################# FLUJO70 #############################
  #Tests Objetivos:
  # - Flexinet-19848:20230703-15:29:24 20230703-15:25:13 20230703-15:20:43 Pedido autorizado - parte creado a partir de pedido autorizado
  # - Flexinet-19849:20230703-15:28:57 20230703-15:25:13 20230703-15:20:43 Pedido autorizado - parte creado a partir de pedido autorizado
  # - Flexinet-19789:P6020-1825 Sherpa: FLEX.INT.IN.30 Envío Parte de horas Fichero CSV - entrar a envio partes oracle
  # - Flexinet-19791:P6020-1825 Botón Buscar Botón check traspasado OFF - se busca un parte no traspasado a oracle
  # - Flexinet-19825:Alta - Traspasar Contrato - se le da a Guardar traspasar en alta
  # - Flexinet-19927:Se elimina el parte Físicamente -
  # - Flexinet-19943: Consulta - Añadir Concepto - LV30-31
  # - Flexinet-19824:Traspasar Contrato - cuando el parte se modifica
  # - Flexinet-19944: Alta - Añadir Concepto - LV30-31 - Esto sería cuando se crea el pedido
  # - Flexinet-19942: Alta - Añadir Concepto - LV30-31 - Esto sería cuando se crea el pedido
  ###################################################################
  #Plan de ejecución completa en el testRunner
  # @CrearPedidoAutorizadoRiesgosFlujo70 or @CrearParteFlujo70 or @EnvioOracleFlujo70 or @EliminarParteFlujo70
  ###################################################################


  @PartesDeHoras @CrearPedidoBloqueadoRiesgosFlujo70 @Flujo70
  Scenario Outline: Flujo70 se crea un Pedidos bloqueado por riesgos y luego traspasado
    Given un pedido de alta simple inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario | pagina | fichero_datos | oficina |
      #PRE
      | CrearPedidoBloqueadoRiesgosFlujo70 | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 451-FLX-TOLEDO |
      #UAT
#      | CrearPedidoBloqueadoRiesgosFlujo70  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 402-FLX-CÁDIZ |

  @PartesDeHoras @CrearPedidoAutorizadoRiesgosFlujo70 @Flujo70
  Scenario Outline: Flujo70 se crea un Pedidos autorizado por riesgos y luego traspasado
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario                            | pagina                | fichero_datos                                | oficina        |
      #PRE
      | CrearPedidoAutorizadoRiesgosFlujo70 | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 451-FLX-TOLEDO |


  #Notas:
  # - Para este escenario en la pantalla de consulta de partes marcar el "chk_aNivelNacional": "true"
  # - Este scenario se puede repetir con los mismos datos, dado que se elimina el parte al final
  # - El parte se traspasa en el alta
  @PartesDeHoras @CrearParteFlujo70 @Flujo70
  Scenario Outline: Flujo70 se crea el parte se traspasa y se le añade un concepto nomina al parte
    #Crear pedido alta simple y generar contrato traspasado
    # El pedido se crea añadiendo un concepto nomina se validan @Flexinet-19944 @Flexinet-19942 test que parecen duplicados
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And selecciona empresa y contrato <scenario>,<pagina>,<fichero_datos>
    And rellena los campos necesarios para dar de alta el parte <scenario>,<pagina>,<fichero_datos>
    # @Flexinet-19825: se le da a guardar y traspasar
    When hace click en el botón BTN_GUARDARTRASPASAR ubicado en CURRENTPAGE false
    Then el usuario comprueba que sale la notificación del tipo EXITO con el mensaje El parte de horas ha sido insertado y traspasado con éxito
    And se toma nota del numero de parte <scenario>,<pagina>,<fichero_datos>
    #Consultar parte
    Given el usuario está en la página PARTES_DE_HORAS__CONSULTA, en la oficina <oficina>, probando el escenario <scenario>
    And rellena los campos necesarios del formulario para buscar un parte <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    And hace click en el botón Buscar y selecciona el resultado esperado de la tabla <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    #Modificar parte - @Flexinet-19943:Añadir Concepto
    When hace click en el botón BTN_MODIFICAR ubicado en CURRENTPAGE true
    And añadimos un concepto nomina <scenario>,PARTES_DE_HORAS__MODIFICACION,<fichero_datos>
    #Guardar traspasar en consulta @Flexinet-19824:Traspasar Contrato
    When hace click en el botón BTN_GUARDARTRASPASAR ubicado en CURRENTPAGE false
    Then el usuario comprueba que sale la notificación del tipo EXITO con el mensaje El parte de horas ha sido modificado y traspasado con éxito

    Examples:
      | scenario | pagina                | fichero_datos                                | oficina        |
#      #PRE
      | Flujo70  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 451-FLX-TOLEDO |
      #UAT
#      | Flujo70  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 402-FLX-CÁDIZ |

  @PartesDeHoras @EnvioOracleFlujo70 @Flujo70
  Scenario Outline: Flujo70 en la página de envio partes oracle, envia el parte a oracle y lo elimina de oracle
    # @Flexinet-19789 - aqui solo se valida el acceso a la web de enviopartesoracle
    # @Flexinet-19849 se ven los partes creados de un pedido autorizado
    # @Flexinet-19848 se ven los partes creados de un pedido autorizado
    Given el usuario está en la página PARTES_DE_HORAS__ENVIOSPARTESAORACLE, en la oficina <oficina>, probando el escenario <scenario>
    # @Flexinet-19791 - aqui marcamos el check Traspasados OFF, debe venir en el json como false
    And rellena los campos necesarios del formulario de busqueda de partes para enviar a oracle <scenario>,PARTES_DE_HORAS__ENVIOSPARTESAORACLE,<fichero_datos>
    #TODO: falta implementar en este punto @Flexinet-19793 es decir el botón enviar a oracle

    Examples:
      | scenario | pagina                | fichero_datos                                | oficina        |
#      #PRE
      | Flujo70  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 451-FLX-TOLEDO |
      #UAT
#      | Flujo70  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 402-FLX-CÁDIZ |

  #TODO integrar alguno de los siguientes test
  #Flexinet-19819:El parte no se envía cono baja en el CSV -
  #Flexinet-19818:P6020-1825 Parte Enviado al ERP: FLEX.INT.IN.30 Envío Parte de horas Fichero CSV -
  #Flexinet-19925:No se puede elimiar Parte –
  @PartesDeHoras @EliminarParteFlujo70 @Flujo70
  Scenario Outline: Flujo70 elimina el parte fisicamente
    Given el usuario está en la página PARTES_DE_HORAS__CONSULTA, en la oficina <oficina>, probando el escenario <scenario>
    And rellena los campos necesarios del formulario para buscar un parte <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    And hace click en el botón Buscar y selecciona el resultado esperado de la tabla <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    When hace click en el botón BTN_MODIFICAR ubicado en CURRENTPAGE true
    Then desactiva el check de validado <scenario>,PARTES_DE_HORAS__MODIFICACION,<fichero_datos>
    And hace click en el botón BTN_GUARDAR ubicado en CURRENTPAGE false
    Then el usuario comprueba que sale la notificación del tipo EXITO con el mensaje Parte de Horas ha sido modificado con éxito
    And selecciona el registro modificado <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    # Eliminar parte fisicamente @Flexinet-19927
    When hace click en el botón BTN_ELIMINAR ubicado en CURRENTPAGE true
    And aparece el dialogo de Borrado de parte y hacemos click en SI
    Then el usuario comprueba que sale la notificación del tipo CORRECTO con el mensaje El parte de horas ha sido eliminado correctamente

    Examples:
      | scenario | pagina                | fichero_datos                                | oficina        |
#      #PRE
      | Flujo70  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 451-FLX-TOLEDO |
      #UAT
#      | Flujo70  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 402-FLX-CÁDIZ |