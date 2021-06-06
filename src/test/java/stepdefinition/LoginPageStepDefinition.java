package stepdefinition;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import locators.HomePage;
import locators.LoginPage;

public class LoginPageStepDefinition extends BaseStepDefinition{
	
	@Given("^user launching the app$")
    public void userLaunchingTheApp() throws Throwable {
		System.out.println("-----------Execution starts--------------");
		getDriver();
	}
	
	@Given("^user closing the app$")
    public void userClosingTheApp() throws Throwable {
		System.out.println("-----------Execution completed--------------");
		getDriver().quit();
	}

	@When("^user enters \"([^\"]*)\" as \"([^\"]*)\"$")
    public void userEntersUserNameAndPassword(String field, String value) throws Throwable {
		LoginPage loginpage = new LoginPage();
		loginpage.entersUserNameAndPassword(field, value);
	}
	
	@And("^user clicks on the login button$")
    public void userClicksLoginButton() throws Throwable {
		LoginPage loginpage = new LoginPage();
		loginpage.clickOnLoginBtn();
	}
	
	@Then("^verify login error message as \"([^\"]*)\"$")
    public void verifyLoginErrorMessage(String expectedMessage) throws Throwable {
		LoginPage loginpage = new LoginPage();
		Assert.assertEquals(expectedMessage.trim(), loginpage.getLoginErrorMessage().trim());
    }
	
	@And("^user clears the text in the \"([^\"]*)\" input$")
    public void userClearsEnteredTextt(String field) throws Throwable {
		LoginPage loginpage = new LoginPage();
		loginpage.clearUserNameAndPassword(field);
	}
	
	@Then("^verify user is redirecteds to Home Page$")
    public void verifyUserIsRedirectedsToHomePage() throws Throwable {
		HomePage homepage = new HomePage();
		Assert.assertTrue(homepage.isHomePageDisplayed());
	}
}
