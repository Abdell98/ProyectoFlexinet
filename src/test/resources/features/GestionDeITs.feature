Feature: gestion-its

  # Resumen:
  # Scenario:
  # P6020-1535: SHERPA: Traspaso Partes facturación (ERP)
  # Precondiciones:
  # Pasos:
  #   1.- Al dar de alta una  IT , se debe desactivar el flag F_TRS_FACT de la tabla PARTE de todos los partes del colaborador dentro del rango de fechas de la baja.
  #   2.- Al cerrar una IT (introducir flecha fin a una IT ya existente), el flag F_TRS_FACT de la tabla PARTE  de todos los partes del colaborador,  que coincida con el mes de la fecha de cierre de la IT y todos los partes posteriores
  # Resultados Esperados:
  # Se realiza correctamente el guardado y la modificación del nuevo campo F_TRS_FACT.

    @AdministracionPersonal @GestionITs @Flexinet-19590
  Scenario Outline: Flexinet-19590:P6020-1535: SHERPA: Traspaso Partes facturación (ERP)
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And se ingresan los datos del colaborador <scenario>,<pagina>,<fichero_datos>
      And hace click en Añadir IT
      Then se ingresan los datos del IT <scenario>,<pagina>,<fichero_datos>
      And hace click en Aceptar
      Then comprueba que se ha creado el IT <scenario>,<pagina>,<fichero_datos>
      When el usuario está en la página <comprobacion>, en la oficina <oficina>, probando el escenario <scenario>
      And se ingresan los datos del colaborador <scenario>,<comprobacion>,<fichero_datos>
      And filtrar por fecha de IT <scenario>,<comprobacion>,<fichero_datos>
      And comprobar 'Traspasado' no esta checkeado <fichero_datos>
      When el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And se ingresan los datos del colaborador <scenario>,<pagina>,<fichero_datos>
      Then comprueba que se ha creado el IT <scenario>,<pagina>,<fichero_datos>
      And borra el IT creado

    Examples:
      | scenario           | pagina     | comprobacion               | fichero_datos                                         | oficina |
      | Flexinet-19590     | GESTION_DE_ITS |  PARTES_DE_HORAS__CONSULTA | ADMINISTRACION__PERSONAL_GESTION_ITS/Flexinet19590/TraspasoPartesFacturacion.json  | 451-FLX-TOLEDO |

