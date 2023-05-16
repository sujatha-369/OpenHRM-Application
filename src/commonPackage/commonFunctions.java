package commonPackage;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class commonFunctions {
	
	public static Properties properties = null;
	public static WebDriver driver = null;
	
	static Logger logger = Logger.getLogger(commonFunctions.class);
	
	
	public Properties loadPropertyFile() throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		
		properties = new Properties();
		
		properties.load(fileInputStream);
		
		return properties;	
		
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException
	{
		PropertyConfigurator.configure("log4j.properties");
		loadPropertyFile();
		logger.info("Loading the Property file");
		
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverLocation = properties.getProperty("DriverLocation");
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
		  	System.setProperty("webdriver.chrome.driver",driverLocation);
			driver = new ChromeDriver();
			logger.info("Launching Chrome");
			
		}
		else if (browser.equalsIgnoreCase("fireFox"))
		{
			System.getProperty("webdriver.gecko.driver",driverLocation);
			driver = new FirefoxDriver();
			logger.info("Launching FireFox");
		}
 				
		driver.manage().window().maximize();
		logger.info("Navigating the Applications");
		driver.get(url);

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
	}
	
	@AfterSuite
	public void tearDown()
	{
		logger.info("Excution Done, Closing the Browser");
		driver.quit();
	}
	
	

}
