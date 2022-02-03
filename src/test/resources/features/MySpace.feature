Feature: Space Page Feature

Background:
	Given user has already logged in to application
	|username|password|
	|anaphdz|123hernandez|

Scenario: Space page title
	Given user is on My Space page
	When user gets the title of the page
	Then page title should be "Mi Espacio"
	
Scenario: My Space section count
	Given user is on My Space page
	Then user gets account section
	|Consulta tu recibo|
	|Administrar mis recibos|
	|Pagar|
	And accounts section count should be 3
