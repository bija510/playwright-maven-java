package playwrightJava;

import java.util.List;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BrowserChannel;

public class Test_16_MultipleWIndow {

	@Test
	public void switchWndow() throws InterruptedException {		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel(BrowserChannel.CHROME));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(page.title());
		
		//This is how we switch to new page
		ElementHandle openWindowButton = page.querySelector("button[id='openwindow']");	
		Page newPage = browserContext.waitForPage(() -> {
			openWindowButton.click();// Opens a new tab
			});
		
		newPage.waitForLoadState();
		System.out.println(newPage.title());
			
	}
	
	@Test
	public void test_multiple_page() throws InterruptedException {		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page pageOne = browserContext.newPage();
		Page pageTwo = browserContext.newPage();
		
		// Get pages of a brower context
		List<Page> allPages = browserContext.pages();
		
		pageOne.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		pageTwo.navigate("http://demo.automationtesting.in/Register.html");
	
		
	}
}
