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

public class WordMergeTemplatePage extends TestBase {
	
	@FindBy(id="title")
	WebElement templateTitle;
	
	@FindBy(name="description")
	WebElement templateDescription;
	
	@FindBy(id="version")
	WebElement templateVersion;
	
	@FindBy(name="file")
	WebElement templateFileUploadButton;
	
	@FindBy(id="tags")
	WebElement templateTags;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement templateSaveButton;
	
	public WordMergeTemplatePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewWordMergeTemplate(String tempTitle, String tempDescription, String tempVersion, 
			String tempTags) throws InterruptedException, AWTException {
		
		templateTitle.sendKeys(tempTitle);
		templateDescription.sendKeys(tempDescription);
		templateVersion.sendKeys(tempVersion);
		
		templateFileUploadButton.click();
		
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
		robot.setAutoDelay(4000);
		
		templateTags.sendKeys(tempTags);
		
		templateSaveButton.click();
		
	}

}
