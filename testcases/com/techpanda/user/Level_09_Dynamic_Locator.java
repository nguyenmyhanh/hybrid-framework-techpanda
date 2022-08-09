package com.techpanda.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.techpanda.user.UserAddressPageObject;
import pageObject.techpanda.user.UserCustomerInforPageObject;
import pageObject.techpanda.user.UserHomePageObject;
import pageObject.techpanda.user.UserLoginPageObject;
import pageObject.techpanda.user.UserMyProductReviewObject;
import pageObject.techpanda.user.UserRegisterPageObject;
import pageObject.techpanda.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPageObject;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		existingEmail = "afc" + generateFakeNumber() + "@gmai.com";

	}

	@Test
	public void User_01_Register_Login() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		System.out.println("Pre_Condition - Step 01: click to register link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("Pre_Condition - Step 02: input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordtTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre_Condition - Step 03: click to Register button");
		registerPage.clickToRegisterbutton();

		System.out.println("Pre_Condition -Step 04: Verify success message displayed");

		Assert.assertEquals(registerPage.getRegisterSuccessrMessage(), "Your registration completed");
		System.out.println("Pre_Condition - Step 05: click to Logout button");
		homePage = registerPage.clickToLogoutbutton();
		loginPageObject = homePage.clickToLoginLink();

		loginPageObject.inputEmailTextbox(existingEmail);
		loginPageObject.inputToPasswordTextbox(password);
		homePage = loginPageObject.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountDisplayed());
		customerInforPage = homePage.clickMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

	}

	@Test
	public void User_02_Dynamic_Page_02() {

		addressPage = (UserAddressPageObject) customerInforPage.openPageMyAccountByName(driver, "Addresses");
		myProductReviewPage = (UserMyProductReviewObject) addressPage.openPageMyAccountByName(driver, "My product reviews");
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPageMyAccountByName(driver, "Reward points");
		customerInforPage = (UserCustomerInforPageObject) rewardPointPage.openPageMyAccountByName(driver, "Customer info");
	}

	@Test
	public void User_02_Dynamic_Page_03() {
		customerInforPage.openPageMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		myProductReviewPage.openPageMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewarPointPage(driver);

		rewardPointPage.openPageMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);

		addressPage.openPageMyAccountByPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
