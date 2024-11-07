package datadrivenTesting;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class InProperties {
	@Test
    public void orgTest()throws IOException, ParseException {
    	

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/resources/jsoncommondata.json"));
		JSONObject map = (JSONObject)obj;
		String BROWSER = map.get("browser").toString();
		String URL = map.get("url").toString();
		String USERNAME = map.get("username").toString();
		String PASSWORD = map.get("password").toString();
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td[@align='center']/a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		List<WebElement> textfields = driver.findElements(By.xpath("//td/b[text()='Organization Information']/ancestor::table[@class='small']/tbody/tr/td[@class='dvtCellLabel']/following-sibling::td/input[@type='text']"));
		WebElement a[]=new WebElement[textfields.size()];
		System.out.println(textfields.size());
		int i=0;
		for (WebElement textfield : textfields) {
			a[i]=textfield;
			i++;
		}
		a[0].sendKeys("techpyramid");
		a[2].sendKeys("www.techpyramid.in");
		a[3].sendKeys("1234567890");
		a[4].sendKeys("FNB");
		a[5].sendKeys("555-56567655");
		a[7].sendKeys("9791633487");
		a[8].sendKeys("100");
		a[9].sendKeys("techpyramid@gmail.com");
		a[10].sendKeys("testyendra@gmail.com");
		a[11].sendKeys("girish");
		a[12].sendKeys("7011");
		a[13].sendKeys("100000000");
		a[14].sendKeys("kathreguppe");
		a[15].sendKeys("kathreguppe");
		a[16].sendKeys("bengaluru");
		a[17].sendKeys("bengaluru");
		a[18].sendKeys("karnataka");
		a[19].sendKeys("karnataka");
		a[20].sendKeys("560085");
		a[21].sendKeys("560085");
		a[22].sendKeys("india");
		a[23].sendKeys("india");
		driver.quit();
		
		
		
		
		
		
	}   
}
