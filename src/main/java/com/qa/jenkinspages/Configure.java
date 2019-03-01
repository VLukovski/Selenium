package com.qa.jenkinspages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Configure {
	
	@FindBy(id = "yui-gen38-button")
	private WebElement save;

	public void saveNoChange() {
		save.click();
	}
}
