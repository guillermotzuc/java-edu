package com.design.patterns.java.behavioral.visitor.d1;

public abstract class Expression {

	public abstract void accept(ExpressionVisitor visitor);

}
