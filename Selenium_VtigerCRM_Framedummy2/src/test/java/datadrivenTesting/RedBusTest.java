package datadrivenTesting;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedBusTest {
      @Test
      public void booking() throws InterruptedException {
          ChromeOptions opt = new ChromeOptions();
          opt.addArguments("--disable-notifications");
    	  WebDriver driver = new ChromeDriver(opt);
    	  driver.get("https://www.redbus.in/");
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	  driver.manage().window().maximize();
    	  WebElement activeElement = driver.switchTo().activeElement();
    	  activeElement.sendKeys("Ban");
    	  driver.findElement(By.xpath("(//div[@tabindex='1']/ul/li)[1]")).click();
    	  driver.switchTo().activeElement().sendKeys("tri");
    	  driver.findElement(By.xpath("(//div[@tabindex='2']/ul/li)[1]")).click();
    	  LocalDateTime todaysDateTime = LocalDateTime.now();
    	  int todaysDate = todaysDateTime.getDayOfMonth();
    	  String thismonth = todaysDateTime.getMonth().toString();
    	  String firstWordOfMonth = thismonth.substring(0, 1);
    	  String lastTwoWordOfMonth = thismonth.substring(1, 3).toLowerCase();
    	  int thisYear = todaysDateTime.getYear();
    	  calenderPopup(driver,todaysDate,firstWordOfMonth+lastTwoWordOfMonth,thisYear);
    	  driver.findElement(By.id("search_button")).click();
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	  wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//i[contains(@class,'icon icon-ic')]/following-sibling::span"), 20));
    	  List<WebElement> ratings = driver.findElements(By.xpath("//i[contains(@class,'icon icon-ic')]/following-sibling::span"));
    	  for (WebElement rating : ratings) {
    		  String text = rating.getText();
    		  float florating = Float.parseFloat(text);
              List<WebElement> busnames = driver.findElements(By.xpath("//span[text()='"+florating+"']//ancestor::div[@class='clearfix bus-item']//descendant::div[contains(@class,'travels')]")); 
    		  validateRatings(florating,busnames);
		}
    	   
      }
      public static void calenderPopup(WebDriver driver,int date,String month,int year) {
    	   int i=0;
    	  while(true) {
    		  WebElement currentmonth = driver.findElement(By.xpath("(//div[contains(@class,'DayNavigator__I')])[2]"));
    		  String currentMonthText = currentmonth.getText();
    		  System.out.println(currentMonthText);
    		  String[] mon = new String[11];
    		  mon[i]=currentMonthText;
    		  String monthText = mon[i].substring(0, 8);
    		  i++;
    		  if(monthText.equalsIgnoreCase(month+" "+year)) {
    		  break;
    		  }
    		  driver.findElement(By.xpath("//div[text()='"+year+"']/following-sibling::div")).click();
    	  }
    	  driver.findElement(By.xpath("//span[text()='"+date+"']")).click();  
      }
      public static void validateRatings(float florating,List<WebElement> busnames) {

            if(florating>=4) {
            	getTextFromList(busnames);
            	Assert.assertEquals(florating>=4, true,"green star-ratings are above 4");
            }else if(florating<4 && florating>=3) {
            	getTextFromList(busnames);
            	  Assert.assertEquals(florating<4 && florating>=3, true,"orange star-ratings are between 4 and 3");
            }else if(florating<3 && florating>=2) {
            	getTextFromList(busnames);
            	Assert.assertEquals(florating<3 && florating>=2, true,"red star-ratings are between 3 and 2");
            }else if(florating<2 && florating>=1) {
            	getTextFromList(busnames);
            	Assert.assertEquals(florating<2 && florating>=1, true,"ratings are between 2 and 1");
            }     
      }
      public static void getTextFromList(List<WebElement> busnames) {
    	  for (WebElement busname : busnames) {
      		String bustext = busname.getText();
      		System.out.println(bustext);
			}
      }
}
