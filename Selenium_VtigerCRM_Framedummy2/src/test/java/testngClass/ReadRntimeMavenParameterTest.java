package testngClass;

import org.testng.annotations.Test;

public class ReadRntimeMavenParameterTest {
   @Test
   public void runTimeParameterTest() {
	   String url = System.getProperty("url");
	   System.out.println("testng test url ====>"+url);
   }
}
