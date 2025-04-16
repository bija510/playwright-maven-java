package com.example;

import org.testng.annotations.Test;

import com.project.base.BaseTest;

/*******************************************************************************************
 * browserContext.newPage() is More like a light weight version of browser in Incognito mode
 ********************************************************************************************/
public class Test_06_CheckBox_RadioBtn extends BaseTest{

	@Test
	public void test_checkBox() throws InterruptedException {		
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
