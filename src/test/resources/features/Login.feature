#@tag @tags
Feature: login
	como usuario de la app de banistmo
	quiere probar las opcione de login de la app

	Background: ejecucion de la apliacion
	Given que el usuario ingresar a la app de Banistmo 
	@tag1
	Scenario: Login exito
	When ingresa sus credenciales correctas
	Then el deberia poder ver la pagina principal de la app
	@tag2
	Scenario: Login exito recordando usuario
	When ingresa sus credenciales correctas y elige la opcion de recordar usuario
	And cuando el usuario cierre sesion y vuelva a ingresa a la app 
	Then el debera observar sus credenciales en el campos correspondiente 
	@tag3
	Scenario: onCheck
	When el usuario ingresa sus credenciales correctas y selecciona la opcion de recorda usuario
	And el usuario cierre su sesion y vuelca a ingresar a la app deberia de observar sus credenciales en el correspondiente campo
	And el usuario vuelva a hacer login en el app deseleccionado la opcion de recordar usuario
	Then cuando el cierre sesion y vuelva a ingresa a la app sus credenciales no deberian estar
	@tag4
	Scenario: Login fallido por usuario incorrecto
	When ingresa sus credenciales incorrectas
	Then el deberia de observa un mensaje de alerta 
	@tag5
	Scenario: Login fallido intento tres veces fallidas
	When el usuario ingresa sus credenciales fallando tres veces en su clave
	Then el deberia de observar un mensaje de alerta de bloqueo
	@tag6	
	Scenario: El usuario quiere ver su clave
	When el usuario ingresa sus credenciales y da click en la opcion ver clave
	Then el deberia poder ver su clave
	@tag7
	Scenario: Login fallido por el usuario bloqueado
	When el usuario ingresa sus credenciales bloqueadas
	Then el deberia de observar un mensaje de alerta de bloqueo
	@tag8
	Scenario: No se digita el usuario
	When el usuario no digita nada en el campo usuario
	Then el deberia de observar el boton continuar bloqueado
	@tag9
	Scenario: No se digita la clave
	When el usuario ingresa sus credenciales excepto su clave
	Then el deberia de observar el boton de acceder bloqueado
	@tag10
	Scenario: Ingreso de caracteres especiales
	When el usuario intenta ingresar caracteres especiales en le campo usuario
	Then el deberia el campo usuario vacio 
	@tag11
	Scenario: Digitar pocos caracteres en el campo de usuario
	When el usuario no ingresa su credencial completa en el campo usuario
	Then el botono continuar deberia de estar deshabilitado
	@tag12
	Scenario: Digita el maximo de caracteres en el campo de usuario
	When el usuario ingresa doce caracteres en el campo usuario
	Then el deberia de poder ver el boton continuar habiltado
	@tag13
	Scenario: Digitar pocos caracteres en el campo de clave
	When el usuario no ingresa su credencial completa en el campo clave
	Then el boton ingresar deberia de estar deshabilitado
	@tag14
	Scenario: Digita el maximo de caracteres en el campo de clave
	When el usuario ingresa el maximo de caracteres en el campo clave
	Then el deberia de poder ver el boton ingresar habiltado
	@tag15
	Scenario: Ver mensaje de tooltip de usuario
	When el usuario da click en el tooltip del campo usuario
	Then el deberia de observar un mensaje correspondiente al tooltip usuario
	@tag16
	Scenario: Ver mensaje de tooltip de clave
	When el usuario da click en el tooltip del campo clave
	Then el deberia de observar un mensaje correspondiente al tooltip clave
	@tag17
	Scenario: Login cancelado
	When el usuario ingresa sus credenciales pero cancela el login
	Then el deberia retornar a la opcion de ingresa sus credenciales de usuario
	
	
	
	
	