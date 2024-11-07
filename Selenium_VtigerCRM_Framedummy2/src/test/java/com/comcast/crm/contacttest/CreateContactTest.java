package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectRepository.utility.ContactInformationPage;
import com.comcast.crm.objectRepository.utility.ContactsPage;
import com.comcast.crm.objectRepository.utility.CreatingNewContactPage;
import com.comcast.crm.objectRepository.utility.CreatingNewOrganisationPage;
import com.comcast.crm.objectRepository.utility.HomePage;
import com.comcast.crm.objectRepository.utility.OrganisationInfromationPage;
import com.comcast.crm.objectRepository.utility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class CreateContactTest extends BaseClass {
	SoftAssert obj=new SoftAssert();
	@Test(groups = "smokeTest",retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
   public void createContactTest()throws IOException, InterruptedException {
	    String lastName = eutils.readDataFromExcel("contact", 1, 2);		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String lastname = lastName+randomInt;
		
		HomePage HomePage = new HomePage(driver);
		HomePage.getContactsHeader().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ContactsPage contactsPage = new ContactsPage(driver);
		
		contactsPage.getCreateContact().click();
		wait.until(ExpectedConditions.elementToBeClickable(contactsPage.getCreateContact()));
		contactsPage.getCreateContact().click();
		
		CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
		creatingNewContactPage.createContact(lastname);
		
		ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
		String lastnametext = contactInformationPage.getLastNameinfo().getText();
		boolean lastnamestatus = lastnametext.contains(lastname);
		Assert.assertTrue(lastnamestatus);
      }
	
	@Test(groups ="regressionTest",retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void createContactWithOrganisationTest() throws EncryptedDocumentException, IOException {
		String lastName = eutils.readDataFromExcel("contact", 7, 2);
	    String organisationName = eutils.readDataFromExcel("contact", 7, 3);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String lastname = lastName+randomInt;
		String organisationname=organisationName+randomInt;
		
		
		HomePage HomePage = new HomePage(driver);
		HomePage.getOrganizationsHeader().click();
		
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrganization().click();
		
		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		creatingNewOrganisationPage.createOrg(organisationname);
		
		OrganisationInfromationPage organisationInfromationPage = new OrganisationInfromationPage(driver);
		String OrganisationInfoHeadertext = organisationInfromationPage.getOrganisationInfoHeader().getText();
		organisationInfromationPage.verify(OrganisationInfoHeadertext, organisationName);
		
		HomePage.getContactsHeader().click();
		
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContact().click();
		
		CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
		creatingNewContactPage.createContact(driver, lastname, organisationname);
	
	    ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
	    String lastNametext = contactInformationPage.getLastNameinfo().getText();
	    boolean lastnamestatus = lastNametext.contains(lastname);
		Assert.assertTrue(lastnamestatus);
	   
	    String organisationNametext = contactInformationPage.getOrganisationNameinfo().getText();
	    boolean organisationStatus = organisationNametext.contains(organisationname);
	    obj.assertTrue(organisationStatus);
	    obj.assertAll();
	  }
	
	   @Test(groups = "regressionTest",retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	   public void createContactWithSupportStartDateTest() throws EncryptedDocumentException, IOException {
		    String lastName = eutils.readDataFromExcel("contact", 1, 2);		
			Random random = new Random();
			int randomInt = random.nextInt(1000);
			String lastname = lastName+randomInt;
			
		    HomePage HomePage = new HomePage(driver);
			HomePage.getContactsHeader().click();
			
			ContactsPage contactsPage = new ContactsPage(driver);
			contactsPage.getCreateContact().click();
			contactsPage.getCreateContact().click();
			
			CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
			String current_Date=jutils.getSystemDateYYYY_MM_dd();
			String endDate = jutils.getRequiredDateYYYY_MM_dd(30);
			creatingNewContactPage.createContact(lastname,current_Date ,endDate );
			
			ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
			String lastnametext = contactInformationPage.getLastNameinfo().getText();
			boolean lastnamestatus = lastnametext.contains(lastname);
			Assert.assertTrue(lastnamestatus);
			String supportstartdatetext = contactInformationPage.getSupportStartdateinfo().getText();
			boolean startDateStatus = supportstartdatetext.contains(jutils.getSystemDateYYYY_MM_dd());
		    obj.assertTrue(startDateStatus);
			String supportEnddatetext = contactInformationPage.getSupportEnddateinfo().getText();
			boolean endDateStatus = supportEnddatetext.contains(supportEnddatetext);
			obj.assertTrue(endDateStatus);
			obj.assertAll();
	   }
}
