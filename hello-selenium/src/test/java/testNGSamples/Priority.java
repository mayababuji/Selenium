package testNGSamples;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Priority {
	@Test
	public void sample1() {
		System.out.println("test Priority none runs 2nd");
	}
	@Test(priority = 3)
	public void sample2() {
		System.out.println("test Priority 3  runs 4th");
	}
	@Test(priority = 2)
	public void sample3() {
		System.out.println("test Priority 2 runs 3rd");
	}
	@Test(priority = 4)
	public void sample4() {
		System.out.println("test Priority 4 runs 5th ");
	}
	@Test(priority = 5)
	public void sample5() {
		System.out.println("test Priority 5 6th");
	}
	@Test(priority = 100)
	public void sample6() {
		System.out.println("test Priority100 runs  7th");
	}
	
	@Test(priority = -3)
	public void sample7() {
		System.out.println("test with Priority - 3 runs 1st");
	}
	
	
	

}
