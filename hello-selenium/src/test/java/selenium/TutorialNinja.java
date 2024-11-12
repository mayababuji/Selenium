package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//xpaths


//------   //button[@class='btn btn-link dropdown-toggle']    dropdown
//---- //button[@name='EUR'] select euro

// --- //h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=30']  select canon 

///---- //button[@onclick='cart.add('30');']   did not get to select canon

//--    //select[@name='option[226]']  available option please slect

//----  //button[@id='button-cart']    add to cart 

///--- //*[@class='text-danger'] 
//--- //*[text()='Select required!']

///    //*[contains(@class,'fa fa-home')]    ---- go back to home after adding cart canon

///      //a[contains(text(),'iPhone')]    -----   select iphone 

///    //*[contains(@name,'quantity')]   --- sendkeys 2 to chage the quatity of iphone

//  //*[contains(@id,'button-cart')]  ---  add to cart the iphone 


//   //*[contains(@id,'cart-total')]    -----    Click on the cart icon (black color) in the right side top 

///   //*[contains(text(),'View Cart')]    ----- then click view cart



////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//////    startssss from here

///  //*[contains(text(),'Show AllLaptops & Notebooks')]   --- for show all laptops

////   //*[contains(@href,'https://tutorialsninja.com/demo/index.php?route=product/product&path=18&product_id=47')]    select hp

////  //button[@id='button-cart']    addd to cart hp

///   //*[contains(text(),'Success: You have added ')]   ---- success message

///   //*[contains(@class,'btn btn-inverse btn-block btn-lg dropdown-toggle')]   --- hover items cart 

////  //*[contains(text(),'View Cart')]    ---- view cart can be clicked

/////   //*[contains(@href,'#collapse-coupon')]     use coupon code click

/////   /*[contains(@name,'coupon')]  ---- sendkeys with coupon 

////   //*[contains(@value,'Apply Coupon')]   ---- click on applycode

//////    //*[contains(text(),'Warning: Coupon is either invalid, expired or reached its usage limit!')]     ----  error message 

/////     //*[contains(@href,'#collapse-voucher')]    -----  click on  gift voucher   

/////       //*[contains(@name,'voucher')]      ---- enter the gift certificate AXDFGH123  sendkeys

/////    //*[contains(@value,'Apply Gift Certificate')]   ---  click on apply gift certificate


///   //*[contains(text(),'Warning: Gift Certificate is either invalid or the balance has been used up!')]  ---- error message for gift certificate

////    //*[contains(@class,'close')]  ---- close the warning message

//////  //a[contains(text(),'Checkout')]    ----  proceed to checkout 

////    //*[contains(@value,'Continue')]  ---  continue to register account 


/// //*[contains(@name,'firstname')]   -- enter first name sendkeys 

///   //*[contains(@name,'lastname')]   -- enter last name send keys

///    //*[contains(@id,'input-payment-email')]    --- enter emai id sendkeys

///   //*[contains(@name,'telephone')]    --- enter telephone sendkeys


///   //*[contains(@name,'address_1')]   -- enter address 1 sendkeys

///    //*[contains(@name,'city')]   --- enter city sendkeys

////     //*[contains(@name,'postcode')]   --- enter postal code sendkeys

///    //*[contains(@name,'zone_id')] /option[2]  --- enter Aberdeen   3513 region state 

////    //*[contains(@id,'input-payment-password')]  ----enter password
//      //*[contains(@id,'input-payment-confirm')]   --- enter password confirm sendkeys

///   //*[contains(@name,'agree')]  --- click on privacy policy

////    //*[contains(@id,'button-register')]  --- click on continue

///   //*[contains(@id,'button-shipping-address')]   --click to continue in delivery details


////   //*[contains(@name,'comment')]  ----  enter commnets sendkeys

////   //*[contains(@id,'button-shipping-method')]   ----  -click to continue in delivery method

////   //*[contains(@name,'agree')]   ---- click on terms and condition agree


/////    //*[contains(@id,'button-payment-method')]    ---  click to continue in payement method

////     //*[contains(@id,'button-confirm')]     ---- click on confirm order

////   //h1[contains(text(),'Your order has been placed!')]   --- order placed confirmed message 

////   //*[contains(text(),'Continue')]     --- click on continue  






public class TutorialNinja {
	
	
	public static void addToCartCanonEOS(WebDriver cromedriver,String url) {
		
		String errorMessage = "Select required!";
		cromedriver.manage().window().maximize();
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cromedriver.get(url);
		cromedriver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		cromedriver.findElement(By.xpath("//button[@name='EUR']")).click();
		cromedriver.findElement(By.xpath("//h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=30']")).click();
		cromedriver.findElement(By.xpath("//select[@name='option[226]']")).click();
		cromedriver.findElement(By.xpath("//button[@id='button-cart']")).click();
		WebElement error =cromedriver.findElement(By.xpath("//div[@id='product']/div[1]/div"));
		//WebElement error =cromedriver.findElement(By.xpath("//*[text()='Select required!']"));
		String err = error.getText();
		System.out.println(error.getText());
		if (err.equals(errorMessage))System.out.println("The select option is disabled ,error  is "+ err);


		
	}
	
	public static void addToCartiPhone(WebDriver cromedriver) {
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		cromedriver.findElement(By.xpath("//*[contains(@class,'fa fa-home')]")).click();/// got back to home 
		cromedriver.findElement(By.xpath("//a[contains(text(),'iPhone')]")).click();  ///  click on iphone
		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).clear();// clear the quantity 1
		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).sendKeys("2");//enter 2 quatity
		
		//new WebDriverWait(cromedriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'button-cart')]"))).click();
		//cromedriver.findElement(By.xpath("//*[contains(@id,'button-cart')]")).click();//click add to cart
		//cromedriver.findElement(By.xpath("//*[contains(@id,'button-cart')]")).click();// add to cart 
		cromedriver.findElement(By.id("button-cart")).click();
		
		WebElement  successMessage = cromedriver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		//WebElement  successMessage = cromedriver.findElement(By.xpath("//*[contains(text(),'Success: You have added ')]"));
		System.out.println(successMessage.getText());
		
		
		cromedriver.findElement(By.xpath("//*[contains(@id,'cart-total')]")).click();///  Click on the cart icon (black color) in the right side top
		cromedriver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();// then click view cart
		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).clear();/// clear the value 2
		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).sendKeys("3");//upadte the value to 3
		cromedriver.findElement(By.xpath("//*[contains(@data-original-title,'Update')]")).click();//click on update 

		WebElement successModifiedMessage = cromedriver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		//WebElement successModifiedMessage = cromedriver.findElement(By.xpath("//*[contains(text(),'Success: You have modified your shopping cart!')]"));
		System.out.println(successModifiedMessage.getText());
		
		WebElement ecoTax = cromedriver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[2]"));///ecoo tax path
		System.out.println(ecoTax.getText());
		WebElement vat = cromedriver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[3]"));//VAT path
		System.out.println(vat.getText());

		
	}
	
	public static void checkOutIphone(WebDriver cromedriver) {
		
	
		
		cromedriver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click(); /// click Checkout button
		//Print the error message
		
		//div[@class='alert alert-danger alert-dismissible']
		WebElement errorCheckout = cromedriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		//WebElement errorCheckout = cromedriver.findElement(By.xpath("//*[contains(text(),'Products marked with *** are not available in the desired quantity or not in stock!')]"));
		System.out.println(errorCheckout.getText());
		cromedriver.findElement(By.xpath("//*[contains(@class,'fa fa-times-circle')]")).click();//remove the product from the cart
		
		
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//cromedriver.findElement(By.xpath("//h1//a[@href='https://tutorialsninja.com/demo/index.php?route=common/home']")).click();//click on qafox.com
		//cromedriver.findElement(By.xpath("//h1//a[@href='https://tutorialsninja.com/demo/index.php?route=common/home']")).click();
		cromedriver.findElement(By.xpath("//*[contains(@class,'fa fa-home')]")).click();///click home button
		cromedriver.findElement(By.xpath("//*[contains(@class,'fa fa-home')]")).click();///click home button
		System.out.println("clicked the home button");
		cromedriver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a")).click();///click on show all laptops by priya
		cromedriver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a")).click();// /click on show all laptops by priya
		
		
		//*[@id="menu"]/div[2]/ul/li[2]/div/a
		System.out.println("clicked the  laptops and notebook");
		cromedriver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a")).click();
		//cromedriver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a")).click();
		
		System.out.println("clicked the show all laptops");
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cromedriver.findElement(By.xpath("//*[@id='content']/div[4]/div[1]/div/div[1]/a/img")).click();
		
		
		//cromedriver.findElement(By.xpath("//div/h4/a[contains(@href,'https://tutorialsninja.com/demo/index.php?route=product/product&path=18&product_id=47')]")).click();
		//cromedriver.findElement(By.xpath("//*[contains(@href,'https://tutorialsninja.com/demo/index.php?route=product/product&path=18&product_id=47')] ")).click();
		
		System.out.println("clicked the on hP");
		cromedriver.findElement(By.xpath("//button[@id='button-cart']")).click();
		
		System.out.println("clicked add to cart for HP");
		
		WebElement success_message =cromedriver.findElement(By.xpath("//*[contains(text(),'Success: You have added ')]"));
		System.out.println(success_message.getText());
		System.out.println("got the Success: You have added HP LP3065 to your shopping cart!");
		
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//new WebDriverWait(cromedriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'cart-total')]"))).click();
		cromedriver.findElement(By.xpath("//*[contains(@id,'cart-total')]")).click();
		//cromedriver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();
		cromedriver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();
		System.out.println("did a view CART EITH HP");
		
		
		new WebDriverWait(cromedriver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href,'#collapse-coupon')]"))).click();
		//cromedriver.findElement(By.xpath("//*[contains(@href,'#collapse-coupon')]")).click();
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		cromedriver.findElement(By.xpath("//*[contains(@name,'coupon')] ")).sendKeys("ABCD123");
		
		
		
		
		
		
		//*[@id="cart"]/ul/li[2]/div/p/a[2]/strong/text()
		 
		
		//cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
		//cromedriver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/div/a")).click();//click Show AllLaptops & Notebooks
		
		
		//cromedriver.findElement(By.xpath("//*[contains(@class,'btn btn-primary')]")).click();///click continue
		
		

		
	}
	public static void addToCartLapTops(WebDriver cromedriver) {
		//WebElement lapTopsHover = cromedriver.findElement(By.xpath("//a[contains(text(),'Laptops & Notebooks')]"));
		//cromedriver.findElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]")).click();
		//Actions action = new Actions(cromedriver); 
		//action.moveToElement(lapTopsHover).perform();
	
		//new WebDriverWait(cromedriver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a"))).click();
		//new WebDriverWait(cromedriver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a"))).click();
		//cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cromedriver.findElement(By.xpath("//*[contains(@class,'btn btn-primary')]")).click();
		//cromedriver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/div/a")).click();
		
		//*[@id="menu"]/div[2]/ul/li[2]/div/a
		//cromedriver.findElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]")).click();
		
	}
	public static void main(String[] args) {
		
		WebDriver cromedriver= new ChromeDriver();
		
		
		
		//WebDriver cromedriver= new FirefoxDriver();
		String url ="https://tutorialsninja.com/demo/";	
	
		addToCartCanonEOS(cromedriver,url);
		addToCartiPhone(cromedriver);
		//checkOutIphone(cromedriver);
		//addToCartLapTops(cromedriver);
		
		
//		cromedriver.findElement(By.xpath("//*[contains(@class,'fa fa-home')]")).click();/// got back to home 
//		cromedriver.findElement(By.xpath("//a[contains(text(),'iPhone')]")).click();  ///  click on iphone
//		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).clear();// clear the quantity 1
//		cromedriver.findElement(By.xpath("//*[contains(@name,'quantity')]")).sendKeys("2");//enter 2 quatity
//		cromedriver.findElement(By.xpath("//*[contains(@id,'button-cart')]")).click();// add to cart 
//		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebElement  successMessage = cromedriver.findElement(By.xpath("//*[contains(text(),'Success: You have added ')]"));
//		System.out.println(successMessage.getText());
		
		
		//cromedriver.findElement(By.xpath("//h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=40']")).click();
		//cromedriver.findElement(By.xpath("//input[@id='input-quantity']")).sendKeys("2");
		//cromedriver.findElement(By.xpath("//button[@id='button-cart']")).click();
		//WebElement totalPrice =cromedriver.findElement(By.xpath("//*[@id='cart-total']text()==' 1 item(s) - 96.66€'"));
		
		

		//cromedriver.close();
	}
}
