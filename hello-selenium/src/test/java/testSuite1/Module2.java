package testSuite1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Module2 {
	@BeforeTest
	public void beforeTest() {
		System.out.println("before every ******Test module 2 test suite1");
	}
	@Test
	public void test001() {
		System.out.println("i am 1st test module 2 test suite1");
	}
	@Test
	public void test002() {
		System.out.println("i am 2nd test module 2 test suite1");
	}
	@Test
	public void test003() {
		System.out.println("i am 3rd test module 2 test suite1");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after every *****Test module 2 test suite1");
	}

}
