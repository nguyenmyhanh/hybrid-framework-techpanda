package pageObjectFacebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratormanager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}
