package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	Page page;
	
	public LoginPage(Page page) {
		this.page = page;
	}

	private String userNameTxt_xpath = "//input[@name='username']";
	private String passwordtxt_xpath = "//input[@placeholder='Password']";
	private String loginBtn_xpath = "//button[@type='submit']";
	private String welcomeMsgLbl_xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
	
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
