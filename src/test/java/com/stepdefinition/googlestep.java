package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Maven_Cucumber.Base_Class;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class googlestep extends Base_Class {
	
	@Given("^User Must Launch The \"([^\"]*)\" Browser$")
	public void user_Must_Launch_The_Browser(String arg1) throws Throwable {
		launchbrowser(arg1);
	}

	@When("^User Must Launch The \"([^\"]*)\" Url$")
	public void user_Must_Launch_The_Url(String arg1) throws Throwable {
		launchUrl(arg1);
	}

	@Then("^User Must Search The Value \"([^\"]*)\" In Search Bar$")
	public void user_Must_Search_The_Value_In_Search_Bar(String arg1) throws Throwable {
		WebElement findElement = driver.findElement(By.name("q"));
		passinput(findElement, arg1);
	}



}
