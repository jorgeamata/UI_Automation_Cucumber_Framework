Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Mi Espacio"

Scenario: Forgot Password link
Given user is on login page
Then ¿Olvidaste tu contraseña? link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "anaphdz"
And user enters password "123hernandez"
And user clicks on Login button
Then user gets the title of the page
And page title should be "Mi Espacio"