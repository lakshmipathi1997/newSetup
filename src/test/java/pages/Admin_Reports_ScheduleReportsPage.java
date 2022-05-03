package pages;

import org.openqa.selenium.WebDriver;

import locators.Admin_Manage_Endpoint_Locators;
import locators.Admin_Reports_ScheduleReportsLocators;
import locators.FilterDialogLocators;
import utility.ConstantsUtil;
import utility.DriverPage;

public class Admin_Reports_ScheduleReportsPage extends DriverPage {

	public Admin_Reports_ScheduleReportsPage(WebDriver webdriver) {
		super(webdriver);
	}

	public void selectAppLogMenu() {
		selectTopMenu("Administration");
		selectSideMenu("Reports", "Scheduled Reports");
		putWait(ConstantsUtil.minWait);

	}

	public void clickOnRefreshButton() {
		clickOn(Admin_Reports_ScheduleReportsLocators.refreshButton);
		putWait(ConstantsUtil.minWait);
		log.log("Page has been refreshed and display new one if any ");
	}

	public void clickOnExportButton() {
		clickOn(Admin_Reports_ScheduleReportsLocators.exportButton);
		putWait(ConstantsUtil.minWait);
		log.log("User clicked on export button");

	}

	public void clickOnCloseButtonOnExportPopUp() {
		clickOn(Admin_Reports_ScheduleReportsLocators.closeExportPopup);
		putWait(ConstantsUtil.minWait);

	}

	public void clikOnEditButton(String sName) {
		putWait(ConstantsUtil.minWait);
		String editButton = Admin_Manage_Endpoint_Locators.editEndpoint.replaceAll("@override", sName);
		clickOn(editButton);

	}

	public void selectOptionFromDropdown(String fieldName, String Condition) {
		putWait(ConstantsUtil.minWait);
		String fname = FilterDialogLocators.conditionDropdown.replaceAll("@override", fieldName);
		clickOn(fname);
		putWait(ConstantsUtil.minWait);
		String option = FilterDialogLocators.dropDownOption.replaceAll("@override", Condition);
		for (int i = 0; i <= option.length() - 1; i++) {
			clickOn(option);

		}

	}

}
