package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utilites.JsonUtils;
import utilites.Utils;

public class BaseTest {
	protected static Browser browser;
	protected static Page page;
	protected static Properties prop;
	protected static JsonUtils data;
	
	@BeforeClass
	public static void setUp() throws IOException {
/*============================
 For data object for testCase
==============================*/		
		data = new JsonUtils("Data\\TestData.json");
/*==========================================================================
  Reading Key value from config.properties file inside Configuration Folder
============================================================================*/
		prop =new Properties();         
		FileInputStream fis = new FileInputStream("../PlaywrightJava_Automation/Configurations/Config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		String executionMode = prop.getProperty("ExecutionMode");

/*=======================================
  To see Browser Execution UserInterface
=========================================*/
		if(executionMode.equalsIgnoreCase("UI")) {
			if(browserName.equalsIgnoreCase("CHROMIUM")) {
				browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				page = browser.newPage();
			}	
			else if(browserName.equalsIgnoreCase("FIREFOX")) {
				browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
				page = browser.newPage();
			}
			else if(browserName.equalsIgnoreCase("WEBKIT")) {
				browser = Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
				page = browser.newPage();
			}
		}
		
/*==============================
 For Headless execution
================================*/
		if(executionMode.equalsIgnoreCase("HEADLESS")) {
			if(browserName.equalsIgnoreCase("CHROMIUM")) {
				browser = Playwright.create().chromium().launch();
				page = browser.newPage();
			}	
			else if(browserName.equalsIgnoreCase("FIREFOX")) {
				browser = Playwright.create().firefox().launch();
				page = browser.newPage();
			}
			else if(browserName.equalsIgnoreCase("WEBKIT")) {
				browser = Playwright.create().webkit().launch();
				page = browser.newPage();
			}
		}
		
		page.navigate(prop.getProperty("Url"));
			
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		String monthAndDate = Utils.getMonthAndDate();
		String digit6TimeStamp = Utils.get6DigitTimeStamp();
		String failScreenShotName = result.getMethod().getMethodName() + monthAndDate + "_Failed_" + digit6TimeStamp;
		
		if(ITestResult.FAILURE == result.getStatus()) {
			String path = System.getProperty("user.dir") + "\\Screenshot\\"+ failScreenShotName +".png";
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		}
	}
	
	@AfterClass
	public static void tearDownClass() {
		//page.pause();
		//page.close();	
	}	
}
