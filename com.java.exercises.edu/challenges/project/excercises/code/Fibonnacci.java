package project.excercises.code;

public class Fibonnacci {

	/* n = n-1 + n-2 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFibonacciNumber(4));
		printFibonnaci(4);
	}
	
	static int getFibonacciNumber(int n) {
		if(n < 1) {
			throw new RuntimeException("");
		} else if(n == 1 || n == 2) {
			return n -1;
		} else {
			return getFibonacciNumber(n-1) + getFibonacciNumber(n - 2);
		}
	}
	
	static void printFibonnaci(int n) {
	
		for(int i =1; i<= n ; i++){
			System.out.print(getFibonacciNumber(i) + ",");
		}
	
	}

}
