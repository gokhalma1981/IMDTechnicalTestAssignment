package com.imd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.imd.qa.base.TestBase;
import com.imd.qa.pages.FramePage;
import com.imd.qa.util.TestUtil;

public class FramePageTest extends TestBase{
	
	FramePage framePage;
	String sheetName = "FramePage";
	
	public FramePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization(prop.getProperty("url_iframe"));
		framePage = new FramePage();		
	}	
	
	@DataProvider
	public Object[][] getTestData(){
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getTestData")
	public void validateiFrameEnteredTextTest(String textbox_input) throws InterruptedException{
		String iframeEnteredText = framePage.validateiFrameEnteredText(textbox_input);
		//System.out.println(iframeEnteredText);
		Assert.assertTrue(iframeEnteredText.contains("I love pizza"), "iFrame Entered Text Validation - FAILED");
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
