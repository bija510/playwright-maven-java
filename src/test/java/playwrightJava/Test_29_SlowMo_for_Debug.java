package playwrightJava;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BrowserChannel;

public class Test_29_SlowMo_for_Debug {

	
	@Test
	public void test_slowmo_for_debugging() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel(BrowserChannel.CHROME).setSlowMo(50));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(10000);
	}
	
}
