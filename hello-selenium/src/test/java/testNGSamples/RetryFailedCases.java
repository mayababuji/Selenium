package testNGSamples;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class RetryFailedCases {
	@Test(retryAnalyzer = RetryFailed.class)
	public void test1() {
		System.out.println("running test 1");
		assertTrue(false);
		System.out.println(" test 1 passed");
	}
	@Test
	public void test2() {
		System.out.println("running test 2");
		assertTrue(false);
		System.out.println(" test 2 passed");
	}
	@Test
	public void test3() {
		System.out.println("running test 3");
		assertTrue(true);
		System.out.println(" test 3 passed");
	}

}
