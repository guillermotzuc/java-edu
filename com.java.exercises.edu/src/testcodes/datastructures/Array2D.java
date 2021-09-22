package testcodes.datastructures;

public class Array2D {

	public static void main(String[] args) {

		Integer[] array = { 1,4,3,2 };
		printInverseArray(array);
	}
	
	static void printInverseArray(Integer[] array) {
		
		Integer[] result = new Integer[array.length];
		for(int i = array.length -1, b = 0; i>=0; i--, b++) {
			if(i != array.length -1)
				System.out.print(" ");
			
			result[b] = array[i];
			System.out.print(result[b]);
		}
	}

}
