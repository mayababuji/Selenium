package selenium;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TutorialNinjaPart1 {
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
                11. Click on the shopping cart link in the top and apply ABCD123 as coupon code to check,
                    print error message
                12. Enter AXDFGH123 as gift certificate and perform apply to check, print error message
                13. Clear both textbox values and proceed to checkout

	 */
	public static void addToCartCanonEOS(WebDriver cromedriver,String url) {
		/*
		 *1.  Launch the application https://tutorialsninja.com/demo/
		 */
		String expectedErrorMessage = "Select required!";
		cromedriver.manage().window().maximize();
		cromedriver.manage().deleteAllCookies(); ////   newly added
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		cromedriver.get(url);
		cromedriver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		cromedriver.findElement(By.xpath("//button[@name='EUR']")).click();
		cromedriver.findElement(By.xpath("//h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=30']")).click();
		//2.  Select the currency in the left top corner to Euro
		cromedriver.findElement(By.xpath("//select[@name='option[226]']")).click();
		/*
		 *3.  Try to order a canon EOS 5 D camera and collect the error message occurred due to a
		 *	  bug in select option by clicking add to cart.
		 */
		cromedriver.findElement(By.xpath("//button[@id='button-cart']")).click();
		WebElement error =cromedriver.findElement(By.xpath("//div[@id='product']/div[1]/div"));
		String actualErrorMessage = error.getText();
		
		System.out.println(error.getText());
		
		if (actualErrorMessage.equals(expectedErrorMessage)) {
			System.err.println("The select option is disabled ,error  is "+ actualErrorMessage);
		}


		
	}
	
	public static void addToCartiPhone(WebDriver cromedriver) {
		
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*4.  Move to the home screen by clicking home icon, Click on iphone and go to details screen, 
		 * change the quantity to two then add to cart.
		 */
		cromedriver.findElement(By.xpath("//*[contains(@class,'fa fa-home')]")).click();/// got back to home 
		cromedriver.findElement(By.xpath("//a[contains(text(),'iPhone')]")).click();  ///  click on iphone
		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).clear();// clear the quantity 1
		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).sendKeys("2");//enter 2 quantity
		
		//new WebDriverWait(cromedriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'button-cart')]"))).click();
		//cromedriver.findElement(By.xpath("//*[contains(@id,'button-cart')]")).click();//click add to cart
		//cromedriver.findElement(By.xpath("//*[contains(@id,'button-cart')]")).click();// add to cart 
		cromedriver.findElement(By.id("button-cart")).click();//add to cart iphone quantity 2
		//5.  Print the success message in the console
		WebElement  successMessage = cromedriver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		System.out.println("Printing Success message for  iPhone to the shopping cart");
		System.out.println(successMessage.getText());
		
		//6.  Click on the cart icon (black color) in the right side top then click view cart
		cromedriver.findElement(By.xpath("//*[contains(@id,'cart-total')]")).click();///  Click on the cart icon (black color) in the right side top
		cromedriver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();// then click view cart
		//7.  Change the quantity of iphone to 3 and click update button
		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).clear();/// clear the value 2
		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).sendKeys("3");//update the value to 3
		cromedriver.findElement(By.xpath("//*[contains(@data-original-title,'Update')]")).click();//click on update 

		WebElement successModifiedMessage = cromedriver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		System.out.println("Printing Success message for modified shopping cart");
		System.out.println(successModifiedMessage.getText());
		//8.  Print the Eco tax and VAT Amount in console and click Checkout button
		WebElement ecoTax = cromedriver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[2]"));// get the eco ptax
		System.out.println("The ECO tax is : "+ecoTax.getText());
		WebElement vat = cromedriver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[3]"));// get the VAT 
		System.out.println("The VAT is : "+vat.getText());
		
		cromedriver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click(); /// click Checkout button
		//9.  Print the error message and remove the product from the cart
		WebElement errorCheckout = cromedriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));//get the erro message
		System.err.println("Printing the error message product are not available");
		System.out.println(errorCheckout.getText());
		
		
		cromedriver.findElement(By.xpath("//i[contains(@class,'fa fa-times-circle')]")).click();//remove the product from the cart

		
		
	}
	public static void addToCartHP(WebDriver cromedriver) throws InterruptedException {
		
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		cromedriver.findElement(By.xpath("//*[contains(@class,'fa fa-home')]")).click();///click home button
		System.out.println("clicked the home button");
		cromedriver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a")).click();
		System.out.println("clicked the  laptops and notebook");
		
		cromedriver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a")).click();
		
		System.out.println("clicked the show all laptops");
		cromedriver.findElement(By.xpath("//*[@class='caption']//h4/a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&path=18&product_id=47']")).click();
		System.out.println("clicked on  HP LP3065 to cart");
		cromedriver.findElement(By.xpath("//button[@id='button-cart']")).click();
		System.out.println("added 1  quantity HP LP3065 to cart");
		
		WebElement success_message =cromedriver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		System.out.println("Printing the succes message HP LP3065 is added to cart ");
		System.out.println(success_message.getText());
		
		WebElement elem = cromedriver.findElement(By.xpath("//span[@id='cart-total']"));
		((JavascriptExecutor)cromedriver).executeScript("arguments[0].scrollIntoView();", elem);
	
		//Thread.sleep(2000); ///newly added for chrome driver
		new WebDriverWait(cromedriver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='cart-total']"))).click();
		//cromedriver.findElement(By.xpath("//span[@id='cart-total']")).click();
		cromedriver.findElement(By.xpath("//strong[contains(text(),'View Cart')]")).click();
		System.out.println("View cart HP LP3065");
		
		
		cromedriver.findElement(By.xpath("//a[contains(@href,'#collapse-coupon')]")).click();
		System.out.println("Clicked on Use Coupon Code");
		cromedriver.findElement(By.xpath("//input[contains(@name,'coupon')]")).sendKeys("ABCD123");
		cromedriver.findElement(By.xpath("//input[contains(@value,'Apply Coupon')]")).click();
		WebElement errorMessageCoupon = cromedriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));//get the erro message
		System.out.println("Printing the warning message coupon is either invalid");
		System.out.println(errorMessageCoupon.getText());
		cromedriver.findElement(By.xpath("//a[contains(@href,'#collapse-coupon')]")).click();
		
	
		
	    Thread.sleep(2000);//newly added for chrome driver
		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'#collapse-voucher')]"))).click();
		cromedriver.findElement(By.xpath("//a[contains(@href,'#collapse-voucher')]")).click();
		cromedriver.findElement(By.xpath("//input[contains(@name,'voucher')]")).sendKeys("AXDFGH123");
		cromedriver.findElement(By.xpath("//input[contains(@value,'Apply Gift Certificate')]")).click();
		WebElement errorGiftCertificate = cromedriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		System.out.println("Printing the warning message gift Certificate is either invalid ");
		System.out.println(errorGiftCertificate.getText());
		
		
		
		JavascriptExecutor js1 = (JavascriptExecutor) cromedriver;
		js1.executeScript("window.scrollTo(0, 500)");
		cromedriver.findElement(By.xpath("//div[@id='accordion']/div[1]/div[1]/h4/a/i")).click();
		System.out.println("Clearing the coupon code");
		cromedriver.findElement(By.id("input-coupon")).clear();
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor) cromedriver;
		//js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js2.executeScript("window.scrollTo(0, 1000)");
		cromedriver.findElement(By.xpath("//a[contains(@href,'#collapse-voucher')]")).click();
		//new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'#collapse-voucher')]"))).click();
		System.out.println("Clearing the gift certificate");
		
		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name,'voucher')]"))).clear();
		
		//cromedriver.findElement(By.xpath("//input[contains(@name,'voucher')]")).clear();
		System.out.println("Proceeding to checkout HP LP3065");
		cromedriver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();	
		
	}
	
	public static void registerAccount(WebDriver cromedriver) throws InterruptedException{
		//Thread.sleep(3000);
		
		String randomString = RandomStringUtils.randomAlphabetic(5);
		String randomEmail = randomString +"@outlook.com";
		
		JavascriptExecutor js1 = (JavascriptExecutor) cromedriver;
		js1.executeScript("window.scrollTo(0, 500)");
		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@value,'Continue')]"))).click();
		//cromedriver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();
		
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
		//cromedriver.findElement(By.xpath("//input[contains(@id,'button-register')]")).click();
		
		
		//Thread.sleep(3000); --this is commented now

		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-shipping-address')]"))).click();
		//cromedriver.findElement(By.xpath("//input[contains(@id,'button-shipping-address')]")).click();
		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-shipping-method')]"))).click();
		//cromedriver.findElement(By.xpath("//input[contains(@id,'button-shipping-method')]")).click();
		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name,'agree')]"))).click();
		//cromedriver.findElement(By.xpath("//input[contains(@name,'agree')]")).click();
		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-payment-method')]"))).click();
		//cromedriver.findElement(By.xpath("//input[contains(@id,'button-payment-method')]")).click();
		
		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'button-confirm')]"))).click();
		//cromedriver.findElement(By.xpath("//input[contains(@id,'button-confirm')]")).click();
		
		new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'btn btn-primary')]"))).click();
		//cromedriver.findElement(By.xpath("//a[contains(@class,'btn btn-primary')]")).click();
		
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//WebDriver cromedriver= new ChromeDriver();
		 FirefoxOptions options = new FirefoxOptions();
	     options.addPreference("browser.cache.disk.enable", false);
	     options.addPreference("browser.cache.memory.enable", false);
		WebDriver firefox= new FirefoxDriver(options);
		
//		cromedriver.manage().deleteAllCookies(); ////   newly added
//		cromedriver.get("chrome://settings/clearBrowserData"); ////   newly added
//		cromedriver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);////   newly added
		
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
		/// 1.question help in removing the sleep.  2. help in removing cache and clearing history for firefox driver
	}

}
