package com.trip.pages;

import org.openqa.selenium.support.PageFactory;

import com.trip.utils.CommonMethods;

public class SearchResults extends CommonMethods{

	public SearchResults() {
		
		PageFactory.initElements(driver, this);
	}
}
