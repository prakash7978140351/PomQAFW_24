package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	// create a webdriver object
	WebDriver driver;
	
	public indexPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

	//identify WebElements
	@FindBy(xpath ="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	//identify actions on webElements
	
	public void clickOnSignIn() {
		signIn.click();
	}
	
}
