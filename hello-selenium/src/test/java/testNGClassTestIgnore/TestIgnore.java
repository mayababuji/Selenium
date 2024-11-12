package testNGClassTestIgnore;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestIgnore {
	String testmessage = "Hello Testng";
	String testSalutationmsg = "Hi Hello Testng";
	MessageUtils messageutils = new MessageUtils(testmessage);
	//A test method annotated with @Testenabled=false,
	//then the test case that is not ready to test is bypassed.
	@Test(enabled = false)
	public void testPrintMessage() {
		System.out.println(testmessage);
		assertEquals(testmessage, messageutils.printMessage());
	}
		
   @Test
	public void testSalutationtMessage() {
		System.out.println(testSalutationmsg);
		assertEquals(testSalutationmsg, messageutils.printSalutationMessage());
		
		
	}

}
