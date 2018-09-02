package stepDefinitions;

import SeleniumPages.Page_TimerTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefs {
	
	Page_TimerTest timerHomepage = new Page_TimerTest();
	
	@Given("^I launch Chrome browser$")
	public void i_launch_Chrome_browser() throws Throwable {
	  System.out.println("Launching the browser");
	  timerHomepage.launchBrowser();
	}

	@When("^I open timer Homepage$")
	public void i_open_Google_Homepage() throws Throwable {
		timerHomepage.openTimerURL();
		System.out.println("Opening the e.ggtimer website");
	}

	@Then("^I verify that the page displays search text box$")
	public void i_verify_that_the_page_displays_search_text_box() throws Throwable {
		timerHomepage.checktimerBoxIsDisplayed();
		
	}
	

	@Then("^the page displays Go button$")
	public void the_page_displays_Google_Search_button() throws Throwable {
		timerHomepage.checkGoButtonIsDisplayed();
		
	}

	@Then("^the welcome message is shown$")
	public void the_welcome_message_is_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Welcome messgae");
	}

	@Given("^I am on the Home Page$")
	public void i_am_on_the_Home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		timerHomepage.launchBrowser();
		timerHomepage.openTimerURL();		
		System.out.println("I am on the Timer Home Page");
	}

	@When("^I validate the text box value$")
	public void i_validate_the_text_box_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hima6");
	}

	@Then("^I should see the default value$")
	public void i_should_see_the_default_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hima7");
	}


	@Given("^I enter the (\\d+) in the text box$")
	public void i_enter_the_in_the_text_box(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		timerHomepage.entertimervalue(arg1);
		//System.out.println("Entered value :"arg1);
	}

	@Given("^I click on Go Button$")
	public void i_click_on_Go_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		timerHomepage.clickongo();
		System.out.println("I clicked on Go button");
	}

	@When("^I validate after (\\d+) seconds$")
	public void i_validate_after_seconds(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		timerHomepage.validatetimertun(arg1);
		
	}

	@Then("^Timer should stop$")
	public void timer_should_stop() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		timerHomepage.closethebrowser();
		System.out.println("Test Is successfull");
	}

	@Given("^I verify the title is \"([^\"]*)\"$")
	public void i_verify_the_title_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    timerHomepage.welcomemessage(arg1);
	   
	}
	
	@Then("^test passes$")
	public void test_passes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Test Is successfull");
	    timerHomepage.closethebrowser();
	}
}
