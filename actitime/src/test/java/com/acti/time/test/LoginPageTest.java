package com.acti.time.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.acti.time.model.LogingPageRequest;
import com.acti.time.page.HomePage;
import com.acti.time.page.LoginPage;
import com.acti.time.testbase.TestBase;
import com.acti.time.util.XLSXReaderUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	String fileName = "C:\\Users\\malli\\workspace\\actitimetestsuite\\actitime\\src\\test\\resource\\com\\acti\\time\\resource\\altitimelogintestdata.xlsx";
	String sheetName = "logintestData";
	String url;
	LoginPageTest() {
		super();
	}
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateTitleTest() {
		String title = loginPage.getTitle();
		Assert.assertEquals(title, "actiTIME - Login", "Login page title was not match");
	}
	
	@Test(priority=2)
	public void validateURLTest() {
		String url=loginPage.getURL();
		Assert.assertEquals(url, "https://demo.actitime.com/login.do", "Login page url was not matched");
	}
	
	@Test(priority=3)
	public void forgotPasswordLinkDisplayTest() {
		boolean isDisplayed = loginPage.ispasswordLinkDisplayed();
		Assert.assertTrue(isDisplayed, "Forget password link was not displayed");
	}
	
	@Test(priority=4)
	public void logoDisplayedTest() {
		boolean logoDisplayed = loginPage.isLogoDisplayed();
		Assert.assertTrue(logoDisplayed, "Logo was was not displayed");
	}
	
	@Test(priority=5)
	public void userLoginTest() {
		homePage = loginPage.clickOnLoginButton("admin", "manager");
		System.out.println("homePage.toString() --->>" + homePage.toString());
		homePage.clickOnLogOut();
	}
	
	@DataProvider
	public Iterator<Object[]> loginTestData() {
		ArrayList<Object[]> obj = XLSXReaderUtil.getLoginTestData(fileName, sheetName);
		
		return obj.iterator();
	}
	@Test(priority =6, dataProvider="loginTestData")
	public void userLoginDataDrivenTest(LogingPageRequest request) {
		
		homePage = loginPage.clickOnLoginButton(request.getUserName(), request.getPassword());
		System.out.println("homePage.toString() --->>" + homePage.toString());
		homePage.clickOnLogOut();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
