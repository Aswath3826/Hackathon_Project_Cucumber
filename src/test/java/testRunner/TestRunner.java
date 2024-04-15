package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = {".//Feature_Files/"}, // all feature files will be executed
					//features = {".//Feature_Files/TS003_Val_GiftCards.feature"},
					//features= {".//Features/Login.feature",".//Features/Registration.feature"},
					//features= {"@target/rerun.txt"}, // only fails execution
					glue = "step_Definitions",//in glue we only specify package and specify specific TestScenario
					plugin= {"pretty", "html:reports/myreport.html", 
					          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
					dryRun=false,   // checks whether scenario steps are associated with step definition methods
					monochrome=true, // avoids junk characters in console window
					publish=true // to publish report in cucumber server
								 // this provides a link for the report which can be view by anyone
								 // this report will be self destruct in a day
					
					//It is equivalent to TestNG groups concept. In cucumber it is "Tagging"
					// tags are added in feature file before the scenario
					//tags="@sanity"  // this will execute scenarios tagged with @sanity
					//tags="@regression"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
					)
public class TestRunner {

}
