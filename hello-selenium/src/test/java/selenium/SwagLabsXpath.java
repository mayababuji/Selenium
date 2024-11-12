package selenium;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SwagLabsXpath {
	/*Date October 15,2024
	 * 
	 * Description of the code:
	 * 
	 * This class test the login, add to cart and logout flow for the website https://www.saucedemo.com/ using only xpath
	 * Step 1 - login to https://www.saucedemo.com/ using credentials
	 * Step 2 -Sort the items from price low to high and add 2 items to the cart
	 * Step 3 -Checkout items by providing first name, last name and zip code and click on finish to complete the checkout process
	 * Step 4 -Return to home page and select logout 
	 * Step 5 - Close the window using chromedriver.close
	 */
	
	public static void main(String[] args) {
		
		WebDriver cromedriver= new ChromeDriver();
		//declare all variables
		String url ="https://www.saucedemo.com/";
		String username = "standard_user";
		String password = "secret_sauce";
		String firstName = "John";
		String lastName = "kennedy";
		String zipCode = "L5P30";
		
		//run all the steps
		login(cromedriver,url,username,password);
		addtoCart(cromedriver);
		checkoutItems(cromedriver,firstName,lastName,zipCode);
		logout(cromedriver);
		cromedriver.close();
	}
	
	//login
	public static void login(WebDriver cromedriver,String url,String username,String password) {
		
		cromedriver.manage().window().maximize();
		cromedriver.get(url);
		cromedriver.findElement(By.xpath("//*[contains(@name,'user-name')]")).sendKeys(username);
		cromedriver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		cromedriver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();	
		
	}
	
	//Add 2 items into the cart
	public static void addtoCart(WebDriver cromedriver) {
		
		cromedriver.findElement(By.xpath("//*[@class='product_sort_container']/option[3]")).click();//filter items from price low to high before adding items into cart
		cromedriver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
		cromedriver.findElement(By.xpath("//*[@name='add-to-cart-sauce-labs-onesie']")).click();
		cromedriver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();	
		
	}
	
	//checkout the items and click on finish
	public static void checkoutItems(WebDriver cromedriver, String firstName,String lastName,String zipCode) {
		
		cromedriver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']")).click();
		cromedriver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
		cromedriver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys(lastName);
		cromedriver.findElement(By.xpath("//*[@class='form_group']//input[@placeholder='Zip/Postal Code']")).sendKeys(zipCode);
		cromedriver.findElement(By.xpath("//*[@class='checkout_buttons']//input[@type='submit']")).click();
		cromedriver.findElement(By.xpath("//*[@class='cart_footer']//button[@name='finish']")).click();
						
		
	}
	
	//go to home page to select logout.implicitlyWait is used to wait for 3 secs till logout_sidebar_link element loads and can be clickable 
	public static void logout(WebDriver cromedriver) {
	
		cromedriver.findElement(By.xpath("//*[@class='checkout_complete_container']//button[@name='back-to-products']")).click();
		cromedriver.findElement(By.xpath("//*[@class='bm-burger-button']//button[@type='button']")).click();
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		cromedriver.findElement(By.xpath("//*[@class='bm-item-list']//a[@id='logout_sidebar_link']")).click();
		
	}



}
