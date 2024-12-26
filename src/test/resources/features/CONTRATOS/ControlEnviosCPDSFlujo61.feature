Feature: contratos-Control Envíos CPDS

  #Ir a la sección de Gestión de Oficinas
  #Dentro de Gestión de Oficinas seleccionar Contratos
  #Dentro de Contratos seleccionar la sección de Control Envíos CPDS
  #Precondiciones:
  #Probar la ventana de Control Envíos CPDS
  # Resultado Esperado :
  # Verificar que todos los campos estén bien.
  @Contratos @Flujo61
  Scenario Outline: Flujo61 : Este escenario es Probar la ventana de Control-Envíos-CPDS, verificar que funcionan todos sus campos, tablas, Check y botones
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    When rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And seleccionamos los checkbox filtrados por estado <fichero_datos>
    And en la tabla rellenamos los datos y buscamos el registro <scenario>,<pagina>,<fichero_datos>
    And selecciona el contrato <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_MARCAR_ENVIADO ubicado en CURRENTPAGE true
    And ingresamos la fecha de envío <scenario>,<pagina>,<fichero_datos>
    Then hace click en el botón BTN_CANCELAR ubicado en DIALOG_FECHAENVIOCPDS_PRORROGAS true
    #ESTE BOTON SE MARCA CUANDO EN FILTRAMOS POR ESTADO "ENVIADO"
   # And hace click en el botón BTN_MARCAR_RECIBIDO ubicado en CURRENTPAGE true

    Examples:
      | scenario       | pagina                         | fichero_datos                                                          | oficina                |
      | Flujo61   | CONTRATOS__CONTROL_ENVIOS_CPDS | CONTRATOS__CONTROL_ENVIOS_CPDS/Flujo61/Flujo61.json  | 451-FLX-TOLEDO |