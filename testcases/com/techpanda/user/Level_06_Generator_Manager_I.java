package com.techpanda.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.techpanda.user.UserHomePageObject;
import pageObject.techpanda.user.UserLoginPageObject;
import pageObject.techpanda.user.UserRegisterPageObject;

public class Level_06_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPageObject;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "afc@afc@.vn";
		notFoundEmail = "afc" + generateFakeNumber() + "@gmai.vn";
		password = "123456";
		existingEmail = "afc" + generateFakeNumber() + "@gmai.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		homePage = new UserHomePageObject(driver);
		System.out.println("Pre_Condition - Step 01: click to register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

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
		registerPage.clickToLogoutbutton();
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPageObject = new UserLoginPageObject(driver);

		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPageObject = new UserLoginPageObject(driver);

		loginPageObject.inputEmailTextbox(invalidEmail);
		loginPageObject.clickToLoginButton();

		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		loginPageObject = new UserLoginPageObject(driver);

		loginPageObject.inputEmailTextbox(notFoundEmail);
		loginPageObject.clickToLoginButton();

		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();
		loginPageObject = new UserLoginPageObject(driver);

		loginPageObject.inputEmailTextbox(existingEmail);
		loginPageObject.inputToPasswordTextbox("");

		loginPageObject.clickToLoginButton();

		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();
		loginPageObject = new UserLoginPageObject(driver);

		loginPageObject.inputEmailTextbox(existingEmail);
		loginPageObject.inputToPasswordTextbox("1231231234");
		loginPageObject.clickToLoginButton();

		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();
		loginPageObject = new UserLoginPageObject(driver);

		loginPageObject.inputEmailTextbox(existingEmail);
		loginPageObject.inputToPasswordTextbox(password);
		loginPageObject.clickToLoginButton();

		homePage = new UserHomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
