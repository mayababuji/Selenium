package selenium;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagCheckoutTest {
	/*Date October 13,2024
	 * 
	 * Description of the code:
	 * 
	 * This class test the login, add to cart and logout flow for the website https://www.saucedemo.com/
	 */
	
	
	public static void main(String[] args) {
		
		WebDriver cromedriver= new ChromeDriver();
		
		String url ="https://www.saucedemo.com/";
		String username = "standard_user";
		String password = "secret_sauce";
		String firstName = "John";
		String lastName = "kennedy";
		String zipCode = "L5P30";
		login(cromedriver,url,username,password);
		addtoCart(cromedriver);
		checkoutItems(cromedriver,firstName,lastName,zipCode);
		logout(cromedriver);
		cromedriver.close();
	}
	
	
	//login method
	public static void login(WebDriver cromedriver,String url,String username,String password) {
		
		cromedriver.manage().window().maximize();//maximize the window
		cromedriver.get(url);
		WebElement userName = cromedriver.findElement(By.name("user-name"));
		userName.sendKeys(username);
		WebElement passWord = cromedriver.findElement(By.id("password"));
		passWord.sendKeys(password);
		WebElement login = cromedriver.findElement(By.id("login-button"));
		login.click();
		
	}
	
	//add to cart method
	public static void addtoCart(WebDriver cromedriver) {
		
		cromedriver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		cromedriver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		cromedriver.findElement(By.className("shopping_cart_container")).click();
		
		
	}
	
	//checkout method
	public static void checkoutItems(WebDriver cromedriver, String firstName,String lastName,String zipCode) {
		
			cromedriver.findElement(By.className("checkout_button")).click();
			cromedriver.findElement(By.name("firstName")).sendKeys(firstName);
			cromedriver.findElement(By.name("lastName")).sendKeys(lastName);
			cromedriver.findElement(By.id("postal-code")).sendKeys(zipCode);
			cromedriver.findElement(By.className("submit-button")).click();
			cromedriver.findElement(By.name("finish")).click();
							
		
	}
	
	//logout method
	public static void logout(WebDriver cromedriver) {
		cromedriver.findElement(By.name("back-to-products")).click();
		cromedriver.findElement(By.id("react-burger-menu-btn")).click();
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//wait 3 secs till the element logout_sidebar_link is clickable 
		cromedriver.findElement(By.id("logout_sidebar_link")).click();
		
	}




}
