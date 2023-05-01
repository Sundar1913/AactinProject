package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC02_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	
	@When("User needs to search hotel using {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_needs_to_search_hotel_using_and(String location, String hotels, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		pom.getSearchHotelPage().searchHotels(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate,
				adultsPerRoom, childrenPerRoom);
	}

	@Then("User should navigate to select hotel and verify the success message {string}")
	public void user_should_navigate_to_select_hotel_and_verify_the_success_message(String searchHotelSuccessMsg) {
		Assert.assertEquals("Verify the success message", searchHotelSuccessMsg,
				pom.getSelectHotelPage().getSuccessMsg2().getText());
	}

	@When("User needs to search hotel using mandatory fields {string},{string},{string},{string} and {string}")
	public void user_needs_to_search_hotel_using_mandatory_fields_and(String location, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom) {
		pom.getSearchHotelPage().searchHotels(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);

	}

	@Then("User should verify after search with the date error message {string} and {string}")
	public void user_should_verify_after_search_with_the_date_error_message_and(String checkInDateErrorMsg, String checkOutDateErrorMsg) {
		Assert.assertEquals("Verify the error message", checkInDateErrorMsg,
				pom.getSearchHotelPage().getErrorMsg2().getText());
		Assert.assertEquals("Verify the error message", checkOutDateErrorMsg,
				pom.getSearchHotelPage().getErrorMsg3().getText());
	}

	@When("User should click search without entering any fields")
	public void user_should_click_search_without_entering_any_fields() {
		pom.getSearchHotelPage().searchHotels();
	}

	@Then("User should verify after search with the error message {string}")
	public void user_should_verify_after_search_with_the_error_message(String enterAnyFields) {
		Assert.assertEquals("Verify the error msg about not entering any fields", enterAnyFields,
				pom.getSearchHotelPage().getErrorMsg4().getText());
	}




}
