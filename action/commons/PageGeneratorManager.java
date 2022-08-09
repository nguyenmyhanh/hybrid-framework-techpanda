package commons;

import org.openqa.selenium.WebDriver;

import pageObject.techpanda.admin.AdminDashboardPageObject;
import pageObject.techpanda.admin.AdminLoginPageObject;
import pageObject.techpanda.user.UserAddressPageObject;
import pageObject.techpanda.user.UserCustomerInforPageObject;
import pageObject.techpanda.user.UserHomePageObject;
import pageObject.techpanda.user.UserLoginPageObject;
import pageObject.techpanda.user.UserMyProductReviewObject;
import pageObject.techpanda.user.UserRegisterPageObject;
import pageObject.techpanda.user.UserRewardPointPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserMyProductReviewObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewObject(driver);
	}

	public static UserRewardPointPageObject getUserRewarPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static AdminLoginPageObject adminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject adminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

}
