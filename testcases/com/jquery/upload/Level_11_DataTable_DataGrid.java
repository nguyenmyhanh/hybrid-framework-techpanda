package com.jquery.upload;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomepageObject;
import pageObject.jQuery.PageGeneratormanager;

public class Level_11_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomepageObject homePage;
	String dl = "dl.jpg";
	String pc = "PC.jpg";
	String sapa = "sapa.jpg";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratormanager.getHomePage(driver);
	}

	@Test
	public void TC_01_One_File() {
		homePage.uploadMutupleFiles(driver, dl);
		Assert.assertTrue(homePage.isFileNameLoadedSuccess(dl));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileUploadSuccess(dl));

	}

	@Test
	public void TC_02_Mutiple_File() {
		homePage.refreshCurrentPage(driver);

		homePage.uploadMutupleFiles(driver, dl, pc, sapa);
		Assert.assertTrue(homePage.isFileNameLoadedSuccess(dl));
		Assert.assertTrue(homePage.isFileNameLoadedSuccess(pc));
		Assert.assertTrue(homePage.isFileNameLoadedSuccess(sapa));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileUploadSuccess(dl));
		Assert.assertTrue(homePage.isFileUploadSuccess(pc));
		Assert.assertTrue(homePage.isFileUploadSuccess(sapa));

	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

}
