package com.imdb.abstractTestPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

import com.imdb.configurations.InitializeDriver;
import com.imdb.configurations.ScreenShotOnFailure;

/**
 * Author: Dhruv Vinayak
 *
 * [Abstract class] This is a base testcase class which is inherited by other Testcase classes 
 * 
 */

public abstract class BasePageTest {
	protected static WebDriver driver;
	
	//read broswer type from run.conf file
    protected static final String browserType = getPropertyValue("browser");
    
    public static void initDriver() {
    	driver = InitializeDriver.getWebDriverInstance(browserType);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    public static String getPropertyValue(String property)
	{
		File file = new File("src\\test\\resources\\run.conf");		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(property);
	}


    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
