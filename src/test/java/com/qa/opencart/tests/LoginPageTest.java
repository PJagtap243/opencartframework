package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String loginPageTitle = lpage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void doLogin() throws InterruptedException {
		accPage = lpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		String actAccPageTitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(actAccPageTitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}
}
