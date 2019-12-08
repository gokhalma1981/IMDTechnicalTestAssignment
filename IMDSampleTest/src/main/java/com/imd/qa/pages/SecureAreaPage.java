package com.imd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imd.qa.base.TestBase;

public class SecureAreaPage extends TestBase {
	
	//Page Factory or OR:
	@FindBy(css="div[id=flash]")
	WebElement loginSuccessMsg;
	
	
	//Initializing the Page Objects:
	public SecureAreaPage(){
		PageFactory.initElements(driver, this);		
	}
	
	
	//Actions:
	public String validateSecureAreaPageTitle(){
		return driver.getTitle();
	}
	
	public String validateLoginSuccessMessage(){
		return loginSuccessMsg.getText();		
	}
	
	
}
