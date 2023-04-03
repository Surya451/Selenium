package com.automation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.base.BaseTest;

public interface ScreenshotUtilities {
	
	public static void takeScreenshot(String tcName) throws IOException {
		TakesScreenshot takeScreenshot=(TakesScreenshot) BaseTest.getWebDriver();
		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(BaseTest.getCurDir()+"\\Screenshots\\"+tcName+".jpeg"));
	}
    
	public static String takeScreenshot() throws IOException {
		TakesScreenshot takeScreenshot=(TakesScreenshot) BaseTest.getWebDriver();
		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String imgPath =BaseTest.getCurDir()+"\\Screenshots\\"+BaseTest.getTcName()+".jpeg";
		FileUtils.copyFile(file, new File(imgPath));
		return imgPath;
	}
}
