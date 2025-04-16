package com.example;

import java.awt.AWTException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;
import com.project.utils.RobotUtils;

public class Test_11_File_Create_Upload_Remove {
/***********************************************************
 * Robot class can be used in selenium as well as playwright 
 * since it is pure Java so it's all good
 **********************************************************/
	Page page;
	BrowserContext browserContext;
	
	@BeforeClass
	public void setUp() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		browserContext = browser.newContext();
		page = browserContext.newPage();
	}
	
	@Test()
	public void test_fileUpload_using_robotclass() throws InterruptedException, AWTException {	
		page.navigate("https://pdf2jpg.net/");
		String uploadFilePath = System.getProperty("user.dir")+"\\Data\\Upload file.pdf";
		page.click("#advanced_pdf_file");	
		RobotUtils.fileUpload(uploadFilePath);
		
		page.pause();
	}
	
	
	@Test(description = "For this to work TagName should be <input & type='file' ")
	public void test_fileUpload_using_playwright() throws InterruptedException {
		page.navigate("https://the-internet.herokuapp.com/upload");
		// Select one file
		String uploadFilePath = System.getProperty("user.dir")+"\\Data\\Upload file.pdf";
		page.setInputFiles("//input[@id='file-upload']", Paths.get(uploadFilePath));
		
		Thread.sleep(4000);
		
		//Removing the upload file
		page.setInputFiles("//input[@id='file-upload']", new Path[0] );
			
	}
	
	@Test()
	public void test_creatingFile_and_upload_using_playwright() throws InterruptedException {
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		page.setInputFiles("input[name='upfile']", new FilePayload(
				"Victor.txt",
				"text/plain",
				"This is victor demo foe file upload".getBytes(StandardCharsets.UTF_8)));
		
		Thread.sleep(3000);
		page.click("input[value='Press']");
		
		Thread.sleep(4000);
		
	}
	
	@Test()
	public void test_multiple_fileUpload_using_playwright() throws InterruptedException {
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		// Select one file
		String uploadFilePath1 = System.getProperty("user.dir")+"\\Data\\Upload file.pdf";

		// Select multiple files using new path ARRAY
		page.setInputFiles("input#filesToUpload", new Path[] {
				Paths.get(uploadFilePath1), 
				Paths.get(uploadFilePath1),
				Paths.get(uploadFilePath1)
				});
		Thread.sleep(4000);
		
		//Removing all the files
		page.setInputFiles("input#filesToUpload", new Path[0] );
	}
	
	
	
	@AfterClass
	public void tearDown() {
		page.pause();
		
		browserContext.close();
		page.close();
	}
}
