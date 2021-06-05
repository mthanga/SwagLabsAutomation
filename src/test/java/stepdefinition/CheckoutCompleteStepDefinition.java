package stepdefinition;

import cucumber.api.java.en.Then;
import junit.framework.Assert;
import locators.CheckoutCompletePage;

public class CheckoutCompleteStepDefinition extends BaseStepDefinition{
	
	@Then("^verify user is redirected to order confirmation page$")
    public void verifyUserIsRedirectedToOrderConfirmationPage() throws Throwable {
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
		Assert.assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed());
	}

	@Then("^veify the order confirmaiton message as \"([^\"]*)\"$")
    public void veifyOrderConfirmationText(String expectedText) throws Throwable {
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
		Assert.assertEquals(expectedText.toLowerCase(), checkoutCompletePage.getOrderConfirmationText().toLowerCase());
	}
}
