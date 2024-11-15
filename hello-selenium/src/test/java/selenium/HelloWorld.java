package selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver.exe");
		WebDriver cromedriver= new FirefoxDriver();
		//WebDriver chromedriver = new ChromeDriver();
		cromedriver.get("https://amazon.com");
		
	}

}
