package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Deals')]")
	WebElement dealsLabel;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(id="title")
	WebElement dealTitle;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(name="contact_lookup")
	WebElement primayContactName;
	
	@FindBy(name="amount")
	WebElement dealAmount;
	
	@FindBy(id="probability")
	WebElement dealProbability;
	
	@FindBy(id="commission")
	WebElement dealCommission;
	
	@FindBy(name="identifier")
	WebElement dealIdentifier;
	
	@FindBy(id="quantity")
	WebElement dealQuantity;
	
	@FindBy(name="type")
	WebElement typeDropDown;
	
	@FindBy(name="source")
	WebElement sourceDropDown;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealsLabel() {
		return dealsLabel.isDisplayed();
	}
	
	public void createNewDeal(String title, String clientLookup, String amount, String probability, String commission, String identifier,
			String quantity, String type, String source) {
		
		dealTitle.sendKeys(title);
		companyName.sendKeys(clientLookup);
		dealAmount.sendKeys(amount);
		dealProbability.sendKeys(probability);
		dealCommission.sendKeys(commission);
		dealIdentifier.sendKeys(identifier);
		dealQuantity.sendKeys(quantity);
		
		Select selectType = new Select(typeDropDown);
		selectType.selectByVisibleText(type);
		
		Select selectSource = new Select(sourceDropDown);
		selectSource.selectByVisibleText(source);
		
		saveButton.click();
	}
	

}
