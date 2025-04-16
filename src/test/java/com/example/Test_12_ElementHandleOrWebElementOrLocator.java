package com.example;

import java.util.List;

import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_12_ElementHandleOrWebElementOrLocator {
/***************************************************
 * WebElement = ElementHandle = Locator
 * driver.findElements() == page.querySelectorAll()
 * List<WebElement> == List<ElementHandle>
 ***************************************************/
	Page page;
	BrowserContext browserContext;

	@BeforeMethod
	public void setUp() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate("https://courses.letskodeit.com/practice");
	}

	@Test
	public void test_Locator_or_webElement() throws InterruptedException { 
		Locator openTab = page.locator("text = Open Tab");
		openTab.click();		
	}
	
	@Test
	public void test_Locator_or_webElement_2() throws InterruptedException { //table[@id='product']
		Locator checkBox = page.locator("//input[@type='checkbox']");		
		int checkBoxs = checkBox.count();
		System.out.println(checkBoxs);
		checkBox.first().click();	
		
	}
	
	@Test
	public void test_Locators_or_webElements() throws InterruptedException { 
		Locator tableCells = page.locator("//table[@id='product']//td");	
		List<String> cellsText = tableCells.allTextContents();
		
		//Way : 01
//		for (int i=0; i<tableCells.count() ; i++) {
//			String text = tableCells.nth(i).textContent();
//			System.out.println(text);
//		}
//		
//		//Way : 02
//		cellsText.forEach(ele -> System.out.println(ele));
		
		//Way : 03
		for(String e : cellsText) {
			System.out.println(e);
		}
		
			
	}
	
	@Test
	public void test_getTotalLinks_SizeAndName() throws InterruptedException {
		List<ElementHandle> eles = page.querySelectorAll("a");
		System.out.println("total num of links in page:- " + eles.size());
		
		for (ElementHandle ele : eles) {
			System.out.println(ele.innerText());
		}
	}

	@Test
	public void test_ElementHandle() {
		ElementHandle benzChk = page.querySelector("//input[@id='benzcheck']");
		benzChk.check();
	}

	@AfterMethod
	public void tearDown() {
//		page.pause();
		page.close();
		browserContext.close();
	}
}
