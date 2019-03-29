package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FormsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class FormsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	FormsPage formsPage;

	String sheetName = "FeedbackForms";

	public FormsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		formsPage = new FormsPage();
		formsPage = homePage.clickOnFormsLink();

	}

	@Test(priority = 1)
	public void verifyFeedbackFormsLabel() {
		Assert.assertTrue(formsPage.verifyFeedbackFormLabel(), "Root folder label is missing on the page");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void validateCreateNewFeedbackForm(String ffTitle, String ffPages, String ffReportEmail,
			String ffDescription, String ffWelcomeMessage, String ffConfirmationMessage) {
		homePage.clickOnNewFormLink();
		formsPage.addFeedbackForm(ffTitle, ffPages, ffReportEmail, ffDescription, ffWelcomeMessage,
				ffConfirmationMessage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
