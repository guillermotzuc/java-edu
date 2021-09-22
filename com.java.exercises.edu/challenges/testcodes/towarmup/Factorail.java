package testcodes.towarmup;

public class Factorail {

	public static void main(String[] args) {

		System.out.println(factorail(7));
		System.out.println(factorialWithIt(7));
	}
	
	/*
	 * 3 * (2 * (1*1)) = 6
	 */
	public static int factorail(int n) {
		
		if(n == 0)
			return 1;
		
		return (n * factorail(--n));
		
	}
	
	public static int factorialWithIt(int n) {
		
		int result = n;
		for(int i = n - 1; i >= 1; --i) {
			
			result = result * (i);
			n--;
		}
		
		return result;
	}

}
