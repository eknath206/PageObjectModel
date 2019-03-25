package com.crm.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DocsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Root Folder')]")
	WebElement rootFolderLabel;
	
	@FindBy(id="title")
	WebElement documentTitle;
	
	@FindBy(name="description")
	WebElement documentDescription;
	
	@FindBy(id="version")
	WebElement documentVersion;
	
	@FindBy(name="file")
	WebElement chooseFileButton;
	
	@FindBy(name="contact_lookup")
	WebElement documentContactLookupText;
	
	@FindBy(name="client_lookup")
	WebElement documentClientLookupText;
	
	@FindBy(name="prospect_lookup")
	WebElement documentProspectLookupText;
	
	@FindBy(name="task_lookup")
	WebElement documentTaskLookupText;
	
	@FindBy(name="case_lookup")
	WebElement documentCaseLookupText;
	
	@FindBy(id="tags")
	WebElement documentTags;
	
	@FindBy(xpath="//*[@id='docForm']/table/tbody/tr[14]/td[2]/input")
	WebElement documentSaveButton;
	
	
	
	public DocsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyRootFolderLabel() {
		return rootFolderLabel.isDisplayed();
	}
	
	public void createNewDocument(String docTitle, String docDescription, String docVersion, String docContact, String docClient, String docProspect, 
			String docTask, String docCase, String docTags) throws InterruptedException, AWTException {
		
		documentTitle.sendKeys(docTitle);
		documentDescription.sendKeys(docDescription);
		documentVersion.sendKeys(docVersion);
		
		chooseFileButton.click();
		
		StringSelection upload = new StringSelection("F:\\eclipse-workspace\\FreeCRMTestDemo_Git\\src\\main\\java\\com\\crm\\qa\\testdata\\Mail Merge Attachment.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
		
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.setAutoDelay(2000);
		
		documentContactLookupText.sendKeys(docContact);
		documentClientLookupText.sendKeys(docClient);
		documentProspectLookupText.sendKeys(docProspect);
		documentTaskLookupText.sendKeys(docTask);
		documentCaseLookupText.sendKeys(docCase);
		documentTags.sendKeys(docTags);
		
		documentSaveButton.click();
		
		
	}

}
