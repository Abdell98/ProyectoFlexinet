Feature: pedidos-alta-simple

  # Notas:
  #  - Falta una empresa que no exista en ERP
  @Pedidos @AltaSimple @Flexinet-19834 @Flujo1
  Scenario Outline: Flexinet-19834:Empresa no existe - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    Then ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina               | fichero_datos                                                     | oficina        |
      | Flexinet-19834 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19834/PedidosSupuestoATOPOXDOX.json | 451-FLX-TOLEDO |

  #14/06/2024 @PRE @DONE en pre este escenario da OK con el fichero de datos asociado
  #18/06/2024 @PRE @DONE si se hace el ultimo paso de verificar en base de datos en la tabla EXTERNAL_CPD_ENVIO entonces este test cubre también el Flexinet-19809
  # -  para el test Flexinet-19809 hay que cambiar las fechas fechaPrevistaDeInicio = %TODAY%,fechaPrevistaDeFin = %PLUS5%,introduzcaLaFechaDeAntiguedadDelContrato = fechaPrevistaDeInicio
  # - este ultimo paso solo es valido en @UAT dado que es donde existe la tabla EXTERNAL_CPD_ENVIO pendiente de implementear
  #DUDAS RESUELTAS:
  # - El Flexinet19809 y el Flexinet19816 y Flexinet19810,Flexinet19885  son iguales salvo por la página?
  #  -  R: si son los mismos
  # - Para este test si el pedido es bloqueado por riesgos y luego lo desbloqueamos es valido el test?
  #  -  R: es valido, pero hemos ajustado el test con datos que no sea bloqueado por riesgos para ser mas fidedigno al test, para el otro caso hemos hecho el test 809-desbloqueoManual.
  #@PRE @done
  @Pedidos @AltaSimple @Flexinet-19809 @Flexinet-19756 @Flujo2
  Scenario Outline: Flexinet-19756:Pedido autorizado - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    And rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    When hace click en Finalizar
    Then aparece una notificacion indicando que el pedido ha sido autorizado <scenario>,<pagina>,<fichero_datos>
    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                                     | oficina         |
#      #PRE
      | Flexinet-19756 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19756/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |
    #UAT
#      | Flexinet-19756 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19756/{PENDIENTE EMPRESA}.json | {OFICINA PENDIENTE} |

  # Este escenario cubre el 19757 y también el 19809 en caso de que haya que desbloquear un pedido bloqueado.
  # @PRE @done
  @Pedidos @AltaSimple @Flexinet-19809 @Flexinet-19757 @Flujo3
  Scenario Outline: Flexinet-19757:Pedido NO autorizado - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    When rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And hace click en Finalizar
    Then aparece un mensaje indicando que el pedido ha sido bloqueado por riesgos y es llevado a la pagina de consulta <scenario>,<pagina>,<fichero_datos>
    And se dirige al menu riesgos, gestion de pedidos bloqueados, donde busca y desbloquea el registro <scenario>,<pagina>,<fichero_datos>,<oficina>
    And se dirige a la pagina pedidos consulta y busca el pedido por su numero <scenario>,<pagina>,<fichero_datos>,<oficina>
    When hace click en Modificar <pagina>
    And es redirigido a la página de modificación de pedidos donde hace click en Generar Contratos
    And en la página de modificacion, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina        |
      #PRE
      #      | Flexinet-19757 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19757/PedidosSupuestoBGAMESTOREIBERIA-datosaltayriesgos.json | 439-FLX-MADRID 1 |
      #UAT
      | Flexinet-19757 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19757/PedidosSupuestoTRANSPORTESIZALNERA-datosaltayriesgos.json | 402-FLX-CÁDIZ |

  #  Notas:
  #  - Falta una empresa que no exista en ERP
  @Pedidos @AltaSimple @Flexinet-19836 @Flujo4
  Scenario Outline: Flexinet-19836:Empresa no existe - Boton Enviar a Riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    Then ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina        |
      | Flexinet-19836 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19836/PedidosSupuestoA.json | 451-FLX-TOLEDO |

  #@PRE @done
  @Pedidos @AltaSimple @btnEnviarARiesgos @Flexinet-19759 @Flujo5
  Scenario Outline: Flexinet-19759:Pedido NO autorizado - Boton Enviar a Riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    When rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And hace click en Enviar a Riesgos
    Then aparece un mensaje indicando que el pedido ha sido bloqueado por riesgos y es llevado a la pagina de consulta <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                                                             | oficina        |
#      #PRE
#      | Flexinet-19759 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19757/PedidosSupuestoBGAMESTOREIBERIA-datosaltayriesgos.json | 439-FLX-MADRID 1 |
#      UAT
      | Flexinet-19759 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19757/PedidosSupuestoTRANSPORTESIZALNERA-datosaltayriesgos.json | 402-FLX-CÁDIZ |

  #@PRE @done
  @Pedidos @AltaSimple @Flexinet-19758 @Flujo6
  Scenario Outline: Flexinet-19758:Pedido autorizado - Boton Enviar a Riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    And rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    When hace click en Enviar a Riesgos
    And aparece un mensaje indicando que el pedido ha sido autorizado por riesgos <scenario>,<pagina>,<fichero_datos>
    And es llevado a la pagina pedidos consulta donde busca el pedido <scenario>,PEDIDOS__CONSULTA,<fichero_datos>,<oficina>
    And hace click en Modificar <pagina>
    And hace click en Generar Contratos
    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,PEDIDOS__MODIFICACION,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                                           | oficina        |
      #PRE
      | Flexinet-19758 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19758/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |


  # Notas:
  # - necesario colaborador que no tenga datos irpf
  #@PRE @done
  @Pedidos @AltaSimple @BloqueoRiesgos @Flexinet-19895 @Flujo8
  Scenario Outline:  Flexinet-19895:FLEX.INT.IN.22 No todos los CPDs se traspasan al SGC - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    And rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And se añade un segundo colaborador <scenario>,<pagina>,<fichero_datos>
    When hace click en Finalizar
    Then aparece una notificacion indicando que el pedido ha sido autorizado <scenario>,<pagina>,<fichero_datos>
    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece notificacion, dialogo de documentos a imprimir y dialogo informando contratos generados con exito pero uno de ellos sin traspasar <scenario>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina         |
      #PRE
      | Flexinet-19895 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19895/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |


  # Notas:
  # - necesario que los 2 colaboradores tengan informacion irpf
  #@PRE @done
  @Pedidos @AltaSimple @Flexinet-19885 @Flujo9
  Scenario Outline: Flexinet-19885:FLEX.INT.IN.22 Todos los CPDs se traspasan a Oracle
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    And rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And se añade un segundo colaborador <scenario>,<pagina>,<fichero_datos>
    When hace click en Finalizar
    Then aparece una notificacion indicando que el pedido ha sido autorizado <scenario>,<pagina>,<fichero_datos>
    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina         |
      #PRE
      | Flexinet-19885 | PEDIDOS__ALTA_SIMPLE | PEDIDOS__ALTA_SIMPLE/Flexinet-19885/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |
