package termProject;

import java.util.StringTokenizer;

public class Phone {
	private final String first_number = "010";
	private final String delimiter = "-";
	private String number;
	
	public Phone() {
		number = first_number + delimiter + "0000" + delimiter + "0000";
	}
	public Phone(String phoneNumber) {
		editNumber(phoneNumber);
	}
	
	public void editNumber (String phoneNumber) {
		number = first_number + delimiter;
		
		if (phoneNumber.contains("-")) {
			StringTokenizer tokens = new StringTokenizer(phoneNumber, "-");
			tokens.nextToken();
			number += tokens.nextToken() + delimiter;
			number += tokens.nextToken();
		} else {
			number += phoneNumber.substring(3, 7) + delimiter;
			number += phoneNumber.substring(7, 11);
		}
	}
	
	public String toString () {
		return number;
	}
}
