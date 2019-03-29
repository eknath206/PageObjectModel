package com.crm.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.WordMergeTemplatePage;
import com.crm.qa.util.TestUtil;

public class WordMergeTemplatePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	WordMergeTemplatePage wordMergeTemplatePage;

	String sheetName = "Templates";

	public WordMergeTemplatePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		wordMergeTemplatePage = new WordMergeTemplatePage();
	}

	@DataProvider
	public Object[][] getCRMTestData() {

		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 1, dataProvider = "getCRMTestData")
	public void validateCreateNewWordMergeTemplate(String tempTitle, String tempDescription, String tempVersion,
			String tempTags) throws InterruptedException, AWTException {

		homePage.clickOnNewDirectoryLink();
		wordMergeTemplatePage.createNewWordMergeTemplate(tempTitle, tempDescription, tempVersion, tempTags);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
