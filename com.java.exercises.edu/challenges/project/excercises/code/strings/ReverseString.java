package project.excercises.code.strings;

public class ReverseString {

	public static void main(String[] args) {
		
		System.out.println(reverse("hel"));
	}
	
	public static String reverse(String text) {
		
		char[] chars = text.toCharArray();
		final int arrayLength = chars.length;
		
		char tmp;
		for(int idx = 0; idx < arrayLength/2; idx++) {
			
			//just odd numbers
			// if ((idx + 1) % 2 != 0){
			//}
			
			tmp = chars[idx];
			chars[idx] = chars[arrayLength-1 - idx];
			chars[arrayLength-1 - idx] = tmp;
		}
		
		return String.valueOf(chars);
	}
}
