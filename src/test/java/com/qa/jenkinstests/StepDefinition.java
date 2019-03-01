package com.qa.jenkinstests;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.jenkinspages.Login;
import com.qa.jenkinspages.Users;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	WebDriver driver;
	Users users;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		driver.get(arg1);
		Login login = PageFactory.initElements(driver, Login.class);
		login.login();
	}

	@Given("^the username is present \"([^\"]*)\"$")
	public void the_username_is_present(String arg1) {
		users = PageFactory.initElements(driver, Users.class);
		users.findItem(arg1);
	}

	@When("^I click on username \"([^\"]*)\"$")
	public void i_click_on_username(String arg1) {
		users = PageFactory.initElements(driver, Users.class);
		users.find(arg1);
		
	}

	@When("^I click on configure link$")
	public void i_click_on_configure_link() {
		users = PageFactory.initElements(driver, Users.class);
		users.configure();
	}

	@When("^change the current fullname to new a new fullname \"([^\"]*)\"$")
	public void change_the_current_fullname_to_new_a_new_fullname(String arg1) {
		users = PageFactory.initElements(driver, Users.class);
		users.setName(arg1);
	}

	@When("^I click save button$")
	public void i_click_save_button() {
		users = PageFactory.initElements(driver, Users.class);
		users.save();
	}

	@When("^I click on People link$")
	public void i_click_on_People_link() {
		users = PageFactory.initElements(driver, Users.class);
		users.people();
	}

	@Then("^the new fullname \"([^\"]*)\" should be visible for the username \"([^\"]*)\"$")
	public void the_new_fullname_should_be_visible_for_the_username(String arg1, String arg2) {
		users = PageFactory.initElements(driver, Users.class);
		assertEquals("Wrong name", true, users.superFind(arg2, arg1));
	}
}
