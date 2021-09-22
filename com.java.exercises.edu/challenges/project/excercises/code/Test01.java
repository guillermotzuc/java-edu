package project.excercises.code;

public class Test01 {

	public static void main(String... args) {
		
		int factorial = 5;
		System.out.println("Print factorial:" + factorial);
		
		/* The factorial is given for n * n-1 while n > 0 */
		/* 5 x 4 x 3 x 2 x 1 = */
		System.out.println(factorial(factorial));
	}
	
	public static int factorial(int n) {
		
		if(n <= 1)
			return 1;
		
		return n * factorial(n-1);
	}
	
	/**
	 * 120  
	 */
}
