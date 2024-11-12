package testNGClassTestIgnore;

public class MessageUtils {
	String message;
	
	public MessageUtils(String message) {
		this.message = message;
	}

	public String printMessage() {
		
		return message;
	}
	
	public String printSalutationMessage() {
		
		return "Hi " + message;
	}

}
