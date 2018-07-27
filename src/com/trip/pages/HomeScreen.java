package com.trip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trip.utils.CommonMethods;

public class HomeScreen extends CommonMethods{

	@FindBy(id="OneWay")
	WebElement tripTypeOne;
	
	@FindBy(id="FromTag")
	WebElement from;
	
	@FindBy(id="ToTag")
	WebElement to;
	
	@FindBy(id="DepartDate")
	WebElement date;
	
	@FindBy(id="Adults")
	WebElement adults;
	
	@FindBy(id="Childrens")
	WebElement children;
	
	@FindBy(id="Infants")
	WebElement infants;
	
	@FindBy(id="SearchBtn")
	WebElement searchFlight;
	
	@FindBy(xpath="//*[@class='autoComplete']/li/a")
	List<WebElement> sourceCityList;
	
	@FindBy(xpath="//*[@class='autoComplete'][2]/li/a")
	List<WebElement> destinationCityList;
	
	@FindBy(xpath="//table[@class='calendar']//td")
	List<WebElement> departureDate;
	
	
	public HomeScreen() {
		
		PageFactory.initElements(driver, this);
	}
	
	public SearchResults search(String trip, String fromPlace, String toPlace, String departureDate, String adultsCount, String childrenCount, String infantsCount) {
	
		
	searchFlight.click();		
	return new SearchResults();
	
	}
	
	public void selectTripTypeOneWay() {
		tripTypeOne.click();
		}
	
	public List<WebElement> sourceCityLists() {
		return sourceCityList;
		}
	
	public List<WebElement> destinationCityLists() {
		return destinationCityList;
		}
	
	public List<WebElement> departureDates() {
		return departureDate;
		}
	
	public void selectFromPlace(String fromPlace) {
		from.sendKeys(fromPlace);
	}
	
	public void selectToPlace(String toPlace) {
		to.sendKeys(toPlace);
	}
	
	public void selectDepartureDate() {
		date.click();
	}
	
	public WebElement noOfAdults() {
		return adults;
		}
	
	public WebElement noOfChildren() {
		return children;
		}
	
	public WebElement noOfInfants() {
		return infants;
		}
	public WebElement searchFlight() {
		return searchFlight;
		}
}
