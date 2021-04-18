package playwrightJava;

import java.awt.AWTException;
import java.nio.file.Paths;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utilites.RobotUtils;

public class Test_11_FileUpload_2_Diff_Ways {
/***********************************************************
 * Robot class can be used in selenium as well as playwright 
 * since it is pure Java so it's all good
 **********************************************************/
	Page page;
	
	@BeforeClass
	public void setUp() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		page = browserContext.newPage();
	}
	
	@Test()
	public void test_fileUpload_using_robotclass() throws InterruptedException, AWTException {	
		page.navigate("https://pdf2jpg.net/");
		String uploadFilePath = System.getProperty("user.dir")+"\\Data\\Upload file.pdf";
		page.click("#advanced_pdf_file");	
		RobotUtils.fileUpload(uploadFilePath);
		
		page.pause();
	}
	
	
	@Test(description = "For this to work TagName should be <input")
	public void test_fileUpload_using_playwright() throws InterruptedException {
		page.navigate("https://the-internet.herokuapp.com/upload");
		// Select one file
		String uploadFilePath = System.getProperty("user.dir")+"\\Data\\Upload file.pdf";
		page.setInputFiles("//input[@id='file-upload']", Paths.get(uploadFilePath));

		// Select multiple files
		//page.setInputFiles("input#upload", new Path[] {Paths.get("file1.txt"), Paths.get("file2.txt")});
		Thread.sleep(2000);
	}
}
