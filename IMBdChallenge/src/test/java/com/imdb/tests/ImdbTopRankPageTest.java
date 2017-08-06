package com.imdb.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.imdb.abstractTestPage.BasePageTest;
import com.imdb.configurations.ScreenShotOnFailure;
import com.imdb.pageObjects.ImdbTopRankPage;


/**
 * Author: Dhruv Vinayak
 *
 * This class contains test cases to validate sorting options on IMDb Top-250 page
 * 
 */

public class ImdbTopRankPageTest extends BasePageTest{
	
	private static ImdbTopRankPage imdbTopRankPage;
	
	// rule to take screenshot only in case of test failure
	@Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);
	
    @BeforeClass
    public static void init() throws Exception {
        initDriver();
        
        imdbTopRankPage = new ImdbTopRankPage(driver, getPropertyValue("url"));
        imdbTopRankPage.openPage();
    }
    
    
    @Test
    public void shouldReturnAtLeastOneMovieInTop250List() throws Exception {
    	Assert.assertTrue(imdbTopRankPage.getMovieElementsList().size() > 0);
    }
    
    
    @Test
    public void shouldReturnAtLeastOneMovieForEachSortOption() throws Exception {
        for(ImdbTopRankPage.SortingDropDownOptions sortByOption: ImdbTopRankPage.SortingDropDownOptions.values()) {
        	imdbTopRankPage.selectSortOption(sortByOption);
            Assert.assertTrue(imdbTopRankPage.getMovieElementsList().size() > 0);
        }
    }


}
