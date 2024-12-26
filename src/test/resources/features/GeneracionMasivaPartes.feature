Feature: generacion-masiva-partes

  # Resumen:
  # 1 Scenario:
  # Se deben visualizar todos los copntratos validados y sin partes, que  cumplan los criterios establecidos
  # Precondiciones:
  # Deben existir contratos validados desde la pantalla "Informe Digital para cierre de nóminas"
  # Pasos:
  #   1.- Pulsa el Botón "Presentar Informe"
  # Resultados Esperados:
  # Se visualizan los contratos suceptibles de generar partes asociados

  # 2 Scenario:
  # Se generean partes de todas las líneas visualziadas al pulsar el Botón "General Informe"
  # Precondiciones:
  # Deben existir contrato sucedptible de ser visualizados al pulsar el Botón "General Informe"
  # Pasos:
  #   1.- Pulsa el Botón "Presentar Informe"
  #   2.- Pulsa el Botón "Generar Partes"
  # Resultados Esperados:
  # Se visualizan los contratos suceptibles de generar partes asociados

    @GeneracionMasivaPartes @PresentarInforme @Flexinet-19832 @Flexinet-19833
  Scenario Outline: Flexinet-19833:Botón Presentar Informe
    Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
    And se ingresa el mes y el anio <scenario>,<pagina>,<fichero_datos>
    When hace click en Presentar Informe
    Then hace click en Generar Partes

    Examples:
      | scenario           | pagina                    | fichero_datos                                         | oficina                |
      | Flexinet-19832     | GENERADOR_AUTOMATICO_PARTES__HORAS | GENERACION__MASIVA_PARTES/Flexinet19832/PresentarInforme.json  | 451-FLX-TOLEDO |

