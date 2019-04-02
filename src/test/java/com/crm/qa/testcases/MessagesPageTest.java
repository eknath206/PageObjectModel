package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MessagesPage;
import com.crm.qa.util.TestUtil;

public class MessagesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	MessagesPage messagesPage;

	String sheetName = "Messages";

	public MessagesPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		messagesPage = new MessagesPage();
		messagesPage = homePage.clickOnMessagesLink();

	}

	@Test(priority = 1)
	public void verifyMessageBoardLabelTest() {
		Assert.assertTrue(messagesPage.verifyMessageBoardLabel(), "Verify Message Board label is missing on the page");
	}

	@DataProvider
	public Object[][] getCRMData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCRMData")
	public void validateCreateNewMessage(String mSubject, String mText) {
		messagesPage.createNewMessage(mSubject, mText);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
