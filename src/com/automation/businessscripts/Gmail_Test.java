package com.automation.businessscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

public class Gmail_Test extends BaseTest {
	
	@Test
	public void gmail_Test() throws IOException {
		
		FileInputStream fip =new FileInputStream("D:\\Selenium\\frameworks\\config.properties");
		Properties prconf =new Properties();
		prconf.load(fip);
		String url=prconf.getProperty("gmail_url");
		getWebDriver().get(url);
		
		FileInputStream fipor =new FileInputStream("D:\\Selenium\\frameworks\\src\\com\\automation\\applnname\\objectrepository\\or.properties");
		Properties pror =new Properties();
		pror.load(fipor);
		String un =pror.getProperty("gmail_un_id");
				
		WebElement un_id = getWebDriver().findElement(By.id(un));
        un_id.clear();
        un_id.sendKeys("suryanarayanamachetti@gmail.com");
	}

}
