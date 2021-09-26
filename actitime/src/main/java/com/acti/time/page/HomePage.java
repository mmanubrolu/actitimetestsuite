package com.acti.time.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.time.testbase.TestBase;

public class HomePage extends TestBase {
	
	//object repository
	@FindBy(id="logoutLink")
	WebElement logOut;
	
	@FindBy(id="logo_aT")
	WebElement logo;
	
	@FindBy(id="container_tasks")
	WebElement tasksTab;
	
	//constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods or functions
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public void clickOnLogOut() {
		logOut.click();
	}
	
	public TaskPage clickOnTaskTab() {
		tasksTab.click();
		return new TaskPage();
	}

}
