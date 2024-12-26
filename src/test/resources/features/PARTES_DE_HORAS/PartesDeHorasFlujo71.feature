Feature: partes-de-horas-flujo71

  ############################# FLUJO71 #############################
  #Tests Objetivos:
  # - Flexinet-19826:Traspasar
  # - Flexinet-19792:P6020-1825 Botón Buscar check partes Traspasados ON -º -
  ###################################################################
  #Plan de ejecución completa en el testRunner
  # @CrearPedidoAutorizadoRiesgosFlujo71 or @CrearParteFlujo71 or @EnvioOracleFlujo71 or @EliminarParteFlujo71
  ###################################################################

  @PartesDeHoras @CrearPedidoAutorizadoRiesgosFlujo71 @Flujo71
  Scenario Outline: Flujo71 Creación de Pedidos autorizado por riesgos y luego traspasado
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>

    Examples:
      | scenario                            | pagina                | fichero_datos                              | oficina        |
      #PRE
      | CrearPedidoAutorizadoRiesgosFlujo71 | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo71/Flujo71_1.json | 451-FLX-TOLEDO |


  #Notas:
  # - Para este escenario en la pantalla de consulta de partes marcar el "chk_aNivelNacional": "true"
  # - Este scenario se puede repetir con los mismos datos, dado que se elimina el parte al final
  # - El parte se traspasa en el alta
  #Tests cubiertos:
  # - Flexinet-19826:Traspasar
  @PartesDeHoras @CrearParteFlujo71 @Flujo71
  Scenario Outline: Flujo71 se crea el parte sin traspasar luego se va a traspasos y se traspasa
    #Crear antes un pedido alta simple, generar contrato y traspasarlo, esperar a que sea procesado por oracle
    #A continuación creamos un parte y lo guardamos sin traspasar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And selecciona empresa y contrato <scenario>,<pagina>,<fichero_datos>
    And rellena los campos necesarios para dar de alta el parte <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_GUARDAR ubicado en CURRENTPAGE false
    Then el usuario comprueba que sale la notificación del tipo EXITO con el mensaje Parte de Horas ha sido insertado con éxito
    And se toma nota del numero de parte <scenario>,<pagina>,<fichero_datos>
    #En traspasos buscar parte
    Given el usuario está en la página PARTES_DE_HORAS__TRASPASO, en la oficina <oficina>, probando el escenario <scenario>
    When rellena los campos necesarios del formulario para buscar un parte <scenario>,PARTES_DE_HORAS__TRASPASO,<fichero_datos>
    And hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And selecciona el resultado esperado de la tabla1 <scenario>,PARTES_DE_HORAS__TRASPASO,<fichero_datos>
    And hace click en el botón BTN_ANADIRPARTE ubicado en CURRENTPAGE true
    And selecciona el resultado esperado de la tabla2 <scenario>,PARTES_DE_HORAS__TRASPASO,<fichero_datos>
    # Se valida el @Flexinet-19826
    Then hace click en el botón BTN_TRASPASAR ubicado en CURRENTPAGE false
    And el usuario comprueba que sale la notificación del tipo INFORMACION con el mensaje Los partes de horas seleccionados han sido traspasados correctamente

    Examples:
      | scenario | pagina                | fichero_datos                                | oficina        |
#      #PRE
      | CrearParteFlujo71  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo71/Flujo71_1.json | 451-FLX-TOLEDO |
      #UAT
#      | CrearParteFlujo71  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo71/Flujo71_1.json | 402-FLX-CÁDIZ |


  @PartesDeHoras @EnvioOracleFlujo71 @Flujo71
  Scenario Outline: Flujo71 en la página de envio partes oracle, envia el parte a oracle y lo elimina de oracle
    Given el usuario está en la página PARTES_DE_HORAS__ENVIOSPARTESAORACLE, en la oficina <oficina>, probando el escenario <scenario>
    # @Flexinet-19792 - aqui marcamos el check Traspasados ON, debe venir en el json como true
    And rellena los campos necesarios del formulario de busqueda de partes para enviar a oracle <scenario>,PARTES_DE_HORAS__ENVIOSPARTESAORACLE,<fichero_datos>
    #TODO: falta implementar en este punto el botón de busqueda y confirmar que aparece en resultados

    Examples:
      | scenario | pagina                | fichero_datos                                | oficina        |
#      #PRE
      | Flujo71  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo71/Flujo71_1.json | 451-FLX-TOLEDO |
      #UAT
#      | Flujo71  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo70/Flujo70_1.json | 402-FLX-CÁDIZ |

  #TODO integrar alguno de los siguientes test
  #Flexinet-19819:El parte no se envía cono baja en el CSV -
  #Flexinet-19818:P6020-1825 Parte Enviado al ERP: FLEX.INT.IN.30 Envío Parte de horas Fichero CSV -
  #Flexinet-19925:No se puede elimiar Parte –
  @PartesDeHoras @EliminarParteFlujo71 @Flujo71
  Scenario Outline: Flujo71 aqui se se elimina el parte
    Given el usuario está en la página PARTES_DE_HORAS__CONSULTA, en la oficina <oficina>, probando el escenario <scenario>
    And rellena los campos necesarios del formulario para buscar un parte <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    And hace click en el botón Buscar y selecciona el resultado esperado de la tabla <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    And hace click en el botón BTN_MODIFICAR ubicado en CURRENTPAGE true
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
      | Flujo71  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo71/Flujo71_1.json | 451-FLX-TOLEDO |
      #UAT
#      | Flujo71  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo71/Flujo71_1.json | 402-FLX-CÁDIZ |