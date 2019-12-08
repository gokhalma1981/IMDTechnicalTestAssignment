package com.imd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imd.qa.base.TestBase;
import com.imd.qa.pages.LoginPage;
import com.imd.qa.pages.SecureAreaPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization(prop.getProperty("url_login"));
		loginPage = new LoginPage();		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "The Internet", "Login Page Title Validation - FAILED");
	}
	
	@Test(priority=2)
	public void loginFailureMessageTest(){
		String loginFailureMessage = loginPage.validateLoginFailureMessage();
		Assert.assertTrue(loginFailureMessage.contains("Your username is invalid!"), "Login Failure Message Validation - FAILED");
	}
	
	@Test(priority=3)
	public void loginSuccessMessageTest(){
		secureAreaPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String loginSuccessMsg = secureAreaPage.validateLoginSuccessMessage();
		Assert.assertTrue(loginSuccessMsg.contains("You logged into a secure area!"), "Login Success Message Validation - FAILED");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
