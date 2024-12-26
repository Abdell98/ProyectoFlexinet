Feature: pedidos-alta-LV3233

  # #@PRE @done
  @Pedidos @AltaLV3233 @btnFinalizar @Flexinet-19862 @Flujo22
  Scenario Outline: Flexinet-19862:Pedido NO autorizado - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    When rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And además rellena deglose de categoria profesional en datos de tarifa <scenario>,<pagina>,<fichero_datos>
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
      #UAT
      | Flexinet-19862 | PEDIDOS__ALTA_LV3233 | PEDIDOS__ALTA_LV3233/Flexinet-19862/Flujo22.json | 402-FLX-CÁDIZ |


  # Notas:
  #  - Falta una empresa para probar
  #   - R: Nos indican que de momento lo dejemos de lado que no es tan importante
  @Pedidos @AltaLV3233 @btnFinalizar @Flexinet-19842
  Scenario Outline: Flexinet-19842:Empresa no existe - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    Then ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina        |
      | Flexinet-19842 | PEDIDOS__ALTA_LV3233 | PEDIDOS__ALTA_LV3233/Flexinet-19842/PedidosSupuestoA.json | 451-FLX-TOLEDO |

  # Nota:
  # - Este escenario cubre los tests @Flexinet-19816 @Flexinet-19767
  # @PRE @done
  @Pedidos @AltaLV3233 @btnFinalizar @Flexinet-19816 @Flexinet-19767 @Flujo24
  Scenario Outline: Flexinet-19767:Pedido autorizado - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    And rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And además rellena deglose de categoria profesional en datos de tarifa <scenario>,<pagina>,<fichero_datos>
    When hace click en Finalizar
    Then aparece una notificacion indicando que el pedido ha sido autorizado <scenario>,<pagina>,<fichero_datos>
    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina         |
      | Flexinet-19767 | PEDIDOS__ALTA_LV3233 | PEDIDOS__ALTA_LV3233/Flexinet-19767/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |

  #@PRE @done
  @Pedidos @AltaLV3233 @btnEnviarARiesgos @Flexinet-19861 @Flujo25
  Scenario Outline: Flexinet-19861:Pedido NO autorizado - Boton Enviar a Riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    When rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And además rellena deglose de categoria profesional en datos de tarifa <scenario>,<pagina>,<fichero_datos>
    And hace click en Enviar a Riesgos
    Then aparece un mensaje indicando que el pedido ha sido bloqueado por riesgos y es llevado a la pagina de consulta <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina        |
      | Flexinet-19861 | PEDIDOS__ALTA_LV3233 | PEDIDOS__ALTA_LV3233/Flexinet-19861/PedidosSupuestoTRANSPORTESIZALNERA-datosaltayriesgos.json | 402-FLX-CÁDIZ |

  #@PRE @done
  @Pedidos @AltaLV3233 @btnEnviarARiesgos @Flexinet-19846
  Scenario Outline: Flexinet-19846:Pedido autorizado - Boton Enviar a Riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    When rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And además rellena deglose de categoria profesional en datos de tarifa <scenario>,<pagina>,<fichero_datos>
    And hace click en Enviar a Riesgos
    And aparece un mensaje indicando que el pedido ha sido autorizado por riesgos <scenario>,<pagina>,<fichero_datos>
    And es llevado a la pagina pedidos consulta donde busca el pedido <scenario>,PEDIDOS__CONSULTA,<fichero_datos>,<oficina>
    And hace click en Modificar <pagina>
    And hace click en Generar Contratos
    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,PEDIDOS__MODIFICACION,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina         |
      | Flexinet-19846 | PEDIDOS__ALTA_LV3233 | PEDIDOS__ALTA_LV3233/Flexinet-19846/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |



  # Notas:
  #  - Falta una empresa para probar
  #   - R: se nos ha indicado dejar de lado este escenario porque no es tan importante
  @Pedidos @AltaLV3233 @btnEnviarARiesgos @Flexinet-19844
  Scenario Outline: Flexinet-19844:Empresa no existe - Boton Enviar a Riesgos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    Then ....PASOS PENDIENTES DE IMPLEMENTAR....

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina        |
      | Flexinet-19844 | PEDIDOS__ALTA_LV3233 | PEDIDOS__ALTA_LV3233/Flexinet-19844/PedidosSupuestoA.json | 451-FLX-TOLEDO |

  # Notas:
  # - necesario que los 2 colaboradores tengan informacion irpf
  #@PRE @done
  @Pedidos @AltaLV3233 @btnFinalizar @Flexinet-19891
  Scenario Outline: Flexinet-19891:Envío de CPDs al ERP - Boton Finalizar
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido <pagina>
    And en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente <scenario>,<pagina>,<fichero_datos>
    And selecciona el registro deseado de la tabla en el dialogo seleccion de empresa <scenario>,<pagina>,<fichero_datos>
    And hace click en Asociar a Empresa
    And rellena los datos necesarios en las pestañas de gestión <scenario>,<pagina>,<fichero_datos>
    And se añade un segundo colaborador <scenario>,<pagina>,<fichero_datos>
    And además rellena deglose de categoria profesional en datos de tarifa <scenario>,<pagina>,<fichero_datos>
    And hace click en Finalizar
    Then aparece una notificacion indicando que el pedido ha sido autorizado <scenario>,<pagina>,<fichero_datos>
    And aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato <scenario>,<pagina>,<fichero_datos>,<oficina>
    And hace click en Si
    Then aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario       | pagina               | fichero_datos                                             | oficina         |
      | Flexinet-19891 | PEDIDOS__ALTA_LV3233 | PEDIDOS__ALTA_LV3233/Flexinet-19891/PedidosSupuestoB-BEBECARESPAÑOLASL.json | 451-FLX-TOLEDO |

