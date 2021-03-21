package playwright;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;

public class Test_03_reloadForwardBack{
	
	@Test
	public void test_demo() throws InterruptedException {
		try (Playwright playwright = Playwright.create()){
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)); 
			Page page = browser.newPage();
			page.navigate("https://www.facebook.com/");
			
			page.click("//*[@id='pageFooterChildren']/ul/li[1]/a");
						
			page.goBack();
			
			page.goForward();
			
			page.reload();
			Thread.sleep(3000);
	  }
	}
}
