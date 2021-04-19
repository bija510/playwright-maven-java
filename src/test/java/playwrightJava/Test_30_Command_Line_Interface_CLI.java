package playwrightJava;

import org.testng.annotations.Test;

import base.BaseTest;

public class Test_30_Command_Line_Interface_CLI extends BaseTest {

	/*****************************************************************************************************************************
	 This is how we can open any URL & then we can record the test case & convert
	 into 3 different language ["java", "javascript", "python"] using Playwright inspector 
	 1. https://playwright.dev/java/docs/cli 
	 2. Go to project path & CMD there & ==> mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI 
	 3. To open Page from CLI in chromium by default==> mvn exec:java -e-Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="open example.com"
	 4. # Open page in WebKit
		$ mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="wk example.com"
	 5. # Emulate iPhone 11.
		$ mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args='open --device="iPhone 11" wikipedia.org'
	 6. # Emulate timezone, language & location
		# Once page opens, click the "my location" button to see geolocation in action
		$ mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args='open --timezone="Europe/Rome" --geolocation="41.890221,12.492348" --lang="it-IT" maps.google.com'
	 7. # Capture a full page screenshot
		$ mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args='screenshot --full-page en.wikipedia.org wiki-full.png'
	 8. #PDF generation only works in Headless Chromium.
		$ mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="pdf https://en.wikipedia.org/wiki/PDF wiki.pdf"
	 9.
	 ******************************************************************************************************************************/
	@Test
	public void test_record_script_using_playwright_inspector() {
		page.navigate("https://learn.letskodeit.com/p/practice");

		page.click("text=Benz >> input[name=\"cars\"]");
		page.selectOption("select[name=\"cars\"]", "honda");
		page.click("select[name=\"multiple-select-example\"]");
		page.click("select[name=\"multiple-select-example\"]");
		page.check("#benzcheck");
		page.click("[placeholder=\"Enter Your Name\"]");
		page.fill("[placeholder='Enter Your Name']", "david");

		page.onceDialog(dialog -> {
			System.out.println(String.format("Dialog message: %s", dialog.message()));
			dialog.dismiss();
		});
		page.click("input:has-text('Alert')");

	}
}
