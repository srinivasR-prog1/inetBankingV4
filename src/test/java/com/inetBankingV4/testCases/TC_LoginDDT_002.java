package com.inetBankingV4.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV4.pageObjects.LoginPage;
import com.inetBankingV4.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void loginTest(String username, String password) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.btnLogin();
		Thread.sleep(3000);

		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login testcase Failed");

		} else {
			Assert.assertTrue(true);
			logger.info("Login testCase Passed");
			lp.btnLogOutClick();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlertPresent() {

		try {

			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) {

			return false;
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBankingV4/testData/LoginData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "loginData");
		int colCount = XLUtils.getCellCount(path, "loginData", 1);

		String logindata[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < colCount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "loginData", i, j);

			}

		}

		return logindata;

	}

}
