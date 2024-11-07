package testngClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleExtentReport {
	ExtentReports report;
	  @BeforeSuite
	  public void configReport() {
			 ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
	    	 spark.config().setDocumentTitle("CRM Test Suite Results");
	    	 spark.config().setReportName("CRM Report");
	    	 spark.config().setTheme(Theme.DARK);
	    	 
	    	 report =new ExtentReports();
	    	 report.attachReporter(spark);
	    	 report.setSystemInfo("OS", "Window-11");
	    	 report.setSystemInfo("BROWSER", "CHROME-118.0.5993.71"); 
	  }
	  
	  @AfterSuite
	  public void flushReport() {
		  report.flush(); 
	  }
      @Test
      public void createContactTest() {
    	 ExtentTest test = report.createTest("create ContactTest");
    	 test.log(Status.INFO,"login to app");
    	 test.log(Status.INFO, "navigate to contact page");
    	 test.log(Status.INFO,"create contact");
    	 if("HDFC".equals("HDFC")) {
    		 test.log(Status.PASS,"contact is created");
    	 }else {
    		 test.log(Status.FAIL,"contact is not created");
    	 }
    	 
      }
      @Test
      public void createContactWithOrgTest() {
    	 ExtentTest test = report.createTest("create ContactTest");
    	 test.log(Status.INFO,"login to app");
    	 test.log(Status.INFO, "navigate to contact page");
    	 test.log(Status.INFO,"create contact");
    	 if("ICICI".equals("ICICI")) {
    		 test.log(Status.PASS,"contact is with org created");
    	 }else {
    		 test.log(Status.FAIL,"contact is not with org created");
    	 } 
      }
      @Test
      public void createContactWithPhonenumberTest() {
    	 ExtentTest test = report.createTest("create ContactTest");
    	 test.log(Status.INFO,"login to app");
    	 test.log(Status.INFO, "navigate to contact page");
    	 test.log(Status.INFO,"create contact");
    	 if("SBI".equals("SBI")) {
    		 test.log(Status.PASS,"contact is created with phonenumber");
    	 }else {
    		 test.log(Status.FAIL,"contact is not with phonenumber created");
    	 }
    	 
      }
}
