package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CasesPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Cases')]")
	WebElement casesLabel;
	
	@FindBy(xpath="//a[@title='Cases']")
	WebElement casesLink;
	
	@FindBy(id="title")
	WebElement caseTitle;
	
	@FindBy(name="status")
	WebElement caseStatusDropDown;
	
	@FindBy(id="f_trigger_c_deadline")
	WebElement caseDeadlineDatePicker;
	
	@FindBy(xpath="//input[@name='closed' and @value='N']")
	WebElement caseOpenState;
	
	@FindBy(xpath="//input[@name='closed' and @value='Y']")
	WebElement caseClosedState;
	
	@FindBy(name="identifier")
	WebElement caseIdentifier;
	
	@FindBy(name="type")
	WebElement caseType;
	
	@FindBy(name="priority")
	WebElement casePriority;
	
	@FindBy(name="contact_lookup")
	WebElement caseContactLookupText;
	
	@FindBy(xpath="//*[@id='caseForm']/table/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[2]/input[4]")
	WebElement caseContactLookupButton;
	
	@FindBy(name="client_lookup")
	WebElement caseClientLookupText;
	
	//@FindBy(id="tags")
	//WebElement caseTags;
	
	//@FindBy(id="description")
	//WebElement caseDescription;
	
	//@FindBy(xpath="//input[@type='submit' and @value='Save' and @class='button']")
	@FindBy(xpath="//form[@id='caseForm']/table/tbody/tr[7]/td/input")
	WebElement saveButton;
	
	public CasesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCasesLabel() {
		return casesLabel.isDisplayed();
	}
	
	public void createNewCase(String cTitle, String cStatus, String cIdentifier, String cType, String cPriority, 
			String cContactLookup) throws InterruptedException {
		
		caseTitle.sendKeys(cTitle);
		
		Select selectCaseStatus = new Select(caseStatusDropDown);
		selectCaseStatus.selectByVisibleText(cStatus);
		
		//caseDeadline.sendKeys(cDeadline);
		
		caseDeadlineDatePicker.click();
		
		List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='calendar']/table[1]//td"));
		
		for(WebElement ele:allDates) {
			String date = ele.getText();
			if(date.equalsIgnoreCase("28")) {
				ele.click();
				break;
			}
		}
		
		
		caseIdentifier.sendKeys(cIdentifier);
		
		Select selectCaseType = new Select(caseType);
		selectCaseType.selectByVisibleText(cType);
		
		Select selectPriority = new Select(casePriority);
		selectPriority.selectByVisibleText(cPriority);
		
		caseContactLookupText.sendKeys(cContactLookup);
		
		caseContactLookupButton.click();
		
		String currentWindowHandle = driver.getWindowHandle();
		
		for(String nextWindowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(nextWindowHandle);
		}
		
		WebElement contactLookupSearchResult = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/a"));
		contactLookupSearchResult.click();
		
		driver.switchTo().window(currentWindowHandle);
		
		//caseTags.sendKeys(cTags);
		
		//caseDescription.sendKeys(cDescription);
		
		saveButton.click();
		
	}

}
