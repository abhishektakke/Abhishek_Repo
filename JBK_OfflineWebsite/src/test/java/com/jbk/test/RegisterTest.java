package com.jbk.test;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.jbk.pageobjects.LoginPage;
import com.jbk.pageobjects.RegisterPage;

import junit.framework.Assert;

public class RegisterTest extends BaseClass
{
	LoginPage lp ;
	RegisterPage rp ;
	
	@Test
	public void registerTC1()
	{
		driver.get(BaseUrl);
		log.info("registerTC1");
		
		lp = new LoginPage(driver);
		rp = new RegisterPage(driver);
		
		lp.clickOnregisterNewMembership();
		rp.setName("Abhishek");
		rp.setMobileNo("1234567899");
		rp.setEmail("Abhi@gmail.com");
		rp.setPassword("12345");
		rp.clickOnSignInBtn();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		String act_title = alert.getText();
		alert.accept();
		
		String exp_title = "User registered successfully."; 	
		log.info("registerTC1 : Atual Title : "+act_title +" "+"Expected Title : "+exp_title);
		Assert.assertEquals(act_title, exp_title);
		
	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.close();
	}
}
