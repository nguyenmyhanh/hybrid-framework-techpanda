package pageObject.techpanda.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.techpanda.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void inPutToUsernameTextbox(String emailAddress) {
		waitForElementVisble(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public void inPutToPasswordTextbox(String password) {
		waitForElementVisble(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public AdminDashboardPageObject clickToTheLoginButton() {
		waitForElementVisble(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.adminDashboardPage(driver);

	}

	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inPutToUsernameTextbox(emailAddress);
		inPutToPasswordTextbox(password);
		return clickToTheLoginButton();

	}

}
