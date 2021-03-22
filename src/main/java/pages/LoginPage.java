package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	Page page;
	
	public LoginPage(Page page) {
		this.page = page;
	}

	private String userNameTxt_xpath = "//input[@id='txtUsername']";
	private String passwordtxt_xpath = "//input[@id='txtPassword']";
	private String loginBtn_xpath = "//input[@id='btnLogin']";
	private String welcomeMsgLbl_xpath = "//*[@id='welcome']";
	
	public void enterUserName(String userName) {
		page.fill(userNameTxt_xpath, userName);
		
	}

	public void enterPassword(String password) {
		page.fill(passwordtxt_xpath, password);
		
	}

	public void clickLoginBtn() {
		page.click(loginBtn_xpath);
		
	}
	
	public String getWelcomeMessage() {
		return page.innerText(welcomeMsgLbl_xpath);
	}

}
