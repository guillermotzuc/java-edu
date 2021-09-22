package testcodes.arrays.multidimentional;

public class Multi2DArray {

	public static void main(String[] args) {
		//12345
		//98451
		//
		int[][] arr = new int[5][5];
		int[][] array2d = { {1,2,3,4,5}, 
							{9,8,4,3,7}, 
							{9,8,4,3,7}
						  };
		System.out.println(array2d[2][0]);
		
		for ( int i = 0; i < array2d.length; i++) {
			for (int j = 0; j < array2d[0].length; j ++) {
				System.out.print(array2d[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
