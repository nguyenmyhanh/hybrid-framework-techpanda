package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectFacebook.LoginPageObject;
import pageObjectFacebook.PageGeneratormanager;

@Listeners(commons.MethodListener.class)
public class Level_10_Assert_Verify extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratormanager.getLoginPage(driver);

	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		log.info("Login_01-Step 01: Click to Create new Account button");
		loginPage.clickToCreateNewAccountButton();

		log.info("Login_01-Step 02: email address textbox displayed");
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());

	}

	@Test
	public void TC_02_Verify_Element_UnDdisplayed_In_Dom() {
		log.info("Login_02-Step 01: Enter data into email address textbox");
		loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(3);

		log.info("Login_02-Step 02: Confirm Email address textbox displayed");
		verifyTrue(loginPage.isConfirmAddressEmailTextboxDisplayes());

		log.info("Login_02-Step 03: Enter data into email address textbox with empty");
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);

		log.info("Login_02-Step 04:Confirm Email address textbox isn't displayed ");
		verifyFalse(loginPage.isConfirmAddressEmailTextboxDisplayes());

	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_Dom() {
		log.info("Login_03-Step 01: Click close icon button");
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(3);

		log.info("Login_03-Step 02: Confirm Email address textbox Undisplayed");
		verifyTrue(loginPage.isConfirmAddressEmailTextboxUnDisplayes());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
