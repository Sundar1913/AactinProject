package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class TC01_LoginStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on the adactin page")
	public void user_is_on_the_adactin_page() throws FileNotFoundException, IOException{
		
	}

	@When("User should perform login {string} , {string}")
	public void user_should_perform_login(String username, String password) {
		pom.getLoginPage().login(username, password);
	}

	@When("User should perform login {string} , {string} with Enterkey")
	public void user_should_perform_login_with_Enterkey(String username, String password) throws AWTException {
		pom.getLoginPage().loginWithEnterKey(username, password);
	}

	@Then("User should verify after login with invalid credentials error message contains {string}")
	public void user_should_verify_after_login_with_invalid_credentials_error_message_contains(String loginErrorMsg) {
		WebElement errorMsg1 = pom.getLoginPage().getErrorMsg1();
		String elementGetText = elementGetText(errorMsg1);
		boolean b = elementGetText.contains(loginErrorMsg);
		Assert.assertTrue("Verify the error message", b);

	}


}
