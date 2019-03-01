package com.qa.jenkinstests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.jenkinspages.Configure;
import com.qa.jenkinspages.Login;
import com.qa.jenkinspages.NewItem;
import com.qa.jenkinspages.Project;


public class MainTest {

	WebDriver driver;

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

	@Test
	public void createItemTest() {
		driver.get(Login.page);
		Login login = PageFactory.initElements(driver, Login.class);
		login.login();
		login.newItem();
		NewItem item = PageFactory.initElements(driver, NewItem.class);
		item.createNew("SeleniumIsFun");
		Configure cfg = PageFactory.initElements(driver, Configure.class);
		cfg.saveNoChange();
		Project prj = PageFactory.initElements(driver, Project.class);
		prj.back();
		assertEquals("No such item in list", true, login.findItem("SeleniumIsFun"));
	}
}
