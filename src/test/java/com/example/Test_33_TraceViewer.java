package com.example;

import java.nio.file.Paths;
import org.testng.annotations.Test;
import com.microsoft.playwright.*;


public class Test_33_TraceViewer {
/****************************************************
 Description: Capture page action Screenshots, Network Calls & details
 1. trace.zip file will downloaded in Project Dir & open in 
   https://trace.playwright.dev./
 2. Or we Can CMD in the Project Dir & Run this command
 	mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="show-trace trace.zip"
 *****************************************************/
	@Test
	public void test_traceViewer() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		
		//Start tracing before creating / navigating a page
		browserContext.tracing().start(new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true));
		
		Page page = browserContext.newPage();
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");

		ElementHandle option1TxtBx = page.querySelector("//input[@id='checkBoxOption1']");
		option1TxtBx.click();
		
		ElementHandle showHideTxtBx = page.querySelector("//input[@id='displayed-text']");
		showHideTxtBx.click();
		
		//Stop tracing and export it into a zip archive
		browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		
	}
	
}
