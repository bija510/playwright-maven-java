package com.example;

import org.testng.annotations.Test;

import com.project.base.BaseTest;

public class Test_26_JavaScriptAction extends BaseTest{

	@Test
	public void test_byRemoving_targetAttribute_and_click() throws InterruptedException {
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");	

		// 1. Javascript click()
		page.evaluate("document.querySelector('#checkBoxOption2').click()");

		// 2. Javascript type() or sendKeys()
		page.evaluate("document.querySelector('#autocomplete').value='ind';");
		
		// 3. Javascript getText()
		System.out.println(page.evaluate("document.querySelector('body h1').innerText;"));
		
		// 4. Scroll to Element
		page.evaluate("document.querySelector('tbody tr td:nth-child(2) ul:nth-child(1) li:nth-child(1) h3:nth-child(1) a:nth-child(1)').scrollIntoView();");
	
		// 4. ScrollDown by number
		Thread.sleep(2000);
		page.evaluate("window.scrollTo(0, -1700)");
		
		// 4. ScrollUp by number
		Thread.sleep(2000);
		page.evaluate("window.scrollTo(0, 1700)");
	}
	
	
	@Test
	public void test_getAttribute_ofValue() {
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		page.fill("input#autocomplete", "apple");
		System.out.println(page.evalOnSelector("input#autocomplete", "el => el.value"));

	}
	
	
}
