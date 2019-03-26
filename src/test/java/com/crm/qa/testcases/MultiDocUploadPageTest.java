package com.crm.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MultiDocUploadPage;
import com.crm.qa.util.TestUtil;

public class MultiDocUploadPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	MultiDocUploadPage multiDocUploadPage;
	
	String sheetName = "MultiDocs";
	
	public MultiDocUploadPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		multiDocUploadPage = new MultiDocUploadPage();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void validateUploadMultipleFiles(String mDFolder, String mDContact, String mDClient, String mDProspect, String mDTask, String mDCase, 
			String mDTags) throws InterruptedException, AWTException {
		
		homePage.clickOnMultiDocUploadLink();
		multiDocUploadPage.uploadMultipleFiles(mDFolder, mDContact, mDClient, mDProspect, mDTask, mDCase, mDTags);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
