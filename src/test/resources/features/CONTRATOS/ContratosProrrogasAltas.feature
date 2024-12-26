Feature: contratos-prorrogas-altas

  @Contratos @CrearPedidoAutorizadoRiesgos @Flujo53Pedido
  Scenario Outline: Flujo53: Creación de Pedidos autorizado por riesgos
    Given un pedido autorizado y traspasado de alta simple <scenario>,<pagina>,<fichero_datos>,<oficina>
    Examples:
      | scenario | pagina | fichero_datos  | oficina |
      #| Flexinet19965  | CONTRATOS__PRORROGAS_ALTA  | CONTRATOS__PRORROGAS/Flujo53/Flujo53-Pedido.json   | 451-FLX-TOLEDO |
      | Flexinet19965  | CONTRATOS__PRORROGAS_ALTA  | CONTRATOS__PRORROGAS/Flujo53/Flujo53-Pedido_C.json   | 451-FLX-TOLEDO |


  @Contratos @CrearPedidoAutorizadoRiesgos @Flujo53ConsultaContrato
  Scenario Outline: Flujo53: Consulta de contrato por número de pedido
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa los datos de la empresa y número cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena los datos necesarios en las pestañas de contratos <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar

    Examples:
      | scenario | pagina | fichero_datos  | oficina |
      #| Flexinet19965  | CONTRATOS__PRORROGAS_ALTA  | CONTRATOS__PRORROGAS/Flujo53/Flujo53-Pedido.json   | 451-FLX-TOLEDO |
      | Flexinet19965  | CONTRATOS__CONSULTA  | CONTRATOS__PRORROGAS/Flujo53/Flujo53-Pedido_B.json   | 451-FLX-TOLEDO |

  # Resumen:
  # 1.- Se crará la prorroga en Flexinet
  # 2.- Se enviará el CPD de la Prórroga a Oracle
  # Precondiciones:
  # Se debe elegir contrato suceptible de poder realizar una Prórroga
  # Pasos:
  # 1.- Elegir contrato
  # 2.- Pulsar Botón crear prórroga
  #
  #1.- Introducir fecha fin alta.
  #2.- Pulsar botón "Crear Prórroga".
  #3.- EXTERNAL_LOG_REQUEST
  # Resultados Esperados:
  # 1.- Se visualiza ventana "Creación de Prórroga"
  # 2.- Se crea la prórroga en Flexinet y se envía a Oracle
  # Verificar tablas:
  # - EXTERNAL_CPD_PRORROGA  (CD_ACCION = "PRORROGA_CPD")
  # - EXTERNAL_LOG_REQUEST
  # - EXTERNAL_HIST_FEC
  #TODO: VALIDAR TEST EN UAT EL MENSAJE
  @Contratos @Prorrogas @Altas @Flujo53 @Flexinet-19965 @Flexinet-19964 @Flexinet19907
  Scenario Outline: Flujo53:Botón Crear Prórroga
    #And Se debe ingresar un pedido por alta simple sin realizar el traspaso de contrato <scenario>,<fichero_datos>,<oficina>
    #And se consulta el id de contrato en la tabla Contrato enviando el id del pedido <scenario>,<pagina>,<fichero_datos>
    #And Se debe realizar un traspaso para dar de baja un contrato <scenario>,<fichero_datos>
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se buscan los datos de la empresa a filtrar y nro de cliente <scenario>,<pagina>,<fichero_datos>
    And se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos <scenario>,<pagina>,<fichero_datos>
    And en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección <scenario>,<pagina>,<fichero_datos>
    And rellena datos necesarios para realizar una anulación de contrato <scenario>,<pagina>,<fichero_datos>
    When hace click en opción Buscar
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en opción Crear Prórroga <scenario>,<pagina>,<fichero_datos>
    And selecciona la fecha de finalización de prorroga <scenario>,<pagina>,<fichero_datos>
    And hace click sobre la opción Crear Prórroga
    And se va a proceder a la creación de la prórroga, hace click boton aceptar
    Then aparece un mensaje indicando que se ha realizado el traspaso con éxito <fichero_datos>

    Examples:
      | scenario      | pagina                      | fichero_datos                                                  | oficina        |
      | Flexinet19907 | CONTRATOS__PRORROGAS_ALTA   | CONTRATOS__PRORROGAS/Flujo53/Flujo53-Pedido_B.json   | 451-FLX-TOLEDO |