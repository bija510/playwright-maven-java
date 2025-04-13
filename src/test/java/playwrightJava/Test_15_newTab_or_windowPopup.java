package playwrightJava;

import org.testng.annotations.Test;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import base.BaseTest;

public class Test_15_newTab_or_windowPopup extends BaseTest{

	@Test
	public void test_handle_popUpWindow_afterClicking_on_link() throws InterruptedException {
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		
		Page popup = page.waitForPopup( ()-> {
			page.click("//img[@alt='OrangeHRM on twitter']");
		});
		
		System.out.println("pop up child window title : " +popup.url());
		popup.close();		
		System.out.println("parent page title : "+page.title());			
	}
	
	@Test
	public void test_open_newBlankTab_and_lunchNewURL() throws InterruptedException {
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		
		Page popup = page.waitForPopup( ()-> {
			//responsible for opening blank window tab or window popup
			page.click("a[target='_blank']"); //responsible for opening blank window
		});
		popup.waitForLoadState();
		
		popup.navigate("https://www.amazon.com");
		
		System.out.println("pop up child window title : " +popup.title());
		popup.close();	
		System.out.println("parent page title : "+page.title());
		page.close();
					
	}
	
	
	
	@Test
	public void test_newTab_using_GetHrefAttribute_AndOpen() throws InterruptedException {
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		String tabLink = page.getAttribute("//a[normalize-space()='Open Tab']", "href");
		
		Thread.sleep(2000);
		page.navigate(tabLink);
		ElementHandle homeTabNameText = page.querySelector("//div[@class='nav-outer clearfix']//a[normalize-space()='Home']");
		System.out.println(homeTabNameText.innerText());
		
		Thread.sleep(2000);
		page.goBack();
		
	}
	
	@Test
	public void switchTonewTab() throws InterruptedException {
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		page.click("//a[normalize-space()='Open Tab']");
		
		ElementHandle homeTabNameText = page.querySelector("//div[@class='nav-outer clearfix']//a[normalize-space()='Home']");
		System.out.println(homeTabNameText.innerText());
		
		Thread.sleep(2000);
		page.goBack();
		
	}
	
	@Test
	public void test_byRemoving_targetAttribute_and_click() throws InterruptedException { //WIP
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");	

		page.evaluate("document.querySelector('#opentab').click()");
	}
	
}
