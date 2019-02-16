package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.CampaignsPage;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	CompaniesPage companiesPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	CasesPage casesPage;
	CallsPage callsPage;
	DocumentsPage documentsPage;
	CampaignsPage campaignsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		companiesPage = new CompaniesPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		casesPage = new CasesPage();
		callsPage = new CallsPage();
		documentsPage = new DocumentsPage();
		campaignsPage = new CampaignsPage();
		
		homePage = loginPage.login(prop.getProperty("useremail"), prop.getProperty("password"));
	}
	
	
//	@Test(priority=1)
//	public void verifyHomePageTitleTest() {
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title is not matching.");
//	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		//testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void verifyCompaniesLinkTest() {
		companiesPage = homePage.clickOnCompaniesLink();
	}
	
	@Test(priority=5)
	public void verifyDealsLinkTest() {
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=6)
	public void verifyTasksLinkTest() {
		tasksPage = homePage.clickOnTasksLink();
	}
	
	@Test(priority=7)
	public void verifyCasesLinkTest() {
		casesPage = homePage.clickOnCasesLink();
	}
	
	@Test(priority=8)
	public void verifyCallsLinkTest() {
		callsPage = homePage.clickOnCallsLink();
	}
	
	@Test(priority=9)
	public void verifyDocumentsLinkTest() {
		documentsPage = homePage.clickOnDocumentsLink();
	}
	
	@Test(priority=10)
	public void verifyCampaignsLinkTest() {
		campaignsPage = homePage.clickOnCampaignsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
