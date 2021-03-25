package playwrightJava;

import java.util.Iterator;
import java.util.List;
import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import base.BaseTest;

public class Test_16_MultipleWIndow_WIP extends BaseTest{

	@Test
	public void switchWndow() throws InterruptedException {		
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		ElementHandle openWindowButton = page.querySelector("button[id='openwindow']");
		openWindowButton.click();
		BrowserContext context = browser.newContext();
		List<Page> allPages = context.pages();
		Iterator<Page> it = allPages.iterator(); // {  0 ,11112222z, 5555444888b }
		
		Page parentWindow = it.next(); //"11112222z"
		Page childWindow = it.next(); // "5555444888
		
	}
}
