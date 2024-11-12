package testNGDependson;

public class Dependson {
	String text = " Guest";
	String textWelcome = "Hi Welcome"+text;
	String textBye = "Bye "+ text + " see you soon";
	String textGuestArriving =  text +  " arriving";
	String textGuestArrived = text + " arrived";
	//creating constructor
	public Dependson() {
		
	}
	public String printText() {
		
		return text;
	}
	
	public String printWelcome() {
		return textWelcome ;
	}
	public String printBye() {
		return textBye;
		
	}
	public String printGuestArriving() {
		return textGuestArriving;
		
	}
	public String printGuestArrived() {
		return textGuestArrived;
		
	}

}
