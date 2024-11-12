package testNGExceptionTest;

public class ArthmethicOperation {
	int value1;
	int value2;
	//constructor
	public ArthmethicOperation (){

	}
	
	public int additionFunction(int value1,int value2) {
		
		int sum = value1 + value2;
		return sum;
		
	}
public int subtractFunction(int value1,int value2) {
		
		int sum = value1 - value2;
		return sum;
		
	}
public int arthexception() {
	int a = 0;
	int b = 1/a;
	return b;
}

}
