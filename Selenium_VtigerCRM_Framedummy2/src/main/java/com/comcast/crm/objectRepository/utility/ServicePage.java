package com.comcast.crm.objectRepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Create POM Class
public class ServicePage {

	// Object Initialisation
	public ServicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Object Creation

	@FindBy(name = "search_text")
	private WebElement SearchService;

	@FindBy(name = "submit")
	private WebElement SearchBtn;

	@FindAll({ @FindBy(id = "bas_searchfield"), @FindBy(name = "search_field") })
	private WebElement ServiceDropDown;

	@FindBy(xpath = "//img[@alt='Create Service...']")
	private WebElement CreateService;

	@FindBy(partialLinkText = "Advanced")
	private WebElement AdvanceSearch;

	// Genarate Getters

	public WebElement getSearchContact() {
		return SearchService;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getCreateContact() {
		return CreateService;
	}

	public WebElement getAdvanceSearch() {
		return AdvanceSearch;
	}

	// Business Methods

	public void createService() {
		CreateService.click();
	}

	public void searchService(String OrgName) {
		SearchService.sendKeys(OrgName);
	}

	public void searchButton() {
		SearchBtn.click();
	}

}
