package com.imdb.configurations;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 * Author: Dhruv Vinayak
 *
 * This class in used to initialize web driver for specified browser 
 * 
 */
public class InitializeDriver {
	
	//  level ALL can be used to enable logging of all messages 
	public static final Level logLevel = Level.ALL;
		
	public static WebDriver getWebDriverInstance(String browser) {
		
        switch (browser.toUpperCase()) {
            case "CHROME":
            	// Configure System Property to set driver path 
            	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");  
            	
            	// Configure Desired Capabilities to set log level
            	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            	capabilities.setCapability(CapabilityType.LOGGING_PREFS, ConfigureLogLevel.setLoggingPreferences(logLevel));
            	
            	// Configure Chrome Options to maximize browser window
            	ChromeOptions chromeOptions = new ChromeOptions();
            	chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("--start-maximized");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                
                return new ChromeDriver(capabilities);
                
            case "FIREFOX":
            	// Configure System Property to set gecko driver path 
            	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\webdrivers\\geckodriver.exe");
            	
            	// Configure Desired Capabilities to set log level
            	DesiredCapabilities cap = DesiredCapabilities.firefox();
            	cap.setCapability(CapabilityType.LOGGING_PREFS, ConfigureLogLevel.setLoggingPreferences(logLevel));
                
            	return new FirefoxDriver(cap);
            	
            default:
                throw new IllegalArgumentException(browser + " driver type is not supported");

        }
    }
}
