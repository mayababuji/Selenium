package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class BstackDemo {
	
	public static void login(WebDriver cromedriver,String url,String username,String password) {
		cromedriver.manage().window().maximize();
		cromedriver.get(url);
		WebElement SignIn = cromedriver.findElement(By.id("signin"));
		SignIn.click();
		cromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cromedriver.findElement(By.cssSelector("#username input")).sendKeys("demouser" + Keys.ENTER);
		cromedriver.findElement(By.cssSelector("#password input")).sendKeys("testingisfun99" + Keys.ENTER);
		cromedriver.findElement(By.id("login-btn")).click();
		
		
		
		//WebElement userName = cromedriver.findElement(By.xpath("//*[contains(@id,'username')]"));//no such element: Unable to locate element: {"method":"xpath","selector":"//*[contains(@id,'username')]"}
		//WebElement userName = cromedriver.findElement(By.xpath("//*[contains(@class,'//*[contains(@class,' css-2b097c-container')]')]"));
		//Select objSelect =new Select(cromedriver.findElement(By.id("'//*[contains(@class,' css-1wa3eu0-placeholder')]")));
		
		//objSelect.selectByVisibleText("demouser");
		//cromedriver.findElement(By.cssSelector("#username input")).sendKeys("locked_user" + Keys.ENTER);
		
		
//		//WebElement userName = cromedriver.findElement(By.xpath("//*[contains(@name,'user-name')]"));
//		userName.sendKeys(username);
//		//WebElement passWord = cromedriver.findElement(By.id("password"));
//		WebElement passWord = cromedriver.findElement(By.xpath("//input[@id='password']"));
//		passWord.sendKeys(password);
//		//WebElement login = cromedriver.findElement(By.id("login-button"));
//		WebElement login = cromedriver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
//		login.click();
	}
		public static void main(String[] args) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			
			WebDriver cromedriver= new ChromeDriver(options);
			
			
			String url ="https://bstackdemo.com/";
			String username = "standard_user";
			String password = "secret_sauce";
			String firstName = "John";
			String lastName = "kennedy";
			String zipCode = "L5P30";
			login(cromedriver,url,username,password);
			

			//cromedriver.close();
		}

}
