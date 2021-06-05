package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import drivermanager.DriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue= {"stepdefinition"}, tags={"@all"},
monochrome=true)
public class Runner {
	
	

}
