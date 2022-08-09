package com.techpanda.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.techpanda.user.UserHomePageObject;
import pageObject.techpanda.user.UserRegisterPageObject;

public class Level_03_Page_Object_01 {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAdress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\brownserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAdress = "afc" + generateFakeNumber() + "@gmai.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);

	}

	@Test
	public void Register_01_Empty_Data() {
		// waitForAllElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Register_01 - Step 01: click to register link");
		homePage.clickToRegisterLink();

		// waitForAllElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_01 - Step 02: click to Register button");
		registerPage.clickToRegisterbutton();

		System.out.println("Register_01 -Step 03: Verify error message displayed");

		// Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

		Assert.assertEquals(registerPage.getErrorMessageAtFisrtNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailNameTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPaswordNameTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPawordNameTextBox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		// waitForAllElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");

		System.out.println("Register_02 - Step 01: click to register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		// sedkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// sedkeyToElement(driver, "//input[@id='LastName']", "FC");
		// sedkeyToElement(driver, "//input[@id='Email']", "123@456#*");
		// sedkeyToElement(driver, "//input[@id='Password']", "123123");
		// sedkeyToElement(driver, "//input[@id='ConfirmPassword']", "123123");
		//
		System.out.println("Register_02 - Step 02: input to required fields");
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox("123@456#*");
		registerPage.inputToPasswordtTextbox("123123");
		registerPage.inputToConfirmPasswordTextbox("123123");

		// waitForAllElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register_02 - Step 02: click to Register button");
		registerPage.clickToRegisterbutton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
		System.out.println("Register_02 -Step 04: Verify error message displayed");

		Assert.assertEquals(registerPage.getErrorMessageAtEmailNameTextBox(), "Wrong email");

	}

	@Test
	public void Register_03_success() {
		// waitForAllElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Register_03 - Step 01: click to register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		// sedkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// sedkeyToElement(driver, "//input[@id='LastName']", "FC");
		// sedkeyToElement(driver, "//input[@id='Email']", emailAdress);
		// sedkeyToElement(driver, "//input[@id='Password']", "123123");
		// sedkeyToElement(driver, "//input[@id='ConfirmPassword']", "123123");

		System.out.println("Register_03 - Step 02: input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordtTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		// waitForAllElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register_03 - Step 03: click to Register button");
		registerPage.clickToRegisterbutton();

		// Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		System.out.println("Register_03 -Step 04: Verify success message displayed");

		Assert.assertEquals(registerPage.getRegisterSuccessrMessage(), "Your registration completed");

		// waitForAllElementClickable(driver, "//a[@class='ico-logout']");
		// clickToElement(driver, "//a[@class='ico-logout']");
		System.out.println("Register_03 - Step 05: click to Logout button");
		registerPage.clickToLogoutbutton();
		homePage = new UserHomePageObject(driver);

	}

	@Test
	public void Register_04_Existing_Email() {

		// waitForAllElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Register_04 - Step 01: click to register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		// sedkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// sedkeyToElement(driver, "//input[@id='LastName']", "FC");
		//
		// sedkeyToElement(driver, "//input[@id='Email']", emailAdress);
		//
		// sedkeyToElement(driver, "//input[@id='Password']", "123123");
		//
		// sedkeyToElement(driver, "//input[@id='ConfirmPassword']", "123123");
		System.out.println("Register_04 - Step 02: input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordtTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		// waitForAllElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register_04 - Step 03: click to Register button");
		registerPage.clickToRegisterbutton();

		// Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
		System.out.println("Register_04 -Step 04: Verify error message displayed");

		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		// waitForAllElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Register_05 - Step 01: click to register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		// sedkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// sedkeyToElement(driver, "//input[@id='LastName']", "FC");
		//
		// sedkeyToElement(driver, "//input[@id='Email']", emailAdress);
		//
		// sedkeyToElement(driver, "//input[@id='Password']", "1231");
		//
		// sedkeyToElement(driver, "//input[@id='ConfirmPassword']", "1231");
		System.out.println("Register_05 - Step 02: input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordtTextbox("1231");
		registerPage.inputToConfirmPasswordTextbox("1231");

		// waitForAllElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register_05 - Step 03: click to Register button");
		registerPage.clickToRegisterbutton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
		System.out.println("Register_05 -Step 04: Verify error message displayed");

		Assert.assertEquals(registerPage.getErrorMessageAtPaswordNameTextBox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		// waitForAllElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");

		System.out.println("Register_06 - Step 01: click to register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		// sedkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// sedkeyToElement(driver, "//input[@id='LastName']", "FC");
		//
		// sedkeyToElement(driver, "//input[@id='Email']", emailAdress);
		//
		// sedkeyToElement(driver, "//input[@id='Password']", "1231123123");
		//
		// sedkeyToElement(driver, "//input[@id='ConfirmPassword']", "1231123456");
		System.out.println("Register_06 - Step 02: input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordtTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("12311231234");

		// waitForAllElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register_06 - Step 03: click to Register button");
		registerPage.clickToRegisterbutton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
		System.out.println("Register_06 -Step 04: Verify error message displayed");

		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPawordNameTextBox(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
