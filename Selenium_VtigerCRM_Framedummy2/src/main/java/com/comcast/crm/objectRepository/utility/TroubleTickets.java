package com.comcast.crm.objectRepository.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TroubleTickets {
	
	public TroubleTickets(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Ticket...']")
	private WebElement createTicket;
	
	
	public WebElement getCreateTicket() {
		return createTicket;
	}
	
	

}
