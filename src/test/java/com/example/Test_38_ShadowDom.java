package com.example;

import org.testng.annotations.Test;

import com.project.base.BaseTest;

public class Test_38_ShadowDom extends BaseTest {

	/************************************************************
	  1. We can only automate where Shadow Dom root is OPEN
	  2. We cannot automate where Shadow Dom root is CLOSE
	  3. Page --> DOM --> SHadow Dom -->Elements
	  4. Page --> DOM -->iFrame --> SHadow Dom -->Elements	
	 *************************************************************/
	@Test
	public void test_shadowDome() {
		//parent path & the #input is we got it from R-click inspect 
		page.navigate("https://books-pwakit.appspot.com/");
		page.locator("book-app[apptitle='BOOKS'] #input").fill("Shadow dom Testing");
		
		String message = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
		System.out.println(message);		

	}
	
	@Test
	public void test_shadowDome_inside_iFrame() {
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("masala Tea");;	

	}

}
