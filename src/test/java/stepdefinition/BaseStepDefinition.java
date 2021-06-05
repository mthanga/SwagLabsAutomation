package stepdefinition;



import drivermanager.DriverManager;
import io.appium.java_client.AppiumDriver;

public class BaseStepDefinition {
	
	public static AppiumDriver getDriver() {
		return (AppiumDriver) DriverManager.getDriver();
	}

}
