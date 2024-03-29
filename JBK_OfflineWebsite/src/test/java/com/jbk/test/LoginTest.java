package com.jbk.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.jbk.pageobjects.LoginPage;
import junit.framework.Assert;

public class LoginTest extends BaseClass
{
	LoginPage lp ;
	
	@Test
	public void loginTC1() throws Exception
	{
		driver.get(BaseUrl);
		log.info("loginTC1");
	
		lp =new LoginPage(driver);
		lp.setEmail("kiran@gmail.com");
		lp.setPassword("123456");
		lp.clickOnSignUpBtn();
		
		String act_title = driver.getTitle();
		String exp_title = "JavaByKiran | Dashboard"; 	
		log.info("loginTC1 : Atual Title : "+act_title +" "+"Expected Title : "+exp_title);
		Assert.assertEquals(act_title, exp_title);
	}
	
	@Test()
	public void loginTC2() throws Exception
	{
		driver.get(BaseUrl);
		log.info("loginTC2");
	
		lp =new LoginPage(driver);
		lp.setEmail("kiran@gmail.com");
		lp.setPassword("12345");
		lp.clickOnSignUpBtn();
		
		String act_title = driver.getTitle();
		String exp_title = "JavaByKiran | Dashboard"; 	
		log.info("loginTC2 : Atual Title : "+act_title +" "+"Expected Title : "+exp_title);
		Assert.assertEquals(act_title, exp_title);
	
	}
	
	@Test(dependsOnMethods = "loginTC2")
	public void loginTC3() throws Exception
	{
		driver.get(BaseUrl);
		log.info("loginTC3");
	
		lp =new LoginPage(driver);
		lp.setEmail("kiran@gmail.com");
		lp.setPassword("123456");
		lp.clickOnSignUpBtn();
		
		String act_title = driver.getTitle();
		String exp_title = "JavaByKiran | Dashboard"; 	
		log.info("loginTC3 : Atual Title : "+act_title +" "+"Expected Title : "+exp_title);
		Assert.assertEquals(act_title, exp_title);
	}

	
	@AfterMethod
	public void closeDriver()
	{
		driver.close();
	}
	
}
