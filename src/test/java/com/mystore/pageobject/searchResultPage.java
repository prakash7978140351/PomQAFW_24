package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchResultPage {
WebDriver driver;

public searchResultPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements( driver,this);
}

//identify the web elements

@FindBy(xpath = "(//a[@title=\"Faded Short Sleeve T-shirts\"])[2]")
WebElement searchedTshirt;

public String getSearchResultPrdoductName() {
	return searchedTshirt.getText();
	
}


}
