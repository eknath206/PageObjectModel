package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AlertsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class AlertsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	AlertsPage alertsPage;

	String sheetName = "Alerts";

	public AlertsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		alertsPage = new AlertsPage();
		alertsPage = homePage.clickOnAlertsLink();
	}

	@Test(priority = 1)
	public void verifyAlertsPageLabel() {

		Assert.assertTrue(alertsPage.verifyCreateAlertLabel(), "Create New Alert label is missing on the page");
	}

	@DataProvider
	public Object[][] getCRMData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCRMData")
	public void validateCreateNewAlert(String aSendMode, String aObjectType, String aTrigger, String aFormat,
			String aActive) {
		alertsPage.createNewAlert(aSendMode, aObjectType, aTrigger, aFormat, aActive);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
