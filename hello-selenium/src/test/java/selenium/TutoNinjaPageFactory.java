package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TutoNinjaPageFactory {
	
	@FindBy (xpath = "//button[@class='btn btn-link dropdown-toggle']") WebElement currencySelectBtn;
	@FindBy (xpath = "//button[@name='EUR']")  WebElement  euroSelectBtn;
	@FindBy (xpath = "//h4//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=30']")  WebElement canonEosBtn;
	@FindBy (xpath = "//button[@id='button-cart']")  WebElement canonAddtoCart;
	@FindBy (xpath = "//div[@id='product']/div[1]/div")  WebElement selectRequiredMsg;
	@FindBy (xpath = "//i[contains(@class,'fa fa-home')]") WebElement homeBtn;
	@FindBy (xpath = "//a[contains(text(),'iPhone')]") WebElement iphoneBtn;
	@FindBy (xpath = "//input[contains(@name,'quantity')]") WebElement iphoneQuantity;
	@FindBy (id = "button-cart") WebElement iphoneAddcart;
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
	@FindBy (xpath = "//span[contains(@id,'cart-total')]") WebElement cartIcon;
	
	@FindBy (xpath = "//strong[contains(text(),'View Cart')]") WebElement viewCartBtn;
	@FindBy (xpath = "//button[contains(@data-original-title,'Update')]") WebElement updateBtn;
	@FindBy (xpath = "//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[2]") WebElement ecoTax;
	@FindBy (xpath = "//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr[3]") WebElement vatTax;
	@FindBy (xpath = "//a[contains(text(),'Checkout')]") WebElement checkOutBtn;
	
	@FindBy (xpath = "//i[contains(@class,'fa fa-times-circle')]") WebElement removeBtn;
	


	public  void addToCartCanonEOS(WebDriver driver,String url) {
		/*
		 *1.  Launch the application https://tutorialsninja.com/demo/
		 */
		String expectedErrorMessage = "Select required!";
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		try {
			driver.get(url);
			
			//2.  Select the currency in the left top corner to Euro
			currencySelectBtn.click();
			euroSelectBtn.click();
			
			//driver.findElement(By.xpath("//select[@name='option[226]']")).click();
			
			/*
			 *3.  Try to order a canon EOS 5 D camera and collect the error message occurred due to a
			 *	  bug in select option by clicking add to cart.
			 */
			canonEosBtn.click();
			canonAddtoCart.click();
			selectRequiredMsg.getText();
			String actualErrorMessage = selectRequiredMsg.getText();
			System.out.println(selectRequiredMsg.getText());
			
			if (actualErrorMessage.equals(expectedErrorMessage)) {
				System.err.println("The select option is disabled ,error  is "+ actualErrorMessage);
			}
		}
			catch(Exception e) {
				System.out.println("Test case addToCartCanonEOS failed ");
				e.printStackTrace();
			}


		
	}
	
	
public  void addToCartiPhone(WebDriver driver) {
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*4.  Move to the home screen by clicking home icon, Click on iphone and go to details screen, 
		 * change the quantity to two then add to cart.
		 */
	   PageFactory.initElements(driver, this);
		try {
		homeBtn.click();
		iphoneBtn.click();  
		iphoneQuantity.clear();
		iphoneQuantity.sendKeys("2"); 
		iphoneAddcart.click();
		
		//5.  Print the success message in the console
		System.out.println("Printing Success message for  iPhone to the shopping cart");
		System.out.println(successMessage.getText());
		
		//6.  Click on the cart icon (black color) in the right side top then click view cart
		cartIcon.click();
		viewCartBtn.click();
		
		//7.  Change the quantity of iphone to 3 and click update button
		iphoneQuantity.clear();
		iphoneQuantity.sendKeys("3");
		updateBtn.click(); 
		System.out.println("Printing Success message for modified shopping cart");
		System.out.println(successMessage.getText());
		
		//8.  Print the Eco tax and VAT Amount in console and click Checkout button

		System.out.println("The ECO tax is : "+ecoTax.getText());
		System.out.println("The VAT is : "+vatTax.getText());
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click(); 
		
		//9.  Print the error message and remove the product from the cart
	
		System.err.println("Printing the error message product are not available");
		System.out.println(checkOutBtn.getText());
		removeBtn.click();
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
		firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String url ="https://tutorialsninja.com/demo/";	
		TutoNinjaPageFactory tutoNinjaPageFactory = new TutoNinjaPageFactory();
		
		tutoNinjaPageFactory.addToCartCanonEOS(firefox, url);
		tutoNinjaPageFactory.addToCartiPhone(firefox);

}

}
