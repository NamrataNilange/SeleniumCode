package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	ElementUtils eUtil;
	public HomePage(WebDriver diver) {
		eUtil = new ElementUtils(diver);
	}
	
	private By homeIcon = By.xpath("//div[@id=\"account-account\"]/ul/li/a/i[@class=\"fa fa-home\"]");
	
	////div[@id="carousel0"]//div[contains(@class , 'swiper-slide text-center'),@data-swiper-slide-index="0"]
	//div[@id="carousel0"]//div[@class='swiper-slide text-center swiper-slide-active']/self::div | //div[@id="carousel0"]//div[@class='swiper-slide text-center swiper-slide-active']/following-sibling::div//img
	
	public void clickHomeIcon() {
		eUtil.getElementClick(homeIcon);
	}
	
}
