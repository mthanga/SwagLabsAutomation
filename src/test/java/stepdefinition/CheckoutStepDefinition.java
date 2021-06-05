package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;
import locators.CheckoutPage;

public class CheckoutStepDefinition extends BaseStepDefinition{
	
	@Then("^verify user is redirected to checkout information page$")
    public void verifyUserRedirectedToCheckoutInformationPage() throws Throwable {
		CheckoutPage checkoutPage = new CheckoutPage();
		Assert.assertTrue(checkoutPage.isCheckoutInformationPageDisplayed());
    }
	
	@When("^user fills \"([^\"]*)\" as \"([^\"]*)\" on checkout information page$")
    public void userFillsCheckoutInformationPage(String field, String value) throws Throwable {
		CheckoutPage checkoutPage = new CheckoutPage();
		checkoutPage.fillCheckoutInformation(field, value);
	}
	
	@And("^user clicks on the continue button$")
    public void userClicksContinueButton() throws Throwable {
		CheckoutPage checkoutPage = new CheckoutPage();
		checkoutPage.clickContinueBtn();
	}

}
