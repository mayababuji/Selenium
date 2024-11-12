package selenium;

import java.time.Duration;

//import java.util.concurrent.TimeUnit;//not working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;//how to use wait?

public class SwagLabsTest {
	
	public static void login(WebDriver cromedriver,String url,String username,String password) {
		cromedriver.manage().window().maximize();
		cromedriver.get(url);
		//WebElement userName = cromedriver.findElement(By.name("user-name"));
		WebElement userName = cromedriver.findElement(By.xpath("//*[contains(@name,'user-name')]"));
		userName.sendKeys(username);
		//WebElement passWord = cromedriver.findElement(By.id("password"));
		WebElement passWord = cromedriver.findElement(By.xpath("//input[@id='password']"));
		passWord.sendKeys(password);
		//WebElement login = cromedriver.findElement(By.id("login-button"));
		WebElement login = cromedriver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
		login.click();
		
	}
	public static void addtoCart(WebDriver cromedriver) {
		cromedriver.findElement(By.xpath("//*[@class='product_sort_container']/option[3]")).click();
		//cromedriver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		cromedriver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
		//cromedriver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		cromedriver.findElement(By.xpath("//*[@name='add-to-cart-sauce-labs-onesie']")).click();
		//cromedriver.findElement(By.className("shopping_cart_container")).click();
		cromedriver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		
	}
	public static void checkoutItems(WebDriver cromedriver, String firstName,String lastName,String zipCode) {
		
				//driver.findElement(By.className("btn.btn_action btn_medium checkout_button")).click();//not working  compund class error
			//cromedriver.findElement(By.className("checkout_button")).click();//working checkout_button do control f for checkout_button to make sure only one search then can use
				//TimeUnit.SECONDS.sleep(1);//not working
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//working 
				//WebDriverWait wait = new WebDriverWait(driver, 10);//not working
		cromedriver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']")).click();
			
			//cromedriver.findElement(By.name("firstName")).sendKeys(firstName);
		cromedriver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
		cromedriver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys(lastName);
		cromedriver.findElement(By.xpath("//*[@class='form_group']//input[@placeholder='Zip/Postal Code']")).sendKeys(zipCode);
		cromedriver.findElement(By.xpath("//*[@class='checkout_buttons']//input[@type='submit']")).click();
		cromedriver.findElement(By.xpath("//*[@class='cart_footer']//button[@name='finish']")).click();
			//cromedriver.findElement(By.name("lastName")).sendKeys(lastName);
			//cromedriver.findElement(By.id("postal-code")).sendKeys(zipCode);
			//cromedriver.findElement(By.className("submit-button")).click();
			//cromedriver.findElement(By.name("finish")).click();
			
			
			
			
				
				
		
	}
	public static void logout(WebDriver cromedriver) {
		//cromedriver.findElement(By.name("back-to-products")).click();
		cromedriver.findElement(By.xpath("//*[@class='checkout_complete_container']//button[@name='back-to-products']")).click();
		cromedriver.findElement(By.xpath("//*[@class='bm-burger-button']//button[@type='button']")).click();
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		cromedriver.findElement(By.xpath("//*[@class='bm-item-list']//a[@id='logout_sidebar_link']")).click();
		//cromedriver.findElement(By.id("react-burger-menu-btn")).click();
		//cromedriver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Your-Name");
		
		//cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//cromedriver.findElement(By.id("logout_sidebar_link")).click();
		//cromedriver.findElement(By.xpath("//a[(@id='logout_sidebar_link')]")).click();
		
	}

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

}
