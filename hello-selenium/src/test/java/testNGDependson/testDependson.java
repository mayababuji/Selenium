package testNGDependson;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class testDependson {
	Dependson depobj = new Dependson();

	@Test(priority = -9)
	public void testText() {
		
		System.out.println(depobj.text);

	}
	
	@Test(dependsOnGroups= {"printbeforeGuest"})
	public void testWelcome() {
		
		System.out.println(depobj.textWelcome);

	}
    @Test(priority = 100)
	public void testBye() {
	
	System.out.println(depobj.textBye);

	}
    @Test(groups= {"printbeforeGuest"})
    
    public void testArrving() {
    	
    	System.out.println(depobj.textGuestArriving);

    	}
    
    @Test(priority = 99)
    public void testArrived() {
    	
    	System.out.println(depobj.textGuestArrived);

    	}
    
}
