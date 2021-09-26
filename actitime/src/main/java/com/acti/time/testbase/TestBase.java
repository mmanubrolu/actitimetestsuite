package com.acti.time.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.acti.time.util.Util;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\malli\\workspace\\actitimetestsuite\\actitime\\src\\test\\resource\\com\\acti\\time\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Malli Softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
