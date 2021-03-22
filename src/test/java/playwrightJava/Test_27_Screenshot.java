package playwrightJava;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_27_Screenshot {

	@Test
	public void test_screenshot() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("http://whatsmyuseragent.org/");
		
		String path = System.getProperty("user.dir") + "\\Screenshot\\example.png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
	}

}
