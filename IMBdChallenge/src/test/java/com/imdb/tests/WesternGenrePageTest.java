package com.imdb.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.imdb.abstractTestPage.BasePageTest;
import com.imdb.configurations.ScreenShotOnFailure;
import com.imdb.pageObjects.ImdbTopRankPage;
import com.imdb.pageObjects.WesternGenrePage;

/**
 * Author: Dhruv Vinayak
 *
 * This class contains test cases to validate sorting options on IMDb Western Genre page
 * 
 */

public class WesternGenrePageTest extends BasePageTest{

	private static WesternGenrePage westernGenrePage;
	
	// rule to take screenshot only in case of test failure
	@Rule
	public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);

    @BeforeClass
    public static void init() throws Exception {
    	initDriver();

    	ImdbTopRankPage imdbTopRankPage = new ImdbTopRankPage(driver, getPropertyValue("url"));
    	imdbTopRankPage.openPage();
    	westernGenrePage = imdbTopRankPage.clickWesternGenreLink();
    }

    
    @Test
    public void shouldContainAtLeastOneMovieInWesternGenreList() throws Exception {
        Assert.assertTrue(westernGenrePage.getMovieTableElementsList().size() > 0);
    }
    
    
    @Test
    public void shouldContainAtLeastOneMovieInWesternGenreListForEachSortByOption() throws Exception {
    	int numberOfSortingOptions = westernGenrePage.getSortByOptions().size();
    	
    	for(int i=0; i< numberOfSortingOptions; i++)  {
    		westernGenrePage.clickSortingOption(westernGenrePage.getSortByOptions().get(i));
    		Assert.assertTrue(westernGenrePage.getMovieTableElementsList().size() > 0);
    	}
    }

}
