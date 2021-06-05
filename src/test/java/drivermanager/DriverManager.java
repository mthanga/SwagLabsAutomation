package drivermanager;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import commonhelper.CommonHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	
	public static AppiumDriver driver;
	
	public static AppiumDriver getDriver() {
		try {
			if(driver == null) {
				CommonHelper.loadProperty();
				initializeDriver();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static void initializeDriver() {
		try {
			File app = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"Config"+File.separator+CommonHelper.property.getProperty("ApkPathName"));
			
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("app", app.getAbsolutePath());
			capability.setCapability("deviceName", CommonHelper.property.getProperty("DeviceName"));
			capability.setCapability("platformName", CommonHelper.property.getProperty("PlatformName"));
			capability.setCapability("appPackage", CommonHelper.property.getProperty("AppPackage"));
			capability.setCapability("appActivity", CommonHelper.property.getProperty("AppActivity"));
			capability.setCapability("automationName", CommonHelper.property.getProperty("AutomationName"));
			driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capability);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
