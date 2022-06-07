package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePagetest extends BaseTest {
	
	@BeforeClass
	public void executeFirstThisStep() {
		homepage = lp.homePageMethod();
		homepage.clickHomeIcon();
	}
	@Test
	public void testHomeIcon() {
		//homepage = lp.homePageMethod();
		homepage.clickHomeIcon();
		
		
	}
	@Test
	public void testHomeIconList() {
		//homepage = lp.homePageMethod();
		homepage.getImageNames();
	}
	
	@Test
	public void testHomeFeatures() {
		
		//homepage.getFeatureList();
		Assert.assertEquals(4, homepage.getFeatureList());
	}
	@Test
	public void testRemoveItemFromCart() {
		homepage.checkInputTextBox();
	}

}
