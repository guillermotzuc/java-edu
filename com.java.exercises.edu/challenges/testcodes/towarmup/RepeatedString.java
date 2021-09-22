package testcodes.towarmup;

import java.util.ArrayList;
import java.util.List;

public class RepeatedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		repeatedString("aba", 10);
	}
	
	 static long repeatedString(String s, long n) {
		 long count = 0;
		 long aCharacteresInS = countACharacteres(s);
		 if( n % s.length() == 0) {
			
			 long ns = (n/s.length());
			 count = ns * aCharacteresInS;
		 } else {
			 
			 long ns = (n/s.length());//Complete serie
			 long needed = n - (s.length() * ns); //new serie to rich n
			 count = (n/s.length()) * aCharacteresInS;
			 char[] array = s.toCharArray();
			 for(int i = 0; i<needed ;i++) {
				 if(array[i] =='a'){
					 count++;
				 }
			 }
			 
		 }
		 
		 return count;
	 }

	public static long countACharacteres(String s) {
		
		long count = 0;
		 char[] array = s.toCharArray();
		for(int i =0; i< array.length; i++) {
			if(array[i] =='a'){
				count++;
			}
		}
		
		return count;
	}
}
