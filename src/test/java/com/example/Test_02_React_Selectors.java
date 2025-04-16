package com.example;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;

/*********************************************************************************************
 * We use React locator in such case where there is no --ID or Name-- and we don't want to use the,
 * Other common attributes.
 * React base component not change much.
 * More stable as compare to the HTML base locator
 *********************************************************************************************/
 
public class Test_02_React_Selectors {
	
	@Test
	public void test_react_locator() {
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("https://www.netflix.com/");
			 
			 Locator email = page.locator("_react=Anonymous[name='email'] >>input").first();
			 email.click();
			 email.fill("Fortesting@gmail.com");
			 
			 page.locator(" _react=UISelect[data-uia='language-picker']").click();
			
			 Locator footer = page.locator("_react=UIMarkup[data-uia='data-uia-footer-label']" );
			 
			 footer.allInnerTexts().forEach(ele -> System.out.println(ele));
			 page.pause();
	     }
	}
	
	
}
