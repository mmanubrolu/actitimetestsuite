package com.acti.time.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.acti.time.page.HomePage;
import com.acti.time.page.LoginPage;
import com.acti.time.page.TaskPage;
import com.acti.time.testbase.TestBase;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TaskPage taskPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.clickOnLoginButton(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateTitleTest() throws InterruptedException {
		Thread.sleep(20000);
		String title = homePage.getTitle();
		Assert.assertEquals(title, "actiTIME - Enter Time-Track", "Home page title is not matched");
		
		homePage.clickOnLogOut();
	}
	
	@Test(priority=2)
	public void validateUrlTest() throws InterruptedException {
		Thread.sleep(20000);
		String url = homePage.getUrl();
		Assert.assertEquals(url, "https://demo.actitime.com/user/submit_tt.do", "Home page url is not matched");
		Thread.sleep(20000);
		homePage.clickOnLogOut();
	}
	
	@Test(priority=3)
	public void validateTaskTest() throws InterruptedException {
		Thread.sleep(20000);
		taskPage = homePage.clickOnTaskTab();
		Thread.sleep(20000);
		homePage.clickOnLogOut();
	}
	
	/*@Test(priority=4)
	public void validateSearchBoxDisplayedTest() {
		taskPage = homePage.clickOnTaskTab();
		boolean isDisplayed = taskPage.isSearchBoxDisplayed()
	}*/
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
