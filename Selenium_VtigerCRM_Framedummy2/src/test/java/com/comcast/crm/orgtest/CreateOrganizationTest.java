package com.comcast.crm.orgtest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectRepository.utility.CreatingNewOrganisationPage;
import com.comcast.crm.objectRepository.utility.HomePage;
import com.comcast.crm.objectRepository.utility.OrganisationInfromationPage;
import com.comcast.crm.objectRepository.utility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class CreateOrganizationTest extends BaseClass {
	SoftAssert obj=new SoftAssert();
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void createOrganizationTest() throws IOException {

		String organisationName = eutils.readDataFromExcel("org", 1, 2);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String organisationname = organisationName + randomInt;
		HomePage HomePage = new HomePage(driver);
		HomePage.getOrganizationsHeader().click();
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrganization().click();
		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		creatingNewOrganisationPage.createOrg(organisationname);
		OrganisationInfromationPage organisationInfromationPage = new OrganisationInfromationPage(driver);
		String organisationtext = organisationInfromationPage.getOrganisationInfoHeader().getText();
		boolean organisationStatus = organisationtext.contains(organisationname);
		Assert.assertTrue(organisationStatus);

	}
	
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void createOrganisationWithPhoneNumberTest() throws EncryptedDocumentException, IOException {
		String organisationName = eutils.readDataFromExcel("org", 7, 2);
	    String phoneNumber = eutils.readDataFromExcel("org", 7, 3);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String organisationname = organisationName+randomInt;
		HomePage homePage = new HomePage(driver);
		homePage.getOrganizationsHeader().click();
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrganization().click();
		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		creatingNewOrganisationPage.createOrg(organisationname, phoneNumber);
		OrganisationInfromationPage organisationInfromationPage = new OrganisationInfromationPage(driver);
		String phonetext = organisationInfromationPage.getPhoneinfo().getText();
		boolean phoneStatus = phonetext.contains(phoneNumber);
		obj.assertTrue(phoneStatus);
		String organisationtext = organisationInfromationPage.getOrganisationInfoHeader().getText();
		boolean organisationStatus = organisationtext.contains(organisationname);
		Assert.assertTrue(organisationStatus);
		obj.assertAll();
	}
	
	@Test
	public void createOrganisationWithIndustriesTest() throws EncryptedDocumentException, IOException {
		String organisationName = eutils.readDataFromExcel("org", 4, 2);
		String industry = eutils.readDataFromExcel("org", 4, 3);
		String type = eutils.readDataFromExcel("org", 4, 4);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String organisationname = organisationName + randomInt;
		HomePage HomePage = new HomePage(driver);
		HomePage.getOrganizationsHeader().click();
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrganization().click();
	    CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
	    creatingNewOrganisationPage.createOrg(organisationname, industry, type);
        OrganisationInfromationPage organisationInfromationPage = new OrganisationInfromationPage(driver);
        String industrytext = organisationInfromationPage.getIndustryinfo().getText();
    	boolean industryStatus = industrytext.contains(industry);
		obj.assertTrue(industryStatus);
        String typetext = organisationInfromationPage.getTypeinfo().getText();
    	boolean typeStatus = typetext.contains(type);
		obj.assertTrue(typeStatus);
        obj.assertAll();
	}
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void createOrganisationAndDelete() throws EncryptedDocumentException, IOException {
		String organisationName = eutils.readDataFromExcel("org", 1, 2);		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String organisationname = organisationName+randomInt;
		HomePage homePage = new HomePage(driver);
		homePage.getOrganizationsHeader().click();
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrganization().click();
		CreatingNewOrganisationPage creatingNewOrganisationPage = new CreatingNewOrganisationPage(driver);
		creatingNewOrganisationPage.createOrg(organisationname);
		OrganisationInfromationPage organisationInfromationPage = new OrganisationInfromationPage(driver);
		String organisationtext = organisationInfromationPage.getOrganisationNameinfo().getText();
		boolean organisationStatus = organisationtext.contains(organisationname);
		Assert.assertTrue(organisationStatus);
		homePage.getOrganizationsHeader().click();
		
		organizationsPage.searchOrg(organisationname, 1);
		organizationsPage.deleteOrg(driver, organisationname);
	}
}
