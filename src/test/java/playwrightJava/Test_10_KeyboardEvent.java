package playwrightJava;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_10_KeyboardEvent {
	/******************************************************************************************************
	 * For more ouse hover in press function F1 - F12, Digit0- Digit9, KeyA- KeyZ,
	 * Backquote, Minus, Equal, Backslash, Backspace, Tab, Delete, Escape,
	 * ArrowDown, End, Enter, Home, Insert, PageDown, PageUp, ArrowRight, ArrowUp,
	 * etc.
	 ******************************************************************************************************/
	@Test()
	public void test_keyboard_Enter() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://letskodeit.teachable.com/pages/practice");
		page.press("//a[normalize-space()='Open Tab']", "Enter");

		page.pause();
	}

	@Test
	public void test_arrowAndMore() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		page.type("//input[@id='autocomplete']", "ind");
		Thread.sleep(2000);
		page.press("//input[@id='autocomplete']", "ArrowDown");
		page.press("//input[@id='autocomplete']", "ArrowDown");
		page.press("//input[@id='autocomplete']", "Enter");

		Thread.sleep(2000);
		page.fill("//input[@id='autocomplete']", "ind");
		page.press("//input[@id='autocomplete']", "Control+a");
		Thread.sleep(2000);
		page.press("//input[@id='autocomplete']", "Backspace");
		page.pause();
	}

	@Test
	public void test_pageDown() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://letskodeit.teachable.com/pages/practice");
		page.press("//h1[normalize-space()='Practice Page']", "PageDown");
		Thread.sleep(2000);
		page.press("//h1[normalize-space()='Practice Page']", "PageDown");

		page.pause();
	}
}
