package com.qa.opencart.driverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.opencart.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	WebDriver driver;
	 LoginPage lpage;
	 Properties prop;
	 public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) {
		if(prop.getProperty("browser").equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		tldriver.set(new ChromeDriver());
		}
		
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		
		
		
		return getDriver();
	}
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		if(envName == null) {
			try {
				//ip = new FileInputStream("./src/test/resources/config.properties");
				ip = new FileInputStream("./testdata/config.properties");
				try {
					prop.load(ip);
				} catch (IOException e) {					
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {				
				e.printStackTrace();
			}
		}
		else if(envName.equals("qa")) {
		try {
			ip = new FileInputStream("./src/test/resources/qa.config.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
		
		return prop;
		
	}
	
	public synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
				
	}
	

}
