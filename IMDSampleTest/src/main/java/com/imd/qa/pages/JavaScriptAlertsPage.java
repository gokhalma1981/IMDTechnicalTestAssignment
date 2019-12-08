package com.imd.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imd.qa.base.TestBase;

public class JavaScriptAlertsPage extends TestBase{
	
	//Page Factory or OR:
	@FindBy(css="button[onclick*='jsConfirm']") //css=tag[attribute*='partial value']
	WebElement jsConfirmBtn;
	
	@FindBy(css="button[onclick*='jsPrompt']")
	WebElement jsPromptBtn;
	
	@FindBy(css="p[id=result]") //css=tag[attribute=value]
	WebElement resultText;
	
	//Initializing the Page Objects:
	public JavaScriptAlertsPage(){
		PageFactory.initElements(driver, this);		
	}
	
	
	//Actions:
	public String validateJSConfirmOkButtonClick() throws InterruptedException{
		jsConfirmBtn.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
		return resultText.getText();		
	}
	
	public String validateJSPromptCancelButtonClick(String js_prompt_text) throws InterruptedException{
		jsPromptBtn.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.sendKeys(js_prompt_text);
		Thread.sleep(1000);
		alert.dismiss();
		return resultText.getText();
	}

	public String validateJSPromptOkButtonClick(String js_prompt_text) throws InterruptedException{
		jsPromptBtn.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.sendKeys(js_prompt_text);
		Thread.sleep(3000);
		alert.accept();
		return resultText.getText();
	}
	
	
}
