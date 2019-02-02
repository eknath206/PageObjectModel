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
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt ='free crm logo']")
	WebElement crmLogo;
	
	//Initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);//this is for referring current class - same as LoginPage.class
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		/*
		 * Youtube URL: https://www.youtube.com/watch?v=iaI1vcEAWlM
		 * 
		 */
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(invisible) {
			loginBtn.click();
		}
		
		return new HomePage();
	}

}
