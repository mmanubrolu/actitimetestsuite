package com.acti.time.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.time.testbase.TestBase;

public class LoginPage extends TestBase{
	
	//page objects or object repository
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(name="pwd")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login ']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='atLogoImg']")
	WebElement logo;
	
	@FindBy(id="toPasswordRecoveryPageLink")
	WebElement passwordLink;
	
	// constructor or page factory 
	public LoginPage( ) {
		PageFactory.initElements(driver, this);
	}

	// methods or functions
	public HomePage clickOnLoginButton(String userName, String password) {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		loginButton.click();
		
		return new HomePage();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public boolean ispasswordLinkDisplayed() {
		return passwordLink.isDisplayed();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	
	
}
