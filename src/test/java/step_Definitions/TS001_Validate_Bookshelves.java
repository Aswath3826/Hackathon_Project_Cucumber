package step_Definitions;


import org.junit.Assert;

import factory.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS001_Validate_Bookshelves extends Base_Class{
	
	@Given("the user search for {string}")
	public void the_user_search_for(String item) {
		logger.debug(".......Application Logs Started for TS_001.......");
		logger.info("**** Start TS001_Validate_BookShelves ****");
		hp.s_box().sendKeys(item);
		hp.click_bookshelves();
		logger.info("Clicked BookShelves");
	}
	
	@When("the user performs all conditions as per description")
	public void the_user_performs_all_conditions_as_per_description() throws InterruptedException {
		bp.click_pop_up_close();
		logger.info("Closed PopUp");
		
		//1. Display the name & price of first 3 Bookshelves below Rs. 15000, with Storage type as open & exclude out of stock
		bp.click_price();
		logger.info("Clicked Price");
		bp.set_price();
		logger.info("Set Price");
		Thread.sleep(3000);
		bp.click_category();
		logger.info("Clicked Category");
		bp.click_category_bookshelf();
		logger.info("Set Category Type As Bookshelf");
		Thread.sleep(2000);
		
		bp.click_ex_out_of_stock();
		logger.info("Clicked Exclude Out of Stock");
		Thread.sleep(2000);
		
		bp.click_recommended();
		logger.info("Clicked Sort By");
		bp.click_price_high_to_low();
		logger.info("Clicked High to Low");
		Thread.sleep(3000);
	}
	
	@Then("the user sees the result page of the product")
	public void the_user_sees_the_result_page_of_the_product() {
	    
		try
		{
			System.out.println("------------Display the name & price of first 3 Bookshelves below Rs. 15000---------");
			for(int item = 0 ;item<3 ; item++)
			{
				System.out.println(bp.searched_items(item));
			}
			logger.debug(".......Application Logs Ended for TC_001.......");
			logger.info("**** End TC_001_Validate_BookShelves ****");
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			logger.error("TC001 Test Failed..");
			logger.debug(".......Application Logs Ended for TC_001.......");
			logger.info("**** End TC_001_Validate_BookShelves ****");
			Assert.fail("An exception occurred: " + e.getMessage());
		}		
	}
}
