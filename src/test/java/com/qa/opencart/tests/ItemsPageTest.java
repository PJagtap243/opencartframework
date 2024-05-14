package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class ItemsPageTest extends BaseTest{
	
	@BeforeClass
	public void itemPageSetup() {
		accPage = lpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void getProductInfoTest() {
		itemPage = accPage.searchProduct("macbook");
		productInfo=itemPage.getProductInfo("MacBook");
		String actItemName = productInfo.getItemNameTest();
		System.out.println("Item Name -> "+actItemName);
		Assert.assertEquals(actItemName, "MacBook");
	}

}
