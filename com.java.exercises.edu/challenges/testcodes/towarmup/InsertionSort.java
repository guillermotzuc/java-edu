package testcodes.towarmup;

import java.util.stream.IntStream;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		insertionSort(new int[] {1, 1, 1, 2, 2});
		insertionSort(new int[] {2, 1, 3, 1, 2});
		
		int[] array = new int[] {2, 1, 3, 1, 2};
		insertionSort2(array);
		IntStream.of(array).boxed().forEach(System.out::println);
	}

	static int insertionSort(int [] array) {
		 int shifts = 0;
		 for(int  i = 1 ; i<array.length;i++) {  
			 int  tmp= array[i], j=i;
		     while ( j>0 && array[j-1]>tmp ) {	
		    	 array[j]=array[j-1];
		    	 shifts++;
		        j--;
		     }
		     array[j] = tmp;
		 }//end of for loop
		 
		 return shifts;
	}//end of method
	
	static void insertionSort2(int[] array) {
		
		for(int i = 1; i< array.length; i++) {
			
			int tmp= array[i], j=i;
			while(j>0 && array[j-1]>tmp) {
				
				array[j] = array[j-1];
				j--;
			}
			
			array[j] = tmp;
			
		}
	}
}
