#@tag @tags
Feature: home
	como usuario de la app de banistmo
	quiere probar las opciones del home
	
	
	Background: ejecucion de la apliacion y hacer login
	Given que el usuario ingresa a la app de Banistmo y hace su login
	@tag1
	Scenario: Visualizar el encabezado
	Then el deberia de ver el encabezado del home
	@tag2
	Scenario: Visualizar el menu
	Then el deberia de ver el menu de la app
	@tag3
	Scenario: Visualizar la opcion de transferencias
	Then el deberia de ver la opcion de transferencias 
	@tag4
	Scenario: Visualizar la opcion de pagos
	Then el deberia de ver la opcion de pagos 
	@tag5
	Scenario: Visualizar la opcion de recargas
	Then el deberia de ver la opcion de recargas
	@tag6
	Scenario: Visualizar la opcion de mas
	Then el deberia de ver la opcion de mas
	@tag7
	Scenario: Visualizar saldos generales
	Then el deberia de ver informacion de sus saldos generales
	@tag8
	Scenario: Visualizar seccion de productos
	Then el deberia de ver la sesccion de sus productos
	@tag9
	Scenario: Visualizar la opcion d productos
	Then el deberia de ver la opcion de productos
	@tag10
	Scenario: Visualizar saldos consolidados
	Then el deberia de ver sus saldos consolidados
	@tag11
	Scenario: Visualizar detalle de cuenta
	Then el deberia de ver el detalle de sus cuentas
	@tag12
	Scenario: Visualizar detalle de inversiones
	Then el deberia de ver el detalle de sus inversiones
	@tag13
	Scenario: Visualizar detalle de creditos
	Then el deberia de ver el detalle de sus creditos
	@tag14
	Scenario: Visualizar detalle de prestamos
	Then el deberia de ver el detalle de sus prestamos  
	@tag15
	Scenario: Visualizar card
	And de click en la opcion de ver productos en formato de cards
	Then el deberia de ver sus productos en formato de cards
	@tag16
	Scenario: Visualizar list
	And de click en la opcion de ver productos en formato de list
	Then el deberia de ver sus productos en formato de lista
	@tag17
	Scenario: Visualizar card detalles depositos
	And de click en la opcion de ver detalles de deposito
	Then el usuario deberia ver el detalle de sus depositos
	@tag18
	Scenario: Visualizar card detalles inversiones
	And de click en la opcion de ver detalles de inversiones
	Then el usuario deberia ver el detalle de sus inversiones
	@tag19
	Scenario: Visualizar card detalles creditos
	And de click en la opcion de ver detalles de creditos
	Then el usuario deberia de ver el detalle de sus creditos
	@tag20
	Scenario: Visualizar card detalles prestamos
	And de click en la opcion de ver detalle de prestamos
	Then el usuario deberia de ver el detalle de sus prestamos
	
	
	
	   
	
	