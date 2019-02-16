package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Eknath Dhauskar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calendarLink;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[@title='Contacts']")	//OR //a[contains(text(),'Contacts')]
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[@title='Deals']")	//OR //a[contains(text(),'Deals')]
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")	//OR //a[contains(text(), 'Tasks')]
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@title='Cases']")
	WebElement casesLink;
	
	@FindBy(xpath="//a[@title='Call']")
	WebElement callsLink;
	
	@FindBy(xpath="//a[@title='Docs']")
	WebElement docsLink;
	
	@FindBy(xpath="//a[@title='Forms']")
	WebElement formsLink;
	
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
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
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
	
	public DocsPage clickOnDocsLink() {
		docsLink.click();
		return new DocsPage();
	}
	
	public FormsPage clickOnFormsLink() {
		formsLink.click();
		return new FormsPage();
	}


}
