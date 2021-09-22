package testcodes;

public class StaticIssue {

	static {
		
		Integer foo = null;
		System.out.println(foo.intValue());
	}
	
	public static void printHello() {
		
		boolean ss = !true;
		System.out.println("");
	}
}
