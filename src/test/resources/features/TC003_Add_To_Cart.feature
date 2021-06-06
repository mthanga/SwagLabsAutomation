Feature:To check login functionality of swaglaps

	Background:
		Given user launching the app
		
	@AddToCart
	Scenario Outline: TC003_Validating user can able to add products to cart
		When user enters "User Name" as "<validusername>"
		And user enters "Password" as "<validpassword>"
		And user clicks on the login button
		Then verify user is redirecteds to Home Page
		And user adds first "2" products to the cart
		
		Examples:
		|validusername|validpassword|
		|standard_user|secret_sauce|
		
		
	