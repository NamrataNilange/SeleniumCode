package com.qa.opencart.tests;

import org.testng.annotations.Test;

public class HomePagetest extends BaseTest {
	@Test
	public void testHomeIcon() {
		homepage = lp.homePageMethod();
		homepage.clickHomeIcon();
		
		
	}

}
