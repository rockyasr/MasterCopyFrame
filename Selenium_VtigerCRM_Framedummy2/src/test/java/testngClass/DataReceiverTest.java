package testngClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataReceiverTest {
     @Test(dataProviderClass = DataSenderTest.class,dataProvider = "getData")
     public void printData(String firstName,String lastName,long number) {
    	 System.out.println("FirstName : "+firstName+" LastName : "+lastName+" phoneNumber : "+number);
     }
     
     @Test(dataProviderClass = DataSenderTest.class,dataProvider = "getPhoneDataFromExcel")
     public void printPhonePrice(String search,String phoneName) {
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 driver.get("https://www.amazon.in/");
    	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search,Keys.ENTER);
    	 WebElement priceelement = driver.findElement(By.xpath("//span[text()='"+phoneName+"']/ancestor::div[@class='puisg-col-inner']/descendant::span[text()='₹']/following-sibling::span"));
    	 String pricetext = priceelement.getText();
    	 System.out.println(pricetext);
    	 driver.quit();
    	 System.out.println("changes");
     }
     
      
}
