package com.qa.opencart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsUtil {
	
	private WebDriver driver;
	
	public ElementsUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public String doGetPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void doSendKeys(String locator, String valueToEnter) {
		driver.findElement(By.xpath(locator)).sendKeys(valueToEnter);
	}
	
	public void doClick(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

}
