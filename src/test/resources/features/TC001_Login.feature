Feature:To check login functionality of swaglaps

	Background:
		Given user launching the app
	
	@login 
	Scenario Outline: TC001_Validating the login functionality of swaglabs app
		When user enters "User Name" as "<validusername>"
		And user enters "Password" as "<validpassword>"
		And user clicks on the login button
		Then verify user is redirecteds to Home Page
		And user closing the app
		
		Examples:
		|validusername|validpassword|
		|standard_user|secret_sauce|
		
	