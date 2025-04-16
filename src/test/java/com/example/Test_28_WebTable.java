package com.example;

import org.testng.annotations.Test;

import com.project.base.BaseTest;
import com.project.utils.WebTableUtils;

public class Test_28_WebTable extends BaseTest{

	@Test
	public void test_webTable() throws Exception {
		page.navigate("https://www.w3schools.com/html/html_tables.asp");
		page.evaluate("window.scrollTo(0, 300)");
		
		System.out.println(new WebTableUtils(page).clickOrGetText("//table[@id='customers']", "Island Trading" ,"Country"));
		
	}
}
