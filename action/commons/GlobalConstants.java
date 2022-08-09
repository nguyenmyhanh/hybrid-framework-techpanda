package commons;

public class GlobalConstants {
	public static final String TECHPANDA_PAGE_URL = "http://live.techpanda.org/index.php/customer/account/login/";
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "http://live.techpanda.org/index.php/backendlogin/customer/";
	public static final String NOP_ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");

	// public static final String UPLOAD_FILE_FOLDER_1 = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + "\\uploadFiles\\";

	public static final String DB_DEV_URL = "32.18.252.185.9860";
	public static final String DB_DEV_USER = "automation";
	public static final String DB_DEV_PASS = "1231231223";

	public static final String DB_TEST_URL = "32.18.252.185.9860";
	public static final String DB_TEST_USER = "automation";
	public static final String DB_TEST_PASS = "1231231223";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;

	public static final String REPORTING_SCREENSHOT_PATH = PROJECT_PATH + "/screenshotReportNG/";
}
