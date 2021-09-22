package testcodes.towarmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockArray {

	public static void main(String[] args) {

//		List<Integer> arr = Arrays.asList(1,1, 4, 1, 1);
		System.out.println(balancedSums(Arrays.asList(1)));
		System.out.println(balancedSums(Arrays.asList(1, 1, 4, 1, 1)));
		System.out.println(balancedSums(Arrays.asList(2, 0, 0, 0)));
		System.out.println(balancedSums(Arrays.asList(0, 0, 2, 0)));
		
	}
	
    static String balancedSums(List<Integer> arr) {
    	
    	if(arr.size() == 1) {
    		return "YES";
    	}
    	
    	// <- x -> y <- x -> = sum
    	// 2x  = sum - y
    	int sum = arr.stream().mapToInt(i -> i).sum();
    	int x = 0;
    	int y = 0;
    	for(int i = 0; i< arr.size() - 1; i++) {
    		
    		x += y;
    		y = arr.get(i);
    		if((2 * x) == sum - y) {
    			
    			return "YES";
    		}
    		
    	}

    	return "NO";
    }
    
// FIRST APPROACH
// Complete the balancedSums function below.
//    static String balancedSums(List<Integer> arr) {
//
//    	for(int i = 0; i< arr.size() - 1; i++) {
//    		
//    		List<Integer> leftList = arr.subList(i + 1, arr.size());
//    		List<Integer> rightList = (i == 0)  ? new ArrayList<>() : arr.subList(0, i);
//    		
//    		long leftVal = leftList.stream().mapToInt(it -> it).sum();
//    		long rigthVal = rightList.stream().mapToInt(it -> it).sum();
//    		
//    		if(leftVal == rigthVal)
//    			return "YES";
//    	}
//
//    	return "NO";
//    }

}
