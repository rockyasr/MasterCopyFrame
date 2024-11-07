package testngClass;

import org.testng.annotations.Test;

public class PriorityTest {
	
      @Test(priority = -1)
      public void test_1() {
    	  System.out.println("priority is -1");
      }
      
      @Test(priority = 0)
      public void test_3() {
    	  System.out.println("priority is 0");
      }
      
      @Test          //default value of priority is 0 and it will execute based on alphabetical order
      public void test_2() {
    	  System.out.println("priority is ");
      }
}
