package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(), 'eknathD eknathD')]")
	WebElement userNameLabel;
	
<<<<<<< HEAD
	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calendarLink;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[@title='Contacts']")	//OR //a[contains(text(),'Contacts')]
=======
	@FindBy(xpath="//span[text()='Contacts']")	//OR //span[contains(text(), 'Contacts')]
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	WebElement contactsLink;
	
//	@FindBy(xpath="//a[contains(text(),'New Contact')]")
//	WebElement newContactLink;
	
	@FindBy(xpath="//span[contains(text(),'Companies')]")	//OR //span[text()='Companies']
	WebElement companiesLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")	//OR //span[text()='Deals']
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(), 'Tasks')]")	//OR //span[text()='Tasks']
	WebElement tasksLink;
	
<<<<<<< HEAD
	@FindBy(xpath="//a[@title='Cases']")
	WebElement casesLink;
	
	@FindBy(xpath="//a[@title='Call']")
	WebElement callsLink;
	
	@FindBy(xpath="//a[@title='Docs']")
	WebElement docsLink;
	
	@FindBy(xpath="//a[@title='Forms']")
	WebElement formsLink;
=======
	@FindBy(xpath="//span[contains(text(), 'Cases')]")	//OR //span[text()='Cases']
	WebElement casesLink;
	
	@FindBy(xpath="//span[contains(text(), 'Calls')]")	//OR //span[text()='Calls']
	WebElement callsLink;
	
	@FindBy(xpath="//span[contains(text(), 'Documents')]")	//OR //span[text(), 'Documents']
	WebElement documentsLink;
	
	@FindBy(xpath="//span[contains(text(), 'Campaigns')]")	//OR //span[text(), 'Campaigns']
	WebElement campaignsLink;
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	
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
	
	public CalendarPage clickOnCalendarLink() {
		calendarLink.click();
		return new CalendarPage();
	}
	
	public CompaniesPage clickOnCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
<<<<<<< HEAD
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
=======
	public CompaniesPage clickOnCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
<<<<<<< HEAD
=======
//	public void clickOnNewContactLink() {
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
//	}
	
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
<<<<<<< HEAD

=======
	
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	public CasesPage clickOnCasesLink() {
		casesLink.click();
		return new CasesPage();
	}
	
	public CallsPage clickOnCallsLink() {
		callsLink.click();
		return new CallsPage();
	}
	
<<<<<<< HEAD
	public DocsPage clickOnDocsLink() {
		docsLink.click();
		return new DocsPage();
	}
	
	public FormsPage clickOnFormsLink() {
		formsLink.click();
		return new FormsPage();
=======
	public DocumentsPage clickOnDocumentsLink() {
		documentsLink.click();
		return new DocumentsPage();
	}
	
	public CampaignsPage clickOnCampaignsLink() {
		campaignsLink.click();
		return new CampaignsPage();
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
	}


}
