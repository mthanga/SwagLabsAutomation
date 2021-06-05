package locators;

import org.openqa.selenium.support.PageFactory;

import commonhelper.CommonHelper;
import constant.Constant;
import drivermanager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage implements Constant{
	
	public LoginPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}
	
	@AndroidFindBy(accessibility = "test-Username")
	public MobileElement userName;
	
	@AndroidFindBy(accessibility = "test-Password")
	public MobileElement password;
	
	@AndroidFindBy(accessibility = "test-LOGIN")
	public MobileElement loginButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
	public MobileElement loginErrorField;
	
	
	public void entersUserNameAndPassword(String field, String value) {
		MobileElement element = null;
		try {
			switch(field) {
			case User_Name:
				element = userName;
				break;
			case Password:
				element = password;
				break;
			}
			
			element.sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnLoginBtn() {
		try {
			loginButton.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getLoginErrorMessage() {
		String errorMessage = null;
		try {
			CommonHelper.waitForElementVisibility(loginErrorField);
			errorMessage = loginErrorField.getText();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return errorMessage;
	}
	
	public void clearUserNameAndPassword(String field) {
		MobileElement element = null;
		try {
			switch(field) {
			case User_Name:
				element = userName;
				break;
			case Password:
				element = password;
				break;
			}
			
			element.clear();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
