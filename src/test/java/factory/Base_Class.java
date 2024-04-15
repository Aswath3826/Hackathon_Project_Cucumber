package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Scenario;
import pageObject.BookShelves_Page;
import pageObject.GiftCards_Page;
import pageObject.Home_Page;

public class Base_Class {
	public static WebDriver driver;
	public static FileInputStream file;
	public static Properties p = new Properties();
	public static Logger logger;
	public static Home_Page hp;
	public static BookShelves_Page bp;
	public static GiftCards_Page gp;
	
	public void setup() throws MalformedURLException
	{
		//loading properties file
		try
		{
			file = new FileInputStream("C:\\Users\\2318646\\eclipse-workspace\\Hackathon_Project_Cucumber\\src\\test\\resources\\config.properties");
			p.load(file);
		}
		catch(Exception e)
		{
			System.out.println("File not Found");
		}
		//loading log4j 
	    logger=LogManager.getLogger(this.getClass());//Log4j
	    logger.info("-----------Driver setup done with "+p.getProperty("browser")+" browser------------------");
	    
	    if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{
	    	DesiredCapabilities capabilities=new DesiredCapabilities();
		
			//os
			if(p.getProperty("os").equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(p.getProperty("os").equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
		
			//browser
			if(p.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				capabilities.setBrowserName("chrome");
			}
			else if(p.getProperty("browser").equalsIgnoreCase("edge"))
			{
				capabilities.setBrowserName("MicrosoftEdge");
			}
		
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
       }
	   else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	   {
		   //launching browser based on condition - locally
		   if(p.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(p.getProperty("browser").equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
			}
	   }
	   hp = new Home_Page(driver);
	   bp = new BookShelves_Page(driver);
	   gp = new GiftCards_Page(driver);
	   driver.get(p.getProperty("baseURL"));
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}	
}
