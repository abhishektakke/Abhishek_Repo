package com.jbk.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginTest 
{
	WebDriver driver ;
	@BeforeTest
	public void loginpage() throws Exception
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	} 
	
	@Test
	public void testCase1() throws Exception
	{
		driver.get("file:///C:/Users/admin/Desktop/Software%20Testing/Automation%20Testing/selenium%20jar/Selenium%20Software%20all/Selenium%20Softwares/Offline%20Website/index.html");
		System.out.println("testCase1");
		
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String act_title = driver.getTitle();
		System.out.println("Title : "+act_title);
		String exp_title = "JavaByKiran | Dashboard"; 	
		Assert.assertEquals(act_title, exp_title);
	
	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.close();
	}
	
}
