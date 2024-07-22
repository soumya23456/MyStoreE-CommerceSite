package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.mystore.pageobject.CustomerAccount;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LogoutPage;
import com.mystore.pageobject.LogoutSuccessPage;
import com.mystore.pageobject.SigninPage;
import com.mystore.utilities.ReadExcelFile;
 
public class TC_DD_SigninPageTest extends BaseClass {
	
//	@Ignore
	@Test(dataProvider = "LoginDataProvider")
	public void VerifySigninPage(String userEmail, String userPwd, String expectedUsername) throws IOException, InterruptedException
	{
		logger.info("***************TestCase VerifyLogin starts*****************"); 

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5));
		IndexPage pglink = new IndexPage(driver, wait);
		SigninPage signin = new SigninPage(driver);
		LogoutPage logout = new LogoutPage(driver);
		CustomerAccount accPage = new CustomerAccount(driver);
	 

		System.out.println(userEmail);
		logger.info("check user email");
		Thread.sleep(2000);
		
	    pglink.clickOnSignin();
		
		logger.info("Clicked on sign in link");

		Thread.sleep(4000);	
		signin.setEmail(userEmail);
		Thread.sleep(2000);
		logger.info("Entered email address");

		signin.setpwd(userPwd);
		logger.info("Entered password");
		Thread.sleep(2000);
		
		String emailInput = signin.getEmail();
		String psdInput = signin.getpwd();
	
		signin.clicklogInButton();
		logger.info("Clicked on sign in button..");

		if(emailInput.isBlank() || psdInput.isBlank()) {
			logger.info("Login with Empty Credntials");
			wait.until(d -> signin.isEmailErrorPresent());
			
			String emailErr = signin.getEmailErrorMessage();
			String psdErr = signin.getPasswordErrorMessage();
		
			System.out.println(emailErr);
			System.out.println(psdErr);
			
			logger.info("Email and Password required fields message is visible!");			
			
			//back to home page
			driver.get(pglink.IndexUrl());
			
		}
		else if (signin.getErrorMessage().length() != 0) {

			logger.info("Login with invalid Credntials");
			
			String errMsg = signin.getErrorMessage();
			System.out.println(errMsg);
			
			logger.info("Error message is visible");
			
			//back to home page
			driver.get(pglink.IndexUrl());
		}
		else {
			wait.until(d -> pglink.isUrl());
			Thread.sleep(2000);
			logger.info("opened home page");

			System.out.println(accPage.customerName());
//			Thread.sleep(5000);
			wait.until(d -> accPage.customerName().contains(expectedUsername));
			logger.info(driver.getCurrentUrl());
			
			String userNameText = accPage.customerName();
			
			if(userNameText.contains(expectedUsername)) {
				//upon successful login, navigated to customer page
				logger.info("verify login test -- passed");
				//logout
				logout.logoutdropdown();
				wait.until(d -> logout.isDropdownVisible());
				logger.info("Account dropdown is open now!");
				
				//click logout link
				logout.logoutbutton();
				logger.info("logged out!");

				//redirected to logout success page
				LogoutSuccessPage logoutSuccessPage = new LogoutSuccessPage(driver);
				wait.until(d -> logoutSuccessPage.isUrl());
				logger.info(driver.getCurrentUrl());
				
				assertTrue(logoutSuccessPage.isSignoutMessagePresent());			
				
				//redirect to home page
//				wait.until(d -> pglink.isUrl());
				logger.info(driver.getCurrentUrl());
				Assert.assertTrue(true);
			}else {
				logger.info("verify login test -- failed");
				captureScreenShot(driver, "verifyLoginTest");
				Assert.assertTrue(false);
			}
			
		}
		
   
		driver.get("https://magento.softwaretestingboard.com/");
		
		logger.info("***************TestCase Verify login ends*****************");
		}

		
		
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
	
		System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\TestData.xlsx";
		
		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
		
		String data[][] = new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)//rows
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
					}
				}
				return data;
			}
}

