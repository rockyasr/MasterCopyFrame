package testngClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
  
public class ListenerPracticeTest extends BaseClass{
    @Test
    public void createOrgTest() {
    	System.out.println("execute createOrgTest");
    	Assert.fail();
    	System.out.println("fail");
    }
    @Test
    public void createOrgWithContact() {
    	System.out.println("execute createOrgWithContact");
    }
}
