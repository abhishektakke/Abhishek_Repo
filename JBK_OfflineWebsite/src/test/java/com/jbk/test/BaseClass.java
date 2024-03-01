package com.jbk.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.jbk.uttilites.ReadConfig;

public class BaseClass 
{

	public WebDriver driver ;
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	ReadConfig readConfig = new ReadConfig();
	String BaseUrl = readConfig.getProperty("BaseUrl");
	String validEmail = readConfig.getProperty("ValidEmail");
	String validPassword = readConfig.getProperty("ValidPassword");
	String chromeDriver = readConfig.getProperty("chromeDriver");
	String firefoxDriver = readConfig.getProperty("geckoDriver");
	
	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String browser)
	{
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("./log4j.properties"));
			PropertyConfigurator.configure(properties);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	
		if (browser.equals("chrome"))
		{
			log.info("Open Chrome Driver");
			System.setProperty("webdriver.chrome.driver", chromeDriver);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(15000, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
		}
		else if (browser.equals("firefox")) 
		{
			log.info("Open Firefox Driver");
			System.setProperty("webdriver.gecko.driver", firefoxDriver);
			driver = new FirefoxDriver() ;
			driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}	
	}
	
}
