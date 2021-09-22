package testcodes.iterview.problems;

public class SecondLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,3,4,5,0,2};
		System.out.println(getTheSecondLargestNumber(array));
	}

	static int getTheSecondLargestNumber(int[] array) {
		
		int firstBiggerNumber = 0;
		int secondBiggerNumber = 0;
		
		for(int i=0; i< array.length; i++) {
			
			if(array[i] > firstBiggerNumber) {
				secondBiggerNumber = firstBiggerNumber;
				firstBiggerNumber = array[i];
			}
		}
		
		return secondBiggerNumber;
	}
}
