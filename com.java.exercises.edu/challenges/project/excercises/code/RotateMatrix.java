package project.excercises.code;

public class RotateMatrix {

	public static void main(String[] args) {

		/*
		 * 9,10,11,12
		 * 16,17,18,19
		 * 23,24,25,26
		 */
		int[][] matrix = {
				{ 9,  10, 11, 12 },
				{ 16, 17, 18, 19 },
				{ 23, 24, 25, 26 },
				{ 30, 31, 32, 33 },
		};
		
		rotate(matrix);
	}

	public static void rotate(int[][] matrix) {
		
		int n= matrix.length;
		if(n <= 1) {
			return;
		}
		
		/* layers */
		for(int i=0; i< n; i++) {
			
			/* Elements */
			for(int j=i; j<n-i-1; j++) {
				
				//swap elements in the clockwise direction
				//temp = top-left
				int temp = matrix[i][j];
				
				//top-left <- bottom-left
				matrix[i][j] = matrix[n-1-j][i];
				
				//bottom-left <- botton-rigth
				matrix[n-1-j][i] = matrix[n - 1-i][n-1-j];
				
				//bottom-right <- top-right
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				
				//top-right <- top-left
				matrix[j][n-1-i] = temp;
			}
		}
	}
	
}
