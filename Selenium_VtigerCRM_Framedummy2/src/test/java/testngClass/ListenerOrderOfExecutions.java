package testngClass;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ListenerOrderOfExecutions extends BaseClass {
  @Test
  public void listenerTest_03() {
	  System.out.println("++++ Third Test +++++");
  }
  @Test
  public void listenerTest_04() {
	  System.out.println("++++ Fourth Test ++++");
  }
}
