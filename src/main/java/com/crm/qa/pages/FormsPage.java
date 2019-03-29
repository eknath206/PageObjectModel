package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class FormsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(), 'Feedback Forms')]")
	WebElement feedbackFormsLabel;

	@FindBy(id = "title")
	WebElement feedbackFormTitle;

	@FindBy(id = "pages")
	WebElement feedbackFormPages;

	@FindBy(id = "report_email")
	WebElement feedbackFormReportEmail;

	@FindBy(name = "description")
	WebElement feedbackFormDescription;

	@FindBy(name = "welcome_message")
	WebElement feedbackFormWelcomeMessage;

	@FindBy(name = "confirmation_message")
	WebElement feedbackFormConfirmationMessage;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement feedbackFormSaveButton;

	public FormsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyFeedbackFormLabel() {
		return feedbackFormsLabel.isDisplayed();
	}

	public void addFeedbackForm(String ffTitle, String ffPages, String ffReportEmail, String ffDescription,
			String ffWelcomeMessage, String ffConfirmationMessage) {

		feedbackFormTitle.sendKeys(ffTitle);
		feedbackFormPages.sendKeys(ffPages);
		feedbackFormReportEmail.sendKeys(ffReportEmail);
		feedbackFormDescription.sendKeys(ffDescription);
		feedbackFormWelcomeMessage.sendKeys(ffWelcomeMessage);
		feedbackFormConfirmationMessage.sendKeys(ffConfirmationMessage);

		feedbackFormSaveButton.click();

	}

}
