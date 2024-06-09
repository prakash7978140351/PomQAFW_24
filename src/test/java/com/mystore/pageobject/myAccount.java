package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {

	// create webDriver object
	WebDriver driver;

	// create constructor
	public myAccount(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// identify the webElements

	@FindBy(id = "email_create")

	WebElement createEmailId;

	@FindBy(id = "SubmitCreate")

	WebElement submitCreate;
	
	
	
	//identify webelement for for registered Users login 
	
	@FindBy(id="email")
	WebElement registerUserEmailid;
	@FindBy(id="passwd")
	WebElement registerUserPassword;
	@FindBy(id="SubmitLogin")
	WebElement registerUserLogin;
	
	
	public void enterCreateEmailAddress(String emailAddress) {
		createEmailId.sendKeys(emailAddress);
	}

	
	public void clickSubmitCreate() {
		submitCreate.click();
	}
	
	public void enterRegisterUseremail(String regUseremail) {
		registerUserEmailid.clear();
		registerUserEmailid.sendKeys(regUseremail);
	}
	
	public void enterRegisterUserpassword(String regUserpassword) {
		registerUserPassword.clear();
		registerUserPassword.sendKeys(regUserpassword);
	}
	
	public void clickOnRegUserSubmit() {
		registerUserLogin.click();
	}
	
}
