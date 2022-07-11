package playwrightJava;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import base.BaseTest;

public class Test_27_Screenshot extends BaseTest{

	@Test
	public void test_screenshot() {
		page.navigate("http://whatsmyuseragent.org/");
		
		String path = System.getProperty("user.dir") + "\\Screenshot\\example.png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
	}

}
