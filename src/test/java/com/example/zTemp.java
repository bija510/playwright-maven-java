package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.options.BrowserChannel;
import com.microsoft.playwright.options.SelectOption;
import com.project.base.BaseTest;
import com.project.utils.JsonUtils;
import com.microsoft.playwright.*;

public class zTemp {
	protected static Browser browser;
	protected static Playwright playwright;
	protected static Page page;

	protected static BrowserContext browserContext;
	
	@Test
	public void test_record_video_default_size() throws InterruptedException {
	
		playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = browserContext.newPage();
		               
		page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
		
		Thread.sleep(2000);
		page.click("//a[@id='opentab']");
		
	}
	

	
}