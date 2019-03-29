package com.crm.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(), 'Tasks')]")
	WebElement allTasksLabel;

	@FindBy(id = "title")
	WebElement newTaskTitle;

	@FindBy(id = "f_trigger_c_deadline")
	WebElement newTaskDeadlineCalendarImage;

	@FindBy(name = "auto_extend")
	WebElement newTaskAutoExtend;

	@FindBy(name = "status")
	WebElement newTaskStatus;

	@FindBy(id = "completion")
	WebElement newTaskCompletionPercentage;

	@FindBy(name = "task_type")
	WebElement newTaskType;

	@FindBy(name = "priority")
	WebElement newTaskPriority;

	@FindBy(name = "prospect_lookup")
	WebElement newTaskDeal;

	@FindBy(name = "case_lookup")
	WebElement newTaskCase;

	@FindBy(id = "tags")
	WebElement newTaskTags;

	@FindBy(name = "description")
	WebElement newTaskDescription;

	@FindBy(name = "contact_lookup")
	WebElement newTaskContact;

	@FindBy(name = "client_lookup")
	WebElement newTaskCompany;

	@FindBy(name = "identifier")
	WebElement newTaskIdentifier;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement newTaskSaveButton;

	public TasksPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyTasksLabel() {
		return allTasksLabel.isDisplayed();
	}

	public void addNewTask(String ntTitle, String ntAutoExtend, String ntStatus, String ntCompletionPercentage,
			String ntType, String ntPriority, String ntDeal, String ntCase, String ntTags, String ntDescription,
			String ntContact, String ntCompany, String ntIdentifier) {

		newTaskTitle.sendKeys(ntTitle);

		newTaskDeadlineCalendarImage.click();

		List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='calendar']/table[1]//td"));

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		String dateArray[] = date1.split("-");
		String day = dateArray[1];

		for (WebElement ele : allDates) {
			String date2 = ele.getText();
			if (date2.equalsIgnoreCase(day)) {
				ele.click();
				break;
			}
		}

		newTaskAutoExtend.sendKeys(ntAutoExtend);
		newTaskStatus.sendKeys(ntStatus);
		newTaskCompletionPercentage.sendKeys(ntCompletionPercentage);
		newTaskType.sendKeys(ntType);
		newTaskPriority.sendKeys(ntPriority);
		newTaskDeal.sendKeys(ntDeal);
		newTaskCase.sendKeys(ntCase);
		newTaskTags.sendKeys(ntTags);
		newTaskDescription.sendKeys(ntDescription);
		newTaskContact.sendKeys(ntContact);
		newTaskCompany.sendKeys(ntCompany);
		newTaskIdentifier.sendKeys(ntIdentifier);
		newTaskSaveButton.click();

	}

}
