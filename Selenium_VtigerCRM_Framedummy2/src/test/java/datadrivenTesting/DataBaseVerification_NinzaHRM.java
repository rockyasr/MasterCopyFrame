package datadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class DataBaseVerification_NinzaHRM {
    public static void main(String[] args) throws SQLException {
    	String projectName="ASR_01";
    	boolean flag=false;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://106.51.90.215:8084/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("AS RANJITH");
		WebElement projectstatus = driver.findElement(By.xpath("//label[text()='Project Status ']/parent::div/select"));
		Select projectStatusDropdown = new Select(projectstatus);
		projectStatusDropdown.selectByVisibleText("On Going");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("====done====");
		Statement stat = conn.createStatement();
		ResultSet resultset = stat.executeQuery("select * from project");
		while(resultset.next()) {
			String actproject = resultset.getString(4);
			if(projectName.equalsIgnoreCase(actproject)) {
				flag=true;
			System.out.println(projectName+"is available db=PASS");	
			}
		}
		if(flag==false) {
			System.out.println(projectName+"is not available db=FAIL");
		}
		conn.close();
		
		
	}
}
