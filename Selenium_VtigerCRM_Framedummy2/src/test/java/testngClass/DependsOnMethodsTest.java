package testngClass;

import org.testng.annotations.Test;

public class DependsOnMethodsTest {
	
       @Test
       public void test_1() {
    	   System.out.println("i am test_1");
       }
       
       @Test
       public void test_3() {
    	   System.out.println("i am test_3 ");
       }
       
       @Test(dependsOnMethods = {"test_1","test_3"})
       public void test_2() {
    	   System.out.println("i am test_2 and i depends on test_1 and test_3");
       }
}
