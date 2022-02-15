package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.Constants;
import com.qa.opencart.pages.ExcelUtil;

public class RegistrationpageTest extends BaseTest {
	
	@BeforeClass
	public void setupRegistration() {
		registrationPage = lp.checkRegistration();
	}
	@DataProvider
	public Object[][] dataExtractionfromExcel() {
		return ExcelUtil.getExcelData(Constants.SHEET_NAME);
	}
	public int getRandomData() {
		Random remail = new Random();
		return remail.nextInt(1000);
		
	}
	
	@Test(dataProvider = "dataExtractionfromExcel")
	public void testRegistrationofNewUser(String firstName, String lastName ,String telphone, 
			String password,
			String subscribe) {
		Assert.assertTrue(registrationPage.doRegistration( firstName,  lastName, "abcd"+getRandomData()+ "@gmail.com", telphone, 
				 password,
				 subscribe));
	}
	
}
