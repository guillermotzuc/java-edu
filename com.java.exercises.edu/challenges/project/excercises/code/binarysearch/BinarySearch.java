package project.excercises.code.binarysearch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BinarySearch {

	public static void main(String[] args) {

		/* Write a function, that gets the index of a 
		 * number if exist or return -1 if its not
		 * */
		int array[] = IntStream.range(1, 5000)
					.boxed().mapToInt(n -> n * 100)
					.sorted()
					.toArray();
		
		int end = array.length -1;
		int start = 0;
		int target = 700;
		System.out.println(binarySearch(array, start, end, target));
		System.out.println(Arrays.binarySearch(array, 200));
		
		
	}
	
	public static boolean binarySearch(int[] array, int start, int end, int target) {
		
		if(start>end) return false;
		
		int midIndex = Math.floorDiv(start + end, 2);
		if(array[midIndex] == target) return true;
		
		//if mid = 4
		// 4 < 2
		if(array[midIndex] < target) return binarySearch(array,  midIndex+1 , end , target);
		else return binarySearch(array, start, midIndex-1, target);
	}

}
