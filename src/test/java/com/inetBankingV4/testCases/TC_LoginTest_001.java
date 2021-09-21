package com.inetBankingV4.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV4.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.btnLogin();

		if (driver.getTitle().equals("Guru99 Bank1 Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("LoginTest is Passed");
			lp.btnLogOutClick();
			logger.info("Clicked on Logoutbutton");

		} else {
			
		

			Assert.assertTrue(false);
			logger.info("LoginTest is failed");

		}
	}

}
