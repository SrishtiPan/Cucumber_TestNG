package com.trip.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.trip.pages.HomeScreen;
import com.trip.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class EnterDetails extends CommonMethods{

	HomeScreen home;

	@Given("^I am on ClearTrip search flights page$")
	public void i_am_on_search_flights_page() {
		CommonMethods.initialization();
	  
	}

	@When("^I enter Source City$")
	public void i_enter_Source_City() {
		home= new HomeScreen();
		if(prop.getProperty("tripType").equals("OneWay")) {
			
			home.selectTripTypeOneWay();
		}

		home.selectFromPlace(prop.getProperty("fromPlace"));
		List<WebElement> str = home.sourceCityLists();
	    str.stream().forEach((element)->{
			
			System.out.println("The list of from cities are:  "+element.getText());
		});
	    
	    str.stream()                                                  // Convert to stream
			.filter(x -> prop.getProperty("selectToCity").equals(x.getText()))        
            .findFirst()
		    .ifPresent(ele -> ele.click()); 
	
    }
	
	@When("^I enter Destination City$")
	public void i_enter_Destination_City()  {
		home.selectToPlace(prop.getProperty("toPlace"));
		List<WebElement> strNew = home.destinationCityLists();
		
		strNew.stream().forEach((element)->{
		
		System.out.println("The list of to cities are:  "+element.getText());
	});
	
	        		
		strNew.stream()                                                  // Convert to stream
			.filter(x -> prop.getProperty("selectFromCity").equals(x.getText()))        
            .findFirst()
		    .ifPresent(ele -> ele.click()); 
	}
	


@When("^I select the journey date$")
public void i_select_the_journey_date()  {
    
	home.selectDepartureDate();
	List<WebElement> allDates=home.departureDates();

	
	long count = allDates.stream().count();
	allDates.stream()
	   .filter(x -> prop.getProperty("departureDate").equals(x.getText()))  
	   .skip(1)
	   .findFirst()
	   .ifPresent(ele -> ele.click());
}

@When("^I select the number of adults$")
public void i_select_the_number_of_adults()  {
	
	WebElement adults = ((prop.getProperty("adults").equals("0")) ? null : Integer.parseInt(prop.getProperty("adults"))>9? null : home.noOfAdults());

	if(adults!=null) {
		
	 Select select = new Select(home.noOfAdults()); 
     List<WebElement> allOptions = select.getOptions();
     
   
     allOptions.stream()
	   .filter(x -> prop.getProperty("adults").equals(x.getText()))  
	   .findFirst()
	   .ifPresent(ele -> ele.click());
     
}
}

@When("^I select the number of children$")
public void i_select_the_number_of_children() {

	WebElement children = ((prop.getProperty("children").equals("0")) ? null : Integer.parseInt(prop.getProperty("children"))>5? null : home.noOfChildren());
	
	if(children!=null) {
		
	     Select select = new Select(home.noOfChildren()); 
	     List<WebElement> allOptions = select.getOptions();
	     
	   
	     allOptions.stream()
		   .filter(x -> prop.getProperty("children").equals(x.getText()))  
		   .findFirst()
		   .ifPresent(ele -> ele.click());
	}
}

@When("^I select the number of infants$")
public void i_select_the_number_of_infants() {
	WebElement infant = ((prop.getProperty("infants").equals("0")) ? null : Integer.parseInt(prop.getProperty("infants"))>4? null : home.noOfInfants());

	if(infant!=null) {
		
		Select select = new Select(home.noOfInfants()); 
	     List<WebElement> allOptions = select.getOptions();
	     
	   
	     allOptions.stream()
		   .filter(x -> prop.getProperty("infants").equals(x.getText()))  
		   .findFirst()
		   .ifPresent(ele -> ele.click());
	}
}

@When("^I tap on Submit button$")
public void i_tap_on_Submit_button()  {
  home.searchFlight().click();
}

@Then("^I navigate to Search Results Page$")
public void i_navigate_to_Search_Results_Page() {
   
}


}

/*String  city = str.stream()                                                  // Convert to steam
        .filter(x -> prop.getProperty("selectCity").equals(x.getText()))       
        .map(WebElement::getText)
        .findAny()                                                              // If 'findAny' then return found
        .orElse("");   
*/
/*	WebElement myDestinationcity = strNew.stream()                                                  // Convert to steam
                .filter(x -> prop.getProperty("selectFromCity").equals(x.getText()))        
                .findAny()                                                              // If 'findAny' then return found
                .orElse(null); 
		
        System.out.println("From city name :  " + myDestinationcity.getText());
        
        WebDriverWait wait2 = new WebDriverWait(driver, 500);
		wait2.until(ExpectedConditions.visibilityOf(myDestinationcity)).click();
*/