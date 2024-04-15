package step_Definitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import factory.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DataReader;
import utilities.Excel_Utilities;

public class TS003_Validate_Gift_Cards extends Base_Class{
	
	List<HashMap<String, String>> datamap; //Data driven
	
	@Given("the user navigates to giftCard section")
	public void the_user_navigates_to_gift_card_section() {
		
		logger.debug(".......Application Logs Started for TC_003.......");
		logger.info("**** Start TC_003_Validate_Gift_Cards ****");
		hp.click_gift_cards();
		logger.info("Clicked Gift Cards");
	}

	@Then("user should be redirected to payment page by passing all details with excel row {string}")
	public void user_should_be_redirected_to_payment_page_by_passing_all_details_with_excel_row(String rows) throws IOException {
		
		datamap=DataReader.data("C:\\Users\\2318646\\eclipse-workspace\\Hackathon_Project_Cucumber\\testData\\HackathonData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String r_name = datamap.get(index).get("R.Name");
        String r_email = datamap.get(index).get("R.Email");
        String r_mobile = datamap.get(index).get("R.Mobile");
        String c_name = datamap.get(index).get("Y.Name");
        String c_email = datamap.get(index).get("Y.Email");
        String c_mobile = datamap.get(index).get("Y.Mobile");
        String c_address = datamap.get(index).get("Y.address");
        String pincode = datamap.get(index).get("Pincode");
        String exp_result = datamap.get(index).get("Exp.result");
        int int_row = Integer.parseInt(rows);
        
        int flag=0;
		Excel_Utilities excel = new Excel_Utilities("C:\\Users\\2318646\\eclipse-workspace\\Hackathon_Project_Cucumber\\testData\\HackathonData.xlsx");
		try
		{
			gp.click_bday_an();
			logger.info("Clicked Birthday Anniversary");
			gp.click_rupees();
			logger.info("Set Rupees");
			gp.click_custom_next();
			logger.info("Clicked Next");
			gp.recipient_name_ele().sendKeys(r_name);
			logger.info("Set Recipient Name Value");
			gp.recipient_email_ele().sendKeys(r_email);
			logger.info("Set Recipient Email Value");
			gp.recipient_mobile_number_ele().sendKeys(r_mobile);
			logger.info("Set Recipient Mobile Number Value");
			gp.customer_name_ele().sendKeys(c_name);
			logger.info("Set Customer Name Value");
			gp.customer_email_ele().sendKeys(c_email);
			logger.info("Set Customer Email Value");
			gp.customer_mobile_number_ele().sendKeys(c_mobile);
			logger.info("Set Customer Mobile Value");
			gp.customer_address_ele().sendKeys(c_address);
			logger.info("Set Customer Address Value");
			gp.zipcode_ele().sendKeys(pincode);
			logger.info("Set Zipcode Value");
			Thread.sleep(1000);
			gp.click_submit_btn();
			logger.info("Clicked Submit");
			Thread.sleep(1000);
			flag=1;
			gp.details_confirm_sec_ele();
			logger.info("Payment Section Present");
			Thread.sleep(1000);
			gp.scroll_to_details_confirm_sec_ele();
			logger.info("Scrolled to Payment Section");
			if(exp_result.equalsIgnoreCase("pass"))
			{
				System.out.println("Info Valid = "+r_name);
				excel.setCellData("Sheet1", int_row, 9,"Valid");
				logger.debug(".......Application Logs Ended for TC_003.......");
				logger.info("**** End TC_003_Validate_Gift_Cards ****");
				Assert.assertTrue(true);
			}
		}
		catch(Exception e)
		{
			String msg = "";
			if(flag==1)
			{
				System.out.println("Info Invalid = "+r_name);
				excel.setCellData("Sheet1", int_row, 9,"Invalid");
				msg = "Section Element Not found: " + e.getMessage();
			}
			else
			{
				msg = "An exception occurred: " + e.getMessage();
			}
			logger.error("TC003 Test Failed..");
			logger.debug(".......Application Logs Ended for TC_003.......");
			logger.info("**** End TC_003_Validate_Gift_Cards ****");
			Assert.fail(msg);
		}
        
	}
}
