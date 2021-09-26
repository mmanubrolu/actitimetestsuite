package com.acti.time.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.time.testbase.TestBase;

public class TaskPage extends TestBase {
	
	//page repository
	@FindBy(xpath="//div[@class='taskManagementHeaderPanel']//input[@placeholder='Start typing name ...']")
	WebElement searchBox;
	
	//constructor
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}

	// methods or functions
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isSearchBoxDisplayed() {
		return searchBox.isDisplayed();
	}
}
