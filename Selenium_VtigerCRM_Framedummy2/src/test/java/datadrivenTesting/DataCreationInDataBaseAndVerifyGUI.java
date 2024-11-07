package datadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class DataCreationInDataBaseAndVerifyGUI {
  public static void main(String[] args) throws SQLException {
	 String expectedprojectName = "roocky"; 
	Driver driver1 = new Driver();
	DriverManager.registerDriver(driver1);
	Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
	Statement stat = conn.createStatement();
	int executeUpdate = stat.executeUpdate("insert into project values('TY_PROJ_100233','AASR','03/10/2024','roocky','Created',1)");
	if(executeUpdate==1) {
		System.out.println("Data is added to the DataBase");
	}else {
		System.out.println("Data is not added to the DataBase");
	}
	conn.close();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("http://106.51.90.215:8084/");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
	driver.findElement(By.linkText("Projects")).click();
	WebElement searchbyproject = driver.findElement(By.xpath("//div[@class='row']/div/select"));
	Select select = new Select(searchbyproject);
	select.selectByVisibleText("Search by Project Name");
	driver.findElement(By.xpath("//input[@placeholder='Search by Project Name']")).sendKeys(expectedprojectName);
	String actprojectname = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
	if(actprojectname.equalsIgnoreCase(expectedprojectName)) {
		System.out.println("project is created in GUI");
	}else {
		System.out.println("project is not created in GUI");
	}
}
}
