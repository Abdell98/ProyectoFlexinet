Feature: contratos-consulta


    # --- CREA EL PEDIDO PARA EL FLUJO38 ----
  @Contratos @CrearPedidoAutorizadoRiesgosFlujo38
  Scenario Outline: Creación de Pedidos autorizado por riesgos y que no es traspasado
    Given un pedido autorizado y NO traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario       | pagina              | fichero_datos                                 | oficina        |
      #UAT
      #| Flexinet-19822 | CONTRATOS__CONSULTA |CONTRATOS__CONSULTAP6020/Flujo38/Flujo38.json | 402-FLX-CÁDIZ |
      #PRE
      | Flexinet-19822 | CONTRATOS__CONSULTA | CONTRATOS__CONSULTAP6020/Flujo38/Flujo38.json | 451-FLX-TOLEDO |

  #INFO: Escenario Flexinet-19904  añadido al test, se ajusta para poder consultar el semaforo con el estado Verde.
  #INFO: este test solo esta disponible para ambiente de PRE cuando un pedido no sea bloqueado por riesgos
  @Contratos @TraspasarContrato @Flexinet-19904 @Flexinet-19822 @Flexinet-19953 @Flexinet-19969 @Flujo38
  Scenario Outline: Flexinet-19822: Traspasar Contrato
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena los datos necesarios en las pestañas de contratos <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    And presionamos el contrato a trapasar <scenario>,<pagina>,<fichero_datos>
    And hace click en opción Ver Detalle Contrato
    And hace click en opción Traspasar
    And se selecciona la opción si, para proceder a traspasar el secuencial del contrato
    And hace click en opción Aceptar, traspaso contrato <scenario>
    Then aparece un mensaje indicando que se ha realizado el traspaso con éxito <fichero_datos>
    #Se valida en este caso el semaforo del contrato ya traspasado, se comenta porque en pre no existe funcionalidad Flexinet-19904
    Then aparecen las opciones de los distintos colores del semaforos <scenario>,<pagina>,<fichero_datos>
    #Se procede a dar de baja el contrato traspasado Flexinet-19896.
    Given el usuario está en la página CONTRATOS__BAJA_DAR_DE_BAJA, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    When hace click en opción Buscar
    And selecciona el contrato <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And hace click en opción dar de baja
    And selecciona el motivo de la baja y su fecha <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And hace click sobre la opcion de aceptar <scenario>
    And hace click sobre el diagolo baja de contrato, para continuar la anulación de contrato
    Then aparece un mensaje indicando que el contrato se ha traspasado <fichero_datos>
    #Se selecciona la opción aceptar para realizar la sustitución del contrato Flexinet-19969.
    And selecciona opción aceptar para realizar la sustitución del contrato
    And se ingresan los datos para completar el Alta de Sustitución <scenario>,CONTRATOS__ALTA_SUSTITUCION,<fichero_datos>
    And hace click en opción alta de sustitución
    And se selecciona la opción aceptar sobre la sustitución
    Then se ha creado correctamente la sustitución del contrato

    Examples:
      | scenario       | pagina              | fichero_datos                                 | oficina        |
      #PRE
      | Flexinet-19822 | CONTRATOS__CONSULTA | CONTRATOS__CONSULTAP6020/Flujo38/Flujo38.json | 451-FLX-TOLEDO |
      #UAT
     #| Flexinet-19822 | CONTRATOS__CONSULTA |CONTRATOS__CONSULTAP6020/Flujo38/Flujo38.json| 451-FLX-TOLEDO|

  # Info: Para este caso se debe ajustar los datos del json y cambiar del contrato seleccionado sobre la tabla "EXTERNAL_CPD_ENVIO" el campo de la tabla CD_STATUS='ERP_KO'
  @Contratos @TraspasarContratoERP @Flexinet-19904 @Flexinet-19884 @Flujo39
  Scenario Outline: Flexinet-19884: Pulsar el Botón "Traspasar a ERP" "Flujo39"
    #Given Se debe ingresar un pedido por alta simple y traspasar o no el contrato <scenario>,<fichero_datos>,<oficina>
    #And se consulta el id de contrato en la tabla Contrato enviando el id del pedido <scenario>,<pagina>,<fichero_datos>
    #And se actualiza la tabla contrato sobre el campo F_TRS_FACT <scenario>,<pagina>,<fichero_datos>
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena los datos necesarios en las pestañas de contratos <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    Then aparecen las opciones de los distintos colores del semaforos <scenario>,<pagina>,<fichero_datos>
    And presionamos el contrato a trapasar <scenario>,<pagina>,<fichero_datos>
    And hace click en opción Ver Detalle Contrato
    And el usuario hace click en opción Traspasar al ERP
    And hace click en opción Aceptar, traspaso contrato <scenario>
    Then aparece un mensaje indicando que se ha realizado el traspaso con éxito <fichero_datos>

    Examples:
      | scenario       | pagina              | fichero_datos                                                    | oficina       |
      | Flexinet-19884 | CONTRATOS__CONSULTA | CONTRATOS__CONSULTAP6020/Flexinet-19884/ContratoTraspasoErp.json | 402-FLX-CÁDIZ |

  # --- CREA EL PEDIDO PARA EL FLUJO40 ----
  @Contratos @CrearPedidoAutorizadoRiesgosFlujo40
  Scenario Outline: Creación de Pedidos autorizado por riesgos y que no es traspasado
    Given un pedido autorizado y NO traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario      | pagina              | fichero_datos                                 | oficina        |
      #UAT
      #| Flexinet19953 | CONTRATOS__CONSULTA |CONTRATOS__CONSULTAP6020/Flujo40/Flujo40.json | 402-FLX-CÁDIZ |
      #PRE
      | Flexinet19953 | CONTRATOS__CONSULTA | CONTRATOS__CONSULTAP6020/Flujo40/Flujo40.json | 451-FLX-TOLEDO |

  # INFO: Para este escenario es necesario que el pedido NO SEA traspasado
  # INFO: Test probado solo en UAT
  @Contratos @TraspasarContrato @Flexinet-19822UAT @Flexinet-19952 @Flexinet-19822 @Flexinet-19904 @Flexinet-19969 @Flujo40
  Scenario Outline: Flujo40: Traspasar Contrato ambiente UAT #3 "Flujo40"+
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena los datos necesarios en las pestañas de contratos <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    # A partir de aqui se cubre @Flexinet-19822
    And presionamos el contrato a trapasar <scenario>,<pagina>,<fichero_datos>
    And hace click en opción Ver Detalle Contrato
    And hace click en opción Traspasar
    And se selecciona la opción si, para proceder a traspasar el secuencial del contrato
    And hace click en opción Aceptar, traspaso contrato <scenario>
    Then aparece un mensaje indicando que se ha realizado el traspaso con éxito <fichero_datos>
    # Funcionalidad @Flexinet-19904
    Then aparecen las opciones de los distintos colores del semaforos <scenario>,<pagina>,<fichero_datos>
    # Se procede a dar de baja el contrato traspasado Flexinet-19952.
    Given el usuario está en la página CONTRATOS__BAJA_DAR_DE_BAJA, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    When hace click en opción Buscar
    And selecciona el contrato <scenario>,CONTRATOS__BAJA_DAR_DE_BAJA,<fichero_datos>
    And hace click en opción dar de baja
    Then se visualiza un mensaje indicando que el contrato tiene un proceso pendiente con oracle o dicho proceso erróneo.

    Examples:
      | scenario       | pagina              | fichero_datos                                 | oficina       |
      #UAT
      | Flexinet-19822 | CONTRATOS__CONSULTA | CONTRATOS__CONSULTAP6020/Flujo40/Flujo40.json | 402-FLX-CÁDIZ |