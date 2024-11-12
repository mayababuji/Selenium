package testNGSamples;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//Incase the depended method is false it skip the method
public class DependMethod {
	
	@Test 
	@Parameters({"value1","value2"})
	public void addMethod1(int value1, int value2) {
		
		int sumValue = value1 + value2;
		System.out.println(sumValue);
		assertEquals(sumValue, 10);
	}
	@Test(dependsOnMethods = "addMethod1")
	@Parameters({"value1","value2"})
	public void addMethod2(int value1, int value2) {
		
		int sumValue = value1 + value2;
		System.out.println(sumValue);
		
	}
	@Test 
	@Parameters({"value1","value2"})
	public void addMethod3(int value1, int value2) {
		
		int sumValue = value1 + value2;
		System.out.println(sumValue);
		
	}

}
