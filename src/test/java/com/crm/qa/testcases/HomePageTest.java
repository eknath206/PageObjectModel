package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
<<<<<<< HEAD
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CallsPage;
=======
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.CampaignsPage;
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
<<<<<<< HEAD
import com.crm.qa.pages.DocsPage;
import com.crm.qa.pages.FormsPage;
=======
import com.crm.qa.pages.DocumentsPage;
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CalendarPage calendarPage;
	CompaniesPage companiesPage;
	ContactsPage contactsPage;
<<<<<<< HEAD
=======
	CompaniesPage companiesPage;
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	DealsPage dealsPage;
	TasksPage tasksPage;
	CasesPage casesPage;
	CallsPage callsPage;
<<<<<<< HEAD
	DocsPage docsPage;
	FormsPage formsPage;
=======
	DocumentsPage documentsPage;
	CampaignsPage campaignsPage;
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	
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
	public void verifyCalendarLinkTest() {
		testUtil.switchToFrame();
		calendarPage = homePage.clickOnCalendarLink();
	}
	
	@Test(priority=4)
	public void verifyCompaniesLinkTest() {
		testUtil.switchToFrame();
		companiesPage = homePage.clickOnCompaniesLink();
	}
	
	@Test(priority=5)
	public void verifyContactsLinkTest() {
		//testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
<<<<<<< HEAD
	@Test(priority=6)
	public void verifyDealsLinkTest() {
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=7)
	public void verifyTasksLinkTest() {
		testUtil.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
	}
	
	@Test(priority=8)
	public void verifyCasesLinkTest() {
		testUtil.switchToFrame();
		casesPage = homePage.clickOnCasesLink();
	}
	
	@Test(priority=9)
	public void verifyCallsLinkTest() {
		testUtil.switchToFrame();
		callsPage = homePage.clickOnCallsLink();
	}
	
	@Test(priority=10)
	public void verifyDocsLinkTest() {
		testUtil.switchToFrame();
		docsPage = homePage.clickOnDocsLink();
	}
	
	@Test(priority=11)
	public void verifyFormsLinkTest() {
		testUtil.switchToFrame();
		formsPage = homePage.clickOnFormsLink();
=======
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
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
