Feature: Login
This fetaure will verify the login functionality of newtours application

Scenario: Verify Successful Login

Given User is on homepage
When User enters valid crendentials
Then User should be logged in successfully


#Scenario: Verify Successful Login passing the credentials in the steps
#
#Given User is on homepage
#When User enters "Jothi" and "Password123"
#Then User should be logged in successfully
#
#
#Scenario Outline: Verify Successful Login for multiple users
#
#Given I am on homepage
#When I enter "<Username>" and "<Password>"
#Then I should be logged in successfully
#
#Examples:
#| Username 	| Password 		|
#| Jothi 		| Password123 | 
#| Jeena			| Password123	|
#| Caroline	| Password123	|
#


