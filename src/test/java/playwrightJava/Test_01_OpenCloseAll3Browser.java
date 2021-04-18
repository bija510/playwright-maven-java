package playwrightJava;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BrowserChannel;

/*****************************************************************************************************
	1. We just Run the first & it automatically download chromium , Webkit, & firefox Browser
	chromium v854489 downloaded to C:\Users\Bijaya Chhetri\AppData\Local\ms-playwright\chromium-854489
	webkit v1438 downloaded to C:\Users\Bijaya Chhetri\AppData\Local\ms-playwright\webkit-1438
	firefox v1234 downloaded to C:\Users\Bijaya Chhetri\AppData\Local\ms-playwright\firefox-1234
	2. By Default it run in headless mode (to run GUI-mode)
	 Documentation:- https://playwright.dev/java/docs/intro
******************************************************************************************************/
public class Test_01_OpenCloseAll3Browser {

	/** [--BrowserChannel--] Introduce in Version:-1.10 work Good
	  CHROME,
	  CHROME_BETA,
	  CHROME_DEV,
	  CHROME_CANARY,
	  MSEDGE,
	  MSEDGE_BETA,
	  MSEDGE_DEV,
	  MSEDGE_CANARY
	 * @throws InterruptedException 
	 */
	@Test
	public void test_CHROME_real_browser() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel(BrowserChannel.CHROME));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(10000);
	}
	

	@Test
	public void test_MSEDGE_real_browser() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel(BrowserChannel.MSEDGE));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(10000);
	}
	
	@Test
	public void test_Chromium_For_Chrome_And_Edge() {
		 try (Playwright playwright = Playwright.create()) {
			 /************************
			 for Headless we use this
			 *************************/
			  //Browser browser = playwright.chromium().launch();
			 
		     /************************
			 To see the browser UI
			 *************************/
			  Browser browser = playwright.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50) );
			  
		      Page page = browser.newPage();
		      page.navigate("http://playwright.dev");
		      System.out.println("Page title:- "+page.title());
		      
		      /*********************************************
				It Autoclose browser to prevent we do pause
			   ********************************************/
		      page.pause();
		    }		
	 }
	
	@Test
	public void test_for_firefox() {
		 try (Playwright playwright = Playwright.create()) {
			 /************************
			 for Headless we use this
			 *************************/
			  //Browser browser = playwright.firefox().launch();
			 
		     /************************
			 To see the browser UI
			 *************************/
			  Browser browser = playwright.firefox().launch( new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50) );			  
		      Page page = browser.newPage();
		      page.navigate("http://playwright.dev");
		      System.out.println("Page title:- "+page.title());		      
		      page.pause();
		     
		    }		
	 }
	
	@Test
	public void test_webkit_for_mac_SafariBrowser() {
		 try (Playwright playwright = Playwright.create()) {
			 /************************
			 for Headless we use this
			 *************************/
			  //Browser browser = playwright.webkit().launch();
			 
		     /************************
			 To see the browser UI
			 *************************/
			  Browser browser = playwright.webkit().launch( new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50) );			  
		      Page page = browser.newPage();
		      page.navigate("http://playwright.dev");
		      System.out.println("Page title:- "+page.title());		      
		      page.pause();
		    }		
	 }
}
