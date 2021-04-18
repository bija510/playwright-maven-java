package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class Test_01_Login extends BaseTest {

	@Test
	public void test() throws Exception {
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
