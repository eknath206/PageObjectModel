package com.crm.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;


import com.crm.qa.base.TestBase;

public class CallsPage extends TestBase {
	
	@FindBy(xpath="//legend[contains(text(), 'Call Information')]")
	WebElement callLabel;
	
	@FindBy(name="contact_lookup")
	WebElement callContactLookupText;
	
	@FindBy(xpath="//*[@id='callDbLookup']/table/tbody/tr[1]/td[2]/input[4]")
	WebElement callContactLookupButton;
	
	//@FindBy(name="flag")
	//@FindBy(xpath="//*[@id='callForm']/table/tbody/tr[8]/td[2]/select")
	//WebElement callFlag;
	
	@FindBy(id="f_trigger_c_start_time")
	WebElement callStartedDatePicker;
	
	@FindBy(name="prospect_lookup")
	WebElement callDeal;
	
	@FindBy(name="task_lookup")
	WebElement callTask;
	
	@FindBy(name="case_lookup")
	WebElement callCase;
	
	@FindBy(id="notes")
	WebElement callNotes;
	
	@FindBy(name="save")
	WebElement callSaveButton;
	
	@FindBy(name="saveandcall")
	WebElement saveAndCallButton;
	
	public CallsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCallLabel() {
		return callLabel.isDisplayed();
	}
	
	public void createNewCall(String cContactLookup, String cDeal, String cTask, String cCase, String cNotes) {
		
		callContactLookupText.sendKeys(cContactLookup);
		
		callContactLookupButton.click();
		
		//Search contact using lookup
		String currentWindowHandle = driver.getWindowHandle();
		
		for(String nextWindowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(nextWindowHandle);
		}
		
		WebElement contactLookupSearchResult = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/a"));
		
		contactLookupSearchResult.click();
		
		driver.switchTo().window(currentWindowHandle);
		
		//Select selectCallFlag = new Select(callFlag);
		//selectCallFlag.selectByVisibleText(cFlag);
		
		
		//Select today's date
		callStartedDatePicker.click();
		
		List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='calendar']/table[1]//td"));
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		String dateArray[] = date1.split("-");
		String day = dateArray[1];
		
		for(WebElement ele:allDates) {
			String date2 = ele.getText();
			if(date2.equalsIgnoreCase(day)) {
				ele.click();
				break;
			}
		}
		
		callDeal.sendKeys(cDeal);
		
		callTask.sendKeys(cTask);
		
		callCase.sendKeys(cCase);
		
		callNotes.sendKeys(cNotes);
		
		callSaveButton.click();
		
	
	}
	
	

}
