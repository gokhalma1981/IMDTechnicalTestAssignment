package com.imd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.imd.qa.base.TestBase;
import com.imd.qa.pages.JavaScriptAlertsPage;
import com.imd.qa.util.TestUtil;

public class JavaScriptAlertsPageTest extends TestBase{
	
	JavaScriptAlertsPage javaScriptAlertsPage;
	String sheetName = "JavaScriptAlertsPage";
	
	public JavaScriptAlertsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization(prop.getProperty("url_jsalert"));
		javaScriptAlertsPage = new JavaScriptAlertsPage();		
	}
	
	@Test(priority=1)
	public void validateJSConfirmOkButtonClickTest() throws InterruptedException{
		String resultTextMessage = javaScriptAlertsPage.validateJSConfirmOkButtonClick();
		Assert.assertTrue(resultTextMessage.contains("You clicked: Ok"), "Result Text Message Validation - FAILED");
		Thread.sleep(5000);
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getTestData")
	public void validateJSPromptCancelButtonClickTest(String js_prompt_text) throws InterruptedException{
		String resultTextMessage = javaScriptAlertsPage.validateJSPromptCancelButtonClick(js_prompt_text);
		Assert.assertTrue(resultTextMessage.contains("You entered: null"), "Result Text Message Validation - FAILED");
		Thread.sleep(2000);
	}	
	
	@Test(priority=3, dataProvider="getTestData")
	public void validateJSPromptOkButtonClickTest(String js_prompt_text) throws InterruptedException{
		String resultTextMessage = javaScriptAlertsPage.validateJSPromptOkButtonClick(js_prompt_text);		
		Assert.assertTrue(resultTextMessage.contains("You entered: Test JS Prompt"), "Result Text Message Validation - FAILED");
		Thread.sleep(2000);
	}	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	
	

}
