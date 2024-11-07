package experimentalExecutiont_01test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ZeroThreadCount_02 extends BaseClass {
  @Test(groups = "smoke")
  public void createLead() {
	  System.out.println("lead is created");
  }
  @Test(groups = "regression")
  public void createProduct() {
	  System.out.println("product is created");
  }
}
