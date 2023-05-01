package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC03_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	
	@When("User should select hotel and continue")
	public void user_should_select_hotel_and_continue() {
		pom.getSelectHotelPage().selectHotel();
	}

	@Then("User should navigate to book hotel and verify the success message {string}")
	public void user_should_navigate_to_book_hotel_and_verify_the_success_message(String successMsgAfterSelectHotel) {
		Assert.assertEquals("Verify the success message", successMsgAfterSelectHotel,
				pom.getBookHotelPage().getSuccessMsg3().getText());
	}

	@When("User should continue without select hotel")
	public void user_should_continue_without_select_hotel() {
		pom.getSelectHotelPage().clickContinue();
	}

	@Then("User should verify after continue with the error message {string}")
	public void user_should_verify_after_continue_with_the_error_message(String selectHotelError) {
		Assert.assertEquals("Verify the error message", selectHotelError,
				pom.getSelectHotelPage().getErrorMsg5().getText());
	}



}
