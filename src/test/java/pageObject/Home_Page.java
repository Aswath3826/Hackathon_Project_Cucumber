package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Base_Page{
	
	public Home_Page(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath = "//input[@id='search']")
	WebElement search_box;
	@FindBy(xpath = "//strong[text()='bookshelves']")
	WebElement bookshelves;
	@FindBy(xpath = "//li[@class = 'topnav_item livingunit']")
	WebElement living;
	@FindBy(xpath = "//li[@class = 'topnav_item livingunit']//ul[@class = 'inline-list left']/li[3]//span")
	List<WebElement> living_storage;
	@FindBy(xpath = "//ul[@class = 'featuredLinksBar__linkContainer']//a[text() = ' Gift Cards ']")
	WebElement gift_cards;
	
	public WebElement s_box()
	{
		return search_box;
	}
	public void click_bookshelves()
	{
		bookshelves.click();
	}
	public void click_living()
	{
		living.click();
	}
	public List<WebElement> living_storage_elements()
	{
		return living_storage;
	}
	public String living_storage_ele_name(int item)
	{
		return living_storage.get(item).getAttribute("innerText");
	}
	public void click_gift_cards()
	{
		gift_cards.click();
	}
	
}
