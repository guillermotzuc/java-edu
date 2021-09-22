package project.excercises.code.strings;

import java.util.Arrays;

public class VersionNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 0
		System.out.println(compare("15", "15.0"));
		// -1
		System.out.println(compare("10.1", "10.1.1"));
		// 1
		System.out.println(compare("10.1.2", "10.1.1"));
	}

	public static int compare(String v1, String v2) {
		
		int[] a1 = Arrays.stream(v1.split("\\."))
				.map(String::trim)
				.mapToInt(Integer::parseInt).toArray();
		
		int[] a2 = Arrays.stream(v2.split("\\."))
				.map(String::trim)
				.mapToInt(Integer::parseInt).toArray();
		
		int idx = 0;
		while(idx< a1.length || idx <a2.length) {
			
			if(idx <a1.length && idx < a2.length) {
				
				if(a1[idx] < a2[idx]) {
					
					return -1;
					
				} else if(a1[idx] > a2[idx]) {
					
					return 1;
				} 
			} else if(idx < a1.length) {
				
				if(a1[idx] != 0) {
					
					return 1;
				}
			} else if(idx < a2.length) {
				
				if(a2[idx] != 0) {
					
					return -1;
				}
			}
			
			idx++;
		}
		
		return 0;
	}
}
