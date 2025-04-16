package com.example;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_36_Automatic_Login_With_Authentication {

	
	@Test
	public void test_save_authentication_in_JSONFile() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();			
		Page page = browserContext.newPage();
		 
		page.navigate("https://opensource-demo.orangehrmlive.com/");	      
		page.locator("#divUsername >> text=Username").click();	     
		page.locator("input[name=\"txtUsername\"]").fill("Admin");     
		page.locator("input[name=\"txtPassword\"]").click();     
		page.locator("input[name=\"txtPassword\"]").fill("admin123");  
		page.locator("input:has-text(\"LOGIN\")").click();	 

		
		browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
	}
	
	@Test
	public void autoLogin() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));		
		Page page = browserContext.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");	   
		page.pause();
	}
}
