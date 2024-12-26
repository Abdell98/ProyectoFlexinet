Feature: informe-digital-para-cierre-de-nomina

  @Facturacion @FacturacionConsulta @Flexinet19746

  #  Como Usuario
  #  Quiero realizar una busqueda eligiendo las facturas que haya emitodo desde el ERP
  #  Para verificar que la consulta es satisfactoria

  #  Este escenario cubre los siguientes casos de prueba de TestLink:

  #  Flexinet-19746:Check Búsqueda ERP activo

  #  Nota: En PRE no se dispone del ChackBox "Búsqueda ERP" por lo tanto el caso de prueba se automatiza sin su disponibilidad esperando que al estar disponible no afecte el flujo automatizado (Para realizar la prueba dejar el campo "chk_busquedaErp" del Json en "True")

  Scenario Outline: Check Búsqueda ERP activo
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los campos del formulario de consulta sobre la facturación <scenario>,<pagina>,<fichero_datos>
    When el usuario hace click sobre la opción Buscar
    And el usuario realiza paginacion cambia el numero de lineas del paginado validando que la consulta sale según el paginado esperado <fichero_datos>
    And el usuario realiza una busqueda por columna <scenario>,<pagina>,<fichero_datos>
    Then la consulta es satisfactoria <scenario>,<pagina>,<fichero_datos>

    Examples:
      |      scenario    |       pagina          |                   fichero_datos                          |     oficina    |
      |   Flexinet19746  | FACTURACION__CONSULTA |  FACTURACION__CONSULTA/Flexinet19746/Flexinet19746.json  | 451-FLX-TOLEDO |

  @Facturacion @FacturacionConsulta @Flexinet19808

  #  Como Usuario
  #  Quiero realizar una busqueda eligiendo las facturas que no haya emitodo desde el ERP
  #  Para verificar que la consulta es satisfactoria

  #  Este escenario cubre los siguientes casos de prueba de TestLink:

  #  Flexinet-19808:20230815-09:21:14 Chek Búsqueda ERP desactivado

  #  Nota: En PRE no se dispone del ChackBox "Búsqueda ERP" por lo tanto el caso de prueba se automatiza sin su disponibilidad esperando que al estar disponible no afecte el flujo automatizado (Para realizar la prueba dejar el campo "chk_busquedaErp" del Json en "False")

  Scenario Outline: Chek Búsqueda ERP desactivado
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los campos del formulario de consulta sobre la facturación <scenario>,<pagina>,<fichero_datos>
    When el usuario hace click sobre la opción Buscar
    And el usuario realiza paginacion cambia el numero de lineas del paginado validando que la consulta sale según el paginado esperado <fichero_datos>
    And el usuario realiza una busqueda por columna <scenario>,<pagina>,<fichero_datos>
    Then la consulta es satisfactoria <scenario>,<pagina>,<fichero_datos>

    Examples:
      |      scenario    |       pagina          |                   fichero_datos                          |     oficina    |
      |   Flexinet19808  | FACTURACION__CONSULTA |  FACTURACION__CONSULTA/Flexinet19808/Flexinet19808.json  | 451-FLX-TOLEDO |

  @Facturacion @FacturacionConsulta @Flexinet19751

  #  Como Usuario
  #  Quiero realizar una busqueda de las las facturas uniendo a los criterios principales, el criterio de la columna
  #  Para verificar las facturas que se visualizan cumplen, tanto los criterios principales, como el de la columna

  #  Este escenario cubre los siguientes casos de prueba de TestLink:

  #  Flexinet-19751:Búsqueda sólo en en tablas Flexinet

  Scenario Outline: Búsqueda sólo en en tablas Flexinet
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los campos del formulario de consulta sobre la facturación <scenario>,<pagina>,<fichero_datos>
    When el usuario hace click sobre la opción Buscar
    And el usuario realiza una busqueda por columna <scenario>,<pagina>,<fichero_datos>
    Then la consulta es satisfactoria <scenario>,<pagina>,<fichero_datos>

    Examples:
      |      scenario    |       pagina          |                   fichero_datos                          |     oficina    |
      |   Flexinet19751  | FACTURACION__CONSULTA |  FACTURACION__CONSULTA/Flexinet19751/Flexinet19751.json  | 451-FLX-TOLEDO |

  @Facturacion @FacturacionConsulta @Flexinet19752

  #  Como Usuario
  #  Quiero realizar una busqueda de las las facturas uniendo a los criterios principales, el criterio de uno columna sólo existentes en el ERP
  #  Para verificar las facturas que se visualizan cumplen, tanto los criterios principales, como el de la columna

  #  Este escenario cubre los siguientes casos de prueba de TestLink:

  #  Flexinet-19752:Búsqueda sólo en el ERP

  Scenario Outline: Búsqueda sólo en el ERP
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los campos del formulario de consulta sobre la facturación <scenario>,<pagina>,<fichero_datos>
    When el usuario hace click sobre la opción Buscar
    # Nota: aun no se sabe que columnas solo aparecen con el check "Busqueda ERP" activado, al saberlo modificar el siguiente paso para auq erealice la buscado sobre la columna correspondiente y agregar la variable al mapa de datos y al JSON
    And el usuario realiza una busqueda por columna <scenario>,<pagina>,<fichero_datos>
    Then la consulta es satisfactoria <scenario>,<pagina>,<fichero_datos>

    Examples:
      |      scenario    |       pagina          |                   fichero_datos                          |     oficina    |
      |   Flexinet19752  | FACTURACION__CONSULTA |  FACTURACION__CONSULTA/Flexinet19752/Flexinet19752.json  | 451-FLX-TOLEDO |