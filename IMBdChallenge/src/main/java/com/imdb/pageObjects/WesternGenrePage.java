package com.imdb.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imdb.abstractPage.BasePage;

/**
 * Author: Dhruv Vinayak
 *
 * This class contains required Web elements of Western Genre Page and
 * methods which perform operations on those WebElements.
 * 
 */

public class WesternGenrePage extends BasePage{
	
	/********************************************************************
     * 						Page Element Declaration
    ********************************************************************/
    
    @FindBy(xpath="//div[@class='lister-list']")
		private WebElement moviesTable;
    
    @FindBy(xpath="//div[@class='lister-item mode-advanced']")
		private List<WebElement> movieTableRows;
    
    @FindBy(xpath="//div[@class='sorting']/a")
		private List<WebElement> sortByLinks;

	
    public WesternGenrePage(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
    }

 
    public List<WebElement> getMovieTableElementsList() {
        return movieTableRows;
    }

    public List<WebElement> getSortByOptions() {
        return sortByLinks;
    }
    
    public void clickSortingOption(WebElement sortByType) {
   		sortByType.click();
    }

}

