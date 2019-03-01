package com.qa.jenkinspages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewItem {
	
	@FindBy(id = "name")
	private WebElement name;
	
	@FindBy(css = "#j-add-item-type-standalone-projects > ul > li.hudson_model_FreeStyleProject")
	private WebElement type;
	
	@FindBy(id = "ok-button")
	private WebElement ok;
	
	public void createNew(String aName) {
		name.sendKeys(aName);
		type.click();
		ok.click();
	}

}
