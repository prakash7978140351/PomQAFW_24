package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	
	WebDriver driver;
	
public RegisteredUserAccount(WebDriver driver) {
	
	this.driver=driver;
PageFactory.initElements(driver,this);	
	
}

//identify the WebElements

@FindBy(xpath = "//a[@title=\"View my customer account\"]")
WebElement regsitredUserName;

@FindBy(xpath = "(//a[contains(text(),\"Sign out\")])[1]")
WebElement signOut;

//search box
@FindBy(name="search_query")
WebElement searchBox;

@FindBy(name="submit_search")
WebElement searchButton;





public String getRegisteredUserName() {
	
	String text = regsitredUserName.getText();
	return text;
}

public void clickOnSignOut() {
	signOut.click();
}


//Enter data on search box

public void enterDataOnSearchBox(String searchText) {
	
	searchBox.clear();
	searchBox.sendKeys(searchText);
	
}

public void clickOnProductSearchButton() {
	searchButton.click();
}

}
