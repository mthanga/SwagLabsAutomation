package runner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import drivermanager.DriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue= {"stepdefinition"}, tags={"@Order"},
monochrome=true)
public class Runner {
	
	@Before
	public void openDriver() {
		DriverManager.getDriver();
	}
	
	@After
	public void closeDriver() {
		DriverManager.getDriver().quit();
	}

}
