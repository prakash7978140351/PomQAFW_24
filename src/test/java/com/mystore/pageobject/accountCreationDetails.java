package com.mystore.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {

	WebDriver driver;

	public accountCreationDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// identify webElements
	@FindBy(id = "id_gender1")
	WebElement titleMr;

	@FindBy(id = "id_gender2")
	WebElement titleMrs;

	@FindBy(id = "customer_firstname")
	WebElement custfirstName;
	@FindBy(id = "customer_lastname")
	WebElement custlastName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "days")
	WebElement dob_days;

	@FindBy(id = "months")
	WebElement dob_months;

	@FindBy(id = "years")
	WebElement dob_years;
	
	@FindBy(id="submitAccount")
	WebElement register;

	// identidy the action for the webelements

	public void selectTitleMr() {
		titleMr.click();
	}

	public void selectTitleMrs() {
		titleMrs.click();
	}

	public void enterFisrtName(String firstname) {
		custfirstName.clear();
		custfirstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		custlastName.clear();
		custlastName.sendKeys(lastname);
	}

	public void enterPassword(String password) {
		passwd.sendKeys(password);
	}

	// select dob
	public void selectDobDate(String date) {

		Select dobdate = new Select(dob_days);
		List<WebElement> Alldates = dobdate.getOptions();
		for(WebElement dates:Alldates) {
			String datetext = dates.getText();
			System.out.println("dates are   "+datetext);
		}
		
		dobdate.selectByValue(date);
	}

	public void selectDobMonth(String month) {

		Select dobmonth = new Select(dob_months);
		dobmonth.selectByValue(month);
	}

	public void selectDobYear(String year) {

		Select dobyear = new Select(dob_years);
		dobyear.selectByValue(year);
	}
	public void clickOnRegister() {
		
		register.click();
	}

}
