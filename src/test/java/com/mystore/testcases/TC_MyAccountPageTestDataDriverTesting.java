package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.utilities.ExcelUtils;

public class TC_MyAccountPageTestDataDriverTesting extends BaseClass {
	
	ExcelUtils excel;
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
		  logger.info("click on register button");
		  
		  RegisteredUserAccount regUser= new RegisteredUserAccount(driver);
		  
		  String actualUserName = regUser.getRegisteredUserName();
		  
		  Assert.assertEquals(actualUserName, "Rakesh Sharma");
		 
		
	}
	@Test(priority = 1,dataProvider = "LoginDataProvider")
	public void verifyLoginForRegUser(String userEmail, String userPassWord, String expectedUserName) throws IOException {
		//launch browser
		
				driver.get(url);
				logger.info("url opened ");
				
				indexPage pg=new indexPage(driver);
				pg.clickOnSignIn();
				logger.info("Clicked on sign in buton ");
				myAccount pg1=new myAccount(driver);
			
				pg1.enterRegisterUseremail(userEmail);
				logger.info("user entered the resister user email");

				pg1.enterRegisterUserpassword(userPassWord);
				logger.info("user entered the resister user password");
				pg1.clickOnRegUserSubmit();
				logger.info("user click submit for the resister user");
				
				 RegisteredUserAccount regUser= new RegisteredUserAccount(driver);
				  
				  String actualUserName = regUser.getRegisteredUserName();
				  
				//  Assert.assertEquals(actualUserName, "Rakesh Sharma")

				  if(actualUserName.equals(expectedUserName)) {
					  logger.info("verifyLoginForRegUser- passed");
					  regUser.clickOnSignOut();
					  Assert.assertTrue(true);
					  
				  }else
				  {
					  logger.info("verifyLoginForRegUser- passed");
					  captureScreenShot(driver, "verifyLoginForRegUser");
					  Assert.assertTrue(false);
					  
					  
				  }
				  
				 
				  		
		
	}
	
	
	@DataProvider(name="LoginDataProvider")
	public String [][]LoginDataProvider(){
		
		String fileName=System.getProperty("user.dir")+"\\TestData\\mystoreTestData.xlsx";
		String sheetName="RegisterUser";
		
		excel= new ExcelUtils(fileName, sheetName);
		int ttlRows=excel.getRowCount();
		int ttlColumns=excel.getColumnCount();
		
		String data[][]=new String [ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++) {
			for(int j=0;j<ttlColumns;j++) {
				data[i-1][j]=excel.getCellData(i, j);
			}
		}
		
		return data;
	}

}
