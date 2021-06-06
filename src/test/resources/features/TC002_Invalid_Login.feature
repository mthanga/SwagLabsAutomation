Feature:To check login functionality of swaglaps

	Background:
		Given user launching the app
	
		
	@InvalidLogin
	Scenario Outline: TC002_Validating the login functionality with invalid credentials
		When user enters "User Name" as "<invalidusername>"
		And user clicks on the login button
		Then verify login error message as "Password is required"
		And user clears the text in the "User Name" input
		And user enters "Password" as "<invalidpassword>"
		And user clicks on the login button
		Then verify login error message as "Username is required"
		When user enters "User Name" as "<invalidusername>"
		And user enters "Password" as "<validpassword>"
		And user clicks on the login button
		Then verify login error message as "Username and password do not match any user in this service."
		When user enters "User Name" as "<validusername>"
		And user enters "Password" as "<invalidvalidpassword>"
		And user clicks on the login button
		Then verify login error message as "Username and password do not match any user in this service."
		When user enters "User Name" as "<invalidusername>"
		And user enters "Password" as "<invalidpassword>"
		And user clicks on the login button
		Then verify login error message as "Username and password do not match any user in this service."
		
		Examples:
			|invalidusername|invalidpassword|validpassword|validusername|
			|test|test|standard_user|secret_sauce|
			
		
		
		
		