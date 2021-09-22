package testcodes.towarmup;

public class SherlockTheBeast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x =0;
		int y =0;
		int n = 11;
		StringBuilder builder = new StringBuilder();
		for(int i = 1;i <= n; i++) {
			
			y = i;
			x = y - 1;
			
			if(((x % 3) + (y %5) - 2) == n) {
				
				if((x % 3) == 0) {
					
					for(int j=0;j<x; j++)
						builder.append("5");
					
				}
				
				if((y % 5) == 0) {
					
					for(int j=0;j<5; j++)
						builder.append("3");
					
				}
				
				break;
			}
				
			
//			if((x % 3) + (y % 5) == n) {
//			
//				System.out.println(x);
//				System.out.println(y);
//			}
			
			

		}
		
		System.out.println(builder);
	}

}
