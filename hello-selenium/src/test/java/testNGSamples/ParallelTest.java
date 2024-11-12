package testNGSamples;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
//parallel = "true"  --> methods in a class are run in parallel
// parallel - " classes"  --> if more than one class specified in paramater_testngxml then they will run parallel
// parallel = "methods" --> methods in that will be parallel (one thread)
//parallel = "test"    --> all the tests mentioned will run in one thread
public class ParallelTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void paralleltest1() {
		System.out.println("Method 1 is in thread "+ Thread.currentThread().getId());
		System.out.println("Method 1 is in thread "+ Thread.currentThread().getName());
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void paralleltest2() {
		System.out.println("Method 2 is in thread "+ Thread.currentThread().getId());
		System.out.println("Method 2 is in thread "+ Thread.currentThread().getName());
		
	}

}
