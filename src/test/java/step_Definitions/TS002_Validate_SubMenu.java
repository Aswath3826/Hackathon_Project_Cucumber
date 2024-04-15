package step_Definitions;

import org.junit.Assert;

import factory.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS002_Validate_SubMenu extends Base_Class{
	
	@Given("the user close the popup")
	public void the_user_close_the_popup() {
		logger.debug(".......Application Logs Started for TC_002.......");
		logger.info("**** Start TC_002_Validate_SubMenu ****");
		try
		{
			bp.click_pop_up_close();
			logger.info("Closed PopUp");
		}
		catch(Exception e)
		{
			
		}
	}

	@When("the user clicks on the LivingStorage Option")
	public void the_user_clicks_on_the_living_storage_option() {
		hp.click_living();
		logger.info("Clicked Living");
	}

	@Then("the user should able to see the submenu present under that option")
	public void the_user_should_able_to_see_the_submenu_present_under_that_option() {
		try
		{
			System.out.println("------------From Living, retrieve all items under any one of sub-menu items-----------");
			for(int item = 0;item<hp.living_storage_elements().size();item++)
			{
				System.out.println(hp.living_storage_ele_name(item));
			}
			logger.info("Displayed Living Contents");
			Thread.sleep(2000);
			logger.debug(".......Application Logs Ended for TC_002.......");
			logger.info("**** End TC_002_Validate_SubMenu ****");
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			logger.error("TC002 Test Failed..");
			logger.debug(".......Application Logs Ended for TC_002.......");
			logger.info("**** End TC_002_Validate_SubMenu ****");
			Assert.fail("An exception occurred: " + e.getMessage());
		}	
	}
}
