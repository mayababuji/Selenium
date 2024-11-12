package testNGExceptionTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestException {
	int val1 = 2;
	int val2 = 3;
	
	
	ArthmethicOperation arthobj = new ArthmethicOperation();
	@Test
	public void testAdd() {
		int sum =arthobj.additionFunction(val1,val2);
		System.out.println(sum);
		}

	@Test
	public void testSubtract() {
		int sum =arthobj.subtractFunction(val1,val2);
		System.out.println(sum);
		}
	@Test(expectedExceptions = ArithmeticException.class)
	public void testArthmenticException() {
		System.out.println("will not have any failures since it is an expected exception");
		arthobj.arthexception();
		
	}
}
