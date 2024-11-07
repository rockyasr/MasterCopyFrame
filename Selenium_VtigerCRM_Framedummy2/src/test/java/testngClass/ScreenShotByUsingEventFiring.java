package testngClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScreenShotByUsingEventFiring {
    @SuppressWarnings("deprecation")
	@Test
    public void screenshotByEventfiring() throws IOException {
    	ChromeDriver driver = new ChromeDriver();
    	driver.get("https://www.amazon.in/");
    	EventFiringWebDriver efWebDriver = new EventFiringWebDriver(driver);
    	File srcfile = efWebDriver.getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(srcfile, new File("./screenshot/test.png"));
    }
}
