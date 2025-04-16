package com.example;

public class Test_35_Inspect_validateLocator {

	
	
	/************************************************ 
	 First open the Website from the console 
		 a. open CMD & cd project path = C:\Users\Bijaya Chhetri\eclipse-workspace\playwright-maven-java\src\test\java\playwrightJava
		 b. run this command = mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="open http://demo.automationtesting.in/Register.html"
		 c. it will open the chromium with this URL then
	 
	 1.	To find the element in the console
	    playwright.$("text=Register")
		<a href=​"Register.html">​Register​</a>​
		
	 2. To find the locator in the Elements section do this	
	    playwright.inspect("text=Register")
		undefined
		
	 3. To find the Multiple element or how many associated with this locator do this
	 	playwright.$$("text=Register")
		(2) [a, h2]
		0: a
		1: h2
		length: 2
		[[Prototype]]: Array(0)

	 ***************************************************/
	
	
	
	
	
	
	
	
	public void validate_locator() {
		
	}
}
