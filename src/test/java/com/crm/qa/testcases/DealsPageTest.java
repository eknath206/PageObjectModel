package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	
	String sheetName = "Deals";
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		dealsPage = new DealsPage();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=1)
	public void verifyDealsPageLabel() {
		Assert.assertTrue(dealsPage.verifyDealsLabel(), "Deals label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewDeal(String title, String clientLookup, String amount, String probability, String commission, 
			String identifier, String quantity, String type, String source) {
		homePage.clickOnNewDealLink();
		dealsPage.createNewDeal(title, clientLookup, amount, probability, commission, identifier, quantity, type, source);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
