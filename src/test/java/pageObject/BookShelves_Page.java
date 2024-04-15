package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BookShelves_Page extends Base_Page{
	
	public BookShelves_Page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.LINK_TEXT, using = "Close")
	WebElement pop_up_close;
	
	@FindBy(xpath = "//li[@class='item' and @data-group='price']")
	WebElement price;
	
	@FindBy(xpath = "//div[@class='noUi-handle noUi-handle-upper']")
	WebElement max_slider;
	
	@FindBy(xpath = "//li[@class='item' and @data-group='category']")
	WebElement category;
	
	@FindBy(xpath = "//input[@value='Bookshelves']")
	WebElement bookshelf;
	
	@FindBy(xpath = "//input[@value='In Stock Only']")
	WebElement ex_out_of_stock;
	
	@FindBy(xpath = "//span[text()='Recommended']")
	WebElement recommended;
	
	@FindBy(xpath = "//li[text()='Price: High to Low']")
	WebElement high_to_low;
	
	@FindBy(xpath = "//span[@class='name']")
	List<WebElement> item_names;
	@FindBy(xpath = "//div[@class='price-number']//span")
	List<WebElement> item_prices;
	
	
	public void click_pop_up_close()
	{
		pop_up_close.click();
	}
	public void click_price()
	{
		price.click();
	}
	public void set_price()
	{
		Actions act = new Actions(driver);
		act.moveToElement(max_slider).click().dragAndDropBy(max_slider, -211, 0).perform();
	}
	public void click_category()
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",category);
	}
	public void click_category_bookshelf()
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",bookshelf);
	}
	public void click_ex_out_of_stock()
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",ex_out_of_stock);
	}
	public void click_recommended()
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",ex_out_of_stock);
	}
	public void click_price_high_to_low()
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",high_to_low);
	}
	
	public String searched_items(int item)
	{
		return item_names.get(item).getText()+" = "+item_prices.get(item).getText();
	}
	
}
