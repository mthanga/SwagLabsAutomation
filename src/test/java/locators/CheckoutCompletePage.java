package locators;

import org.openqa.selenium.support.PageFactory;

import commonhelper.CommonHelper;
import drivermanager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutCompletePage {

	public CheckoutCompletePage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView")
	public MobileElement checkoutCompleteTitle;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
	public MobileElement thanksText;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]/android.widget.TextView")
	public MobileElement backToHome;
	
	public boolean isCheckoutCompletePageDisplayed() {
		boolean isDisplayed = true;
		try {
			isDisplayed = checkoutCompleteTitle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void clickBackToHomeBtn() {
		try {
			backToHome.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getOrderConfirmationText() {
		String orderConfirmationText = null;
		try {
			CommonHelper.waitForElementVisibility(thanksText);
			orderConfirmationText = thanksText.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderConfirmationText;
	}

}
