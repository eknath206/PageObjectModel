package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Eknath Dhauskar')]")
	WebElement userNameLabel;

	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calendarLink;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Company')]")
	WebElement newCompanyLink;
	
	@FindBy(xpath="//a[@title='Contacts']")	//OR //a[contains(text(),'Contacts')]
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[@title='Deals']")	//OR //a[contains(text(), 'Deals')]
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement newDealLink;
	
	@FindBy(xpath="//a[@title='Tasks']")	//OR //a[contains(text(), 'Tasks')]
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@title='Cases']")
	WebElement casesLink;
	
	@FindBy(xpath="//a[@title='New Case']")
	WebElement newCaseLink;
	
	@FindBy(xpath="//a[@title='Call']")
	WebElement callsLink;
	
	@FindBy(xpath="//a[@title='New Call']")
	WebElement newCallLink;
	
	@FindBy(xpath="//a[@title='Docs']")
	WebElement docsLink;
	
	@FindBy(xpath="//a[@title='Forms']")
	WebElement formsLink;

	@FindBy(xpath="//a[@title='Docs']")
	WebElement documentsLink;
	
	@FindBy(xpath="//a[@title='Campaigns']")
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
	
	public CalendarPage clickOnCalendarLink() {
		calendarLink.click();
		return new CalendarPage();
	}
	
	public CompaniesPage clickOnCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public void clickOnNewCompanyLink() {
		Actions action = new Actions(driver);
		action.moveToElement(companiesLink).build().perform();
		newCompanyLink.click();
	}
		
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewDealLink() {
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDealLink.click();
	}
		
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public CasesPage clickOnCasesLink() {
		casesLink.click();
		return new CasesPage();
	}
	
	public void clickOnNewCaseLink() {
		Actions action = new Actions(driver);
		action.moveToElement(casesLink).build().perform();
		newCaseLink.click();
	}
	
	public CallsPage clickOnCallsLink() {
		callsLink.click();
		return new CallsPage();
	}
	
	public void clickOnNewCallLink() {
		Actions action = new Actions(driver);
		action.moveToElement(callsLink).build().perform();
		newCallLink.click();
	}
	
	public DocsPage clickOnDocsLink() {
		docsLink.click();
		return new DocsPage();
	}
	
	public FormsPage clickOnFormsLink() {
		formsLink.click();
		return new FormsPage();
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
