package commonhelper;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivermanager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonHelper {
	public static Properties property = null;

	public static void waitForElementVisibility(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	private static void swipeUp() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int starty = (int) (size.height * 0.65);
        int endy = (int) (size.height * 0.2);
        int startx = (int) (size.width / 2.0);
        try {
            new TouchAction(DriverManager.getDriver()).press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(startx, endy)).release().perform();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

	public static void scrollToMobileElement(MobileElement element, String scrollCount) {
        try {
            int count = Integer.parseInt(scrollCount);
            for (int i = 0; i < count; i++) {
                if (isElementDispalyed(element)) {
                    break;
                } else {
                	swipeUp();
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
	
	public static void scrollToMobileElementOnce(MobileElement element) {
		try {
			if (!isElementDispalyed(element)) {
				swipeUp();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isElementDispalyed(MobileElement element) {
		boolean isDisplayed = true;
		try {
			isDisplayed = element.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}
	
	public static void loadProperty() {
		try {
			String fileName = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"Config"+File.separator+"Config.properties";
			FileReader reader=new FileReader(fileName);
			property=new Properties();  
			property.load(reader); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
}
