package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC05_CancelBookingStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();


@When("User should navigate to booked itinerary to cancel the order id")
public void user_should_navigate_to_booked_itinerary_to_cancel_the_order_id() {
	pom.getCancelBookingPage().cancelCurrentOrderId();
}

@Then("User should verify after cancel the order id with the success message {string}")
public void user_should_verify_after_cancel_the_order_id_with_the_success_message(String cancelOrderSuccessMessage) {
	Assert.assertEquals("Verify the success message", cancelOrderSuccessMessage,
			pom.getCancelBookingPage().getsuccessMsg5().getText());
}

@When("User should navigate to booked itinerary to cancel the existing {string}")
public void user_should_navigate_to_booked_itinerary_to_cancel_the_existing(String exOrderId) {
	pom.getCancelBookingPage().cancelExistingOrderId(exOrderId);
}




}
