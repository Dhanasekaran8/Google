package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\lashm\\eclipse-workspace\\Maven_Cucumber\\src\\test\\java\\com\\feature\\Google.feature",
glue = "com.stepdefinition",
plugin = {"html:reports/cucumber.html","pretty","json:Reports/JsonFile.json",
		"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"})

public class googlerun {

}
