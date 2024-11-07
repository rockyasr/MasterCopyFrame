package experimentalExecutionTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class ZeroThreadCount_01 extends BaseClass{
   @Test(groups = "smoke",retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
   public void createOrg() {
	   System.out.println("org is created");
	   SoftAssert softAssert = new SoftAssert();
	   softAssert.assertEquals(false, true);
	   softAssert.assertAll();
   }
   
   @Test(groups = "regression")
   public void createContact() {
	   System.out.println("contact is created");
   }
}
