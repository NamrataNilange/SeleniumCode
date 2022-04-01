package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement element = driver.findElement(By.xpath("//span[text() = 'right click me']"));
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
		
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']//li[contains(@class,'context-menu-item context-menu-icon context-menu-icon-')]"));
		//getData(elements);
		ElementUtils e = new ElementUtils(driver);
		e.getData(elements,driver);
		//e.getalert();
		
	
	}
}


