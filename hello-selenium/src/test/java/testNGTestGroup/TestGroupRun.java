package testNGTestGroup;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.AssertJUnit;



public class TestGroupRun {
	String expectedmessage  = "TestNG";
	String testSalutationmsg = "Hi TestNG";
	String testExitnmsg = "Bye TestNG";
	MessageUtils msg = new MessageUtils(expectedmessage);
	@Test(groups = { "functest", "checkintest" })
	public void testmessage() {
		System.out.println(expectedmessage);
		assertEquals(expectedmessage,msg.printMessage() );
	}
	
	@Test(groups = { "checkintest" })
	public void testSalutationMessage() {
		System.out.println(testSalutationmsg);
		assertEquals(testSalutationmsg,msg.printSalutationMessage() );
	}
	
	@Test(groups = { "exittest" })
	public void testByeMessage() {
		System.out.println(testExitnmsg);
		assertEquals(testExitnmsg,msg.printExitMessage() );
	}
	
	@Test(groups = { "print" })
	public void testPrint() {
		System.out.println("print method");
	}

}
