package com.qa.jenkinspages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Manage {

	@FindBys({@FindBy(className = "manage-option"), @FindBy(css = "a")})
	private List<WebElement> options;

	public void manageUsers() {
		options.get(15).click();
	}

}
