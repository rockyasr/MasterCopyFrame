package testngClass;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.crm.listenerUtility.ListenerImpTest.class)
public class ListenerOrderOfExecution extends BaseClass{
    @Test(timeOut = 5000)
    public void listenertest_01() {
    	System.out.println("++++ first test ++++");
    	Assert.fail();
    }
    @Test
    public void listenertest_02() {
    	System.out.println("++++ second test ++++");
    }
    
}
