package testSuite1;
//program
import dsutilities.LoggerLoad;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Module1 {
	@BeforeTest
	public void beforeTest() {
		LoggerLoad.debug("Method before LOGGER STATEMENT");
		//System.out.println("before every ******Test module 1 test suite1");
	}
	@Test
	public void test001() {
		LoggerLoad.error("Method test001  LOGGER STATEMENT");
		//System.out.println("i am first 1st module 1 test suite1");
	}
	@Test
	public void test002() {
		LoggerLoad.info("Method test002  LOGGER STATEMENT");
		//System.out.println("i am 2nd test module 1 test suite1");
	}
	
	@Test //(groups = "smoke")
	public void test003() {
		//System.out.println("i am 3rd test module1 test suite1");
	}
	@Test
	public void test004() {
		//System.out.println("i am 4rd test module1 test suite1");
	}
	@Test
	public void test005() {
		System.out.println("i am 5rd test module1 test suite1");
	}
	@AfterTest
	public void afterTest() {
		//LoggerLoad.info("Method after");
		System.out.println("after every ****Test module 1 test suite1");
	}

}
