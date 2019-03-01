package com.qa.jenkinspages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Login {
	
	public static String page = "http://localhost:8081";

	@FindBys({ @FindBy(css = "body > div > div > form"), @FindBy(css = "input") })
	private List<WebElement> form;

	@FindBys({ @FindBy(id = "tasks"), @FindBy(css = ".task-link") })
	private List<WebElement> tasks;

	@FindBys({ @FindBy(id = "projectstatus"), @FindBy(css = ".model-link.inside") })
	private List<WebElement> itemNames;

	public void login() {
		form.get(0).sendKeys("VLukovski");
		form.get(1).sendKeys("admin");
		form.get(3).click();
	}

	public void newItem() {
		tasks.get(0).click();
	}
	
	public void manage() {
		tasks.get(3).click();
	}

	public Boolean findItem(String name) {
		return itemNames.stream().map(n -> n.getText()).collect(Collectors.toList()).contains(name);
	}
}
