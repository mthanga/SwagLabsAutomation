package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import locators.CartPage;

public class CartPageStepDefinition extends BaseStepDefinition{
	
	@Then("^verify user is naviagted to your cart page$")
    public void verifyUserNaviagtedToCartPage() throws Throwable {
		CartPage cartpage = new CartPage();
		Assert.assertTrue(cartpage.isCartPageDispalyed());
	}

	@And("^user clicks on the checkout button$")
    public void userClicksCheckoutButton() throws Throwable {
		CartPage cartpage = new CartPage();
		cartpage.clickCheckoutBtn();
	}

	@And("^user removes \"([^\"]*)\" product from the cart$")
    public void userRemovesProductFromTheCart(String count) throws Throwable {
		CartPage cartpage = new CartPage();
		cartpage.removeProducts(count);
	}
	
}
