package locators;

import org.openqa.selenium.support.PageFactory;

import commonhelper.CommonHelper;
import constant.Constant;
import drivermanager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage implements Constant{

	public CheckoutPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView")
	public MobileElement checkoutInformationTitle;

	@AndroidFindBy(accessibility = "test-First Name")
	public MobileElement firstName;

	@AndroidFindBy(accessibility = "test-Last Name")
	public MobileElement lastName;

	@AndroidFindBy(accessibility = "test-Zip/Postal Code")
	public MobileElement postalCode;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView")
	public MobileElement continueBtn;

	
	public boolean isCheckoutInformationPageDisplayed() {
		@SuppressWarnings("unused")
		boolean isDisplayed = true;
		try {
			isDisplayed = checkoutInformationTitle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void fillCheckoutInformation(String field, String value) {
		MobileElement element = null;
		try {
			switch (field) {
			case First_Name:
				element = firstName;
				break;
			case Last_Name:
				element = lastName;
				break;
			case Postal_Code:
				element = postalCode;
				break;
			}
			CommonHelper.waitForElementVisibility(element);
			element.sendKeys(value);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickContinueBtn() {
		try {
			CommonHelper.waitForElementVisibility(continueBtn);
			continueBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
