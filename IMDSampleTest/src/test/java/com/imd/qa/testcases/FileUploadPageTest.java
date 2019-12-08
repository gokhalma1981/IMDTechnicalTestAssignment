package com.imd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.imd.qa.base.TestBase;
import com.imd.qa.pages.FileUploadPage;
import com.imd.qa.util.TestUtil;

public class FileUploadPageTest extends TestBase{
	
	FileUploadPage fileUploadPage;
	String sheetName = "FileUploadPage";
	
	public FileUploadPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization(prop.getProperty("url_fileupload"));
		fileUploadPage = new FileUploadPage();		
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getTestData")
	public void validateFileUploadConfirmMessageTest(String upload_file_path) throws InterruptedException{
		String fileUploadConfirmMessage = fileUploadPage.validateFileUploadConfirmMessage(upload_file_path);
		Thread.sleep(1000);				
		Assert.assertTrue(fileUploadConfirmMessage.contains("File Uploaded!"), "File Upload - Confirm Message Validation - FAILED");
		Assert.assertTrue(fileUploadConfirmMessage.contains("burrito.jpg"), "File Upload - Uploaded File Name Validation - FAILED");
	}	
		
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}		

}
