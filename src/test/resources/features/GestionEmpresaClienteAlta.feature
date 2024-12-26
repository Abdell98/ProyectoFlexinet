Feature: gestion-empresas-cliente-alta

  #    Condiciones:
  #    - la empresa debe estár en estado 0 (inicial)
  #    - la empresa debe estár en la misma oficina que el usuario
  Rule: Se busca una empresa que cumpla ciertas condiciones

  #Notas:
  # @PRE: Este test no funciona en PRE porque  al parecer no está el botón enviar a riesgos
  # - Sin probar por falta de datos
    @GestionEmpresaCliente @Alta @EnviarARiesgos
    Scenario Outline: El objetivo de este escenario es comprobar el funcionamiento del botón EnviarARiesgos y alta de empresas
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena el campo cif y hace click en el botón Obtener Datos  <scenario>,<pagina>,<fichero_datos>
      And accede a las pestañas y rellena los campos requeridos <scenario>,<pagina>,<fichero_datos>
      When hace clic en el botón Enviar Riesgos
      And luego hace click en Yes, para confirmar el envio a riesgos
      Then verifica que aparece un modal que informa que los datos de la empresa han sido enviados a riesgos para su estudio
      When rellena el campo cif y hace click en el botón Obtener Datos  <scenario>,<pagina>,<fichero_datos>
      Then verifica el mensaje que indica que la empresa no puede ser dada de alta porque aún se encuentra en estudio por el Departamento de Riesgos

      Examples:
        | scenario       | pagina                         | fichero_datos                                                             | oficina        |
        | EnviarARiesgos | GESTION_EMPRESAS_CLIENTE__ALTA | GESTION_EMPRESAS_CLIENTE__ALTA/EnviarARiesgos/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Alta @BotonGuardar
    Scenario Outline: Flexinet-19743:Guardado de campos
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena el campo cif y hace click en el botón Obtener Datos  <scenario>,<pagina>,<fichero_datos>
      And accede a las pestañas y rellena los campos requeridos <scenario>,<pagina>,<fichero_datos>
      When hace clic en el botón Guardar <scenario>,<pagina>,<fichero_datos>
      Then ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario | pagina                         | fichero_datos                                                           | oficina        |
        | Guardar  | GESTION_EMPRESAS_CLIENTE__ALTA | GESTION_EMPRESAS_CLIENTE__ALTA/BotonGuardar/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Alta @BotonGuardar @Flexinet-19739
    Scenario Outline: Flexinet-19739:Check F Globalizada On
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena el campo cif y hace click en el botón Obtener Datos  <scenario>,<pagina>,<fichero_datos>
      And accede a las pestañas y rellena los campos requeridos <scenario>,<pagina>,<fichero_datos>
      When hace clic en el botón Guardar <scenario>,<pagina>,<fichero_datos>
      Then ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                         | fichero_datos                                                             | oficina        |
        | Flexinet-19739 | GESTION_EMPRESAS_CLIENTE__ALTA | GESTION_EMPRESAS_CLIENTE__ALTA/Flexinet-19739/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Alta @BotonGuardar @Flexinet-19741
    Scenario Outline: Flexinet-19741:Check F.Golbalizada Off
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena el campo cif y hace click en el botón Obtener Datos  <scenario>,<pagina>,<fichero_datos>
      And accede a las pestañas y rellena los campos requeridos <scenario>,<pagina>,<fichero_datos>
      When hace clic en el botón Guardar <scenario>,<pagina>,<fichero_datos>
      Then ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                         | fichero_datos                                                             | oficina        |
        | Flexinet-19741 | GESTION_EMPRESAS_CLIENTE__ALTA | GESTION_EMPRESAS_CLIENTE__ALTA/Flexinet-19741/GestionEmpresasCliente.json | 442-FLX-GETAFE |

    #En principio este escenario podrá abarcar 3 test,
    @GestionEmpresaCliente @Alta @BotonGuardar @Flexinet-19743 @Flexinet-19779 @Flexinet-19803
    Scenario Outline: Flexinet-19743:Guardado de campos
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena el campo cif y hace click en el botón Obtener Datos  <scenario>,<pagina>,<fichero_datos>
      And valida que los campos de datos de riegos no sean editables <scenario>,<pagina>,<fichero_datos>
      And accede a las pestañas y rellena los campos requeridos <scenario>,<pagina>,<fichero_datos>
      When hace clic en el botón Guardar <scenario>,<pagina>,<fichero_datos>
      Then ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                         | fichero_datos                                                             | oficina        |
        | Flexinet-19743 | GESTION_EMPRESAS_CLIENTE__ALTA | GESTION_EMPRESAS_CLIENTE__ALTA/Flexinet-19743/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Alta @BotonGuardar @Flexinet-19779
    Scenario Outline: Flexinet-19779:P6020-1533 SHERPA: Acomodar Numero de cliente 30 posiciones
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena el campo cif y hace click en el botón Obtener Datos  <scenario>,<pagina>,<fichero_datos>
      And accede a las pestañas y rellena los campos requeridos <scenario>,<pagina>,<fichero_datos>
      When hace clic en el botón Guardar <scenario>,<pagina>,<fichero_datos>
      Then ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                         | fichero_datos                                                             | oficina        |
        | Flexinet-19779 | GESTION_EMPRESAS_CLIENTE__ALTA | GESTION_EMPRESAS_CLIENTE__ALTA/Flexinet-19779/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Alta @Flexinet-19803
    Scenario Outline: Flexinet-19803:P6020-1824 ;FLEX.INT.IN.32. Empresa: actualización de direcciones
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena el campo cif y hace click en el botón Obtener Datos  <scenario>,<pagina>,<fichero_datos>
      And accede a las pestañas y rellena los campos requeridos <scenario>,<pagina>,<fichero_datos>
      When hace clic en el botón Guardar <scenario>,<pagina>,<fichero_datos>
      Then ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                         | fichero_datos                                                             | oficina        |
        | Flexinet-19803 | GESTION_EMPRESAS_CLIENTE__ALTA | GESTION_EMPRESAS_CLIENTE__ALTA/Flexinet-19803/GestionEmpresasCliente.json | 442-FLX-GETAFE |


