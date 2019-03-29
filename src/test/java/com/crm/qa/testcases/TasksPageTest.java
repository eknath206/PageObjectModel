package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TasksPage tasksPage;

	String sheetName = "Tasks";

	public TasksPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		tasksPage = new TasksPage();
		tasksPage = homePage.clickOnTasksLink();
	}

	@Test(priority = 1)
	public void verifyTasksPageLabel() {

		Assert.assertTrue(tasksPage.verifyTasksLabel(), "Tasks label is missing on the page");

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void validateAddNewTask(String ntTitle, String ntAutoExtend, String ntStatus, String ntCompletionPercentage,
			String ntType, String ntPriority, String ntDeal, String ntCase, String ntTags, String ntDescription,
			String ntContact, String ntCompany, String ntIdentifier) {

		homePage.clickOnNewTaskLink();
		tasksPage.addNewTask(ntTitle, ntAutoExtend, ntStatus, ntCompletionPercentage, ntType, ntPriority, ntDeal,
				ntCase, ntTags, ntDescription, ntContact, ntCompany, ntIdentifier);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
