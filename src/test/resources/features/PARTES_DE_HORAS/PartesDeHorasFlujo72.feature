Feature: partes-de-horas-flujo72

  ############################# FLUJO72 #############################
  #Tests Objetivos:
  # - Flexinet-19948:Añadir Concepto
  # - Flexinet-19949:Añadir Concepto
  ###################################################################
  #Plan de ejecución completa en el testRunner
  # @CrearPedidoAutorizadoRiesgosFlujo72 or @CrearParteFlujo72 or @EnvioOracleFlujo72 or @EliminarParteFlujo72
  ###################################################################

  @PartesDeHoras @CrearPedidoAutorizadoRiesgosFlujo72 @Flujo72
  Scenario Outline: Flujo72 Creación de Pedido lv3233 autorizado por riesgos y luego traspasado
    Given un pedido autorizado y traspasado LV3233 <scenario>,<pagina>,<fichero_datos>,<oficina>

    Examples:
      | scenario                            | pagina                | fichero_datos                              | oficina        |
      #PRE
      | CrearPedidoFlujo72 | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo72/Flujo72_1.json | 451-FLX-TOLEDO |


  @PartesDeHoras @CrearParteFlujo72 @Flujo72
  Scenario Outline: Flujo72 se crea el parte se traspasa y se le añade un concepto nomina al parte
    #Crear pedido alta simple y generar contrato traspasado
    # El pedido se crea añadiendo un concepto nomina se validan @Flexinet-19948 @Flexinet-19949 test que parecen duplicados
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
    #Modificar parte - @Flexinet-19948:Añadir Concepto
    When hace click en el botón BTN_MODIFICAR ubicado en CURRENTPAGE true
    And añadimos un concepto nomina <scenario>,PARTES_DE_HORAS__MODIFICACION,<fichero_datos>
    #Guardar traspasar en consulta @Flexinet-19824:Traspasar Contrato
    When hace click en el botón BTN_GUARDARTRASPASAR ubicado en CURRENTPAGE false
    Then el usuario comprueba que sale la notificación del tipo EXITO con el mensaje El parte de horas ha sido modificado y traspasado con éxito

    Examples:
      | scenario | pagina                | fichero_datos                                | oficina        |
#      #PRE
      | CrearParteFlujo72  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo72/Flujo72_1.json | 451-FLX-TOLEDO |
      #UAT
#      | CrearParteFlujo72  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo72/Flujo72_1.json | 402-FLX-CÁDIZ |

  @PartesDeHoras @Alta @EnviarParteOracleFlujo72
  Scenario Outline: Flujo72 Se crea un parte y se traspasa
    #Crear antes un pedido alta simple, generar contrato y traspasarlo, esperar a que sea procesado por oracle
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And selecciona empresa y contrato <scenario>,<pagina>,<fichero_datos>
    And rellena los campos necesarios para dar de alta el parte <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_GUARDARTRASPASAR ubicado en CURRENTPAGE true
    Then el usuario comprueba que sale la notificación del tipo EXITO con el mensaje El parte de horas ha sido insertado y traspasado con éxito
    And se toma nota del numero de parte <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario | pagina                | fichero_datos                                | oficina        |
#     #PRE
      | CrearParteFlujo72  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo72/Flujo72_1.json | 451-FLX-TOLEDO |
#     #UAT
#      | CrearParteFlujo72  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo72/Flujo72_1.json | 402-FLX-CÁDIZ |

  #TODO integrar alguno de los siguientes test
  #Flexinet-19819:El parte no se envía cono baja en el CSV -
  #Flexinet-19818:P6020-1825 Parte Enviado al ERP: FLEX.INT.IN.30 Envío Parte de horas Fichero CSV -
  #Flexinet-19925:No se puede elimiar Parte –
  @PartesDeHoras @Alta @EliminarParteFlujo72
  Scenario Outline: Flujo72 Aqui se se intenta eliminar el parte pero de confirma que aparece un mensaje indicando que no se puede
    Given el usuario está en la página PARTES_DE_HORAS__CONSULTA, en la oficina <oficina>, probando el escenario <scenario>
    And rellena los campos necesarios del formulario para buscar un parte <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    And hace click en el botón Buscar y selecciona el resultado esperado de la tabla <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    And hace click en el botón BTN_MODIFICAR ubicado en CURRENTPAGE true
    Then desactiva el check de validado <scenario>,PARTES_DE_HORAS__MODIFICACION,<fichero_datos>
    And hace click en el botón BTN_GUARDAR ubicado en CURRENTPAGE false
    Then el usuario comprueba que sale la notificación del tipo EXITO con el mensaje Parte de Horas ha sido modificado con éxito
    And selecciona el registro modificado <scenario>,PARTES_DE_HORAS__CONSULTA,<fichero_datos>
    When hace click en el botón BTN_ELIMINAR ubicado en CURRENTPAGE true
    And aparece el dialogo de Borrado de parte y hacemos click en SI
    Then el usuario comprueba que sale la notificación del tipo CORRECTO con el mensaje El parte de horas ha sido eliminado correctamente

    Examples:
      | scenario | pagina                | fichero_datos                                | oficina        |
#      #PRE
      | EliminarParteFlujo72  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo72/Flujo72_1.json | 451-FLX-TOLEDO |
      #UAT
#      | EliminarParteFlujo72  | PARTES_DE_HORAS__ALTA | PARTES_DE_HORAS__ALTA/Flujo71/Flujo72_1.json | 402-FLX-CÁDIZ |