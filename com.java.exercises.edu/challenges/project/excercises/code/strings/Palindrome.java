package project.excercises.code.strings;

public class Palindrome {

	public static void main(String[] args) {

		System.out.println(isPalindrome("2f1"));
		System.out.println(isPalindrome("101"));

	}

	public static boolean isPalindrome(String text) {
		
		final int length = text.length();
		for(int idx = 0; idx < length/2; idx++ ) {
			
			if(text.charAt(idx) != text.charAt(length-1-idx)){
				
				return false;
			}
		}
		
		return true;
	}
}
