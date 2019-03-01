package com.qa.jenkinspages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Project {
	
	@FindBys({ @FindBy(id = "tasks"), @FindBy(css = "a") })
	private List<WebElement> tasks;
	
	public void back() {
		tasks.get(0).click();
	}

}
