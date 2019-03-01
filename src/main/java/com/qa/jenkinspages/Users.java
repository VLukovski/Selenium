package com.qa.jenkinspages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Users {

	@FindBy(css = "#tasks > div:nth-child(3) > a.task-link")
	private WebElement create;

	@FindBys({ @FindBy(css = "#main-panel > form > div:nth-child(2) > table > tbody"), @FindBy(css = "input") })
	private List<WebElement> fields;

	@FindBy(css = "#yui-gen1-button")
	private WebElement create2;

	@FindBys({ @FindBy(css = "#people > tbody"), @FindBy(css = "tr > td > a") })
	private List<WebElement> names;

	@FindBy(css = "#tasks > div:nth-child(4) > a.task-link")
	private WebElement configure;

	@FindBy(name = "_.fullName")
	private WebElement nameField;
	
	@FindBy(id = "yui-gen2-button")
	private WebElement savebtn;
	
	@FindBy(css = "#tasks > div:nth-child(1) > a.task-link")
	private WebElement peoplebtn;
	
	@FindBy(css = "#people > tbody > tr")
	private List<WebElement> users;

	public void createUser(String username, String pass, String passConfirm, String name, String email) {
		create.click();
		fields.get(0).sendKeys(username);
		fields.get(1).sendKeys(pass);
		fields.get(2).sendKeys(passConfirm);
		fields.get(3).sendKeys(name);
		fields.get(4).sendKeys(email);
		create2.click();
	}

	public Boolean findItem(String name) {
		return names.stream().map(n -> n.getText()).collect(Collectors.toList()).contains(name);
	}

	public void find(String name) {
		names.get(names.stream().map(n -> n.getText()).collect(Collectors.toList()).indexOf(name)).click();
	}

	public void configure() {
		configure.click();
	}

	public void setName(String name) {
		nameField.clear();
		nameField.sendKeys(name);
	}

	public void save() {
		savebtn.click();
	}
	
	public void people() {
		peoplebtn.click();
	}

	public boolean superFind(String username, String name) {
		return users.get(users.stream().map(n -> n.getAttribute("id")).collect(Collectors.toList()).indexOf("person-" + username)).findElements(By.cssSelector("td")).get(2).getText().equals(name);
	}
}
