package playwrightJava;

import java.awt.AWTException;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utilites.RobotUtils;

public class Test_11_FileUploadRobotClass {
/***********************************************************
 * Robot class can be used in selenium as well as playwright 
 * since it is pure Java so it's all good
 **********************************************************/
	@Test()
	public void test_fileUpload() throws InterruptedException, AWTException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://pdf2jpg.net/");
		
		String uploadFilePath = System.getProperty("user.dir")+"\\Data\\Upload file.pdf";
		page.click("#advanced_pdf_file");
		
		RobotUtils.fileUpload(uploadFilePath);
		
		page.pause();
	}
}
