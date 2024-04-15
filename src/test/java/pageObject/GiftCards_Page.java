package pageObject;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCards_Page extends Base_Page{
	
	public GiftCards_Page(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath = "//ul[@class = '_2sedU']//h3[text() = 'Birthday/Anniversary']")
	WebElement bday_an;
	@FindBy(xpath = "//button[@class='HuPJS'][2]")
	WebElement rupees;
	@FindBy(xpath = "//button[text()='Next']")
	WebElement custom_next;
	@FindBy(xpath = "//input[@name='recipient_name']")
	WebElement recipient_name;
	@FindBy(xpath = "//input[@name='recipient_email']")
	WebElement recipient_email;
	@FindBy(xpath = "//input[@name='recipient_mobile_number']")
	WebElement recipient_mobile_number;
	@FindBy(xpath = "//input[@name='customer_name']")
	WebElement customer_name;
	@FindBy(xpath = "//input[@name='customer_email']")
	WebElement customer_email;
	@FindBy(xpath = "//input[@name='customer_mobile_number']")
	WebElement customer_mobile_number;
	@FindBy(xpath = "//input[@name='customer_address']")
	WebElement customer_address;
	@FindBy(xpath = "//input[@name='zip']")
	WebElement zipcode;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_btn;
	@FindBy(xpath = "//section[@class = '_14QEd _1QpDs']")
	WebElement details_confirm_sec;
	
	public void click_bday_an()
	{
		bday_an.click();
	}
	public void click_rupees()
	{
		rupees.click();
	}
	public void click_custom_next()
	{
		custom_next.click();
	}
	public WebElement recipient_name_ele()
	{
		return recipient_name;
	}
	public WebElement recipient_email_ele()
	{
		return recipient_email;
	}
	public WebElement recipient_mobile_number_ele()
	{
		return recipient_mobile_number;
	}
	public WebElement customer_name_ele()
	{
		return customer_name;
	}
	public WebElement customer_email_ele()
	{
		return customer_email;
	}
	public WebElement customer_mobile_number_ele()
	{
		return customer_mobile_number;
	}
	public WebElement customer_address_ele()
	{
		return customer_address;
	}
	public WebElement zipcode_ele()
	{
		return zipcode;
	}
	public void click_submit_btn()
	{
		submit_btn.click();
	}
	public void details_confirm_sec_ele()
	{
		boolean ele = details_confirm_sec.isDisplayed();
	}
	public void scroll_to_details_confirm_sec_ele()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", details_confirm_sec);
	}
}
