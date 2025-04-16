package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.base.BaseTest;

public class Test_08_Asserts extends BaseTest{
/**********************************************
 * All assertion same in selenium & playwright 
 * since they use same framework TestNG
 **********************************************/
	@Test()
	public void test_waits() throws InterruptedException {
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");

		// Example:- 1
		Assert.assertFalse(page.isChecked("//input[@id='checkBoxOption1']"));

		// Example:- 2
		Assert.assertTrue(page.isVisible("//input[@id='displayed-text']"));

		// Example:- 3
		String actTitle = "Practice Page";
		Assert.assertEquals(actTitle, page.title());

		// Example:- 4
		String aFor = "apple";
		String bFor = "ball";
		Assert.assertNotEquals(aFor, bFor);
		
		// Example:- 5
		String aa = null;
		//Assert.assertNull("aa", "Assert Null Example");
		Assert.assertNull(aa, "Assert Null Example");

		// Example:- 6
		Assert.assertSame(aFor, aFor);
		
		// Example:- 7
       // Assert.fail();
		Assert.fail("==========Not found or any message this will fail testcase============");

		System.out.println("All Example 1, 2, 3 & 4 Passes Successfully");
	}
}
