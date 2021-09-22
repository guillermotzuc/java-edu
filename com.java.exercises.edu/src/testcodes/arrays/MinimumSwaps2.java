package testcodes.arrays;

import java.util.stream.IntStream;

public class MinimumSwaps2 {

	public static void main(String[] args) {
		System.out.println(minimumSwaps(IntStream.of(2,3,4,1,5).toArray()));
	}

    static int minimumSwaps(int[] arr) {
    	
    	int[] originalArray = IntStream.of(arr).toArray();
    	int[] orderedArray = IntStream.of(arr).sorted().toArray();
    	int numberOfSwap = 0;
    	for(int i=0; i< orderedArray.length; i++) { 
    		
    		if(orderedArray[i] != originalArray[i]) {
    		
    			for(int j=i+1; j< originalArray.length; j++) {
    			
    				if(orderedArray[i] == originalArray[j]) {
    			        int temp = originalArray[i];
    			        originalArray[i] = originalArray[j];
    			        originalArray[j] = temp;
    					numberOfSwap++;
    					break;
    				}
    			}
    		}
    	}
    	return numberOfSwap;
    }
}
