package testcodes;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPrime(2001));
	}
	
	public static boolean isPrime(int n) {  
		if (n <= 1) {  
			return false;  
		}  
		System.out.println("sqrt: " +  Math.sqrt(n));
		for (int i = 2; i < Math.sqrt(n); i++) {  
			if (n % i == 0) {  
				return false;  
			}  
		}  
		return true;  
	}  

}
