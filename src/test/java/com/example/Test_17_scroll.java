package com.example;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_17_scroll {

	@Test
	public void test_pageDown() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://letskodeit.teachable.com/pages/practice");
		page.press("//h1[normalize-space()='Practice Page']", "PageDown");
		Thread.sleep(2000);
		page.press("//h1[normalize-space()='Practice Page']", "PageDown");
		//******************Using javaScript************************
		page.evaluate("window.scrollTo(0,2000)");
		page.pause();
	}	
}
