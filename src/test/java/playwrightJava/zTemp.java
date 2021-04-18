package playwrightJava;

import org.testng.annotations.Test;
import com.microsoft.playwright.options.BrowserChannel;

import base.BaseTest;

import com.microsoft.playwright.*;

public class zTemp extends BaseTest{
	
	@Test
  public void testing() throws InterruptedException {
		
		page.navigate("https://github.com/login");
		
	}
}