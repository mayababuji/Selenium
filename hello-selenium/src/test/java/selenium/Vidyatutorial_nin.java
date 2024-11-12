


package selenium;

import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Vidyatutorial_nin {

	public static void main(String[] args) {
		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		
		//WebDriver driver = new ChromeDriver(options);
		//System.setProperty("webdriver.chrome.verboseLogging", "true");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); ////   newly added
		driver.get("chrome://settings/clearBrowserData"); ////   newly added
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);////   newly added
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	

	
		driver.get("https://tutorialsninja.com/demo");
		
		WebElement button = driver.findElement(By.xpath("//div/button[@class='btn btn-link dropdown-toggle']")); /* selection of drop down*/
		button.click();

		WebElement button1 = driver.findElement(By.xpath("//*[text()='€Euro']")); /* select EURo*/
		button1.click();

		// WebElement addCartButton= driver.findElement(By.xpath("//a[text()='Canon EOS 5D']/../../../div[3]/button/span[text()='Add to Cart']"));
		// addCartButton.click();
		
		
		System.out.println("Printing error");/* print error in select */
		
		driver.findElement(By.xpath("//h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=30']")).click(); /*click canon*/

		driver.findElement(By.xpath("//select[@name='option[226]']")).click(); /*select text box*/

		driver.findElement(By.xpath("//button[@id='button-cart']")).click(); /* add to cart*/

		WebElement home = driver.findElement(By.xpath("//i[contains(@class,'fa fa-home')]")); /* go to home*/
		home.click();

		driver.findElement(By.xpath( "//h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=40']")).click();/* select iphone*/
		 
		WebElement quantity = driver.findElement(By.id("input-quantity")); /* select 2 iphone*/
		quantity.clear(); 
		quantity.sendKeys("2");
	  
	  
		WebElement addcart= driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary btn-lg btn-block')]")); /*add to cart*/
		addcart.click();
	  
		System.out.println("Printing Success message");/* print success in console*/
		
		
		
		WebElement clickcart= driver.findElement(By.xpath("//button[contains(@class,'btn btn-inverse btn-block btn-lg dropdown-toggle')]")); /*see to cart*/
		clickcart.click();
		
		
		
		WebElement viewcart = driver.findElement(By.xpath("//p//a/strong[text()='View Cart']")); /* select view cart*/
		viewcart.click();
		
		driver.findElement(By.xpath("//*[contains(@name,'quantity')]")).clear();/// clear the value 2

		driver.findElement(By.xpath("//*[contains(@name,'quantity')]")).sendKeys("3"); // add iphone value 3
		
		
		driver.findElement(By.xpath("//*[contains(@data-original-title,'Update')]")).click(); //click update
		
		WebElement ecoTax = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[2]/td[2]")); /* print ecotax*/
		System.out.println(ecoTax.getText());
		
		WebElement vat = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[3]/td[2]"));/* printvat*/
		System.out.println(vat.getText());
		
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click(); 
		
		WebElement errorCheckout = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		
		System.out.println(errorCheckout.getText());
		
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-times-circle')]")).click();  /*remove product*/
		
		
		driver.findElement(By.xpath("//*[contains(@class,'fa fa-home')]")).click();///click home button
	
		driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a")).click();  ////   newly added
		driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a")).click();////   newly added
		driver.findElement(By.xpath("//*[@class='caption']//h4/a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&path=18&product_id=47']")).click();////   newly added
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();////   newly added


	}

}
