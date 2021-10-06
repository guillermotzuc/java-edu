package designpatterns.decorator;

public class Expresso implements Beverage {

	@Override
	public double cost() {

		return 1.90;
	}

	@Override
	public String description() {

		return "Expreso";
	}

}
