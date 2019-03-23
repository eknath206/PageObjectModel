package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class CallsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Calls')]")
	WebElement callsLabel;
	
	@FindBy(xpath="//*[@id='callDbLookup']/table/tbody/tr[1]/td[2]/input[4]")
	WebElement contactLookupButton;
	
	@FindBy(name="contact_lookup")
	WebElement contactLookupText;
	
	

}
