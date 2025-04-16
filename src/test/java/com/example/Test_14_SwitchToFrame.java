package com.example;

import org.testng.annotations.Test;

import com.project.base.BaseTest;

public class Test_14_SwitchToFrame extends BaseTest{

	@Test
	public void test_switchToFrame_And_switchBackToDefaultFrame() throws InterruptedException {
		page.navigate("https://letskodeit.teachable.com/pages/practice");
		
		//Switch to frame by name
		page.evaluate("window.scrollTo(0,1200)");
		page.frame("iframe-name").fill("#search-courses", "python");
		
		//Switch back to default frame
		page.evaluate("window.scrollTo(0,-1200)");
		page.mainFrame().click("//input[@id='benzcheck']");
		
		//page.pause();	
	 }
}
