package com.automation.businessscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;



public class Fp_Test extends BaseTest {
	
	@Test
	public void fp_Test() {
		getWebDriver().get("https://www.flipkart.com");
		getWebDriver().findElement(By.id("identifierId"));
	}
	
}
