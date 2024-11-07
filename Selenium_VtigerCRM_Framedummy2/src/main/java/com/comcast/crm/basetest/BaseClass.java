package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.UtilityClassObject;
import com.comcast.crm.objectRepository.utility.HomePage;
import com.comcast.crm.objectRepository.utility.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public DataBaseUtility dbUtilis=new DataBaseUtility();   
    public ExcelUtility eutils = new ExcelUtility();
	public FileUtility futils=new  FileUtility();
	public WebDriverUtility wutils=new WebDriverUtility();
	public JavaUtility jutils =new JavaUtility();
	
	
    @BeforeSuite(groups = {"smokeTest","regressionTest"})
    public void connectToDB() throws SQLException {
    	Reporter.log("=====connected to DB=======",true);
    	dbUtilis.getDbConnection();	
    }
    
    @Parameters("BROWSER")
    @BeforeClass(groups = {"smokeTest","regressionTest"})
       public void launchBrowser(@Optional("chrome") String browser) throws IOException {
		String URL = futils.readDataFromPropertyFile("url");
    	String BROWSER=browser;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			Reporter.log("====CHROME IS LAUNCHED SUCCESSFULLY====",true);
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		wutils.waitForPageToLoad(driver, 15);
		driver.manage().window().maximize();
		driver.get(URL);
		
    }
    
    @BeforeMethod(groups = {"smokeTest","regressionTest"})
    public void login() throws IOException {
    	LoginPage login = new LoginPage(driver);
    	String USERNAME = futils.readDataFromPropertyFile("username");
		String PASSWORD = futils.readDataFromPropertyFile("password");
    	login.loginPage(USERNAME, PASSWORD);
    	Reporter.log("======Login is Successfull=====",true);
    }
    
    @AfterMethod(groups = {"smokeTest","regressionTest"})
    public void logout() {
    	HomePage homepage=new HomePage(driver);
    	homepage.signOut();
    	Reporter.log("=====Logout is Successfull=====",true);
    }
    
    @AfterClass(groups = {"smokeTest","regressionTest"})
    public void closeBrowser() {
    	driver.quit();
    	Reporter.log("=====BROWSER IS CLOSED======",true);
    }
    
    @AfterSuite(groups = {"smokeTest","regressionTest"})
    public void closeDB() {
    	dbUtilis.closeDbConnection();
    	Reporter.log("=====database is closed=====",true);
    }
}
