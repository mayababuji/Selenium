package testNGParametrisedTest;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;


public class testPrimeNumberDataProvider {
	PrimeNumberValidate primobj = new PrimeNumberValidate();

	 @DataProvider(name = "test1")    
	 public static Object[][] primeNumbers() {       
   return new Object[][] { 
	   { 2, true }, { 6, false }, { 19, true },        
	   { 22, false }, { 23, true } };    
	   }
	 
	 @Test(dataProvider = "test1")    
	 public void testPrimeNumberChecker(Integer inputNumber,Boolean expectedResult) { 
	
	  System.out.println(inputNumber + " " + expectedResult);
	  assertEquals(expectedResult,primobj.primeValidate(inputNumber));    }
	
}
