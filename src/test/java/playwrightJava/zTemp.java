package playwrightJava;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import base.BaseTest;

public class zTemp extends BaseTest{

	Page page;
	@Test
	public void test001() throws InterruptedException {
		page.navigate("http://demo.automationtesting.in/Datepicker.html");
		page.click("//button(kf)");
	}

}