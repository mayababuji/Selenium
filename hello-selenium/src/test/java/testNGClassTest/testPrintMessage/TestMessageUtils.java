package testNGClassTest.testPrintMessage;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;




public class TestMessageUtils {
	String testmessage = "Hello Testng";
	int invocationcount = 0;
	MessageUtils messageutils = new MessageUtils(testmessage);
	
	
	@Test
	public class MyTest {

	}
	@Test
	public void testPrintMessage() {
		System.out.println(testmessage);
		assertEquals(testmessage, messageutils.printMessage());
		
		
	}
	@Test( dependsOnMethods = { "testFailedmethod" })
	
	public void testIgnoremethod() {
		messageutils.ignoreTest();
	}
	@Test(successPercentage = 50,invocationCount=2)
	public void testFailedmethod() {
		
		
		invocationcount++;
		
	
		System.out.println("Test Failed But Within Success Percentage Test Method, invocation count: " + invocationcount);
		messageutils.failedTest();
		
	}
	

	
	

}
