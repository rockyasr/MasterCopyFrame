package com.comcast.crm.objectRepository.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildWindowOfContactPage {

	public ChildWindowOfContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(id = "search_text"), @FindBy(name = "search_text") })
	private WebElement Searchtxt;

	@FindBy(id = "search_field")
	private WebElement OrgDropDown;

	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	

	public WebElement getSearchtxt() {
		return Searchtxt;
	}

	public WebElement getOrgDropDown() {
		return OrgDropDown;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public void searchOrg(WebDriver driver,String value) {
		Searchtxt.sendKeys(value);
		SearchBtn.click();
		//driver.findElement(By.linkText(value)).click();
	}

	public void searchBtn() {
		SearchBtn.click();
	}
	
	

}
