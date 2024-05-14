package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void AccountsPageSetup() {
		accPage = lpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void accsPageTitleTest() {
		String actAccPageTitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(actAccPageTitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void searchProductTest() {
		itemPage = accPage.searchProduct("macbook");
		String actSearchedItem = itemPage.getSearchedProductHeader();
		System.out.println("Searched Item is -> " +actSearchedItem);
		Assert.assertEquals(actSearchedItem, "macbook");
	}
	
}
