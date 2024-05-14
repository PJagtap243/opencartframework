package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage {

	private By itemName = By.xpath("//div[@id='content']//h1");
	
	private WebDriver driver;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getItemNameTest() {
		String actItemName = driver.findElement(itemName).getText();
		return actItemName;
	}

}
