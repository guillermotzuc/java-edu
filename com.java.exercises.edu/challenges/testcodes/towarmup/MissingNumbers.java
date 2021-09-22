package testcodes.towarmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumbers {

    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
////		int[] arr = {203,204, 205, 206, 207, 208, 203, 204, 205, 206};
////		int[] brr = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
//
//		int[] arr = { 11, 4, 11, 7, 13, 4, 12, 11, 10, 14 };
//		int[] brr = { 11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12};
//		
//		missingNumbers(arr, brr);
		
		 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/guillermoMac/Desktop/input.txt"));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] arr = new int[n];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        int m = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] brr = new int[m];

	        String[] brrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < m; i++) {
	            int brrItem = Integer.parseInt(brrItems[i]);
	            brr[i] = brrItem;
	        }

	        Integer[] result = missingNumbers(arr, brr);

	        for (int i = 0; i < result.length; i++) {
	            bufferedWriter.write(String.valueOf(result[i]));

	            if (i != result.length - 1) {
	                bufferedWriter.write(" ");
	            }
	        }

	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	}

	// Complete the missingNumbers function below.
	static Integer[] missingNumbers(int[] arr, int[] brr) {

		Set<Integer> result = new HashSet<>();
		for(int i = 0, j = 0; (i < brr.length); i++ ) {

			if((j >= arr.length)) {
				
				result.add(brr[i]);
				continue;
			}
			
			System.out.println(brr[i]);
			System.out.println(arr[j]);
			
			result.add((brr[i] == arr[j]) ? 0 : brr[i]);

			System.out.println(result);
			
			if(brr[i] == arr[j])
				j++;
		}
		
		Integer[] newArray = result.stream().filter(i -> i > 0)
		.collect(Collectors.toList()).toArray(new Integer[0]);
		return newArray;
	}
}
