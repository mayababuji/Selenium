package testNGParametrisedTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParametrised {
	@Test
	@Parameters("myTestString")

	public void parameterTestString(String myTestString) {
		System.out.println("the test String name is "+ myTestString);
		
	}
	@Test
	@Parameters("myTestValueInteger")
	

	public void parameterTestInteger(int myTestValueInteger) {
		System.out.println("the test Integer value is "+ myTestValueInteger);
		
	}
	
	//The boolean keyword is a data type that can only take the values true or false.
	
	@Test
	@Parameters("myTestBoolValue")
	public void parameterTestBool(boolean myTestBoolValue) {
		System.out.println("the test boolean value is "+ myTestBoolValue);
		
	}
	
	
	//The double keyword is a data type that can store fractional numbers from 1.7e−308 to 1.7e+308.
   //Note that you should end the value with a "d";
	@Test
	@Parameters("myTestDoubleValue")
	

	public void parameterTestDouble(double myTestDoubleValue) {
		System.out.println("the test double value is "+ myTestDoubleValue);
		
	}
	
	//The char keyword is a data type that is used to store a single character.
    //A char value must be surrounded by single quotes, like 'A' or 'c'.
	@Test
	@Parameters("myTestChar")
	

	public void parameterTestChar(char myTestChar) {
		System.out.println("the test Char value is "+ myTestChar);
		
	}
	
	//The byte keyword is a data type that can store whole numbers from -128 to 127.
	@Test
	@Parameters("myTestByte")
	

	public void parameterTestByte(byte myTestByte) {
		System.out.println("the test Byte value is "+ myTestByte);
		
	}
	
	
	//The float keyword is a data type that can store fractional numbers from 3.4e−038 to 3.4e+038.
     //Note that you should end the value with an "f":
	@Test
	@Parameters("myTestFloat")

	public void parameterTestFloat(float myTestFloat) {
		System.out.println("the test Float value is "+ myTestFloat);
		
	}
	
	//The long keyword is a data type that can store
	//whole numbers from -9223372036854775808 to 9223372036854775808.
	//Note that you should end the value with an "L":
	@Test
	@Parameters("myTestLong")
	public void parameterTestLong(long myTestLong) {
		System.out.println("the test Long value is "+ myTestLong);
		
	}
	
	//The short keyword is a data type that can store whole numbers from -32768 to 32767.
	@Test
	@Parameters("myTestShort")
	public void parameterTestShort(short myTestShort) {
		System.out.println("the test Short value is "+ myTestShort);
		
	}

}
