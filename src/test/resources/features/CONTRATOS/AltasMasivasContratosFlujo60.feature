Feature: Altas-Masivas-Contratos


  #Ir a la sección de Gestión de Oficinas
  #Dentro de Gestión de Oficinas seleccionar Contratos
  #Dentro de Contratos seleccionar la sección de Traspasos Masivos de Altas
  #Precondiciones:
  #Probar la ventana de Altas Masivas Contratos
  # Resultado Esperado :
  # Verificar que todos los campos estén bien.

  @Contratos @Flujo60
  Scenario Outline: Flujo60 : Probar la ventana de Altas-Masivas-Contratos
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    When rellena el formulario de <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_BUSCAR ubicado en CURRENTPAGE true
    And seleccionamos los checkbox para realizar el Traspaso Masivo
    And rellena los datos de la tabla y seleccionamos el registro <scenario>,<pagina>,<fichero_datos>
    And hace click en el botón BTN_TRASPASOMASIVO ubicado en CURRENTPAGE true
    Then hace click en el botón BTN_CANCELAR ubicado en DIALOG_TRASPASO_MASIVO_ALTAS_CONTRATO true
    Examples:
      | scenario       | pagina                         | fichero_datos                                                          | oficina                |
      | Flujo60   | CONTRATOS__TRASPASO_MASIVO | CONTRATOS__ALTAS_MASIVAS/Flujo60/Flujo60.json  | 451-FLX-TOLEDO |