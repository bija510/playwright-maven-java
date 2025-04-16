package com.example;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.annotations.Test;
import com.microsoft.playwright.ElementHandle;
import com.project.base.BaseTest;

public class Test_13_Calendar_Datepicker extends BaseTest{

	// Current Date
	Format f = new SimpleDateFormat("MM/dd/yyyy");
	String currentDate = f.format(new Date());

	@Test
	public void test_selectCurrentDate() throws InterruptedException {
		page.navigate("http://demo.automationtesting.in/Datepicker.html"); // strDate.substring(3, 5)
		page.click("//input[@id='datepicker2']");
		
		List<ElementHandle> days = page.querySelectorAll("td");
		for (int i = 0; i < days.size(); i++) {
			if (days.get(i).innerText().equalsIgnoreCase(currentDate.substring(3, 5))) {
				System.out.println(days.get(i).innerText());
				days.get(i).click();
				break;
			}
		}
		page.pause();
	}
}
