package com.imd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imd.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or OR:
	@FindBy(css="input[name=username]") //css=tag[attribute=value]
	WebElement username;
	
	@FindBy(css="input[name=password]")
	WebElement password;
	
	@FindBy(css="button[type=submit]") 
	WebElement loginBtn;
	
	@FindBy(css="div[id=flash]")
	WebElement loginFailureMsg;
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);		
	}
	
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();		
	}
		
	public String validateLoginFailureMessage(){
		loginBtn.click();
		return loginFailureMsg.getText();
	}
	
	public SecureAreaPage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();		
		return new SecureAreaPage();
	}
		
	
}
