package locators;

public class Admin_Manage_SettingLocators {
	public static final String pageHeaderName = "//div[@class='topBar']/child::div[text()='Settings']";
	public static final String setInitPageBtn="//button[@title='Set this view as init page']";
	public static final String defaultLanguage="//div/span[text()='Default Language']/following-sibling::span//span[@class='k-input-value-text']";
	public static final String defaultLanguageDropdownIcon="//button[@aria-label='DropDownList_Open']";
	public static final String dropdownValue="//span[@class='k-list-item-text' and text()='@override']";
	public static final String uncheckedEnableInactivityCheckbox="//label[contains(text(), 'Enable Inactivity')]/preceding-sibling::input[@type='checkbox' and @class='valid']";
	public static final String checkedEnableInactivityCheckbox="//label[contains(text(), 'Enable Inactivity')]/preceding-sibling::input[@type='checkbox' and @class='valid']";	
	public static final String clickOnSaveButton="//button[text()='Save']";
	public static final String sessionCheckbox="//input[@type='checkbox']";
	public static final String enterSessionTimeOut="//input[@type='number']";
	public static final String selectBrandImage="//input[@type='file']";
	public static final String clickOnUserName="//div[@class='top-userEmail']";
	public static final String clickOnLogoutbutton="//div/button[text()='Logout']";
	
	}
