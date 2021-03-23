package playwrightJava;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_14_Frame_WIP {

	@Test()
	public void test_waits() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://letskodeit.teachable.com/pages/practice");
		page.press("//a[normalize-space()='Open Tab']", "Enter");

		page.pause();
		}
	}
