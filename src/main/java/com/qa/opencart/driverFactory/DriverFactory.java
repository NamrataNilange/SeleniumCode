package com.qa.opencart.driverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	WebDriver driver;

	 Properties prop;
	 public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	 public OptionsManager optionsManager;
	
	public WebDriver init_driver(Properties prop) {
		optionsManager = new OptionsManager(prop);
		if(prop.getProperty("browser").equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
		init_remoteDriver("chrome");
		}
		else
			{
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		}
		
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
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
	private void init_remoteDriver(String browser) {

		System.out.println("Running test on remote grid server: " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			//selenium 3.x
			DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setBrowserName("chrome");
			
			cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());
			try {
				tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			//cap.setBrowserName("firefox");
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsManager.getFirefoxOptions());
			try {
				tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

	}

	

}
