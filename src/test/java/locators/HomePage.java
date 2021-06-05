package locators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import commonhelper.CommonHelper;
import drivermanager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
	public MobileElement homePageTitle;

	@AndroidFindBy(xpath = "//*[@content-desc=\"test-Cart\"]")
	public MobileElement cartCountElement;

	@AndroidFindBy(xpath = "//*[@content-desc='test-ADD TO CART']")
	public List<MobileElement> addToCartBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"REMOVE\"]")
	public List<MobileElement> removeBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	public MobileElement filterIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
	public MobileElement priceLowToHigh;

	public boolean isHomePageDisplayed() {
		boolean isDisplayed = true;
		try {
			CommonHelper.waitForElementVisibility(homePageTitle);
			isDisplayed = homePageTitle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDisplayed;
	}

	public void addProducts(String count) {
		try {
			for (int index = 0; index < Integer.parseInt(count); index++) {
				if (addToCartBtn.size() == 1) {
					index--;
					CommonHelper.waitForElementVisibility(addToCartBtn.get(index));
					addToCartBtn.get(index).click();
					break;
				}
				CommonHelper.scrollToMobileElementOnce(addToCartBtn.get(index));
				addToCartBtn.get(index).click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCartIndicatorCount() {
		String count = null;
		try {
			count = cartCountElement.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public void clickCartIcon() {
		try {
			cartCountElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
