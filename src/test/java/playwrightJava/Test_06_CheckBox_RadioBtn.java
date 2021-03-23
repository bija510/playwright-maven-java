package playwrightJava;

import org.testng.annotations.Test;
import com.microsoft.playwright.*;

/*******************************************************************************************
 * browserContext.newPage() is More like a light weight version of browser in Incognito mode
 ********************************************************************************************/
public class Test_06_CheckBox_RadioBtn {

	@Test
	public void test_checkBox() throws InterruptedException {		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("http://demo.automationtesting.in/Register.html");
		
		//Check and un check checkBox
		System.out.println("Should be false:- "+ page.isChecked("//input[@id='checkbox2']"));
		page.check("//input[@id='checkbox2']");
		
		Thread.sleep(2000);
		page.uncheck("//input[@id='checkbox2']");
		
		//select male radioBtn
		page.check("//input[@value='Male']");
	}
}
