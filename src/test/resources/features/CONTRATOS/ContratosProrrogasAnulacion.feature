Feature: contratos-prorrogas-consulta

  @Contratos @CrearPedidoBloqueadoRiesgos
  Scenario Outline: Creación de Pedidos bloqueado por riesgos y luego traspasado
    Given un pedido de alta simple inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario | pagina | fichero_datos  | oficina |
      | CrearPedidoBloqueadoRiesgos | CONTRATOS__PRORROGAS_ANULACION |CONTRATOS__PRORROGAS/Flujo51/Flexinet-19961.json | 402-FLX-CÁDIZ |

  @Contratos @CrearPedidoAutorizadoRiesgos
  Scenario Outline: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario | pagina | fichero_datos  | oficina |
      | CrearPedidoAutorizadoRiesgos | CONTRATOS__PRORROGAS_ANULACION |CONTRATOS__PRORROGAS/Flujo51/Flexinet-19961.json | 402-FLX-CÁDIZ |

  #TODO: ver de asociar el flujo de los da baja con el escenario siguiente.

  # Resumen:
  # 1.-Botón anular Prorroga
  # Precondiciones:
  # - Se debe crear una prórroga con estado ERP_OK y una prórroga con estado EP_KO
  # Flexinet19961: - Se anula la Prórroga y se envía la información a Oracle
  # Flexinet19960: - No se anula prórroga, ni se envía a Oracle. Devuelve el error:
  # "El contrato tiene un proceso pendiente con oracle o dicho proceso es erróneo"
  # Flexinet19959: - Se anula la Prórroga y se envía la información a Oracle

  @Contratos @Prorrogas @Anulacion @Flujo51 @Flexinet-19961 @Flexinet-19960 @Flexinet-19959
  Scenario Outline: Flujo51: Tiene movimiento oracle OK
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se buscan los datos de la empresa a filtrar y nro de cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en Anular Prórroga
    Then comprobar resultado esperado <scenario>

      Examples:
        | scenario       | pagina                         | fichero_datos                                                          | oficina                |
        | Flexinet19961  | CONTRATOS__PRORROGAS_ANULACION | CONTRATOS__PRORROGAS/Flujo51/Flexinet-19961.json | 451-FLX-TOLEDO |
        #| Flexinet19961  | CONTRATOS__PRORROGAS_ANULACION | CONTRATOS__PRORROGAS/Flujo51/Flexinet-19961.json | 402-FLX-CÁDIZ |
        #| Flexinet19960  | CONTRATOS__PRORROGAS_ANULACION  | CONTRATOS__PRORROGAS/Flujo51/Flexinet-19960.json | 402-FLX-CÁDIZ |
        #| Flexinet19959  | CONTRATOS__PRORROGAS_ANULACION  | CONTRATOS__PRORROGAS/Flujo51/Flexinet-19959.json | 402-FLX-CÁDIZ |
