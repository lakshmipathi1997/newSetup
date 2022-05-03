package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import locators.Admin_Manage_Endpoint_Locators;
import locators.Admin_Manage_SettingLocators;
import utility.ConstantsUtil;
import utility.DriverPage;

public class Admin_Manage_SettingsPage extends DriverPage {

	public Admin_Manage_SettingsPage(WebDriver webdriver) {
		super(webdriver);
	}
	
	public void selectAdminManageSettingMenu() {
		putWait(ConstantsUtil.minWait);
		selectTopMenu("Administration");
		selectSideMenu("Manage", "Settings");
		putWait(ConstantsUtil.mediumWait);
	}
	
	public void verifyHeaderName() {
		putWait(ConstantsUtil.minWait);
		clickOn(Admin_Manage_SettingLocators.pageHeaderName);
		log.log("Header name is displaying on top left corner of page ");

	}
	public void setManage_SettingsPageAsInitPage() {
		putWait(ConstantsUtil.minWait);
		clickOn(Admin_Manage_SettingLocators.setInitPageBtn);
		putWait(ConstantsUtil.minWait);
        log.log("User is Set the Manage Setting Page as Init Page");
	}
	public void languageSettingOfApplication(String languageName) {
		clickOn(Admin_Manage_SettingLocators.defaultLanguageDropdownIcon);
		putWait(ConstantsUtil.minWait);
		String language= Admin_Manage_SettingLocators.dropdownValue.replaceAll("@override", languageName);
		clickOn(language);
		putWait(ConstantsUtil.minWait);
		
	}
	
	public void verifySelectedLanguage(String expectedLanguage) {
		putWait(ConstantsUtil.minWait);
		String actualValue = driver.findElement(By.xpath(Admin_Manage_SettingLocators.defaultLanguage)).getText();
		Assert.assertEquals(actualValue, expectedLanguage);
		log.log("Selected language is " + actualValue);
	}
	
	public void clickOnSaveButton() {
		clickOn(Admin_Manage_SettingLocators.clickOnSaveButton);
		putWait(ConstantsUtil.minWait);
	}
	
	public void selectOrUnselectEnableInactivityUserSessionLogoutCheckbox(Boolean status) {		
		if(status == true) {
			clickOn(Admin_Manage_SettingLocators.uncheckedEnableInactivityCheckbox);
		}else {
			clickOn(Admin_Manage_SettingLocators.checkedEnableInactivityCheckbox);
		}		
	}

}
