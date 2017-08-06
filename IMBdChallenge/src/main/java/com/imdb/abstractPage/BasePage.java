package com.imdb.abstractPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Author: Dhruv Vinayak
 *
 * [Abstract class] This a base page class which will be inherited by other page classes 
 * 
 */

public abstract class BasePage {
	private final static Logger logger = Logger.getLogger(BasePage.class);	
	
    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // method to open browser and navigate to base url
    public void openPage() {
        driver.get(url);
    }
    
    // method to open browser and navigate to required url
    public void openPage(String url) {
        driver.get(url);
    }

    public void waitForElementToLoad(WebElement element, int waitTimeInSecs) {
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
