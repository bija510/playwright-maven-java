package playwrightJava;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;


public class Test_34_BrowserContext_Concept {
/****************************************************
  Description: 
 
 *****************************************************/
	@Test
	public void test_browserContext_Concept() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext1 = browser.newContext();			
		Page page1 = browserContext1.newPage();
		page1.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		ElementHandle option1TxtBx = page1.querySelector("//input[@id='checkBoxOption1']");
		option1TxtBx.click();
		System.out.println(page1.title());
	
		BrowserContext browserContext2 = browser.newContext();			
		Page page2 = browserContext2.newPage();
		page2.navigate("http://demo.automationtesting.in/Register.html");
		page2.querySelector("//input[@id='checkbox1']").check();
		System.out.println(page2.title());
		
		BrowserContext browserContext3 = browser.newContext();			
		Page page3 = browserContext3.newPage();
		page3.navigate("https://opensource-demo.orangehrmlive.com/");
		page3.querySelector("//input[@id='btnLogin']").click();
		System.out.println(page3.title());
		
		page1.close();
		browserContext1.close();
		
		page2.close();
		browserContext2.close();
		
		page3.close();
		browserContext3.close();
		
	}
	
}
