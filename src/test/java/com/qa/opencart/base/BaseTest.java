package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.ItemsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;



public class BaseTest {
	
	WebDriver driver;
	
	protected LoginPage lpage;
	protected AccountsPage accPage;
	protected ItemsPage itemPage;
	protected ProductInfoPage productInfo;
	protected DriverFactory df;
	protected Properties prop;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProperty();
		driver = df.initBrowser(prop);		
		lpage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
