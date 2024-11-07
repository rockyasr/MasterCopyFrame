package com.comcast.crm.producttest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectRepository.utility.CreatingNewProductPage;
import com.comcast.crm.objectRepository.utility.HomePage;
import com.comcast.crm.objectRepository.utility.ProductInformationPage;
import com.comcast.crm.objectRepository.utility.ProductsPage;
@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class CreatingProductTest extends BaseClass{
	
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
   public void creatingProductTest()throws IOException {
	  
		String productName = eutils.readDataFromExcel("product", 1, 4);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String productname = productName+randomInt;
		HomePage homePage = new HomePage(driver);
		homePage.getProductsHeader().click();
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.getCreateProduct().click();
		
		CreatingNewProductPage creatingNewProductPage = new CreatingNewProductPage(driver);
		creatingNewProductPage.createProduct(productname);
		
		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		String producttext = productInformationPage.getProductinfo().getText();
		productInformationPage.verify(producttext, productname);
		
     }
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void creatingProductWithCategoryTest() throws EncryptedDocumentException, IOException {
		String productName = eutils.readDataFromExcel("product", 1, 4);
		String productType = eutils.readDataFromExcel("product", 1, 5);
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String productname = productName+randomInt;
		
		HomePage homePage = new HomePage(driver);
		homePage.getProductsHeader().click();
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.getCreateProduct().click();
		CreatingNewProductPage creatingNewProductPage = new CreatingNewProductPage(driver);
		creatingNewProductPage.createProduct(productname, productType);
		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		String producttext = productInformationPage.getProductinfo().getText();
		productInformationPage.verify(producttext, productname);
		String productCategorytext = productInformationPage.getProductCategortinfo().getText();
		productInformationPage.verify(productCategorytext, productType);
	}
}
