package datadrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenInDemoWebShop {
    public static void main(String[] args) throws InterruptedException {
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//form/input[@type='text']")).sendKeys("laptop");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='1590.00']/parent::div/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Qty.:']/parent::td/input")).sendKeys("3");
	}
}
