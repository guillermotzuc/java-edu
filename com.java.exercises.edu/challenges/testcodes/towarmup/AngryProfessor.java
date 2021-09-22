package testcodes.towarmup;

import java.util.Arrays;

public class AngryProfessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(angryProfessor(2, new int[] {0, -1, 2, 1}));
		System.out.println(angryProfessor(3, new int[] {-1, -3, 4, 2 }));
	}

	// Complete the angryProfessor function below.
	static String angryProfessor(int k, int[] a) {

		Arrays.sort(a);
		int count = 0;
		for(int i = 0; i < a.length; i++) {

			if(a[i] <= 0)
				count++;
			
			if(count >= k){
				return "NO";
			}
			
			if(a[i] >= 1 && a[i + 1] >= 1)
				break;
		}
		
		return "YES";
	}

}
