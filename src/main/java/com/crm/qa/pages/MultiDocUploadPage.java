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

public class MultiDocUploadPage extends TestBase {
	
	@FindBy(name="directory_id")
	WebElement multiDocfolderDropDown;
	
	@FindBy(name="contact_lookup")
	WebElement multiDocContact;
	
	@FindBy(name="client_lookup")
	WebElement multiDocClient;
	
	@FindBy(name="prospect_lookup")
	WebElement multiDocProspect;
	
	@FindBy(name="task_lookup")
	WebElement multiDocTask;
	
	@FindBy(name="case_lookup")
	WebElement multiDocCase;
	
	@FindBy(id="tags")
	WebElement multiDocTags;
	
	@FindBy(name="file1")
	WebElement multiDocChooseFile1Button;
	
	@FindBy(name="file2")
	WebElement multiDocChooseFile2Button;
	
	@FindBy(name="file3")
	WebElement multiDocChooseFile3Button;
	
	@FindBy(xpath="//a[contains(text(), 'Add Another')]")
	WebElement multiDocAddAnotherLink;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement multiDocSaveButton;
	
	public MultiDocUploadPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void uploadMultipleFiles(String mDFolder, String mDContact, String mDClient, String mDProspect, String mDTask, String mDCase, 
			String mDTags) throws InterruptedException, AWTException {
		
		multiDocfolderDropDown.sendKeys(mDFolder);
		multiDocContact.sendKeys(mDContact);
		multiDocClient.sendKeys(mDClient);
		multiDocProspect.sendKeys(mDProspect);
		multiDocTask.sendKeys(mDTask);
		multiDocCase.sendKeys(mDCase);
		multiDocTags.sendKeys(mDTags);
		
		multiDocChooseFile1Button.click();
		
		StringSelection uploadFile1 = new StringSelection("F:\\eclipse-workspace\\FreeCRMTestDemo_Git\\src\\main\\java\\com\\crm\\qa\\testdata\\Mail Merge Attachment.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadFile1, null);
		
		Thread.sleep(2000);
		
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.setAutoDelay(1000);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.setAutoDelay(1000);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.setAutoDelay(1000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.setAutoDelay(3000);
		
		multiDocAddAnotherLink.click();
		
		multiDocChooseFile2Button.click();
		
		StringSelection uploadFile2 = new StringSelection("F:\\eclipse-workspace\\FreeCRMTestDemo_Git\\src\\main\\java\\com\\crm\\qa\\testdata\\freeCrmTestData.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadFile2, null);
		
		Thread.sleep(2000);
		
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.setAutoDelay(1000);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.setAutoDelay(1000);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.setAutoDelay(1000);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.setAutoDelay(3000);
		
		multiDocAddAnotherLink.click();
		
		multiDocChooseFile3Button.click();
		
		StringSelection uploadFile3 = new StringSelection("F:\\eclipse-workspace\\FreeCRMTestDemo_Git\\src\\main\\java\\com\\crm\\qa\\testdata\\freeCrmTestData - Copy.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadFile3, null);
		
		Thread.sleep(2000);
		
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_CONTROL);
		robot3.setAutoDelay(1000);
		robot3.keyPress(KeyEvent.VK_V);
		robot3.setAutoDelay(1000);
		robot3.keyRelease(KeyEvent.VK_CONTROL);
		robot3.keyRelease(KeyEvent.VK_V);
		robot3.setAutoDelay(1000);
		robot3.keyPress(KeyEvent.VK_ENTER);
		robot3.setAutoDelay(3000);
		
		Thread.sleep(2000);
		
		multiDocSaveButton.click();
	}

}
