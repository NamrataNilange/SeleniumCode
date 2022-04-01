package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest{
	@BeforeClass
	public void gotoAccountPage() {
		aP = lp.checkSearchFunctionality();
		//productpage = aP.goToProductPage();
	}
	
	@Test
	public void doTestProdcuctPage() {
		//lp.loginMethod(prop.getProperty("username"), prop.getProperty("password"));
		productpage = aP.goToProductPage();
		
		//productpage.clickOnCart();
		Assert.assertTrue(productpage.clickOnCart());
	}
	@Test
	public void testProductInfoOfProductPage() {
		aP.clearTheInputTextArea();
		productpage  = aP.goToProductPage();
		productpage.clickOnCart();
		Map<String,String> metaProductPage = productpage.getproductinfo();
		metaProductPage.forEach((k,v) -> System.out.println(k+":"+v));
		Assert.assertEquals(metaProductPage.get("Brand"),"Apple");
	}

}
