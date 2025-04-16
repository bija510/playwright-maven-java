package com.example;

import org.testng.annotations.Test;

import com.project.base.BaseTest;

public class Test_18_WindowAuthentication extends BaseTest{

	@Test
	public void test001() throws InterruptedException {
		//This is good
		String userName = "admin";
		String password = "admin";
		page.navigate("http://" + userName + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
		
		//page.navigate("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		// This is without credential and it will fail 
		//page.navigate("http://the-internet.herokuapp.com//basic_auth"); 
		
	}
}
