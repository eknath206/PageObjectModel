package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CasesPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CasesPage casesPage;
	
	String sheetName = "Cases";
	
	public CasesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		casesPage = new CasesPage();
		casesPage = homePage.clickOnCasesLink();
	}
	
	@Test(priority=1)
	public void verifyCasesPageLabel() {
		Assert.assertTrue(casesPage.verifyCasesLabel(), "Cases label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewCase(String cTitle, String cStatus, String cIdentifier, String cType, String cPriority, 
			String cContactLookup) throws InterruptedException {
		
		homePage.clickOnNewCaseLink();
		casesPage.createNewCase(cTitle, cStatus, cIdentifier, cType, cPriority, cContactLookup);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
