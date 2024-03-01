package com.jbk.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	@FindBy(id ="name")
	private WebElement name ;
	
	@FindBy(id ="mobile")
	private WebElement mobileNo ;
	
	@FindBy(id ="email")
	private WebElement email ;
	
	@FindBy(id ="password")
	private WebElement password ;

	@FindBy(xpath ="//button[text()='Sign In']")
	private WebElement signIn ;
	
	@FindBy(linkText ="I already have a membership")
	private WebElement iAlreadyHaveaMembership ;
	
	public static Logger log = Logger.getLogger(LoginPage.class);
	
	public RegisterPage(WebDriver driver)
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
	
	public void setName(String text)
	{
		if(name.isEnabled())
		{
			name.sendKeys(text);
		}
		else	
		{
			log.info("Name Element Is Not Enabled");
		}
	}
	
	public void setMobileNo(String text)
	{
		if(mobileNo.isEnabled())
		{
			mobileNo.sendKeys(text);
		}
		else	
		{
			log.info("MobileNo Element Is Not Enabled");
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
	
	public void clickOnSignInBtn()
	{
		if(signIn.isEnabled())
		{
			signIn.click();
		}
		else	
		{
			log.info("SignInBtn Element Is Not Enabled");
		}
	}
	
	public void clickOnIAlreadyHaveaMembership()
	{
		if(iAlreadyHaveaMembership.isEnabled())
		{
			iAlreadyHaveaMembership.click();
		}
		else	
		{
			log.info("I Already Have aMembership Element Is Not Enabled");
		}
	}
}
	

