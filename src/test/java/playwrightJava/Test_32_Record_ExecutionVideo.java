package playwrightJava;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.options.BrowserChannel;
import com.microsoft.playwright.options.SelectOption;

import base.BaseTest;

import com.microsoft.playwright.*;

public class Test_32_Record_ExecutionVideo{
	
	/**
	 * https://playwright.dev/java/docs/videos
	 * @throws InterruptedException
	 */
	@Test
	public void test_record_video_default_size() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		Page page = context.newPage();
		
		page.navigate("http://demo.automationtesting.in/Loader.html");
		Thread.sleep(1000);
		page.click("//button[normalize-space()='Run']");
		// this element take 15-20 sec to be displayed	
		page.click("//button[normalize-space()='Close']");
		
		context.close();// Make sure to close, so that videos are saved
		Path path = page.video().path();
		System.out.println("Video is storer in this path:- " + path);
		
	}
	
	@Test
	public void test_record_video_custom_size() throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")).setRecordVideoSize(1024, 768));
		Page page = context.newPage();
		
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		page.selectOption("//select[@id='dropdown-class-example']", "option2"); //By value
		Thread.sleep(2000);
		page.selectOption("//select[@id='dropdown-class-example']", new SelectOption().setLabel("Option3")); 
		
		context.close();// Make sure to close, so that videos are saved
		Path path = page.video().path();
		System.out.println("Video is storer in this path:- " + path);
		
	}
	
}