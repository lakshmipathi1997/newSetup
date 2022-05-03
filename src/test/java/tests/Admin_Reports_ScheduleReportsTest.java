package tests;

import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Admin_Reports_ScheduleReportsPage;
import pages.FilterDialogPage;
import pages.LoginPage;
import utility.DriverTestCase;
import utility.ExcelUtils;
import utility.ExecutionLog;
import utility.PropertyReader;
import utility.QAAnnotations.TestCaseInfo;

public class Admin_Reports_ScheduleReportsTest extends DriverTestCase {

	private static Admin_Reports_ScheduleReportsPage admin_reports_scheduleReportsPage;
	private static LoginPage loginPage;
	private static ExcelUtils sheet;
	private static FilterDialogPage filterDialogPage;

	PropertyReader propertyReader = new PropertyReader();
	String userName = propertyReader.readProperty("username");
	String password = propertyReader.readProperty("password");

	Random random = new Random();
	int randNo = random.nextInt(100000);

	@BeforeMethod(alwaysRun = true)
	public void initForAppLog() throws Exception {
		setup();
		loginPage = new LoginPage(getWebDriver());
		admin_reports_scheduleReportsPage = new Admin_Reports_ScheduleReportsPage(getWebDriver());
		sheet = new ExcelUtils();
		filterDialogPage = new FilterDialogPage(getWebDriver());
		loginPage.loginIntoApplication(userName, password);

	}

	@TestCaseInfo(testCaseID = "645", title = "Verify that user is able to refresh when clicking on refresh button'")
	@Test(priority = 2, groups = { "SmokeTest" })
	public void testScheduleReportsPageIsRefreshed() throws Exception {

		try {

			admin_reports_scheduleReportsPage.selectAppLogMenu();
			admin_reports_scheduleReportsPage.clickOnRefreshButton();

		} catch (Error e) {
			captureScreenshot("testScheduleReportsPageIsRefreshed");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testScheduleReportsPageIsRefreshed");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		} finally {
			try {
				admin_reports_scheduleReportsPage.clickOnRefreshButton();

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}

	@TestCaseInfo(testCaseID = "646", title = "Verify that a dropdown list with three options 'Contains', 'Equals' and 'Strat With' is open when clicking on condition dropdown fields on filter dialog'")
	@Test(priority = 2, groups = { "SmokeTest" })
	public void testfilterDropdownHaveContainsEqualsAndStartWithOptions() throws Exception {

		String fieldName = "Name";
		String fieldValue = "schema";
		String condition = "Contains";

		try {

			admin_reports_scheduleReportsPage.selectAppLogMenu();
			filterDialogPage.clickOnFilterButton();
			filterDialogPage.selectOptionFromDropdown(fieldName, condition);
			filterDialogPage.enterValueInInputField(fieldName, fieldValue);
			filterDialogPage.clickOnOkButton();

		} catch (Error e) {
			captureScreenshot("testfilterDropdownHaveContainsEqualsAndStartWithOptions");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testfilterDropdownHaveContainsEqualsAndStartWithOptions");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		} finally {
			try {
				filterDialogPage.clickOnFilterButton();
				filterDialogPage.clickOnClearButton();
				filterDialogPage.clickOnOkButton();

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}

	@TestCaseInfo(testCaseID = "653", title = "Verify that applied filter is not cleared when click on cancel button on filter dialog")
	@Test(priority = 2, groups = { "SmokeTest" })
	public void testThatFilterWillNotClearedWenClickOnCancelButton() throws Exception {
		String fieldName = "Name";
		String fieldValue = "schema";
		String condition = "Equals";

		try {

			admin_reports_scheduleReportsPage.selectAppLogMenu();
			filterDialogPage.clickOnFilterButton();
			filterDialogPage.selectOptionFromDropdown(fieldName, condition);
			filterDialogPage.enterValueInInputField(fieldName, fieldValue);
			filterDialogPage.clickOnOkButton();
			filterDialogPage.clickOnFilterButton();
			filterDialogPage.clickOnCancelButton();

		} catch (Error e) {
			captureScreenshot("testThatFilterWillNotClearedWenClickOnCancelButton");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testThatFilterWillNotClearedWenClickOnCancelButton");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		} finally {
			try {
				admin_reports_scheduleReportsPage.clickOnRefreshButton();

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}

	@TestCaseInfo(testCaseID = "654", title = "Verify that filter is not applied when click on cancel button on filter popup")
	@Test(priority = 2, groups = { "SmokeTest" })
	public void testThatFilterIsNotAppliedWhenClickOnCancelButtonOnPopup() throws Exception {

		String fieldName = "Name";
		String fieldValue = "schema";
		String condition = "Equals";

		try {

			admin_reports_scheduleReportsPage.selectAppLogMenu();
			filterDialogPage.clickOnFilterButton();
			filterDialogPage.selectOptionFromDropdown(fieldName, condition);
			filterDialogPage.enterValueInInputField(fieldName, fieldValue);
			filterDialogPage.clickOnCancelButton();

		} catch (Error e) {
			captureScreenshot("testThatFilterIsNotAppliedWhenClickOnCancelButtonOnPopup");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testThatFilterIsNotAppliedWhenClickOnCancelButtonOnPopup");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		} finally {
			try {
				admin_reports_scheduleReportsPage.clickOnRefreshButton();

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws Exception {
		destroyBrowser();
	}

}
