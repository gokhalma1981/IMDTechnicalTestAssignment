package com.imd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imd.qa.base.TestBase;
import com.imd.qa.pages.LoginPage;
import com.imd.qa.pages.SecureAreaPage;

public class SecureAreaPageTest extends TestBase{
	
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	
	public SecureAreaPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization(prop.getProperty("url_login"));
		loginPage = new LoginPage();
		secureAreaPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	@Test(priority=1)
	public void secureAreaPageTitleTest(){
		String secureAreaPageTitle = secureAreaPage.validateSecureAreaPageTitle();
		Assert.assertEquals(secureAreaPageTitle, "The Internet", "Secure Area Page Title Validation - FAILED");
	}
	
	@Test(priority=2)
	public void loginSuccessMessageTest(){
		String loginSuccessMsg = secureAreaPage.validateLoginSuccessMessage();
		Assert.assertTrue(loginSuccessMsg.contains("You logged into a secure area!"), "Login Success Message Validation - FAILED");
	}	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
		

}
