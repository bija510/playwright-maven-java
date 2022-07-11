package playwrightJava;

import org.testng.annotations.Test;
import base.BaseTest;

public class Test_19_Alert extends BaseTest {
	/********************************************************************************************************************
	 * By default, dialogs are auto-dismissed by Playwright, so you don't have to
	 * handle them. However, you can register a dialog handler before the action
	 * that triggers the dialog to accept or decline it.
	 *******************************************************************************************************************/
	@Test
	public void acceptAlert() throws InterruptedException {
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

		page.click("button[onclick='jsAlert()']");
		// playwright by default auto accept Alert
	}

	@Test
	public void acceptAlert_and_printing_alert_text() throws InterruptedException {
		page.navigate("https://courses.letskodeit.com/practice");

		page.fill("[placeholder='Enter Your Name']", "david");
		page.onceDialog(dialog -> {
			System.out.println(String.format("Dialog message: %s", dialog.message()));
			dialog.dismiss();
		});
		page.click("input:has-text('Alert')");

	}
}
