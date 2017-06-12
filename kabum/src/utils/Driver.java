package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	
	protected WebDriver driver;
	
	protected WebDriver newDriver(){
		
		WebDriver driver;
		
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "\\drivers\\chromedriver-2.25.exe");
		
		options.addArguments("chrome.switches","--disable-extensions");
		options.addArguments("chrome.switches","--start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(capabilities);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	protected void closeDriver(WebDriver driver){
		driver.close();
		driver.quit();
	}
	
}
