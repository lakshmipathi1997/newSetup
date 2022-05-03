package tests;

import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Admin_Manage_SettingsPage;
import pages.LoginPage;
import utility.DriverTestCase;
import utility.ExecutionLog;
import utility.PropertyReader;
import utility.QAAnnotations.TestCaseInfo;

public class Admin_Manage_SettingsTest extends DriverTestCase {
	private static LoginPage loginPage;
	private static Admin_Manage_SettingsPage admin_Manage_SettingsPage;

	PropertyReader propertyReader = new PropertyReader();
	String userName = propertyReader.readProperty("username");
	String password = propertyReader.readProperty("password");

	Random random = new Random();
	int randNo = random.nextInt(100000);

	@BeforeMethod(alwaysRun = true)
	public void initForManageSetting() throws Exception {
		setup();
		loginPage = new LoginPage(getWebDriver());
		admin_Manage_SettingsPage = new Admin_Manage_SettingsPage(getWebDriver());

		loginPage.loginIntoApplication(userName, password);

	}

	@TestCaseInfo(testCaseID = "6056", title = "Verify user is able to change the language from Default language dropdown")
	@Test(priority = 1, groups = { "SmokeTest" })
	public void testUserIsAbleToSelectLanguageFromDefaultLanguageDropdown() throws Exception {

		try {
			admin_Manage_SettingsPage.selectAdminManageSettingMenu();
			admin_Manage_SettingsPage.languageSettingOfApplication("Spanish");
			admin_Manage_SettingsPage.verifySelectedLanguage("Spanish");
			admin_Manage_SettingsPage.languageSettingOfApplication("English");
			admin_Manage_SettingsPage.clickOnSaveButton();
			admin_Manage_SettingsPage.verifySelectedLanguage("English");

		} catch (Error e) {
			getScreenshot("testUserIsAbleToSelectLanguageFromDefaultLanguageDropdown");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testUserIsAbleToSelectLanguageFromDefaultLanguageDropdown");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		} 
	}
	
	@TestCaseInfo(testCaseID = "249", title = "Verify 'Enable Inactivity User Session Logout' checkbox under Session section")
	@Test(priority = 1, groups = { "SmokeTest" })
	public void testEnableInactivityUserSessionLogoutcheckbox() throws Exception {
		try {
			admin_Manage_SettingsPage.selectAdminManageSettingMenu();
			admin_Manage_SettingsPage.selectOrUnselectEnableInactivityUserSessionLogoutCheckbox(false);


		} catch (Error e) {
			getScreenshot("testEnableInactivityUserSessionLogoutcheckbox");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testEnableInactivityUserSessionLogoutcheckbox");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		} 
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws Exception {
		destroyBrowser();
	}

}
