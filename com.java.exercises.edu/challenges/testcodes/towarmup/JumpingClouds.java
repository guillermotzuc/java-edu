package testcodes.towarmup;

import java.util.function.Predicate;

public class JumpingClouds {

	public static void main(String[] args) {

		System.out.println(jumpingOnClouds(new int[]{ 
				//0,0,0,0,1,0
				0,0,0,1,0,0
		}));
	}

    static int jumpingOnClouds(int[] c) {
    	
    	Predicate<Integer> isThunder = (n) -> n != 1;
    	int countJumps = 0;
    	int index = 0;
    	do {

    		if((index + 2) <= c.length -1 && isThunder.test(c[index + 2])) {
    			index = index + 2;
    			countJumps++;
    		}else {
    			index++;
    			countJumps++;
    		}
    		
    		
    	} while (index != (c.length - 1));

    	return countJumps;
    }
}
