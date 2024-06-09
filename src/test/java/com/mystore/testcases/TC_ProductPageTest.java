package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.searchResultPage;

public class TC_ProductPageTest extends BaseClass {
	@Test
	public void verifySearchedProduct() {
		
		//setUp();
		driver.get(url);
		logger.info("user enter the URL");
		indexPage idx=new indexPage(driver);
		
		idx.clickOnSignIn();
		logger.info("user clicks on sign in ");
		
		myAccount mcp=new myAccount(driver);
		String email="test.prakash193@gmail.com";
		logger.info("user enters the email");
		String password="Test@1234";
		
		mcp.enterRegisterUseremail(email);
		mcp.enterRegisterUserpassword(password);
		logger.info("user enters the password ");
		mcp.clickOnRegUserSubmit();
		logger.info("user clicks on submit in ");
		
		RegisteredUserAccount ra=new RegisteredUserAccount(driver);
		ra.enterDataOnSearchBox("T-shirt");
		ra.clickOnProductSearchButton();
		
		
		searchResultPage srp= new searchResultPage(driver);
		
		String searchResultPrdoductName = srp.getSearchResultPrdoductName();
		System.out.println(searchResultPrdoductName);
		
		boolean contains = searchResultPrdoductName.contains("55T-shirt456");
		
		
		if (contains) {
			System.out.println("product contains T-shirt- Passed");
			Assert.assertTrue(true);
		}else
		{
			System.out.println("product NOT contains T-shirt- Failed");
			Assert.assertTrue(false);
		}
		
		ra.clickOnSignOut();
	}

}
