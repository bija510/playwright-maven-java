package playwrightJava;

import java.util.List;

import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_12_ElementHandleOrWebElement {
/***************************************************
 * WebElement = ElementHandle
 * driver.findElements() == page.querySelectorAll()
 * List<WebElement> == List<ElementHandle>
 ***************************************************/
	Page page;

	@BeforeMethod
	public void setUp() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate("https://letskodeit.teachable.com/pages/practice");
	}

	@Test
	public void test_getTotalLinks_SizeAndName() throws InterruptedException {
		List<ElementHandle> eles = page.querySelectorAll("a");
		System.out.println("total num of links in page:- " + eles.size());
		
		for (ElementHandle ele : eles) {
			System.out.println(ele.innerText());
		}
	}

	@Test
	public void test_ElementHandle() {
		ElementHandle benzChk = page.querySelector("//input[@id='benzcheck']");
		benzChk.check();
	}

	@AfterMethod
	public void tearDown() {
		//page.pause();
	}
}
