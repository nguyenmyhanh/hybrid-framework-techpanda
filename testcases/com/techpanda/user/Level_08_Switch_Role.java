package com.techpanda.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.techpanda.admin.AdminDashboardPageObject;
import pageObject.techpanda.admin.AdminLoginPageObject;
import pageObject.techpanda.user.UserCustomerInforPageObject;
import pageObject.techpanda.user.UserHomePageObject;
import pageObject.techpanda.user.UserLoginPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPageObject;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardpage;
	private UserCustomerInforPageObject userCustomerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userPassword = "123123123";
		userEmailAddress = "hanh@gmail.com";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

	}

	@Test
	public void Role_01_User_To_Admin() {
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userLoginPageObject = userHomePage.clickToLoginLink();
		userHomePage = userLoginPageObject.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountDisplayed());
		userCustomerInfoPage = userHomePage.clickMyAccountLink();
		userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);

		userHomePage.openPageUlr(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.adminLoginPage(driver);
		adminDashboardpage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		adminDashboardpage.sleepInSecond(2);
		Assert.assertTrue(adminDashboardpage.isDashboardHeaderDisplayed());

		adminLoginPage = adminDashboardpage.clickToLogoutLinkAtAdminPage(driver);

	}

	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPage.openPageUlr(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userLoginPageObject = userHomePage.clickToLoginLink();
		userHomePage = userLoginPageObject.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
