package com.imd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imd.qa.base.TestBase;

public class FileUploadPage extends TestBase {
	
	//Page Factory or OR:
	@FindBy(css="input[id=file-upload]") //css=tag[attribute=value]
	WebElement chooseFileBtn;
	
	@FindBy(css="input[id=file-submit]") //css=tag[attribute=value]
	WebElement uploadBtn;

	//@FindBy(css="h3:contains('File Uploaded')") //css=tag:contains('text')
	//WebElement fileUploadConfirmMessage;
	
	@FindBy(css="div[id=content]") //css=tag[attribute=value]
	WebElement fileUploadConfirmMessage;
	
	
	//Initializing the Page Objects:
	public FileUploadPage(){
		PageFactory.initElements(driver, this);		
	}
	
	
	//Actions:
	public String validateFileUploadConfirmMessage(String upload_file_path){
		chooseFileBtn.sendKeys(upload_file_path);
		uploadBtn.click();
		return fileUploadConfirmMessage.getText();		
	}	
	
	

}
