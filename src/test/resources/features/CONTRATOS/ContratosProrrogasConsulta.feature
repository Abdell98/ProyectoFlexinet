Feature: contratos-prorrogas-consulta

  # ---- CREACION DE PEDIDOS Y CONTRATOS ----

  @PartesDeHoras @CrearPedidoAutorizadoRiesgosFlujo41
  Scenario Outline: CrearPedidoAutorizadoRiesgosFlujo41: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario                    | pagina                | fichero_datos                                | oficina        |
      #PRE
      | Flexinet-19909 | CONTRATOS__PRORROGAS_CONSULTA | CONTRATOS__PRORROGAS/Flujo41/Flujo41.json | 451-FLX-TOLEDO |



  # ---- COMIENZO DE LOS ESCENARIOS DE CONTRATOS PRORROGAS -----

  # Resumen:
  # 1.- Se añaden 2 columnas con los últimos datos del envío
  #   - Status: Estado del envío
  #   - MSG Envío: Mensaje del envío
  # 2.- Se crea un semaforo
  #   - Rojo: La prórroga no ha sido procesada por Oracle o el envío es erróneo
  #   - Verde: La prórroga ha sido procesada correctamente
  # Precondiciones:
  # Pasos:
  # 1.- Pulsar el botón "Buscar"
  # Resultados Esperados:
  # 1.- Se visualizan 2 columnas con los últimos datos del envío
  #     - Status: Estado del envío
  #     - MSG Envío: Mensaje del envío
  # 2.- Se visliza un semaforo
  #     - Rojo: La prórroga no ha sido procesada por Oracle o el envío es erróneo
  #     - Verde: La prórroga ha sido procesada correctamente
  #TODO: Validar colores de los semaforos en este test
  @Contratos @Prorrogas @Flexinet19903 @Flujo52
  Scenario Outline: Flexinet-19903:Botón Buscar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    Then aparecen las opciones de los distintos colores del semaforos <scenario>,<pagina>,<fichero_datos>

      Examples:
        | scenario       | pagina                         | fichero_datos                                                          | oficina                |
       #UAT
        | Flexinet19903  | CONTRATOS__PRORROGAS_CONSULTA  | CONTRATOS__PRORROGAS/Flexinet19903/ContratoProrrogasConsultaVerde.json | 445-FLX-ALCALÁ HENARES |
#        | Flexinet19903  | CONTRATOS__PRORROGAS_CONSULTA  | CONTRATOS__PRORROGAS/Flexinet19903/ContratoProrrogasConsultaRojo.json  | 445-FLX-ALCALÁ HENARES |
#        | Flexinet19903  | CONTRATOS__PRORROGAS_CONSULTA  | CONTRATOS__PRORROGAS/Flexinet19903/ContratoProrrogasConsultaAzul.json  | 445-FLX-ALCALÁ HENARES |
#       PRE
#        | Flexinet19903  | CONTRATOS__PRORROGAS_CONSULTA  | CONTRATOS__PRORROGAS/Flexinet19903/ContratoProrrogasConsultaRojo.json  | 445-FLX-ALCALÁ HENARES |
##       | Flexinet19903  | CONTRATOS__PRORROGAS_CONSULTA  | CONTRATOS__PRORROGAS/Flexinet19903/ContratoProrrogasConsultaAzul.json  | 445-FLX-ALCALÁ HENARES |
#



  @Contratos @Prorrogas @Flexinet-19909 @Flujo41
      Scenario Outline: Flujo41: este flujo prueba que se visualiza el Botón Más
        Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
        And el usuario ingresa los datos del formulario de busqueda de prorroga de contrato <scenario>,<pagina>,<fichero_datos>
        When hace click en opción Buscar
        And hace click en el botón Mas
        Then selecciona el registro deseado de la tabla en el dialogo seleccion de Historico de traspasos a Oracle <scenario>,<pagina>,<fichero_datos>

        Examples:
          | scenario       | pagina                         | fichero_datos                                                          | oficina                |
          | Flexinet-19909  | CONTRATOS__PRORROGAS_CONSULTA  | CONTRATOS__PRORROGAS/Flujo41/Flujo41.json | 451-FLX-TOLEDO |
    #        | Flexinet19903  | CONTRATOS__PRORROGAS_CONSULTA  | CONTRATOS__PRORROGAS/Flexinet19903/ContratoProrrogasConsultaRojo.json  | 445-FLX-ALCALÁ HENARES |
    #        | Flexinet19903  | CONTRATOS__PRORROGAS_CONSULTA  | CONTRATOS__PRORROGAS/Flexinet19903/ContratoProrrogasConsultaAzul.json  | 445-FLX-ALCALÁ HENARES |




  # Resumen:
  # 1.- Se anula contrato (Se da de baja el contrato con fecha igual que fecha inicio y con motivo de baja 97).
  # 2.- Se envía la fecha de de fin de Prórroga
  # Precondiciones:
  # Pasos:
  # 1. Pulsar el Botón "Anular Baja"
  # Resultados Esperados:
  # 1.- Se anula la baja y se envía la fecha fin de prórroga
  #   verificar:
  #     - EXTERNAL_CPD_PRORROGA. (CD_ACCION = 'ANULA_PRORROGA_CPD'
  #     - EXTERNAL_LOG_REQUEST.
  #     - EXTERNAL_HIST_FEC.
  @Contratos @Prorrogas @Anulacion @Flexinet19902
  Scenario Outline: Flexinet-19902:Anulación
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se selecciona la lupa para buscar los datos de la empresa a filtrar y contrato <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de prorroga de contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    #Then aparecen las opciones de los distintos colores del semaforos <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario      | pagina                         | fichero_datos                                                       | oficina                |
      | Flexinet19902 | CONTRATOS__PRORROGAS_ANULACION | CONTRATOS__PRORROGAS/Flexinet19902/ContratoProrrogasAnulacion.json  | 445-FLX-ALCALÁ HENARES |


  # Resumen:
  # - En una ventana se visualiza todos los movimientos de  bajas, anulación de bajas,  prorroga y  Anulación de Prórroga
  # Precondiciones:
  # Pasos:
  # Se pulsa el botón +
  # Resultados Esperados:
  # - Se visualizan todos los movimentos e  bajas, anulación de bajas,  prorroga y  Anulación de Prórroga.
  # - Verificar que la información se extrae de la tabla de EXTERNAL_HIST_FEC


