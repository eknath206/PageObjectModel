package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class AlertsPage extends TestBase {

	@FindBy(xpath = "//legend[contains(text(), 'Create New Alert')]")
	WebElement createAlertLabel;

	@FindBy(name = "alert_send_mode")
	WebElement alertSendModeDropdown;

	@FindBy(name = "object_type")
	WebElement alertObjectTypeDropdown;

	@FindBy(name = "alert_trigger")
	WebElement alertTriggerDropdown;

	@FindBy(name = "format")
	WebElement alertFormatDropdown;

	@FindBy(xpath = "//input[@value='N' and @name='active']")
	WebElement alertActiveNo;

	@FindBy(xpath = "//input[@value='Y' and @name='active']")
	WebElement alertActiveYes;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveAlertButton;

	public AlertsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCreateAlertLabel() {
		return createAlertLabel.isDisplayed();
	}

	public void createNewAlert(String aSendMode, String aObjectType, String aTrigger, String aFormat, String aActive) {

		Select selectAlertSendMode = new Select(alertSendModeDropdown);
		selectAlertSendMode.selectByVisibleText(aSendMode);

		Select selectAlertObjectType = new Select(alertObjectTypeDropdown);
		selectAlertObjectType.selectByVisibleText(aObjectType);

		Select selectAlertTrigger = new Select(alertTriggerDropdown);
		selectAlertTrigger.selectByVisibleText(aTrigger);

		Select selectAlertFormat = new Select(alertFormatDropdown);
		selectAlertFormat.selectByVisibleText(aFormat);

		if (aActive == "Yes") {
			alertActiveYes.click();
		} else {
			alertActiveNo.click();
		}

		saveAlertButton.click();

	}

}
