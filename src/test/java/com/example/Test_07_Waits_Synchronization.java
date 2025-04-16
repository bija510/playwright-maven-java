package com.example;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_07_Waits_Synchronization {
/****************************************************************************************
 * https://playwright.dev/java/docs/actionability
 * This By default auto wait for 30sec for element same to present for to do any action
 * as WebDriverWait (Explicit wait) in Selenium
 * For example, for Page.click(selector[, options]), Playwright will ensure that:
	1) element is Attached to the DOM
	2) element is Visible
	3) element is Stable, as in not animating or completed animation
	4) element Receives Events, as in not obscured by other elements
	5) element is Enabled
 ****************************************************************************************/
	
	@Test(description = "Explicit wait example in playwright")
	public void test_waits() throws InterruptedException {		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("http://demo.automationtesting.in/Loader.html");
		
		Thread.sleep(1000);
		// page.wait + control space give other function
		page.click("//button[normalize-space()='Run']");
		// this element take 15-20 sec to be displayed	
		page.click("//button[normalize-space()='Close']");
	}
}
