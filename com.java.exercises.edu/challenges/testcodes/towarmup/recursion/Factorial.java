package testcodes.towarmup.recursion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factiorial(5));
	}
	
	static int factiorial(int n) {
		if(n == 0){
			return 1;
		} else {
			return (n * factiorial(--n));
		}
	}

}
