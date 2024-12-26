Feature: contratos-baja-flujo42

  @Contratos @CrearPedidoBloqueadoRiesgosBaja @Flujo40
  Scenario Outline: Creación de Pedidos bloqueado por riesgos y luego traspasado
    Given un pedido de alta simple inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
    #UAT
      | scenario      | pagina                  | fichero_datos                       | oficina       |
      | Flujo40 | CONTRATOS__BAJA_BAJAS_MASIVAS |CONTRATOS__BAJA/Flujo40/Flujo40.json | 402-FLX-CÁDIZ |

  #TODO: Validar error presentado al dar de baja sobre la creación del pedido y no procesado.
  #INFO: Validar nuevamente cuando se tenga información para realizar la baja en ambiente UAT.
  @Contratos @Baja @DarBaja @Flexinet-19952 @Flexinet19956 @Flujo40
  Scenario Outline: Flexinet-19952:Dar de Baja )Tiene movimientos Oracle KO o pendientes "Flujo40"
    Given un pedido de alta simple inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado <scenario>,<pagina>,<fichero_datos>,<oficina>
    And el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en opción dar de baja
    Then se visualiza un mensaje indicando que el contrato tiene un proceso pendiente con oracle o dicho proceso erróneo.
    Examples:
      | scenario       |pagina                       |fichero_datos                             | oficina|
      #UAT
      #| Flexinet19952 | CONTRATOS__BAJA_DAR_DE_BAJA |CONTRATOS__BAJA/Flujo40/Flujo40.json | 402-FLX-CÁDIZ |