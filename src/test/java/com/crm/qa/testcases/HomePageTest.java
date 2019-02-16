package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.DocsPage;
import com.crm.qa.pages.FormsPage;
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
	DealsPage dealsPage;
	TasksPage tasksPage;
	CasesPage casesPage;
	CallsPage callsPage;
	DocsPage docsPage;
	FormsPage formsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title is not matching.");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
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
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
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
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
