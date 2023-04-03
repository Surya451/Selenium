package com.automation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utilities.DriverPaths;
import com.automation.utilities.ScreenshotUtilities;


public class BaseTest {
	private static WebDriver webDriver; 
	private static String curDir;
	private static String tcName;
	/*
	 * This method is used to open the browser if the webdriver is not null 
	 */
	
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(@Optional("chrome") String browser) {
		curDir=System.getProperty("user.dir");
        if(browser.equalsIgnoreCase("chrome"))   {
        	System.setProperty(DriverPaths.chromekey, DriverPaths.chromevalue);
        	webDriver =new ChromeDriver();
        	init();	
        }
        else if(browser.equalsIgnoreCase("edge")){
        	System.setProperty(DriverPaths.edgekey, DriverPaths.edgevalue);
         	webDriver =new EdgeDriver();
            init();     
        }
	}
	
	private void init() {
		webDriver.manage().window().maximize();
    	webDriver.manage().deleteAllCookies();
    	webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	/*
	 * Tracking which Test case is going to be executed
	 */
	@BeforeMethod
	public void beforeTCExecution(Method method) {
		String tcName =method.getName();
		System.out.println("Current TC execution is: "+tcName);

	}
	/*
	 * After executing the Test case
	 */
	@AfterMethod
	public void afterTCExecution(ITestResult result) throws IOException {
		tcName=result.getName();
		if (result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("TC is Passed: "+tcName);
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("TC is Failed: "+tcName);
			//ScreenshotUtilities.takeScreenshot(tcName);
			String imgPath = ScreenshotUtilities.takeScreenshot();
			System.out.println("Screenshot Path is: "+imgPath);
			System.out.println("TC is Failed so taking Screenshot for: "+tcName);
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			System.out.println("TC is Skipped: "+tcName);
			//ScreenshotUtilities.takeScreenshot(tcName);
			String imgPath = ScreenshotUtilities.takeScreenshot();
			System.out.println("Screenshot Path is: "+imgPath);
			System.out.println("TC is skipped so taking Screenshot for: "+tcName);
		}

	}
 
	
	/*
	 * This method is used to close the browser if the webdriver is not null 
	 */
	@AfterSuite
	public void closeBrowser() {
		if (webDriver!=null) {
			webDriver.close();			
		}else {
			System.out.println("DRIVER IS POINTING TO NULL...");
		}
	}
	
	/*
	 * This is getter method to get the webdriver outside of the class
	 */
	public static WebDriver getWebDriver() {
		return webDriver;
	}
	/*
	 * This is getter method to get the current directory outside of the class
	 */
	public static String getCurDir() {
		return curDir;
	}
	/*
	 * This is getter method to get the Testcase name outside of the class
	 */
	public static String getTcName() {
		return tcName;
	}
}
