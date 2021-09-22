package com.design.patterns.java.behavioral.strategy.exercise;

public class RealDiscriminantStrategy implements DiscriminantStrategy {

	@Override
	public double calculateDiscriminant(double a, double b, double c)
	{
		double result = b*b-4*a*c;
		return result >= 0 ? result : Double.NaN;
	}
}
