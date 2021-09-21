package com.inetBankingV4.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV4.utilities.ReadConfig;

public class BaseClass {

    ReadConfig readConfig= new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPwd();
	public static WebDriver driver = null;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readConfig.getChromeDriver());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxDriver());
			driver = new FirefoxDriver();
		}
		
		driver.get(baseURL);
		logger.info("Opened URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}
	
	public static String captureScreen(String screenShotName) throws IOException
	{
		String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);	
		String path = System.getProperty("user.dir") + "/Screenshots/" + screenShotName + df + ".png";
		
		File destination = new File(path);
		FileUtils.copyFile(src, destination);
		
		
		
	//	FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png"));
		System.out.println("Screenshot Taken");
		return path;
		
		
	}

}
