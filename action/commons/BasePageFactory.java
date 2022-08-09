package commons;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();

	}

	protected void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();

	}

	protected boolean isElementDisplay(WebDriver driver, WebElement element) {
		return element.isDisplayed();

	}

	protected void waitForElementVisble(WebDriver driver, WebElement element) {
		WebDriverWait expliciWait = new WebDriverWait(driver, longTimeout);
		expliciWait.until(ExpectedConditions.visibilityOf(element));

	}

	protected void waitForAllElementVisble(WebDriver driver, List<WebElement> elements) {
		WebDriverWait expliciWait = new WebDriverWait(driver, longTimeout);
		expliciWait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	protected void waitForElementInVisble(WebDriver driver, WebElement element) {
		WebDriverWait expliciWait = new WebDriverWait(driver, longTimeout);
		expliciWait.until(ExpectedConditions.invisibilityOf(element));

	}

	protected void waitForAllElementInVisble(WebDriver driver, List<WebElement> elements) {
		WebDriverWait expliciWait = new WebDriverWait(driver, longTimeout);
		expliciWait.until(ExpectedConditions.invisibilityOfAllElements(elements));

	}

	protected void waitForAllElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait expliciWait = new WebDriverWait(driver, longTimeout);
		expliciWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	private long longTimeout = 30;

}
