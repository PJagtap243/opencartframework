package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsPage {

	private By searchedProductHeader = By.xpath("//div[@id='content']//h1");
	private By productLink = By.xpath("//div[@class='caption']//a");
	private By product = By.xpath("//div[@class='caption']//b");
	
	private WebDriver driver;
	
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getItemsPageTitle() {
		return driver.getTitle();
	}
	
	public String getSearchedProductHeader() {
		String productName [] = driver.findElement(searchedProductHeader).getText().split("-");
		String name = productName[1].trim();
		return name;
	}
	
	public ProductInfoPage getProductInfo(String productName) {
		driver.findElement(By.linkText(productName)).click();
		return new ProductInfoPage(driver);
	}
}
