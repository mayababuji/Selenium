package testNGParametrisedTest;

public class PrimeNumberValidate {
	//constructor
	public PrimeNumberValidate() {
		
	}
	
	public Boolean primeValidate(int primeNumber) {
		for (int i =2;i<(primeNumber/2);i++) {
			if (primeNumber%i==0){
				return false;
			}
			
		}
		return true;
	}

}
