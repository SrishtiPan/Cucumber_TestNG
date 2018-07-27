package com.trip.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/com/trip/features/SearchFlight.feature", glue="com/trip/stepDefinitions")

public class TestNGRunner extends AbstractTestNGCucumberTests{

}
