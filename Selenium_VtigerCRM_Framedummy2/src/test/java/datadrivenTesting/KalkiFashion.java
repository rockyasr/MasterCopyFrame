package datadrivenTesting;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class KalkiFashion {
      public static void main(String[] args)throws EncryptedDocumentException, IOException, InterruptedException {
          ChromeOptions opt = new ChromeOptions();
          opt.addArguments("--disable-notifications");
    	  WebDriver driver = new ChromeDriver(opt);
    	  driver.manage().window().maximize();
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	  driver.get("https://www.kalkifashion.com/");
    	  driver.findElement(By.xpath("//button[text()='OK']")).click();
    	  FileInputStream file = new FileInputStream("./src/test/resources/kalkiFashiondata.xlsx");
    	  Workbook workbook = WorkbookFactory.create(file);
    	  Sheet sheet = workbook.getSheet("kalki");
    	  String data1 = sheet.getRow(1).getCell(0).getStringCellValue();
    	  String data2 = sheet.getRow(2).getCell(0).getStringCellValue();
    	  Actions act = new Actions(driver);
    	  WebElement accounticon = driver.findElement(By.xpath("//div[text()='Search for Style, Collections & more']"));
    	  act.moveToElement(accounticon).perform();
    	  accounticon.click();
    	  WebElement searchtextfield = driver.findElement(By.xpath("//input[@id='search-input']"));
    	  searchtextfield.click();
    	  searchtextfield.sendKeys(data1,Keys.ENTER);
    	  Thread.sleep(3000);
    	 driver.findElement(By.xpath("//a[@id='wishlist-item']/preceding-sibling::div/div[@id='customer-menu']")).click();
    	 driver.findElement(By.xpath("//div[@id='login_content_wraper']/button[@id='user_close_popup']")).click();

    	 WebElement mensuit = driver.findElement(By.xpath("//div[@id='searchResultsWrapper']/div/div//child::div[@class='UNX-product-content']/a/h3[text()='Beige Jodhpuri Suit With Self Work Embroidery For Men']"));
    	 
    	 act.moveToElement(mensuit).perform();
    	 mensuit.click();
    	 
    	 
    	Set<String> windids = driver.getWindowHandles();
    	for (String windid : windids) {
			String title = driver.switchTo().window(windid).getTitle();
			if(title.contains("Buy Beige Jodhpuri Suit With Self Work Embroidery For Men")) {
				  System.out.println("===window is switched===");
				  WebElement size = driver.findElement(By.xpath("//div[text()='38']"));
				  act.moveToElement(size).perform();
				  size.click();
			      driver.findElement(By.xpath("//button[@title='Add to Cart']")).submit();
			}
		}
    	String text = driver.findElement(By.xpath("//div[text()='Grand Total']/parent::div/div[text()='₹20,999.00']")).getText();
    	System.out.println(text);
    	sheet.getRow(1).createCell(1,CellType.STRING).setCellValue(text);
    	sheet.getRow(1).createCell(2,CellType.STRING).setCellValue("added");
    	FileOutputStream f = new FileOutputStream("./src/test/resources/kalkiFashiondata.xlsx");
    	workbook.write(f);
    	driver.findElement(By.xpath("//div[text()='Search for Style, Collections & more']")).click();
  	    searchtextfield.click();
  	  searchtextfield.sendKeys(data2,Keys.ENTER);
    	
    	workbook.close();
    	  
      }
}
