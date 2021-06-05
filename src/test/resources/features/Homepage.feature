Feature:To check login functionality of swaglaps

	Background:
		Given user launching the app
		
	@AddToCart @all
	Scenario Outline: TC003_Validating user can able to add products to cart
		When user enters "User Name" as "<validusername>"
		And user enters "Password" as "<validpassword>"
		And user clicks on the login button
		Then verify user is redirecteds to Home Page
		And user adds first "2" products to the cart
		
		Examples:
		|validusername|validpassword|
		|standard_user|secret_sauce|
		
		
	@Order @all
	Scenario Outline: TC004_Validating user can able complete the order
		When user enters "User Name" as "<validusername>"
		And user enters "Password" as "<validpassword>"
		And user clicks on the login button
		Then verify user is redirecteds to Home Page
		And user adds first "2" products to the cart
		And user clicks on the cart icon
		Then verify user is naviagted to your cart page
		And user removes "1" product from the cart
		And user clicks on the checkout button
		Then verify user is redirected to checkout information page
		When user fills "First Name" as "<firstname>" on checkout information page
		And user fills "Last Name" as "<lastname>" on checkout information page
		And user fills "Postal Code" as "<postalcode>" on checkout information page
		And user clicks on the continue button
		Then verify user is redirected to checkout overview page
		And user clicks on the finish button
		Then verify user is redirected to order confirmation page
		Then veify the order confirmaiton message as "Thank you for you order"
		
		Examples:
		|validusername|validpassword|firstname|lastname|postalcode|
		|standard_user|secret_sauce|Thangaraj|Matheson|636303|
		
		
	
	