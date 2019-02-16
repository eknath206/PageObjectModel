package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(), 'eknathD eknathD')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[text()='Contacts']")	//OR //span[contains(text(), 'Contacts')]
	WebElement contactsLink;
	
//	@FindBy(xpath="//a[contains(text(),'New Contact')]")
//	WebElement newContactLink;
	
	@FindBy(xpath="//span[contains(text(),'Companies')]")	//OR //span[text()='Companies']
	WebElement companiesLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")	//OR //span[text()='Deals']
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(), 'Tasks')]")	//OR //span[text()='Tasks']
	WebElement tasksLink;
	
	@FindBy(xpath="//span[contains(text(), 'Cases')]")	//OR //span[text()='Cases']
	WebElement casesLink;
	
	@FindBy(xpath="//span[contains(text(), 'Calls')]")	//OR //span[text()='Calls']
	WebElement callsLink;
	
	@FindBy(xpath="//span[contains(text(), 'Documents')]")	//OR //span[text(), 'Documents']
	WebElement documentsLink;
	
	@FindBy(xpath="//span[contains(text(), 'Campaigns')]")	//OR //span[text(), 'Campaigns']
	WebElement campaignsLink;
	
	//Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public CompaniesPage clickOnCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
//	public void clickOnNewContactLink() {
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
//	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public CasesPage clickOnCasesLink() {
		casesLink.click();
		return new CasesPage();
	}
	
	public CallsPage clickOnCallsLink() {
		callsLink.click();
		return new CallsPage();
	}
	
	public DocumentsPage clickOnDocumentsLink() {
		documentsLink.click();
		return new DocumentsPage();
	}
	
	public CampaignsPage clickOnCampaignsLink() {
		campaignsLink.click();
		return new CampaignsPage();
	}


}
