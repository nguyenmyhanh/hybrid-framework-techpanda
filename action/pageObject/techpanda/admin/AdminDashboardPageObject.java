package pageObject.techpanda.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.admin.AdminDashboardUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisble(driver, AdminDashboardUI.DASHBOARD_HEADER);
		return isElementDisplay(driver, AdminDashboardUI.DASHBOARD_HEADER);

	}

}
