package locators;

import org.openqa.selenium.support.PageFactory;

import commonhelper.CommonHelper;
import drivermanager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutOverviewPage {

	public CheckoutOverviewPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView")
	public MobileElement checkoutOverviewTitle;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView")
	public MobileElement finishBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CANCEL\"]/android.widget.TextView")
	public MobileElement cancelBtn;

	
	public boolean isCheckoutOverviewPageDisplayed() {
		boolean isDisplayed = true;
		try {
			isDisplayed = checkoutOverviewTitle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void clickFinishBtn() {
		try {
			CommonHelper.scrollToMobileElement(finishBtn,"3");
			finishBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
