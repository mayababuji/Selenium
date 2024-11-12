package testNGSamples;

import org.testng.annotations.Test;

public class InvocationCount {
	@SuppressWarnings("deprecation")
	@Test(invocationCount = 2,priority =2)
	public void invocation2times() {
		System.out.println("invocation 2 times");
		System.out.println("Method invocation2times is in thread "+ Thread.currentThread().getId());
		System.out.println("Method invocation2times is in thread "+ Thread.currentThread().getName());
		
	}
	@SuppressWarnings("deprecation")
	@Test(invocationCount = 3,priority =1,description = "i am first")
	public void invocation3times() {
		System.out.println("invocation 3 times");
		System.out.println("Method invocation3times is in thread "+ Thread.currentThread().getId());
		System.out.println("Method invocation3times is in thread "+ Thread.currentThread().getName());
		
		
		
	}
	//For ignoring the testcase We can use one method called Enabled
	//When we use enabled=false,It will skip the particular test case
	@SuppressWarnings("deprecation")
	@Test(invocationCount = 10,priority =100,description = "i am not running",enabled=false)
	public void invocation10times() {
		System.out.println("invocation 10 times");
		System.out.println("Method invocation10times is in thread "+ Thread.currentThread().getId());
		System.out.println("Method invocation10times is in thread "+ Thread.currentThread().getName());
		
		
		
	}

}
