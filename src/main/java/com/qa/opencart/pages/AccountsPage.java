package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
	
	private By searchBox = By.xpath("//input[@placeholder='Search']");
	private By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");
	
	private WebDriver driver;
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public ItemsPage searchProduct(String productName) {
		driver.findElement(searchBox).sendKeys(productName);
		driver.findElement(searchBtn).click();
		return new ItemsPage(driver);
	}
	
}
