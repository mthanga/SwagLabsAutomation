package locators;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import commonhelper.CommonHelper;
import drivermanager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {

	public CartPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView")
	public MobileElement yourCartTitle;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]/android.widget.TextView")
	public MobileElement checkoutButton;
	
	@AndroidFindBy(accessibility = "test-REMOVE")
	public List<MobileElement> removeBtn;
	
	public boolean isCartPageDispalyed() {
		boolean isDisplayed = true;
		try {
			CommonHelper.waitForElementVisibility(yourCartTitle);
			isDisplayed = yourCartTitle.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isDisplayed;
	}
	
	public void clickCheckoutBtn() {
		try {
			CommonHelper.waitForElementVisibility(checkoutButton);
			checkoutButton.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeProducts(String count) {
		int productCount = Integer.parseInt(count);
		try {
			for(int index=0; index<productCount; index++) {
				CommonHelper.waitForElementVisibility(removeBtn.get(index));
				removeBtn.get(index).click();
				index--;
				productCount--;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
