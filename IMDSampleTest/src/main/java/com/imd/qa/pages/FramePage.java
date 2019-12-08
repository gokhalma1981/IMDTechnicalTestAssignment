package com.imd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imd.qa.base.TestBase;

public class FramePage extends TestBase{
	
	//Page Factory or OR:
	@FindBy(css="iframe[id=mce_0_ifr]") //css=tag[attribute=value]
	WebElement frameElement;
		
	@FindBy(css="body[id=tinymce]")
	WebElement textBox;
	
	
	//Initializing the Page Objects:
	public FramePage(){
		PageFactory.initElements(driver, this);		
	}
	
	
	//Actions:
	public String validateiFrameEnteredText(String textbox_input) throws InterruptedException{
		driver.switchTo().frame(frameElement);
		//driver.switchTo().frame("mce_0_ifr");
		//driver.switchTo().frame(0);
		textBox.clear();
		textBox.sendKeys(textbox_input);
		Thread.sleep(1000);
		return textBox.getText();
	}

}
