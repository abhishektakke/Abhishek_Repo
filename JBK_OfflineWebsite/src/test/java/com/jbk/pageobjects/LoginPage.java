package com.jbk.pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id ="email")
	private WebElement email ;
	
	@FindBy(id ="password")
	private WebElement password ;
	
	@FindBy(xpath ="//button[text()='Sign In']")
	private WebElement signUpBtn ;
	
	@FindBy(linkText ="Register a new membership")
	private WebElement registerNewMembership ;

	public static Logger log = Logger.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("log4j.properties"));
			PropertyConfigurator.configure(properties);
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void setEmail(String text)
	{
		if(email.isEnabled())
		{
			email.sendKeys(text);
		}
		else	
		{
			log.info("Email Element Is Not Enabled");
		}
	}
	
	public void setPassword(String text)
	{
		if(password.isEnabled())
		{
			password.sendKeys(text);
		}
		else	
		{
			log.info("Password Element Is Not Enabled");
		}
	}
	
	public void clickOnSignUpBtn()
	{
		if(signUpBtn.isEnabled())
		{
			signUpBtn.click();
		}
		else	
		{
			log.info("signUpBtn Element Is Not Enabled");
		}
	}
	public void clickOnregisterNewMembership()
	{
		if(registerNewMembership.isEnabled())
		{
			registerNewMembership.click();
		}
		else	
		{
			log.info("registerNewMembership Element Is Not Enabled");
		}
	}
}