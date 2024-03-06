package com.jbk.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.jbk.pageobjects.LoginPage;
import com.jbk.test.BaseClass;

public class TestListener implements ITestListener {

	public static Logger log = Logger.getLogger(LoginPage.class);
	//public WebDriver driver = new ChromeDriver();
	
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	
	  public void onTestFailure(ITestResult result) {
		  BaseClass b = new BaseClass();
		WebDriver  driver =b.setUp("chrome");
		  
	  System.out.println("*** Test execution " + result.getMethod().getMethodName()
	  + " failed..."); ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	  captureScreenshot(driver, result.getMethod().getMethodName());
	  
	  }
	  
	  
	  private void captureScreenshot(WebDriver driver, String methodName) {
		    if (driver instanceof TakesScreenshot) {
		        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
		        File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

		        try {
		            FileUtils.copyFile(screenshot, new File("screenshots/" + methodName + ".png"));
		            System.out.println("Screenshot captured: " + methodName);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	
	private String getTestClassName(String instanceName) {
		return null;
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}