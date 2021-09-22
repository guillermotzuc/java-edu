package testcodes.towarmup.recursion.timecomplexity;

import java.util.stream.IntStream;

public class Sample01 {

	static int highestValue = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		System.out.println(findBiggerNumber(new int[] {19,15,9,30}, 3));
		System.out.println(findBiggerNumber(new int[] {19,15,9,30}));
	}
	
	static int findBiggerNumber(int[] array, int n) {
		
		if(n == -1)
			return highestValue;
		else if(array[n]> highestValue){
			highestValue = array[n];
		}
		
		return findBiggerNumber(array, n - 1);
	}
	
	static int findBiggerNumber(int[] array) {
		
		return IntStream.of(array).max().getAsInt();
	}
}
