package project.excercises.code;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RotateMatrixTest {

	@Test
	public void rotate5x5() {
		
		int[][] matrix = {
				{ 1,  2,  3,  4,  5 },
				{ 6,  7,  8,  9,  10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 }
		};
		
		RotateMatrix.rotate(matrix);
		assertArrayEquals(new int[] { 21,16,11,6,1}, matrix[0]);
		assertArrayEquals(new int[] { 22,17,12,7,2}, matrix[1]);

	}
}
