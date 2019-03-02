package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CompaniesPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Companies')]")
	WebElement companiesLabel;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement companiesLink;
	
	@FindBy(id="company_name")
	WebElement companyName;
	
	@FindBy(name="industry")
	WebElement industryName;
	
	@FindBy(id="annual_revenue")
	WebElement annualRevenue;
	
	@FindBy(id="num_of_employees")
	WebElement numOfEmployees;
	
	@FindBy(name="status")
	WebElement statusDropDown;
	
	@FindBy(name="category")
	WebElement categoryDropDown;
	
	@FindBy(name="priority")
	WebElement priorityDropDown;
	
	@FindBy(name="source")
	WebElement sourceDropDown;
	
	@FindBy(name="type")
	WebElement typeDropDown;
	
	@FindBy(name="address")
	WebElement companyAddress;
	
	@FindBy(name="city")
	WebElement companyCity;
	
	@FindBy(name="state")
	WebElement companyState;
	
	@FindBy(name="postcode")
	WebElement companyPostcode;
	
	@FindBy(name="country")
	WebElement companyCountry;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit']")
	WebElement saveButton;
	
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCompaniesLabel() {
		return companiesLabel.isDisplayed();
	}
	
	public void createNewCompany(String compName, String industry, String revenue, String employees, String status, String category,
			String priority, String source, String type, String address, String city, String state, String zip, String country) {
		
		companyName.sendKeys(compName);
		industryName.sendKeys(industry);
		annualRevenue.sendKeys(revenue);
		numOfEmployees.sendKeys(employees);
		
		Select selectStatus = new Select(statusDropDown);
		selectStatus.selectByVisibleText(status);
		
		Select selectCategory = new Select(categoryDropDown);
		selectCategory.selectByVisibleText(category);
		
		Select selectPriority = new Select(priorityDropDown);
		selectPriority.selectByVisibleText(priority);
		
		Select selectSource = new Select(sourceDropDown);
		selectSource.selectByVisibleText(source);
		
		Select selectType = new Select(typeDropDown);
		selectType.selectByVisibleText(type);
		
		companyAddress.sendKeys(address);
		companyCity.sendKeys(city);
		companyState.sendKeys(state);
		companyPostcode.sendKeys(zip);
		companyCountry.sendKeys(country);
		
		saveButton.click();
	}
	

}
