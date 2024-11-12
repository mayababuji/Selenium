package testNGClassTest.testPrintMessage;



public class MessageUtils {
	String message;
	
	public MessageUtils(String message) {
		this.message = message;
	}

	public String printMessage() {
		
		return message;
	}
	public int failedTest() {
		int a = 0;
		int b = 1;
		int sum = b/a;
		return sum;
	}
	
	 public String ignoreTest() {
		
		return "i am ignored";
	}

}
