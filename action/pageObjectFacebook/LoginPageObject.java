package pageObjectFacebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIfacebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForAllElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTOM);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTOM);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisble(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplay(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisble(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);

	}

	public boolean isConfirmAddressEmailTextboxDisplayes() {

		return isElementDisplay(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconAtRegisterForm() {
		waitForAllElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);

	}

	public boolean isConfirmAddressEmailTextboxUnDisplayes() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

}
