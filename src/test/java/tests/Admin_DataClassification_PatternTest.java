package tests;

import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Admin_DataClassification_PatternPage;
import pages.LoginPage;
import utility.DriverTestCase;
import utility.ExecutionLog;
import utility.PropertyReader;
import utility.QAAnnotations.TestCaseInfo;

public class Admin_DataClassification_PatternTest extends DriverTestCase {
	private static LoginPage loginPage;
	private static Admin_DataClassification_PatternPage admin_DataClassification_PatternPage;

	PropertyReader propertyReader = new PropertyReader();
	String userName = propertyReader.readProperty("username");
	String password = propertyReader.readProperty("password");

	Random random = new Random();
	int randNo = random.nextInt(100000);

	@BeforeMethod(alwaysRun = true)
	public void initForPattern() throws Exception {
		setup();
		loginPage = new LoginPage(getWebDriver());
		admin_DataClassification_PatternPage = new Admin_DataClassification_PatternPage(getWebDriver());

		loginPage.loginIntoApplication(userName, password);
	}

	@TestCaseInfo(testCaseID = "269", title = "Verify application allows to delete created pattern.")
	@Test(priority = 1, groups = { "SmokeTest" })
	public void testApplicationAllowsToDeleteCreatedPattern() throws Exception {
		String patternName = "QATestingP" + randNo;
		String labelName = "QALabel" + randNo;
		String regularExpression = "QARegExp" + randNo;
		try {
			String[] patternDetail = { "Name", "Regular Expression", "Custom", "", labelName, "EditDelete" };

			admin_DataClassification_PatternPage.navigateToDataClassificationPatternPage();
			admin_DataClassification_PatternPage.clickOnCreateButton();
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Type", "Name");
			admin_DataClassification_PatternPage.enterPatternName(patternName);
			admin_DataClassification_PatternPage.addPatternLabel(labelName);
			admin_DataClassification_PatternPage.enterTextInRegularExpressionTextArea(regularExpression);
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnSaveButton();

			admin_DataClassification_PatternPage.verifyPatternDetails(patternName, patternDetail);

		} catch (Error e) {
			getScreenshot("testApplicationAllowsToDeleteCreatedPattern");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testApplicationAllowsToDeleteCreatedPattern");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		} finally {
			try {
				admin_DataClassification_PatternPage.deleteExistingPattern(patternName);

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}

	@TestCaseInfo(testCaseID = "256", title = "Verify application allows to create a new label under patterns")
	@Test(priority = 1, groups = { "SmokeTest" })
	public void testApplicationAllowsToCreateNewLabel() throws Exception {
		String patternName = "QATestingP" + randNo;
		String labelName = "QALabel" + randNo;
		String regularExpression = "QARegExp" + randNo;
		try {

			admin_DataClassification_PatternPage.navigateToDataClassificationPatternPage();
			admin_DataClassification_PatternPage.clickOnCreateButton();
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Type", "Name");
			admin_DataClassification_PatternPage.enterPatternName(patternName);
			admin_DataClassification_PatternPage.addPatternLabel(labelName);
			admin_DataClassification_PatternPage.enterTextInRegularExpressionTextArea(regularExpression);
			admin_DataClassification_PatternPage.clickOnXIconOfNewlyAddedLabel();
			admin_DataClassification_PatternPage.clickInLabelField();
			admin_DataClassification_PatternPage.verifyLabelNameInLabelDropdown(labelName);

		} catch (Error e) {
			getScreenshot("testApplicationAllowsToCreateNewLabel");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testApplicationAllowsToCreateNewLabel");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}
	}

	@TestCaseInfo(testCaseID = "262", title = "Verify application allows to create the pattern with 'Include Keywords' and 'Exclude Keywords'")
	@Test(priority = 1, groups = { "SmokeTest" })
	public void testApplicationAllowsToCreatePatternWithIncludeAndExcludeKeywords() throws Exception {
		String patternName = "QATestingP" + randNo;
		String regularExpression = "QARegExp" + randNo;
		String includeKeyword = "Application";
		String excludeKeyword = "Mobile";
		try {
			
			String[] patternDetail = { "Content", "Regular Expression", "Custom", "", "", "EditDelete" };

			admin_DataClassification_PatternPage.navigateToDataClassificationPatternPage();
			admin_DataClassification_PatternPage.clickOnCreateButton();
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Type", "Content");
			admin_DataClassification_PatternPage.enterPatternName(patternName);
			admin_DataClassification_PatternPage.enterTextInRegularExpressionTextArea(regularExpression);
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.addIncludeOrExcludeKeywordInPattern("Include Keywords", includeKeyword);
			admin_DataClassification_PatternPage.addIncludeOrExcludeKeywordInPattern("Exclude Keywords", excludeKeyword);
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnSaveButton();
			
			admin_DataClassification_PatternPage.verifyPatternDetails(patternName, patternDetail);

			
		} catch (Error e) {
			getScreenshot("testApplicationAllowsToCreatePatternWithIncludeAndExcludeKeywords");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testApplicationAllowsToCreatePatternWithIncludeAndExcludeKeywords");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}finally {
			try {
				admin_DataClassification_PatternPage.deleteExistingPattern(patternName);

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}

	@TestCaseInfo(testCaseID = "261", title = "Verify application allows to delete the added keywords from 'Include Keywords' and 'Exclude Keywords'")
	@Test(priority = 1, groups = { "SmokeTest" })
	public void testApplicationAllowsToDeleteAddedIncludeAndExcludeKeywords() throws Exception {
		String patternName = "QATestingP" + randNo;
		String regularExpression = "QARegExp" + randNo;
		String includeKeyword = "Application";
		String excludeKeyword = "Mobile";
		try {

			admin_DataClassification_PatternPage.navigateToDataClassificationPatternPage();
			admin_DataClassification_PatternPage.clickOnCreateButton();
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Type", "Content");
			admin_DataClassification_PatternPage.enterPatternName(patternName);
			admin_DataClassification_PatternPage.enterTextInRegularExpressionTextArea(regularExpression);
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.addIncludeOrExcludeKeywordInPattern("Include Keywords", includeKeyword);
			admin_DataClassification_PatternPage.addIncludeOrExcludeKeywordInPattern("Exclude Keywords", excludeKeyword);
			
			admin_DataClassification_PatternPage.clickOnDeleteIconForKeyword("Include Keywords");
			admin_DataClassification_PatternPage.clickOnDeleteIconForKeyword("Exclude Keywords");
			
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnSaveButton();
						
		} catch (Error e) {
			getScreenshot("testApplicationAllowsToCreatePatternWithIncludeAndExcludeKeywords");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testApplicationAllowsToCreatePatternWithIncludeAndExcludeKeywords");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}finally {
			try {
				admin_DataClassification_PatternPage.deleteExistingPattern(patternName);

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}
	
	@TestCaseInfo(testCaseID = "265", title = "Verify application allows to create pattern by 'String List' type")
	@Test(priority = 1, groups = { "SmokeTest" })
	public void testApplicationAllowsToCreatePatternByStringListMatchingType() throws Exception {
		String patternName = "QATestingP" + randNo;
		String includeWords = "QAWord" + randNo;

		try {
			
			String[] patternDetail = { "Name", "List of Strings", "Custom", "", "", "EditDelete" };

			admin_DataClassification_PatternPage.navigateToDataClassificationPatternPage();
			admin_DataClassification_PatternPage.clickOnCreateButton();
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Type", "Name");
			admin_DataClassification_PatternPage.enterPatternName(patternName);
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Match Type", "String List");
            admin_DataClassification_PatternPage.addIncludeWordsInPattern(includeWords);
			
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnSaveButton();
			
			admin_DataClassification_PatternPage.verifyPatternDetails(patternName, patternDetail);

			
		} catch (Error e) {
			getScreenshot("testApplicationAllowsToCreatePatternByStringListMatchingType");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testApplicationAllowsToCreatePatternByStringListMatchingType");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}finally {
			try {
				admin_DataClassification_PatternPage.deleteExistingPattern(patternName);

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}
	
	@TestCaseInfo(testCaseID = "270", title = "Verify application allows to edit any pattern")
	@Test(priority = 1, groups = { "Regression" })
	public void testApplicationAllowsToEditExistingPattern() throws Exception {
		String patternName = "QATestingP" + randNo;
		String includeWords = "QAWord" + randNo;
		String newPatternName = "QATestingNewP" + randNo;
		String labelName = "QALabel" + randNo;

		try {
			
			String[] patternDetail = { "Name", "List of Strings", "Custom", "", "", "EditDelete" };

			//Create a pattern
			admin_DataClassification_PatternPage.navigateToDataClassificationPatternPage();
			admin_DataClassification_PatternPage.clickOnCreateButton();
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Type", "Name");
			admin_DataClassification_PatternPage.enterPatternName(patternName);
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Match Type", "String List");
            admin_DataClassification_PatternPage.addIncludeWordsInPattern(includeWords);	
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnSaveButton();	
			admin_DataClassification_PatternPage.verifyPatternDetails(patternName, patternDetail);
			
			// Edit above created pattern
			
			String[] newPatternDetail = { "Name", "List of Strings", "Custom", "", labelName, "EditDelete" };
			
			admin_DataClassification_PatternPage.editExistingPattern(patternName);
			admin_DataClassification_PatternPage.enterPatternName(newPatternName);
			admin_DataClassification_PatternPage.addPatternLabel(labelName);
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnSaveButton();	
			admin_DataClassification_PatternPage.verifyPatternDetails(newPatternName, newPatternDetail);

			
		} catch (Error e) {
			getScreenshot("testApplicationAllowsToEditExistingPattern");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testApplicationAllowsToEditExistingPattern");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}finally {
			try {
				admin_DataClassification_PatternPage.deleteExistingPattern(newPatternName);

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}
	
	@TestCaseInfo(testCaseID = "260", title = "Verify application allows to add keyword in 'Include Keywords' and 'Exclude Keywords'")
	@Test(priority = 1, groups = { "Regression" })
	public void testApplicationAllowsToAddIncludeAndExcludeKeywordsInPattern() throws Exception {
		String patternName = "QATestingP" + randNo;
		String regularExpression = "QARegExp" + randNo;
		String includeKeyword = "Application";
		String excludeKeyword = "Mobile";
		try {
			
			String[] patternDetail = { "Content", "Regular Expression", "Custom", "", "", "EditDelete" };

			admin_DataClassification_PatternPage.navigateToDataClassificationPatternPage();
			admin_DataClassification_PatternPage.clickOnCreateButton();
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Type", "Content");
			admin_DataClassification_PatternPage.enterPatternName(patternName);
			admin_DataClassification_PatternPage.enterTextInRegularExpressionTextArea(regularExpression);
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.addIncludeOrExcludeKeywordInPattern("Include Keywords", includeKeyword);
			admin_DataClassification_PatternPage.addIncludeOrExcludeKeywordInPattern("Exclude Keywords", excludeKeyword);
			
			admin_DataClassification_PatternPage.clickOnDeleteIconForKeyword("Include Keywords");
			admin_DataClassification_PatternPage.clickOnDeleteIconForKeyword("Exclude Keywords");
			
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnSaveButton();
			
			admin_DataClassification_PatternPage.verifyPatternDetails(patternName, patternDetail);

			
		} catch (Error e) {
			getScreenshot("testApplicationAllowsToAddIncludeAndExcludeKeywordsInPattern");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testApplicationAllowsToAddIncludeAndExcludeKeywordsInPattern");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}finally {
			try {
				admin_DataClassification_PatternPage.deleteExistingPattern(patternName);

			} catch (Error e) {
				ExecutionLog.logErrorMessage(e);
				throw e;
			} catch (Exception e) {
				ExecutionLog.logExceptionMessage(e);
				throw e;
			}
		}
	}

	@TestCaseInfo(testCaseID = "257", title = "Verify user can test the pattern before creates it when pattern defined as String")
	@Test(priority = 1, groups = { "Regression" })
	public void testUserCanTestPatternBeforeCreateWhenPatternDefinedAsString() throws Exception {
		String patternName = "QATestingP" + randNo;
		String stringValue = "QATest" + randNo;
		String includeKeyword = "Application";
		String excludeKeyword = "Mobile";
		String confirmMessage = "Matches:  1";
		try {
			
			String[] patternDetail = { "Content", "String", "Custom", "", "", "EditDelete" };

			admin_DataClassification_PatternPage.navigateToDataClassificationPatternPage();
			admin_DataClassification_PatternPage.clickOnCreateButton();
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Type", "Content");
			admin_DataClassification_PatternPage.enterPatternName(patternName);
			admin_DataClassification_PatternPage.selectDropdownValueOnCreatePatternPopUp("Match Type", "String");
			admin_DataClassification_PatternPage.enterStringValue(stringValue);
			
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.addIncludeOrExcludeKeywordInPattern("Include Keywords", includeKeyword);
			admin_DataClassification_PatternPage.addIncludeOrExcludeKeywordInPattern("Exclude Keywords", excludeKeyword);
		
			admin_DataClassification_PatternPage.clickOnNextButton();
			admin_DataClassification_PatternPage.clickOnNextButton();
			
			admin_DataClassification_PatternPage.enterTextInTestField(stringValue);
			admin_DataClassification_PatternPage.clickOnTestButton();
			admin_DataClassification_PatternPage.assertTestConfirmationMessage(confirmMessage);
			admin_DataClassification_PatternPage.clickOnSaveButton();
			
			admin_DataClassification_PatternPage.verifyPatternDetails(patternName, patternDetail);

			
		} catch (Error e) {
			getScreenshot("testUserCanTestPatternBeforeCreateWhenPatternDefinedAsString");
			ExecutionLog.logErrorMessage(e);
			throw e;
		} catch (Exception e) {
			getScreenshot("testUserCanTestPatternBeforeCreateWhenPatternDefinedAsString");
			ExecutionLog.logExceptionMessage(e);
			throw e;
		}finally {
			try {
				admin_DataClassification_PatternPage.deleteExistingPattern(patternName);

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
