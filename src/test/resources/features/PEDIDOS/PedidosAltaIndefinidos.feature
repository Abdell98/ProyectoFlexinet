Feature: pedidos-alta-indefinidos


  #Notas:
  # Este escenario cubre mas de 1 test de testlink
  # - Pendiente de tener una empresa que no exista
  @Pedidos @AltaIndefinidos @btnFinalizar @Flexinet-19841 @Flexinet-19840 @Flujo10
  Scenario Outline: Flexinet-19841:Empresa no existe - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    Then ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina                    | fichero_datos                                                  | oficina        |
      | Flexinet-19841 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19841/PedidosSupuestoA.json | 451-FLX-TOLEDO |



  #@PRE @done
  @Pedidos @AltaIndefinidos @btnFinalizar @Flexinet-19761 @Flujo12
  Scenario Outline: Flexinet-19761:Pedido NO autorizado - Boton Finalizar
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
      | scenario       | pagina                    | fichero_datos                                                  | oficina        |
#       #PRE
#      | Flexinet-19761 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19761/PedidosSupuestoBGAMESTOREIBERIA-datosaltayriesgos.json | 439-FLX-MADRID 1 |
      #UAT
      | Flexinet-19761 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19761/PedidosSupuestoTRANSPORTESIZALNERA-datosaltayriesgos.json | 402-FLX-CÁDIZ |

  #Nota:
  # - este escenario subre 2 tests de testlink
  #@PRE @done
  @Pedidos @AltaIndefinidos @btnFinalizar @Flexinet-19810 @Flexinet-19760 @Flujo11
  Scenario Outline: Flexinet-19760:Pedido autorizado - Boton Finalizar
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
      | scenario       | pagina                    | fichero_datos                                                  | oficina         |
      | Flexinet-19760 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19760/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |

#  #Notas:
#  #20/08/2024 - Roberto nos indica de que descartemos los test de enviar a riesgos en indefinidos porque no existe el botón
#  # - Pendiente de tener una empresa que no exista
#  @Pedidos @AltaIndefinidos @btnEnviarARiesgos @Flexinet-19835
#  Scenario Outline: Flexinet-19835:Empresa no existe - Boton Enviar a Riesgos
#    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
#    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
#    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
#    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
#    And hace click en Asociar a Empresa
#    When rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
#    And hace click en Enviar a Riesgos
#    Then ....PASOS PENDIENTES DE IMPLEMENTAR....
#
#    Examples:
#      | scenario       | pagina                    | fichero_datos                                                  | oficina        |
#      | Flexinet-19835 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19835/PedidosSupuestoA.json | 451-FLX-TOLEDO |

  #20/08/2024 - Roberto nos indica de que descartemos los test de enviar a riesgos en indefinidos porque no existe el botón
  #@PRE @done
#  @Pedidos @AltaIndefinidos @btnEnviarARiesgos @Flexinet-19765
#  Scenario Outline: Flexinet-19765:Pedido autorizado - Boton Enviar a Riesgos
#    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
#    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
#    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
#    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
#    And hace click en Asociar a Empresa
#    And rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
#    When hace click en Enviar a Riesgos
#    And aparece un mensaje indicando que el pedido ha sido autorizado por riesgos <scenario>,<pagina>,<fichero_datos>
#    And es llevado a la pagina pedidos consulta donde busca el pedido <scenario>,PEDIDOS__CONSULTA,<fichero_datos>,<oficina>
#    And hace click en Modificar <pagina>
#    And hace click en Generar Contratos
#    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,PEDIDOS__MODIFICACION,<fichero_datos>,<oficina>
#    And hace click en Si
#    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>
#
#    Examples:
#      | scenario       | pagina                    | fichero_datos                                                  | oficina         |
#      | Flexinet-19765 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19765/PedidosSupuestoB-BEBECARESPAÑOLASL-datosaltayconsulta.json | 451-FLX-TOLEDO |

#  #20/08/2024 - Roberto nos indica de que descartemos los test de enviar a riesgos en indefinidos porque no existe el botón
#  #@PRE @done
#  @Pedidos @AltaIndefinidos @btnEnviarARiesgos @Flexinet-19762
#  Scenario Outline: Flexinet-19762:Pedido NO autorizado - Boton Enviar a Riesgos
#    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
#    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
#    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
#    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
#    And hace click en Asociar a Empresa
#    When rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
#    And hace click en Enviar a Riesgos
#    Then aparece un mensaje indicando que el pedido ha sido bloqueado por riesgos y es llevado a la pagina de consulta <scenario>,<pagina>,<fichero_datos>
#
#    Examples:
#      | scenario       | pagina                    | fichero_datos                                                  | oficina        |
#      | Flexinet-19762 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19762/PedidosSupuestoBTOPOXDOX170624-datosaltayriesgos.json | 439-FLX-MADRID 1 |
#

  # Notas:
  # - necesario que los 2 colaboradores tengan informacion irpf
  #@PRE @done
  @Pedidos @AltaIndefinidos @BloqueoRiesgos @btnFinalizar @Flexinet-19887 @Flujo19
  Scenario Outline: Flexinet-19887:FLEX.INT.IN.22 Todos los CPDs se traspasan al SGC - Boton Finalizar
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
      | scenario       | pagina                    | fichero_datos                                                  | oficina        |
      | Flexinet-19887 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19887/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |


  #@PRE @done
  @Pedidos @AltaIndefinidos @BloqueoRiesgos @btnFinalizar @Flexinet-19888 @Flujo20
  Scenario Outline: Flexinet-19888:FLEX.INT.IN.22 No todos los CPDs se traspasan al SGC - Boton Finalizar
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
      | scenario       | pagina                    | fichero_datos                                                  | oficina        |
      | Flexinet-19888 | PEDIDOS__ALTA_INDEFINIDOS | PEDIDOS__ALTA_INDEFINIDOS/Flexinet-19888/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |

