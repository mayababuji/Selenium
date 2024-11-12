package testNGSamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Annotations {
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}
	
	@Test
	public void sampleTest() {
		System.out.println("running sample test ");
	}
	
	@Test (groups = "run smoke")
	public void sampleGroup() {
		System.out.println("running sample group smoke test ");
	}
	@BeforeGroups("run smoke")
	public void beforeGroups() {
		System.out.println("running before smoke groups ");
	}
	@AfterGroups("run smoke")
	public void afterGroups() {
		System.out.println("running after smoke groups ");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("before test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("before method");
	}
	

}
