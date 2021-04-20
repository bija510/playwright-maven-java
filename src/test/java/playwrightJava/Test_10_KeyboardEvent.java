package playwrightJava;

import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.*;

public class Test_10_KeyboardEvent {
	/******************************************************************************************************
	 * https://playwright.dev/java/docs/api/class-keyboard
	 * For more ouse hover in press function F1 - F12, Digit0- Digit9, KeyA- KeyZ,
	 * Backquote, Minus, Equal, Backslash, Backspace, Tab, Delete, Escape,
	 * ArrowDown, End, Enter, Home, Insert, PageDown, PageUp, ArrowRight, ArrowUp,
	 * etc.
	 ******************************************************************************************************/

	Page page;

	@BeforeMethod
	public void setUp() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		page = browserContext.newPage();
	}

	@Test()
	public void test_keyboard_Enter() throws InterruptedException {
		page.navigate("https://letskodeit.teachable.com/pages/practice");
		ElementHandle openNewTabBtn = page.querySelector("//a[normalize-space()='Open Tab']");
		openNewTabBtn.press("Enter");
	}

	@Test
	public void test_arrowAndMore() throws InterruptedException {
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		ElementHandle countryDynamixTxt = page.querySelector("//input[@id='autocomplete']");
		countryDynamixTxt.fill("ind");
		Thread.sleep(2000);
		countryDynamixTxt.press("ArrowDown");
		countryDynamixTxt.press("ArrowDown");
		countryDynamixTxt.press("Enter");

		Thread.sleep(2000);
		countryDynamixTxt.fill("ind");
		countryDynamixTxt.press("Control+a");
		Thread.sleep(2000);
		countryDynamixTxt.press("Backspace");
	}

	@Test
	public void test_pageDown() throws InterruptedException {
		page.navigate("https://letskodeit.teachable.com/pages/practice");
		ElementHandle registerLabel = page.querySelector("//h1[normalize-space()='Practice Page']");
		registerLabel.press("PageDown");
		Thread.sleep(2000);
		registerLabel.press("PageDown");
	}
	
	

	@AfterMethod
	public void teraDown() {
		//page.pause();
	}
}
