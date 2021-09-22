package project.excercises.code;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = {1,2,3,4,5,6,7,8 };
		int end = array.length -1;
		int start = 0;
		int target = 7;
		System.out.println(binarySearch(array, start, end, target));
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
