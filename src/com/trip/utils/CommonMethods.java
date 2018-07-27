package com.trip.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CommonMethods {

	public static WebDriver driver;
	public static Properties prop;
	
	public CommonMethods() {
		
		try {
			prop= new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Srishti_Pant\\eclipse-workspace\\Cucumber_TestNG\\src\\com\\trip\\data\\config.properties");
		prop.load(fis);
		
		}
		catch(IOException e) {
			e.getMessage();
		}
	}
	
	public static void initialization() {
		
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
			driver = new ChromeDriver(options);
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
