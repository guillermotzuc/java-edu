package testcodes.towarmup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(pairs(2, new int[] { 1, 5, 3, 4, 2 }));
		//1,2,3,4,5
	}

	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {

		Arrays.sort(arr);
		
	    int i=0,j=1,count=0, n= arr.length;
	    
	    while(j < n) {
	        int diff = arr[j] - arr[i];
	        
	        if (diff == k) {
	            count++;
	            j++;
	        } else if (diff > k) {
	            i++;
	        } else if (diff < k) {
	            j++;
	        }
	    }
	    
	    return count;
	}

}
