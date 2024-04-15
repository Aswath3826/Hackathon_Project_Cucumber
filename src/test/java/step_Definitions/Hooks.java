package step_Definitions;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.Base_Class;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base_Class{
	
	@Before
	public void setup() throws MalformedURLException {
		
		new Base_Class().setup();			
	}
	
	@After
	public void close(Scenario scenario) throws IOException {
				
		TakesScreenshot ts=(TakesScreenshot) Base_Class.driver;
    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshot, "image/png",scenario.getName());
	    Base_Class.driver.quit();		
	}
	
}
