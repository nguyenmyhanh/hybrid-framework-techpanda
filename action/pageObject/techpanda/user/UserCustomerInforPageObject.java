package pageObject.techpanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.user.CustomerInforUI;

public class UserCustomerInforPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisble(driver, CustomerInforUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplay(driver, CustomerInforUI.CUSTOMER_INFOR_HEADER);
	}

}
