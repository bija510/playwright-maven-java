package playwrightJava;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.microsoft.playwright.ElementHandle;

import base.BaseTest;

public class Test_15_newTab extends BaseTest{

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
	public void test_byRemoving_targetAttribute_and_click() throws InterruptedException { //WIP
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");	

		page.evaluate("document.querySelector('#opentab').click()");

	}
	
}
