package playwrightJava;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class Test_05_Dropdown {

	@Test
	public void test_staticDropdown() throws InterruptedException {
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
			
			 page.selectOption("//select[@id='dropdown-class-example']", "option2"); //By value
			 Thread.sleep(2000);
			 page.selectOption("//select[@id='dropdown-class-example']", new SelectOption().setLabel("Option3")); //By label
			 			
			 page.pause();
	     }
	}
	
	@Test
	public void test_dynamicDropdown() throws InterruptedException {
		//https://applitools.com/blog/playwright-java/
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			 Page page = browser.newPage();		
			 page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
			 page.type("//input[@id='autocomplete']", "ind");
			 Thread.sleep(2000);
			 List<String> eles = page.querySelectorAll("//*[@id='ui-id-1']/li")
             .stream()
             .map(e -> e.innerText())
             .collect(Collectors.toList());
			 
			 System.out.println(eles.get(2));
			 
			 int sizeEle = page.querySelectorAll("//*[@id='ui-id-1']/li").size();
			
			 for(int i=0; i<=sizeEle; i++) {
			 if (eles.get(i).equalsIgnoreCase("India")) {
				 page.click("(//*[@id='ui-id-1']/li)["+i +"]");
					break;
				}		
	          }
			 page.pause();
	  }
   }
}
