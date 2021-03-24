package playwrightJava;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import base.BaseTest;

public class zTemp {

	Page page;

	@BeforeMethod
	public void setUp() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		page = browserContext.newPage();
	}
	
	@Test
	public void test001() throws InterruptedException {
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");	

		page.evaluate("document.querySelector('#opentab').click()");
		// String videoPath = System.getProperty("user.dir")+"\\Data\\Upload file.pdf";
		 System.out.println(page.video().path());
		 page.video().path();
	
		
	}
}