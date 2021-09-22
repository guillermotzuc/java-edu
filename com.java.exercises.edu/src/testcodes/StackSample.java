package testcodes;

import java.util.Stack;

public class StackSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop()); 
		System.out.println(stack.pop());
	}

}
