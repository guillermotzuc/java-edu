package testcodes.towarmup.nooprators;

public class AddWithoutArithmeticOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(addNumber(25, 30));
		System.out.println(subtractNumber(25, 10));
	}

	static int addNumber(int a, int b)
	{
		while(b != 0)
		{
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
	
	static int subtractNumber(int i, int j) 
	{ 
		while(j != 0) 
		{ 
			int carry = (~i) & j; 
			i = i ^ j; 
			j = carry << 1; 
		}
		return i;
	}

	static int multiplyNumber(int a, int b) 
	{    
		// 0 multiplied with 0 is 0
		if(b == 0) 
			return 0;
		// adding variable a one by one
		if(b > 0) 
			return (a + multiplyNumber(a, b - 1));
		// here's the case where b is negative
		if(b < 0) 
			return -multiplyNumber(a, -b);
		return -1;
	}
	
	/* --------------------------- */

	static int addNumber2(int a, int b) {

		while(b !=0 ) {
			
			int carry = a & b;
			a = a  ^ b;
			b = carry << 1;
		}
		
		return a;
	}

}
