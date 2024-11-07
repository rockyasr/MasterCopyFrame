package com.comcast.crm.leadtest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.UtilityClassObject;
import com.comcast.crm.objectRepository.utility.CreateNewLeadPage;
import com.comcast.crm.objectRepository.utility.HomePage;
import com.comcast.crm.objectRepository.utility.LeadInformationPage;
import com.comcast.crm.objectRepository.utility.LeadsPage;

/** Test class for creating leads module
 * @author RanjithAS
 */

@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class CreateLeadTest extends BaseClass {
	SoftAssert obj = new SoftAssert();

	@Test(groups = "smokeTest", retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void createLeadTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = eutils.readDataFromExcel("leads", 1, 2);
		String company = eutils.readDataFromExcel("leads", 1, 3);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String organisation = company + randomInt;
		UtilityClassObject.getTest().log(Status.INFO, "navigate to leads Page");
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsHeader().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create leads page");
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLead().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to new leads page");
		CreateNewLeadPage createNewLeadPage = new CreateNewLeadPage(driver);
		createNewLeadPage.createLead(lastName, organisation);
		UtilityClassObject.getTest().log(Status.INFO, "create a new lead");
		LeadInformationPage leadInformationPage = new LeadInformationPage(driver);
		String lastNametext = leadInformationPage.getLastNameinfo().getText();
		boolean lastnameStatus = lastNametext.contains(lastName);
		Assert.assertTrue(lastnameStatus);
		Assert.fail();
		String companytext = leadInformationPage.getCompanyinfo().getText();
		boolean companyStatus = companytext.contains(company);
		Assert.assertTrue(companyStatus);

	}

	@Test(groups = "regressionTest", retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void createLeadWithIndustryTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = eutils.readDataFromExcel("leads", 7, 2);
		String company = eutils.readDataFromExcel("leads", 7, 3);
		String industry = eutils.readDataFromExcel("leads", 7, 4);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String organisation = company + randomInt;
		UtilityClassObject.getTest().log(Status.INFO, "navigate to leads Page");
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsHeader().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create leads page");
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLead().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to new leads page");		
		CreateNewLeadPage createNewLeadPage = new CreateNewLeadPage(driver);
		createNewLeadPage.getLastNameText().sendKeys(lastName);
		createNewLeadPage.getCompanyTextField().sendKeys(organisation);

		WebElement industryDropDown = createNewLeadPage.getIndustryDropDown();
		WebDriverUtility webutils = new WebDriverUtility();
		webutils.selectByVisibleText(industryDropDown, industry);
		createNewLeadPage.getSaveButton().click();

		LeadInformationPage leadInformationPage = new LeadInformationPage(driver);
		String lastNametext = leadInformationPage.getLastNameinfo().getText();
		boolean lastnameStatus = lastNametext.contains(lastName);
		Assert.assertTrue(lastnameStatus);
		String companytext = leadInformationPage.getCompanyinfo().getText();
		boolean companyStatus = companytext.contains(company);
		Assert.assertTrue(companyStatus);
		String industrytext = leadInformationPage.getIndustryinfo().getText();
		boolean industryStatus = industrytext.contains(industry);
		obj.assertTrue(industryStatus);
		obj.assertAll();
	}

	@Test(groups = "regressionTest", retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void createLeadWithLeadsourceTest() throws EncryptedDocumentException, IOException {
		String lastName = eutils.readDataFromExcel("leads", 4, 2);
		String company = eutils.readDataFromExcel("leads", 4, 3);
		String leadSource = eutils.readDataFromExcel("leads", 4, 4);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String organisation = company + randomInt;

		HomePage homePage = new HomePage(driver);
		homePage.getLeadsHeader().click();
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLead().click();

		CreateNewLeadPage createNewLeadPage = new CreateNewLeadPage(driver);
		createNewLeadPage.getLastNameText().sendKeys(lastName);
		createNewLeadPage.getCompanyTextField().sendKeys(organisation);

		WebElement leadSourceDropDown = createNewLeadPage.getLeadSourceDropDown();
		WebDriverUtility webutils = new WebDriverUtility();

		webutils.selectByVisibleText(leadSourceDropDown, leadSource);
		createNewLeadPage.getSaveButton().click();

		LeadInformationPage leadInformationPage = new LeadInformationPage(driver);
		String lastNametext = leadInformationPage.getLastNameinfo().getText();
		boolean lastnameStatus = lastNametext.contains(lastName);
		Assert.assertTrue(lastnameStatus);
		String companytext = leadInformationPage.getCompanyinfo().getText();
		boolean companyStatus = companytext.contains(company);
		Assert.assertTrue(companyStatus);
		String leadSourcetext = leadInformationPage.getLeadSourceinfo().getText();
		boolean leadsourceStatus = leadSourcetext.contains(leadSource);
		obj.assertTrue(leadsourceStatus);
		obj.assertAll();
	}

}
