package com.design.patterns.java.behavioral.visitor.d1;

public class ClassicVisitorDemo {

	public static void main(String[] args)
	{
		// 1+(2+3)
		AdditionExpression e = new AdditionExpression(
				new DoubleExpression(1),
				new AdditionExpression(
						new DoubleExpression(2),
						new DoubleExpression(3)
						));
		ExpressionPrinter ep = new ExpressionPrinter();
		ep.visit(e);
		System.out.println(ep);

		ExpressionCalculator calc = new ExpressionCalculator();
		calc.visit(e);
		System.out.println(ep + " = " + calc.result);
	}
}
