package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory - OR
	
	@FindBy(name="email")
	WebElement useremail;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	//@FindBy(xpath="//img[@alt ='free crm logo']")
<<<<<<< HEAD
	@FindBy(xpath="//img[@src ='https://classic.crmpro.com/img/logo@2x.png']")
	WebElement crmLogo;
=======
	//WebElement crmLogo;
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	
	//Initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);//this is for referring current class - same as LoginPage.class
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
//	public boolean validateCRMImage() {
//		return crmLogo.isDisplayed();
//	}
	
	public HomePage login(String un, String pwd) {
		useremail.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		/*
		 * Youtube URL: https://www.youtube.com/watch?v=iaI1vcEAWlM
		 * 
		 */
		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		
//		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
//		if(invisible) {
//			loginBtn.click();
//		}
		
		return new HomePage();
	}

}
