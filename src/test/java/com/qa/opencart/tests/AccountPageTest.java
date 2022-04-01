package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void testBefreforAcountPage() {
		aP = lp.checkSearchFunctionality();
	}
	
	@Test
	public void doAccountPageTest() {
		
		Assert.assertTrue(aP.doPressBtn());
		
	}

}
