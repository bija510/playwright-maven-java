package playwrightJava;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;

/*********************************************************************************************
 * Playwright can search for elements using CSS selectors, XPath selectors
 * You can explicitly specify the selector engine you are using or let Playwright detect it.
 * Selector Docs:- https://playwright.dev/docs/selectors
 * =============MUCH MORE SELECTORS LEFT NEED TO WORK IN FUTURE TBD.........==================
 *********************************************************************************************/
 
public class Test_02_Selectors {
	
	@Test
	public void test_text_buttonNameSelector() {
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("https://courses.letskodeit.com/practice");
			 
			 //1. Text selector has a few variations: 
			 //<button id="openwindow" class="btn-style class1" onclick="openWindow()" xpath="1">Open Window</button>
			
			 // page.click("text=Open Window");
			 // or we can do this and it's same
			 page.click("'Open Window'");
			 page.pause();
	     }
	}
	
	@Test
	public void test_text_selector_2() {
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("https://www.orangehrm.com/orangehrm-30-days-trial/");
			 //Type =1 
			// page.locator("text=privacy Policy").first().click();
			
			Locator links = page.locator("text=privacy Policy");
			 for(int i =0; i<links.count(); i++) {
				 System.out.println(links.nth(i).textContent());
				 links.nth(i).click();
			 }
			// page.pause();
	     }
	}
	
	@Test
	public void test_text_selector_3() {
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("http://demo.automationtesting.in/Register.html");
			 
			 String header = page.locator("h2:has-text('Register')").textContent(); // h2= tagname
			 System.out.println(header);
			 
			// page.pause();
	     }
	}
	
	@Test
	public void test_text_selector_parentChild() {
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("https://demo.opencart.com/index.php?route=account/login");
			 page.type("//*[@id='input-email']", "apple");
			page.locator("form button:has-text('Login')").click(); 
			  
			page.pause();
	     }
	}
	
	@Test
	public void test_xpath_cssSelector() {
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("http://demo.automationtesting.in/Register.html");
			 //1. xpath
			 page.type("//input[@placeholder='First Name']", "Ram");
			 //2. cssSelector
			 page.type("input[placeholder='Last Name']", "Lee");
			// page.pause();
	     }
	}
	

	
}
