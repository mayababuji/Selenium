package testNGTestGroup;

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
	
  public String printExitMessage() {
		
		return "Bye " + message;
	}
}
