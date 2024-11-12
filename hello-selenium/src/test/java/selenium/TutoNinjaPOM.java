package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TutoNinjaPOM {
	
	static By currencySelectBtn = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
	static By euroSelectBtn = By.xpath("//button[@name='EUR']");
	static By canonEosBtn = By.xpath("//h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=30']");
	static By canonAddtoCart = By.xpath("//button[@id='button-cart']");
	static By selectRequiredMsg = By.xpath("//div[@id='product']/div[1]/div");
	static By homeBtn = By.xpath("//i[contains(@class,'fa fa-home')]");
	static By iphoneBtn = By.xpath("//a[contains(text(),'iPhone')]");
	static By iphoneQuantity = By.xpath("//input[contains(@name,'quantity')]");
	static By iphoneAddcart = By.id("button-cart");
	static By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	static By cartIcon = By.xpath("//span[contains(@id,'cart-total')]");
	static By viewCartBtn = By.xpath("//strong[contains(text(),'View Cart')]");
	static By updateBtn = By.xpath("//button[contains(@data-original-title,'Update')]");
	static By ecoTax = By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[2]");
	static By vatTax = By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[3]");
	static By checkOutBtn = By.xpath("//a[contains(text(),'Checkout')]");
	static By removeBtn = By.xpath("//i[contains(@class,'fa fa-times-circle')]");
	
	
	
	
	public static void addToCartCanonEOS(WebDriver driver,String url) {
		/*
		 *1.  Launch the application https://tutorialsninja.com/demo/
		 */
		String expectedErrorMessage = "Select required!";
		driver.manage().window().maximize();
		try {
		driver.get(url);
		
		//2.  Select the currency in the left top corner to Euro
		driver.findElement(currencySelectBtn).click();
		driver.findElement(euroSelectBtn).click();
		
		/*
		 *3.  Try to order a canon EOS 5 D camera and collect the error message occurred due to a
		 *	  bug in select option by clicking add to cart.
		 */
		driver.findElement(canonEosBtn).click();
		driver.findElement(canonAddtoCart).click();
		WebElement selectError =driver.findElement(selectRequiredMsg);
		String actualErrorMessage = selectError.getText();
		System.out.println(selectError.getText());
		
		if (actualErrorMessage.equals(expectedErrorMessage)) {
			System.err.println("The select option is disabled ,error  is "+ actualErrorMessage);
		}
		}
		catch(Exception e) {
			System.out.println("Test case addToCartCanonEOS failed ");
			e.printStackTrace();
		}


		
	}
	
	public static void addToCartiPhone(WebDriver driver) {
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*4.  Move to the home screen by clicking home icon, Click on iphone and go to details screen, 
		 * change the quantity to two then add to cart.
		 */
		try {
		driver.findElement(homeBtn).click();
		driver.findElement(iphoneBtn).click();  
		driver.findElement(iphoneQuantity).clear();
		driver.findElement(iphoneQuantity).sendKeys("2"); 
		driver.findElement(iphoneAddcart).click();
		
		//5.  Print the success message in the console
		WebElement  successele = driver.findElement(successMessage);
		System.out.println("Printing Success message for  iPhone to the shopping cart");
		System.out.println(successele.getText());
		
		//6.  Click on the cart icon (black color) in the right side top then click view cart
		driver.findElement(cartIcon).click();
		driver.findElement(viewCartBtn).click();
		
		//7.  Change the quantity of iphone to 3 and click update button
		driver.findElement(iphoneQuantity).clear();
		driver.findElement(iphoneQuantity).sendKeys("3");
		driver.findElement(updateBtn).click(); 
		WebElement successModifiedMessage = driver.findElement(successMessage);
		System.out.println("Printing Success message for modified shopping cart");
		System.out.println(successModifiedMessage.getText());
		
		//8.  Print the Eco tax and VAT Amount in console and click Checkout button
		WebElement ecoTaxElem = driver.findElement(ecoTax);
		System.out.println("The ECO tax is : "+ecoTaxElem.getText());
		WebElement vatElem = driver.findElement(vatTax);
		System.out.println("The VAT is : "+vatElem.getText());
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click(); 
		
		//9.  Print the error message and remove the product from the cart
		WebElement errorCheckoutElem = driver.findElement(checkOutBtn);
		System.err.println("Printing the error message product are not available");
		System.out.println(errorCheckoutElem.getText());
		driver.findElement(removeBtn).click();
		}
		catch(Exception e) {
			System.out.println("Test case addToCartiPhone failed ");
			e.printStackTrace();
		}

		
		
	}
	
	
	
	public static void main(String[] args) {
		FirefoxOptions options = new FirefoxOptions();
	    options.addPreference("browser.cache.disk.enable", false);
	    options.addPreference("browser.cache.memory.enable", false);
		WebDriver firefox= new FirefoxDriver(options);
		firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String url ="https://tutorialsninja.com/demo/";	
		addToCartCanonEOS(firefox,url);
		addToCartiPhone(firefox);

}
}
