package com.design.patterns.java.behavioral.visitor.d1;

public interface ExpressionVisitor {

	void visit(DoubleExpression e);
	void visit(AdditionExpression e);
}
