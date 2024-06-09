package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;

public class TC_MyAccountPageTest extends BaseClass {
	
	
	@Test(enabled = false,priority = 0)
	public void verifyRegistrationAndLogin() {
		
		//launch browser
		driver.get(url);
		logger.info("url opened ");
		
		indexPage pg=new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on sign in buton ");
		myAccount pg1=new myAccount(driver);
		
		pg1.enterCreateEmailAddress("test.prakash195@gmail.com");
		logger.info("entered on create account section ");
		pg1.clickSubmitCreate();
		logger.info("click on create account button");
		
		accountCreationDetails accCreationPg= new accountCreationDetails(driver);
		accCreationPg.selectTitleMr();
		accCreationPg.enterFisrtName("Rakesh");
		accCreationPg.enterLastName("Sharma");
		logger.info("user details filled");
		accCreationPg.enterPassword("Test@1234");
		logger.info("pass word enter by the user");
		accCreationPg.selectDobDate("19");
		accCreationPg.selectDobMonth("6");
		accCreationPg.selectDobYear("1990");
		logger.info("user DOB details filled");
		
		
		  accCreationPg.clickOnRegister();
		  logger.info("click on register button ");
		  
		  RegisteredUserAccount regUser= new RegisteredUserAccount(driver);
		  
		  String actualUserName = regUser.getRegisteredUserName();
		  
		  Assert.assertEquals(actualUserName, "Rakesh Sharma");
		 
		
	}
	@Test(priority = 1)
	public void verifyLoginForRegUser() throws IOException {
		//launch browser
		
				driver.get(url);
				logger.info("url opened ");
				
				indexPage pg=new indexPage(driver);
				pg.clickOnSignIn();
				logger.info("Clicked on sign in buton ");
				myAccount pg1=new myAccount(driver);
			
				pg1.enterRegisterUseremail("test.prakash192@gmail.com");
				logger.info("user entered the resister user email");

				pg1.enterRegisterUserpassword("Test@1234");
				logger.info("user entered the resister user password");
				pg1.clickOnRegUserSubmit();
				logger.info("user click submit for the resister user");
				
				 RegisteredUserAccount regUser= new RegisteredUserAccount(driver);
				  
				  String actualUserName = regUser.getRegisteredUserName();
				  
				//  Assert.assertEquals(actualUserName, "Rakesh Sharma")

				  if(actualUserName.equals("Rakesh Sharma")) {
					  logger.info("verifyLoginForRegUser- passed");
					  Assert.assertTrue(true);
				  }else
				  {
					  logger.info("verifyLoginForRegUser- passed");
					  captureScreenShot(driver, "verifyLoginForRegUser");
					  Assert.assertTrue(false);
					  
					  
				  }
				
		
	}

}
