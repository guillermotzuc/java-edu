package testcodes.towarmup;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		isCasiPalindromo("abccbx");
	}
	
	
	public static boolean isCasiPalindromo(String value) {
		
		StringBuilder reversedString = new StringBuilder();
		char[] stringChar = value.toCharArray();
		
		for(int i = stringChar.length-1; i>=0; i--) {
			
			reversedString.append(stringChar[i]);
		}
		
		if(reversedString.toString().equals(value)) {
			
			return true;
		}else {
			
			char[] reversedStringCharArray = reversedString.toString().toCharArray();
			int count = 0;
			for(int i =0; i< reversedStringCharArray.length; i++) {
				
				char reversedChar = reversedStringCharArray[i];
				char valueChar = stringChar[i];
				
				if(reversedChar != valueChar)
					count++;
				
				if(count>1) {
					return false;
				}
			
			}
			
			if(count==1)
				return true;
			
		}
		return false;
	}

}
