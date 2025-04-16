package com.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.base.BaseTest;
import com.project.pages.LoginPage;

public class Test_Login extends BaseTest{

	@Test
	public void login() throws Exception {
		page.navigate(prop.getProperty("Url"));
		LoginPage loginPage = new LoginPage(page);
		loginPage.enterUserName(prop.getProperty("UserName"));
		loginPage.enterPassword(prop.getProperty("Password"));
		loginPage.clickLoginBtn();

		// Validation
		System.out.println(loginPage.getWelcomeMessage());

		System.out.println("From JsonFile=>" + data.readJson("welcomeText"));
		Assert.assertTrue(loginPage.getWelcomeMessage().contains(data.readJson("welcomeText")));

	}
}
