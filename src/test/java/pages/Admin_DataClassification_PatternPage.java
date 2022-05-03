package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import locators.Admin_AlertsLocators;
import locators.Admin_DataClassification_PatternsLocators;
import utility.ConstantsUtil;
import utility.DriverPage;

public class Admin_DataClassification_PatternPage extends DriverPage {

	public Admin_DataClassification_PatternPage(WebDriver webdriver) {
		super(webdriver);
	}

	public void navigateToDataClassificationPatternPage() {
		putWait(ConstantsUtil.minWait);
		selectTopMenu("Administration");
		selectSideMenu("Data Classification", "Patterns");
		putWait(ConstantsUtil.mediumWait);
	}

	public void verifyHeaderName() {
		putWait(ConstantsUtil.minWait);
		clickOn(Admin_DataClassification_PatternsLocators.pageHeaderName);
		log.log("Header name is displaying on top left corner of page ");

	}

	public void setPatternPageAsInitPage() {
		putWait(ConstantsUtil.minWait);
		clickOn(Admin_DataClassification_PatternsLocators.setInitPageBtn);
		putWait(ConstantsUtil.minWait);
		log.log("User is Set the Manage Setting Page as Init Page");
	}

	public void clickOnCreateButton() {
		clickOn(Admin_DataClassification_PatternsLocators.createBtn);
		putWait(ConstantsUtil.minWait);
		log.log("Clicked on create button");
	}

	public void selectDropdownValueOnCreatePatternPopUp(String fieldLabel, String typeName) {
		String dropdownName = Admin_DataClassification_PatternsLocators.dropDownField.replaceAll("@override",
				fieldLabel);
		clickOn(dropdownName);
		String dropdownValue = Admin_DataClassification_PatternsLocators.dropDownOption.replaceAll("@override",
				typeName);
		clickOn(dropdownValue);
		putWait(ConstantsUtil.minWait);
		log.log("User selected Type as: " + typeName);
	}

	public void enterPatternName(String patternName) {
		sendKeys(Admin_DataClassification_PatternsLocators.nameField, patternName);
		putWait(ConstantsUtil.minWait);
		log.log("eneter Pattern Name as: " + patternName);
	}

	public void addPatternLabel(String labelName) {
		clickOn(Admin_DataClassification_PatternsLocators.addLabelIcon);
		sendKeys(Admin_DataClassification_PatternsLocators.labelName, labelName);
		clickOn(Admin_DataClassification_PatternsLocators.addBtn);
		putWait(ConstantsUtil.minWait);
	}

	public void enterTextInRegularExpressionTextArea(String regularExpression) {
		sendKeys(Admin_DataClassification_PatternsLocators.regularExpressionTextArea, regularExpression);
		putWait(ConstantsUtil.minWait);
		log.log("Clicked on create button");
	}

	public void clickOnNextButton() {
		clickOn(Admin_DataClassification_PatternsLocators.nextBtn);
		putWait(ConstantsUtil.minWait);
		log.log("Clicked on Next button");
	}

	public void clickOnCancelButton() {
		clickOn(Admin_DataClassification_PatternsLocators.cancelBtn);
		putWait(ConstantsUtil.minWait);
		log.log("Clicked on Cancel button");
	}

	public void clickOnSaveButton() {
		clickOn(Admin_DataClassification_PatternsLocators.saveButton);
		putWait(ConstantsUtil.minWait);
		log.log("Clicked on Save button");
	}

	public void deleteExistingPattern(String alertName) {
		String alertloc = Admin_DataClassification_PatternsLocators.deletePattern.replaceAll("@override", alertName);
		clickOn(alertloc);
		waitForElementPresent(Admin_DataClassification_PatternsLocators.deleteOKButton, 10);
		log.log("Clicked on delete button to delete alert");
		putWait(ConstantsUtil.minWait);
		clickOn(Admin_DataClassification_PatternsLocators.deleteOKButton);
		putWait(ConstantsUtil.mediumWait);
	}

	public void assertValuesInColumns(String columnName, String expectedColumnValue) {
		putWait(ConstantsUtil.oneMinWait);
		String actualValue = null;
		List<WebElement> ele = null;
		String[] colNames = { "Name", "Type", "Match Type", "Pattern", "Labels" };

		for (int i = 0; i <= colNames.length - 1; i++) {

			String colmName = colNames[i];

			if (columnName.equals(colmName)) {
				int colNo = i + 1;
				ele = driver
						.findElements(By.xpath("//div[@class='k-grid-container']//td[@aria-colindex='" + colNo + "']"));

				for (int j = 0; j <= ele.size() - 1; j++) {
					actualValue = ele.get(i).getText();
					Assert.assertTrue(actualValue.contains(expectedColumnValue));
					log.log("Verified that '" + actualValue + "' contains : '" + expectedColumnValue
							+ "' under the column : '" + columnName);
				}

			}
		}
	}

	public void verifyPatternDetails(String objectName, String[] logDetails) {

		String no = driver.findElement(By.xpath("//td[text()='" + objectName + "']/..")).getAttribute("aria-rowindex");

		List<WebElement> ele = driver.findElements(By.xpath("//tr[@aria-rowindex='" + no + "']/td"));

		for (int i = 1; i <= ele.size() - 1; i++) {
			String actualValues = ele.get(i).getText();

			String expectedValue = null;
			for (int j = 0; j <= i; j++) {

				if (j == i - 1) {
					expectedValue = logDetails[j];
				}
			}

			Assert.assertEquals(actualValues, expectedValue);
		}
	}

	public void clickOnXIconOfNewlyAddedLabel() {
		putWait(ConstantsUtil.minWait);
		clickOn(Admin_DataClassification_PatternsLocators.xIconWithNewLabelValue);
		putWait(ConstantsUtil.minWait);
		log.log("Clicked on 'X' icon present Label");
	}

	public void clickInLabelField() {
		putWait(ConstantsUtil.minWait);
		clickOn(Admin_DataClassification_PatternsLocators.labelField);
		putWait(ConstantsUtil.minWait);
		log.log("Clicked on create button");
	}

	public void verifyLabelNameInLabelDropdown(String expectedLabel) {
		putWait(ConstantsUtil.mediumWait);
		List<WebElement> ele = driver.findElements(By.xpath("//ul[@class='k-list-ul']/li"));

		for (int i = 1; i <= ele.size() - 1; i++) {
			String actualValues = ele.get(i).getText();

			if (actualValues.equals(expectedLabel)) {
				Assert.assertEquals(actualValues, expectedLabel);
				log.log("Label is displaying in dropdown");
			} else {
				Assert.assertNotEquals(actualValues, expectedLabel);
				log.log("Label is not displaying in dropdown");
			}
		}
	}

	public void addIncludeOrExcludeKeywordInPattern(String fieldLabelName, String keywordName) {
		clickOnPlusIcon(fieldLabelName);
		sendKeys(Admin_DataClassification_PatternsLocators.texFieldOnPopUp, keywordName);
		clickOn(Admin_DataClassification_PatternsLocators.addBtnOnPopUp);
		putWait(ConstantsUtil.minWait);
	}

	public void clickOnPlusIcon(String fieldLabelName) {
		String plusIcon = Admin_DataClassification_PatternsLocators.addIncludeKeywordIcon.replaceAll("@override",
				fieldLabelName);
		clickOn(plusIcon);
		putWait(ConstantsUtil.minWait);
	}

	public void clickOnDeleteIconForKeyword(String keywordName) {
		String deleteIcon = Admin_DataClassification_PatternsLocators.deleteKeywordBtn.replaceAll("@override",
				keywordName);
		clickOn(deleteIcon);
		log.log("User deleted kerword from field: " + keywordName);
		putWait(ConstantsUtil.minWait);
	}

	public void addIncludeWordsInPattern(String keywordName) {
		clickOn(Admin_DataClassification_PatternsLocators.plusIconForIncludeWords);
		sendKeys(Admin_DataClassification_PatternsLocators.texFieldOnPopUp, keywordName);
		clickOn(Admin_DataClassification_PatternsLocators.addBtnOnPopUp);
		log.log("User added 'Include Words' in Pattern");
		putWait(ConstantsUtil.minWait);
	}

	public void editExistingPattern(String existingPatternName) {
		String existingAlert = Admin_DataClassification_PatternsLocators.editPattern.replaceAll("@override",
				existingPatternName);
		clickOn(existingAlert);
		log.log("Clicked on edit button on Pattern");
		putWait(ConstantsUtil.minWait);
	}

	public void enterStringValue(String stringValue) {
		sendKeys(Admin_DataClassification_PatternsLocators.stringTextField, stringValue);
		putWait(ConstantsUtil.minWait);
		log.log("User enter the Sring Value as: " + stringValue);
	}

	public void enterTextInTestField(String testText) {
		clickOn(Admin_DataClassification_PatternsLocators.testTextField);
		putWait(ConstantsUtil.minWait);
		sendKeys(Admin_DataClassification_PatternsLocators.testTextField, testText);
		putWait(ConstantsUtil.minWait);
		log.log("User enter the text in Test field as: " + testText);
	}

	public void clickOnTestButton() {
		clickOn(Admin_DataClassification_PatternsLocators.testBtn);
		putWait(ConstantsUtil.minWait);
		log.log("User clicked on TEST button");
	}
	
	public void assertTestConfirmationMessage(String confirmMessage) {
		String actualConfirmMsg= getText(Admin_DataClassification_PatternsLocators.testConfirmationMsg);
		Assert.assertEquals(actualConfirmMsg, confirmMessage);
		log.log("User verified that " + actualConfirmMsg + "is equals to " + confirmMessage);
		putWait(ConstantsUtil.mediumWait);
	}
}
