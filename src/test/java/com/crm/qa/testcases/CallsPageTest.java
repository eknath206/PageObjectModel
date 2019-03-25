package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CallsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CallsPage callsPage;
	
	String sheetName = "Calls";
	
	public CallsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		callsPage = new CallsPage();
		callsPage = homePage.clickOnCallsLink();
	}
	
	@Test(priority=1)
	public void verifyCallsPageLabel() {
		Assert.assertTrue(callsPage.verifyCallLabel(),"Calls label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider = "getCRMTestData")
	public void validateCreateNewCall(String cContactLookup, String cDeal, String cTask, String cCase, String cNotes) {
		
		homePage.clickOnNewCallLink();
		callsPage.createNewCall(cContactLookup, cDeal, cTask, cCase, cNotes);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
