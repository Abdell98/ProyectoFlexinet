Feature: gestion-clientes-contrato-alta

  #    Condiciones:
  #    - la empresa debe estár en estado 5 (registrada)
  #    - la empresa debe estár en la misma oficina que el usuario
  Rule: Se busca una empresa que cumpla ciertas condiciones

@GestionClientesContrato @Alta @FaltaRequeridoKO
Scenario Outline: El objetivo de este escenario es comprobar que no se pueden guardar cambios si hay un campo requerido que falta por rellenar
  Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
  And busca una empresa por su razón social <scenario>,<pagina>,<fichero_datos>
  And la selecciona y hace click en la fila correspondiente del resultado de la tabla <scenario>,<pagina>,<fichero_datos>
  And hace click en Alta Cliente Contrato
  When aparecen las pestañas de gestion y se comprueba que existen campos obligatorios sin rellenar <scenario>,<pagina>,<fichero_datos>
  And hace click en el botón Guardar
  Then aparece de atención indicando que faltan campos requeridos por rellenar

  Examples:
    | scenario        | pagina                             | fichero_datos                  | oficina           |
    | FaltaRequeridoKO | GESTION_CLIENTES_CONTRATO__ALTA | GestionClientesContratoAlta | 480-FLX-CENTRAL |

@GestionClientesContrato @Alta @AltaClienteContratoEnvioKO
Scenario Outline: El objetivo de este escenario es comprobar que al dar de alta un cliente contrato con una empresa no registrada da error
  Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
  And busca una empresa por su razón social <scenario>,<pagina>,<fichero_datos>
  And la selecciona y hace click en la fila correspondiente del resultado de la tabla <scenario>,<pagina>,<fichero_datos>
  And hace click en Alta Cliente Contrato
  When aparecen las pestañas de gestion accede a ellas y rellena los campos requeridos que no tengan valor <scenario>,<pagina>,<fichero_datos>
  And hace click en el botón Guardar
  Then aparece un mensaje de error de envio al ERP <scenario>,<pagina>,<fichero_datos>
  And finalmente comprueba que NO se han creado entidades nuevas en la tabla CLIENT_CON <scenario>,<pagina>,<fichero_datos>,<oficina>
  And finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado KO <scenario>,<pagina>,<fichero_datos>

  Examples:
    | scenario        | pagina                             | fichero_datos                  | oficina           |
    | AltaClienteContratoEnvioKO | GESTION_CLIENTES_CONTRATO__ALTA | GestionClientesContratoAlta | 480-FLX-CENTRAL |

  #Para este scenario hay que modificar la oficina, por una que aún no tenga clientes contrato.
  #Se puede usar la siguiente consulta, reemplazando el nif por la empresa que hayamos indicado en los archivos de datos:
  # SELECT oficina.ID_OFICINA,oficina.LITERAL,CLIENT_CON.NIF_EMP
  # FROM oficina LEFT OUTER JOIN client_con ON (oficina.id_oficina=client_con.id_oficina AND client_con.nif_emp='11407171E')
  # WHERE oficina.literal NOT LIKE '0-%'
  # ORDER BY NIF_EMP ASC
@GestionClientesContrato @Alta @AltaClienteContratoEnvioOK
Scenario Outline: El objetivo de este escenario es comprobar que es posible der de alta un nuevo registro de Clientes Contrato
  Given el usuario está en la página <pagina>, en la oficina <oficina>, probando el escenario <scenario>
  And busca una empresa por su razón social <scenario>,<pagina>,<fichero_datos>
  And la selecciona y hace click en la fila correspondiente del resultado de la tabla <scenario>,<pagina>,<fichero_datos>
  And hace click en Alta Cliente Contrato
  When aparecen las pestañas de gestion accede a ellas y rellena los campos requeridos que no tengan valor <scenario>,<pagina>,<fichero_datos>
  And hace click en el botón Guardar
  Then aparece un mensaje que indica que el alta se ha realizado correctamente y se ha enviado al ERP <scenario>,<pagina>,<fichero_datos>
  And finalmente comprueba que SI se ha creado una nueva entidad en la tabla CLIENT_CON <scenario>,<pagina>,<fichero_datos>,<oficina>
  And finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado OK <scenario>,<pagina>,<fichero_datos>

  Examples:
    | scenario        | pagina                             | fichero_datos                  | oficina           |
    | AltaClienteContratoEnvioOK | GESTION_CLIENTES_CONTRATO__ALTA | GestionClientesContratoAlta | 436-FLX-CIUDAD REAL |