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

public class Level_07_Switch_Page extends BaseTest {
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
	public void User_01_Register() {
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
	}

	@Test
	public void User_02_Login() {
		loginPageObject = homePage.clickToLoginLink();

		loginPageObject.inputEmailTextbox(existingEmail);
		loginPageObject.inputToPasswordTextbox(password);
		homePage = loginPageObject.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountDisplayed());

	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.clickMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// customer infor -> address
		addressPage = customerInforPage.openAddressPage(driver);

		// Address -> my product review
		myProductReviewPage = addressPage.openMyProductReview(driver);
		// my product review -> reward point
		rewardPointPage = myProductReviewPage.openRewardPoint(driver);
		// Reward pont -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPoint(driver);
		// Reward Point -> My product Review
		myProductReviewPage = rewardPointPage.openMyProductReview(driver);
		addressPage = myProductReviewPage.openAddressPage(driver);
		rewardPointPage = addressPage.openRewardPoint(driver);
		customerInforPage = rewardPointPage.openCustomerInforPage(driver);
	}

	@Test
	public void User_04_Switch_Role() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
