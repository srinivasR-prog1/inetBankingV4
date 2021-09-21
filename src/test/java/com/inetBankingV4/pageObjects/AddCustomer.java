package com.inetBankingV4.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	WebDriver driver;

	public AddCustomer(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(name = "name")
	@CacheLookup
	WebElement cusName;

	@FindBy(name = "rad1")
	@CacheLookup
	WebElement cusGender;

	@FindBy(name = "dob")
	@CacheLookup
	WebElement cusDoB;

	@FindBy(name = "addr")
	@CacheLookup
	WebElement cusAddr;

	@FindBy(name = "city")
	@CacheLookup
	WebElement cusCity;

	@FindBy(name = "state")
	@CacheLookup
	WebElement cusState;

	@FindBy(name = "pinno")
	@CacheLookup
	WebElement cusPin;

	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement cusMobileno;

	@FindBy(name = "emailid")
	@CacheLookup
	WebElement cusEmail;

	@FindBy(name = "password")
	@CacheLookup
	WebElement cusPwd;

	@FindBy(name = "sub")
	@CacheLookup
	WebElement cusbtnSubmit;
	
	
	
	public void clickAddNewCustomer()
	{
		
		lnkAddNewCustomer.click();
		
	}

	public void setCusName(String custName) {

		cusName.clear();
		cusName.sendKeys(custName);

	}

	public void setCusAddr(String custAddr) {

		cusAddr.clear();
		cusAddr.sendKeys(custAddr);

	}

	public void setCusCity(String custCity) {

		cusCity.clear();
		cusCity.sendKeys(custCity);

	}
	
	public void setCusState(String custState) {

		cusState.clear();
		cusState.sendKeys(custState);

	}
	public void setCusPin(String custPin) {

		cusPin.clear();
		cusPin.sendKeys(custPin);

	}
	public void setCusMobileno(String custMobileno) {

		cusMobileno.clear();
		cusMobileno.sendKeys(custMobileno);

	}
	public void setCusEmail(String custEmail) {

		cusEmail.clear();
		cusEmail.sendKeys(custEmail);

	}
	
	public void setCusPwd(String custPwd) {

		cusPwd.clear();
		cusPwd.sendKeys(custPwd);

	}
	
	public void cusBtnSubmit()
	{
		
		cusbtnSubmit.click();
		
	}
	
	

}
