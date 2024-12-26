Feature: portal-de-cliente-facturas-facturas-emitidas

  # Resumen:
  # se visualizan las facturas que están en la bd de flexinet
  # Precondiciones:
  # El Criterio deber abarcar facturas emeitidas desde flexinet exclusivamente
  # Pasos:
  #   1.- Pulsar el botón "Buscar"
  #   2.- Pulsar botón icono de documento
  #   3.- Pulsar el botón "Descargar"
  # Resultados Esperados:
  # 1.- Se visualizar la facturas que cumplen con el rango de búsqueda
  # 2.- Se visualiza el documento de la factura
  # 3.- Se descargan todas las facturas en formato ZIP
    @PortalDeClientes @Facturas @FacturasEmitidas @Flexinet19937
    Scenario Outline: Flexinet-19937:Facturas desde la BD de Flexinet
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la razon social y selecciona la lupa <scenario>,<pagina>,<fichero_datos>
    And se ingresa los campos del formulario de consulta sobre la facturación <scenario>,<pagina>,<fichero_datos>
    When el usuario hace click sobre la opción Buscar
    And selecciona la factura <scenario>,<pagina>,<fichero_datos>
    #Then aparecen las opciones de los distintos colores del semaforos <scenario>,<pagina>,<fichero_datos>

     Examples:
      | scenario          | pagina                  | fichero_datos                                                        | oficina        |
      | Flexinet19937     | FACTURACION__CONSULTA   | FACTURACION__CONSULTA/Flexinet19937/FacturasEmitidasBDFlexinet.json  | 451-FLX-TOLEDO |

  # Resumen:
  # Se visualizan las facturas emitidas desde Oracle
  # Precondiciones:
  # El criterio debe abarcar tarifas emitidas exclusivamente desde Oracle
  # Pasos:
  #   1.- Pulsar el botón "Buscar"
  #   2.- Pulsar botón icono de documento
  #   3.- Pulsar el botón "Descargar"
  # Resultados Esperados:
  # 1.- Se visualizan las facturas emitidas desde Oracle que cumplen el crierio introducido
  # 2.- Se visualiza el documento de la factura
  # 3.- Se descargan todas las facturas en formato ZIP
   @PortalDeClientes @Facturas @FacturasEmitidas @Flexinet19938
   Scenario Outline: Flexinet-19938:Facturas Emitidas desde Oracle
   Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
   And se ingresa los datos de la razon social y selecciona la lupa <scenario>,<pagina>,<fichero_datos>
   And se ingresa los campos del formulario de consulta sobre la facturación <scenario>,<pagina>,<fichero_datos>
   When el usuario hace click sobre la opción Buscar
   And selecciona la factura <scenario>,<pagina>,<fichero_datos>
   #Then aparecen las opciones de los distintos colores del semaforos <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario           | pagina                | fichero_datos                                                   | oficina        |
      | Flexinet19938      | FACTURACION__CONSULTA | FACTURACION__CONSULTA/Flexinet19938/FacturasEmitidasOracle.json | 451-FLX-TOLEDO |

 # Resumen:
 # Se visualizan las facturas que están emitidas en la bd de flexinet y en Oracle
 # Precondiciones:
 # Pasos:
 #   1.- Pulsar el botón "Buscar"
 #   2.- Pulsar botón icono de documento
 #   3.- Pulsar el botón "Descargar"
 # Resultados Esperados:
 # 1.- Se visualizar la facturas que cumplen con el rango de búsqueda
 # 2.- Se visualiza el documento de la factura
 # 3.- Se descargan todas las facturas en formato ZIP
  @PortalDeClientes @Facturas @FacturasEmitidas @Flexinet19939
  Scenario Outline: Flexinet-19939:FActuras emitidas desde Flexinet y desde Oracle
  Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
  And se ingresa los datos de la razon social y selecciona la lupa <scenario>,<pagina>,<fichero_datos>
  And se ingresa los campos del formulario de consulta sobre la facturación <scenario>,<pagina>,<fichero_datos>
  When el usuario hace click sobre la opción Buscar
  And selecciona la factura <scenario>,<pagina>,<fichero_datos>
  #Then aparecen las opciones de los distintos colores del semaforos <scenario>,<pagina>,<fichero_datos>

    Examples:
      | scenario          | pagina                | fichero_datos                                                           | oficina        |
      | Flexinet19939     | FACTURACION__CONSULTA | FACTURACION__CONSULTA/Flexinet19939/FacturasEmitidasOracleFlexinet.json | 451-FLX-TOLEDO |
