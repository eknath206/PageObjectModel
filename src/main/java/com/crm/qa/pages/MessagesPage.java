package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MessagesPage extends TestBase {

	@FindBy(xpath = "//input[@value='New Message']")
	WebElement newMessageButton;

	@FindBy(xpath = "//td[contains(text(), 'Message Board')]")
	WebElement messageBoardLabel;

	@FindBy(id = "subject")
	WebElement messageSubject;

	@FindBy(id = "msg")
	WebElement messageText;

	@FindBy(xpath = "//input[@value='Post']")
	WebElement postButton;

	public MessagesPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyMessageBoardLabel() {
		return messageBoardLabel.isDisplayed();
	}

	public void createNewMessage(String mSubject, String mText) {

		newMessageButton.click();

		messageSubject.sendKeys(mSubject);
		messageText.sendKeys(mText);

		postButton.click();

	}

}
