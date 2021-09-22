package testcodes.towarmup.recursion;

public class Sample01 {

	public static void main(String[] args) {
		recursion(3);
	}
	
	static void recursion(int n) {
		if(n< 1){
			return;
		}else {
			recursion(n-1);
		}
		
		System.out.println("Hello " + n);
		
	}

}
