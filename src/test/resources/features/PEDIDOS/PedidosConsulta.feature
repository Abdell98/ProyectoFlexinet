Feature: pedidos-consulta

  #Nota:
  # Ambos colaboradores tienen datos de irpf
  # @PRE @done
  @Pedidos @Consulta @Flexinet-19817 @Flexinet-19870 @Flexinet-19889
  Scenario Outline: Flexinet-19889:FLEX.INT.IN.22 Envío Altas CPD's - boton finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
#    And teniendo un pedido guardado por alta simple <scenario>,<fichero_datos>,<oficina>
    And teniendo 2 colaboradores en un pedido guardado por alta simple <scenario>,<fichero_datos>,<oficina>
    And en la página de consulta de pedidos rellena el formulario de consulta de pedidos, hace click en buscar y selecciona el registro en la tabla <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Modificar <pagina>
    And es llevado a la página de modificacion de pedidos
    When hace click en Finalizar
    Then aparece una notificacion indicando que el pedido ha sido autorizado <scenario>,<pagina>,<fichero_datos>
    And en la página de modificacion, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion de información indicando los documentos que que se han generado <scenario>,<pagina>,<fichero_datos>
#    Then aparece un dialogo con documentos listos para imprimir
    And aparece un mensaje indicando que el contrato para el colaborador ha sido generado con exito <fichero_datos>
    And ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina            | fichero_datos                                                           | oficina        |
      | Flexinet-19889 | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flexinet-19889/PedidosConsulta-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |

  #Notas:
  # Uno de los colaboradores no tiene datos de irpf
  # @PRE done
  @Pedidos @Consulta @Flexinet-19890
  Scenario Outline: Flexinet -19890:FLEX.INT.IN.22 Envío Altas CPD's uno de los contatos no se traspasa - boton finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And teniendo 2 colaboradores en un pedido guardado por alta simple <scenario>,<fichero_datos>,<oficina>
    And en la página de consulta de pedidos rellena el formulario de consulta de pedidos, hace click en buscar y selecciona el registro en la tabla <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Modificar <pagina>
    And es llevado a la página de modificacion de pedidos
    When hace click en Finalizar
    Then aparece una notificacion indicando que el pedido ha sido autorizado <scenario>,<pagina>,<fichero_datos>
#    And cierra la notificación
    And en la página de modificacion, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion de información indicando los documentos que que se han generado <scenario>,<pagina>,<fichero_datos>
#    Then aparece un dialogo con documentos listos para imprimir
    And aparece un dialogo de estado del pedido indicando que el contrato para el colaborador ha sido generado con exito pero para el segundo colaborador no se ha podido traspasar <fichero_datos>
    And ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina            | fichero_datos                                                            | oficina        |
      | Flexinet-19890 | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flexinet-19890/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |

  # @PRE @done
  #Este test crea un pedido lo guarda, luego lo busca y le da enviar a riesgos lo vuelve a buscar y genera los contratos
  @Pedidos @Consulta @Flexinet-19869
  Scenario Outline: Flexinet-19869:Pedido autorizado - boton enviar a riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And teniendo un pedido guardado por alta simple <scenario>,<fichero_datos>,<oficina>
    And en la página de consulta de pedidos rellena el formulario de consulta de pedidos, hace click en buscar y selecciona el registro en la tabla <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Modificar <pagina>
    And es llevado a la página de modificacion de pedidos
    When hace click en Enviar a Riesgos
    And aparece un mensaje indicando que el pedido ha sido autorizado por riesgos <scenario>,<pagina>,<fichero_datos>
    And es llevado a la pagina pedidos consulta donde busca el pedido <scenario>,PEDIDOS__CONSULTA,<fichero_datos>,<oficina>
    And hace click en Modificar <pagina>
    And hace click en Generar Contratos
    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,PEDIDOS__MODIFICACION,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina            | fichero_datos                                                           | oficina        |
      | Flexinet-19869 | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flexinet-19869/PedidosConsulta-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |

  #@PRE @done
  #Este test crea un pedido de alta simple, lo guarda, lo busca lo edita y le da a enviar a riesgos
  @Pedidos @Consulta @Flexinet-19866 @Flujo33
  Scenario Outline: Flexinet-19866:Pedido NO autorizado - boton enviar a riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And teniendo un pedido guardado por alta simple <scenario>,<fichero_datos>,<oficina>
    And en la página de consulta de pedidos rellena el formulario de consulta de pedidos, hace click en buscar y selecciona el registro en la tabla <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Modificar <pagina>
    When es llevado a la página de modificacion de pedidos
    And hace click en Enviar a Riesgos
    Then aparece un mensaje indicando que el pedido ha sido bloqueado por riesgos y es llevado a la pagina de consulta <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina            | fichero_datos                                                                              | oficina       |
      #UAT
      | Flexinet-19866 | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flexinet-19866/PedidosSupuestoTRANSPORTESIZALNERA-datosaltayriesgos.json | 402-FLX-CÁDIZ |

  #  Notas:
  #  - Falta una empresa que no exista en ERP
  @Pedidos @Consulta @Flexinet-19860
  Scenario Outline: Flexinet-19860:Empresa no existe - boton enviar a riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina            | fichero_datos                                         | oficina         |
      | Flexinet-19860 | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flexinet-19860/PedidosConsulta.json | 401-FLX-ALMERÍA |

  #@PRE @done
  @Pedidos @Consulta @Flexinet-19864 @Flujo36
  Scenario Outline: Flexinet-19864:Pedido NO autorizado - boton finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And teniendo un pedido guardado por alta simple <scenario>,<fichero_datos>,<oficina>
    And en la página de consulta de pedidos rellena el formulario de consulta de pedidos, hace click en buscar y selecciona el registro en la tabla <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Modificar <pagina>
    And es llevado a la página de modificacion de pedidos
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
      | scenario       | pagina            | fichero_datos                                                                              | oficina       |
      #UAT
      | Flexinet-19864 | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flexinet-19864/PedidosSupuestoTRANSPORTESIZALNERA-datosaltayriesgos.json | 402-FLX-CÁDIZ |

  #  Notas:
  #  - Falta una empresa que no exista en ERP
  @Pedidos @Consulta @Flexinet-19863
  Scenario Outline: Flexinet-19863:Empresa no existe - boton finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina            | fichero_datos                                         | oficina         |
      | Flexinet-19863 | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flexinet-19863/PedidosConsulta.json | 401-FLX-ALMERÍA |


  @Pedidos @Consulta @Flujo1X
  Scenario Outline: Flujo1X: Este escenario solo pretende eliminar un pedido
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    When hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And filtra y selecciona un resultado de la pagina PEDIDOS__CONSULTA ubicado en CURRENTPAGE,<scenario>,<fichero_datos>
    Then hace click en el botón BTN_ELIMINAR ubicado en CURRENTPAGE true
    Then hace click en el botón BTN_ACEPTAR ubicado en DIALOG_ELIMINACIONDEPEDIDO false
    Then el usuario comprueba que sale la notificación del tipo INFORMACION con el mensaje No se ha obtenido resultados

    Examples:
      | scenario | pagina            | fichero_datos                                                                                                                                                                             | oficina        |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604610799;pedidosConsulta->tableEmpresa->qbe_nPedido:604610799;pedidosConsulta->tableEmpresa->nPedido:604610799 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611730;pedidosConsulta->tableEmpresa->qbe_nPedido:604611730;pedidosConsulta->tableEmpresa->nPedido:604611730 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611732;pedidosConsulta->tableEmpresa->qbe_nPedido:604611732;pedidosConsulta->tableEmpresa->nPedido:604611732 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611733;pedidosConsulta->tableEmpresa->qbe_nPedido:604611733;pedidosConsulta->tableEmpresa->nPedido:604611733 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611734;pedidosConsulta->tableEmpresa->qbe_nPedido:604611734;pedidosConsulta->tableEmpresa->nPedido:604611734 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611735;pedidosConsulta->tableEmpresa->qbe_nPedido:604611735;pedidosConsulta->tableEmpresa->nPedido:604611735 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611736;pedidosConsulta->tableEmpresa->qbe_nPedido:604611736;pedidosConsulta->tableEmpresa->nPedido:604611736 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611738;pedidosConsulta->tableEmpresa->qbe_nPedido:604611738;pedidosConsulta->tableEmpresa->nPedido:604611738 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611739;pedidosConsulta->tableEmpresa->qbe_nPedido:604611739;pedidosConsulta->tableEmpresa->nPedido:604611739 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611741;pedidosConsulta->tableEmpresa->qbe_nPedido:604611741;pedidosConsulta->tableEmpresa->nPedido:604611741 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611742;pedidosConsulta->tableEmpresa->qbe_nPedido:604611742;pedidosConsulta->tableEmpresa->nPedido:604611742 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611744;pedidosConsulta->tableEmpresa->qbe_nPedido:604611744;pedidosConsulta->tableEmpresa->nPedido:604611744 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611745;pedidosConsulta->tableEmpresa->qbe_nPedido:604611745;pedidosConsulta->tableEmpresa->nPedido:604611745 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611755;pedidosConsulta->tableEmpresa->qbe_nPedido:604611755;pedidosConsulta->tableEmpresa->nPedido:604611755 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611759;pedidosConsulta->tableEmpresa->qbe_nPedido:604611759;pedidosConsulta->tableEmpresa->nPedido:604611759 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611760;pedidosConsulta->tableEmpresa->qbe_nPedido:604611760;pedidosConsulta->tableEmpresa->nPedido:604611760 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611761;pedidosConsulta->tableEmpresa->qbe_nPedido:604611761;pedidosConsulta->tableEmpresa->nPedido:604611761 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611787;pedidosConsulta->tableEmpresa->qbe_nPedido:604611787;pedidosConsulta->tableEmpresa->nPedido:604611787 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611789;pedidosConsulta->tableEmpresa->qbe_nPedido:604611789;pedidosConsulta->tableEmpresa->nPedido:604611789 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611791;pedidosConsulta->tableEmpresa->qbe_nPedido:604611791;pedidosConsulta->tableEmpresa->nPedido:604611791 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611792;pedidosConsulta->tableEmpresa->qbe_nPedido:604611792;pedidosConsulta->tableEmpresa->nPedido:604611792 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611793;pedidosConsulta->tableEmpresa->qbe_nPedido:604611793;pedidosConsulta->tableEmpresa->nPedido:604611793 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611794;pedidosConsulta->tableEmpresa->qbe_nPedido:604611794;pedidosConsulta->tableEmpresa->nPedido:604611794 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611795;pedidosConsulta->tableEmpresa->qbe_nPedido:604611795;pedidosConsulta->tableEmpresa->nPedido:604611795 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611796;pedidosConsulta->tableEmpresa->qbe_nPedido:604611796;pedidosConsulta->tableEmpresa->nPedido:604611796 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611797;pedidosConsulta->tableEmpresa->qbe_nPedido:604611797;pedidosConsulta->tableEmpresa->nPedido:604611797 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611798;pedidosConsulta->tableEmpresa->qbe_nPedido:604611798;pedidosConsulta->tableEmpresa->nPedido:604611798 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611799;pedidosConsulta->tableEmpresa->qbe_nPedido:604611799;pedidosConsulta->tableEmpresa->nPedido:604611799 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611801;pedidosConsulta->tableEmpresa->qbe_nPedido:604611801;pedidosConsulta->tableEmpresa->nPedido:604611801 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611802;pedidosConsulta->tableEmpresa->qbe_nPedido:604611802;pedidosConsulta->tableEmpresa->nPedido:604611802 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611803;pedidosConsulta->tableEmpresa->qbe_nPedido:604611803;pedidosConsulta->tableEmpresa->nPedido:604611803 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611805;pedidosConsulta->tableEmpresa->qbe_nPedido:604611805;pedidosConsulta->tableEmpresa->nPedido:604611805 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611806;pedidosConsulta->tableEmpresa->qbe_nPedido:604611806;pedidosConsulta->tableEmpresa->nPedido:604611806 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611807;pedidosConsulta->tableEmpresa->qbe_nPedido:604611807;pedidosConsulta->tableEmpresa->nPedido:604611807 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611808;pedidosConsulta->tableEmpresa->qbe_nPedido:604611808;pedidosConsulta->tableEmpresa->nPedido:604611808 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611809;pedidosConsulta->tableEmpresa->qbe_nPedido:604611809;pedidosConsulta->tableEmpresa->nPedido:604611809 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611810;pedidosConsulta->tableEmpresa->qbe_nPedido:604611810;pedidosConsulta->tableEmpresa->nPedido:604611810 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611811;pedidosConsulta->tableEmpresa->qbe_nPedido:604611811;pedidosConsulta->tableEmpresa->nPedido:604611811 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611812;pedidosConsulta->tableEmpresa->qbe_nPedido:604611812;pedidosConsulta->tableEmpresa->nPedido:604611812 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611813;pedidosConsulta->tableEmpresa->qbe_nPedido:604611813;pedidosConsulta->tableEmpresa->nPedido:604611813 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611814;pedidosConsulta->tableEmpresa->qbe_nPedido:604611814;pedidosConsulta->tableEmpresa->nPedido:604611814 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611815;pedidosConsulta->tableEmpresa->qbe_nPedido:604611815;pedidosConsulta->tableEmpresa->nPedido:604611815 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611817;pedidosConsulta->tableEmpresa->qbe_nPedido:604611817;pedidosConsulta->tableEmpresa->nPedido:604611817 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611821;pedidosConsulta->tableEmpresa->qbe_nPedido:604611821;pedidosConsulta->tableEmpresa->nPedido:604611821 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611826;pedidosConsulta->tableEmpresa->qbe_nPedido:604611826;pedidosConsulta->tableEmpresa->nPedido:604611826 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611827;pedidosConsulta->tableEmpresa->qbe_nPedido:604611827;pedidosConsulta->tableEmpresa->nPedido:604611827 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611828;pedidosConsulta->tableEmpresa->qbe_nPedido:604611828;pedidosConsulta->tableEmpresa->nPedido:604611828 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611829;pedidosConsulta->tableEmpresa->qbe_nPedido:604611829;pedidosConsulta->tableEmpresa->nPedido:604611829 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611830;pedidosConsulta->tableEmpresa->qbe_nPedido:604611830;pedidosConsulta->tableEmpresa->nPedido:604611830 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611831;pedidosConsulta->tableEmpresa->qbe_nPedido:604611831;pedidosConsulta->tableEmpresa->nPedido:604611831 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611833;pedidosConsulta->tableEmpresa->qbe_nPedido:604611833;pedidosConsulta->tableEmpresa->nPedido:604611833 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611835;pedidosConsulta->tableEmpresa->qbe_nPedido:604611835;pedidosConsulta->tableEmpresa->nPedido:604611835 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611836;pedidosConsulta->tableEmpresa->qbe_nPedido:604611836;pedidosConsulta->tableEmpresa->nPedido:604611836 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611837;pedidosConsulta->tableEmpresa->qbe_nPedido:604611837;pedidosConsulta->tableEmpresa->nPedido:604611837 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611838;pedidosConsulta->tableEmpresa->qbe_nPedido:604611838;pedidosConsulta->tableEmpresa->nPedido:604611838 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611839;pedidosConsulta->tableEmpresa->qbe_nPedido:604611839;pedidosConsulta->tableEmpresa->nPedido:604611839 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611840;pedidosConsulta->tableEmpresa->qbe_nPedido:604611840;pedidosConsulta->tableEmpresa->nPedido:604611840 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611841;pedidosConsulta->tableEmpresa->qbe_nPedido:604611841;pedidosConsulta->tableEmpresa->nPedido:604611841 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611842;pedidosConsulta->tableEmpresa->qbe_nPedido:604611842;pedidosConsulta->tableEmpresa->nPedido:604611842 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611843;pedidosConsulta->tableEmpresa->qbe_nPedido:604611843;pedidosConsulta->tableEmpresa->nPedido:604611843 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611844;pedidosConsulta->tableEmpresa->qbe_nPedido:604611844;pedidosConsulta->tableEmpresa->nPedido:604611844 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611845;pedidosConsulta->tableEmpresa->qbe_nPedido:604611845;pedidosConsulta->tableEmpresa->nPedido:604611845 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611846;pedidosConsulta->tableEmpresa->qbe_nPedido:604611846;pedidosConsulta->tableEmpresa->nPedido:604611846 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611898;pedidosConsulta->tableEmpresa->qbe_nPedido:604611898;pedidosConsulta->tableEmpresa->nPedido:604611898 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611899;pedidosConsulta->tableEmpresa->qbe_nPedido:604611899;pedidosConsulta->tableEmpresa->nPedido:604611899 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611908;pedidosConsulta->tableEmpresa->qbe_nPedido:604611908;pedidosConsulta->tableEmpresa->nPedido:604611908 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611909;pedidosConsulta->tableEmpresa->qbe_nPedido:604611909;pedidosConsulta->tableEmpresa->nPedido:604611909 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611912;pedidosConsulta->tableEmpresa->qbe_nPedido:604611912;pedidosConsulta->tableEmpresa->nPedido:604611912 | 451-FLX-TOLEDO |
#      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611914;pedidosConsulta->tableEmpresa->qbe_nPedido:604611914;pedidosConsulta->tableEmpresa->nPedido:604611914 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611915;pedidosConsulta->tableEmpresa->qbe_nPedido:604611915;pedidosConsulta->tableEmpresa->nPedido:604611915 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611916;pedidosConsulta->tableEmpresa->qbe_nPedido:604611916;pedidosConsulta->tableEmpresa->nPedido:604611916 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611917;pedidosConsulta->tableEmpresa->qbe_nPedido:604611917;pedidosConsulta->tableEmpresa->nPedido:604611917 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611918;pedidosConsulta->tableEmpresa->qbe_nPedido:604611918;pedidosConsulta->tableEmpresa->nPedido:604611918 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611919;pedidosConsulta->tableEmpresa->qbe_nPedido:604611919;pedidosConsulta->tableEmpresa->nPedido:604611919 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611920;pedidosConsulta->tableEmpresa->qbe_nPedido:604611920;pedidosConsulta->tableEmpresa->nPedido:604611920 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611921;pedidosConsulta->tableEmpresa->qbe_nPedido:604611921;pedidosConsulta->tableEmpresa->nPedido:604611921 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611922;pedidosConsulta->tableEmpresa->qbe_nPedido:604611922;pedidosConsulta->tableEmpresa->nPedido:604611922 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611923;pedidosConsulta->tableEmpresa->qbe_nPedido:604611923;pedidosConsulta->tableEmpresa->nPedido:604611923 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611924;pedidosConsulta->tableEmpresa->qbe_nPedido:604611924;pedidosConsulta->tableEmpresa->nPedido:604611924 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611925;pedidosConsulta->tableEmpresa->qbe_nPedido:604611925;pedidosConsulta->tableEmpresa->nPedido:604611925 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611926;pedidosConsulta->tableEmpresa->qbe_nPedido:604611926;pedidosConsulta->tableEmpresa->nPedido:604611926 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611927;pedidosConsulta->tableEmpresa->qbe_nPedido:604611927;pedidosConsulta->tableEmpresa->nPedido:604611927 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611928;pedidosConsulta->tableEmpresa->qbe_nPedido:604611928;pedidosConsulta->tableEmpresa->nPedido:604611928 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611929;pedidosConsulta->tableEmpresa->qbe_nPedido:604611929;pedidosConsulta->tableEmpresa->nPedido:604611929 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611930;pedidosConsulta->tableEmpresa->qbe_nPedido:604611930;pedidosConsulta->tableEmpresa->nPedido:604611930 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611931;pedidosConsulta->tableEmpresa->qbe_nPedido:604611931;pedidosConsulta->tableEmpresa->nPedido:604611931 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611932;pedidosConsulta->tableEmpresa->qbe_nPedido:604611932;pedidosConsulta->tableEmpresa->nPedido:604611932 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611933;pedidosConsulta->tableEmpresa->qbe_nPedido:604611933;pedidosConsulta->tableEmpresa->nPedido:604611933 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611934;pedidosConsulta->tableEmpresa->qbe_nPedido:604611934;pedidosConsulta->tableEmpresa->nPedido:604611934 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611935;pedidosConsulta->tableEmpresa->qbe_nPedido:604611935;pedidosConsulta->tableEmpresa->nPedido:604611935 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611936;pedidosConsulta->tableEmpresa->qbe_nPedido:604611936;pedidosConsulta->tableEmpresa->nPedido:604611936 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611937;pedidosConsulta->tableEmpresa->qbe_nPedido:604611937;pedidosConsulta->tableEmpresa->nPedido:604611937 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611938;pedidosConsulta->tableEmpresa->qbe_nPedido:604611938;pedidosConsulta->tableEmpresa->nPedido:604611938 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611939;pedidosConsulta->tableEmpresa->qbe_nPedido:604611939;pedidosConsulta->tableEmpresa->nPedido:604611939 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611940;pedidosConsulta->tableEmpresa->qbe_nPedido:604611940;pedidosConsulta->tableEmpresa->nPedido:604611940 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611941;pedidosConsulta->tableEmpresa->qbe_nPedido:604611941;pedidosConsulta->tableEmpresa->nPedido:604611941 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611943;pedidosConsulta->tableEmpresa->qbe_nPedido:604611943;pedidosConsulta->tableEmpresa->nPedido:604611943 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611971;pedidosConsulta->tableEmpresa->qbe_nPedido:604611971;pedidosConsulta->tableEmpresa->nPedido:604611971 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611972;pedidosConsulta->tableEmpresa->qbe_nPedido:604611972;pedidosConsulta->tableEmpresa->nPedido:604611972 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611974;pedidosConsulta->tableEmpresa->qbe_nPedido:604611974;pedidosConsulta->tableEmpresa->nPedido:604611974 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611975;pedidosConsulta->tableEmpresa->qbe_nPedido:604611975;pedidosConsulta->tableEmpresa->nPedido:604611975 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611976;pedidosConsulta->tableEmpresa->qbe_nPedido:604611976;pedidosConsulta->tableEmpresa->nPedido:604611976 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611977;pedidosConsulta->tableEmpresa->qbe_nPedido:604611977;pedidosConsulta->tableEmpresa->nPedido:604611977 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611979;pedidosConsulta->tableEmpresa->qbe_nPedido:604611979;pedidosConsulta->tableEmpresa->nPedido:604611979 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611980;pedidosConsulta->tableEmpresa->qbe_nPedido:604611980;pedidosConsulta->tableEmpresa->nPedido:604611980 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611981;pedidosConsulta->tableEmpresa->qbe_nPedido:604611981;pedidosConsulta->tableEmpresa->nPedido:604611981 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611982;pedidosConsulta->tableEmpresa->qbe_nPedido:604611982;pedidosConsulta->tableEmpresa->nPedido:604611982 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611983;pedidosConsulta->tableEmpresa->qbe_nPedido:604611983;pedidosConsulta->tableEmpresa->nPedido:604611983 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611984;pedidosConsulta->tableEmpresa->qbe_nPedido:604611984;pedidosConsulta->tableEmpresa->nPedido:604611984 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611985;pedidosConsulta->tableEmpresa->qbe_nPedido:604611985;pedidosConsulta->tableEmpresa->nPedido:604611985 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611988;pedidosConsulta->tableEmpresa->qbe_nPedido:604611988;pedidosConsulta->tableEmpresa->nPedido:604611988 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611989;pedidosConsulta->tableEmpresa->qbe_nPedido:604611989;pedidosConsulta->tableEmpresa->nPedido:604611989 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611990;pedidosConsulta->tableEmpresa->qbe_nPedido:604611990;pedidosConsulta->tableEmpresa->nPedido:604611990 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611992;pedidosConsulta->tableEmpresa->qbe_nPedido:604611992;pedidosConsulta->tableEmpresa->nPedido:604611992 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604611993;pedidosConsulta->tableEmpresa->qbe_nPedido:604611993;pedidosConsulta->tableEmpresa->nPedido:604611993 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612047;pedidosConsulta->tableEmpresa->qbe_nPedido:604612047;pedidosConsulta->tableEmpresa->nPedido:604612047 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612050;pedidosConsulta->tableEmpresa->qbe_nPedido:604612050;pedidosConsulta->tableEmpresa->nPedido:604612050 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612051;pedidosConsulta->tableEmpresa->qbe_nPedido:604612051;pedidosConsulta->tableEmpresa->nPedido:604612051 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612052;pedidosConsulta->tableEmpresa->qbe_nPedido:604612052;pedidosConsulta->tableEmpresa->nPedido:604612052 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612056;pedidosConsulta->tableEmpresa->qbe_nPedido:604612056;pedidosConsulta->tableEmpresa->nPedido:604612056 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612057;pedidosConsulta->tableEmpresa->qbe_nPedido:604612057;pedidosConsulta->tableEmpresa->nPedido:604612057 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612062;pedidosConsulta->tableEmpresa->qbe_nPedido:604612062;pedidosConsulta->tableEmpresa->nPedido:604612062 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612063;pedidosConsulta->tableEmpresa->qbe_nPedido:604612063;pedidosConsulta->tableEmpresa->nPedido:604612063 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612064;pedidosConsulta->tableEmpresa->qbe_nPedido:604612064;pedidosConsulta->tableEmpresa->nPedido:604612064 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612092;pedidosConsulta->tableEmpresa->qbe_nPedido:604612092;pedidosConsulta->tableEmpresa->nPedido:604612092 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612093;pedidosConsulta->tableEmpresa->qbe_nPedido:604612093;pedidosConsulta->tableEmpresa->nPedido:604612093 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612094;pedidosConsulta->tableEmpresa->qbe_nPedido:604612094;pedidosConsulta->tableEmpresa->nPedido:604612094 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612095;pedidosConsulta->tableEmpresa->qbe_nPedido:604612095;pedidosConsulta->tableEmpresa->nPedido:604612095 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612096;pedidosConsulta->tableEmpresa->qbe_nPedido:604612096;pedidosConsulta->tableEmpresa->nPedido:604612096 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612102;pedidosConsulta->tableEmpresa->qbe_nPedido:604612102;pedidosConsulta->tableEmpresa->nPedido:604612102 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612125;pedidosConsulta->tableEmpresa->qbe_nPedido:604612125;pedidosConsulta->tableEmpresa->nPedido:604612125 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612199;pedidosConsulta->tableEmpresa->qbe_nPedido:604612199;pedidosConsulta->tableEmpresa->nPedido:604612199 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612221;pedidosConsulta->tableEmpresa->qbe_nPedido:604612221;pedidosConsulta->tableEmpresa->nPedido:604612221 | 451-FLX-TOLEDO |
      #| Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612248;pedidosConsulta->tableEmpresa->qbe_nPedido:604612248;pedidosConsulta->tableEmpresa->nPedido:604612248 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612256;pedidosConsulta->tableEmpresa->qbe_nPedido:604612256;pedidosConsulta->tableEmpresa->nPedido:604612256 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612257;pedidosConsulta->tableEmpresa->qbe_nPedido:604612257;pedidosConsulta->tableEmpresa->nPedido:604612257 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612258;pedidosConsulta->tableEmpresa->qbe_nPedido:604612258;pedidosConsulta->tableEmpresa->nPedido:604612258 | 451-FLX-TOLEDO |
      | Flujo1X  | PEDIDOS__CONSULTA | PEDIDOS__CONSULTA/Flujo1X/Flujo1X.json;pedidosConsulta->nPedido:604612260;pedidosConsulta->tableEmpresa->qbe_nPedido:604612260;pedidosConsulta->tableEmpresa->nPedido:604612260 | 451-FLX-TOLEDO |

