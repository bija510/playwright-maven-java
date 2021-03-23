package playwrightJava;

import org.testng.annotations.*;
import com.microsoft.playwright.*;

public class Test_09_MouseEvent {

	Page page;

	@BeforeMethod
	public void setUp() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
		BrowserContext browserContext = browser.newContext();
		page = browserContext.newPage();
	}

	@Test
	public void test_doubleClick() throws InterruptedException {
		page.navigate("http://demo.automationtesting.in/Register.html");
		ElementHandle skillsDD = page.querySelector("//select[@id='Skills']");
	/************************************************************************
	 Wait for actionability checks on the element, unless force option is set.
	 Scroll the element into view if needed.
	************************************************************************/
		skillsDD.click();
		Thread.sleep(2000);
		skillsDD.dblclick();	
	}
	
	@Test
	public void test_mouseHover() throws InterruptedException {
		page.navigate("https://www.amazon.com/");
		page.hover("//a[@id='nav-link-accountList']");
		Thread.sleep(2000);
	}
	
	@Test
	public void test_02() throws InterruptedException {
		page.navigate("https://www.amazon.com/");
		page.hover("//a[@id='nav-link-accountList']");
		Thread.sleep(2000);
		page.mouse().move(4.0, 5.0);
		Thread.sleep(2000);
		
	}
	
	
	@AfterMethod
	public void teraDown() {
		//page.pause();
	}
}
