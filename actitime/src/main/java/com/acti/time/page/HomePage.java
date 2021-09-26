package com.acti.time.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.time.testbase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(id="logoutLink")
	WebElement logOut;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogOut() {
		logOut.click();
	}

}
