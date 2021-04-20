package playwrightJava;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import com.microsoft.playwright.*;

public class Test_31_IsVisible_IsChecked_IsEnabled extends BaseTest{
	
	@Test
	public void SelAndDesMethod() {
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");

		//Example:- 1
		ElementHandle option1TxtBx = page.querySelector("//input[@id='checkBoxOption1']");
		System.out.println(option1TxtBx.isChecked());
		Assert.assertFalse(option1TxtBx.isChecked());

		//Example:- 2
		ElementHandle showHideTxtBx = page.querySelector("//input[@id='displayed-text']");
		System.out.println(showHideTxtBx.isVisible());
		Assert.assertTrue(showHideTxtBx.isVisible());
		
		//Example:- 3
		page.evaluate("window.scrollTo(0, 200)");
		ElementHandle hideBtn = page.querySelector("[id='hide-textbox']");
		hideBtn.click();
		System.out.println(showHideTxtBx.isVisible());
		Assert.assertTrue(showHideTxtBx.isVisible());
		
	}
	
	@Test
	public void isEnabled() {
		page.navigate("http://www.testdiary.com/training/selenium/selenium-test-page/");
		ElementHandle saveBtn = page.querySelector("//button[@id='demo']");
		System.out.println("is Btn Enabled?:- " + saveBtn.isEnabled());
	}
}