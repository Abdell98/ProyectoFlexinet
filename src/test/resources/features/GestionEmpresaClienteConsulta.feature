Feature: gestion-empresas-cliente-consulta

  #    Condiciones:
  #    - la empresa debe estár en estado 5 (registrada)
  #    - la empresa debe estár en la misma oficina que el usuario
  Rule: Se busca una empresa que cumpla ciertas condiciones


    @GestionEmpresaCliente @Consulta @BuscarEmpresa
    Scenario Outline: El objetivo de este escenario es comprobar el funcionamiento del botón Buscar Empresas
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      When rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      Then hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>

      Examples:
        | scenario      | pagina                             | fichero_datos                                                                | oficina        |
        | BuscarEmpresa | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/BuscarEmpresa/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @VerEmpresa
    Scenario Outline: El objetivo de este escenario es comprobar el funcionamiento del botón ver empresa
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      When hace click en el boton ver empresa
      Then valida que los valores indicados en los campos son correctos <scenario>,<pagina>,<fichero_datos>

      Examples:
        | scenario   | pagina                             | fichero_datos                                                             | oficina        |
        | VerEmpresa | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/VerEmpresa/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @ModificarEmpresaEnvioKO @SHERPA
    Scenario Outline: El objetivo de este escenario es comprobar que salta un error cuando se modifican datos que lanzan envio al ERP y se hace rollback en DB
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      And hace click en el boton Modificar Empresa
      When va a la pestaña datos economicos y modifica algunos campos de la dirección de facturación <scenario>, <pagina>, <fichero_datos>
      And anota los resultados de la consulta en base de datos en un csv luego hace click en el botón guardar <scenario>,<pagina>,<fichero_datos>,<oficina>
      Then aparece un mensaje de error indicando, error en envio ERP la empresa no se enuentra registrada en el sistema <scenario>, <pagina>, <fichero_datos>
      And se confirma que los datos modificados NO se han guardado en base de datos <scenario>, <pagina>, <fichero_datos>
      And finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado KO <scenario>,<pagina>,<fichero_datos>

      Examples:
        | scenario                | pagina                             | fichero_datos                                                                          | oficina        |
        | ModificarEmpresaEnvioKO | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/ModificarEmpresaEnvioKO/GestionEmpresasCliente.json | 442-FLX-GETAFE |



    @GestionEmpresaCliente @Consulta @SHERPA @Flexinet-19740
    Scenario Outline: Flexinet-19740:Check F.Globalizada On
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      And hace click en el boton Modificar Empresa
      When modifica algunos campos indicando Globalizada ON <scenario>,<pagina>,<fichero_datos>
      And hace click en el botón Guardar
      And aparece un dialogo de Confirmación de Operacion por parte de riesgos, hace click en SI <scenario>,<pagina>,<fichero_datos>
      Then aparece una notificacion indicando que los datos han sido enviados a riesgos <scenario>,<pagina>,<fichero_datos>,<oficina>
      And finalmente comprueba en la tabla EMP_TIPOFA que SI hay un registro para la empresa <scenario>,<pagina>,<fichero_datos>

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19740 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19740/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @SHERPA @Flexinet-19742
    Scenario Outline: Flexinet-19742:Chekc F.Globalizada Off
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      And hace click en el boton Modificar Empresa
      When modifica algunos campos indicando Globalizada OFF <scenario>,<pagina>,<fichero_datos>
      And hace click en el botón Guardar
      And aparece un dialogo de Confirmación de Operacion por parte de riesgos, hace click en SI <scenario>,<pagina>,<fichero_datos>
      Then aparece una notificacion indicando que los datos han sido enviados a riesgos <scenario>,<pagina>,<fichero_datos>,<oficina>
      And finalmente comprueba en la tabla EMP_TIPOFA que NO hay un registro para la empresa <scenario>,<pagina>,<fichero_datos>

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19742 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19742/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @SHERPA @Flexinet-19744
    Scenario Outline: Flexinet-19744:Etiqueta "Datos Económicos" Impuesto Y Días Fijo de Pagos con valores Nulos
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      And hace click en el boton Modificar Empresa
      When modifica algunos campos de manera que los campos Impuesto y Días Fijo de Pagos sean valores Nulos <scenario>,<pagina>,<fichero_datos>
      And hace click en el botón Guardar
      And aparece un dialogo de Confirmación de Operacion por parte de riesgos, hace click en SI <scenario>,<pagina>,<fichero_datos>
      Then aparece una notificacion indicando que los datos han sido enviados a riesgos <scenario>,<pagina>,<fichero_datos>,<oficina>
      And ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19744 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19744/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @SHERPA @Flexinet-19745
    Scenario Outline: Flexinet-19745:Etiqueta "Datos Económicos": Impuestos y Días de Pago con valores no nulos
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      And hace click en el boton Modificar Empresa
      When modifica algunos campos de manera que los campos Impuesto y Días Fijo de Pagos sean valores NO Nulos <scenario>,<pagina>,<fichero_datos>
      And hace click en el botón Guardar
      And aparece un dialogo de Confirmación de Operacion por parte de riesgos, hace click en SI <scenario>,<pagina>,<fichero_datos>
      Then aparece una notificacion indicando que los datos han sido enviados a riesgos <scenario>,<pagina>,<fichero_datos>,<oficina>
      And ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19745 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19745/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @SHERPA @Flexinet-19780
    Scenario Outline: Flexinet-19780:P6020-1533 SHERPA: Acomodar Numero de cliente 30 posiciones
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      And hace click en el boton Modificar Empresa
      When modifica algunos campos de manera que los campos Impuesto y Días Fijo de Pagos sean valores NO Nulos <scenario>,<pagina>,<fichero_datos>
      And hace click en el botón Guardar
      And aparece un dialogo de Confirmación de Operacion por parte de riesgos, hace click en SI <scenario>,<pagina>,<fichero_datos>
      Then aparece una notificacion indicando que los datos han sido enviados a riesgos <scenario>,<pagina>,<fichero_datos>,<oficina>
      And pendiente query falta tener uat...... <scenario>,<pagina>,<fichero_datos>

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19780 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19780/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @SHERPA @Flexinet-19799
    Scenario Outline: Flexinet-19799:No se realizan cambios en datos susceptibles de ser enviados al ERP
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19780 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19799/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @SHERPA @Flexinet-19804
    Scenario Outline: Flexinet-19804:Se Modifican datos del ERP
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And ....PASOS PENDIENTES DE IMPLEMENTAR....

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19804 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19804/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @ModificarEmpresaEnvioOK @SHERPA @Flexinet-19805
    Scenario Outline: Flexinet-19805:Se modifican casos de ERP
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      And hace click en el boton Modificar Empresa
      When va a la pestaña datos economicos y modifica algunos campos de la dirección de facturación <scenario>, <pagina>, <fichero_datos>
      And anota los resultados de la consulta en base de datos en un csv luego hace click en el botón guardar <scenario>,<pagina>,<fichero_datos>,<oficina>
      Then aparece un mensaje indicando que se han guardado los cambios y se han enviado al ERP <scenario>, <pagina>, <fichero_datos>
      And se confirma que los datos modificados SI se han guardado en base de datos <scenario>,<pagina>,<fichero_datos>,<oficina>
      And finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado OK <scenario>,<pagina>,<fichero_datos>

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19805 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19805/GestionEmpresasCliente.json | 442-FLX-GETAFE |


    @GestionEmpresaCliente @Consulta @ModificarEmpresaSinEnvioERP @SHERPA @Flexinet-19806
    Scenario Outline: Flexinet-19806:No se modifican casos de ERP
      Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
      And rellena los campos del formulario de consulta <scenario>,<pagina>,<fichero_datos>
      And hace click en buscar y selecciona el registro encontrado <scenario>,<pagina>,<fichero_datos>
      And hace click en el boton Modificar Empresa
      When modifica algunos campos pero ninguno de la pestaña datos economicos dirección de facturación <scenario>, <pagina>, <fichero_datos>
      And anota los resultados de la consulta en base de datos en un csv luego hace click en el botón guardar <scenario>,<pagina>,<fichero_datos>,<oficina>
      Then aparece un mensaje indicando que se han guardado los cambios pero no se han enviado al ERP <scenario>,<pagina>,<fichero_datos>
      And se confirma que los datos modificados SI se han guardado en base de datos <scenario>,<pagina>,<fichero_datos>,<oficina>
      And se confirma revisando la tabla de EXTERNAL_MISC_ENVIO que no se ha creado ningún registro de lote nuevo <scenario>, <pagina>, <fichero_datos>

      Examples:
        | scenario       | pagina                             | fichero_datos                                                                 | oficina        |
        | Flexinet-19806 | GESTION_EMPRESAS_CLIENTE__CONSULTA | GESTION_EMPRESAS_CLIENTE__CONSULTA/Flexinet-19806/GestionEmpresasCliente.json | 442-FLX-GETAFE |

