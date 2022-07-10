package playwrightJava;

import java.nio.file.Paths;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_37_Download_Move_Rename_File {

	public static void main(String [] args){
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		BrowserContext browserContext = browser.newContext();			
		Page page = browserContext.newPage();
		 
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=104.0.5112.29/");
		
		// This will click on the file to download & wait until the download process to end.
		Download download = page.waitForDownload( ()-> {
		page.click("//a[normalize-space()='chromedriver_win32.zip']");	
		});
		
		//It'll cancel the download
		//download.cancel();
		
		System.out.println("Download error if any = " +download.failure());
		
		System.out.println(download.url());
		
		String path = download.path().toString();
		System.out.println("File download path = " +path);
		
		//This is Renaming the file and copy from the temp dir to this Data path
		download.saveAs(Paths.get(System.getProperty("user.dir")+ "/Data/ChromeDriverFile.exe"));
		System.out.println("Suggested File name = " +download.suggestedFilename());
	}
	
}
