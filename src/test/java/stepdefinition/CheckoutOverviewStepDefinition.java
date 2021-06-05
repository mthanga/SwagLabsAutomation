package stepdefinition;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import locators.CheckoutOverviewPage;

public class CheckoutOverviewStepDefinition extends BaseStepDefinition{
	
	@Then("^verify user is redirected to checkout overview page$")
    public void verifyUserIsedirectedToCheckoutOverviewPage() throws Throwable {
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
		Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageDisplayed());
	}
	
	@And("^user clicks on the finish button$")
    public void userClicksFinishButton() throws Throwable {
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
		checkoutOverviewPage.clickFinishBtn();
	}
}
