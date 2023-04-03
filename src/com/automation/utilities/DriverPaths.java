package com.automation.utilities;

import com.automation.base.BaseTest;

public interface DriverPaths {
	
	String chromekey = "webdriver.chrome.driver";
	String edgekey = "webdriver.edge.driver";
	
	String chromevalue = BaseTest.getCurDir()+"\\Drivers\\chromedriver.exe";
	String edgevalue = BaseTest.getCurDir()+"\\Drivers\\msedgedriver.exe";
	
}
