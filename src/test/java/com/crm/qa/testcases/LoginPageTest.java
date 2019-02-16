package com.crm.qa.testcases;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
<<<<<<< HEAD
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
=======
//	@Test(priority=1)
//	public void loginPageTitleTest() {
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
//	}
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	
//	@Test(priority=2)
//	public void crmLogoImageTest() {
//		boolean flag = loginPage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("useremail"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
