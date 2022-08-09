package pageObject.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jQuery.HomePageUI;

public class HomepageObject extends BasePage {
	WebDriver driver;

	public HomepageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByNumber(String pageNumber) {
		waitForAllElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisble(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);

	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisble(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);

		return isElementDisplay(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);

	}

	public List<String> getValuesEachRowAtAllPage() {
		int totalpage = getElementSize(driver, HomePageUI.TOTAL_PAGE);

		List<String> allRowValues = new ArrayList<String>();

		for (int index = 1; index <= totalpage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));

			// List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValues.add(eachRow.getText());

			}

		}
		for (String eachRow : allRowValues) {
			System.out.println(eachRow);

		}
		return allRowValues;

	}

	public void enterToTextboxAtTowNumberByColumName(String colunName, String rowNumber, String value) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, colunName) + 1;

		waitForElementVisble(driver, HomePageUI.TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columIndex));

	}

	public void selectdropdowByColumNameAtRowNumber(String columName, String rowNumber, String value) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName) + 1;
		waitForAllElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		selectItemDropdown(driver, HomePageUI.DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columIndex));

	}

	public void clickToLoadButton() {
		waitForAllElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);

	}

	public void checkToCheckboxByColumNameAtRowNumber(String columName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName) + 1;
		waitForAllElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
	}

	public void uncheckToCheckboxByColumNameAtRowNumber(String columName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName) + 1;
		waitForAllElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForAllElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);

	}

	public boolean isFileNameLoadedSuccess(String fileName) {
		waitForElementVisble(driver, HomePageUI.IMAGE_FILE_NAME_LOADED, fileName);

		return isElementDisplay(driver, HomePageUI.IMAGE_FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtonWlements = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtonWlements) {
			waitForAllElementClickable(driver, startButton);
			startButton.click();
			sleepInSecond(2);

		}

	}

	public boolean isFileUploadSuccess(String fileName) {
		waitForElementVisble(driver, HomePageUI.IMAGE_FILE_UPLOADED, fileName);

		return isElementDisplay(driver, HomePageUI.IMAGE_FILE_UPLOADED, fileName);
	}

}
