package testcodes.iterview.problems;

public class CountNegativesNumber {

	public static void main(String[] args) {

		int[][] array = {
					 {-4 ,-3, -1, 1},
					 {-2, -2, 1, 2},
					 {-1,1,2,3},
					 {1,2,4,5 }
				 };
		System.out.println(countNegatives(array));
	}

	static int countNegatives(int[][] givenArray) {
		
		int count = 0;
		int row_i=0;
		int col_i=givenArray[0].length - 1;
		
		while(col_i >=0 && row_i < givenArray.length) {
			
			if(givenArray[row_i][col_i] < 0) {
				count+= (col_i + 1);
				row_i++;
			} else {
				col_i--;
			}
		}
		
		return count;
	}
}
