package com.qa.stepDefinitions;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomePageSteps extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	@Given("^user opens browser$")
	public void user_opens_browser() {
		TestBase.initialization();
	}

	@SuppressWarnings("deprecation")
	@Then("^user is on login page$")
	public void user_is_on_login_page() {
		loginPage =  new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}

	@Then("^user logs into app$")
	public void user_logs_into_app() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@SuppressWarnings("deprecation")
	@Then("^validate home page title$")
	public void validate_home_page_title() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", title);
	}

	@SuppressWarnings("deprecation")
	@Then("^validate logged in username$")
	public void validate_logged_in_username() {
		driver.switchTo().frame("mainpanel");
	    boolean flag = homePage.verifyCorrectUserName();
	    Assert.assertTrue(flag);
	}
	
	
}
