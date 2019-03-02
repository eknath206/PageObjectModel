package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CompaniesPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CompaniesPage companiesPage;
	
	String sheetName = "Companies";
	
	public CompaniesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		companiesPage = new CompaniesPage();
		companiesPage =  homePage.clickOnCompaniesLink();
	}
	
	@Test(priority=1)
	public void verifyCompaniesPageLabel() {
		Assert.assertTrue(companiesPage.verifyCompaniesLabel(), "Companies label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewCompany(String compName, String industry, String revenue, String employees, String status, String category,
			String priority, String source, String type, String address, String city, String state, String zip, String country) {
		homePage.clickOnNewCompanyLink();
		companiesPage.createNewCompany(compName, industry, revenue, employees, status, category, priority, source, type, address, city, state, zip, country);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
