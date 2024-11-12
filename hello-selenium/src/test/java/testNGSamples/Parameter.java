package testNGSamples;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameter {
	//You want to pass the input from xml sheet at that time parameters are used
	@SuppressWarnings("deprecation")
	//You have to give @parameter annotation on the testcase
	//you need to run your xml suite to provide a valid parameter to your TestNG class.
	@Test
	@Parameters({"username","password"})
	public void parameterSample1(String name , String password) {
		System.out.println("username for test 1 is "+name);
		System.out.println("passwrod for test 1 is "+password);
		System.out.println("Method parameterSample1 is in thread "+ Thread.currentThread().getId());
		System.out.println("Method parameterSample1 is in thread "+ Thread.currentThread().getName());
		
	}
	@SuppressWarnings("deprecation")
	@Test
	@Parameters({"username","password"})
	public void parameterSample2(String nam , String pass) {
		System.out.println("username for test 2 is "+nam);
		System.out.println("passwrodfor test2  is "+pass);
		System.out.println("Method parameterSample2 is in thread "+ Thread.currentThread().getId());
		System.out.println("Method parameterSample2 is in thread "+ Thread.currentThread().getName());
		
		
	}
	/*
	 * @Optional Incase of parameter is not exactly matched 
	 * @optional is used You have to pass the value at the time of initialization:
	 * Here it take the value from the optional not from the parameter
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Parameters({"user","pass"})
	public void parameterSample3(@Optional("optional_maya") String nam ,  @Optional("Optional_pass")  String pass) {
		System.out.println("username for test 2 is "+nam);
		System.out.println("passwrodfor test2  is "+pass);
		System.out.println("Method parameterSample3 is in thread "+ Thread.currentThread().getId());
		System.out.println("Method parameterSample3 is in thread "+ Thread.currentThread().getName());
		// 
		
	}

}
