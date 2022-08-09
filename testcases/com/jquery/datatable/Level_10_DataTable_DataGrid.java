package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomepageObject;
import pageObject.jQuery.PageGeneratormanager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomepageObject homePage;
	List<String> actualAllCountryValue;
	List<String> expectedAllCountryValue;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratormanager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingByNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));

		homePage.openPagingByNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));

	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterHeaderTextboxByLabel("Country", "Singapore");
		homePage.enterHeaderTextboxByLabel("Females", "32000");
		homePage.enterHeaderTextboxByLabel("Males", "35300");
		homePage.enterHeaderTextboxByLabel("Total", "69600");
		homePage.sleepInSecond(3);

		homePage.enterHeaderTextboxByLabel("Country", "Denmark");
		homePage.enterHeaderTextboxByLabel("Females", "34730");
		homePage.enterHeaderTextboxByLabel("Males", "36555");
		homePage.enterHeaderTextboxByLabel("Total", "71285");

	}

	// @Test
	public void Table_03_Enter_To_Header() {
		actualAllCountryValue = homePage.getValuesEachRowAtAllPage();

		Assert.assertEquals(actualAllCountryValue, expectedAllCountryValue);
	}

	@Test
	public void Table_04_Enter_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(5);

		// homePage.enterToTextboxAtTowNumberByColumName("Album", "2", "Michael 97");
		// homePage.enterToTextboxAtTowNumberByColumName("Artist", "4", "Michael 97");
		// homePage.enterToTextboxAtTowNumberByColumName("Year", "3", "1997");
		// homePage.enterToTextboxAtTowNumberByColumName("Price", "1", "15");
		// homePage.selectdropdowByColumNameAtRowNumber("Origin", "1", "Hong Kong");
		//
		// homePage.checkToCheckboxByColumNameAtRowNumber("With Poster?", "3");
		// homePage.checkToCheckboxByColumNameAtRowNumber("With Poster?", "5");
		//
		// homePage.uncheckToCheckboxByColumNameAtRowNumber("With Poster?", "1");
		// homePage.uncheckToCheckboxByColumNameAtRowNumber("With Poster?", "2");
		// homePage.uncheckToCheckboxByColumNameAtRowNumber("With Poster?", "4");

		homePage.clickToIconByRowNumber("1", "Remove Current Row");

		homePage.clickToIconByRowNumber("1", "Insert Row Above");

		homePage.clickToIconByRowNumber("3", "Move Up");

		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");

	}

	@AfterClass
	public void afterclass() {
		// driver.quit();
	}

}
