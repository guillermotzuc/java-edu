package testcodes.towarmup;

import java.util.Arrays;

public class TheHurdleRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//hurdleRace(4, new int[] {1, 6, 3, 5, 2 });
		System.out.println(hurdleRace(4, new int[] {1, 6, 3, 5, 2 }));
	}
	
    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {

    	Arrays.sort(height);
    	int val = height[height.length - 1] - k;
    	return val>= 0 ? val : 0;
    }

}
