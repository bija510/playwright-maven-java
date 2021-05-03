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
	

	@Test
	public void test_text_buttonNameSelector() {
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("https://learn.letskodeit.com/p/practice");
			 
			 //1. Text selector has a few variations: 
			 //<button id="openwindow" class="btn-style class1" onclick="openWindow()" xpath="1">Open Window</button>
			 page.click("text=Open Window");
			 //page.pause();
	     }
	}
}
