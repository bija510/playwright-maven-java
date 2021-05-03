package playwrightJava;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.options.BrowserChannel;
import com.microsoft.playwright.options.SelectOption;

import base.BaseTest;

import com.microsoft.playwright.*;

public class zTemp extends BaseTest{
	
	/**
	 * https://playwright.dev/java/docs/videos
	 * @throws InterruptedException
	 */
	@Test
	public void test_record_video_default_size() throws InterruptedException {
	
		page.navigate("http://demo.automationtesting.in/Loader.html");
		page.mouse().move(0, 0);
		page.mouse().down();
		page.mouse().move(0, 100);
		page.mouse().move(100, 100);
		page.mouse().move(100, 0);
		page.mouse().move(0, 0);
		page.mouse().up();
		
	}
	

	
}