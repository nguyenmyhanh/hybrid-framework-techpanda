package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratormanager {
	public static HomepageObject getHomePage(WebDriver driver) {
		return new HomepageObject(driver);
	}

}
