package com.crm.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DocsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DocsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DocsPage docsPage;
	
	String sheetName = "Docs";
	
	public DocsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		docsPage = new DocsPage();
		docsPage = homePage.clickOnDocsLink();
	}
	
	@Test(priority=1)
	public void verifyDocsPageLabel() {
		Assert.assertTrue(docsPage.verifyRootFolderLabel(), "Root folder label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider = "getCRMTestData")
	public void validateCreateNewDocument(String docTitle, String docDescription, String docVersion, String docContact, String docClient, 
			String docProspect, String docTask, String docCase, String docTags) throws InterruptedException, AWTException {
		
		homePage.clickOnNewDocumentLink();
		docsPage.createNewDocument(docTitle, docDescription, docVersion, docContact, docClient, docProspect, docTask, docCase, docTags);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
