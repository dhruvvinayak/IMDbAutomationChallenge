package com.imdb.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.imdb.abstractPage.BasePage;

/**
 * Author: Dhruv Vinayak
 *
 * This class contains required Web elements of IMDb Top-250 page and
 * methods which perform operations on those WebElements.
 * 
 */

public class ImdbTopRankPage extends BasePage {
	
    public ImdbTopRankPage(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
    }
    
    /********************************************************************
     * 						Page Element Declaration
    ********************************************************************/
       
    @FindBy(xpath="//div[@class='lister']//table//tr")
		private List<WebElement> movieTableRows;
    
    @FindBy(xpath="//select[@name='sort']")
		private WebElement sortByDropdown;
    
    @FindBy(xpath="//ul[@class='quicklinks ']//li[21]/a")
		private WebElement westernGenreLink;
    
    
    // enum to represent Sort By drop-down options
    public enum SortingDropDownOptions {
        RANKING("rk:ascending"), IMDB_RATING("ir:descending"), RELEASE_DATE("us:descending"), NUMBER_OF_RATINGS("nv:descending"), YOUR_RATING("ur:descending");

        private String sortingDropDownValue;

        SortingDropDownOptions(String value) {
        	sortingDropDownValue = value;
        }

        public String getDropDownValue() {
            return sortingDropDownValue;
        }
    }
    
    
    public List<WebElement> getMovieElementsList() {
        return movieTableRows;
    }

    
    public void selectSortOption(SortingDropDownOptions sortType) {
        new Select(sortByDropdown).selectByValue(sortType.getDropDownValue());
    }

    
    public WesternGenrePage clickWesternGenreLink() {
    	westernGenreLink.click();
        return new WesternGenrePage(driver, driver.getCurrentUrl());
    }

}
