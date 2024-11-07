package testngClass;

import org.testng.annotations.Test;

public class UnderstandingTestNG {
    @Test
    public void testngNonStaticMethod() {
    	System.out.println("i will create object");
    }
    
    @Test
    public static void testngStaticMethod() {
    	System.out.println("i am with in the class");
    }
    
    
    public static void main() {
    	System.out.println("i am st");
    }
    
    public void home() {
    	System.out.println("i am non");
    }
    public static void main(String[] args) {
    	UnderstandingTestNG understandingTestNG = new UnderstandingTestNG();
    	understandingTestNG.home();
    	UnderstandingTestNG.main();
	}
}
