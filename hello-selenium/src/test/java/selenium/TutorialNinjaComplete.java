package selenium;


import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TutorialNinjaComplete {
	/*          Steps covered in this class are as follows
	 *       	1.  Launch the application https://tutorialsninja.com/demo/
				2.  Select the currency in the left top corner to Euro
				3.  Try to order a canon EOS 5 D camera and collect the error message occurred due to a
				    bug in select option by clicking add to cart.
				4.  Move to the home screen by clicking home icon, Click on iphone and go to details screen, change the quantity to two then add to cart.
				5.  Print the success message in the console
				6.  Click on the cart icon (black color) in the right side top then click view cart
				7.  Change the quantity of iphone to 3 and click update button
				8.  Print the Eco tax and VAT Amount in console and click Checkout button
				9.  Print the error message and remove the product from the cart
				10. Move to the laptops screen and click on HP laptop, check the default quantity is 1 and
                    click add to cart then verify success message
                11. Click on the shopping cart link in the top and apply ABCD123 as coupon code to check, print error message
				12. Enter AXDFGH123 as gift certificate and perform apply to check, print error message
				13. Clear both textbox values and proceed to checkout
				14. Select register account option and enter all account and billing details, click continue
				15. Click on payment method and confirm
				16. Return to home page 


	 */
	public static void addToCartCanonEOS(WebDriver driver,String url) {
		/*
		 *1.  Launch the application https://tutorialsninja.com/demo/
		 */
		String expectedErrorMessage = "Select required!";
		driver.manage().window().maximize();
		driver.get(url);
		
		
		//2.  Select the currency in the left top corner to Euro
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		driver.findElement(By.xpath("//button[@name='EUR']")).click();
		driver.findElement(By.xpath("//h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=30']")).click();
		driver.findElement(By.xpath("//select[@name='option[226]']")).click();
		
		/*
		 *3.  Try to order a canon EOS 5 D camera and collect the error message occurred due to a
		 *	  bug in select option by clicking add to cart.
		 */
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		WebElement error =driver.findElement(By.xpath("//div[@id='product']/div[1]/div"));
		String actualErrorMessage = error.getText();
		System.out.println(error.getText());
		
		if (actualErrorMessage.equals(expectedErrorMessage)) {
			System.err.println("The select option is disabled ,error  is "+ actualErrorMessage);
		}


		
	}
	
	public static void addToCartiPhone(WebDriver driver) {
		
		
		/*4.  Move to the home screen by clicking home icon, Click on iphone and go to details screen, 
		 * change the quantity to two then add to cart.
		 */
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-home')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'iPhone')]")).click();  
		driver.findElement(By.xpath("//input[contains(@name,'quantity')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'quantity')]")).sendKeys("2"); 
		driver.findElement(By.id("button-cart")).click();
		
		//5.  Print the success message in the console
		WebElement  successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		System.out.println("Printing Success message for  iPhone to the shopping cart");
		System.out.println(successMessage.getText());
		
		//6.  Click on the cart icon (black color) in the right side top then click view cart
		driver.findElement(By.xpath("//span[contains(@id,'cart-total')]")).click();
		driver.findElement(By.xpath("//strong[contains(text(),'View Cart')]")).click();
		
		//7.  Change the quantity of iphone to 3 and click update button
		driver.findElement(By.xpath("//input[contains(@name,'quantity')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'quantity')]")).sendKeys("3");
		driver.findElement(By.xpath("//button[contains(@data-original-title,'Update')]")).click(); 
		WebElement successModifiedMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		System.out.println("Printing Success message for modified shopping cart");
		System.out.println(successModifiedMessage.getText());
		
		//8.  Print the Eco tax and VAT Amount in console and click Checkout button
		WebElement ecoTax = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[2]"));
		System.out.println("The ECO tax is : "+ecoTax.getText());
		WebElement vat = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[3]"));
		System.out.println("The VAT is : "+vat.getText());
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click(); 
		
		//9.  Print the error message and remove the product from the cart
		WebElement errorCheckout = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		System.err.println("Printing the error message product are not available");
		System.out.println(errorCheckout.getText());
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-times-circle')]")).click();

		
		
	}
	
public static void addToCartHP(WebDriver driver) {
		/*10. Move to the laptops screen and click on HP laptop, check the default quantity is 1 and
	    *click add to cart then verify success message
	    */
	    
		driver.findElement(By.xpath("//*[contains(@class,'fa fa-home')]")).click();
		System.out.println("clicked the home button");
		driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a")).click();
		System.out.println("clicked the  laptops and notebook");
		driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a")).click();
		System.out.println("clicked the show all laptops");
		driver.findElement(By.xpath("//*[@class='caption']//h4/a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&path=18&product_id=47']")).click();
		System.out.println("clicked on  HP LP3065 to cart");
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		System.out.println("added 1  quantity HP LP3065 to cart");
		WebElement success_message =driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		System.out.println("Printing the succes message HP LP3065 is added to cart ");
		System.out.println(success_message.getText());
		
		//11. Click on the shopping cart link in the top and apply ABCD123 as coupon code to check, print error message
		driver.findElement(By.xpath("//span[@id='cart-total']")).click();
		driver.findElement(By.xpath("//strong[contains(text(),'View Cart')]")).click();
		System.out.println("View cart HP LP3065");
		driver.findElement(By.xpath("//a[contains(@href,'#collapse-coupon')]")).click();
		System.out.println("Clicked on Use Coupon Code");
		driver.findElement(By.xpath("//input[contains(@name,'coupon')]")).sendKeys("ABCD123");
		driver.findElement(By.xpath("//input[contains(@value,'Apply Coupon')]")).click();
		WebElement errorMessageCoupon = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		System.out.println("Printing the warning message coupon is either invalid");
		System.out.println(errorMessageCoupon.getText());
		
		//12. Enter AXDFGH123 as gift certificate and perform apply to check, print error message
		//Thread.sleep(1000);//to do remove sleep added for chrome driver
		driver.findElement(By.xpath("//a[contains(@href,'#collapse-coupon')]")).click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'#collapse-voucher')]"))).click();
		driver.findElement(By.xpath("//a[contains(@href,'#collapse-voucher')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'voucher')]")).sendKeys("AXDFGH123");
		driver.findElement(By.xpath("//input[contains(@value,'Apply Gift Certificate')]")).click();
		WebElement errorGiftCertificate = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		System.out.println("Printing the warning message gift Certificate is either invalid ");
		System.out.println(errorGiftCertificate.getText());
		
		//13. Clear both textbox values and proceed to checkout
		//Thread.sleep(2000);//to do remove sleep added for chrome driver
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, 500)");
		driver.findElement(By.xpath("//div[@id='accordion']/div[1]/div[1]/h4/a/i")).click();
		System.out.println("Clearing the coupon code");
		driver.findElement(By.id("input-coupon")).clear();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'#collapse-voucher')]"))).click();
		driver.findElement(By.xpath("//a[contains(@href,'#collapse-voucher')]")).click();
		System.out.println("Clearing the gift voucher code");
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name,'voucher')]"))).clear();
		System.out.println("Proceeding to checkout HP LP3065");
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();

		
	
	}

public static void registerAccount(WebDriver cromedriver){
	
	
	String randomString = RandomStringUtils.randomAlphabetic(5);
	String randomEmail = randomString +"@outlook.com";
	/*
	 * 14. Select register account option and enter all account and billing details, click continue
	 */
	JavascriptExecutor js1 = (JavascriptExecutor) cromedriver;
	js1.executeScript("window.scrollTo(0, 500)");
	new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@value,'Continue')]"))).click();
	cromedriver.findElement(By.xpath("//input[contains(@name,'firstname')]")).sendKeys("Maya");
	cromedriver.findElement(By.xpath("//input[contains(@name,'lastname')]")).sendKeys("Babuji");
	cromedriver.findElement(By.xpath("//input[contains(@id,'input-payment-email')]")).sendKeys(randomEmail);
	cromedriver.findElement(By.xpath("//input[contains(@id,'input-payment-telephone')]")).sendKeys("32223344");
	cromedriver.findElement(By.xpath("//input[contains(@id,'input-payment-password')]")).sendKeys("@Maya123");
	cromedriver.findElement(By.xpath("//input[contains(@id,'input-payment-confirm')]")).sendKeys("@Maya123");
	cromedriver.findElement(By.xpath("//input[contains(@id,'input-payment-address-1')]")).sendKeys("mayaaddress");
	cromedriver.findElement(By.xpath("//input[contains(@id,'input-payment-city')]")).sendKeys("mississuaga");
	cromedriver.findElement(By.xpath("//input[contains(@id,'input-payment-postcode')]")).sendKeys("AB345");
	cromedriver.findElement(By.xpath("//select[contains(@id,'input-payment-zone')]//option[2]")).click();	
	cromedriver.findElement(By.xpath("//input[contains(@name,'agree')]")).click();
	new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-register')]"))).click();
	System.out.println("Completed billing details");
	new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-shipping-address')]"))).click();
	System.out.println("Completed delivery details");
	new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-shipping-method')]"))).click();
	System.out.println("Completed delivery method");
	new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name,'agree')]"))).click();
	System.out.println("Clicked on  terms and  conditions");
	new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-payment-method')]"))).click();
	System.out.println("Completed payment method");
	
	new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-confirm')]"))).click();
	System.out.println("Clicked on confirm  order");
	
	new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'btn btn-primary')]"))).click();
	System.out.println("Clicked on continue  to return to the home page");
	
}
	
	
	
	public static void main(String[] args) {
		
		//WebDriver cromedriver= new ChromeDriver();// uncomment to use crome driver  TO DO remove sleep statements for chrome driver
		
		WebDriver firefox= new FirefoxDriver();//  run test  with firefox
		
		firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		String url ="https://tutorialsninja.com/demo/";	
//		addToCartCanonEOS(cromedriver,url);
//		addToCartiPhone(cromedriver);
//		addToCartHP(cromedriver);
//		registerAccount(cromedriver);
//		
		addToCartCanonEOS(firefox,url);
		addToCartiPhone(firefox);
		addToCartHP(firefox);
		registerAccount(firefox);
		
	}
}
