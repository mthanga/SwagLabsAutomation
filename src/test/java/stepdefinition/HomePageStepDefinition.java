package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import locators.HomePage;

public class HomePageStepDefinition extends BaseStepDefinition {
	
	@And("^user adds first \"([^\"]*)\" products to the cart$")
    public void userAddsProductsToCart(String count) throws Throwable {
		HomePage homePage = new HomePage();
		homePage.addProducts(count);
	}

	@Then("^veriy the card indicator count should display \"([^\"]*)\"$")
    public void veriyCartIndicatorCount(String count) throws Throwable {
		HomePage homepage = new HomePage();
		Assert.assertEquals(count, homepage.getCartIndicatorCount());
    }

	@And("^user clicks on the cart icon$")
    public void userClicksCartIcon() throws Throwable {
		HomePage homepage = new HomePage();
		homepage.clickCartIcon();
	}
}
